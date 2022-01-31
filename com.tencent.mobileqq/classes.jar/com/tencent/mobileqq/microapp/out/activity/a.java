package com.tencent.mobileqq.microapp.out.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.microapp.app.a.a;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class a
  extends BaseAdapter
{
  Context a;
  List b;
  CompoundButton.OnCheckedChangeListener c;
  
  public a(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.a = paramContext;
    this.c = paramOnCheckedChangeListener;
    LayoutInflater.from(paramContext);
    this.b = new ArrayList();
  }
  
  public a.a a(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.b.size())) {
      return (a.a)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (paramString.equals(locala.a))
      {
        if (paramBoolean) {}
        for (int i = 2;; i = 4)
        {
          locala.b = i;
          break;
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a.a locala;
    boolean bool;
    if (paramView != null)
    {
      paramView = (FormSwitchItem)paramView;
      locala = a(paramInt);
      if (locala != null)
      {
        if (locala.b != 2) {
          break label100;
        }
        bool = true;
        label33:
        paramView.setChecked(bool);
        paramView.a().setTag(locala.a);
        paramViewGroup = (String)com.tencent.mobileqq.microapp.app.a.b.get(locala.a);
        if (paramViewGroup == null) {
          break label106;
        }
      }
    }
    for (;;)
    {
      paramView.setText(paramViewGroup);
      return paramView;
      paramView = new FormSwitchItem(this.a);
      paramView.setOnCheckedChangeListener(this.c);
      break;
      label100:
      bool = false;
      break label33;
      label106:
      paramViewGroup = locala.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.a
 * JD-Core Version:    0.7.0.1
 */