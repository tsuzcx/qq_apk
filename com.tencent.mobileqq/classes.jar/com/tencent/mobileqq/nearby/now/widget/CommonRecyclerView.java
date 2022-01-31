package com.tencent.mobileqq.nearby.now.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View;
import avep;
import aver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommonRecyclerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int = -1;
  private List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<View> b = new ArrayList();
  
  public CommonRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @Nullable
  public aver a()
  {
    if (getAdapter() == null) {
      return null;
    }
    if ((((avep)getAdapter()).a() instanceof aver)) {
      return (aver)((avep)getAdapter()).a();
    }
    return null;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    if (paramAdapter == null) {
      super.setAdapter(null);
    }
    for (;;)
    {
      return;
      if ((a() == null) || (paramAdapter != a()))
      {
        if (!(paramAdapter instanceof aver)) {
          throw new IllegalArgumentException("adapter must extends CommonAdapter");
        }
        super.setAdapter(new avep(paramAdapter));
        View localView;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          paramAdapter = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramAdapter.hasNext())
          {
            localView = (View)paramAdapter.next();
            ((avep)getAdapter()).a(localView);
          }
        }
        if (this.b.size() <= 0) {
          break;
        }
        paramAdapter = this.b.iterator();
        while (paramAdapter.hasNext())
        {
          localView = (View)paramAdapter.next();
          ((avep)getAdapter()).b(localView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonRecyclerView
 * JD-Core Version:    0.7.0.1
 */