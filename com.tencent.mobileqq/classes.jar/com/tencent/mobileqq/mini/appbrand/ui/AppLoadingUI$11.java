package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;

class AppLoadingUI$11
  extends CmdCallback.Stub
{
  AppLoadingUI$11(AppLoadingUI paramAppLoadingUI) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = StorageUtil.getPreference().getString("version", "1.13.0.00013");
      if ((AppLoadingUI.access$000(this.this$0) != null) && (AppLoadingUI.access$000(this.this$0).config != null) && ((TextUtils.isEmpty(paramBundle)) || (BaseLibInfo.needUpdateVersion(AppLoadingUI.access$000(this.this$0).config.baselibMiniVersion, paramBundle))))
      {
        AppBrandTask.runTaskOnUiThread(new AppLoadingUI.11.1(this));
        return;
      }
      this.this$0.mIsBaseLibVersionMatch = true;
      ThreadManager.excute(new AppLoadingUI.11.2(this), 16, null, false);
      return;
    }
    QLog.e("miniapp-start", 1, "LoadingFragment updateBaseLib, fail.");
    AppBrandTask.runTaskOnUiThread(new AppLoadingUI.11.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.11
 * JD-Core Version:    0.7.0.1
 */