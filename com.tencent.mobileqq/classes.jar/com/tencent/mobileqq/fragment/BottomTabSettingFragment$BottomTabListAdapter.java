package com.tencent.mobileqq.fragment;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class BottomTabSettingFragment$BottomTabListAdapter
  extends BaseAdapter
{
  public BottomTabSettingFragment$BottomTabListAdapter(BottomTabSettingFragment paramBottomTabSettingFragment) {}
  
  private View.OnClickListener a(int paramInt)
  {
    return new BottomTabSettingFragment.BottomTabListAdapter.1(this, paramInt);
  }
  
  public int getCount()
  {
    return BottomTabSettingFragment.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FormSimpleItem localFormSimpleItem = new FormSimpleItem(this.a.getBaseActivity());
    if (paramInt == BottomTabSettingFragment.a(this.a)) {
      localFormSimpleItem.setRightIcon(this.a.getResources().getDrawable(2130844706), ScreenUtil.dip2px(16.0F), ScreenUtil.dip2px(16.0F));
    } else {
      localFormSimpleItem.setRightIcon(null);
    }
    if (paramInt < BottomTabSettingFragment.a(this.a).size()) {
      localFormSimpleItem.setLeftText((CharSequence)BottomTabSettingFragment.a(this.a).get(Integer.valueOf(paramInt)));
    }
    localFormSimpleItem.setTag(Integer.valueOf(paramInt));
    localFormSimpleItem.setOnClickListener(a(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localFormSimpleItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BottomTabSettingFragment.BottomTabListAdapter
 * JD-Core Version:    0.7.0.1
 */