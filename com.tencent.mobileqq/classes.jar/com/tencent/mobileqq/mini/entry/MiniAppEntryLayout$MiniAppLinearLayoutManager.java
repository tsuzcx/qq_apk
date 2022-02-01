package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;

class MiniAppEntryLayout$MiniAppLinearLayoutManager
  extends LinearLayoutManager
{
  public MiniAppEntryLayout$MiniAppLinearLayoutManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public MiniAppEntryLayout$MiniAppLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public MiniAppEntryLayout$MiniAppLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    }
    catch (Throwable paramRecycler)
    {
      paramState = new StringBuilder();
      paramState.append("onLayoutChildren, exception: ");
      paramState.append(Log.getStackTraceString(paramRecycler));
      QLog.e("MicroAppEntryLayout", 1, paramState.toString());
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      paramInt = super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
      return paramInt;
    }
    catch (Throwable paramRecycler)
    {
      paramState = new StringBuilder();
      paramState.append("scrollHorizontallyBy, exception: ");
      paramState.append(Log.getStackTraceString(paramRecycler));
      QLog.e("MicroAppEntryLayout", 1, paramState.toString());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryLayout.MiniAppLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */