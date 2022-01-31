package com.tencent.qqmini.sdk.launcher;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import beqf;
import beqk;
import beql;
import beqm;
import bezi;
import bfgl;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppUIProxy$LoadingUI
  extends RelativeLayout
  implements View.OnClickListener
{
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView c;
  
  public AppUIProxy$LoadingUI(AppUIProxy paramAppUIProxy, Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  private boolean a()
  {
    return true;
  }
  
  private void c()
  {
    inflate(getContext(), 2131559301, this);
    this.jdField_a_of_type_AndroidViewViewGroup = this;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376453);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364687));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bfgl.a(getContext(), 80.0F), bfgl.a(getContext(), 30.0F));
    localLayoutParams.addRule(11, -1);
    localLayoutParams.topMargin = (bfgl.a(getContext(), 9.0F) + a());
    localLayoutParams.rightMargin = bfgl.a(getContext(), 12.5F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363585));
    this.c = ((ImageView)findViewById(2131363500));
    this.c.setImageResource(2130840837);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131368887));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366923));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369582));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365087);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365088));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetProgressBar.clearAnimation();
  }
  
  private void e()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject1 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject1).setDuration(500L);
    ((Animation)localObject1).setInterpolator(new LinearInterpolator());
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, 40.0F, 0.0F);
    ((Animation)localObject2).setDuration(300L);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setAnimation(localAnimationSet);
    localAnimationSet = new AnimationSet(true);
    localObject1 = new TranslateAnimation(0.0F, 0.0F, 40.0F, 0.0F);
    ((Animation)localObject1).setDuration(300L);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject2).setDuration(800L);
    ((Animation)localObject2).setInterpolator(new DecelerateInterpolator());
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    ((Animation)localObject1).setAnimationListener(new beqk(this));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AppUIProxy.LoadingUI.3(this, localAnimationSet), 200L);
  }
  
  private void f()
  {
    d();
    Object localObject1 = new AnimationSet(true);
    Object localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject2).setDuration(300L);
    ((Animation)localObject2).setInterpolator(new LinearInterpolator());
    Object localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -80.0F);
    ((Animation)localObject3).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
    ((AnimationSet)localObject1).setInterpolator(new LinearInterpolator());
    ((AnimationSet)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setAnimation((Animation)localObject1);
    localObject1 = new AnimationSet(true);
    localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -60.0F);
    ((Animation)localObject2).setDuration(200L);
    localObject3 = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject3).setDuration(300L);
    ((Animation)localObject3).setInterpolator(new DecelerateInterpolator());
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
    ((AnimationSet)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AppUIProxy.LoadingUI.4(this, (AnimationSet)localObject1), 100L);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    new AnimationSet(true);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setDuration(400L);
    ((AlphaAnimation)localObject1).setAnimationListener(new beql(this));
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation((Animation)localObject1);
  }
  
  public int a()
  {
    int i = getResources().getIdentifier("status_bar_height", "dimen", "android");
    return getResources().getDimensionPixelSize(i);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    d();
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AppUIProxy.LoadingUI.1(this), 250L);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (a())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
    f();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363500)
    {
      bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1026, "1");
      if (beqf.a().a() != null) {
        beqf.a().a().notifyRuntimeEvent(60, new Object[0]);
      }
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherAppUIProxy.quit();
    }
    while (paramView.getId() != 2131363585) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy.LoadingUI
 * JD-Core Version:    0.7.0.1
 */