package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherEntryData;
import java.util.ArrayList;
import java.util.Iterator;

public class TogetherPopupDialog$TogetherEntryAdapter
{
  Context a;
  LinearLayout b;
  LayoutInflater c;
  View.OnClickListener d;
  ArrayList<View> e = new ArrayList();
  ArrayList<TogetherEntryData> f = new ArrayList(4);
  ArrayList<TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener> g = new ArrayList();
  
  public TogetherPopupDialog$TogetherEntryAdapter(Context paramContext, View.OnClickListener paramOnClickListener, LinearLayout paramLinearLayout)
  {
    this.a = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.d = paramOnClickListener;
    this.b = paramLinearLayout;
  }
  
  public int a()
  {
    ArrayList localArrayList = this.f;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public void a(int paramInt)
  {
    TogetherPopupDialog.TogetherEntryHolder localTogetherEntryHolder = new TogetherPopupDialog.TogetherEntryHolder();
    Object localObject = this.c;
    TogetherEntryData localTogetherEntryData = null;
    View localView = ((LayoutInflater)localObject).inflate(2131627657, null);
    localTogetherEntryHolder.a(localView);
    localTogetherEntryHolder.b(localView);
    this.g.add(new TogetherPopupDialog.TogetherEntryAdapter.1(this, localTogetherEntryHolder));
    paramInt *= 2;
    if (paramInt < this.f.size())
    {
      ((TogetherEntryData)this.f.get(paramInt)).a(TogetherControlManager.a(((BaseActivity)this.a).app).c(((TogetherEntryData)this.f.get(paramInt)).g));
      localObject = (TogetherEntryData)this.f.get(paramInt);
    }
    else
    {
      localObject = null;
    }
    paramInt += 1;
    if (paramInt < this.f.size())
    {
      ((TogetherEntryData)this.f.get(paramInt)).a(TogetherControlManager.a(((BaseActivity)this.a).app).c(((TogetherEntryData)this.f.get(paramInt)).g));
      localTogetherEntryData = (TogetherEntryData)this.f.get(paramInt);
    }
    if (localObject == null)
    {
      localTogetherEntryHolder.a.a.setVisibility(4);
    }
    else
    {
      localTogetherEntryHolder.a.a.setVisibility(0);
      localTogetherEntryHolder.a((TogetherEntryData)localObject, this.d, this.a);
    }
    if (localTogetherEntryData == null)
    {
      localTogetherEntryHolder.b.a.setVisibility(4);
    }
    else
    {
      localTogetherEntryHolder.b.a.setVisibility(0);
      localTogetherEntryHolder.b(localTogetherEntryData, this.d, this.a);
    }
    this.b.addView(localView);
  }
  
  public void a(ArrayList<TogetherEntryData> paramArrayList)
  {
    this.f.clear();
    this.f.addAll(paramArrayList);
    b();
  }
  
  public void b()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (this.g == null) {
        return;
      }
      ((LinearLayout)localObject).removeAllViews();
      localObject = this.g.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)((Iterator)localObject).next();
        if (localOnStateChangeListener != null) {
          localOnStateChangeListener.c();
        }
      }
      this.g.clear();
      int j = this.f.size();
      int k = this.f.size() / 2;
      int i = 0;
      while (i < j % 2 + k)
      {
        a(i);
        i += 1;
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)localIterator.next();
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.b();
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)localIterator.next();
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.a();
      }
    }
  }
  
  public void e()
  {
    Object localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)((Iterator)localObject).next();
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.c();
      }
    }
    this.g.clear();
    localObject = this.b;
    if (localObject != null)
    {
      ((LinearLayout)localObject).removeAllViews();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog.TogetherEntryAdapter
 * JD-Core Version:    0.7.0.1
 */