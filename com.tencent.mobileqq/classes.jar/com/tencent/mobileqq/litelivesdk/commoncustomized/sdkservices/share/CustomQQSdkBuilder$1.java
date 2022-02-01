package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.falco.base.libapi.qqsdk.QQBaseShareData;
import com.tencent.falco.base.libapi.qqsdk.QQLoginCallback;
import com.tencent.falco.base.libapi.qqsdk.QQSdkInterface;
import com.tencent.falco.base.libapi.qqsdk.QQShareListener;
import com.tencent.falco.base.libapi.qqsdk.QZoneBaseShareData;
import com.tencent.falco.base.libapi.qqsdk.QZoneShareListener;

class CustomQQSdkBuilder$1
  implements QQSdkInterface
{
  CustomQQSdkBuilder$1(CustomQQSdkBuilder paramCustomQQSdkBuilder) {}
  
  public void clearEventOutput() {}
  
  public boolean isQQInstalled()
  {
    return false;
  }
  
  public void login(QQLoginCallback paramQQLoginCallback) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void shareToQQ(Activity paramActivity, QQBaseShareData paramQQBaseShareData, QQShareListener paramQQShareListener) {}
  
  public void shareToQzone(Activity paramActivity, QZoneBaseShareData paramQZoneBaseShareData, QZoneShareListener paramQZoneShareListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.share.CustomQQSdkBuilder.1
 * JD-Core Version:    0.7.0.1
 */