package com.tencent.mobileqq.hiboom;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class HiBoomPanelView$HiBoomAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  List<Integer> a = new ArrayList();
  
  public HiBoomPanelView$HiBoomAdapter(HiBoomPanelView paramHiBoomPanelView)
  {
    this.a.add(Integer.valueOf(-1));
  }
  
  public int a(int paramInt)
  {
    return ((Integer)this.a.get(paramInt)).intValue();
  }
  
  public void a(List<Integer> paramList1, List<Integer> paramList2, List<Integer> paramList3)
  {
    this.a.clear();
    if (paramList1 != null) {
      this.a.addAll(paramList1);
    }
    if ((paramList2 != null) && (paramList2.size() > 0)) {
      this.a.addAll(paramList2);
    }
    if ((paramList3 != null) && (paramList3.size() > 0)) {
      this.a.addAll(paramList3);
    }
    this.a.add(Integer.valueOf(-1));
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt) == -2) {
      return 2;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof HiBoomPanelView.HiBoomViewHolder))
    {
      HiBoomPanelView.HiBoomViewHolder localHiBoomViewHolder = (HiBoomPanelView.HiBoomViewHolder)paramViewHolder;
      localHiBoomViewHolder.h = paramInt;
      if (localHiBoomViewHolder.i)
      {
        int i = a(paramInt);
        ViewGroup.LayoutParams localLayoutParams = localHiBoomViewHolder.itemView.getLayoutParams();
        localLayoutParams.height = HiBoomPanelView.b;
        localLayoutParams.width = HiBoomPanelView.c;
        localHiBoomViewHolder.itemView.setPadding(0, 0, HiBoomPanelView.d, HiBoomPanelView.d);
        localLayoutParams = localHiBoomViewHolder.a.getLayoutParams();
        localLayoutParams.width = (HiBoomPanelView.c - HiBoomPanelView.d - HiBoomPanelView.e * 2);
        localLayoutParams.height = localLayoutParams.width;
        this.b.a(localHiBoomViewHolder, i);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    if (paramInt != 1) {
      return null;
    }
    boolean bool = false;
    try
    {
      paramViewGroup = LayoutInflater.from(this.b.getContext()).inflate(2131629651, paramViewGroup, false);
      bool = true;
    }
    catch (Exception paramViewGroup)
    {
      QLog.e("HiBoomFont.HiBoomPanelView", 1, "inflate hiboom item error: ", paramViewGroup);
      paramViewGroup = (ViewGroup)localObject;
    }
    localObject = paramViewGroup;
    if (paramViewGroup == null) {
      localObject = new View(this.b.getContext());
    }
    return new HiBoomPanelView.HiBoomViewHolder(this.b, (View)localObject, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView.HiBoomAdapter
 * JD-Core Version:    0.7.0.1
 */