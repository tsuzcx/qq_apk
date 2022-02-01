package com.tencent.mobileqq.leba.business;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.mobileqq.leba.entity.LebaMgrViewItem;
import java.util.List;

public abstract interface ILebaTableMgrItemBiz
{
  public abstract RecyclerView.ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt, boolean paramBoolean);
  
  public abstract void a(Context paramContext, List<LebaMgrViewItem> paramList);
  
  public abstract boolean a(RecyclerView.ViewHolder paramViewHolder, LebaMgrViewItem paramLebaMgrViewItem, Context paramContext, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.ILebaTableMgrItemBiz
 * JD-Core Version:    0.7.0.1
 */