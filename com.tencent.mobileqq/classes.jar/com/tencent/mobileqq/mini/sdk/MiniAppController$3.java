package com.tencent.mobileqq.mini.sdk;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;

final class MiniAppController$3
  implements Runnable
{
  MiniAppController$3(Context paramContext) {}
  
  public void run()
  {
    QQToast.makeText(this.val$context, "AppID为空", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppController.3
 * JD-Core Version:    0.7.0.1
 */