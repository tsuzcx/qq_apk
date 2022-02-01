package com.tencent.open.downloadnew;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.open.business.base.StaticAnalyz;

public class MyAppApi$BackListener
  implements DialogInterface.OnCancelListener
{
  String a;
  String b;
  
  public MyAppApi$BackListener(MyAppApi paramMyAppApi, String paramString1, String paramString2)
  {
    this.a = StaticAnalyz.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.c.a(this.b);
    StaticAnalyz.a("720", this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.BackListener
 * JD-Core Version:    0.7.0.1
 */