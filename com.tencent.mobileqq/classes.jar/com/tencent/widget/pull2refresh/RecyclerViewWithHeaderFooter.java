package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import bltc;
import bltq;
import bltu;
import bltv;
import bltw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewWithHeaderFooter
  extends RecyclerViewCompat
{
  private bltu jdField_a_of_type_Bltu;
  private bltv jdField_a_of_type_Bltv;
  private final List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private final List<View> b = new ArrayList();
  
  public RecyclerViewWithHeaderFooter(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramView);
  }
  
  public boolean a(View paramView)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramView);
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramView);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public void c(View paramView)
  {
    this.b.add(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      super.onInterceptTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramMotionEvent.getAction() == 1) {
        this.jdField_a_of_type_Boolean = false;
      }
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
    {
      localObject = paramAdapter;
      if (this.b.size() <= 0) {}
    }
    else
    {
      localObject = new bltq(paramAdapter);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((bltq)localObject).a((View)localIterator.next());
      }
      localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((bltq)localObject).c((View)localIterator.next());
      }
      ((bltq)localObject).setHasStableIds(paramAdapter.hasStableIds());
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramAdapter = (GridLayoutManager)getLayoutManager();
        paramAdapter.setSpanSizeLookup(new bltc((bltq)localObject, paramAdapter));
      }
      if (this.jdField_a_of_type_Bltu != null) {
        ((bltq)localObject).a(this.jdField_a_of_type_Bltu);
      }
      if (this.jdField_a_of_type_Bltv != null) {
        ((bltq)localObject).a(this.jdField_a_of_type_Bltv);
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    if ((getAdapter() != null) && ((getAdapter() instanceof bltq)))
    {
      Object localObject = (bltq)getAdapter();
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramLayoutManager = (GridLayoutManager)getLayoutManager();
        localObject = new bltc((bltq)localObject, paramLayoutManager);
        ((bltc)localObject).a(paramLayoutManager.getSpanSizeLookup());
        paramLayoutManager.setSpanSizeLookup((GridLayoutManager.SpanSizeLookup)localObject);
      }
    }
  }
  
  public void setOnBindHeaderObserver(bltv parambltv)
  {
    this.jdField_a_of_type_Bltv = parambltv;
    if ((getAdapter() instanceof bltq)) {
      ((bltq)getAdapter()).a(parambltv);
    }
  }
  
  public void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    super.setRecycledViewPool(new bltw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter
 * JD-Core Version:    0.7.0.1
 */