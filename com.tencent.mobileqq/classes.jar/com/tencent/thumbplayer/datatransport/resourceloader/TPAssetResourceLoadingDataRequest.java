package com.tencent.thumbplayer.datatransport.resourceloader;

import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TPAssetResourceLoadingDataRequest
  implements ITPAssetResourceLoadingDataRequest
{
  private static final int MAX_ASSET_READ_LEN = 1048576;
  private static final int MSG_RESPOND_WITH_DATA = 256;
  private static String TAG = "TPAssetResourceLoadingDataRequest";
  private volatile long mCurrentOffset;
  private String mDataWritePath;
  private TPAssetResourceLoadingDataRequest.EventHandler mEventHandler;
  private RandomAccessFile mRandomAccessFile;
  private long mReadyDataTotalSize;
  private volatile long mRealOffset;
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
  }
  
  private void internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (this.mEventHandler != null)
    {
      Message localMessage = this.mEventHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.mEventHandler.sendMessage(localMessage);
    }
  }
  
  private boolean writeDataToPath(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        this.mRandomAccessFile = new RandomAccessFile(paramString, "rw");
        this.mRandomAccessFile.seek(paramLong);
        this.mRandomAccessFile.write(paramArrayOfByte);
        bool2 = true;
        bool1 = bool2;
      }
      catch (FileNotFoundException paramArrayOfByte)
      {
        boolean bool2;
        TPLogUtil.e(TAG, "file not found");
        if (this.mRandomAccessFile == null) {
          continue;
        }
        try
        {
          this.mRandomAccessFile.close();
          return false;
        }
        catch (IOException paramArrayOfByte)
        {
          TPLogUtil.e(TAG, "fail to close mRandomAccessFile");
          return false;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        TPLogUtil.e(TAG, "fail to write data");
        if (this.mRandomAccessFile == null) {
          continue;
        }
        try
        {
          this.mRandomAccessFile.close();
          return false;
        }
        catch (IOException paramArrayOfByte)
        {
          TPLogUtil.e(TAG, "fail to close mRandomAccessFile");
          return false;
        }
      }
      finally
      {
        if (this.mRandomAccessFile == null) {
          break label160;
        }
      }
      try
      {
        this.mRandomAccessFile.close();
        bool1 = bool2;
        return bool1;
      }
      catch (IOException paramArrayOfByte)
      {
        TPLogUtil.e(TAG, "fail to close mRandomAccessFile");
        return true;
      }
    }
    try
    {
      this.mRandomAccessFile.close();
      label160:
      throw paramArrayOfByte;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        TPLogUtil.e(TAG, "fail to close mRandomAccessFile");
      }
    }
  }
  
  public long getCurrentOffset()
  {
    return this.mCurrentOffset;
  }
  
  public int getDataReadyLength(long paramLong)
  {
    if (paramLong >= this.mRealOffset)
    {
      TPLogUtil.e(TAG, "No data for request");
      return -1;
    }
    if (paramLong < this.mRequestedOffset)
    {
      TPLogUtil.e(TAG, "Offset less than mRequestedOffset");
      return -1;
    }
    return (int)Math.min(1048576L, this.mRealOffset - paramLong);
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
    TPLogUtil.i(TAG, "notify data ready, mRealOffset: " + this.mRealOffset);
    if (paramLong1 + paramLong2 > this.mRequestedOffset + this.mRequestedLength)
    {
      TPLogUtil.e(TAG, "data exceed the max request offset");
      return;
    }
    if (paramLong1 < this.mRequestedOffset) {
      TPLogUtil.w(TAG, "the notify data offset is less than request offset");
    }
    if (paramLong1 + paramLong2 < this.mCurrentOffset)
    {
      TPLogUtil.e(TAG, "data not reach current offset");
      return;
    }
    this.mCurrentOffset = (paramLong1 + paramLong2);
    this.mRealOffset = this.mCurrentOffset;
  }
  
  public void respondWithData(byte[] paramArrayOfByte)
  {
    if (this.mReadyDataTotalSize > this.mRequestedLength)
    {
      TPLogUtil.i(TAG, "respond full data");
      return;
    }
    int i = paramArrayOfByte.length;
    TPAssetResourceLoadingDataRequest.DataWriteParams localDataWriteParams = new TPAssetResourceLoadingDataRequest.DataWriteParams(null);
    localDataWriteParams.writeOffset = this.mCurrentOffset;
    localDataWriteParams.data = paramArrayOfByte;
    internalMessage(256, i, 0, localDataWriteParams);
    TPLogUtil.i(TAG, "respond data from:" + this.mCurrentOffset + ", dataLength:" + i);
    this.mCurrentOffset += i;
    long l = this.mReadyDataTotalSize;
    this.mReadyDataTotalSize = (i + l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoadingDataRequest
 * JD-Core Version:    0.7.0.1
 */