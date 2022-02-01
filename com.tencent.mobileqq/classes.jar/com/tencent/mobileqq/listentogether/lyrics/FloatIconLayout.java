package com.tencent.mobileqq.listentogether.lyrics;

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
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  DownloadParams.DecodeHandler jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler = new FloatIconLayout.2(this);
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  String jdField_a_of_type_JavaLangString;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  ImageView c;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  float f;
  
  public FloatIconLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void a(float paramFloat)
  {
    float f1 = this.jdField_b_of_type_AndroidViewView.getRotation();
    float f2 = paramFloat - f1;
    if (Math.abs(f2) < 0.5F)
    {
      this.jdField_b_of_type_AndroidViewView.setRotation(paramFloat);
      return;
    }
    ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { f1, paramFloat });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration((Math.abs(f2) * 200.0F / 28.0F));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new FloatIconLayout.1(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateMusicIcon url:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" mAlbumUrl:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("FloatBaseLayout.Icon", 2, ((StringBuilder)localObject).toString());
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
      paramString.mFailedDrawable = URLDrawableHelperConstants.a;
      paramString.mLoadingDrawable = URLDrawableHelperConstants.a;
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localObject != null)
      {
        ((URLDrawable)localObject).setURLDrawableListener(null);
        this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, paramString);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(this.jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler);
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (paramString != null)
    {
      paramString.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    h();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ((ImageView)findViewById(paramInt1)).setImageResource(paramInt2);
  }
  
  private void f()
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131560936, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131368368));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131364719));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131371625));
    this.c = ((ImageView)((View)localObject).findViewById(2131371626));
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131376838);
    this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131371645);
    addView((View)localObject, new FrameLayout.LayoutParams(-2, -2));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131704729));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131704730));
    this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131297321));
    this.jdField_b_of_type_Int = ((int)getResources().getDimension(2131297320));
    this.jdField_d_of_type_Int = AIOUtils.b(40.0F, getResources());
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
    localObject = new LinearInterpolator();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator((TimeInterpolator)localObject);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(10000L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewView.setPivotX(AIOUtils.b(40.0F, getResources()) / 2);
    this.jdField_a_of_type_AndroidViewView.setPivotY(AIOUtils.b(40.0F, getResources()) / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
    this.jdField_b_of_type_AndroidViewView.setPivotX(AIOUtils.b(20.0F, getResources()));
    this.jdField_b_of_type_AndroidViewView.setPivotY(AIOUtils.b(3.0F, getResources()));
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
      }
      else
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        this.f = 0.0F;
        a(-28.0F);
        this.jdField_e_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.f = 0.0F;
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  private void h()
  {
    this.c.setVisibility(8);
  }
  
  private void i()
  {
    this.c.setVisibility(0);
  }
  
  public int a(FloatParams paramFloatParams)
  {
    return paramFloatParams.jdField_a_of_type_Int - this.jdField_a_of_type_Int / 2;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    QLog.d("FloatBaseLayout.Icon", 1, String.format("[float-icon] onMutualLevelChange mutualLevel=%d vasSkinShowing=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    if (paramBoolean) {
      return;
    }
    int i = 2130844786;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          paramInt = i;
        } else {
          paramInt = 2130844789;
        }
      }
      else {
        paramInt = 2130844788;
      }
    }
    else {
      paramInt = 2130844787;
    }
    b(2131371617, paramInt);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130844792);
    b(2131371651, 2130844791);
    b(2131364719, 2130844790);
  }
  
  public void a(FloatParams paramFloatParams)
  {
    if (paramFloatParams == null) {
      return;
    }
    if ((paramFloatParams.f) && (!paramFloatParams.g) && (paramFloatParams.jdField_c_of_type_Boolean)) {
      a(paramFloatParams.jdField_a_of_type_JavaLangString);
    }
    paramFloatParams.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    paramFloatParams.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
  }
  
  public boolean a(FloatParams paramFloatParams)
  {
    if (paramFloatParams == null) {
      return false;
    }
    boolean bool2 = c();
    boolean bool1;
    if ((paramFloatParams.f) && (!paramFloatParams.g) && (paramFloatParams.jdField_c_of_type_Boolean)) {
      bool1 = a();
    } else {
      bool1 = b();
    }
    if (bool2 != c()) {
      g();
    }
    return bool1 ^ true;
  }
  
  public int b(FloatParams paramFloatParams)
  {
    return paramFloatParams.jdField_b_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  public void b()
  {
    super.b();
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable != null)
    {
      localURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
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
    int i;
    if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId))) {
      i = 0;
    } else {
      i = 1;
    }
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
    int i = paramView.getId();
    if (i != 2131364719)
    {
      if ((i == 2131371625) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback.c();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback.d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout
 * JD-Core Version:    0.7.0.1
 */