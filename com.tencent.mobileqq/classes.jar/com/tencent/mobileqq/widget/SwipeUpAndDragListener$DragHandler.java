package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragCallBack;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Iterator;

class SwipeUpAndDragListener$DragHandler
  extends SwipeUpAndDragListener.GestureHandler
{
  int jdField_a_of_type_Int;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int = 0;
  RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  int jdField_c_of_type_Int;
  RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  int d;
  int e;
  int jdField_f_of_type_Int;
  private RelativeLayout.LayoutParams jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  
  public SwipeUpAndDragListener$DragHandler(SwipeUpAndDragListener paramSwipeUpAndDragListener, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramSwipeUpAndDragListener, paramContext, paramViewGroup);
    a(0);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setElevation(50.0F);
    }
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = new QQBlurView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      localQQBlurView.b(localQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      LottieComposition.Factory.fromAssetFileName(this.jdField_a_of_type_AndroidContentContext, "lottie/photo_list_panel_drag.json", new SwipeUpAndDragListener.DragHandler.2(this));
      return;
    }
    e();
  }
  
  private void e()
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).setAlpha(1.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694863);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localObject != null) {
      ((DiniFlyAnimationView)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject != null) {
      ((LottieDrawable)localObject).start();
    }
  }
  
  private void f()
  {
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localLottieDrawable != null)
    {
      localLottieDrawable.stop();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
    }
  }
  
  private void g()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      localImageView.setScaleX(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h);
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694862);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void h()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(4);
    }
  }
  
  AnimationSet a()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.a(this.g, this.jdField_d_of_type_AndroidWidgetRelativeLayout.getWidth(), this.jdField_d_of_type_AndroidWidgetRelativeLayout.getHeight());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("d scale = ");
    ((StringBuilder)localObject1).append(f1);
    Logger.a("PhotoListPanel", "createDragReleaseSendAnim", ((StringBuilder)localObject1).toString());
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    int k = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[0];
    int m = (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 65.0F + 0.5F + this.jdField_d_of_type_AndroidWidgetRelativeLayout.getWidth() * f1 + 0.5F);
    int n = this.jdField_a_of_type_ArrayOfInt[0];
    int j = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() + this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getHeight() - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 13.0F + 0.5F + this.jdField_d_of_type_AndroidWidgetRelativeLayout.getHeight() * f1 + 0.5F) - this.jdField_a_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(this.g) == 1) {
      i = j - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 70.0F + 0.5F);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" deltY = ");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(", flyStartLocation[1] = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfInt[1]);
    ((StringBuilder)localObject1).append(",inputBarRightTopCorner[1] = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[1]);
    ((StringBuilder)localObject1).append(",top = ");
    ((StringBuilder)localObject1).append(this.jdField_d_of_type_AndroidWidgetRelativeLayout.getTop());
    Logger.a("PhotoListPanel", "createDragReleaseSendAnim", ((StringBuilder)localObject1).toString());
    localObject1 = new AnimationSet(false);
    Object localObject2 = new ScaleAnimation(1.0F, f1, 1.0F, f1);
    ((ScaleAnimation)localObject2).setStartOffset(0L);
    ((ScaleAnimation)localObject2).setDuration(500L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new AnimationSet(false);
    ((AnimationSet)localObject2).setStartOffset(0L);
    ((AnimationSet)localObject2).setDuration(500L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, k - m - n, 0.0F, 0.0F);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
    localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject2).setStartOffset(400L);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).setFillAfter(false);
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167333));
    c();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(View.generateViewId());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841553);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(17.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ((int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 9.0F));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(3, this.jdField_a_of_type_AndroidWidgetImageView.getId());
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(15);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setTranslationY(AIOUtils.b(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ((int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 18.0F));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(3, this.jdField_a_of_type_AndroidWidgetImageView.getId());
    this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_c_of_type_Int = 3;
    this.jdField_d_of_type_Int = 8;
    this.jdField_e_of_type_Int = 26;
    this.jdField_f_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (SwipeUpAndDragListener.jdField_a_of_type_Int == 1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt == 4)
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
                this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
                a(true);
                f();
                h();
                this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
              }
            }
            else
            {
              this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setColor(Color.rgb(30, 186, 252));
              this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(128);
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
              if (this.jdField_b_of_type_Int != 3)
              {
                d();
                h();
              }
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h < 0.8F)
            {
              this.jdField_f_of_type_Int = ((int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h * 128.0F / 0.8F));
              this.jdField_c_of_type_Int = 3;
              this.jdField_d_of_type_Int = 8;
              this.jdField_e_of_type_Int = 26;
            }
            else
            {
              this.jdField_f_of_type_Int = 128;
              float f1 = (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h - 0.8F) / 0.2F;
              this.jdField_c_of_type_Int = ((int)(27.0F * f1 + 3.0F));
              this.jdField_d_of_type_Int = ((int)(178.0F * f1 + 8.0F));
              this.jdField_e_of_type_Int = ((int)(f1 * 226.0F + 26.0F));
            }
            this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setColor(Color.rgb(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int));
            this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(this.jdField_f_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
            g();
            if (this.jdField_b_of_type_Int == 3)
            {
              f();
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
          }
        }
        else
        {
          int[] arrayOfInt = new int[2];
          this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getLocationOnScreen(arrayOfInt);
          int i = arrayOfInt[1];
          this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a().getLocationOnScreen(arrayOfInt);
          int j = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b();
          this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, arrayOfInt[1] - i - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b());
          this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = j;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
            this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          }
          this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
          a(false);
        }
      }
      else {
        a();
      }
    }
    else if (SwipeUpAndDragListener.jdField_a_of_type_Int == 0) {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt == 4) {
                this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
              }
            }
            else {
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            }
          }
          else {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidWidgetTextView.getParent() != null) {
            return;
          }
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131708131));
        if (Build.VERSION.SDK_INT >= 21) {
          this.jdField_a_of_type_AndroidWidgetTextView.setElevation(10.0F);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(10.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838151);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ((int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 6.0F));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14);
      }
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    IApolloAIOHelper localIApolloAIOHelper = (IApolloAIOHelper)this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(8);
    if (localIApolloAIOHelper != null) {
      localIApolloAIOHelper.showApolloView(paramBoolean);
    }
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    float f2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_d_of_type_Float;
    paramMotionEvent = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramMotionEvent.topMargin = ((int)(paramMotionEvent.topMargin + (f1 - f2)));
    this.jdField_a_of_type_Int = (this.jdField_b_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_c_of_type_Int + paramMotionEvent.topMargin);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramMotionEvent);
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("drag hanldeMove, contentParent = ");
    paramMotionEvent.append(this.jdField_d_of_type_AndroidWidgetRelativeLayout.getParent());
    Logger.a("PhotoListPanel", "DragHandler", paramMotionEvent.toString());
    paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener;
    paramMotionEvent.jdField_d_of_type_Float = f1;
    f1 -= paramMotionEvent.b;
    paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener;
    paramMotionEvent.h = (-f1 / paramMotionEvent.g);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h > 1.0F) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h = 1.0F;
    } else if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h < 0.0F) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.h = 0.0F;
    }
    if (-(int)f1 > (int)this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.g) {
      a(3);
    } else {
      a(2);
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.invalidate();
    return true;
  }
  
  boolean a(PhotoListPanel.PhotoPanelAdapter.RecyclerHolder paramRecyclerHolder, int paramInt)
  {
    super.a(paramRecyclerHolder, paramInt);
    a(1);
    paramInt = paramRecyclerHolder.itemView.getWidth() - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 2.0F + 0.5F);
    int i = paramRecyclerHolder.itemView.getHeight() - (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 2.0F + 0.5F) * 2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = (this.jdField_c_of_type_ArrayOfInt[0] + (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 2.0F + 0.5F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = (this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_c_of_type_Int + (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 2.0F + 0.5F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.g = (i * 3 / 5);
    paramRecyclerHolder = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.getParent();
    if (paramRecyclerHolder != null)
    {
      this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.clearAnimation();
      paramRecyclerHolder.removeView(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView);
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView, new RelativeLayout.LayoutParams(paramInt, i));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(paramInt, i);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin;
    this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getParent() != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((ViewGroup)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getParent()).removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, this.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.invalidate();
    paramRecyclerHolder = new StringBuilder();
    paramRecyclerHolder.append("drag prepare, contentParent = ");
    paramRecyclerHolder.append(this.jdField_d_of_type_AndroidWidgetRelativeLayout.getParent());
    Logger.a("PhotoListPanel", "DragHandler", paramRecyclerHolder.toString());
    return true;
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handler = ");
    ((StringBuilder)localObject1).append(this);
    Logger.a("PhotoListPanel", "handleUp", ((StringBuilder)localObject1).toString());
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.jdField_b_of_type_Int;
    boolean bool = false;
    if (i != 3)
    {
      a(4);
      if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_Long < 200L) && (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.b) < this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_d_of_type_Int) && (Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_d_of_type_Int))
      {
        b();
        return false;
      }
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getLocationInWindow(this.jdField_c_of_type_ArrayOfInt);
      paramMotionEvent = new TranslateAnimation(0.0F, 0.0F, 0.0F, (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.e * 2.0F + 0.5F) + this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ArrayOfInt[1]);
      paramMotionEvent.setFillAfter(true);
      paramMotionEvent.setDuration(200L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation(paramMotionEvent);
      paramMotionEvent.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      return true;
    }
    a(4);
    Logger.a("PhotoListPanel", "DragHandler", "@#handleUp, createFlyAnimation ");
    paramMotionEvent = a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean = true;
    Logger.a("PhotoListPanel", "DragHandler", "@#handleUp, startFlyAnimation ");
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation(paramMotionEvent);
    i = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(this.g);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(this.g).path);
    ReportController.b(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", this.g + 1, 0, "1", "", "", "");
    int j = PhotoUtils.getTypeforReport2(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.g + 1);
    ReportController.b(null, "dc00898", "", "", "0X800A914", "0X800A914", j, 0, ((StringBuilder)localObject2).toString(), "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(this.g).path;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_c_of_type_Int == 2) {
        bool = true;
      }
      ((PhotoListPanel.SwipeUpAndDragCallBack)localObject1).a((String)localObject2, bool);
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (QFileAssistantUtils.a(((SessionInfo)localObject2).jdField_a_of_type_JavaLangString))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((String)localObject3, ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_a_of_type_Int, true);
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
      j = this.g;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("");
      ((PhotoListPanel)localObject2).a(j, (ArrayList)localObject1, false, true, "0X8005E0D", "0", ((StringBuilder)localObject3).toString(), false);
    }
    paramMotionEvent.setAnimationListener(new SwipeUpAndDragListener.DragHandler.1(this, f2));
    return true;
  }
  
  boolean c(MotionEvent paramMotionEvent)
  {
    a(4);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.DragHandler
 * JD-Core Version:    0.7.0.1
 */