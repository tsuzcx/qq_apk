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
    Object localObject2 = (d)paramDialogInterface;
    Object localObject1 = ((d)localObject2).a();
    if (localObject1 != null)
    {
      paramDialogInterface = ((Bundle)localObject1).getString("key_event_name");
      localObject1 = ((Bundle)localObject1).getString("key_params");
    }
    else
    {
      localObject1 = null;
      paramDialogInterface = (DialogInterface)localObject1;
    }
    localObject1 = a.c(paramDialogInterface, (String)localObject1);
    boolean bool1 = ((d)localObject2).b();
    boolean bool2 = ((d)localObject2).c();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onDismiss eventName=");
      ((StringBuilder)localObject2).append(paramDialogInterface);
      ((StringBuilder)localObject2).append(",scopeName=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",isConfirm=");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(",isRefuse=");
      ((StringBuilder)localObject2).append(bool2);
      QLog.d("JsPluginEngine", 2, ((StringBuilder)localObject2).toString());
    }
    paramDialogInterface = f.a(this.a).obtainMessage(1);
    if (bool1)
    {
      paramDialogInterface.arg1 = 1;
      this.a.b.a((String)localObject1, true);
    }
    else if (bool2)
    {
      paramDialogInterface.arg1 = 2;
      paramDialogInterface.obj = localObject1;
      this.a.b.a((String)localObject1, false);
    }
    else
    {
      paramDialogInterface.arg1 = 3;
      paramDialogInterface.obj = localObject1;
    }
    paramDialogInterface.sendToTarget();
    this.a.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.i
 * JD-Core Version:    0.7.0.1
 */