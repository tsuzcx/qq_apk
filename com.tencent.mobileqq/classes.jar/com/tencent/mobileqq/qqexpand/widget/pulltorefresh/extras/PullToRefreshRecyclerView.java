package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.AnimationStyle;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Orientation;

public class PullToRefreshRecyclerView
  extends PullToRefreshBase<RecyclerView>
{
  public PullToRefreshRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshRecyclerView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  private int getFirstVisiblePosition()
  {
    View localView = ((RecyclerView)this.e).getChildAt(0);
    if (localView != null) {
      return ((RecyclerView)this.e).getChildPosition(localView);
    }
    return -1;
  }
  
  private int getLastVisiblePosition()
  {
    View localView = ((RecyclerView)this.e).getChildAt(((RecyclerView)this.e).getChildCount() - 1);
    if (localView != null) {
      return ((RecyclerView)this.e).getChildPosition(localView);
    }
    return -1;
  }
  
  private boolean l()
  {
    RecyclerView.Adapter localAdapter = ((RecyclerView)getRefreshableView()).getAdapter();
    if (localAdapter != null)
    {
      if (localAdapter.getItemCount() == 0) {
        return true;
      }
      if (getFirstVisiblePosition() == 0) {
        return ((RecyclerView)this.e).getChildAt(0).getTop() >= ((RecyclerView)this.e).getTop();
      }
      return false;
    }
    return true;
  }
  
  private boolean m()
  {
    RecyclerView.Adapter localAdapter = ((RecyclerView)getRefreshableView()).getAdapter();
    if (localAdapter != null)
    {
      if (localAdapter.getItemCount() == 0) {
        return true;
      }
      if (getLastVisiblePosition() >= ((RecyclerView)this.e).getAdapter().getItemCount() - 1) {
        return ((RecyclerView)this.e).getChildAt(((RecyclerView)this.e).getChildCount() - 1).getBottom() <= ((RecyclerView)this.e).getBottom();
      }
      return false;
    }
    return true;
  }
  
  protected RecyclerView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView(paramContext, paramAttributeSet);
  }
  
  protected boolean a()
  {
    return l();
  }
  
  protected boolean b()
  {
    return m();
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView
 * JD-Core Version:    0.7.0.1
 */