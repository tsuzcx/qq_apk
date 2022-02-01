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
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.c == null)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)localIterator.next();
        if (localOnStateChangeListener != null) {
          localOnStateChangeListener.c();
        }
      }
      this.c.clear();
      int j = this.b.size();
      int k = this.b.size() / 2;
      int i = 0;
      while (i < k + j % 2)
      {
        a(i);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    TogetherPopupDialog.TogetherEntryHolder localTogetherEntryHolder = new TogetherPopupDialog.TogetherEntryHolder();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561458, null);
    localTogetherEntryHolder.a(localView);
    localTogetherEntryHolder.b(localView);
    this.c.add(new TogetherPopupDialog.TogetherEntryAdapter.1(this, localTogetherEntryHolder));
    if (paramInt * 2 < this.b.size()) {
      ((TogetherEntryData)this.b.get(paramInt * 2)).a(TogetherControlManager.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((TogetherEntryData)this.b.get(paramInt * 2)).b));
    }
    for (TogetherEntryData localTogetherEntryData1 = (TogetherEntryData)this.b.get(paramInt * 2);; localTogetherEntryData1 = null)
    {
      if (paramInt * 2 + 1 < this.b.size()) {
        ((TogetherEntryData)this.b.get(paramInt * 2 + 1)).a(TogetherControlManager.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app).a(((TogetherEntryData)this.b.get(paramInt * 2 + 1)).b));
      }
      for (TogetherEntryData localTogetherEntryData2 = (TogetherEntryData)this.b.get(paramInt * 2 + 1);; localTogetherEntryData2 = null)
      {
        if (localTogetherEntryData1 == null)
        {
          localTogetherEntryHolder.a.a.setVisibility(4);
          if (localTogetherEntryData2 != null) {
            break label282;
          }
          localTogetherEntryHolder.b.a.setVisibility(4);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          return;
          localTogetherEntryHolder.a.a.setVisibility(0);
          localTogetherEntryHolder.a(localTogetherEntryData1, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidContentContext);
          break;
          label282:
          localTogetherEntryHolder.b.a.setVisibility(0);
          localTogetherEntryHolder.b(localTogetherEntryData2, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidContentContext);
        }
      }
    }
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
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener localOnStateChangeListener = (TogetherPopupDialog.TogetherEntryAdapter.OnStateChangeListener)localIterator.next();
      if (localOnStateChangeListener != null) {
        localOnStateChangeListener.c();
      }
    }
    this.c.clear();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog.TogetherEntryAdapter
 * JD-Core Version:    0.7.0.1
 */