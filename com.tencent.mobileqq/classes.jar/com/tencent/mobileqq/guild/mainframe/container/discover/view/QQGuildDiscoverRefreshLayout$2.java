package com.tencent.mobileqq.guild.mainframe.container.discover.view;

import android.view.ViewGroup;

class QQGuildDiscoverRefreshLayout$2
  extends QQGuildDiscoverRefreshLayout.RefreshCallback
{
  QQGuildDiscoverRefreshLayout$2(QQGuildDiscoverRefreshLayout paramQQGuildDiscoverRefreshLayout)
  {
    super(paramQQGuildDiscoverRefreshLayout);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((QQGuildDiscoverRefreshLayout.c(this.a) != null) && ((QQGuildDiscoverRefreshLayout.c(this.a) instanceof QQGuildDiscoverRefreshLayout.SwipeTrigger)) && (QQGuildDiscoverRefreshLayout.STATUS.c(QQGuildDiscoverRefreshLayout.d(this.a))))
    {
      if (QQGuildDiscoverRefreshLayout.c(this.a).getVisibility() != 0) {
        QQGuildDiscoverRefreshLayout.c(this.a).setVisibility(0);
      }
      ((QQGuildDiscoverRefreshLayout.SwipeTrigger)QQGuildDiscoverRefreshLayout.c(this.a)).a(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void b()
  {
    if ((QQGuildDiscoverRefreshLayout.c(this.a) != null) && (QQGuildDiscoverRefreshLayout.STATUS.b(QQGuildDiscoverRefreshLayout.d(this.a))))
    {
      if ((QQGuildDiscoverRefreshLayout.c(this.a) instanceof QQGuildDiscoverRefreshLayout.SwipeRefreshTrigger)) {
        ((QQGuildDiscoverRefreshLayout.SwipeRefreshTrigger)QQGuildDiscoverRefreshLayout.c(this.a)).b();
      }
      if (QQGuildDiscoverRefreshLayout.e(this.a) != null) {
        QQGuildDiscoverRefreshLayout.e(this.a).a();
      }
    }
  }
  
  public void c()
  {
    if ((QQGuildDiscoverRefreshLayout.c(this.a) != null) && ((QQGuildDiscoverRefreshLayout.c(this.a) instanceof QQGuildDiscoverRefreshLayout.SwipeTrigger)) && ((QQGuildDiscoverRefreshLayout.STATUS.a(QQGuildDiscoverRefreshLayout.d(this.a))) || (QQGuildDiscoverRefreshLayout.STATUS.h(QQGuildDiscoverRefreshLayout.d(this.a)))))
    {
      QQGuildDiscoverRefreshLayout.c(this.a).setVisibility(0);
      ((QQGuildDiscoverRefreshLayout.SwipeTrigger)QQGuildDiscoverRefreshLayout.c(this.a)).c();
    }
  }
  
  public void d()
  {
    if ((QQGuildDiscoverRefreshLayout.c(this.a) != null) && ((QQGuildDiscoverRefreshLayout.c(this.a) instanceof QQGuildDiscoverRefreshLayout.SwipeTrigger)) && (QQGuildDiscoverRefreshLayout.STATUS.e(QQGuildDiscoverRefreshLayout.d(this.a)))) {
      ((QQGuildDiscoverRefreshLayout.SwipeTrigger)QQGuildDiscoverRefreshLayout.c(this.a)).d();
    }
  }
  
  public void e()
  {
    if ((QQGuildDiscoverRefreshLayout.c(this.a) != null) && ((QQGuildDiscoverRefreshLayout.c(this.a) instanceof QQGuildDiscoverRefreshLayout.SwipeTrigger)) && ((QQGuildDiscoverRefreshLayout.STATUS.a(QQGuildDiscoverRefreshLayout.d(this.a))) || (QQGuildDiscoverRefreshLayout.STATUS.h(QQGuildDiscoverRefreshLayout.d(this.a))))) {
      ((QQGuildDiscoverRefreshLayout.SwipeTrigger)QQGuildDiscoverRefreshLayout.c(this.a)).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.view.QQGuildDiscoverRefreshLayout.2
 * JD-Core Version:    0.7.0.1
 */