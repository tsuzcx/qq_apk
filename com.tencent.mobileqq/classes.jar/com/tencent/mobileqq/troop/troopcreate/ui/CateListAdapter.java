package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class CateListAdapter
  extends BaseAdapter
{
  public static final String a = HardCodeUtil.a(2131899700);
  public static final String b = HardCodeUtil.a(2131899701);
  protected ArrayList<TroopCateListProvider.TroopCateInfo> c = new ArrayList();
  protected Context d;
  protected NewTroopCateView e;
  protected LayoutInflater f;
  protected AppInterface g;
  
  public CateListAdapter(NewTroopCateView paramNewTroopCateView, AppInterface paramAppInterface)
  {
    this.d = paramNewTroopCateView.a;
    this.e = paramNewTroopCateView;
    this.f = LayoutInflater.from(this.d);
    this.g = paramAppInterface;
  }
  
  public void a(ArrayList<TroopCateListProvider.TroopCateInfo> paramArrayList)
  {
    this.c = paramArrayList;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.f.inflate(2131626678, null);
      paramView = new CateListAdapter.ViewHolder(this, localView);
      localView.setTag(paramView);
    }
    else
    {
      CateListAdapter.ViewHolder localViewHolder = (CateListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    paramView.a((TroopCateListProvider.TroopCateInfo)this.c.get(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.CateListAdapter
 * JD-Core Version:    0.7.0.1
 */