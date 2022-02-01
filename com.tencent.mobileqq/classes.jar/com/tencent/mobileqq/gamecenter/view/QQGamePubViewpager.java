package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class QQGamePubViewpager
  extends ViewPager
{
  private ViewGroup a;
  
  public QQGamePubViewpager(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQGamePubViewpager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.requestDisallowInterceptTouchEvent(true);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.a != null) {
        this.a.requestDisallowInterceptTouchEvent(true);
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      QLog.d("QQGamePubViewpager", 1, "QQGamePubViewpager onTouchEvent throwable:" + paramMotionEvent.getMessage());
    }
    return true;
  }
  
  public void setNestedpParent(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager
 * JD-Core Version:    0.7.0.1
 */