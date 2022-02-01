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
    return new -..Lambda.BottomTabSettingFragment.BottomTabListAdapter._Jevyf8tWXYWKrUodELUX-dDDDU(this, paramInt);
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
    FormSimpleItem localFormSimpleItem = new FormSimpleItem(this.a.getQBaseActivity());
    if (paramInt == BottomTabSettingFragment.b(this.a)) {
      localFormSimpleItem.setRightIcon(this.a.getResources().getDrawable(2130846138), ScreenUtil.dip2px(16.0F), ScreenUtil.dip2px(16.0F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BottomTabSettingFragment.BottomTabListAdapter
 * JD-Core Version:    0.7.0.1
 */