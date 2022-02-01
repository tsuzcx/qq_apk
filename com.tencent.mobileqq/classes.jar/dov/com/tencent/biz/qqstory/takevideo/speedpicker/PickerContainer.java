package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anvx;
import bpga;
import bpgq;
import bphd;
import bphe;
import bphf;
import bphg;
import bphh;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.lang.ref.WeakReference;

public class PickerContainer
  extends RelativeLayout
  implements bphd
{
  public static final String a;
  public float a;
  private int jdField_a_of_type_Int = 58;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  Property<PickerContainer, Float> jdField_a_of_type_AndroidUtilProperty = new bphe(this, Float.class, "containerAlpha");
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bpga jdField_a_of_type_Bpga;
  private bpgq jdField_a_of_type_Bpgq;
  private PickerBarLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout;
  private Float jdField_a_of_type_JavaLangFloat = Float.valueOf(1.0F);
  private WeakReference<bphh> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  public float b;
  private boolean b;
  private float c = 200.0F;
  private float d = 497.0F;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131707610);
  }
  
  public PickerContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PickerContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PickerContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = 333.60001F;
    this.jdField_b_of_type_Float = 333.60001F;
  }
  
  private static float a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    return paramResources.getDisplayMetrics().density * paramFloat;
  }
  
  public static float a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return paramFloat;
    }
    return a(paramFloat / 2.0F, paramContext.getResources());
  }
  
  private Float a()
  {
    return this.jdField_a_of_type_JavaLangFloat;
  }
  
  private void a(Context paramContext)
  {
    this.c = a(paramContext, this.c);
    this.jdField_a_of_type_Float = a(paramContext, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = a(paramContext, this.jdField_b_of_type_Float);
    this.d = a(paramContext, this.d);
    this.jdField_a_of_type_Int = AIOUtils.dp2px(this.jdField_a_of_type_Int, paramContext.getResources());
  }
  
  private void a(Float paramFloat)
  {
    this.jdField_a_of_type_JavaLangFloat = paramFloat;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    float f = 1.0F;
    if (!paramBoolean) {
      f = 0.0F;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.jdField_a_of_type_AndroidUtilProperty, new float[] { this.jdField_a_of_type_JavaLangFloat.floatValue(), f }) });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramLong);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bphf(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bphg(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Bpgq != null)
    {
      this.jdField_a_of_type_Bpgq.a();
      this.jdField_a_of_type_Bpgq = null;
    }
    if (this.jdField_a_of_type_Bpga != null)
    {
      this.jdField_a_of_type_Bpga.a();
      this.jdField_a_of_type_Bpga = null;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidUtilProperty = null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      if (this.jdField_a_of_type_Bpga != null)
      {
        this.jdField_a_of_type_Bpga.stop();
        this.jdField_a_of_type_Bpga.a(false);
        this.jdField_a_of_type_Bpga.a(1);
        this.jdField_a_of_type_Bpga.start();
      }
    }
    while ((paramInt == 4) || (this.jdField_a_of_type_Bpga == null)) {
      return;
    }
    this.jdField_a_of_type_Bpga.stop();
    this.jdField_a_of_type_Bpga.a(false);
    this.jdField_a_of_type_Bpga.a(2);
    this.jdField_a_of_type_Bpga.start();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PickerContainer", 2, "onSelected: index:" + paramInt + " text:" + paramString + " bstart:" + paramBoolean1 + " bend:" + paramBoolean2);
    }
    bphh localbphh = (bphh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbphh != null)
    {
      if (!paramBoolean1) {
        break label125;
      }
      this.jdField_b_of_type_Boolean = true;
      localbphh.a(paramInt, paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PickerContainer.4(this, paramString), 300L);
      return;
      label125:
      if (paramBoolean2)
      {
        this.jdField_b_of_type_Boolean = false;
        localbphh.c(paramInt, paramString);
      }
      else
      {
        localbphh.b(paramInt, paramString);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.a(paramInt, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    if (paramLong > 0L)
    {
      setVisibility(0);
      b(paramBoolean, paramLong);
      return;
    }
    setAlpha(1.0F);
    if (paramBoolean)
    {
      setVisibility(0);
      return;
    }
    setVisibility(8);
  }
  
  public boolean a(EditVideoParams paramEditVideoParams, bphh parambphh)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambphh);
    a(getContext());
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    parambphh = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_Bpga = new bpga();
    this.jdField_a_of_type_Bpga.a(getContext());
    this.jdField_a_of_type_AndroidViewView.setBackground(this.jdField_a_of_type_Bpga);
    addView(this.jdField_a_of_type_AndroidViewView, parambphh);
    parambphh = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.bottomMargin = this.jdField_a_of_type_Int;
    addView(parambphh, localLayoutParams);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout = new PickerBarLayout(getContext());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.a(paramEditVideoParams, getContext(), this);
    this.d = (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.a() * 60 + 80 + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.a() * 5 + 22 + 70);
    this.d = a(getContext(), this.d);
    paramEditVideoParams = new RelativeLayout.LayoutParams((int)this.c, (int)this.d);
    paramEditVideoParams.addRule(11);
    paramEditVideoParams.addRule(15);
    parambphh.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout, paramEditVideoParams);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    paramEditVideoParams = new RelativeLayout.LayoutParams((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    paramEditVideoParams.addRule(13);
    this.jdField_a_of_type_Bpgq = new bpgq();
    this.jdField_a_of_type_Bpgq.a(getContext(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, 1.2F);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackground(this.jdField_a_of_type_Bpgq);
    parambphh.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramEditVideoParams);
    return true;
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_Bpgq != null)
      {
        this.jdField_a_of_type_Bpgq.stop();
        if ((this.jdField_a_of_type_Bpgq.a() == 1) || (this.jdField_a_of_type_Bpgq.a() == 3))
        {
          this.jdField_a_of_type_Bpgq.a(2);
          this.jdField_a_of_type_Bpgq.start();
        }
      }
    }
  }
  
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer
 * JD-Core Version:    0.7.0.1
 */