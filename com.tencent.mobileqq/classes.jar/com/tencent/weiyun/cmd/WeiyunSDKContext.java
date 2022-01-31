package com.tencent.weiyun.cmd;

import android.text.TextUtils;
import com.tencent.weiyun.utils.WyLog;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class WeiyunSDKContext
{
  public static final int LOGIN_TYPE_QQ = 0;
  public static final int LOGIN_TYPE_WECHAT = 1;
  private static final int LOG_LEVEL_DEBUG = 0;
  private static final int LOG_LEVEL_ERROR = 3;
  private static final int LOG_LEVEL_INFO = 1;
  private static final int LOG_LEVEL_WARNING = 2;
  
  public abstract String getAccessToken();
  
  public abstract String getCachePath();
  
  public abstract String getDeviceId();
  
  public abstract String getDeviceInfo();
  
  public abstract String getDeviceName();
  
  public String getDocumentPath()
  {
    return "";
  }
  
  public abstract int getLoginType();
  
  public int getNetworkStatus()
  {
    return 0;
  }
  
  public abstract int getNetworkType();
  
  public abstract String getOpenID();
  
  public abstract String getOpenKey();
  
  public int getPlatform()
  {
    return 0;
  }
  
  public abstract String getRefreshToken();
  
  public abstract long[] getScreenSize();
  
  public long getUin()
  {
    String str = getOpenID();
    if (TextUtils.isEmpty(str)) {
      return 0L;
    }
    return str.hashCode();
  }
  
  public abstract String getWifiBssid();
  
  protected void onCallback(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString, boolean paramBoolean2)
  {
    WeiyunClient.getInstance().onNativeCallback(paramLong1, paramLong2, paramInt1, paramBoolean1, paramInt2, paramString, paramBoolean2);
  }
  
  public native void recvResponse(int paramInt1, byte[] paramArrayOfByte, long paramLong, int paramInt2);
  
  public abstract void sendRequest(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt);
  
  public void traceLog(int paramInt, byte[] paramArrayOfByte)
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
      WyLog.e("traceLog convert String error", paramArrayOfByte);
      return;
    }
    WyLog.d(paramArrayOfByte);
    return;
    WyLog.i(paramArrayOfByte);
    return;
    WyLog.w(paramArrayOfByte);
    return;
    WyLog.e(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.cmd.WeiyunSDKContext
 * JD-Core Version:    0.7.0.1
 */