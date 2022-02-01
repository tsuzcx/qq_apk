package com.tencent.mobileqq.kandian.base.report;

import android.app.ActivityManager;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ReadInJoyMMapKvStorage
{
  public static final String NAME_DEFAULT = "global";
  private static final String TAG = "kandianreport.ReadInJoyMMapKvStorage";
  private static Map<String, ReadInJoyMMapKvStorage> mMapHelperMap = new ConcurrentHashMap();
  private static String mmkvRootPath;
  private Map<String, String> dataMap = new HashMap();
  private int expiredTime = 0;
  private int mMMapCurrentSize = 0;
  private MappedByteBuffer mMMapDataBuffer;
  private int mMMapFileSize = 0;
  private String mMMapFilepath;
  private int mMMapMaxSize = 16777216;
  private RandomAccessFile mMMapMemoryMappedFile = null;
  private int mMMapMinSize = 4096;
  private String mMMapName = "";
  private int mNumberOfKeysWithDuplicated = 0;
  
  private ReadInJoyMMapKvStorage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(mmkvRootPath);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    this.mMMapFilepath = localStringBuilder.toString();
    this.mMMapName = paramString;
    init();
  }
  
  private boolean ensureMemorySize(int paramInt)
  {
    this.mMMapCurrentSize = sizeAfterRemoveDuplicatedKeys();
    return this.mMMapCurrentSize + paramInt <= this.mMMapFileSize;
  }
  
  /* Error */
  private boolean expandMMapFile()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 44	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFileSize	I
    //   11: iconst_2
    //   12: imul
    //   13: aload_0
    //   14: getfield 62	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapMaxSize	I
    //   17: if_icmple +42 -> 59
    //   20: ldc 11
    //   22: iconst_1
    //   23: ldc 98
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 44	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFileSize	I
    //   35: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: getfield 62	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapMaxSize	I
    //   45: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: invokestatic 110	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: monitorexit
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 44	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFileSize	I
    //   64: iconst_2
    //   65: imul
    //   66: putfield 44	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFileSize	I
    //   69: new 118	java/io/RandomAccessFile
    //   72: dup
    //   73: aload_0
    //   74: getfield 83	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFilepath	Ljava/lang/String;
    //   77: ldc 120
    //   79: invokespecial 123	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: astore_2
    //   83: aload_0
    //   84: getfield 50	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapMemoryMappedFile	Ljava/io/RandomAccessFile;
    //   87: invokevirtual 127	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   90: getstatic 133	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   93: lconst_0
    //   94: aload_0
    //   95: getfield 44	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFileSize	I
    //   98: i2l
    //   99: invokevirtual 139	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   102: astore_3
    //   103: aload_3
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 50	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapMemoryMappedFile	Ljava/io/RandomAccessFile;
    //   109: astore 4
    //   111: aload_3
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 141	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapDataBuffer	Ljava/nio/MappedByteBuffer;
    //   117: astore 5
    //   119: aload_3
    //   120: astore_1
    //   121: aload_0
    //   122: aload_2
    //   123: putfield 50	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapMemoryMappedFile	Ljava/io/RandomAccessFile;
    //   126: aload_3
    //   127: astore_1
    //   128: aload_0
    //   129: aload_3
    //   130: putfield 141	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapDataBuffer	Ljava/nio/MappedByteBuffer;
    //   133: aload_3
    //   134: astore_1
    //   135: aload_0
    //   136: getfield 141	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapDataBuffer	Ljava/nio/MappedByteBuffer;
    //   139: aload_0
    //   140: getfield 46	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapCurrentSize	I
    //   143: invokevirtual 147	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   146: pop
    //   147: aload_3
    //   148: astore_1
    //   149: aload_0
    //   150: aload 4
    //   152: invokespecial 151	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:releaseMMapFile	(Ljava/io/RandomAccessFile;)V
    //   155: aload_3
    //   156: astore_1
    //   157: aload_0
    //   158: aload 5
    //   160: invokespecial 155	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:releaseMMapMemory	(Ljava/nio/MappedByteBuffer;)V
    //   163: aload_0
    //   164: monitorexit
    //   165: iconst_1
    //   166: ireturn
    //   167: astore_3
    //   168: goto +13 -> 181
    //   171: astore_1
    //   172: goto +162 -> 334
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_1
    //   178: aload 4
    //   180: astore_2
    //   181: new 68	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   188: astore 4
    //   190: aload 4
    //   192: aload_3
    //   193: invokevirtual 159	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   196: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 4
    //   202: ldc 64
    //   204: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: ldc 11
    //   210: iconst_1
    //   211: aload 4
    //   213: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: aload_2
    //   221: invokespecial 151	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:releaseMMapFile	(Ljava/io/RandomAccessFile;)V
    //   224: aload_0
    //   225: aload_1
    //   226: invokespecial 155	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:releaseMMapMemory	(Ljava/nio/MappedByteBuffer;)V
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 44	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFileSize	I
    //   234: iconst_2
    //   235: idiv
    //   236: putfield 44	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFileSize	I
    //   239: aload_0
    //   240: new 118	java/io/RandomAccessFile
    //   243: dup
    //   244: aload_0
    //   245: getfield 83	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFilepath	Ljava/lang/String;
    //   248: ldc 120
    //   250: invokespecial 123	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: putfield 50	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapMemoryMappedFile	Ljava/io/RandomAccessFile;
    //   256: aload_0
    //   257: aload_0
    //   258: getfield 50	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapMemoryMappedFile	Ljava/io/RandomAccessFile;
    //   261: invokevirtual 127	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   264: getstatic 133	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   267: lconst_0
    //   268: aload_0
    //   269: getfield 44	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapFileSize	I
    //   272: i2l
    //   273: invokevirtual 139	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   276: putfield 141	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapDataBuffer	Ljava/nio/MappedByteBuffer;
    //   279: aload_0
    //   280: getfield 141	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapDataBuffer	Ljava/nio/MappedByteBuffer;
    //   283: aload_0
    //   284: getfield 46	com/tencent/mobileqq/kandian/base/report/ReadInJoyMMapKvStorage:mMMapCurrentSize	I
    //   287: invokevirtual 147	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   290: pop
    //   291: aload_0
    //   292: monitorexit
    //   293: iconst_0
    //   294: ireturn
    //   295: astore_1
    //   296: new 68	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   303: astore_2
    //   304: aload_2
    //   305: aload_1
    //   306: invokevirtual 159	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   309: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload_2
    //   314: ldc 64
    //   316: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc 11
    //   322: iconst_1
    //   323: aload_2
    //   324: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: aload_0
    //   331: monitorexit
    //   332: iconst_0
    //   333: ireturn
    //   334: aload_0
    //   335: monitorexit
    //   336: aload_1
    //   337: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	ReadInJoyMMapKvStorage
    //   6	151	1	localObject1	Object
    //   171	1	1	localObject2	Object
    //   177	49	1	localMappedByteBuffer1	MappedByteBuffer
    //   295	42	1	localThrowable1	Throwable
    //   82	242	2	localObject3	Object
    //   102	54	3	localMappedByteBuffer2	MappedByteBuffer
    //   167	1	3	localThrowable2	Throwable
    //   175	18	3	localThrowable3	Throwable
    //   3	209	4	localObject4	Object
    //   117	42	5	localMappedByteBuffer3	MappedByteBuffer
    // Exception table:
    //   from	to	target	type
    //   83	103	167	java/lang/Throwable
    //   105	111	167	java/lang/Throwable
    //   113	119	167	java/lang/Throwable
    //   121	126	167	java/lang/Throwable
    //   128	133	167	java/lang/Throwable
    //   135	147	167	java/lang/Throwable
    //   149	155	167	java/lang/Throwable
    //   157	163	167	java/lang/Throwable
    //   7	55	171	finally
    //   59	83	171	finally
    //   83	103	171	finally
    //   105	111	171	finally
    //   113	119	171	finally
    //   121	126	171	finally
    //   128	133	171	finally
    //   135	147	171	finally
    //   149	155	171	finally
    //   157	163	171	finally
    //   181	239	171	finally
    //   239	291	171	finally
    //   296	330	171	finally
    //   7	55	175	java/lang/Throwable
    //   59	83	175	java/lang/Throwable
    //   239	291	295	java/lang/Throwable
  }
  
  public static ReadInJoyMMapKvStorage getInstance()
  {
    return getInstance("global");
  }
  
  public static ReadInJoyMMapKvStorage getInstance(String paramString)
  {
    if (mMapHelperMap.containsKey(paramString)) {
      return (ReadInJoyMMapKvStorage)mMapHelperMap.get(paramString);
    }
    if (mmkvRootPath == null) {
      resetRootPath();
    }
    try
    {
      if (mMapHelperMap.containsKey(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("contains key: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("kandianreport.ReadInJoyMMapKvStorage", 2, ((StringBuilder)localObject).toString());
        paramString = (ReadInJoyMMapKvStorage)mMapHelperMap.get(paramString);
        return paramString;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create key: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("kandianreport.ReadInJoyMMapKvStorage", 2, ((StringBuilder)localObject).toString());
      localObject = new ReadInJoyMMapKvStorage(paramString);
      mMapHelperMap.put(paramString, localObject);
      return localObject;
    }
    finally {}
  }
  
  private void init()
  {
    try
    {
      Object localObject1 = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
      if ((localObject1 != null) && (((ActivityManager)localObject1).getMemoryClass() * 1024 * 1024 / 10 > this.mMMapMaxSize)) {
        this.mMMapMaxSize = (((ActivityManager)localObject1).getMemoryClass() * 1024 * 1024 / 10);
      }
      this.mMMapFileSize = readMMapSize();
      if (this.mMMapFileSize == 0) {
        this.mMMapFileSize = this.mMMapMinSize;
      }
      if (!FileUtils.e(this.mMMapFilepath)) {
        FileUtils.a(this.mMMapFilepath);
      }
      this.mMMapMemoryMappedFile = new RandomAccessFile(this.mMMapFilepath, "rw");
      this.mMMapDataBuffer = this.mMMapMemoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, this.mMMapFileSize);
      this.mMMapDataBuffer.rewind();
      int j = this.mMMapDataBuffer.getInt();
      this.mNumberOfKeysWithDuplicated = j;
      this.mMMapCurrentSize += 4;
      int i = 0;
      Object localObject2;
      while (i < j)
      {
        int k = this.mMMapDataBuffer.getInt();
        this.mMMapCurrentSize += 4;
        localObject1 = new byte[k];
        this.mMMapDataBuffer.get((byte[])localObject1);
        this.mMMapCurrentSize += k;
        localObject2 = new String((byte[])localObject1);
        k = this.mMMapDataBuffer.getInt();
        this.mMMapCurrentSize += 4;
        localObject1 = null;
        if (k != 0)
        {
          localObject1 = new byte[k];
          this.mMMapDataBuffer.get((byte[])localObject1);
          localObject1 = new String((byte[])localObject1);
          this.mMMapCurrentSize += k;
        }
        this.dataMap.put(localObject2, localObject1);
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localThrowable.getStackTrace());
      ((StringBuilder)localObject2).append("");
      QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, ((StringBuilder)localObject2).toString());
      if (!ensureMemorySize(0)) {
        expandMMapFile();
      }
    }
  }
  
  private int readMMapSize()
  {
    return (int)new File(this.mMMapFilepath).length();
  }
  
  private void releaseMMapFile(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile != null) {
      try
      {
        paramRandomAccessFile.close();
        paramRandomAccessFile.getChannel().close();
        return;
      }
      catch (IOException paramRandomAccessFile)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramRandomAccessFile.getStackTrace());
        localStringBuilder.append("");
        QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, localStringBuilder.toString());
      }
    }
  }
  
  private void releaseMMapMemory(MappedByteBuffer paramMappedByteBuffer)
  {
    if (paramMappedByteBuffer != null) {
      paramMappedByteBuffer.clear();
    }
  }
  
  public static void resetRootPath()
  {
    String str3 = "default";
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.a();
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        localStringBuilder.append("/tencent/MobileQQ/rijmmkv/");
        if (localAppRuntime != null)
        {
          String str1 = localAppRuntime.getAccount();
          localStringBuilder.append(str1);
          mmkvRootPath = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("kandianreport.ReadInJoyMMapKvStorage", 1, localThrowable.getMessage());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getParent());
        localStringBuilder.append("/tencent/MobileQQ/rijmmkv/");
        str2 = str3;
        if (localAppRuntime != null) {
          str2 = localAppRuntime.getAccount();
        }
        localStringBuilder.append(str2);
        mmkvRootPath = localStringBuilder.toString();
        return;
      }
      String str2 = "default";
    }
  }
  
  private int sizeAfterRemoveDuplicatedKeys()
  {
    Object localObject = this.mMMapDataBuffer;
    if (localObject != null)
    {
      ((MappedByteBuffer)localObject).clear();
      this.mMMapDataBuffer.rewind();
      this.mMMapDataBuffer.putInt(this.dataMap.size());
      int i = 4;
      localObject = this.dataMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        this.mMMapDataBuffer.putInt(((String)localEntry.getKey()).getBytes().length);
        this.mMMapDataBuffer.put(((String)localEntry.getKey()).getBytes());
        if (localEntry.getValue() != null)
        {
          this.mMMapDataBuffer.putInt(((String)localEntry.getValue()).getBytes().length);
          this.mMMapDataBuffer.put(((String)localEntry.getValue()).getBytes());
        }
        else
        {
          this.mMMapDataBuffer.putInt(0);
        }
        int k = ((String)localEntry.getKey()).getBytes().length;
        int j;
        if (localEntry.getValue() != null) {
          j = ((String)localEntry.getValue()).getBytes().length;
        } else {
          j = 0;
        }
        i += k + 8 + j;
      }
      this.mNumberOfKeysWithDuplicated = this.dataMap.size();
      return i;
    }
    return 0;
  }
  
  public int getExpiredTime()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandianreport_mmkv_expired_");
    localStringBuilder.append(this.mMMapName);
    this.expiredTime = ((Integer)RIJSPUtils.a(localStringBuilder.toString(), Integer.valueOf(0))).intValue();
    return this.expiredTime;
  }
  
  public String getValeForKey(String paramString)
  {
    try
    {
      if (this.dataMap.containsKey(paramString))
      {
        paramString = (String)this.dataMap.get(paramString);
        return paramString;
      }
      return null;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void invalidate()
  {
    try
    {
      if (this.mMMapDataBuffer != null) {
        this.mMMapDataBuffer.clear();
      }
      this.dataMap.clear();
      releaseMMapFile(this.mMMapMemoryMappedFile);
      this.mNumberOfKeysWithDuplicated = 0;
      this.mMMapCurrentSize = 0;
      if ((!TextUtils.isEmpty(this.mMMapFilepath)) && (FileUtils.e(this.mMMapFilepath))) {
        new File(this.mMMapFilepath).delete();
      }
      mMapHelperMap.remove(this.mMMapName);
      return;
    }
    finally {}
  }
  
  public void setExpiredTime(int paramInt)
  {
    try
    {
      this.expiredTime = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kandianreport_mmkv_expired_");
      localStringBuilder.append(this.mMMapName);
      RIJSPUtils.a(localStringBuilder.toString(), Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean update(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, "key is empty");
          return false;
        }
        int j = paramString1.getBytes().length;
        if (paramString2 != null)
        {
          i = paramString2.getBytes().length;
          i = j + 8 + i;
          if ((this.mMMapCurrentSize + i > this.mMMapFileSize) && (!ensureMemorySize(i)) && (!expandMMapFile()))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("expand map file error key ");
            localStringBuilder.append(paramString1);
            localStringBuilder.append(" value ");
            localStringBuilder.append(paramString2);
            QLog.e("kandianreport.ReadInJoyMMapKvStorage", 2, localStringBuilder.toString());
            return false;
          }
          try
          {
            this.mMMapDataBuffer.putInt(paramString1.getBytes().length);
            this.mMMapCurrentSize += 4;
            this.mMMapDataBuffer.put(paramString1.getBytes());
            this.mMMapCurrentSize += paramString1.getBytes().length;
            if (paramString2 != null)
            {
              this.mMMapDataBuffer.putInt(paramString2.getBytes().length);
              this.mMMapCurrentSize += 4;
              this.mMMapDataBuffer.put(paramString2.getBytes());
              this.mMMapCurrentSize += paramString2.getBytes().length;
            }
            else
            {
              this.mMMapDataBuffer.putInt(0);
              this.mMMapCurrentSize += 4;
            }
            this.mNumberOfKeysWithDuplicated += 1;
            this.mMMapDataBuffer.putInt(0, this.mNumberOfKeysWithDuplicated);
            this.dataMap.put(paramString1, paramString2);
            return true;
          }
          catch (Throwable paramString1)
          {
            paramString2 = new StringBuilder();
            paramString2.append(paramString1.getStackTrace());
            paramString2.append("");
            QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, paramString2.toString());
            return false;
          }
        }
        int i = 0;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage
 * JD-Core Version:    0.7.0.1
 */