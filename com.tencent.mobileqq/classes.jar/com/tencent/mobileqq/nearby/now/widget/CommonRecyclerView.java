package com.tencent.mobileqq.nearby.now.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommonRecyclerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int = -1;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private List b = new ArrayList();
  
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
  public CommonAdapter a()
  {
    if (getAdapter() == null) {
      return null;
    }
    if ((((AdapterWrapper)getAdapter()).a() instanceof CommonAdapter)) {
      return (CommonAdapter)((AdapterWrapper)getAdapter()).a();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
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
        if (!(paramAdapter instanceof CommonAdapter)) {
          throw new IllegalArgumentException("adapter must extends CommonAdapter");
        }
        super.setAdapter(new AdapterWrapper(paramAdapter));
        View localView;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          paramAdapter = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramAdapter.hasNext())
          {
            localView = (View)paramAdapter.next();
            ((AdapterWrapper)getAdapter()).a(localView);
          }
        }
        if (this.b.size() <= 0) {
          break;
        }
        paramAdapter = this.b.iterator();
        while (paramAdapter.hasNext())
        {
          localView = (View)paramAdapter.next();
          ((AdapterWrapper)getAdapter()).b(localView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonRecyclerView
 * JD-Core Version:    0.7.0.1
 */