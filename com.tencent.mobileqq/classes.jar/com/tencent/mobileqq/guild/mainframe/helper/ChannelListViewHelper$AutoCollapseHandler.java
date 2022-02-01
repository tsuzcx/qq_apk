package com.tencent.mobileqq.guild.mainframe.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.guild.main.SwipPinnedHeaderExpandableListViewEx;
import com.tencent.mobileqq.guild.mainframe.container.facade.GuildFacadeTopFrameController;
import com.tencent.mobileqq.guild.widget.ChannelTitleLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class ChannelListViewHelper$AutoCollapseHandler
  implements ChannelListViewHelper.IAutoCollapseHandler
{
  public static final int a = ChannelTitleLayout.a + GuildFacadeTopFrameController.a;
  private int b;
  private long c;
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.b = paramInt;
    this.c = SystemClock.uptimeMillis();
    if (paramInt != 0) {
      return;
    }
    a("onScrollStateChanged", paramAbsListView);
  }
  
  public boolean a(String paramString, View paramView)
  {
    if ((QLog.isDevelopLevel()) && (!(paramView instanceof SwipPinnedHeaderExpandableListViewEx))) {
      throw new IllegalStateException("出错了, 自动收折逻辑对应的 ListView 类型变换了! ");
    }
    paramView = (SwipPinnedHeaderExpandableListViewEx)paramView;
    if (paramView.getFirstVisiblePosition() == 0)
    {
      View localView = paramView.getChildAt(0);
      if (localView == null) {
        return false;
      }
      int i = localView.getHeight() - a;
      float f = (localView.getTop() + i) / i;
      if (QLog.isDevelopLevel()) {
        QLog.d("ChannelListAnimateHelper", 4, new Object[] { "tryCollapseListView(): ", paramString, " scrollState:", Integer.valueOf(this.b), " getTop: ", Integer.valueOf(localView.getTop()), " lastPosition: ", Integer.valueOf(paramView.getLastVisiblePosition()), " getMeasuredHeight: ", Integer.valueOf(paramView.getMeasuredHeight()), " item count: ", Integer.valueOf(paramView.getAdapter().getCount()), " expandProgress: ", Float.valueOf(f), " maxTotalRange: ", Integer.valueOf(i), " headerHeight: ", Integer.valueOf(localView.getHeight()) });
      }
      if ((f >= 0.0F) && (f <= 0.6F))
      {
        new Handler(Looper.getMainLooper()).post(new -..Lambda.ChannelListViewHelper.AutoCollapseHandler.-TKzFg--fvXkcgQXnaHhPKs58ak(f, paramView));
        return true;
      }
    }
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (this.b == 0) && (SystemClock.uptimeMillis() - this.c > 30L)) {
      a("onTouch", paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.ChannelListViewHelper.AutoCollapseHandler
 * JD-Core Version:    0.7.0.1
 */