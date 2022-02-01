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
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<TogetherEntryData> b = new ArrayList(4);
  ArrayList<TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener> c = new ArrayList();
  
  public TogetherPopupDialog$TogetherEntryAdapter(Context paramContext, View.OnClickListener paramOnClickListener, LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
  }
  
  public int a()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null)
    {
      if (this.c == null) {
        return;
      }
      ((LinearLayout)localObject).removeAllViews();
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)((Iterator)localObject).next();
        if (localOnStateChangeListener != null) {
          localOnStateChangeListener.c();
        }
      }
      this.c.clear();
      int j = this.b.size();
      int k = this.b.size() / 2;
      int i = 0;
      while (i < j % 2 + k)
      {
        a(i);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    TogetherPopupDialog.TogetherEntryHolder localTogetherEntryHolder = new TogetherPopupDialog.TogetherEntryHolder();
    Object localObject = this.jdField_a_of_type_AndroidViewLayoutInflater;
    TogetherEntryData localTogetherEntryData = null;
    View localView = ((LayoutInflater)localObject).inflate(2131561301, null);
    localTogetherEntryHolder.a(localView);
    localTogetherEntryHolder.b(localView);
    this.c.add(new TogetherPopupDialog.TogetherEntryAdapter.1(this, localTogetherEntryHolder));
    paramInt *= 2;
    if (paramInt < this.b.size())
    {
      ((TogetherEntryData)this.b.get(paramInt)).a(TogetherControlManager.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((TogetherEntryData)this.b.get(paramInt)).b));
      localObject = (TogetherEntryData)this.b.get(paramInt);
    }
    else
    {
      localObject = null;
    }
    paramInt += 1;
    if (paramInt < this.b.size())
    {
      ((TogetherEntryData)this.b.get(paramInt)).a(TogetherControlManager.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((TogetherEntryData)this.b.get(paramInt)).b));
      localTogetherEntryData = (TogetherEntryData)this.b.get(paramInt);
    }
    if (localObject == null)
    {
      localTogetherEntryHolder.a.a.setVisibility(4);
    }
    else
    {
      localTogetherEntryHolder.a.a.setVisibility(0);
      localTogetherEntryHolder.a((TogetherEntryData)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidContentContext);
    }
    if (localTogetherEntryData == null)
    {
      localTogetherEntryHolder.b.a.setVisibility(4);
    }
    else
    {
      localTogetherEntryHolder.b.a.setVisibility(0);
      localTogetherEntryHolder.b(localTogetherEntryData, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  public void a(ArrayList<TogetherEntryData> paramArrayList)
  {
    this.b.clear();
    this.b.addAll(paramArrayList);
    a();
  }
  
  public void b()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)localIterator.next();
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.b();
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)localIterator.next();
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.a();
      }
    }
  }
  
  public void d()
  {
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)((Iterator)localObject).next();
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.c();
      }
    }
    this.c.clear();
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null)
    {
      ((LinearLayout)localObject).removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog.TogetherEntryAdapter
 * JD-Core Version:    0.7.0.1
 */