package com.tencent.mobileqq.soso.location;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

final class SosoInterface$11
  implements Runnable
{
  SosoInterface$11(String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$content)) {
      QQToast.a(MobileQQ.sMobileQQ.getApplicationContext(), this.val$content, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.11
 * JD-Core Version:    0.7.0.1
 */