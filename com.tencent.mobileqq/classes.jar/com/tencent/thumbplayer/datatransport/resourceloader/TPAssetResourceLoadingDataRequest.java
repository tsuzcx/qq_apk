package com.tencent.thumbplayer.datatransport.resourceloader;

import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPReadWriteLock;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TPAssetResourceLoadingDataRequest
  implements ITPAssetResourceLoadingDataRequest
{
  private static final boolean ENV_DEBUG = false;
  private static final int MAX_ASSET_READ_LEN = 1048576;
  private static final int MSG_RESPOND_WITH_DATA = 256;
  private static String TAG = "TPAssetResourceLoadingDataRequest";
  private long mCurrentOffset;
  private String mDataWritePath;
  private TPAssetResourceLoadingDataRequest.EventHandler mEventHandler;
  private TPReadWriteLock mLock;
  private RandomAccessFile mRandomAccessFile;
  private long mReadyDataTotalSize;
  private long mRealOffset;
  private int mRequestNum;
  private long mRequestedLength;
  private long mRequestedOffset;
  private boolean mRequestsAllDataToEndOfResource;
  
  public TPAssetResourceLoadingDataRequest(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.mRequestedOffset = paramLong1;
    this.mCurrentOffset = paramLong1;
    this.mRealOffset = paramLong1;
    this.mRequestedLength = paramLong2;
    this.mRequestsAllDataToEndOfResource = paramBoolean;
    this.mLock = new TPReadWriteLock();
  }
  
  private void internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Object localObject = this.mEventHandler;
    if (localObject != null)
    {
      localObject = ((TPAssetResourceLoadingDataRequest.EventHandler)localObject).obtainMessage();
      ((Message)localObject).what = paramInt1;
      ((Message)localObject).arg1 = paramInt2;
      ((Message)localObject).arg2 = paramInt3;
      ((Message)localObject).obj = paramObject;
      this.mEventHandler.sendMessage((Message)localObject);
    }
  }
  
  /* Error */
  private boolean writeDataToPath(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 108	java/io/RandomAccessFile
    //   4: dup
    //   5: aload 4
    //   7: ldc 110
    //   9: invokespecial 113	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: putfield 115	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   15: aload_0
    //   16: getfield 115	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   19: lload_1
    //   20: invokevirtual 119	java/io/RandomAccessFile:seek	(J)V
    //   23: aload_0
    //   24: getfield 115	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   27: aload_3
    //   28: invokevirtual 123	java/io/RandomAccessFile:write	([B)V
    //   31: iconst_1
    //   32: istore 5
    //   34: aload_0
    //   35: getfield 115	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +78 -> 118
    //   43: aload_3
    //   44: invokevirtual 126	java/io/RandomAccessFile:close	()V
    //   47: iconst_1
    //   48: ireturn
    //   49: getstatic 69	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:TAG	Ljava/lang/String;
    //   52: ldc 128
    //   54: invokestatic 133	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: ireturn
    //   59: astore_3
    //   60: goto +61 -> 121
    //   63: getstatic 69	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:TAG	Ljava/lang/String;
    //   66: ldc 135
    //   68: invokestatic 133	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield 115	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull +38 -> 115
    //   80: goto +20 -> 100
    //   83: getstatic 69	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:TAG	Ljava/lang/String;
    //   86: ldc 137
    //   88: invokestatic 133	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: getfield 115	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +18 -> 115
    //   100: aload_3
    //   101: invokevirtual 126	java/io/RandomAccessFile:close	()V
    //   104: goto +11 -> 115
    //   107: getstatic 69	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:TAG	Ljava/lang/String;
    //   110: ldc 128
    //   112: invokestatic 133	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: iconst_0
    //   116: istore 5
    //   118: iload 5
    //   120: ireturn
    //   121: aload_0
    //   122: getfield 115	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   125: astore 4
    //   127: aload 4
    //   129: ifnull +19 -> 148
    //   132: aload 4
    //   134: invokevirtual 126	java/io/RandomAccessFile:close	()V
    //   137: goto +11 -> 148
    //   140: getstatic 69	com/tencent/thumbplayer/datatransport/resourceloader/TPAssetResourceLoadingDataRequest:TAG	Ljava/lang/String;
    //   143: ldc 128
    //   145: invokestatic 133	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_3
    //   149: athrow
    //   150: astore_3
    //   151: goto -68 -> 83
    //   154: astore_3
    //   155: goto -92 -> 63
    //   158: astore_3
    //   159: goto -110 -> 49
    //   162: astore_3
    //   163: goto -56 -> 107
    //   166: astore 4
    //   168: goto -28 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	TPAssetResourceLoadingDataRequest
    //   0	171	1	paramLong	long
    //   0	171	3	paramArrayOfByte	byte[]
    //   0	171	4	paramString	String
    //   32	87	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	31	59	finally
    //   63	71	59	finally
    //   83	91	59	finally
    //   0	31	150	java/io/FileNotFoundException
    //   0	31	154	java/io/IOException
    //   43	47	158	java/io/IOException
    //   100	104	162	java/io/IOException
    //   132	137	166	java/io/IOException
  }
  
  public long getCurrentOffset()
  {
    this.mLock.readLock().lock();
    long l = this.mCurrentOffset;
    this.mLock.readLock().unlock();
    return l;
  }
  
  public int getDataReadyLength(long paramLong)
  {
    this.mLock.readLock().lock();
    long l = this.mRealOffset;
    this.mLock.readLock().unlock();
    if (paramLong >= l) {
      return -1;
    }
    if (paramLong < this.mRequestedOffset)
    {
      TPLogUtil.e(TAG, "Offset less than mRequestedOffset");
      return -1;
    }
    return (int)(l - paramLong);
  }
  
  public int getRequestNum()
  {
    return this.mRequestNum;
  }
  
  public long getRequestedLength()
  {
    return this.mRequestedLength;
  }
  
  public long getRequestedOffset()
  {
    return this.mRequestedOffset;
  }
  
  public void notifyDataReady(long paramLong1, long paramLong2)
  {
    paramLong2 += paramLong1;
    long l = this.mRequestedOffset;
    if (paramLong2 > this.mRequestedLength + l)
    {
      TPLogUtil.e(TAG, "data exceed the max request offset");
      return;
    }
    if (paramLong1 < l) {
      TPLogUtil.w(TAG, "the notify data offset is less than request offset");
    }
    if (paramLong2 < this.mCurrentOffset)
    {
      TPLogUtil.e(TAG, "data not reach current offset");
      return;
    }
    this.mLock.writeLock().lock();
    this.mCurrentOffset = paramLong2;
    this.mRealOffset = this.mCurrentOffset;
    this.mLock.writeLock().unlock();
  }
  
  public void release()
  {
    TPAssetResourceLoadingDataRequest.EventHandler localEventHandler = this.mEventHandler;
    if (localEventHandler != null)
    {
      localEventHandler.removeCallbacksAndMessages(null);
      this.mEventHandler = null;
    }
  }
  
  public void respondWithData(byte[] paramArrayOfByte)
  {
    if (this.mReadyDataTotalSize > this.mRequestedLength)
    {
      TPLogUtil.i(TAG, "respond full data");
      return;
    }
    int i = paramArrayOfByte.length;
    Object localObject = new TPAssetResourceLoadingDataRequest.DataWriteParams(null);
    ((TPAssetResourceLoadingDataRequest.DataWriteParams)localObject).writeOffset = this.mCurrentOffset;
    ((TPAssetResourceLoadingDataRequest.DataWriteParams)localObject).data = paramArrayOfByte;
    internalMessage(256, i, 0, localObject);
    paramArrayOfByte = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("respond data from:");
    ((StringBuilder)localObject).append(this.mCurrentOffset);
    ((StringBuilder)localObject).append(", dataLength:");
    ((StringBuilder)localObject).append(i);
    TPLogUtil.i(paramArrayOfByte, ((StringBuilder)localObject).toString());
    this.mLock.writeLock().lock();
    long l1 = this.mCurrentOffset;
    long l2 = i;
    this.mCurrentOffset = (l1 + l2);
    this.mReadyDataTotalSize += l2;
    this.mLock.writeLock().unlock();
  }
  
  public void setDataWritePath(String paramString)
  {
    this.mDataWritePath = paramString;
  }
  
  public void setDataWriteThreadLooper(Looper paramLooper)
  {
    this.mEventHandler = new TPAssetResourceLoadingDataRequest.EventHandler(this, paramLooper);
  }
  
  public void setRequestNum(int paramInt)
  {
    this.mRequestNum = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoadingDataRequest
 * JD-Core Version:    0.7.0.1
 */