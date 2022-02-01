package com.tencent.mobileqq.kandian.biz.framework;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;

class RIJFrameworkHeaderManager$1
  implements Runnable
{
  RIJFrameworkHeaderManager$1(RIJFrameworkHeaderManager paramRIJFrameworkHeaderManager, View paramView1, int paramInt, View paramView2, ReadInJoyXListView paramReadInJoyXListView) {}
  
  public void run()
  {
    RIJFrameworkHeaderManager.a(this.this$0).k();
    int i = this.a.getHeight();
    StringBuilder localStringBuilder;
    if ((i != this.b) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=");
      localStringBuilder.append(i);
      localStringBuilder.append(",h = ");
      localStringBuilder.append(this.b);
      QLog.d("RIJFrameworkReportManager", 2, localStringBuilder.toString());
    }
    if (i > this.b)
    {
      this.c.setPadding(0, i, 0, 0);
      this.d.setPadding(0, i, 0, 0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI 看点 mListView.setPadding statusLineHeight=");
        localStringBuilder.append(i);
        QLog.d("RIJFrameworkReportManager", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager.1
 * JD-Core Version:    0.7.0.1
 */