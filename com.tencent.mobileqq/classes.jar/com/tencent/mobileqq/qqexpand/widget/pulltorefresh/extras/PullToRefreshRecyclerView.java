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
  
  private int d()
  {
    View localView = ((RecyclerView)this.a).getChildAt(0);
    if (localView != null) {
      return ((RecyclerView)this.a).getChildPosition(localView);
    }
    return -1;
  }
  
  private int e()
  {
    View localView = ((RecyclerView)this.a).getChildAt(((RecyclerView)this.a).getChildCount() - 1);
    if (localView != null) {
      return ((RecyclerView)this.a).getChildPosition(localView);
    }
    return -1;
  }
  
  private boolean e()
  {
    RecyclerView.Adapter localAdapter = ((RecyclerView)a()).getAdapter();
    if (localAdapter != null)
    {
      if (localAdapter.getItemCount() == 0) {
        return true;
      }
      if (d() == 0) {
        return ((RecyclerView)this.a).getChildAt(0).getTop() >= ((RecyclerView)this.a).getTop();
      }
      return false;
    }
    return true;
  }
  
  private boolean f()
  {
    RecyclerView.Adapter localAdapter = ((RecyclerView)a()).getAdapter();
    if (localAdapter != null)
    {
      if (localAdapter.getItemCount() == 0) {
        return true;
      }
      if (e() >= ((RecyclerView)this.a).getAdapter().getItemCount() - 1) {
        return ((RecyclerView)this.a).getChildAt(((RecyclerView)this.a).getChildCount() - 1).getBottom() <= ((RecyclerView)this.a).getBottom();
      }
      return false;
    }
    return true;
  }
  
  protected RecyclerView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView(paramContext, paramAttributeSet);
  }
  
  public final PullToRefreshBase.Orientation a()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  protected boolean a()
  {
    return e();
  }
  
  protected boolean b()
  {
    return f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView
 * JD-Core Version:    0.7.0.1
 */