package com.tencent.mobileqq.mini.entry.desktop;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class MiniAppDesktopLayout$MiniAppGridLayoutManager
  extends GridLayoutManager
{
  public MiniAppDesktopLayout$MiniAppGridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
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
      QLog.e("MicroAppEntryLayout", 1, "onLayoutChildren, exception: " + Log.getStackTraceString(paramRecycler));
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
      QLog.e("MicroAppEntryLayout", 1, "scrollHorizontallyBy, exception: " + Log.getStackTraceString(paramRecycler));
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout.MiniAppGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */