package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class OtherJsPlugin$6$1
  implements DialogInterface.OnClickListener
{
  OtherJsPlugin$6$1(OtherJsPlugin.6 param6) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      if ((this.this$1.this$0.jsPluginEngine.appBrandRuntime != null) && ((this.this$1.this$0.jsPluginEngine.appBrandRuntime.getContainer() instanceof AppBrandPageContainer))) {
        ((AppBrandPageContainer)this.this$1.this$0.jsPluginEngine.appBrandRuntime.getContainer()).notifyOnAddColorNote();
      }
      OtherJsPlugin.access$700(this.this$1.this$0, this.this$1.val$finalColorNoteController);
      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690746), 5000).a();
      if (this.this$1.this$0.isMiniGameRuntime())
      {
        paramDialogInterface = new OtherJsPlugin.6.1.1(this);
        if ((this.this$1.this$0.jsPluginEngine.appBrandRuntime.activity != null) && ((this.this$1.this$0.jsPluginEngine.appBrandRuntime.activity instanceof GameActivity))) {
          ((GameActivity)this.this$1.this$0.jsPluginEngine.appBrandRuntime.activity).setColorSignAddListener(paramDialogInterface);
        }
      }
      else
      {
        this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$eventName, null, this.this$1.val$callbackId);
        return;
      }
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e(OtherJsPlugin.access$000(), 1, "show modalView error." + paramDialogInterface);
      this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$webview, this.this$1.val$eventName, null, this.this$1.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.6.1
 * JD-Core Version:    0.7.0.1
 */