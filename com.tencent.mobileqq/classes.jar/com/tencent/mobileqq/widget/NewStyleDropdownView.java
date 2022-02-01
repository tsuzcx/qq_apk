package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableImageView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class NewStyleDropdownView
  extends RelativeLayout
  implements PopupWindow.OnDismissListener
{
  private float jdField_a_of_type_Float;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  NewStyleDropdownView.AutoCompleteView jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView;
  public NewStyleDropdownView.DropdownCallback a;
  boolean jdField_a_of_type_Boolean = false;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public NewStyleDropdownView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView = new NewStyleDropdownView.AutoCompleteView(this, paramContext);
    a(paramContext);
  }
  
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView = new NewStyleDropdownView.AutoCompleteView(this, paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView = new NewStyleDropdownView.AutoCompleteView(this, paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(float paramFloat, Resources paramResources)
  {
    return ViewUtils.a(paramFloat);
  }
  
  private void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView, new Object[] { Integer.valueOf(8) });
      }
      catch (Exception localException)
      {
        QLog.w("NewStyleDropdownView", 2, "disable auto fill error", localException);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setHintTextColor(getResources().getColor(2131165798));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setHighlightColor(Color.parseColor("#8000CAFC"));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    setPadding(0, 0, 0, 0);
    Object localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    addView(this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setDropDownVerticalOffset(ViewUtils.a(12.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setDropDownHeight(a(251.5F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setPadding(ViewUtils.a(63.0F), 0, ViewUtils.a(63.0F), 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setDropDownBackgroundResource(2130845544);
    localObject1 = new SpannableString(HardCodeUtil.a(2131707573));
    ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(17, true), 0, ((SpannableString)localObject1).length(), 33);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setHint((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    Object localObject2 = (RelativeLayout.LayoutParams)localObject1;
    ((RelativeLayout.LayoutParams)localObject2).setMargins(ViewUtils.a(10.0F), 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
    this.c = new ImageView(paramContext);
    int i = ViewUtils.a(40.0F) + 4;
    localObject1 = new FrameLayout.LayoutParams(i, i);
    this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((FrameLayout.LayoutParams)localObject1).gravity = 17;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.c, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    i -= 4;
    localObject1 = new FrameLayout.LayoutParams(i, i);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((FrameLayout.LayoutParams)localObject1).gravity = 17;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844689);
    this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707574));
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
    float f = this.jdField_a_of_type_Float;
    ((ImageView)localObject2).setPadding((int)(f * 10.0F), (int)(f * 10.0F), (int)(f * 10.0F), (int)(f * 10.0F));
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, ViewUtils.a(40.0F), 0);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetImageView = new AlphaClickableImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(571);
    paramContext = this.jdField_a_of_type_AndroidWidgetImageView;
    f = this.jdField_a_of_type_Float;
    paramContext.setPadding((int)(f * 10.0F), (int)(f * 10.0F), (int)(f * 10.0F), (int)(f * 10.0F));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707572));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840670);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840671);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.setMargins(0, 0, ViewUtils.a(15.0F), 0);
    paramContext.addRule(15);
    paramContext.addRule(11, -1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new NewStyleDropdownView.1(this));
    try
    {
      paramContext = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getClass().getSuperclass().getDeclaredField("mPopup");
      paramContext.setAccessible(true);
      paramContext = paramContext.get(this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView);
      paramContext.getClass().getMethod("setOnDismissListener", new Class[] { PopupWindow.OnDismissListener.class }).invoke(paramContext, new Object[] { this });
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public AutoCompleteTextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    NewStyleDropdownView.AutoCompleteView localAutoCompleteView = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView;
    if (localAutoCompleteView != null) {
      localAutoCompleteView.showDropDown();
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if ((paramObject instanceof Bitmap))
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap((Bitmap)paramObject);
        this.c.setVisibility(0);
        return;
      }
      if ((paramObject instanceof Drawable))
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)paramObject);
        this.c.setVisibility(4);
        return;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130840667);
      this.c.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public ImageView b()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "onDismiss set icon down");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    NewStyleDropdownView.DropdownCallback localDropdownCallback = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback;
    if (localDropdownCallback != null) {
      localDropdownCallback.b();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new NewStyleDropdownView.2(this), 500L);
  }
  
  public void setHeadBorder(int paramInt)
  {
    this.c.setImageResource(paramInt);
  }
  
  public void setHeadDrawableDownListener(URLDrawableDownListener.Adapter paramAdapter)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(paramAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView
 * JD-Core Version:    0.7.0.1
 */