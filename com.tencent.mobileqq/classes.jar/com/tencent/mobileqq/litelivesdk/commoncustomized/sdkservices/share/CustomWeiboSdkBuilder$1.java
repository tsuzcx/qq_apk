package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.falco.base.libapi.weibosdk.WeiboLoginCallback;
import com.tencent.falco.base.libapi.weibosdk.WeiboSdkInterface;
import com.tencent.falco.base.libapi.weibosdk.WeiboShareData;
import com.tencent.falco.base.libapi.weibosdk.WeiboShareListener;

class CustomWeiboSdkBuilder$1
  implements WeiboSdkInterface
{
  CustomWeiboSdkBuilder$1(CustomWeiboSdkBuilder paramCustomWeiboSdkBuilder) {}
  
  public void clearEventOutput() {}
  
  public boolean isWeiboInstalled()
  {
    return false;
  }
  
  public void login(Activity paramActivity, WeiboLoginCallback paramWeiboLoginCallback) {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void onWeiboResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void share(Activity paramActivity, WeiboShareData paramWeiboShareData, WeiboShareListener paramWeiboShareListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.share.CustomWeiboSdkBuilder.1
 * JD-Core Version:    0.7.0.1
 */