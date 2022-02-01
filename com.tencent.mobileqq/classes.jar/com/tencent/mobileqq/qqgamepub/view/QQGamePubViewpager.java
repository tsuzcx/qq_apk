package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
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
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(true);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQGamePubViewpager onTouchEvent throwable:");
      localStringBuilder.append(paramMotionEvent.getMessage());
      QLog.d("QQGamePub_QQGamePubViewpager", 1, localStringBuilder.toString());
    }
    return true;
  }
  
  public void setNestedpParent(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager
 * JD-Core Version:    0.7.0.1
 */