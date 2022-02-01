package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class OlympicShareActionSheetHelper$7$1
  implements Runnable
{
  OlympicShareActionSheetHelper$7$1(OlympicShareActionSheetHelper.7 param7, String paramString) {}
  
  public void run()
  {
    if (this.b.this$0.c.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.a))
    {
      QQToast.makeText(this.b.this$0.c, 1, HardCodeUtil.a(2131896393), 1).show();
      this.b.this$0.c.setResult(0);
      return;
    }
    if (this.b.a == 9) {
      WXShareHelper.a().a(this.a, this.b.this$0.d, 0);
    } else {
      WXShareHelper.a().a(this.a, this.b.this$0.d, 1);
    }
    if (this.b.b != null) {
      this.b.b.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.7.1
 * JD-Core Version:    0.7.0.1
 */