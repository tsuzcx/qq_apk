package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tencent.qphone.base.util.QLog;

public class SafeLinearLayoutManager
  extends LinearLayoutManager
{
  public SafeLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public SafeLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
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
    catch (Exception paramRecycler)
    {
      QLog.e("SafeLinearLayoutManager", 1, paramRecycler, new Object[0]);
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
      return paramInt;
    }
    catch (IndexOutOfBoundsException paramRecycler)
    {
      paramRecycler.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.SafeLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */