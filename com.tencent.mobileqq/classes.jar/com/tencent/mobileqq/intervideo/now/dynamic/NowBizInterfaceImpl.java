package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBizAbilityImpl;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.IHostCallback;
import com.tencent.qqinterface.NowBizInterface;
import java.util.concurrent.ExecutorService;

public class NowBizInterfaceImpl
  implements NowBizInterface
{
  private static final String TAG = "NowBizInterfaceImpl";
  SdkBizAbilityImpl bizImpl = SdkBizAbilityImpl.getInstance();
  
  public void doActionResult(long paramLong, String paramString)
  {
    SdkBizAbilityImpl.getInstance().onDoActionResult(paramLong, paramString);
  }
  
  public Bitmap getCoverImg(String paramString)
  {
    return ExtSdkBizAbilityImpl.getInstance().getCoverImg(paramString);
  }
  
  public ExecutorService getFixedThreadPool(int paramInt)
  {
    return this.bizImpl.getFixedThreadPool(paramInt);
  }
  
  public void getRecordInfo(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    this.bizImpl.getRecordInfo(paramBundle, paramCommonCallback);
  }
  
  public boolean isNowLivePushEnable()
  {
    return ExtSdkBizAbilityImpl.getInstance().isNowLivePushEnable();
  }
  
  public void notifyCoreAction(Bundle paramBundle)
  {
    ExtSdkBizAbilityImpl.getInstance().notifyCoreAction(paramBundle);
  }
  
  public void onEnterRoom(Bundle paramBundle) {}
  
  public void onFirstFrameShow(Bundle paramBundle) {}
  
  public void onLiveOverIsInstalled(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLiveOverPluginState--from-pm---onLiveOverIsInstalled=");
    localStringBuilder.append(paramBoolean);
    Log.d("Login_Exception", localStringBuilder.toString());
    ExtSdkBizAbilityImpl.getInstance().onLiveOverIsInstalled(paramBoolean);
  }
  
  public void onLoginExpired(int paramInt)
  {
    Log.e("Login_Exception", "onLoginExpired----------");
    this.bizImpl.onLoginExpired(paramInt);
  }
  
  public void onNoLogin()
  {
    Log.e("Login_Exception", "onNoLogin----------");
    this.bizImpl.onNoLogin();
  }
  
  public void onPluginActivityLifecycleEvent(Bundle paramBundle)
  {
    ExtSdkBizAbilityImpl.getInstance().onActivityLifecycle(paramBundle);
  }
  
  public void onRoomActivityOnCreate(Bundle paramBundle) {}
  
  public void openLiveHall()
  {
    ExtSdkBizAbilityImpl.getInstance().openLiveHall();
  }
  
  public void openNowLivePushSetting(CommonCallback paramCommonCallback)
  {
    ExtSdkBizAbilityImpl.getInstance().openNowLivePlushSetting(paramCommonCallback);
  }
  
  public void openPayPage(Bundle paramBundle, CommonCallback paramCommonCallback)
  {
    ExtSdkBizAbilityImpl.getInstance().openPayPage(paramBundle, paramCommonCallback);
  }
  
  public void openPhoneAuthPage()
  {
    ExtSdkBizAbilityImpl.getInstance().openPhoneAuthPage();
  }
  
  public void openWxMiniProgram(String paramString)
  {
    ExtSdkBizAbilityImpl.getInstance().openWxMiniProgram(paramString);
  }
  
  public void queryPhoneAuthState()
  {
    ExtSdkBizAbilityImpl.getInstance().queryPhoneAuthState();
  }
  
  public void reportData(Bundle paramBundle) {}
  
  public void reportWelfareTask(String paramString1, String paramString2)
  {
    ExtSdkBizAbilityImpl.getInstance().reportWelfareTask(paramString1, paramString2);
  }
  
  public void setBizIntent(Intent paramIntent)
  {
    ExtSdkBizAbilityImpl.getInstance().setBizIntent(paramIntent);
  }
  
  public void setHostCallback(IHostCallback paramIHostCallback)
  {
    this.bizImpl.setHostCallBack(paramIHostCallback);
  }
  
  public void share(Bundle paramBundle)
  {
    ExtSdkBizAbilityImpl.getInstance().share(paramBundle);
  }
  
  public void shareToQQ(Bundle paramBundle)
  {
    this.bizImpl.shareToQQ(paramBundle);
  }
  
  public void showBiuComponent(Bundle paramBundle)
  {
    this.bizImpl.jumpToKandianBiu(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowBizInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */