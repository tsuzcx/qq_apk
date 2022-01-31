package com.tencent.mobileqq.minigame.jsapi;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.NetworkTimeoutInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime.ShareScreenshotCallback;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;

public class GameBrandRuntime
  extends BaseAppBrandRuntime
{
  private static final String TAG = "GameBrandRuntime";
  private ApkgInfo apkgInfo;
  public int fromShareMenuBtn = -1;
  public String shareAppid;
  public int shareCallbackId = -1;
  public ShareChatModel shareChatModel;
  public String shareEvent;
  public String shareJson;
  public String shareOpenid;
  public boolean withShareQQ;
  public boolean withShareQzone;
  public boolean withShareTicket;
  public boolean withShareWeChatFriend;
  public boolean withShareWeChatMoment;
  
  public GameBrandRuntime(BaseActivity paramBaseActivity, ApkgInfo paramApkgInfo)
  {
    AppInterface localAppInterface = paramBaseActivity.getAppInterface();
    if ((localAppInterface instanceof MiniAppInterface)) {
      this.appInterface = ((MiniAppInterface)localAppInterface);
    }
    onAttachWindow(paramBaseActivity);
    paramApkgInfo.mAppConfigInfo = new AppConfigInfo();
    paramApkgInfo.mAppConfigInfo.networkTimeoutInfo = new NetworkTimeoutInfo();
    paramApkgInfo.mAppConfigInfo.networkTimeoutInfo.request = 60000;
    paramApkgInfo.mAppConfigInfo.networkTimeoutInfo.connectSocket = 60000;
    paramApkgInfo.mAppConfigInfo.networkTimeoutInfo.downloadFile = 60000;
    paramApkgInfo.mAppConfigInfo.networkTimeoutInfo.uploadFile = 60000;
    this.apkgInfo = paramApkgInfo;
    ThreadManagerV2.excute(new GameBrandRuntime.1(this, this.activity), 16, null, true);
  }
  
  public ApkgInfo getApkgInfo()
  {
    return this.apkgInfo;
  }
  
  public void getScreenShot(ScreenShotCallback paramScreenShotCallback)
  {
    GameLoadManager.g().getGameEngine().getScreenShot(paramScreenShotCallback);
  }
  
  public void getShareScreenshot(BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback)
  {
    super.getShareScreenshot(paramShareScreenshotCallback);
    showShareScreenshotProgress();
    this.isGettingScreenShot = true;
    getScreenShot(new GameBrandRuntime.2(this, paramShareScreenshotCallback));
  }
  
  public void moveAppBrandToBack()
  {
    super.moveAppBrandToBack();
    GameActivity localGameActivity = (GameActivity)this.activity;
    localGameActivity.runOnUiThread(new GameBrandRuntime.3(this, localGameActivity));
  }
  
  public void onAttachWindow(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime
 * JD-Core Version:    0.7.0.1
 */