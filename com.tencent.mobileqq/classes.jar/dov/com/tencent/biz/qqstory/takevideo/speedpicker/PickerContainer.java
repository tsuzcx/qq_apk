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
import aonh;
import aoni;
import aonj;
import aonk;
import aonl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PickerContainer
  extends RelativeLayout
  implements aonh
{
  public float a;
  private int jdField_a_of_type_Int = 58;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  Property jdField_a_of_type_AndroidUtilProperty = new aoni(this, Float.class, "containerAlpha");
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ContainerDrawable jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable;
  private HintDrawable jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable;
  private PickerBarLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout;
  private Float jdField_a_of_type_JavaLangFloat = Float.valueOf(1.0F);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  public float b;
  private boolean b;
  private float c = 200.0F;
  private float d = 497.0F;
  
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
    this.jdField_a_of_type_Int = AIOUtils.a(this.jdField_a_of_type_Int, paramContext.getResources());
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
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aonj(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new aonk(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable = null;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable = null;
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
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.stop();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.a(false);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.a(1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.start();
      }
    }
    while ((paramInt == 4) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable == null)) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.stop();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.a(false);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.a(2);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.start();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PickerContainer", 2, "onSelected: index:" + paramInt + " text:" + paramString + " bstart:" + paramBoolean1 + " bend:" + paramBoolean2);
    }
    PickerContainer.PickerContainerListener localPickerContainerListener = (PickerContainer.PickerContainerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localPickerContainerListener != null)
    {
      if (!paramBoolean1) {
        break label123;
      }
      this.jdField_b_of_type_Boolean = true;
      localPickerContainerListener.b(paramInt, paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aonl(this, paramString), 300L);
      return;
      label123:
      if (paramBoolean2)
      {
        this.jdField_b_of_type_Boolean = false;
        localPickerContainerListener.d(paramInt, paramString);
      }
      else
      {
        localPickerContainerListener.c(paramInt, paramString);
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
  
  public boolean a(PickerContainer.PickerContainerListener paramPickerContainerListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPickerContainerListener);
    a(getContext());
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    paramPickerContainerListener = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable = new ContainerDrawable();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable.a(getContext());
    this.jdField_a_of_type_AndroidViewView.setBackground(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerContainerDrawable);
    addView(this.jdField_a_of_type_AndroidViewView, paramPickerContainerListener);
    paramPickerContainerListener = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.bottomMargin = this.jdField_a_of_type_Int;
    addView(paramPickerContainerListener, localLayoutParams);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout = new PickerBarLayout(getContext());
    localLayoutParams = new RelativeLayout.LayoutParams((int)this.c, (int)this.d);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    paramPickerContainerListener.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout, localLayoutParams);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.a(getContext(), this);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    localLayoutParams = new RelativeLayout.LayoutParams((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable = new HintDrawable();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable.a(getContext(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, 1.2F);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackground(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable);
    paramPickerContainerListener.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    return true;
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable.stop();
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable.a() == 1) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable.a() == 3))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable.a(2);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerHintDrawable.start();
        }
      }
    }
  }
  
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer
 * JD-Core Version:    0.7.0.1
 */