package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;

public class AppBrandLaunchUI
  extends BaseActivity
{
  public static final int ACTIVITY_CODE_LOGIN = 100001;
  public static final String TAG = "miniapp-start_AppBrandLaunchUI";
  private Handler mUIHandler;
  
  private void doRequestByAppid(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new AppBrandLaunchUI.1(this, paramLaunchParam));
  }
  
  private void doStartMiniApp(MiniAppConfig paramMiniAppConfig)
  {
    try
    {
      MiniAppController.startApp(this, paramMiniAppConfig, null);
      return;
    }
    catch (Throwable paramMiniAppConfig)
    {
      QLog.e("miniapp", 1, "startAppByAppid exception! ", paramMiniAppConfig);
    }
  }
  
  private void initData()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean isMiniAppInfoValid(MiniAppConfig paramMiniAppConfig)
  {
    return (paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) && (!TextUtils.isEmpty(paramMiniAppConfig.config.downloadUrl));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = new StringBuilder();
    paramIntent.append("doOnActivityResult requestCode=");
    paramIntent.append(paramInt1);
    paramIntent.append(" resultCode=");
    paramIntent.append(paramInt2);
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, paramIntent.toString());
    if (paramInt1 != 100001) {
      return;
    }
    if (paramInt2 == -1)
    {
      paramIntent = MiniAppStartUtils.parserStringToMiniAppInfo(getIntent().getStringExtra("CONFIG_base64"));
      if (paramIntent != null) {
        doStartMiniApp(paramIntent);
      }
      moveTaskToBack(true);
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.mUIHandler = new Handler(Looper.getMainLooper());
    return true;
  }
  
  protected void doOnDestroy()
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnDestroy");
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnResume");
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnPause");
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnResume");
    super.doOnResume();
    initData();
  }
  
  protected void doOnStop()
  {
    QLog.i("miniapp-start_AppBrandLaunchUI", 1, "doOnStop");
    super.doOnStop();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI
 * JD-Core Version:    0.7.0.1
 */