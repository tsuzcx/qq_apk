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
import bhga;
import bivq;
import bivr;
import bivs;
import bivt;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class ClearableEditText
  extends EditText
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  public Drawable a;
  bivs jdField_a_of_type_Bivs;
  public bivt a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  
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
    try
    {
      a(paramContext, paramAttributeSet);
      this.jdField_a_of_type_Bivs = new bivs(this, this);
      ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_Bivs);
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
      this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(2, -1);
      this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(1, -1);
      paramContext.recycle();
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839544);
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
      setOnTouchListener(new bivq(this));
      addTextChangedListener(new bivr(this));
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
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramMotionEvent.getX() > getWidth() - getPaddingRight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth())) {
      return this.jdField_a_of_type_Bivs.dispatchHoverEvent(paramMotionEvent);
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public void onDetachedFromWindow()
  {
    if ((QLog.isColorLevel()) && (AppSetting.d))
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
    }
    do
    {
      return;
      setCursorVisible(true);
    } while (getText().toString().length() == 0);
    setClearButtonVisible(true);
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
        bhga.a(this);
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && (AppSetting.d) && (this.jdField_a_of_type_Boolean))
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
  
  public void setTextClearedListener(bivt parambivt)
  {
    this.jdField_a_of_type_Bivt = parambivt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClearableEditText
 * JD-Core Version:    0.7.0.1
 */