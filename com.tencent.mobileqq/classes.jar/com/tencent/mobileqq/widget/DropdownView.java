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
import anzj;
import bixp;
import bixq;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DropdownView
  extends RelativeLayout
  implements PopupWindow.OnDismissListener
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  public Drawable a;
  public InputMethodManager a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
  public bixq a;
  public boolean a;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public DropdownView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bixq = new bixq(this, paramContext);
    a(paramContext);
  }
  
  public DropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bixq = new bixq(this, paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public DropdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bixq = new bixq(this, paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    setPadding(0, 0, 0, 0);
    Object localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    addView(this.jdField_a_of_type_Bixq, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_Bixq.setDropDownVerticalOffset(0);
    localObject1 = new LinearLayout(paramContext);
    new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, this.jdField_a_of_type_Bixq.getId());
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding((int)(this.jdField_a_of_type_Float * 10.0F), (int)(this.jdField_a_of_type_Float * 10.0F), (int)(this.jdField_a_of_type_Float * 15.0F), (int)(this.jdField_a_of_type_Float * 10.0F));
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839391);
    this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131702445));
    new LinearLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    localObject2 = new LinearLayout.LayoutParams((int)(44.0F * this.jdField_a_of_type_Float), (int)(39.0F * this.jdField_a_of_type_Float));
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout)localObject1).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(571);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(1.0F * this.jdField_a_of_type_Float), (int)(this.jdField_a_of_type_Float * 10.0F), (int)(this.jdField_a_of_type_Float * 15.0F), (int)(this.jdField_a_of_type_Float * 10.0F));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131702446));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840594);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840595);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    paramContext = new LinearLayout.LayoutParams((int)(35.0F * this.jdField_a_of_type_Float), (int)(33.0F * this.jdField_a_of_type_Float));
    paramContext.gravity = 16;
    ((LinearLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bixp(this));
    try
    {
      paramContext = this.jdField_a_of_type_Bixq.getClass().getSuperclass().getDeclaredField("mPopup");
      paramContext.setAccessible(true);
      paramContext = paramContext.get(this.jdField_a_of_type_Bixq);
      paramContext.getClass().getMethod("setOnDismissListener", new Class[] { PopupWindow.OnDismissListener.class }).invoke(paramContext, new Object[] { this });
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public AutoCompleteTextView a()
  {
    return this.jdField_a_of_type_Bixq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DropdownView
 * JD-Core Version:    0.7.0.1
 */