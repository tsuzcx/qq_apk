package com.tencent.mobileqq.mini.cache;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MiniCacheFreeManager$1$1
  implements DialogInterface.OnClickListener
{
  MiniCacheFreeManager$1$1(MiniCacheFreeManager.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MiniCacheFreeManager.freeCache(this.this$0.val$uin, this.this$0.val$miniAppInfo);
    if (this.this$0.val$activity != null) {
      this.this$0.val$activity.finish();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.1.1
 * JD-Core Version:    0.7.0.1
 */