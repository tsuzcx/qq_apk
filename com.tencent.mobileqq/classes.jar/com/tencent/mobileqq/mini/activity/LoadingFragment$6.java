package com.tencent.mobileqq.mini.activity;

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

class LoadingFragment$6
  extends CmdCallback.Stub
{
  LoadingFragment$6(LoadingFragment paramLoadingFragment) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = StorageUtil.getPreference().getString("version", "1.14.0.00225");
      if ((LoadingFragment.access$000(this.this$0) != null) && (LoadingFragment.access$000(this.this$0).config != null) && ((TextUtils.isEmpty(paramBundle)) || (BaseLibInfo.needUpdateVersion(LoadingFragment.access$000(this.this$0).config.baselibMiniVersion, paramBundle))))
      {
        AppBrandTask.runTaskOnUiThread(new LoadingFragment.6.1(this));
        return;
      }
      this.this$0.mIsBaseLibVersionMatch = true;
      ThreadManager.excute(new LoadingFragment.6.2(this), 16, null, false);
      return;
    }
    QLog.e("miniapp-start", 1, "LoadingFragment updateBaseLib, fail.");
    AppBrandTask.runTaskOnUiThread(new LoadingFragment.6.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.6
 * JD-Core Version:    0.7.0.1
 */