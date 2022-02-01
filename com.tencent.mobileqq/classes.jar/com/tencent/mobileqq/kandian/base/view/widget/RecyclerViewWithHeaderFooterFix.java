package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.widget.pull2refresh.HeaderSpanSizeLookup;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter.ContentDataObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewWithHeaderFooterFix
  extends RecyclerViewCompat
{
  private RecyclerViewHeaderViewAdapter.ContentDataObserver jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewHeaderViewAdapter$ContentDataObserver;
  private final List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private final List<View> b = new ArrayList();
  
  public RecyclerViewWithHeaderFooterFix(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public RecyclerViewWithHeaderFooterFix(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public RecyclerViewWithHeaderFooterFix(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramView);
  }
  
  public void b(View paramView)
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
      localObject = new RecyclerViewWithHeaderFooterFix.1(this, paramAdapter);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).addHeader((View)localIterator.next());
      }
      localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).addFooter((View)localIterator.next());
      }
      ((RecyclerViewHeaderViewAdapter)localObject).setHasStableIds(paramAdapter.hasStableIds());
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramAdapter = (GridLayoutManager)getLayoutManager();
        paramAdapter.setSpanSizeLookup(new HeaderSpanSizeLookup((RecyclerViewHeaderViewAdapter)localObject, paramAdapter));
      }
      paramAdapter = this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewHeaderViewAdapter$ContentDataObserver;
      if (paramAdapter != null) {
        ((RecyclerViewHeaderViewAdapter)localObject).setContentDataObserver(paramAdapter);
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    if ((getAdapter() != null) && ((getAdapter() instanceof RecyclerViewHeaderViewAdapter)))
    {
      Object localObject = (RecyclerViewHeaderViewAdapter)getAdapter();
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramLayoutManager = (GridLayoutManager)getLayoutManager();
        localObject = new HeaderSpanSizeLookup((RecyclerViewHeaderViewAdapter)localObject, paramLayoutManager);
        ((HeaderSpanSizeLookup)localObject).setSpanSizeLookup(paramLayoutManager.getSpanSizeLookup());
        paramLayoutManager.setSpanSizeLookup((GridLayoutManager.SpanSizeLookup)localObject);
      }
    }
  }
  
  public void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    super.setRecycledViewPool(new RecyclerViewWithHeaderFooterFix.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RecyclerViewWithHeaderFooterFix
 * JD-Core Version:    0.7.0.1
 */