package com.tencent.timi.game.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieListener;
import com.tencent.mobileqq.dinifly.LottieTask;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ReflectionUtils;
import com.tencent.timi.game.utils.ThreadPool;

public class SafeLottieAnimationView
  extends DiniFlyAnimationView
{
  boolean a;
  boolean b = false;
  private boolean c;
  private boolean d = false;
  private final LottieListener e = new SafeLottieAnimationView.3(this);
  
  public SafeLottieAnimationView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public SafeLottieAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public SafeLottieAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.c = true;
  }
  
  private void a(String paramString)
  {
    try
    {
      ReflectionUtils.a(this, "animationName", paramString);
      ReflectionUtils.a(this, "animationResId", Integer.valueOf(0));
      ReflectionUtils.b(this, "clearComposition", null);
      ReflectionUtils.b(this, "cancelLoaderTask", null);
      return;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetReflect error ");
      localStringBuilder.append(paramString.getMessage());
      Logger.c("SafeLottieAnimationView", localStringBuilder.toString());
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (!this.c) {
      return;
    }
    if ((paramInt == 0) && (this.a))
    {
      if (!isAnimating()) {
        resumeAnimation();
      }
    }
    else if (isAnimating())
    {
      this.a = true;
      pauseAnimation();
    }
    else
    {
      this.a = false;
    }
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public void pauseAnimation()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.pauseAnimation();
      return;
    }
    ThreadPool.c(new SafeLottieAnimationView.2(this));
  }
  
  public void playAnimation()
  {
    super.playAnimation();
    this.a = true;
  }
  
  public void setAnimation(Animation paramAnimation)
  {
    super.setAnimation(paramAnimation);
  }
  
  public void setAnimation(String paramString)
  {
    a(paramString);
    paramString = LottieCompositionFactory.fromAsset(getContext(), paramString);
    paramString.addListener(this.e);
    paramString.addFailureListener(new SafeLottieAnimationView.1(this));
  }
  
  public void setAnimation(String paramString, boolean paramBoolean)
  {
    setNeedClearImageCache(paramBoolean);
    setAnimation(paramString);
  }
  
  public void setNeedClearImageCache(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.SafeLottieAnimationView
 * JD-Core Version:    0.7.0.1
 */