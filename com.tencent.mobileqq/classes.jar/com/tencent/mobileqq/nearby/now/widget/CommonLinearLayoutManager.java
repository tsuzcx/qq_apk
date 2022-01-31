package com.tencent.mobileqq.nearby.now.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;

public class CommonLinearLayoutManager
  extends LinearLayoutManager
{
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    }
    catch (IndexOutOfBoundsException paramRecycler)
    {
      Log.e("CommonLLManager", "catch java.lang.IndexOutOfBoundsException: Inconsistency detected. ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */