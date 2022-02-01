package com.tencent.mobileqq.leba.more;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;

public class LebaMoreAdapter$TitleViewHolder
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public LebaMoreAdapter$TitleViewHolder(Context paramContext, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131447463));
    if (paramBoolean)
    {
      this.a.setTextColor(paramContext.getResources().getColor(2131166373));
      return;
    }
    this.a.setTextColor(paramContext.getResources().getColor(2131166372));
  }
  
  public void a(LebaMoreViewItem paramLebaMoreViewItem)
  {
    if (TextUtils.isEmpty(paramLebaMoreViewItem.b)) {
      paramLebaMoreViewItem = "";
    } else {
      paramLebaMoreViewItem = paramLebaMoreViewItem.b;
    }
    if (!paramLebaMoreViewItem.equals(this.a.getText().toString())) {
      this.a.setText(paramLebaMoreViewItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreAdapter.TitleViewHolder
 * JD-Core Version:    0.7.0.1
 */