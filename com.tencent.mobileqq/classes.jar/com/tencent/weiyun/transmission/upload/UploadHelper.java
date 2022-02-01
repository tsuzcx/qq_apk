package com.tencent.weiyun.transmission.upload;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.utils.ErrorCodeUtil;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.xplatform.UploadError;
import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;
import com.tencent.weiyun.utils.NetworkUtils;

public final class UploadHelper
{
  private static final long NETWORK_CHANGE_WAIT_TIME = 60000L;
  private static final String TAG = "UploadHelper";
  private static volatile int sCurrNetworkType = NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext());
  private static volatile long sNetworkChangeTime = SystemClock.elapsedRealtime();
  
  public static void acquireWakeLockIfNot()
  {
    WeiyunTransmissionGlobal.getInstance().acquireWakeLockIfNot();
  }
  
  public static String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag)
  {
    return UploadManager.getInstance().calSliceSha1(paramString, paramCanceledFlag);
  }
  
  public static String convertErrorMessage(int paramInt, String paramString)
  {
    Object localObject = paramString;
    if (paramInt != 0)
    {
      localObject = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        localObject = ErrorCodeUtil.getErrorMsg(paramInt);
        paramString = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramString = ErrorCodeUtil.getErrorMsg(1810014);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(")");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  private static boolean isNetworkChange()
  {
    long l = SystemClock.elapsedRealtime() - sNetworkChangeTime;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("change wait time = ");
    localStringBuilder.append(l);
    TsLog.d("UploadHelper", localStringBuilder.toString());
    if (60000L > l) {
      return true;
    }
    int i = NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext());
    return sCurrNetworkType != i;
  }
  
  public static int parseUploadResponse(UploadResponse paramUploadResponse)
  {
    if (paramUploadResponse == null) {
      return 1810024;
    }
    int j = paramUploadResponse.code();
    int i = j;
    if (UploadError.isCurlError(j))
    {
      i = j;
      if (isNetworkChange()) {
        i = 1810003;
      }
    }
    return i;
  }
  
  public static void releaseWakeLockIfExist()
  {
    WeiyunTransmissionGlobal.getInstance().releaseWakeLockIfExist();
  }
  
  static boolean shouldRetry(int paramInt)
  {
    return false;
  }
  
  static void updateNetworkChange()
  {
    sCurrNetworkType = NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext());
    sNetworkChangeTime = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadHelper
 * JD-Core Version:    0.7.0.1
 */