package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.qphone.base.util.QLog;

public class VideoFeedsLayoutManager
  extends LinearLayoutManager
{
  private VideoFeedsRecyclerView a;
  
  public VideoFeedsLayoutManager(Context paramContext, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
    this.a = paramVideoFeedsRecyclerView;
  }
  
  private boolean a(View paramView)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    int i = this.a.getChildViewHolder(paramView).getLayoutPosition();
    int j = this.a.b();
    boolean bool1 = bool2;
    if (j >= 0) {
      if (i != j + 1)
      {
        bool1 = bool2;
        if (i != j - 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    return super.getExtraLayoutSpace(paramState) + 200;
  }
  
  public void removeAndRecycleView(View paramView, RecyclerView.Recycler paramRecycler)
  {
    if (!a(paramView)) {
      super.removeAndRecycleView(paramView, paramRecycler);
    }
  }
  
  public void removeAndRecycleViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    if (!a(getChildAt(paramInt))) {
      super.removeAndRecycleViewAt(paramInt, paramRecycler);
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
      return paramInt;
    }
    catch (Exception paramRecycler)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFeedsLayoutManager", 2, "scrollVerticallyBy: ", paramRecycler);
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLayoutManager
 * JD-Core Version:    0.7.0.1
 */