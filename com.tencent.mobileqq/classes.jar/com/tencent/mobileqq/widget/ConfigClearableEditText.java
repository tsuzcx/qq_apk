package com.tencent.mobileqq.widget;

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
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class ConfigClearableEditText
  extends EditText
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ConfigClearableEditText.ConfigClearableEditTextHelper jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$ConfigClearableEditTextHelper;
  private ConfigClearableEditText.CustomClearButtonCallback jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$CustomClearButtonCallback = null;
  ConfigClearableEditText.OnTextClearedListener jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$OnTextClearedListener;
  private ConfigClearableEditText.OnTextContextSelectListener jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$OnTextContextSelectListener = null;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  
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
    this.jdField_a_of_type_Boolean = false;
    try
    {
      a(paramContext, paramAttributeSet);
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$ConfigClearableEditTextHelper = new ConfigClearableEditText.ConfigClearableEditTextHelper(this, this);
    ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$ConfigClearableEditTextHelper);
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private int a()
  {
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$CustomClearButtonCallback != null) {
      k = getWidth();
    }
    for (int m = this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$CustomClearButtonCallback.a();; m = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth())
    {
      return k - m;
      k = getWidth() - getPaddingRight();
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bW);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(R.styleable.cr);
      this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.ct, -1);
      this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.cs, -1);
      this.d = paramContext.getBoolean(R.styleable.cw, false);
      this.e = paramContext.getBoolean(R.styleable.cx, false);
      this.f = paramContext.getBoolean(R.styleable.cy, false);
      this.g = paramContext.getBoolean(R.styleable.cu, false);
      this.h = paramContext.getBoolean(R.styleable.cz, false);
      this.i = paramContext.getBoolean(R.styleable.cA, false);
      this.j = paramContext.getBoolean(R.styleable.cv, false);
      paramContext.recycle();
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839537);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if ((this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1))
        {
          float f1 = this.jdField_a_of_type_Float;
          this.jdField_a_of_type_Int = ((int)(f1 * 19.0F));
          this.jdField_b_of_type_Int = ((int)(f1 * 19.0F));
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        setClearButtonVisible(false);
      }
      setOnTouchListener(new ConfigClearableEditText.1(this));
      addTextChangedListener(new ConfigClearableEditText.2(this));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private boolean b()
  {
    try
    {
      Object localObject = TextView.class.getDeclaredField("mSingleLine");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if ((localObject instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return false;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return false;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    return false;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$CustomClearButtonCallback;
    if (localObject != null) {
      ((ConfigClearableEditText.CustomClearButtonCallback)localObject).b(true);
    }
    if ((getCompoundDrawables()[2] == null) && ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$CustomClearButtonCallback == null))) {
      return;
    }
    setText("");
    setClearButtonVisible(false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$OnTextClearedListener;
    if (localObject != null) {
      ((ConfigClearableEditText.OnTextClearedListener)localObject).afterTextCleared();
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramMotionEvent.getX() > a())) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$ConfigClearableEditTextHelper.dispatchHoverEvent(paramMotionEvent);
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public void onDetachedFromWindow()
  {
    if ((QLog.isColorLevel()) && (AppSetting.e))
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
      return;
    }
    setCursorVisible(true);
    if (getText().toString().length() != 0) {
      setClearButtonVisible(true);
    }
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    boolean bool = a();
    ConfigClearableEditText.OnTextContextSelectListener localOnTextContextSelectListener = this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$OnTextContextSelectListener;
    if (localOnTextContextSelectListener != null) {
      localOnTextContextSelectListener.a(paramInt);
    }
    if (bool) {
      return super.onTextContextMenuItem(paramInt);
    }
    return this.j ^ true;
  }
  
  public void setCanMultiLine(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setClearButtonStyle(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    paramInt = this.jdField_c_of_type_Int;
    if (paramInt == 1)
    {
      setClearButtonVisible(false);
      return;
    }
    if (paramInt == 2) {
      setClearButtonVisible(true);
    }
  }
  
  public void setClearButtonVisible(boolean paramBoolean)
  {
    if (((paramBoolean) && (this.jdField_c_of_type_Int == 1)) || ((!paramBoolean) && (this.jdField_c_of_type_Int == 2))) {
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    } else {
      localDrawable = null;
    }
    ConfigClearableEditText.CustomClearButtonCallback localCustomClearButtonCallback = this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$CustomClearButtonCallback;
    if (localCustomClearButtonCallback != null)
    {
      localCustomClearButtonCallback.a(paramBoolean);
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }
    else
    {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
    }
    if (this.jdField_b_of_type_Boolean != paramBoolean) {
      AccessibilityUtil.a(this);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && (AppSetting.e) && (this.jdField_a_of_type_Boolean))
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
  
  public void setCustomClearButtonCallback(ConfigClearableEditText.CustomClearButtonCallback paramCustomClearButtonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$CustomClearButtonCallback = paramCustomClearButtonCallback;
  }
  
  public void setOnTextContextSelectListener(ConfigClearableEditText.OnTextContextSelectListener paramOnTextContextSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$OnTextContextSelectListener = paramOnTextContextSelectListener;
  }
  
  public void setTextClearedListener(ConfigClearableEditText.OnTextClearedListener paramOnTextClearedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText$OnTextClearedListener = paramOnTextClearedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ConfigClearableEditText
 * JD-Core Version:    0.7.0.1
 */