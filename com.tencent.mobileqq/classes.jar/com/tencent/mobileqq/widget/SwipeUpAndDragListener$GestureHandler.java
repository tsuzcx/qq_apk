package com.tencent.mobileqq.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRectImageView;
import mqq.os.MqqHandler;

class SwipeUpAndDragListener$GestureHandler
{
  RelativeLayout A;
  RoundRectImageView B;
  Animation.AnimationListener C;
  Runnable D;
  Runnable E;
  AlphaAnimation F;
  Context p;
  ViewGroup q;
  int[] r;
  RelativeLayout s;
  RelativeLayout.LayoutParams t;
  RelativeLayout u;
  RelativeLayout.LayoutParams v;
  PhotoListPanel.PhotoPanelAdapter.RecyclerHolder w;
  int[] x;
  int y;
  AlphaAnimation z;
  
  public SwipeUpAndDragListener$GestureHandler(SwipeUpAndDragListener paramSwipeUpAndDragListener, Context paramContext, ViewGroup paramViewGroup)
  {
    this.p = paramContext;
    this.q = paramViewGroup;
    this.r = new int[2];
    this.x = new int[2];
    paramViewGroup.getLocationInWindow(this.r);
    this.s = new RelativeLayout(paramContext);
    this.s.setBackgroundResource(17170445);
    this.s.setOnTouchListener(new SwipeUpAndDragListener.GestureHandler.1(this, paramSwipeUpAndDragListener));
    this.t = new RelativeLayout.LayoutParams(-1, -1);
    this.t.topMargin = paramSwipeUpAndDragListener.h;
    this.u = new RelativeLayout(paramContext);
    this.u.setBackgroundColor(637534208);
    this.B = new RoundRectImageView(paramContext);
    this.z = new AlphaAnimation(1.0F, 0.0F);
    this.z.setFillAfter(true);
    this.F = new AlphaAnimation(0.0F, 1.0F);
    this.C = new SwipeUpAndDragListener.GestureHandler.2(this, paramSwipeUpAndDragListener);
    this.D = new SwipeUpAndDragListener.GestureHandler.3(this, paramSwipeUpAndDragListener);
    this.E = new SwipeUpAndDragListener.GestureHandler.4(this, paramSwipeUpAndDragListener);
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  boolean a(PhotoListPanel.PhotoPanelAdapter.RecyclerHolder paramRecyclerHolder, int paramInt)
  {
    SwipeUpAndDragListener localSwipeUpAndDragListener = this.G;
    localSwipeUpAndDragListener.f = true;
    localSwipeUpAndDragListener.z.r().setMotionEventSplittingEnabled(false);
    this.w = paramRecyclerHolder;
    this.y = paramInt;
    paramRecyclerHolder.itemView.getLocationInWindow(this.x);
    paramRecyclerHolder = this.w.b.getDrawable();
    this.B.setImageDrawable(paramRecyclerHolder);
    this.B.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return true;
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handler = ");
    localStringBuilder.append(this);
    QLog.d("PhotoListPanel", 1, new Object[] { "clear", localStringBuilder.toString() });
    try
    {
      this.w.itemView.clearAnimation();
      this.s.removeAllViews();
      this.q.removeView(this.s);
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
    if (this.A != null)
    {
      ThreadManager.getUIHandler().postDelayed(this.D, 50L);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(this.E, 100L);
  }
  
  boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  boolean d()
  {
    RelativeLayout localRelativeLayout = this.s;
    return (localRelativeLayout != null) && (this.q.indexOfChild(localRelativeLayout) != -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.GestureHandler
 * JD-Core Version:    0.7.0.1
 */