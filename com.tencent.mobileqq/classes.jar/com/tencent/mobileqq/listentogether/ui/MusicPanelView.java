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
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    LayoutInflater.from(getContext()).inflate(2131560938, this, true);
    setBackgroundResource(2130844780);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365173));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView = ((AlphaClickableImageView)findViewById(2131377851));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371653));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371632));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374756));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress = ((SweepGradientCircleProgress)findViewById(2131371647));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)findViewById(2131369575));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371650));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371649));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130844796);
    int i = AIOUtils.b(8.0F, this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.getResources());
    Object localObject = (Activity)getContext();
    AlphaClickableImageView localAlphaClickableImageView = this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Activity)localObject).getWindow().getDecorView();
    }
    BaseListenTogetherPanel.a(localAlphaClickableImageView, i, i, i, i, (View)localObject);
    this.jdField_a_of_type_Int = AIOUtils.b(31.0F, getResources());
    setMusicProgressDefaultShow();
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    float f = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(localImageView, "Rotation", new float[] { f - 360.0F, f });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(10000L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new MusicPanelView.1(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707067));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setVisibility(paramInt1);
    if (paramInt2 == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130844797);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription(HardCodeUtil.a(2131707065));
      return;
    }
    if (paramInt2 == 2)
    {
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130844798);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription(HardCodeUtil.a(2131707063));
    }
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
        Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTag(new int[] { this.jdField_a_of_type_Int / 2 });
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.y);
        ((URLDrawable)localObject).startDownload();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramString);
        this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag("");
    }
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
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObjectAnimator == null) {
      return false;
    }
    return localObjectAnimator.isRunning();
  }
  
  public void b()
  {
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObjectAnimator != null) {
      localObjectAnimator.end();
    }
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131707066));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setVisibility(paramInt1);
    if (paramInt2 < 0)
    {
      paramInt1 = 0;
    }
    else
    {
      paramInt1 = paramInt2;
      if (paramInt2 > 100) {
        paramInt1 = 100;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setProgress(paramInt1);
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
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707062));
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131707064));
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setVisibility(paramInt);
  }
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
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
    int i = getResources().getColor(2131167039);
    if ((ThemeUtil.curThemeId.equals("1103")) || (ThemeUtil.curThemeId.equals("2920"))) {
      i = getResources().getColor(2131167038);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setBgAndProgressColor(100, i, 100, getResources().getColor(2131167037));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setBgAndProgressUseAlpha(false, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setStrokeWidth(1.5F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setmShadowColor(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setNeedSweepGradient(false, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSweepGradientCircleProgress.setShadowRadius(AIOUtils.b(1.0F, getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.MusicPanelView
 * JD-Core Version:    0.7.0.1
 */