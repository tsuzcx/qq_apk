package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.microapp.widget.f;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class ch
  implements DialogInterface.OnDismissListener
{
  ch(cg paramcg, f paramf) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("UIJsPlugin", 2, "onDismiss isConfirm=" + this.a.b() + "，isRefuse=" + this.a.c());
    try
    {
      paramDialogInterface = new JSONObject();
      if (this.a.b()) {
        paramDialogInterface.put("confirm", true);
      }
      for (;;)
      {
        this.b.k.a.a(this.b.a, this.b.b, paramDialogInterface, this.b.c);
        return;
        paramDialogInterface.put("cancel", this.a.c());
      }
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.ch
 * JD-Core Version:    0.7.0.1
 */