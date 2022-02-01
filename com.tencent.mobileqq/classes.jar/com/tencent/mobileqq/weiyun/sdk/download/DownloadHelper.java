package com.tencent.mobileqq.weiyun.sdk.download;

import android.text.TextUtils;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.utils.ErrorCodeUtil;
import com.tencent.weiyun.utils.NetworkUtils;

public final class DownloadHelper
{
  public static String a(int paramInt, String paramString)
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
          if (ErrorCodeUtil.isHttpError(paramInt)) {
            paramString = ErrorCodeUtil.getErrorMsg(1810023);
          } else {
            paramString = ErrorCodeUtil.getErrorMsg(1810014);
          }
        }
        localObject = paramString;
        if (1810008 == paramInt)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("\n请尝试下载到其他路径");
          localObject = ((StringBuilder)localObject).toString();
        }
        paramString = new StringBuilder();
        paramString.append("(");
        paramString.append(paramInt);
        paramString.append(")");
        paramString.append((String)localObject);
        localObject = paramString.toString();
      }
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int i = NetworkUtils.getNetworkType(WeiyunTransmissionGlobal.getInstance().getContext());
    paramString.append("&nettype=");
    paramString.append(i);
    return paramString.toString();
  }
  
  static boolean a(int paramInt)
  {
    return (-29150 == paramInt) || (-29151 == paramInt) || (-29152 == paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.DownloadHelper
 * JD-Core Version:    0.7.0.1
 */