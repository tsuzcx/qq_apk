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
    paramLong = Long.parseLong(this.a.app.getCurrentAccountUin());
    if (paramAdapterView.f == paramLong)
    {
      this.a.showDelSheet(paramAdapterView);
      return true;
    }
    if (ShortVideoCommentsView.access$000(this.a).u == paramLong) {
      this.a.showDelAndReportSheet(paramAdapterView);
    } else {
      this.a.showReportSheet(paramAdapterView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.12
 * JD-Core Version:    0.7.0.1
 */