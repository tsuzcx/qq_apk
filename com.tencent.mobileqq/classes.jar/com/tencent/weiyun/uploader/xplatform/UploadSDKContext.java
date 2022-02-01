package com.tencent.weiyun.uploader.xplatform;

import com.tencent.weiyun.uploader.module.XpConfig;
import com.tencent.weiyun.uploader.module.XpLog;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public final class UploadSDKContext
{
  private static final int LOG_LEVEL_DEBUG = 3;
  private static final int LOG_LEVEL_ERROR = 1;
  private static final int LOG_LEVEL_INFO = 2;
  private final UploadSDKContext.IUploadSDKCallback mCallback;
  
  public UploadSDKContext(UploadSDKContext.IUploadSDKCallback paramIUploadSDKCallback)
  {
    this.mCallback = paramIUploadSDKCallback;
  }
  
  static int getLogLevel()
  {
    int i = XpLog.getLogLevel();
    if (i <= 2) {
      return 3;
    }
    if (i == 3) {
      return 2;
    }
    if (i <= 5) {
      return 1;
    }
    return 0;
  }
  
  public int getApn()
  {
    return XpConfig.getIsp();
  }
  
  public void traceLogEx(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return;
    }
    try
    {
      paramArrayOfByte = new String(Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length), "UTF-8");
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      XpLog.e("traceLogEx convert String error", paramArrayOfByte);
      return;
    }
    XpLog.e(paramArrayOfByte);
    return;
    XpLog.d(paramArrayOfByte);
    return;
    XpLog.i(paramArrayOfByte);
  }
  
  public void uploadCancelled(String paramString)
  {
    this.mCallback.uploadCancelled(paramString);
  }
  
  public void uploadFinish(String paramString1, int paramInt, String paramString2)
  {
    this.mCallback.uploadFinish(paramString1, paramInt, paramString2);
  }
  
  public void uploadProgress(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.mCallback.uploadProgress(paramString, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.uploader.xplatform.UploadSDKContext
 * JD-Core Version:    0.7.0.1
 */