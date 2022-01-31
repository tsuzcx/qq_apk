package com.tencent.mobileqq.widget;

import aepi;
import alud;
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
import bere;
import berf;
import berg;
import berh;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableImageView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class NewStyleDropdownView
  extends RelativeLayout
  implements PopupWindow.OnDismissListener
{
  private float jdField_a_of_type_Float;
  public Drawable a;
  public InputMethodManager a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
  public berg a;
  public berh a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public boolean a;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public NewStyleDropdownView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Berg = new berg(this, paramContext);
    a(paramContext);
  }
  
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Berg = new berg(this, paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Berg = new berg(this, paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_Berg, new Object[] { Integer.valueOf(8) });
      this.jdField_a_of_type_Berg.setHintTextColor(getResources().getColor(2131165738));
      this.jdField_a_of_type_Berg.setHighlightColor(Color.parseColor("#8000CAFC"));
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)paramContext.getSystemService("input_method"));
      this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
      setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      setPadding(0, 0, 0, 0);
      Object localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      addView(this.jdField_a_of_type_Berg, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_Berg.setDropDownVerticalOffset(aepi.a(12.0F, getResources()));
      this.jdField_a_of_type_Berg.setDropDownHeight(aepi.a(251.5F, getResources()));
      this.jdField_a_of_type_Berg.setPadding(aepi.a(63.0F, getResources()), 0, aepi.a(63.0F, getResources()), 0);
      this.jdField_a_of_type_Berg.setGravity(17);
      this.jdField_a_of_type_Berg.setDropDownBackgroundResource(2130844977);
      localObject = new SpannableString(alud.a(2131707957));
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(17, true), 0, ((SpannableString)localObject).length(), 33);
      this.jdField_a_of_type_Berg.setHint((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(aepi.a(10.0F, getResources()), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
      this.c = new ImageView(paramContext);
      int i = aepi.a(40.0F, getResources()) + 4;
      localObject = new FrameLayout.LayoutParams(i, i);
      this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.c, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new bere(this));
      localObject = new FrameLayout.LayoutParams(i - 4, i - 4);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844303);
      this.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131707958));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding((int)(this.jdField_a_of_type_Float * 10.0F), (int)(this.jdField_a_of_type_Float * 10.0F), (int)(this.jdField_a_of_type_Float * 10.0F), (int)(this.jdField_a_of_type_Float * 10.0F));
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, aepi.a(40.0F, getResources()), 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView = new AlphaClickableImageView(paramContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setId(571);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(this.jdField_a_of_type_Float * 10.0F), (int)(this.jdField_a_of_type_Float * 10.0F), (int)(this.jdField_a_of_type_Float * 10.0F), (int)(this.jdField_a_of_type_Float * 10.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131707956));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840395);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840396);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.setMargins(0, 0, aepi.a(15.0F, getResources()), 0);
      paramContext.addRule(15);
      paramContext.addRule(11, -1);
      addView(this.jdField_a_of_type_AndroidWidgetImageView, paramContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new berf(this));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramContext = this.jdField_a_of_type_Berg.getClass().getSuperclass().getDeclaredField("mPopup");
          paramContext.setAccessible(true);
          paramContext = paramContext.get(this.jdField_a_of_type_Berg);
          paramContext.getClass().getMethod("setOnDismissListener", new Class[] { PopupWindow.OnDismissListener.class }).invoke(paramContext, new Object[] { this });
          return;
        }
        catch (Exception paramContext) {}
        localException = localException;
        QLog.w("NewStyleDropdownView", 2, "disable auto fill error", localException);
      }
    }
  }
  
  public AutoCompleteTextView a()
  {
    return this.jdField_a_of_type_Berg;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Berg != null) {
      this.jdField_a_of_type_Berg.showDropDown();
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
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130840392);
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
    if (this.jdField_a_of_type_Berh != null) {
      this.jdField_a_of_type_Berh.c();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new NewStyleDropdownView.3(this), 500L);
  }
  
  public void setHeadBorder(int paramInt)
  {
    this.c.setImageResource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView
 * JD-Core Version:    0.7.0.1
 */