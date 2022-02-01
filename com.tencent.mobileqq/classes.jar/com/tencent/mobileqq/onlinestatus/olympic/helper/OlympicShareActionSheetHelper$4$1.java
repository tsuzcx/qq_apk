package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class OlympicShareActionSheetHelper$4$1
  implements Runnable
{
  OlympicShareActionSheetHelper$4$1(OlympicShareActionSheetHelper.4 param4) {}
  
  public void run()
  {
    if (this.a.this$0.c != null)
    {
      if (this.a.this$0.c.isFinishing()) {
        return;
      }
      QQToast.makeText(this.a.this$0.c, 1, HardCodeUtil.a(2131896393), 1).show();
      if (this.a.a != null) {
        this.a.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.4.1
 * JD-Core Version:    0.7.0.1
 */