package com.tencent.mobileqq.listentogether.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.SweepGradientCircleProgress;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableImageView;
import com.tencent.widget.PatchedButton;

public class MusicPanelView
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View.OnClickListener a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  SweepGradientCircleProgress jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress;
  AlphaClickableImageView jdField_a_of_type_ComTencentWidgetAlphaClickableImageView;
  PatchedButton jdField_a_of_type_ComTencentWidgetPatchedButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public MusicPanelView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  private void d()
  {
    LayoutInflater.from(getContext()).inflate(2131561074, this, true);
    setBackgroundResource(2130844904);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365298));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView = ((AlphaClickableImageView)findViewById(2131378437));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372056));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372032));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375241));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress = ((SweepGradientCircleProgress)findViewById(2131372048));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)findViewById(2131369890));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372053));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372050));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130844920);
    int i = AIOUtils.a(8.0F, this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.getResources());
    Object localObject = (Activity)getContext();
    AlphaClickableImageView localAlphaClickableImageView = this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Activity)localObject).getWindow().getDecorView())
    {
      BaseListenTogetherPanel.a(localAlphaClickableImageView, i, i, i, i, (View)localObject);
      this.jdField_a_of_type_Int = AIOUtils.a(31.0F, getResources());
      setMusicProgressDefaultShow();
      return;
    }
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "Rotation", new float[] { this.jdField_a_of_type_Float - 360.0F, this.jdField_a_of_type_Float });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(10000L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new MusicPanelView.1(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707045));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setVisibility(paramInt1);
    if (paramInt2 == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130844921);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription(HardCodeUtil.a(2131707043));
    }
    while (paramInt2 != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130844922);
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription(HardCodeUtil.a(2131707041));
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equals((String)this.jdField_a_of_type_AndroidWidgetImageView.getTag()))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        int i = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTag(new int[] { this.jdField_a_of_type_Int / 2 });
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.A);
        ((URLDrawable)localObject).startDownload();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramString);
        this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(paramInt));
    setContentDescription(paramString);
    AIOMusicSkin.a().a(getContext(), this);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.end();
    }
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131707044));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setVisibility(paramInt1);
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setProgress(paramInt1);
      return;
      paramInt1 = paramInt2;
      if (paramInt2 > 100) {
        paramInt1 = 100;
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) && (a())) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707040));
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131707042));
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setVisibility(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      super.setBackgroundDrawable(null);
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setMusicProgressDefaultShow()
  {
    int i = getResources().getColor(2131167016);
    if ((ThemeUtil.curThemeId.equals("1103")) || (ThemeUtil.curThemeId.equals("2920"))) {
      i = getResources().getColor(2131167015);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setBgAndProgressColor(100, i, 100, getResources().getColor(2131167014));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setBgAndProgressUseAlpha(false, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setStrokeWidth(1.5F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setmShadowColor(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setNeedSweepGradient(false, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setShadowRadius(AIOUtils.a(1.0F, getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.MusicPanelView
 * JD-Core Version:    0.7.0.1
 */