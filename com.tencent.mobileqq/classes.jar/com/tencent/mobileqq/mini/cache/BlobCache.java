package com.tencent.mobileqq.mini.cache;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.zip.Adler32;

public class BlobCache
  implements Closeable
{
  private static final int BH_CHECKSUM = 8;
  private static final int BH_KEY = 0;
  private static final int BH_LENGTH = 16;
  private static final int BH_OFFSET = 12;
  private static final int BLOB_HEADER_SIZE = 20;
  private static final int DATA_HEADER_SIZE = 4;
  private static final int IH_ACTIVE_BYTES = 20;
  private static final int IH_ACTIVE_ENTRIES = 16;
  private static final int IH_ACTIVE_REGION = 12;
  private static final int IH_CHECKSUM = 28;
  private static final int IH_MAGIC = 0;
  private static final int IH_MAX_BYTES = 8;
  private static final int IH_MAX_ENTRIES = 4;
  private static final int IH_VERSION = 24;
  private static final int INDEX_HEADER_SIZE = 32;
  private static final int MAGIC_DATA_FILE = -1121680112;
  private static final int MAGIC_INDEX_FILE = -1289277392;
  private static final String TAG = "BlobCache";
  private int mActiveBytes;
  private RandomAccessFile mActiveDataFile;
  private int mActiveEntries;
  private int mActiveHashStart;
  private int mActiveRegion;
  private Adler32 mAdler32 = new Adler32();
  private byte[] mBlobHeader = new byte[20];
  private RandomAccessFile mDataFile0;
  private RandomAccessFile mDataFile1;
  private int mFileOffset;
  private RandomAccessFile mInactiveDataFile;
  private int mInactiveHashStart;
  private MappedByteBuffer mIndexBuffer;
  private FileChannel mIndexChannel;
  private RandomAccessFile mIndexFile;
  private byte[] mIndexHeader = new byte[32];
  private BlobCache.LookupRequest mLookupRequest = new BlobCache.LookupRequest();
  private int mMaxBytes;
  private int mMaxEntries;
  private int mSlotOffset;
  private int mVersion;
  
  public BlobCache(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramString, paramInt1, paramInt2, paramBoolean, 0);
  }
  
  public BlobCache(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".idx");
    this.mIndexFile = new RandomAccessFile(localStringBuilder.toString(), "rw");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".0");
    this.mDataFile0 = new RandomAccessFile(localStringBuilder.toString(), "rw");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".1");
    this.mDataFile1 = new RandomAccessFile(localStringBuilder.toString(), "rw");
    this.mVersion = paramInt3;
    if ((!paramBoolean) && (loadIndex())) {
      return;
    }
    resetCache(paramInt1, paramInt2);
    if (loadIndex()) {
      return;
    }
    closeAll();
    throw new IOException("unable to load index");
  }
  
  private void clearHash(int paramInt)
  {
    byte[] arrayOfByte = new byte[1024];
    this.mIndexBuffer.position(paramInt);
    paramInt = this.mMaxEntries * 12;
    while (paramInt > 0)
    {
      int i = Math.min(paramInt, 1024);
      this.mIndexBuffer.put(arrayOfByte, 0, i);
      paramInt -= i;
    }
  }
  
  private void closeAll()
  {
    closeSilently(this.mIndexChannel);
    closeSilently(this.mIndexFile);
    closeSilently(this.mDataFile0);
    closeSilently(this.mDataFile1);
  }
  
  static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  private static void deleteFileSilently(String paramString)
  {
    try
    {
      new File(paramString).delete();
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static void deleteFiles(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".idx");
    deleteFileSilently(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".0");
    deleteFileSilently(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".1");
    deleteFileSilently(localStringBuilder.toString());
  }
  
  private void flipRegion()
  {
    this.mActiveRegion = (1 - this.mActiveRegion);
    this.mActiveEntries = 0;
    this.mActiveBytes = 4;
    writeInt(this.mIndexHeader, 12, this.mActiveRegion);
    writeInt(this.mIndexHeader, 16, this.mActiveEntries);
    writeInt(this.mIndexHeader, 20, this.mActiveBytes);
    updateIndexHeader();
    setActiveVariables();
    clearHash(this.mActiveHashStart);
    syncIndex();
  }
  
  /* Error */
  private boolean getBlob(RandomAccessFile paramRandomAccessFile, int paramInt, BlobCache.LookupRequest paramLookupRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	com/tencent/mobileqq/mini/cache/BlobCache:mBlobHeader	[B
    //   4: astore 10
    //   6: aload_1
    //   7: invokevirtual 212	java/io/RandomAccessFile:getFilePointer	()J
    //   10: lstore 6
    //   12: iload_2
    //   13: i2l
    //   14: lstore 8
    //   16: aload_1
    //   17: lload 8
    //   19: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   22: aload_1
    //   23: aload 10
    //   25: invokevirtual 220	java/io/RandomAccessFile:read	([B)I
    //   28: bipush 20
    //   30: if_icmpeq +19 -> 49
    //   33: ldc 39
    //   35: ldc 222
    //   37: invokestatic 228	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_1
    //   42: lload 6
    //   44: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   47: iconst_0
    //   48: ireturn
    //   49: aload 10
    //   51: iconst_0
    //   52: invokestatic 232	com/tencent/mobileqq/mini/cache/BlobCache:readLong	([BI)J
    //   55: lstore 8
    //   57: lload 8
    //   59: aload_3
    //   60: getfield 236	com/tencent/mobileqq/mini/cache/BlobCache$LookupRequest:key	J
    //   63: lcmp
    //   64: ifeq +43 -> 107
    //   67: new 91	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   74: astore_3
    //   75: aload_3
    //   76: ldc 238
    //   78: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: lload 8
    //   85: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: ldc 39
    //   91: aload_3
    //   92: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 228	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   98: pop
    //   99: aload_1
    //   100: lload 6
    //   102: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload 10
    //   109: bipush 8
    //   111: invokestatic 245	com/tencent/mobileqq/mini/cache/BlobCache:readInt	([BI)I
    //   114: istore 4
    //   116: aload 10
    //   118: bipush 12
    //   120: invokestatic 245	com/tencent/mobileqq/mini/cache/BlobCache:readInt	([BI)I
    //   123: istore 5
    //   125: iload 5
    //   127: iload_2
    //   128: if_icmpeq +43 -> 171
    //   131: new 91	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   138: astore_3
    //   139: aload_3
    //   140: ldc 247
    //   142: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_3
    //   147: iload 5
    //   149: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 39
    //   155: aload_3
    //   156: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 228	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   162: pop
    //   163: aload_1
    //   164: lload 6
    //   166: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   169: iconst_0
    //   170: ireturn
    //   171: aload 10
    //   173: bipush 16
    //   175: invokestatic 245	com/tencent/mobileqq/mini/cache/BlobCache:readInt	([BI)I
    //   178: istore 5
    //   180: iload 5
    //   182: iflt +151 -> 333
    //   185: iload 5
    //   187: aload_0
    //   188: getfield 252	com/tencent/mobileqq/mini/cache/BlobCache:mMaxBytes	I
    //   191: iload_2
    //   192: isub
    //   193: bipush 20
    //   195: isub
    //   196: if_icmple +6 -> 202
    //   199: goto +134 -> 333
    //   202: aload_3
    //   203: getfield 255	com/tencent/mobileqq/mini/cache/BlobCache$LookupRequest:buffer	[B
    //   206: ifnull +13 -> 219
    //   209: aload_3
    //   210: getfield 255	com/tencent/mobileqq/mini/cache/BlobCache$LookupRequest:buffer	[B
    //   213: arraylength
    //   214: iload 5
    //   216: if_icmpge +11 -> 227
    //   219: aload_3
    //   220: iload 5
    //   222: newarray byte
    //   224: putfield 255	com/tencent/mobileqq/mini/cache/BlobCache$LookupRequest:buffer	[B
    //   227: aload_3
    //   228: getfield 255	com/tencent/mobileqq/mini/cache/BlobCache$LookupRequest:buffer	[B
    //   231: astore 10
    //   233: aload_3
    //   234: iload 5
    //   236: putfield 258	com/tencent/mobileqq/mini/cache/BlobCache$LookupRequest:length	I
    //   239: aload_1
    //   240: aload 10
    //   242: iconst_0
    //   243: iload 5
    //   245: invokevirtual 261	java/io/RandomAccessFile:read	([BII)I
    //   248: iload 5
    //   250: if_icmpeq +20 -> 270
    //   253: ldc 39
    //   255: ldc_w 263
    //   258: invokestatic 228	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   261: pop
    //   262: aload_1
    //   263: lload 6
    //   265: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   268: iconst_0
    //   269: ireturn
    //   270: aload_0
    //   271: aload 10
    //   273: iconst_0
    //   274: iload 5
    //   276: invokevirtual 266	com/tencent/mobileqq/mini/cache/BlobCache:checkSum	([BII)I
    //   279: iload 4
    //   281: if_icmpeq +44 -> 325
    //   284: new 91	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   291: astore_3
    //   292: aload_3
    //   293: ldc_w 268
    //   296: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_3
    //   301: iload 4
    //   303: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: ldc 39
    //   309: aload_3
    //   310: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 228	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   316: pop
    //   317: aload_1
    //   318: lload 6
    //   320: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   323: iconst_0
    //   324: ireturn
    //   325: aload_1
    //   326: lload 6
    //   328: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   331: iconst_1
    //   332: ireturn
    //   333: new 91	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   340: astore_3
    //   341: aload_3
    //   342: ldc_w 270
    //   345: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_3
    //   350: iload 5
    //   352: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: ldc 39
    //   358: aload_3
    //   359: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 228	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   365: pop
    //   366: aload_1
    //   367: lload 6
    //   369: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   372: iconst_0
    //   373: ireturn
    //   374: astore_3
    //   375: goto +22 -> 397
    //   378: astore_3
    //   379: ldc 39
    //   381: ldc_w 272
    //   384: aload_3
    //   385: invokestatic 276	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   388: pop
    //   389: aload_1
    //   390: lload 6
    //   392: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   395: iconst_0
    //   396: ireturn
    //   397: aload_1
    //   398: lload 6
    //   400: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
    //   403: aload_3
    //   404: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	BlobCache
    //   0	405	1	paramRandomAccessFile	RandomAccessFile
    //   0	405	2	paramInt	int
    //   0	405	3	paramLookupRequest	BlobCache.LookupRequest
    //   114	188	4	i	int
    //   123	228	5	j	int
    //   10	389	6	l1	long
    //   14	70	8	l2	long
    //   4	268	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	41	374	finally
    //   49	99	374	finally
    //   107	125	374	finally
    //   131	163	374	finally
    //   171	180	374	finally
    //   185	199	374	finally
    //   202	219	374	finally
    //   219	227	374	finally
    //   227	262	374	finally
    //   270	317	374	finally
    //   333	366	374	finally
    //   379	389	374	finally
    //   16	41	378	java/lang/Throwable
    //   49	99	378	java/lang/Throwable
    //   107	125	378	java/lang/Throwable
    //   131	163	378	java/lang/Throwable
    //   171	180	378	java/lang/Throwable
    //   185	199	378	java/lang/Throwable
    //   202	219	378	java/lang/Throwable
    //   219	227	378	java/lang/Throwable
    //   227	262	378	java/lang/Throwable
    //   270	317	378	java/lang/Throwable
    //   333	366	378	java/lang/Throwable
  }
  
  private void insertInternal(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.mBlobHeader;
    int i = checkSum(paramArrayOfByte);
    writeLong(arrayOfByte, 0, paramLong);
    writeInt(arrayOfByte, 8, i);
    writeInt(arrayOfByte, 12, this.mActiveBytes);
    writeInt(arrayOfByte, 16, paramInt);
    this.mActiveDataFile.write(arrayOfByte);
    this.mActiveDataFile.write(paramArrayOfByte, 0, paramInt);
    this.mIndexBuffer.putLong(this.mSlotOffset, paramLong);
    this.mIndexBuffer.putInt(this.mSlotOffset + 8, this.mActiveBytes);
    this.mActiveBytes += paramInt + 20;
    writeInt(this.mIndexHeader, 20, this.mActiveBytes);
  }
  
  private boolean loadIndex()
  {
    try
    {
      this.mIndexFile.seek(0L);
      this.mDataFile0.seek(0L);
      this.mDataFile1.seek(0L);
      byte[] arrayOfByte = this.mIndexHeader;
      if (this.mIndexFile.read(arrayOfByte) != 32)
      {
        Log.w("BlobCache", "cannot read header");
        return false;
      }
      if (readInt(arrayOfByte, 0) != -1289277392)
      {
        Log.w("BlobCache", "cannot read header magic");
        return false;
      }
      if (readInt(arrayOfByte, 24) != this.mVersion)
      {
        Log.w("BlobCache", "version mismatch");
        return false;
      }
      this.mMaxEntries = readInt(arrayOfByte, 4);
      this.mMaxBytes = readInt(arrayOfByte, 8);
      this.mActiveRegion = readInt(arrayOfByte, 12);
      this.mActiveEntries = readInt(arrayOfByte, 16);
      this.mActiveBytes = readInt(arrayOfByte, 20);
      int i = readInt(arrayOfByte, 28);
      if (checkSum(arrayOfByte, 0, 28) != i)
      {
        Log.w("BlobCache", "header checksum does not match");
        return false;
      }
      if (this.mMaxEntries <= 0)
      {
        Log.w("BlobCache", "invalid max entries");
        return false;
      }
      if (this.mMaxBytes <= 0)
      {
        Log.w("BlobCache", "invalid max bytes");
        return false;
      }
      if ((this.mActiveRegion != 0) && (this.mActiveRegion != 1))
      {
        Log.w("BlobCache", "invalid active region");
        return false;
      }
      if ((this.mActiveEntries >= 0) && (this.mActiveEntries <= this.mMaxEntries))
      {
        if ((this.mActiveBytes >= 4) && (this.mActiveBytes <= this.mMaxBytes))
        {
          if (this.mIndexFile.length() != this.mMaxEntries * 12 * 2 + 32)
          {
            Log.w("BlobCache", "invalid index file length");
            return false;
          }
          arrayOfByte = new byte[4];
          i = this.mDataFile0.read(arrayOfByte);
          if (i != 4)
          {
            Log.w("BlobCache", "cannot read data file magic");
            return false;
          }
          i = readInt(arrayOfByte, 0);
          if (i != -1121680112)
          {
            Log.w("BlobCache", "invalid data file magic");
            return false;
          }
          if (this.mDataFile1.read(arrayOfByte) != 4)
          {
            Log.w("BlobCache", "cannot read data file magic");
            return false;
          }
          if (readInt(arrayOfByte, 0) != -1121680112)
          {
            Log.w("BlobCache", "invalid data file magic");
            return false;
          }
          this.mIndexChannel = this.mIndexFile.getChannel();
          this.mIndexBuffer = this.mIndexChannel.map(FileChannel.MapMode.READ_WRITE, 0L, this.mIndexFile.length());
          this.mIndexBuffer.order(ByteOrder.LITTLE_ENDIAN);
          setActiveVariables();
          return true;
        }
        Log.w("BlobCache", "invalid active bytes");
        return false;
      }
      Log.w("BlobCache", "invalid active entries");
      return false;
    }
    catch (IOException localIOException)
    {
      Log.e("BlobCache", "loadIndex failed.", localIOException);
    }
    return false;
  }
  
  private boolean lookupInternal(long paramLong, int paramInt)
  {
    int k = this.mMaxEntries;
    int j = (int)(paramLong % k);
    int i = j;
    if (j < 0) {
      i = j + k;
    }
    k = i;
    for (;;)
    {
      j = k * 12 + paramInt;
      long l = this.mIndexBuffer.getLong(j);
      int m = this.mIndexBuffer.getInt(j + 8);
      if (m == 0)
      {
        this.mSlotOffset = j;
        return false;
      }
      if (l == paramLong)
      {
        this.mSlotOffset = j;
        this.mFileOffset = m;
        return true;
      }
      k += 1;
      j = k;
      if (k >= this.mMaxEntries) {
        j = 0;
      }
      k = j;
      if (j == i)
      {
        Log.w("BlobCache", "corrupted index: clear the slot.");
        this.mIndexBuffer.putInt(j * 12 + paramInt + 8, 0);
        k = j;
      }
    }
  }
  
  static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static long readLong(byte[] paramArrayOfByte, int paramInt)
  {
    long l = paramArrayOfByte[(paramInt + 7)] & 0xFF;
    int i = 6;
    while (i >= 0)
    {
      l = l << 8 | paramArrayOfByte[(paramInt + i)] & 0xFF;
      i -= 1;
    }
    return l;
  }
  
  private void resetCache(int paramInt1, int paramInt2)
  {
    this.mIndexFile.setLength(0L);
    this.mIndexFile.setLength(paramInt1 * 12 * 2 + 32);
    this.mIndexFile.seek(0L);
    byte[] arrayOfByte = this.mIndexHeader;
    writeInt(arrayOfByte, 0, -1289277392);
    writeInt(arrayOfByte, 4, paramInt1);
    writeInt(arrayOfByte, 8, paramInt2);
    writeInt(arrayOfByte, 12, 0);
    writeInt(arrayOfByte, 16, 0);
    writeInt(arrayOfByte, 20, 4);
    writeInt(arrayOfByte, 24, this.mVersion);
    writeInt(arrayOfByte, 28, checkSum(arrayOfByte, 0, 28));
    this.mIndexFile.write(arrayOfByte);
    this.mDataFile0.setLength(0L);
    this.mDataFile1.setLength(0L);
    this.mDataFile0.seek(0L);
    this.mDataFile1.seek(0L);
    writeInt(arrayOfByte, 0, -1121680112);
    this.mDataFile0.write(arrayOfByte, 0, 4);
    this.mDataFile1.write(arrayOfByte, 0, 4);
  }
  
  private void setActiveVariables()
  {
    RandomAccessFile localRandomAccessFile;
    if (this.mActiveRegion == 0) {
      localRandomAccessFile = this.mDataFile0;
    } else {
      localRandomAccessFile = this.mDataFile1;
    }
    this.mActiveDataFile = localRandomAccessFile;
    if (this.mActiveRegion == 1) {
      localRandomAccessFile = this.mDataFile0;
    } else {
      localRandomAccessFile = this.mDataFile1;
    }
    this.mInactiveDataFile = localRandomAccessFile;
    this.mActiveDataFile.setLength(this.mActiveBytes);
    this.mActiveDataFile.seek(this.mActiveBytes);
    this.mActiveHashStart = 32;
    this.mInactiveHashStart = 32;
    if (this.mActiveRegion == 0)
    {
      this.mInactiveHashStart += this.mMaxEntries * 12;
      return;
    }
    this.mActiveHashStart += this.mMaxEntries * 12;
  }
  
  private void updateIndexHeader()
  {
    byte[] arrayOfByte = this.mIndexHeader;
    writeInt(arrayOfByte, 28, checkSum(arrayOfByte, 0, 28));
    this.mIndexBuffer.position(0);
    this.mIndexBuffer.put(this.mIndexHeader);
  }
  
  static void writeInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < 4)
    {
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(i & 0xFF));
      i >>= 8;
      paramInt2 += 1;
    }
  }
  
  static void writeLong(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    int i = 0;
    while (i < 8)
    {
      paramArrayOfByte[(paramInt + i)] = ((byte)(int)(0xFF & paramLong));
      paramLong >>= 8;
      i += 1;
    }
  }
  
  int checkSum(byte[] paramArrayOfByte)
  {
    this.mAdler32.reset();
    this.mAdler32.update(paramArrayOfByte);
    return (int)this.mAdler32.getValue();
  }
  
  int checkSum(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.mAdler32.reset();
    this.mAdler32.update(paramArrayOfByte, paramInt1, paramInt2);
    return (int)this.mAdler32.getValue();
  }
  
  public void close()
  {
    syncAll();
    closeAll();
  }
  
  int getActiveCount()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.mMaxEntries; j = k)
    {
      int m = this.mActiveHashStart + i * 12;
      this.mIndexBuffer.getLong(m);
      k = j;
      if (this.mIndexBuffer.getInt(m + 8) != 0) {
        k = j + 1;
      }
      i += 1;
    }
    if (j == this.mActiveEntries) {
      return j;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wrong active count: ");
    localStringBuilder.append(this.mActiveEntries);
    localStringBuilder.append(" vs ");
    localStringBuilder.append(j);
    Log.e("BlobCache", localStringBuilder.toString());
    return -1;
  }
  
  public void insert(long paramLong, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = this.mMaxBytes;
    if (i + 24 <= j)
    {
      if ((this.mActiveBytes + 20 + paramArrayOfByte.length > j) || (this.mActiveEntries * 2 >= this.mMaxEntries)) {
        flipRegion();
      }
      if (!lookupInternal(paramLong, this.mActiveHashStart))
      {
        this.mActiveEntries += 1;
        writeInt(this.mIndexHeader, 16, this.mActiveEntries);
      }
      insertInternal(paramLong, paramArrayOfByte, paramArrayOfByte.length);
      updateIndexHeader();
      return;
    }
    throw new RuntimeException("blob is too large!");
  }
  
  public boolean lookup(BlobCache.LookupRequest paramLookupRequest)
  {
    if ((lookupInternal(paramLookupRequest.key, this.mActiveHashStart)) && (getBlob(this.mActiveDataFile, this.mFileOffset, paramLookupRequest))) {
      return true;
    }
    int i = this.mSlotOffset;
    if ((lookupInternal(paramLookupRequest.key, this.mInactiveHashStart)) && (getBlob(this.mInactiveDataFile, this.mFileOffset, paramLookupRequest))) {
      if (this.mActiveBytes + 20 + paramLookupRequest.length <= this.mMaxBytes)
      {
        if (this.mActiveEntries * 2 >= this.mMaxEntries) {
          return true;
        }
        this.mSlotOffset = i;
      }
    }
    try
    {
      insertInternal(paramLookupRequest.key, paramLookupRequest.buffer, paramLookupRequest.length);
      this.mActiveEntries += 1;
      writeInt(this.mIndexHeader, 16, this.mActiveEntries);
      updateIndexHeader();
      return true;
    }
    catch (Throwable paramLookupRequest)
    {
      label153:
      break label153;
    }
    Log.e("BlobCache", "cannot copy over");
    return true;
    return false;
  }
  
  public byte[] lookup(long paramLong)
  {
    BlobCache.LookupRequest localLookupRequest = this.mLookupRequest;
    localLookupRequest.key = paramLong;
    byte[] arrayOfByte = null;
    localLookupRequest.buffer = null;
    if (lookup(localLookupRequest)) {
      arrayOfByte = this.mLookupRequest.buffer;
    }
    return arrayOfByte;
  }
  
  public void syncAll()
  {
    syncIndex();
    try
    {
      this.mDataFile0.getFD().sync();
    }
    catch (Throwable localThrowable1)
    {
      Log.w("BlobCache", "sync data file 0 failed", localThrowable1);
    }
    try
    {
      this.mDataFile1.getFD().sync();
      return;
    }
    catch (Throwable localThrowable2)
    {
      Log.w("BlobCache", "sync data file 1 failed", localThrowable2);
    }
  }
  
  public void syncIndex()
  {
    try
    {
      this.mIndexBuffer.force();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BlobCache", "sync index failed", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.BlobCache
 * JD-Core Version:    0.7.0.1
 */