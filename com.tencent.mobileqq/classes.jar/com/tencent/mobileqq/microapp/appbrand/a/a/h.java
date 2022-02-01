package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.widget.d;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

final class h
  implements DialogInterface.OnDismissListener
{
  h(f paramf) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Object localObject3 = (d)paramDialogInterface;
    Object localObject2 = ((d)localObject3).a();
    if (localObject2 != null)
    {
      paramDialogInterface = ((Bundle)localObject2).getString("key_event_name");
      localObject1 = ((Bundle)localObject2).getString("key_params");
    }
    else
    {
      paramDialogInterface = null;
      localObject1 = paramDialogInterface;
    }
    Object localObject1 = com.tencent.mobileqq.microapp.app.a.d(paramDialogInterface, (String)localObject1);
    boolean bool1 = ((d)localObject3).b();
    boolean bool2 = ((d)localObject3).c();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onDismiss eventName=");
      ((StringBuilder)localObject3).append(paramDialogInterface);
      ((StringBuilder)localObject3).append(",permissionName=");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(",isConfirm=");
      ((StringBuilder)localObject3).append(bool1);
      ((StringBuilder)localObject3).append(",isRefuse=");
      ((StringBuilder)localObject3).append(bool2);
      QLog.d("JsPluginEngine", 2, ((StringBuilder)localObject3).toString());
    }
    paramDialogInterface = f.a(this.a).obtainMessage(4);
    if (bool1)
    {
      localObject2 = this.a.a.d;
      if (localObject2 == null)
      {
        paramDialogInterface.arg1 = 3;
        paramDialogInterface.obj = localObject1;
        return;
      }
      localObject1 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      ((Intent)localObject1).setData(Uri.fromParts("package", ((BaseActivity)localObject2).getPackageName(), null));
      ((BaseActivity)localObject2).startActivity((Intent)localObject1);
    }
    else if (bool2)
    {
      paramDialogInterface.arg1 = 2;
      paramDialogInterface.obj = localObject1;
      f.b(this.a).offer((f.a)((Bundle)localObject2).getSerializable("key_job_info"));
    }
    else
    {
      paramDialogInterface.arg1 = 3;
      paramDialogInterface.obj = localObject1;
      f.b(this.a).offer((f.a)((Bundle)localObject2).getSerializable("key_job_info"));
    }
    paramDialogInterface.sendToTarget();
    this.a.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.h
 * JD-Core Version:    0.7.0.1
 */