package com.tencent.qqmini.sdk.core.plugins;

import android.view.View;
import beka;
import benh;
import benm;
import besl;

class TelephonyJsPlugin$2$1
  implements benm
{
  TelephonyJsPlugin$2$1(TelephonyJsPlugin.2 param2, benh parambenh) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    try
    {
      paramView = this.this$1.this$0;
      String str1 = this.this$1.val$req.a;
      String str2 = this.this$1.val$req.b;
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        TelephonyJsPlugin.access$000(paramView, str1, str2, bool);
        this.val$actionSheet.dismiss();
        return;
      }
      return;
    }
    catch (Exception paramView)
    {
      besl.d("TelephonyJsPlugin", this.this$1.val$req.a + " error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.TelephonyJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */