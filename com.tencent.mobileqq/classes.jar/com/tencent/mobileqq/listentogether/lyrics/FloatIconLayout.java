package com.tencent.mobileqq.listentogether.lyrics;

import afur;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anni;
import avuq;
import avur;
import avus;
import avut;
import bdzx;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FloatIconLayout
  extends FloatBaseLayout
  implements ValueAnimator.AnimatorUpdateListener, View.OnClickListener, URLDrawable.URLDrawableListener
{
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  DownloadParams.DecodeHandler jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler = new avur(this);
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  String jdField_a_of_type_JavaLangString;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  ImageView c;
  public int d;
  boolean d;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  float f;
  
  public FloatIconLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_d_of_type_Boolean = false;
    f();
  }
  
  private void a(float paramFloat)
  {
    float f1 = this.jdField_b_of_type_AndroidViewView.getRotation();
    if (Math.abs(paramFloat - f1) < 0.5F)
    {
      this.jdField_b_of_type_AndroidViewView.setRotation(paramFloat);
      return;
    }
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { f1, paramFloat });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration((Math.abs(paramFloat - f1) * 200.0F / 28.0F));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new avuq(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatBaseLayout.Icon", 2, "updateMusicIcon url:" + paramString + " mAlbumUrl:" + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView.setRotation(0.0F);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mMemoryCacheKeySuffix = "round";
      int i = this.jdField_d_of_type_Int;
      paramString.mRequestWidth = i;
      paramString.mRequestHeight = i;
      paramString.mFailedDrawable = bdzx.a;
      paramString.mLoadingDrawable = bdzx.a;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
        this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, paramString);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(this.jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler);
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    h();
  }
  
  private void f()
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131561019, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131368165));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131364554));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131371449));
    this.c = ((ImageView)((View)localObject).findViewById(2131371450));
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131376817);
    this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131371470);
    addView((View)localObject, new FrameLayout.LayoutParams(-2, -2));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131703413));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131703414));
    this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131297238));
    this.jdField_b_of_type_Int = ((int)getResources().getDimension(2131297237));
    this.jdField_d_of_type_Int = afur.a(40.0F, getResources());
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
    localObject = new LinearInterpolator();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator((TimeInterpolator)localObject);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(10000L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewView.setPivotX(afur.a(40.0F, getResources()) / 2);
    this.jdField_a_of_type_AndroidViewView.setPivotY(afur.a(40.0F, getResources()) / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
    this.jdField_b_of_type_AndroidViewView.setPivotX(afur.a(20.0F, getResources()));
    this.jdField_b_of_type_AndroidViewView.setPivotY(afur.a(3.0F, getResources()));
    this.jdField_b_of_type_AndroidViewView.setRotation(-28.0F);
    this.f = 0.0F;
    h();
  }
  
  private void g()
  {
    if (c())
    {
      if (this.jdField_d_of_type_Boolean)
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          this.f = 0.0F;
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          this.jdField_e_of_type_Boolean = true;
          a(0.0F);
        }
        return;
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.f = 0.0F;
      a(-28.0F);
      this.jdField_e_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.f = 0.0F;
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void h()
  {
    this.c.setVisibility(8);
  }
  
  private void i()
  {
    this.c.setVisibility(0);
  }
  
  public int a(avut paramavut)
  {
    return paramavut.jdField_a_of_type_Int - this.jdField_a_of_type_Int / 2;
  }
  
  public void a(avut paramavut)
  {
    if (paramavut == null) {
      return;
    }
    if ((paramavut.f) && (!paramavut.g) && (paramavut.jdField_c_of_type_Boolean)) {
      a(paramavut.jdField_a_of_type_JavaLangString);
    }
    paramavut.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    paramavut.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
  }
  
  public boolean a(avut paramavut)
  {
    boolean bool1 = true;
    if (paramavut == null) {
      return false;
    }
    boolean bool2 = c();
    if ((paramavut.f) && (!paramavut.g) && (paramavut.jdField_c_of_type_Boolean)) {
      if (a()) {}
    }
    for (;;)
    {
      if (bool2 != c()) {
        g();
      }
      return bool1;
      bool1 = false;
      continue;
      if (b()) {
        bool1 = false;
      }
    }
  }
  
  public int b(avut paramavut)
  {
    return paramavut.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    g();
    return bool;
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_AndroidGraphicsPaint.getColorFilter() == null) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
        paramCanvas.saveLayer(null, this.jdField_a_of_type_AndroidGraphicsPaint, 31);
      }
      super.dispatchDraw(paramCanvas);
      if (i != 0) {
        paramCanvas.restore();
      }
      return;
    }
  }
  
  public void e()
  {
    invalidate();
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f3 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.jdField_a_of_type_AndroidViewView.getRotation() + (f3 - this.f);
    float f1 = f2;
    if (f2 > 360.0F) {
      f1 = f2 - 360.0F;
    }
    this.jdField_a_of_type_AndroidViewView.setRotation(f1);
    this.f = f3;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Avus != null)
      {
        this.jdField_a_of_type_Avus.d();
        continue;
        if (this.jdField_a_of_type_Avus != null) {
          this.jdField_a_of_type_Avus.c();
        }
      }
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    h();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    i();
  }
  
  public void setPlayState(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout
 * JD-Core Version:    0.7.0.1
 */