package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;

class SwiftBrowserDebugHelper$4
  implements DialogInterface.OnClickListener
{
  SwiftBrowserDebugHelper$4(SwiftBrowserDebugHelper paramSwiftBrowserDebugHelper, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ClipboardManager)this.b.b.b().getSystemService("clipboard")).setText(this.a);
    Toast.makeText(this.b.b.b().getApplicationContext(), 2131911997, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserDebugHelper.4
 * JD-Core Version:    0.7.0.1
 */