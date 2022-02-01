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
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class ClearableEditText
  extends EditText
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ClearableEditText.ClearableEditTextHelper jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$ClearableEditTextHelper;
  ClearableEditText.OnTextClearedListener jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  
  public ClearableEditText(Context paramContext)
  {
    this(paramContext, null, 16842862);
  }
  
  public ClearableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }
  
  public ClearableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$ClearableEditTextHelper = new ClearableEditText.ClearableEditTextHelper(this, this);
    ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$ClearableEditTextHelper);
    ViewCompat.setImportantForAccessibility(this, 1);
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
      paramContext.recycle();
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839537);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if ((this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1))
        {
          float f = this.jdField_a_of_type_Float;
          this.jdField_a_of_type_Int = ((int)(f * 19.0F));
          this.jdField_b_of_type_Int = ((int)(f * 19.0F));
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        setClearButtonVisible(false);
      }
      setOnTouchListener(new ClearableEditText.1(this));
      addTextChangedListener(new ClearableEditText.2(this));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private boolean a()
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
  
  protected Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramMotionEvent.getX() > getWidth() - getPaddingRight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth())) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$ClearableEditTextHelper.dispatchHoverEvent(paramMotionEvent);
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public void onDetachedFromWindow()
  {
    if ((QLog.isColorLevel()) && (QQUIDelegate.jdField_c_of_type_Boolean))
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("onDetachedFromWindow ");
      localStringBuilder.append(getContext().getClass().getSimpleName());
      localStringBuilder.append("@0x");
      localStringBuilder.append(Integer.toHexString(getContext().hashCode()));
      localStringBuilder.append(" ClearableEditText@0x");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      QLog.d("ClearableEditText", 2, localStringBuilder.toString());
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
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
    if (this.jdField_b_of_type_Boolean != paramBoolean) {
      AccessibilityUtil.a(this);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && (QQUIDelegate.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("setCursorVisible=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(getContext().getClass().getSimpleName());
      localStringBuilder.append("@0x");
      localStringBuilder.append(Integer.toHexString(getContext().hashCode()));
      localStringBuilder.append(" ClearableEditText@0x");
      localStringBuilder.append(Integer.toHexString(hashCode()));
      QLog.d("ClearableEditText", 2, localStringBuilder.toString(), new Exception());
    }
    super.setCursorVisible(paramBoolean);
  }
  
  public void setTextClearedListener(ClearableEditText.OnTextClearedListener paramOnTextClearedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener = paramOnTextClearedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClearableEditText
 * JD-Core Version:    0.7.0.1
 */