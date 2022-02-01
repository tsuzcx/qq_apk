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
    String str = paramString;
    if (paramInt != 0)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        str = ErrorCodeUtil.getErrorMsg(paramInt);
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          paramString = ErrorCodeUtil.getErrorMsg(1810014);
        }
        str = "(" + paramInt + ")" + paramString;
      }
    }
    return str;
  }
  
  private static boolean isNetworkChange()
  {
    long l = SystemClock.elapsedRealtime() - sNetworkChangeTime;
    TsLog.d("UploadHelper", "change wait time = " + l);
    if (60000L > l) {}
    int i;
    do
    {
      return true;
      i = NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext());
    } while (sCurrNetworkType != i);
    return false;
  }
  
  public static int parseUploadResponse(UploadResponse paramUploadResponse)
  {
    int i;
    if (paramUploadResponse == null) {
      i = 1810024;
    }
    do
    {
      int j;
      do
      {
        return i;
        j = paramUploadResponse.code();
        i = j;
      } while (!UploadError.isCurlError(j));
      i = j;
    } while (!isNetworkChange());
    return 1810003;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadHelper
 * JD-Core Version:    0.7.0.1
 */