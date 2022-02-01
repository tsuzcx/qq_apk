package com.tencent.mobileqq.flashshow.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.mobileqq.flashshow.request.like.FSLikeManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class FSDoublePraiseView
  extends FSBaseWidgetView<FeedCloudMeta.StFeed>
  implements AnimationDrawableFactory.CreateResultListener
{
  private boolean a = false;
  private int b = 800;
  private ImageView c;
  
  public FSDoublePraiseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSDoublePraiseView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSDoublePraiseView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    FSLikeManager.a((FeedCloudMeta.StFeed)getData());
  }
  
  private ImageView getImageView()
  {
    removeAllViews();
    ImageView localImageView = new ImageView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.a(88.0F), ViewUtils.a(88.0F));
    localLayoutParams.gravity = 17;
    addView(localImageView, localLayoutParams);
    return localImageView;
  }
  
  public void a()
  {
    if (this.a) {
      return;
    }
    AnimationDrawableCreateOption.Builder localBuilder = new AnimationDrawableCreateOption.Builder("https://down.qq.com/video_story/flashshow/animation/doubletap_like_sep.zip");
    localBuilder.a(this.b);
    localBuilder.a(this.b);
    localBuilder.a(false);
    localBuilder.b(true);
    AnimationDrawableFactory.a().a(hashCode(), localBuilder.a(), this);
    this.c = getImageView();
    c();
  }
  
  protected void a(FeedCloudMeta.StFeed paramStFeed, int paramInt) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      if (this.a) {
        return;
      }
      this.a = true;
      setVisibility(0);
      paramQQAnimationDrawable.b(true);
      this.c.setImageDrawable(paramQQAnimationDrawable);
      paramQQAnimationDrawable.start();
      postDelayed(new FSDoublePraiseView.1(this), this.b);
    }
  }
  
  public void b()
  {
    this.a = false;
    removeAllViews();
    setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("FSDoublePraiseView", 1, "registerReceiver");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QLog.d("FSDoublePraiseView", 1, "unRegisterReceiver");
  }
  
  protected void onInitView(Context paramContext, View paramView) {}
  
  public void setData(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.setData(paramStFeed, paramInt);
    removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.FSDoublePraiseView
 * JD-Core Version:    0.7.0.1
 */