package com.tencent.mobileqq.listentogether.ui;

import actj;
import ajya;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arty;
import arug;
import aylu;
import bavw;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.widget.AlphaClickableImageView;
import com.tencent.widget.PatchedButton;

public class MusicPanelView
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View.OnClickListener a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
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
    LayoutInflater.from(getContext()).inflate(2131560624, this, true);
    setBackgroundResource(2130843978);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364695));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView = ((AlphaClickableImageView)findViewById(2131376455));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370589));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370568));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373496));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131370583));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)findViewById(2131368754));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370586));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370585));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843991);
    int i = actj.a(8.0F, this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.getResources());
    arty.a(this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView, i, i, i, i);
    this.jdField_a_of_type_Int = actj.a(31.0F, getResources());
    i = getResources().getColor(2131166839);
    if ((ThemeUtil.curThemeId.equals("1103")) || (ThemeUtil.curThemeId.equals("2920"))) {
      i = getResources().getColor(2131166838);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, i, 100, getResources().getColor(2131166837));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressUseAlpha(false, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(1.5F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setmShadowColor(0);
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
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new arug(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131707040));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setVisibility(paramInt1);
    if (paramInt2 == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130843992);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription(ajya.a(2131707038));
    }
    while (paramInt2 != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130843993);
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription(ajya.a(2131707036));
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramString);
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
        ((URLDrawable)localObject).setDecodeHandler(bavw.z);
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
    aylu.a().a(getContext(), this);
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
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(ajya.a(2131707039));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(paramInt1);
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramInt1);
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
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131707035));
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(ajya.a(2131707037));
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.MusicPanelView
 * JD-Core Version:    0.7.0.1
 */