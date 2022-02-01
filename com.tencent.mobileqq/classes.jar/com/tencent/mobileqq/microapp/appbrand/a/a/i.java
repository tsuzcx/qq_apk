package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.microapp.app.a;
import com.tencent.mobileqq.microapp.widget.d;
import com.tencent.qphone.base.util.QLog;

final class i
  implements DialogInterface.OnDismissListener
{
  i(f paramf) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    d locald = (d)paramDialogInterface;
    Object localObject = locald.a();
    if (localObject != null)
    {
      paramDialogInterface = ((Bundle)localObject).getString("key_event_name");
      localObject = ((Bundle)localObject).getString("key_params");
    }
    for (;;)
    {
      localObject = a.c(paramDialogInterface, (String)localObject);
      boolean bool1 = locald.b();
      boolean bool2 = locald.c();
      if (QLog.isColorLevel()) {
        QLog.d("JsPluginEngine", 2, "onDismiss eventName=" + paramDialogInterface + ",scopeName=" + (String)localObject + ",isConfirm=" + bool1 + ",isRefuse=" + bool2);
      }
      paramDialogInterface = f.a(this.a).obtainMessage(1);
      if (bool1)
      {
        paramDialogInterface.arg1 = 1;
        this.a.b.a((String)localObject, true);
      }
      for (;;)
      {
        paramDialogInterface.sendToTarget();
        this.a.c = null;
        return;
        if (bool2)
        {
          paramDialogInterface.arg1 = 2;
          paramDialogInterface.obj = localObject;
          this.a.b.a((String)localObject, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.i
 * JD-Core Version:    0.7.0.1
 */