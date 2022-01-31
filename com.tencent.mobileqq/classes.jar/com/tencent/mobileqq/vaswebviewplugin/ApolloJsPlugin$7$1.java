package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ApolloJsPlugin$7$1
  implements DialogInterface.OnClickListener
{
  ApolloJsPlugin$7$1(ApolloJsPlugin.7 param7) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.this$1.this$0.callbackError(this.this$1.val$callbackId, "下载失败，用户取消");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.7.1
 * JD-Core Version:    0.7.0.1
 */