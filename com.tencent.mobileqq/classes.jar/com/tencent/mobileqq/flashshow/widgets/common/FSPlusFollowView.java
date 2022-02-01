package com.tencent.mobileqq.flashshow.widgets.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;

public class FSPlusFollowView
  extends FSFollowView
  implements AnimationDrawableFactory.CreateResultListener
{
  public FSPlusFollowView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FSPlusFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FSPlusFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e()
  {
    AnimationDrawableCreateOption.Builder localBuilder = new AnimationDrawableCreateOption.Builder("https://downv6.qq.com/video_story/flashshow/animation/follow_btn_sep.zip");
    localBuilder.a(1000);
    localBuilder.a(1000L);
    localBuilder.a(true);
    localBuilder.b(true);
    AnimationDrawableFactory.a().a(hashCode(), localBuilder.a(), this);
  }
  
  protected void a()
  {
    setVisibility(0);
    setBackgroundDrawable(getResources().getDrawable(2130840427));
  }
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      paramQQAnimationDrawable.b(true);
      setBackgroundDrawable(paramQQAnimationDrawable);
      paramQQAnimationDrawable.b(true);
      paramQQAnimationDrawable.start();
      postDelayed(new FSPlusFollowView.1(this), 1000L);
      return;
    }
    post(new FSPlusFollowView.2(this));
  }
  
  protected void b()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSPlusFollowView
 * JD-Core Version:    0.7.0.1
 */