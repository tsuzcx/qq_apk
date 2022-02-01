package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;

class ShortVideoCommentsView$11
  implements AdapterView.OnItemClickListener
{
  ShortVideoCommentsView$11(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ShortVideoCommentsView.access$802(this.a, (Comments.Comment)paramAdapterView.getAdapter().getItem(paramInt));
    if (ShortVideoCommentsView.access$800(this.a) == null) {
      return;
    }
    paramLong = this.a.app.getLongAccountUin();
    if (ShortVideoCommentsView.access$800(this.a).c == paramLong)
    {
      this.a.showToast(HardCodeUtil.a(2131713959));
      ShortVideoCommentsView.access$802(this.a, null);
      return;
    }
    paramAdapterView = new StringBuilder();
    paramAdapterView.append("回复 ");
    if (ShortVideoCommentsView.access$800(this.a).b.length() >= 6)
    {
      paramAdapterView.append(ShortVideoCommentsView.access$800(this.a).b.substring(0, 5));
      paramAdapterView.append("...");
    }
    else
    {
      paramAdapterView.append(ShortVideoCommentsView.access$800(this.a).b);
    }
    ShortVideoCommentsView.access$400(this.a).setText("");
    ShortVideoCommentsView.access$400(this.a).setHint(paramAdapterView);
    if (ShortVideoCommentsView.access$2100(this.a))
    {
      this.a.showComment();
      return;
    }
    ShortVideoCommentsView.access$300(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.11
 * JD-Core Version:    0.7.0.1
 */