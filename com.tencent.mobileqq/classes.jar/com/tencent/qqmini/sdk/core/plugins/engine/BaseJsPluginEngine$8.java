package com.tencent.qqmini.sdk.core.plugins.engine;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import bemx;
import betc;

class BaseJsPluginEngine$8
  implements DialogInterface.OnDismissListener
{
  BaseJsPluginEngine$8(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    bemx localbemx = (bemx)paramDialogInterface;
    Object localObject = localbemx.a();
    if (localObject != null)
    {
      paramDialogInterface = ((Bundle)localObject).getString("key_event_name");
      localObject = ((Bundle)localObject).getString("key_params");
    }
    for (;;)
    {
      localObject = BaseJsPluginEngine.access$000(paramDialogInterface, (String)localObject);
      boolean bool1 = localbemx.a();
      boolean bool2 = localbemx.b();
      betc.a("JsPluginEngine[AuthGuard]", "onDismiss eventName=" + paramDialogInterface + ",scopeName=" + (String)localObject + ",isConfirm=" + bool1 + ",isRefuse=" + bool2);
      paramDialogInterface = BaseJsPluginEngine.access$500(this.this$0).obtainMessage(1);
      if (bool1)
      {
        paramDialogInterface.arg1 = 1;
        BaseJsPluginEngine.access$100(this.this$0, (String)localObject, true);
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
          BaseJsPluginEngine.access$100(this.this$0, (String)localObject, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.8
 * JD-Core Version:    0.7.0.1
 */