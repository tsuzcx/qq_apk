package com.tencent.open.downloadnew;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.business.base.StaticAnalyz;

public class MyAppApi$ClickListenerProxy
  implements DialogInterface.OnClickListener
{
  DialogInterface.OnClickListener a;
  String b;
  String c;
  
  public MyAppApi$ClickListenerProxy(MyAppApi paramMyAppApi, DialogInterface.OnClickListener paramOnClickListener, String paramString1, String paramString2)
  {
    this.a = paramOnClickListener;
    this.b = StaticAnalyz.a(paramString1, "NEWYYB");
    this.c = paramString2;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface = this.d;
    paramDialogInterface.i = null;
    paramDialogInterface.j = null;
    StaticAnalyz.a("710", this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.ClickListenerProxy
 * JD-Core Version:    0.7.0.1
 */