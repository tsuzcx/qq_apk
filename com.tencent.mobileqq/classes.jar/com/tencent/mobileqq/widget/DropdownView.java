package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DropdownView
  extends RelativeLayout
  implements PopupWindow.OnDismissListener
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
  DropdownView.AutoCompleteView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView;
  boolean jdField_a_of_type_Boolean = false;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public DropdownView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView = new DropdownView.AutoCompleteView(this, paramContext);
    a(paramContext);
  }
  
  public DropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView = new DropdownView.AutoCompleteView(this, paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public DropdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView = new DropdownView.AutoCompleteView(this, paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    setPadding(0, 0, 0, 0);
    Object localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    addView(this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView.setDropDownVerticalOffset(0);
    localObject1 = new LinearLayout(paramContext);
    new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView.getId());
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
    float f = this.jdField_a_of_type_Float;
    ((ImageView)localObject2).setPadding((int)(f * 10.0F), (int)(f * 10.0F), (int)(f * 15.0F), (int)(f * 10.0F));
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839382);
    this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131703710));
    new LinearLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    f = this.jdField_a_of_type_Float;
    localObject2 = new LinearLayout.LayoutParams((int)(44.0F * f), (int)(f * 39.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout)localObject1).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(571);
    paramContext = this.jdField_a_of_type_AndroidWidgetImageView;
    f = this.jdField_a_of_type_Float;
    paramContext.setPadding((int)(1.0F * f), (int)(f * 10.0F), (int)(15.0F * f), (int)(f * 10.0F));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131703711));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840675);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840676);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    f = this.jdField_a_of_type_Float;
    paramContext = new LinearLayout.LayoutParams((int)(35.0F * f), (int)(f * 33.0F));
    paramContext.gravity = 16;
    ((LinearLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new DropdownView.1(this));
    try
    {
      paramContext = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView.getClass().getSuperclass().getDeclaredField("mPopup");
      paramContext.setAccessible(true);
      paramContext = paramContext.get(this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView);
      paramContext.getClass().getMethod("setOnDismissListener", new Class[] { PopupWindow.OnDismissListener.class }).invoke(paramContext, new Object[] { this });
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public AutoCompleteTextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public ImageView b()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    new Handler().postDelayed(new DropdownView.2(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DropdownView
 * JD-Core Version:    0.7.0.1
 */