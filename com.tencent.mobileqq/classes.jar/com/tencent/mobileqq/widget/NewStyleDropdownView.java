package com.tencent.mobileqq.widget;

import akvc;
import akvd;
import akvf;
import akvg;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class NewStyleDropdownView
  extends RelativeLayout
  implements PopupWindow.OnDismissListener
{
  private float jdField_a_of_type_Float;
  public akvg a;
  public Drawable a;
  public InputMethodManager a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public NewStyleDropdownView.DropdownCallback a;
  public boolean a;
  public Drawable b;
  private ImageView b;
  private ImageView c;
  
  public NewStyleDropdownView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Akvg = new akvg(this, paramContext);
    a(paramContext);
  }
  
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Akvg = new akvg(this, paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Akvg = new akvg(this, paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Akvg.setHintTextColor(getResources().getColor(2131493050));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    setPadding(0, 0, 0, 0);
    Object localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    addView(this.jdField_a_of_type_Akvg, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_Akvg.setDropDownVerticalOffset(0);
    this.jdField_a_of_type_Akvg.setDropDownHeight((int)(175.0F * this.jdField_a_of_type_Float));
    localObject1 = new LinearLayout(paramContext);
    new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, this.jdField_a_of_type_Akvg.getId());
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject2);
    this.c = new ImageView(paramContext);
    int i = (int)(33.0F * this.jdField_a_of_type_Float);
    localObject2 = new FrameLayout.LayoutParams(i, i);
    this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.c, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new akvc(this));
    localObject2 = new FrameLayout.LayoutParams(i - 4, i - 4);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842077);
    this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("清除帐号");
    new LinearLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    localObject2 = new LinearLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 25.0F), (int)(this.jdField_a_of_type_Float * 25.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ((int)(8.0F * this.jdField_a_of_type_Float));
    ((LinearLayout)localObject1).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(571);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("帐号列表");
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839303);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839304);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    paramContext = new LinearLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 25.0F), (int)(this.jdField_a_of_type_Float * 25.0F));
    paramContext.gravity = 16;
    paramContext.leftMargin = ((int)(8.0F * this.jdField_a_of_type_Float));
    ((LinearLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new akvd(this));
    try
    {
      paramContext = this.jdField_a_of_type_Akvg.getClass().getSuperclass().getDeclaredField("mPopup");
      paramContext.setAccessible(true);
      paramContext = paramContext.get(this.jdField_a_of_type_Akvg);
      paramContext.getClass().getMethod("setOnDismissListener", new Class[] { PopupWindow.OnDismissListener.class }).invoke(paramContext, new Object[] { this });
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public AutoCompleteTextView a()
  {
    return this.jdField_a_of_type_Akvg;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akvg != null) {
      this.jdField_a_of_type_Akvg.showDropDown();
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
      }
      for (;;)
      {
        paramObject = new AlphaAnimation(0.2F, 1.0F);
        paramObject.setDuration(500L);
        this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(paramObject);
        return;
        if ((paramObject instanceof Drawable))
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)paramObject);
          this.c.setVisibility(4);
        }
        else
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130839300);
          this.c.setVisibility(0);
        }
      }
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback.c();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new akvf(this), 500L);
  }
  
  public void setHeadBorder(int paramInt)
  {
    this.c.setImageResource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView
 * JD-Core Version:    0.7.0.1
 */