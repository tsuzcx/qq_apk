package com.tencent.mobileqq.guild.channel.create.fragment;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;

class QQGuildAppPreviewFragment$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QQGuildAppPreviewFragment$1(QQGuildAppPreviewFragment paramQQGuildAppPreviewFragment) {}
  
  @RequiresApi(api=16)
  public void onGlobalLayout()
  {
    QQGuildAppPreviewFragment localQQGuildAppPreviewFragment = this.a;
    QQGuildAppPreviewFragment.a(localQQGuildAppPreviewFragment, QQGuildAppPreviewFragment.a(localQQGuildAppPreviewFragment).getMeasuredHeight());
    localQQGuildAppPreviewFragment = this.a;
    QQGuildAppPreviewFragment.b(localQQGuildAppPreviewFragment, (int)(QQGuildAppPreviewFragment.b(localQQGuildAppPreviewFragment) * QQGuildAppPreviewFragment.d()));
    int i = (QQGuildAppPreviewFragment.a(this.a).getMeasuredWidth() - QQGuildAppPreviewFragment.c(this.a)) / 2;
    QQGuildAppPreviewFragment.a(this.a).setPadding(i, 0, i, 0);
    QQGuildAppPreviewFragment.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    QQGuildAppPreviewFragment.a(this.a).setAdapter(new QQGuildAppPreviewFragment.MyAdapter(this.a, null));
    QQGuildAppPreviewFragment.a(this.a).setOnPageChangeListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildAppPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */