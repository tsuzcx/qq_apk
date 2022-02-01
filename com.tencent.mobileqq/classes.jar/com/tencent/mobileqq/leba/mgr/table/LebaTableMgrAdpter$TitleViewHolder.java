package com.tencent.mobileqq.leba.mgr.table;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.leba.entity.LebaMgrViewItem;

public class LebaTableMgrAdpter$TitleViewHolder
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public LebaTableMgrAdpter$TitleViewHolder(Context paramContext, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131379432));
    if (paramBoolean)
    {
      this.a.setTextColor(paramContext.getResources().getColor(2131165777));
      return;
    }
    this.a.setTextColor(paramContext.getResources().getColor(2131165776));
  }
  
  public void a(LebaMgrViewItem paramLebaMgrViewItem)
  {
    if (TextUtils.isEmpty(paramLebaMgrViewItem.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(paramLebaMgrViewItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaTableMgrAdpter.TitleViewHolder
 * JD-Core Version:    0.7.0.1
 */