package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class HomeWorkTroopSelectorFragment$HwTroopAdapter
  extends BaseAdapter
{
  List<HomeWorkTroopSelectorFragment.MyPair<TroopInfo, Boolean>> a;
  private Activity b;
  private String c;
  
  HomeWorkTroopSelectorFragment$HwTroopAdapter(Activity paramActivity, List<TroopInfo> paramList, TroopInfo paramTroopInfo, List<String> paramList1)
  {
    this.b = paramActivity;
    this.a = new ArrayList();
    if (paramTroopInfo != null)
    {
      this.a.add(new HomeWorkTroopSelectorFragment.MyPair(paramTroopInfo, Boolean.valueOf(true)));
      this.c = paramTroopInfo.troopuin;
      if (this.c == null) {
        this.c = "";
      }
    }
    if (paramList != null)
    {
      paramActivity = paramList.iterator();
      while (paramActivity.hasNext())
      {
        paramList = (TroopInfo)paramActivity.next();
        if (paramList != null)
        {
          boolean bool;
          if ((paramList1 != null) && (paramList1.contains(paramList.troopuin))) {
            bool = true;
          } else {
            bool = false;
          }
          this.a.add(new HomeWorkTroopSelectorFragment.MyPair(paramList, Boolean.valueOf(bool)));
        }
      }
    }
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
    HomeWorkTroopSelectorFragment.MyPair localMyPair = (HomeWorkTroopSelectorFragment.MyPair)getItem(paramInt);
    HomeWorkTroopSelectorFragment.HwTroopAdapter.ViewHolder localViewHolder;
    if (paramView != null)
    {
      localViewHolder = (HomeWorkTroopSelectorFragment.HwTroopAdapter.ViewHolder)paramView.getTag();
    }
    else
    {
      localViewHolder = new HomeWorkTroopSelectorFragment.HwTroopAdapter.ViewHolder();
      paramView = new LinearLayout(this.b);
      paramView.setMinimumHeight(ScreenUtil.dip2px(48.0F));
      paramView.setOrientation(0);
      paramView.setGravity(16);
      localViewHolder.a = new CheckBox(this.b);
      localViewHolder.a.setButtonDrawable(2130839226);
      Object localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(ScreenUtil.dip2px(12.0F), 0, 0, 0);
      localViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(this.b);
      Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).setMargins(ScreenUtil.dip2px(12.0F), 0, ScreenUtil.dip2px(12.0F), 0);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((LinearLayout)localObject1).setOrientation(1);
      localViewHolder.b = new TextView(this.b);
      localViewHolder.b.setTextColor(-16777216);
      localViewHolder.b.setTextSize(1, 16.0F);
      localViewHolder.b.setGravity(16);
      localObject2 = new LinearLayout.LayoutParams(-1, 0);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      localViewHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new View(this.b);
      ((View)localObject2).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#dedfe0")));
      ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
      ((LinearLayout)localObject1).addView(localViewHolder.b);
      ((LinearLayout)localObject1).addView((View)localObject2);
      paramView.addView(localViewHolder.a);
      paramView.addView((View)localObject1);
      paramView.setClickable(true);
      paramView.setTag(localViewHolder);
    }
    paramView.setOnClickListener(null);
    localViewHolder.a.setOnCheckedChangeListener(null);
    localViewHolder.a.setChecked(((Boolean)localMyPair.b).booleanValue());
    localViewHolder.a.setEnabled(true ^ ((TroopInfo)localMyPair.a).troopuin.equals(this.c));
    localViewHolder.a.setOnCheckedChangeListener(new HomeWorkTroopSelectorFragment.HwTroopAdapter.1(this, localMyPair));
    paramView.setOnClickListener(new HomeWorkTroopSelectorFragment.HwTroopAdapter.2(this, localViewHolder.a));
    localViewHolder.b.setText(((TroopInfo)localMyPair.a).troopname);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.HwTroopAdapter
 * JD-Core Version:    0.7.0.1
 */