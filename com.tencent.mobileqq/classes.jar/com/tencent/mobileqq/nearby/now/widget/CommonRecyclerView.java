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
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    if (paramAdapter == null)
    {
      super.setAdapter(null);
      return;
    }
    if ((a() != null) && (paramAdapter == a())) {
      return;
    }
    if ((paramAdapter instanceof CommonAdapter))
    {
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
      if (this.b.size() > 0)
      {
        paramAdapter = this.b.iterator();
        while (paramAdapter.hasNext())
        {
          localView = (View)paramAdapter.next();
          ((AdapterWrapper)getAdapter()).b(localView);
        }
      }
      return;
    }
    paramAdapter = new IllegalArgumentException("adapter must extends CommonAdapter");
    for (;;)
    {
      throw paramAdapter;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonRecyclerView
 * JD-Core Version:    0.7.0.1
 */