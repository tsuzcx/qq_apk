package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import anvx;

class ApolloJsPlugin$12$1
  implements DialogInterface.OnClickListener
{
  ApolloJsPlugin$12$1(ApolloJsPlugin.12 param12) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.this$1.this$0.callbackError(this.this$1.val$callbackId, anvx.a(2131699957));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.12.1
 * JD-Core Version:    0.7.0.1
 */