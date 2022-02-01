package com.tencent.mobileqq.qqgift.mvvm.business.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelBaseViewModel;
import java.util.ArrayList;
import java.util.List;

public class QQGiftPanelPageAdapter
  extends RecyclerView.Adapter<QQGiftPanelPageAdapter.MyViewHolder>
{
  protected final Context b;
  protected final List<List<GiftServiceData>> c = new ArrayList();
  protected final QQGiftPanelBaseViewModel d;
  
  public QQGiftPanelPageAdapter(Context paramContext, QQGiftPanelBaseViewModel paramQQGiftPanelBaseViewModel)
  {
    this.b = paramContext;
    this.d = paramQQGiftPanelBaseViewModel;
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected QQGiftPanelGridAdapter a(Context paramContext, QQGiftPanelBaseViewModel paramQQGiftPanelBaseViewModel)
  {
    return new QQGiftPanelGridAdapter(paramContext, paramQQGiftPanelBaseViewModel);
  }
  
  @NonNull
  public QQGiftPanelPageAdapter.MyViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new GridView(this.b);
    paramViewGroup.setGravity(17);
    paramViewGroup.setNumColumns(4);
    paramViewGroup.setVerticalSpacing(b());
    paramViewGroup.setHorizontalSpacing(a());
    paramViewGroup.setSelector(new ColorDrawable(0));
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    return new QQGiftPanelPageAdapter.MyViewHolder(paramViewGroup);
  }
  
  public void a(@NonNull QQGiftPanelPageAdapter.MyViewHolder paramMyViewHolder, int paramInt)
  {
    List localList = (List)this.c.get(paramInt);
    QQGiftPanelGridAdapter localQQGiftPanelGridAdapter = a(this.b, this.d);
    localQQGiftPanelGridAdapter.a(localList, paramInt);
    paramMyViewHolder.a.setAdapter(localQQGiftPanelGridAdapter);
    paramMyViewHolder.a.setOnItemClickListener(new QQGiftPanelPageAdapter.1(this, paramInt));
  }
  
  public void a(List<List<GiftServiceData>> paramList)
  {
    this.c.clear();
    this.c.addAll(paramList);
  }
  
  protected int b()
  {
    return 0;
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelPageAdapter
 * JD-Core Version:    0.7.0.1
 */