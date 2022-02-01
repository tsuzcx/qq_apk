package com.tencent.mobileqq.widget;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AnimationView$Player
  implements Handler.Callback
{
  public static final int MSG_PLAY = 1;
  final int a;
  protected Handler a;
  protected WeakReference<AnimationView> a;
  final int jdField_b_of_type_Int = 1;
  boolean jdField_b_of_type_Boolean = false;
  final int c = 2;
  int d = 0;
  int e = 0;
  int f = 0;
  
  public AnimationView$Player(AnimationView paramAnimationView)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAnimationView);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  protected Drawable a(AnimationView paramAnimationView)
  {
    if ((paramAnimationView != null) && (paramAnimationView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo != null))
    {
      paramAnimationView = paramAnimationView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      if (this.d == 2) {
        return null;
      }
      if (paramAnimationView.mOneCycleFrames.size() <= 0)
      {
        this.d = 2;
        return null;
      }
      int i = this.e;
      if ((i >= 0) && (i <= paramAnimationView.mOneCycleFrames.size()))
      {
        int k = this.e + 1;
        int m = 0;
        i = k;
        int j = m;
        if (paramAnimationView.mInfiniteFromInOnCycle > 0)
        {
          i = k;
          j = m;
          if (paramAnimationView.mInfiniteToInOnCycle > 0)
          {
            i = k;
            j = m;
            if (paramAnimationView.mInfiniteToInOnCycle > paramAnimationView.mInfiniteFromInOnCycle)
            {
              i = k;
              if (this.e == paramAnimationView.mInfiniteToInOnCycle) {
                i = paramAnimationView.mInfiniteFromInOnCycle;
              }
              j = 1;
            }
          }
        }
        if (i > paramAnimationView.mOneCycleFrames.size())
        {
          if (paramAnimationView.mCycle < 0) {
            this.d = 2;
          } else if ((paramAnimationView.mCycle != 0) && (this.f >= paramAnimationView.mCycle)) {
            this.d = 2;
          }
          if (this.d == 2) {
            return null;
          }
          k = 1;
        }
        else
        {
          k = i;
          if (i == paramAnimationView.mOneCycleFrames.size())
          {
            k = i;
            if (j == 0)
            {
              this.f += 1;
              k = i;
            }
          }
        }
        this.e = k;
        i = ((Integer)paramAnimationView.mOneCycleFrames.get(k - 1)).intValue();
        return (Drawable)paramAnimationView.mFrames.get(i);
      }
      this.d = 2;
      return null;
    }
    this.d = 2;
    return null;
  }
  
  protected void a()
  {
    Object localObject = (AnimationView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      if (this.d == 2) {
        return;
      }
      Drawable localDrawable = a((AnimationView)localObject);
      if (localDrawable != null) {
        ((AnimationView)localObject).setImageDrawable(localDrawable);
      }
      if (((AnimationView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener != null) {
        if ((this.e == 1) && (this.f > 0)) {
          ((AnimationView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener.onAnimationRepeat((AnimationView)localObject);
        } else if ((this.e == 1) && (this.f == 0))
        {
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            ((AnimationView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener.onAnimationStart((AnimationView)localObject);
          }
        }
        else if (this.d == 2) {
          ((AnimationView)localObject).jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener.onAnimationEnd((AnimationView)localObject);
        }
      }
      int i = getNextFrameDelay((AnimationView)localObject);
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, i);
    }
  }
  
  public int getNextFrameDelay(AnimationView paramAnimationView)
  {
    if ((paramAnimationView != null) && (paramAnimationView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo != null))
    {
      if (this.e >= paramAnimationView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo.mOneCycleFrames.size()) {
        return paramAnimationView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo.mDelay;
      }
      return paramAnimationView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo.mInterval;
    }
    return 100;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a();
    }
    return false;
  }
  
  public void pause()
  {
    stop();
  }
  
  public void play()
  {
    reset();
    this.d = 1;
    a();
  }
  
  public void reset()
  {
    this.e = 0;
    this.f = 0;
    this.d = 0;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void resume()
  {
    AnimationView localAnimationView = (AnimationView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.d != 1)
    {
      if (localAnimationView == null) {
        return;
      }
      this.d = 1;
      a();
      if (localAnimationView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener != null) {
        localAnimationView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener.onAnimationStart(localAnimationView);
      }
    }
  }
  
  public void stop()
  {
    this.d = 2;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView.Player
 * JD-Core Version:    0.7.0.1
 */