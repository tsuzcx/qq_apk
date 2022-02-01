package com.tencent.mobileqq.fragment;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class LangSettingFragment$LocaleListAdapter
  extends BaseAdapter
{
  public LangSettingFragment$LocaleListAdapter(LangSettingFragment paramLangSettingFragment) {}
  
  private View.OnClickListener a(int paramInt)
  {
    return new LangSettingFragment.LocaleListAdapter.1(this, paramInt);
  }
  
  private boolean b(int paramInt)
  {
    int i = LangSettingFragment.a().size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt < i)
    {
      if (paramInt < 0) {
        return false;
      }
      bool1 = bool2;
      if (((Integer)LangSettingFragment.a().get(paramInt)).intValue() == 1033) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int getCount()
  {
    return LangSettingFragment.a().size();
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
    if (paramInt == LangSettingFragment.a(this.a)) {
      localFormSimpleItem.setRightIcon(this.a.getResources().getDrawable(2130846138));
    } else {
      localFormSimpleItem.setRightIcon(null);
    }
    if (paramInt < LangSettingFragment.a().size()) {
      localFormSimpleItem.setLeftText(LangSettingFragment.a(this.a, paramInt, false));
    }
    localFormSimpleItem.setTag(Integer.valueOf(paramInt));
    localFormSimpleItem.setOnClickListener(a(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localFormSimpleItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment.LocaleListAdapter
 * JD-Core Version:    0.7.0.1
 */