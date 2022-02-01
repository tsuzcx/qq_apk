package com.tencent.qqmini.miniapp.core.page;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.ProcessUtil;

class AppBrandPageContainer$5$1
  implements DialogInterface.OnClickListener
{
  AppBrandPageContainer$5$1(AppBrandPageContainer.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StorageUtil.getPreference().edit().putBoolean(AppBrandPageContainer.access$000(this.this$1.this$0).getMiniAppInfo().appId + "_debug", this.this$1.val$enableDebug);
    this.this$1.this$0.hideSoftInput(this.this$1.this$0);
    ProcessUtil.exitProcess(AppBrandPageContainer.access$000(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.5.1
 * JD-Core Version:    0.7.0.1
 */