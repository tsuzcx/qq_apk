package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

class ShortVideoCommentsView$12
  implements AdapterView.OnItemLongClickListener
{
  ShortVideoCommentsView$12(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Comments.Comment)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null) {
      return true;
    }
    paramLong = Long.parseLong(this.a.a.getCurrentAccountUin());
    if (paramAdapterView.c == paramLong)
    {
      this.a.c(paramAdapterView);
      return true;
    }
    if (ShortVideoCommentsView.a(this.a).c == paramLong) {
      this.a.e(paramAdapterView);
    }
    for (;;)
    {
      return false;
      this.a.d(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.12
 * JD-Core Version:    0.7.0.1
 */