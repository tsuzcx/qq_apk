package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class VideofeedsUserGuideController
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideofeedsUserGuideController.5(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = true;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  
  public VideofeedsUserGuideController(Activity paramActivity, AppRuntime paramAppRuntime, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.d = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.e = paramBoolean2;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380311));
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { paramView1, paramView2 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131380316)).setText(paramString);
    paramString = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if (paramString != null) {
      paramString.cancel();
    }
    paramString = this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
    if (paramString != null) {
      paramString.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new VideofeedsUserGuideController.2(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new VideofeedsUserGuideController.3(this));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideofeedsUserGuideController.4(this), 300L);
  }
  
  @TargetApi(11)
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideofeedsUserGuideController", 2, "hide user guide");
    }
    b();
    this.jdField_a_of_type_AndroidOsHandler.post(new VideofeedsUserGuideController.1(this));
  }
  
  @TargetApi(11)
  public void a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.e) {
        return;
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
      {
        if (this.c) {
          return;
        }
        int i = ReadInJoyHelper.y(this.jdField_a_of_type_MqqAppAppRuntime);
        if (i < 3)
        {
          ReadInJoyHelper.z(this.jdField_a_of_type_MqqAppAppRuntime, i + 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feedsVideofeedsUserGuideController", 2, "show user guide");
          }
          if (!TextUtils.isEmpty(paramVideoInfo.g)) {
            paramVideoInfo = HardCodeUtil.a(2131715913);
          } else {
            paramVideoInfo = HardCodeUtil.a(2131715912);
          }
          a(paramVideoInfo);
        }
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
    {
      if (this.c) {
        return;
      }
      a(paramECommerceEntranceInfo.a);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  @TargetApi(11)
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation() != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().setAnimationListener(null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().cancel();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
    }
    Object localObject = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    localObject = this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
      if (localObject != null)
      {
        localObject = ((AnimatorSet)localObject).getChildAnimations().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Animator localAnimator = (Animator)((Iterator)localObject).next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideofeedsUserGuideController
 * JD-Core Version:    0.7.0.1
 */