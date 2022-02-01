package com.tencent.mobileqq.kandian.biz.feeds;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyProteusFamilyListViewGroup$2
  implements Runnable
{
  ReadInJoyProteusFamilyListViewGroup$2(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup, View paramView1, int paramInt, View paramView2) {}
  
  public void run()
  {
    int i = this.a.getHeight();
    StringBuilder localStringBuilder;
    if ((i != this.b) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=");
      localStringBuilder.append(i);
      localStringBuilder.append(",heightDef =");
      localStringBuilder.append(this.b);
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, localStringBuilder.toString());
    }
    if (i > this.b)
    {
      this.c.setPadding(0, i, 0, 0);
      ReadInJoyProteusFamilyListViewGroup.a(this.this$0).setPadding(0, i, 0, 0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI 看点 mListView.setPadding statusLineHeight=");
        localStringBuilder.append(i);
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyListViewGroup.2
 * JD-Core Version:    0.7.0.1
 */