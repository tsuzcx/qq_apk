package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class OtherJsPlugin$5$1
  implements DialogInterface.OnClickListener
{
  OtherJsPlugin$5$1(OtherJsPlugin.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      if ((this.this$1.this$0.jsPluginEngine.appBrandRuntime != null) && ((this.this$1.this$0.jsPluginEngine.appBrandRuntime.getContainer() instanceof AppBrandPageContainer))) {
        ((AppBrandPageContainer)this.this$1.this$0.jsPluginEngine.appBrandRuntime.getContainer()).notifyOnAddColorNote();
      }
      OtherJsPlugin.access$300(this.this$1.this$0, this.this$1.val$finalColorNoteController);
      bcpw.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690852), 5000).a();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e(OtherJsPlugin.access$000(), 1, "show modalView error." + paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */