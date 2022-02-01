package com.tencent.qqmini.miniapp.core.page;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.ProcessUtil;

class AppBrandPageContainer$7$1
  implements DialogInterface.OnClickListener
{
  AppBrandPageContainer$7$1(AppBrandPageContainer.7 param7) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = StorageUtil.getPreference().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppBrandPageContainer.access$200(this.this$1.this$0).getMiniAppInfo().appId);
    localStringBuilder.append("_debug");
    paramDialogInterface.putBoolean(localStringBuilder.toString(), this.this$1.val$enableDebug);
    this.this$1.this$0.hideSoftInput(this.this$1.this$0);
    ProcessUtil.exitProcess(AppBrandPageContainer.access$200(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.7.1
 * JD-Core Version:    0.7.0.1
 */