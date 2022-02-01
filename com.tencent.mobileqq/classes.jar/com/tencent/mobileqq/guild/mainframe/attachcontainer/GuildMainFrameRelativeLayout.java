package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class GuildMainFrameRelativeLayout
  extends RelativeLayout
{
  private float a = 0.0F;
  private float b = 0.0F;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private ViewGroup f;
  private GuildMainViewContext g;
  private GuildChatFramePosNotifyHelper h;
  private GuildChatFrameLayoutAnimator i;
  
  public GuildMainFrameRelativeLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildMainFrameRelativeLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuildMainFrameRelativeLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildMainFrameRelativeLayout", 2, "isCurMainFrameLayoutIntercept aioIsShowing false");
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            return super.onInterceptTouchEvent(paramMotionEvent);
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
  
  private boolean b()
  {
    if ((this.g.e().l() != GuildAttachContainerController.b) && (this.f.getVisibility() == 0)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildMainFrameRelativeLayout", 2, "onInterceptTouchEvent return  super.onInterceptTouchEvent(event)");
    }
    return false;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    this.a = paramMotionEvent.getRawX();
    this.b = paramMotionEvent.getRawY();
    float f1 = this.f.getTranslationX();
    float f2 = GuildChatFrameGestureUtil.a();
    float f3 = GuildChatFrameGestureUtil.a(getContext());
    if (f1 != f3) {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
    }
    if ((f1 > f2) && (f1 < f3))
    {
      this.c = true;
    }
    else
    {
      this.g.f().a(paramMotionEvent);
      this.c = false;
    }
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("onInterceptTouchEventDown mIsIntercept = ");
      paramMotionEvent.append(this.c);
      QLog.d("GuildMainFrameRelativeLayout", 2, paramMotionEvent.toString());
    }
    return this.c;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    if (this.c) {
      return true;
    }
    if (j(paramMotionEvent))
    {
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("onInterceptTouchEventMove isAllowActionMove true mIsIntercept = ");
        paramMotionEvent.append(this.c);
        QLog.d("GuildMainFrameRelativeLayout", 2, paramMotionEvent.toString());
      }
      this.c = true;
    }
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("onInterceptTouchEventMove mIsIntercept = ");
      paramMotionEvent.append(this.c);
      QLog.d("GuildMainFrameRelativeLayout", 2, paramMotionEvent.toString());
    }
    return this.c;
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInterceptTouchEventCancelOrUp mIsIntercept = ");
      localStringBuilder.append(this.c);
      QLog.d("GuildMainFrameRelativeLayout", 2, localStringBuilder.toString());
    }
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
    if (!this.c) {
      this.g.f().a(paramMotionEvent);
    }
    return this.c;
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 1)
      {
        int j = 2;
        if (k != 2)
        {
          if (k != 3) {
            return false;
          }
        }
        else
        {
          if (this.e) {
            return true;
          }
          if (paramMotionEvent.getRawX() > this.a) {
            j = 1;
          }
          if ((j(paramMotionEvent)) && (this.h.e(j)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GuildMainFrameRelativeLayout", 1, "isBusiIntercept ACTION_MOVE isAllowActionMove true and onBusiInterceptMove true");
            }
            this.e = true;
          }
          if (QLog.isColorLevel())
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("isBusiIntercept ACTION_MOVE mIsBusiIntercept = ");
            paramMotionEvent.append(this.e);
            QLog.d("GuildMainFrameRelativeLayout", 1, paramMotionEvent.toString());
          }
          return this.e;
        }
      }
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("isBusiIntercept ACTION_UP mIsBusiIntercept = ");
        paramMotionEvent.append(this.e);
        QLog.d("GuildMainFrameRelativeLayout", 1, paramMotionEvent.toString());
      }
      return this.e;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildMainFrameRelativeLayout", 1, "isBusiIntercept ACTION_DOWN mIsBusiIntercept = false");
    }
    this.e = false;
    return this.e;
  }
  
  private boolean f(MotionEvent paramMotionEvent)
  {
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
          return h(paramMotionEvent);
        }
      }
      return i(paramMotionEvent);
    }
    return g(paramMotionEvent);
  }
  
  private boolean g(MotionEvent paramMotionEvent)
  {
    this.d = this.h.a(paramMotionEvent);
    if (this.d) {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
    }
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleChildInterceptActionDown mIsChildIntercept = ");
      paramMotionEvent.append(this.d);
      QLog.d("GuildMainFrameRelativeLayout", 1, paramMotionEvent.toString());
    }
    return this.d;
  }
  
  private boolean h(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleChildInterceptActionMove mIsChildIntercept = ");
      paramMotionEvent.append(this.d);
      QLog.d("GuildMainFrameRelativeLayout", 1, paramMotionEvent.toString());
    }
    return this.d;
  }
  
  private boolean i(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("handleChildInterceptActionUpOrCancel mIsChildIntercept = ");
      paramMotionEvent.append(this.d);
      QLog.d("GuildMainFrameRelativeLayout", 1, paramMotionEvent.toString());
    }
    if (this.d)
    {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
      return true;
    }
    return false;
  }
  
  private boolean j(MotionEvent paramMotionEvent)
  {
    float f1 = this.f.getTranslationX();
    int j;
    if (paramMotionEvent.getRawX() > this.a) {
      j = 1;
    } else {
      j = 2;
    }
    if (((f1 == GuildChatFrameGestureUtil.a()) && (j == 2)) || ((f1 == GuildChatFrameGestureUtil.a(getContext())) && (j == 1)))
    {
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("isAllowActionMove false translationX =  ");
        paramMotionEvent.append(f1);
        QLog.d("GuildMainFrameRelativeLayout", 1, paramMotionEvent.toString());
      }
      return false;
    }
    return (Math.abs(paramMotionEvent.getRawX() - this.a) > Math.abs(paramMotionEvent.getRawY() - this.b)) && (Math.abs(paramMotionEvent.getRawX() - this.a) > 20.0F);
  }
  
  public void a()
  {
    GuildChatFramePosNotifyHelper localGuildChatFramePosNotifyHelper = this.h;
    if (localGuildChatFramePosNotifyHelper != null) {
      localGuildChatFramePosNotifyHelper.d();
    }
  }
  
  public void a(GuildMainViewContext paramGuildMainViewContext, ViewGroup paramViewGroup, GuildChatFramePosNotifyHelper paramGuildChatFramePosNotifyHelper, GuildChatFrameLayoutAnimator paramGuildChatFrameLayoutAnimator)
  {
    this.g = paramGuildMainViewContext;
    this.f = paramViewGroup;
    this.h = paramGuildChatFramePosNotifyHelper;
    this.i = paramGuildChatFrameLayoutAnimator;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.i.a()) {
      return true;
    }
    if (f(paramMotionEvent))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildMainFrameRelativeLayout", 2, "onInterceptTouchEvent isChildIntercept true");
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (e(paramMotionEvent)) {
      return true;
    }
    return a(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.c) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            return super.onTouchEvent(paramMotionEvent);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("GuildMainFrameRelativeLayout", 1, "onTouchEvent ACTION_MOVE");
          }
          return this.g.f().a(paramMotionEvent);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuildMainFrameRelativeLayout", 1, "onTouchEvent ACTION_UP || ACTION_CANCEL mIsIntercept = false");
      }
      this.c = false;
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
      return this.g.f().a(paramMotionEvent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildMainFrameRelativeLayout", 1, "onTouchEvent ACTION_DOWN");
    }
    return this.g.f().a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildMainFrameRelativeLayout
 * JD-Core Version:    0.7.0.1
 */