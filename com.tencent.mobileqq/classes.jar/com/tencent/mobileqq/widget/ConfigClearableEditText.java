package com.tencent.mobileqq.widget;

import alas;
import alat;
import alau;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class ConfigClearableEditText
  extends EditText
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  alau jdField_a_of_type_Alau;
  public Drawable a;
  public ConfigClearableEditText.OnTextClearedListener a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  
  public ConfigClearableEditText(Context paramContext)
  {
    this(paramContext, null, 16842862);
  }
  
  public ConfigClearableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }
  
  public ConfigClearableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      a(paramContext, paramAttributeSet);
      this.jdField_a_of_type_Alau = new alau(this, this);
      ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_Alau);
      ViewCompat.setImportantForAccessibility(this, 1);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.clearableEditText);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(0);
      this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(1, -1);
      this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(2, -1);
      this.d = paramContext.getBoolean(3, false);
      this.e = paramContext.getBoolean(4, false);
      this.f = paramContext.getBoolean(5, false);
      this.g = paramContext.getBoolean(6, false);
      this.h = paramContext.getBoolean(7, false);
      this.i = paramContext.getBoolean(8, false);
      this.j = paramContext.getBoolean(9, false);
      paramContext.recycle();
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838712);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if ((this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1))
        {
          this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * 19.0F));
          this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 19.0F));
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        setClearButtonVisible(false);
      }
      setOnTouchListener(new alas(this));
      addTextChangedListener(new alat(this));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private boolean a()
  {
    for (;;)
    {
      try
      {
        Object localObject = TextView.class.getDeclaredField("mSingleLine");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(this);
        if ((localObject instanceof Boolean))
        {
          bool = ((Boolean)localObject).booleanValue();
          return bool;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return false;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return false;
      }
      boolean bool = false;
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (paramDrawable != this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) && (this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramMotionEvent.getX() > getWidth() - getPaddingRight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth())) {
      return this.jdField_a_of_type_Alau.dispatchHoverEvent(paramMotionEvent);
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public void onDetachedFromWindow()
  {
    if ((QLog.isColorLevel()) && (AppSetting.jdField_c_of_type_Boolean))
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("onDetachedFromWindow ");
      localStringBuilder.append(getContext().getClass().getSimpleName());
      localStringBuilder.append("@0x");
      localStringBuilder.append(Integer.toHexString(getContext().hashCode()));
      localStringBuilder.append(" ConfigClearableEditText@0x");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      QLog.d("ConfigClearableEditText", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    super.onDetachedFromWindow();
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
    {
      setCursorVisible(false);
      setClearButtonVisible(false);
    }
    do
    {
      return;
      setCursorVisible(true);
    } while (getText().toString().length() == 0);
    setClearButtonVisible(true);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    return !this.j;
  }
  
  public void setCanMultiLine(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setClearButtonStyle(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_c_of_type_Int == 1) {
      setClearButtonVisible(false);
    }
    while (this.jdField_c_of_type_Int != 2) {
      return;
    }
    setClearButtonVisible(true);
  }
  
  public void setClearButtonVisible(boolean paramBoolean)
  {
    if (((paramBoolean) && (this.jdField_c_of_type_Int == 1)) || ((!paramBoolean) && (this.jdField_c_of_type_Int == 2))) {
      return;
    }
    if (paramBoolean) {}
    for (Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;; localDrawable = null)
    {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
      if (this.jdField_b_of_type_Boolean != paramBoolean) {
        AccessibilityUtil.a(this);
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && (AppSetting.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("setCursorVisible=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(getContext().getClass().getSimpleName());
      localStringBuilder.append("@0x");
      localStringBuilder.append(Integer.toHexString(getContext().hashCode()));
      localStringBuilder.append(" ConfigClearableEditText@0x");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      QLog.d("ConfigClearableEditText", 2, localStringBuilder.toString(), new Exception());
    }
    super.setCursorVisible(paramBoolean);
  }
  
  public void setTextClearedListener(ConfigClearableEditText.OnTextClearedListener paramOnTextClearedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$OnTextClearedListener = paramOnTextClearedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ConfigClearableEditText
 * JD-Core Version:    0.7.0.1
 */