package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.qphone.base.util.QLog;

class BaseJsPluginEngine$8
  implements DialogInterface.OnDismissListener
{
  BaseJsPluginEngine$8(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AuthDialog localAuthDialog = (AuthDialog)paramDialogInterface;
    Object localObject = localAuthDialog.getData();
    if (localObject != null)
    {
      paramDialogInterface = ((Bundle)localObject).getString("key_event_name");
      localObject = ((Bundle)localObject).getString("key_params");
    }
    for (;;)
    {
      localObject = AuthorizeCenter.getScopeName(paramDialogInterface, (String)localObject);
      boolean bool1 = localAuthDialog.isConfirm();
      boolean bool2 = localAuthDialog.isRefuse();
      QLog.d("BaseJsPluginEngine", 2, "onDismiss eventName=" + paramDialogInterface + ",scopeName=" + (String)localObject + ",isConfirm=" + bool1 + ",isRefuse=" + bool2);
      paramDialogInterface = this.this$0.uiHandler.obtainMessage(1);
      if (bool1)
      {
        paramDialogInterface.arg1 = 1;
        this.this$0.authorizeCenter.setAuthorize((String)localObject, true);
      }
      for (;;)
      {
        paramDialogInterface.sendToTarget();
        this.this$0.authDialog = null;
        return;
        if (bool2)
        {
          paramDialogInterface.arg1 = 2;
          paramDialogInterface.obj = localObject;
          this.this$0.authorizeCenter.setAuthorize((String)localObject, false);
        }
        else
        {
          paramDialogInterface.arg1 = 3;
          paramDialogInterface.obj = localObject;
        }
      }
      localObject = null;
      paramDialogInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.8
 * JD-Core Version:    0.7.0.1
 */