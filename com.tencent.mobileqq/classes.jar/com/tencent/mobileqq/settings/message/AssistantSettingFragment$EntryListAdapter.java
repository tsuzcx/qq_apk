package com.tencent.mobileqq.settings.message;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class AssistantSettingFragment$EntryListAdapter
  extends BaseAdapter
{
  private boolean a;
  private Context b;
  private final List<CTEntry> c;
  private CompoundButton.OnCheckedChangeListener d;
  
  public AssistantSettingFragment$EntryListAdapter(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.b = paramContext;
    this.c = new ArrayList();
    this.d = paramOnCheckedChangeListener;
  }
  
  private void b(List<CTEntry> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        CTEntry localCTEntry = (CTEntry)paramList.get(i);
        if (((localCTEntry == null) || (localCTEntry.a == 1) || (localCTEntry.a == 2)) && (localCTEntry != null)) {
          paramList.remove(localCTEntry);
        }
        i -= 1;
      }
    }
  }
  
  public CTEntry a(short paramShort)
  {
    int i = 0;
    while (i < this.c.size())
    {
      if (((CTEntry)this.c.get(i)).j == paramShort) {
        return (CTEntry)this.c.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<CTEntry> paramList)
  {
    this.c.clear();
    if (paramList != null)
    {
      b(paramList);
      this.c.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a(short[] paramArrayOfShort)
  {
    boolean bool1 = false;
    int i = 0;
    for (;;)
    {
      if ((!bool1) && (paramArrayOfShort != null)) {
        try
        {
          if (i < paramArrayOfShort.length)
          {
            int j = 0;
            boolean bool2;
            for (;;)
            {
              bool2 = bool1;
              if (j >= this.c.size()) {
                break;
              }
              int k = paramArrayOfShort[i];
              int m = ((CTEntry)this.c.get(j)).j;
              if (k == m)
              {
                bool2 = true;
                break;
              }
              j += 1;
            }
            i += 1;
            bool1 = bool2;
          }
        }
        catch (Throwable paramArrayOfShort)
        {
          paramArrayOfShort.printStackTrace();
        }
      }
    }
    return bool1;
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount())) {
      return this.c.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    CTEntry localCTEntry = (CTEntry)getItem(paramInt);
    if (localCTEntry == null) {
      return 0L;
    }
    return localCTEntry.a;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FormMultiLineSwitchItem localFormMultiLineSwitchItem;
    if (!(paramView instanceof FormSwitchItem))
    {
      localFormMultiLineSwitchItem = new FormMultiLineSwitchItem(this.b);
      paramView = localFormMultiLineSwitchItem;
    }
    else
    {
      localFormMultiLineSwitchItem = (FormMultiLineSwitchItem)paramView;
    }
    CTEntry localCTEntry = (CTEntry)getItem(paramInt);
    if (localCTEntry != null)
    {
      localFormMultiLineSwitchItem.setText(localCTEntry.b);
      localFormMultiLineSwitchItem.setChecked(localCTEntry.m ^ true);
      if ((localCTEntry.a == 3) && (localCTEntry.m))
      {
        localFormMultiLineSwitchItem.setSecendLineText(this.b.getString(2131897012));
        localFormMultiLineSwitchItem.setSecondLineTextViewVisibility(0);
      }
      else
      {
        localFormMultiLineSwitchItem.setSecendLineText("");
        localFormMultiLineSwitchItem.setSecondLineTextViewVisibility(8);
      }
    }
    int i = getCount();
    if ((paramInt == 0) && (i == 1))
    {
      if (this.a) {
        localFormMultiLineSwitchItem.setBgType(2);
      } else {
        localFormMultiLineSwitchItem.setBgType(0);
      }
    }
    else if (paramInt == 0)
    {
      localFormMultiLineSwitchItem.setBgType(1);
    }
    else
    {
      i -= 1;
      if (paramInt == i)
      {
        if (this.a) {
          localFormMultiLineSwitchItem.setBgType(2);
        } else {
          localFormMultiLineSwitchItem.setBgType(3);
        }
      }
      else if ((paramInt > 0) && (paramInt < i)) {
        localFormMultiLineSwitchItem.setBgType(2);
      }
    }
    localFormMultiLineSwitchItem.setTag(localCTEntry);
    localFormMultiLineSwitchItem.setOnCheckedChangeListener(this.d);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.EntryListAdapter
 * JD-Core Version:    0.7.0.1
 */