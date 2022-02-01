package com.tencent.mobileqq.guild.main;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class QQGuildChannelView$5
  implements AbsListView.OnScrollListener
{
  QQGuildChannelView$5(QQGuildChannelView paramQQGuildChannelView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = paramAbsListView.getChildAt(0);
    paramInt2 = localView.getTop();
    paramInt3 = -paramAbsListView.getScrollY();
    int i = localView.getHeight();
    if (QLog.isDevelopLevel()) {
      QLog.d("QQGuildChannelView.scroll", 2, String.format("listView scroll firstVisibleItem:%d, offset:%d, overScrollY:%d, itemHeight:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) }));
    }
    if (QQGuildChannelView.g(this.a) != null) {
      QQGuildChannelView.g(this.a).a(paramInt1, paramInt2 + paramInt3, i);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.5
 * JD-Core Version:    0.7.0.1
 */