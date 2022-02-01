package com.tencent.mobileqq.listentogether.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class BaseListenTogetherPanel$7
  implements Runnable
{
  BaseListenTogetherPanel$7(BaseListenTogetherPanel paramBaseListenTogetherPanel) {}
  
  public void run()
  {
    try
    {
      View localView = ((LayoutInflater)this.this$0.b.getSystemService("layout_inflater")).inflate(2131627276, this.this$0.c, false);
      localView.measure(0, 0);
      this.this$0.f = new PopupWindow(localView);
      this.this$0.f.setHeight(-2);
      this.this$0.f.setWidth(-2);
      this.this$0.f.setOutsideTouchable(true);
      localView.setOnClickListener(new BaseListenTogetherPanel.7.1(this));
      int i;
      if (this.this$0.c != null) {
        i = this.this$0.c.getWidth();
      } else {
        i = ViewUtils.getScreenWidth();
      }
      int j = localView.getMeasuredWidth();
      int k = ViewUtils.dip2px(52.0F);
      this.this$0.f.showAsDropDown(this.this$0.d, i - j - k, 0);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("BaseListenTogetherPanel", 1, "showGuide exception, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.7
 * JD-Core Version:    0.7.0.1
 */