package com.tencent.mobileqq.kandian.biz.framework;

import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class RIJUGCDianDian$1$2
  implements Runnable
{
  RIJUGCDianDian$1$2(RIJUGCDianDian.1 param1) {}
  
  public void run()
  {
    if (RIJUGCDianDian.b() >= 2)
    {
      QQToast.makeText(this.this$0.a, 0, this.this$0.a.getString(2131915357), 0).show(this.this$0.a.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    RIJUGCDianDian.a(this.this$0.a);
    RIJUGCDianDian.a("3", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian.1.2
 * JD-Core Version:    0.7.0.1
 */