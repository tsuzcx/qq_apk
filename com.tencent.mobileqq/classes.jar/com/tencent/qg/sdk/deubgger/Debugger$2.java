package com.tencent.qg.sdk.deubgger;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

class Debugger$2
  implements Runnable
{
  Debugger$2(Debugger paramDebugger, String paramString1, String paramString2) {}
  
  public void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(Debugger.access$000(this.this$0));
    localBuilder.setMessage(this.val$msg).setTitle(this.val$title).setPositiveButton("OK", new Debugger.2.1(this));
    localBuilder.create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.deubgger.Debugger.2
 * JD-Core Version:    0.7.0.1
 */