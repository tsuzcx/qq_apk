package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.wns;

import android.content.Context;
import com.tencent.falco.base.libapi.wns.WnsInterface;
import com.tencent.falco.base.libapi.wns.WnsLoginCallback;
import com.tencent.falco.base.libapi.wns.WnsLogoutCallback;
import com.tencent.falco.base.libapi.wns.WnsSendCallback;

class CustomWnsServiceBuilder$1
  implements WnsInterface
{
  CustomWnsServiceBuilder$1(CustomWnsServiceBuilder paramCustomWnsServiceBuilder) {}
  
  public void clearEventOutput() {}
  
  public void init(Context paramContext, int paramInt, boolean paramBoolean) {}
  
  public boolean isGlobalInitialized()
  {
    return true;
  }
  
  public void login(String paramString1, String paramString2, int paramInt, WnsLoginCallback paramWnsLoginCallback) {}
  
  public void logout(WnsLogoutCallback paramWnsLogoutCallback) {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void send(String paramString, byte[] paramArrayOfByte, int paramInt, WnsSendCallback paramWnsSendCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.wns.CustomWnsServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */