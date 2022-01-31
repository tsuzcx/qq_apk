package com.tencent.mobileqq.vaswebviewplugin;

import alpo;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ApolloJsPlugin$8$1
  implements DialogInterface.OnClickListener
{
  ApolloJsPlugin$8$1(ApolloJsPlugin.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.this$1.this$0.callbackError(this.this$1.val$callbackId, alpo.a(2131700827));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.8.1
 * JD-Core Version:    0.7.0.1
 */