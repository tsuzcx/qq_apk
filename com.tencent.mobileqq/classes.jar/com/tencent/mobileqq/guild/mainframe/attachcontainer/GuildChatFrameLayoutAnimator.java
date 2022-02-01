package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

public class GuildChatFrameLayoutAnimator
{
  private GuildChatFramePosNotifyHelper a;
  private float b = 0.0F;
  private float c = 0.0F;
  private View d;
  private ObjectAnimator e;
  private ObjectAnimator f;
  
  public GuildChatFrameLayoutAnimator(View paramView, GuildChatFramePosNotifyHelper paramGuildChatFramePosNotifyHelper)
  {
    this.d = paramView;
    this.a = paramGuildChatFramePosNotifyHelper;
    this.b = GuildChatFrameGestureUtil.a();
    this.c = GuildChatFrameGestureUtil.a(this.d.getContext());
  }
  
  private void a(NotifyData paramNotifyData, int paramInt, float paramFloat)
  {
    paramNotifyData.a(3);
    paramNotifyData.c(paramInt);
    paramNotifyData.b(c());
    paramNotifyData.b(paramFloat);
    this.a.a(paramNotifyData);
  }
  
  private void a(NotifyData paramNotifyData, int paramInt1, float paramFloat, int paramInt2)
  {
    paramNotifyData.a(1);
    paramNotifyData.d(paramInt2);
    paramNotifyData.c(paramInt1);
    paramNotifyData.a(paramFloat);
    paramNotifyData.b(c());
    this.a.a(paramNotifyData);
  }
  
  private void a(D8SafeAnimatorListener paramD8SafeAnimatorListener, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildChatFrameLayoutAnimator", 2, "showOutAnim");
    }
    float f1 = GuildChatFrameGestureUtil.a();
    float f2 = GuildChatFrameGestureUtil.a(this.d.getContext());
    float f3 = this.d.getTranslationX();
    if (f3 == f1)
    {
      paramD8SafeAnimatorListener = new NotifyData(this.b, this.c);
      a(paramD8SafeAnimatorListener, 2, f3, 3);
      this.d.setTranslationX(f1);
      a(paramD8SafeAnimatorListener, 2, f3);
      return;
    }
    this.e = ObjectAnimator.ofFloat(this.d, "translationX", new float[] { f3, f1 });
    this.e.setDuration(((f3 - f1) / f2 * 150.0F));
    this.e.addListener(paramD8SafeAnimatorListener);
    this.e.addUpdateListener(paramAnimatorUpdateListener);
    this.e.start();
  }
  
  private ValueAnimator.AnimatorUpdateListener b()
  {
    return new GuildChatFrameLayoutAnimator.4(this);
  }
  
  private void b(D8SafeAnimatorListener paramD8SafeAnimatorListener, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildChatFrameLayoutAnimator", 2, "showInAnim");
    }
    float f1 = GuildChatFrameGestureUtil.a(this.d.getContext());
    float f2 = this.d.getTranslationX();
    if (f2 == f1)
    {
      paramD8SafeAnimatorListener = new NotifyData(this.b, this.c);
      a(paramD8SafeAnimatorListener, 1, f2, 3);
      this.d.setTranslationX(f1);
      a(paramD8SafeAnimatorListener, 1, f2);
      return;
    }
    this.f = ObjectAnimator.ofFloat(this.d, "translationX", new float[] { f2, f1 });
    this.f.setDuration(((f1 - f2) / f1 * 150.0F));
    this.f.addListener(paramD8SafeAnimatorListener);
    this.f.addUpdateListener(paramAnimatorUpdateListener);
    this.f.start();
  }
  
  private int c()
  {
    return (int)(this.d.getTranslationX() * 1000.0F / GuildChatFrameGestureUtil.a(this.d.getContext()));
  }
  
  private D8SafeAnimatorListener f(boolean paramBoolean)
  {
    return new GuildChatFrameLayoutAnimator.3(this, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showByPos in = ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = 1;
    QLog.i("GuildChatFrameLayoutAnimator", 1, (String)localObject);
    if (a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showByPos anim running in = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("GuildChatFrameLayoutAnimator", 1, ((StringBuilder)localObject).toString());
      return;
    }
    float f2 = this.d.getTranslationX();
    float f1;
    if (paramBoolean) {
      f1 = this.c;
    } else {
      f1 = this.b;
    }
    localObject = new NotifyData(this.b, this.c);
    if (!paramBoolean) {
      i = 2;
    }
    a((NotifyData)localObject, i, f2, 2);
    this.d.setTranslationX(f1);
    a((NotifyData)localObject, i, f2);
  }
  
  public boolean a()
  {
    ObjectAnimator localObjectAnimator = this.e;
    if ((localObjectAnimator == null) || (!localObjectAnimator.isRunning())) {
      localObjectAnimator = this.f;
    }
    return (localObjectAnimator != null) && (localObjectAnimator.isRunning());
  }
  
  public void b(boolean paramBoolean)
  {
    if (a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showByAnim running in = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("GuildChatFrameLayoutAnimator", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = c(paramBoolean);
    ValueAnimator.AnimatorUpdateListener localAnimatorUpdateListener = d(paramBoolean);
    if ((localObject != null) && (localAnimatorUpdateListener != null))
    {
      if (paramBoolean)
      {
        b((D8SafeAnimatorListener)localObject, localAnimatorUpdateListener);
        return;
      }
      a((D8SafeAnimatorListener)localObject, localAnimatorUpdateListener);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildChatFrameLayoutAnimator", 2, "showByAnim args error!");
    }
  }
  
  public D8SafeAnimatorListener c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createD8SafeAnimatorListener in = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("GuildChatFrameLayoutAnimator", 2, localStringBuilder.toString());
    }
    if (this.a.a() != 0) {
      return null;
    }
    return new GuildChatFrameLayoutAnimator.1(this, paramBoolean);
  }
  
  public ValueAnimator.AnimatorUpdateListener d(boolean paramBoolean)
  {
    return new GuildChatFrameLayoutAnimator.2(this);
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("continueMoveAnim in = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GuildChatFrameLayoutAnimator", 2, ((StringBuilder)localObject).toString());
    }
    if (a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("continueMoveAnim anim running in = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("GuildChatFrameLayoutAnimator", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = f(paramBoolean);
    ValueAnimator.AnimatorUpdateListener localAnimatorUpdateListener = b();
    if ((localObject != null) && (localAnimatorUpdateListener != null))
    {
      float f1 = this.d.getTranslationX();
      float f2 = this.c;
      if (f1 != f2)
      {
        float f3 = this.b;
        if (f1 != f3)
        {
          if (paramBoolean)
          {
            this.f = ObjectAnimator.ofFloat(this.d, "translationX", new float[] { f1, f2 });
            f2 = this.c;
            l = ((f2 - f1) / f2 * 150.0F);
            this.f.setDuration(l);
            this.f.addUpdateListener(localAnimatorUpdateListener);
            this.f.addListener((Animator.AnimatorListener)localObject);
            this.f.start();
            return;
          }
          this.e = ObjectAnimator.ofFloat(this.d, "translationX", new float[] { f1, f3 });
          long l = ((f1 - this.b) / this.c * 150.0F);
          this.e.setDuration(l);
          this.e.addUpdateListener(localAnimatorUpdateListener);
          this.e.addListener((Animator.AnimatorListener)localObject);
          this.e.start();
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildChatFrameLayoutAnimator", 2, "continueMoveAnim args error!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameLayoutAnimator
 * JD-Core Version:    0.7.0.1
 */