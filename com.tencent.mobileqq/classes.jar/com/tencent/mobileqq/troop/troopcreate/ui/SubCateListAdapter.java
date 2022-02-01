package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class SubCateListAdapter
  extends BaseAdapter
{
  protected ArrayList<TroopCateListProvider.TroopCateInfo> a = new ArrayList();
  protected Context b;
  protected LayoutInflater c;
  protected View.OnClickListener d;
  protected TroopCateListProvider.TroopCateInfo e;
  protected int f = -1;
  
  public SubCateListAdapter(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.b = paramContext;
    this.c = LayoutInflater.from(this.b);
    this.d = paramOnClickListener;
  }
  
  public void a(TroopCateListProvider.TroopCateInfo paramTroopCateInfo)
  {
    this.e = paramTroopCateInfo;
    this.a = paramTroopCateInfo.g;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopCateListProvider.TroopCateInfo localTroopCateInfo = (TroopCateListProvider.TroopCateInfo)this.a.get(paramInt);
    SubCateListAdapter.ViewHolder localViewHolder = new SubCateListAdapter.ViewHolder();
    if (paramView != null)
    {
      localViewHolder = (SubCateListAdapter.ViewHolder)paramView.getTag();
    }
    else
    {
      paramView = this.c.inflate(2131626680, null);
      localViewHolder.a = ((TextView)paramView.findViewById(2131447062));
      paramView.setTag(localViewHolder);
    }
    localViewHolder.a.setText(localTroopCateInfo.b);
    localViewHolder.a.setTag(localTroopCateInfo);
    if (this.d != null) {
      localViewHolder.a.setOnClickListener(this.d);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.SubCateListAdapter
 * JD-Core Version:    0.7.0.1
 */