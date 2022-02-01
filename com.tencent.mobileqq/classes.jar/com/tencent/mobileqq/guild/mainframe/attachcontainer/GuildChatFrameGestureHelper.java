package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class GuildChatFrameGestureHelper
{
  private ViewGroup a;
  private GuildChatFrameLayoutAnimator b;
  private GuildChatFramePosNotifyHelper c;
  private VelocityTracker d;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 3.4028235E+38F;
  private float h = 3.4028235E+38F;
  private float i = 3.4028235E+38F;
  
  public GuildChatFrameGestureHelper(ViewGroup paramViewGroup, GuildChatFrameLayoutAnimator paramGuildChatFrameLayoutAnimator, GuildChatFramePosNotifyHelper paramGuildChatFramePosNotifyHelper)
  {
    this.a = paramViewGroup;
    this.b = paramGuildChatFrameLayoutAnimator;
    this.c = paramGuildChatFramePosNotifyHelper;
    this.d = VelocityTracker.obtain();
    this.e = GuildChatFrameGestureUtil.a();
    this.f = GuildChatFrameGestureUtil.a(this.a.getContext());
  }
  
  private int a()
  {
    return (int)(this.a.getTranslationX() * 1000.0F / GuildChatFrameGestureUtil.a(this.a.getContext()));
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("continueAnim moveDirection = ");
      ((StringBuilder)localObject).append(this.c.b());
      QLog.d("GuildChatFrameGestureHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    int j = this.c.b();
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    ((GuildChatFrameLayoutAnimator)localObject).e(bool);
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    this.d.clear();
    this.g = paramMotionEvent.getRawX();
    this.h = this.g;
    this.i = this.a.getTranslationX();
    this.c.b(a());
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleActionDown mStartPosX = ");
      paramMotionEvent.append(this.g);
      paramMotionEvent.append(" mLastPosX = ");
      paramMotionEvent.append(this.h);
      paramMotionEvent.append(" mStartTranslationX = ");
      paramMotionEvent.append(this.i);
      QLog.d("GuildChatFrameGestureHelper", 2, paramMotionEvent.toString());
    }
    this.c.a(0);
    this.c.c(0);
    this.c.c();
    return true;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildChatFrameGestureHelper", 2, "handleActionMove");
    }
    int j = this.c.a();
    if ((j != 0) && (j != 1) && (j != 2))
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleActionMove curViewMoveState = ");
      paramMotionEvent.append(j);
      QLog.e("GuildChatFrameGestureHelper", 2, paramMotionEvent.toString());
      return true;
    }
    float f3 = paramMotionEvent.getRawX();
    float f4 = this.a.getTranslationX();
    float f2 = f3 - this.h + f4;
    float f1 = f2;
    if (this.c.a() == 0)
    {
      if (f3 > this.h) {
        f1 = -20.0F;
      } else {
        f1 = 20.0F;
      }
      f1 = f2 + f1;
    }
    f2 = this.f;
    if (f1 > f2)
    {
      f1 = f2;
    }
    else
    {
      f2 = this.e;
      if (f1 < f2) {
        f1 = f2;
      }
    }
    this.h = f3;
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleActionMove curTranlationX = ");
      paramMotionEvent.append(f4);
      paramMotionEvent.append(" targetTranslationX = ");
      paramMotionEvent.append(f1);
      paramMotionEvent.append(" x = ");
      paramMotionEvent.append(f3);
      QLog.d("GuildChatFrameGestureHelper", 2, paramMotionEvent.toString());
    }
    if (f4 == f1) {
      return true;
    }
    if (f1 > f4) {
      this.c.c(1);
    } else {
      this.c.c(2);
    }
    this.a.setTranslationX(f1);
    if (this.c.a() == 0)
    {
      this.c.a(1);
      this.c.d(1);
      this.c.a(this.i);
    }
    else
    {
      this.c.a(2);
    }
    this.c.b(a());
    this.c.c();
    return true;
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    boolean bool = QLog.isColorLevel();
    int j = 2;
    if (bool) {
      QLog.d("GuildChatFrameGestureHelper", 2, "handleActionUpOrCancel");
    }
    int k = this.c.a();
    if ((k != 0) && (k != 1) && (k != 2))
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleActionUpOrCancel error ! curViewMoveState = ");
      paramMotionEvent.append(k);
      QLog.e("GuildChatFrameGestureHelper", 1, paramMotionEvent.toString());
      return true;
    }
    float f2 = this.a.getTranslationX();
    StringBuilder localStringBuilder;
    float f1;
    if (f2 < this.e)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleActionUpOrCancel curTranslationX error! translationX = ");
      localStringBuilder.append(f2);
      localStringBuilder.append("mMinTranslationX = ");
      localStringBuilder.append(this.e);
      QLog.e("GuildChatFrameGestureHelper", 1, localStringBuilder.toString());
      f1 = this.e;
      this.a.setTranslationX(f1);
    }
    else
    {
      f1 = f2;
      if (f2 > this.f)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleActionUpOrCancel curTranslationX error! translationX = ");
        localStringBuilder.append(f2);
        localStringBuilder.append("mMaxTranslationX = ");
        localStringBuilder.append(this.f);
        QLog.e("GuildChatFrameGestureHelper", 1, localStringBuilder.toString());
        f1 = this.f;
        this.a.setTranslationX(f1);
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleActionUpOrCancel translationX = ");
      localStringBuilder.append(f1);
      localStringBuilder.append(" mMinTranslationX = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" mMaxTranslationX = ");
      localStringBuilder.append(this.f);
      QLog.d("GuildChatFrameGestureHelper", 2, localStringBuilder.toString());
    }
    f2 = this.e;
    k = 1000;
    if ((f1 != f2) && (f1 != this.f))
    {
      this.c.a(2);
      this.d.computeCurrentVelocity(1000);
      f2 = this.d.getXVelocity();
      this.d.clear();
      if ((Math.abs(f2) > ViewConfiguration.get(this.a.getContext()).getScaledMinimumFlingVelocity()) && (Math.abs(paramMotionEvent.getRawX() - this.g) > GuildChatFrameGestureUtil.b(this.a.getContext()) / 10.0F))
      {
        paramMotionEvent = this.c;
        if (f2 > 0.0F) {
          j = 1;
        }
        paramMotionEvent.c(j);
      }
      else
      {
        paramMotionEvent = this.c;
        if (f1 > this.f / 2.0F) {
          j = 1;
        }
        paramMotionEvent.c(j);
      }
      b();
      return true;
    }
    if ((this.c.a() == 1) || (this.c.a() == 2))
    {
      this.c.a(3);
      paramMotionEvent = this.c;
      if (f1 == this.f) {
        j = k;
      } else {
        j = 0;
      }
      paramMotionEvent.b(j);
      this.c.c();
    }
    if (this.c.a() == 3)
    {
      this.c.c(0);
      this.c.a(0);
      this.c.c();
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchEvent + event = ");
      localStringBuilder.append(paramMotionEvent.getAction());
      QLog.d("GuildChatFrameGestureHelper", 2, localStringBuilder.toString());
    }
    this.d.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            return false;
          }
        }
        else {
          return c(paramMotionEvent);
        }
      }
      return d(paramMotionEvent);
    }
    return b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureHelper
 * JD-Core Version:    0.7.0.1
 */