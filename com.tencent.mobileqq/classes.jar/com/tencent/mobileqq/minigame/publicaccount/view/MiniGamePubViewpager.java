package com.tencent.mobileqq.minigame.publicaccount.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

public class MiniGamePubViewpager
  extends ViewPager
{
  private static final String TAG = "QQGamePubViewpager";
  private ViewGroup parent;
  
  public MiniGamePubViewpager(Context paramContext)
  {
    super(paramContext);
  }
  
  public MiniGamePubViewpager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup = this.parent;
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup = this.parent;
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(true);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.parent != null) {
        this.parent.requestDisallowInterceptTouchEvent(true);
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQGamePubViewpager onTouchEvent throwable:");
      localStringBuilder.append(paramMotionEvent.getMessage());
      QLog.d("QQGamePubViewpager", 1, localStringBuilder.toString());
    }
    return true;
  }
  
  public void postDraw()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void setNestedpParent(ViewGroup paramViewGroup)
  {
    this.parent = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.view.MiniGamePubViewpager
 * JD-Core Version:    0.7.0.1
 */