package com.tencent.mobileqq.businessCard.views;

import abhs;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.businessCard.helpers.BusinessCardChildViewTransform;
import com.tencent.mobileqq.businessCard.helpers.PathInterpolatorDonut;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class BusinessCardChildView
  extends FrameLayout
  implements View.OnClickListener
{
  public static final Interpolator a;
  float jdField_a_of_type_Float;
  abhs jdField_a_of_type_Abhs;
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  Object jdField_a_of_type_JavaLangObject;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean;
  TextView d;
  TextView e;
  
  static
  {
    jdField_a_of_type_AndroidViewAnimationInterpolator = new PathInterpolatorDonut(0.4F, 0.0F, 0.2F, 1.0F);
  }
  
  public BusinessCardChildView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BusinessCardChildView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BusinessCardChildView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setTaskProgress(a());
    super.setOnClickListener(this);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangObject != null;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  @TargetApi(11)
  void a()
  {
    if (BusinessCardUtils.a(11)) {
      setLayerType(0, null);
    }
    BusinessCardChildViewTransform.a(this);
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof URLDrawable))) {
      ((URLDrawable)localDrawable).cancelDownload();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
  }
  
  void a(abhs paramabhs)
  {
    this.jdField_a_of_type_Abhs = paramabhs;
  }
  
  @TargetApi(11)
  void a(BusinessCardChildViewTransform paramBusinessCardChildViewTransform, int paramInt)
  {
    paramBusinessCardChildViewTransform.a(this, paramInt, jdField_a_of_type_AndroidViewAnimationInterpolator, false, true);
    BusinessCardUtils.a(this.jdField_a_of_type_AndroidAnimationObjectAnimator);
    setTaskProgress(paramBusinessCardChildViewTransform.c);
    if ((this.jdField_a_of_type_Boolean) && (paramBusinessCardChildViewTransform.jdField_a_of_type_Float > 0.87F))
    {
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(4);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    if ((!a()) || (!this.jdField_a_of_type_JavaLangObject.equals(paramObject))) {
      return;
    }
    label109:
    Resources localResources;
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.d.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString3);
      if (paramString4 == null) {
        break label246;
      }
      this.e.setText(paramString4);
      this.e.setVisibility(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramBoolean) {
        break label262;
      }
      localResources = getResources();
      paramObject = paramString1;
      if (paramString1 == null) {
        paramObject = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      paramString2 = paramString3;
      if (paramString3 == null) {
        paramString2 = "";
      }
      paramString3 = paramString4;
      if (paramString4 == null) {
        paramString3 = "";
      }
    }
    label262:
    for (this.jdField_a_of_type_JavaLangString = localResources.getString(2131437079, new Object[] { paramObject, paramString1, paramString2, paramString3 });; this.jdField_a_of_type_JavaLangString = paramString1)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.d.setVisibility(0);
      this.d.setText(paramString1);
      break;
      label246:
      this.jdField_a_of_type_Boolean = false;
      this.e.setVisibility(4);
      break label109;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842282);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("BusinessCardChildView", 2, "bindCardPictureWithUrl:mTaskProgress=" + this.jdField_a_of_type_Float + "pic=" + paramString);
    }
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = 500;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = 300;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = super.getResources().getDrawable(2130842282);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = super.getResources().getDrawable(2130842282);
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("BusinessCardChildView", 2, "get drawable failed : " + localException.toString() + " url: " + paramString);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842282);
    }
  }
  
  void b()
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Abhs != null) {
      this.jdField_a_of_type_Abhs.a(this, false);
    }
    super.invalidate();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void getHitRect(Rect paramRect)
  {
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11)
    {
      RectF localRectF = new RectF();
      ViewHelper.a(localRectF, this);
      paramRect.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
      return;
    }
    super.getHitRect(paramRect);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Abhs != null) {
      this.jdField_a_of_type_Abhs.a(this, a());
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369741);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369743));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131369744);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369746));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369747));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369748));
    this.d = ((TextView)findViewById(2131369745));
    this.e = ((TextView)findViewById(2131369742));
    View localView = findViewById(2131368437);
    if (Build.VERSION.SDK_INT > 10) {
      localView.setLayerType(1, null);
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean) {
      b();
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setContentDescription(this.jdField_a_of_type_JavaLangString);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int i = paramInt1 - getPaddingLeft() - getPaddingRight();
    int j = paramInt2 - getPaddingBottom() - getPaddingTop();
    this.jdField_a_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
    this.jdField_a_of_type_AndroidWidgetImageView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(j - (int)(97.0F * DeviceInfoUtil.a()), 1073741824));
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11) && (paramMotionEvent.getAction() == 2)) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setFocusedTask(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Abhs != null) {
      this.jdField_a_of_type_Abhs.a(this, true);
    }
    super.setFocusableInTouchMode(true);
    super.requestFocus();
    super.setFocusableInTouchMode(false);
    super.invalidate();
  }
  
  public void setTaskProgress(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.BusinessCardChildView
 * JD-Core Version:    0.7.0.1
 */