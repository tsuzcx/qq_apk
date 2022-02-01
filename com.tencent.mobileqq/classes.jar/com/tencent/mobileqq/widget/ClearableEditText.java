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
  Drawable a;
  ClearableEditText.OnTextClearedListener b;
  ClearableEditText.ClearableEditTextHelper c;
  public boolean d = false;
  private int e;
  private int f;
  private float g;
  private boolean h = false;
  private boolean i = false;
  private int j = 0;
  
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
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    this.c = new ClearableEditText.ClearableEditTextHelper(this, this);
    ViewCompat.setAccessibilityDelegate(this, this.c);
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.g = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fB);
    try
    {
      this.a = paramContext.getDrawable(R.styleable.fC);
      this.e = paramContext.getDimensionPixelSize(R.styleable.fE, -1);
      this.f = paramContext.getDimensionPixelSize(R.styleable.fD, -1);
      paramContext.recycle();
      if (this.a == null) {
        this.a = getResources().getDrawable(2130839736);
      }
      if (this.a != null)
      {
        if ((this.e == -1) || (this.f == -1))
        {
          float f1 = this.g;
          this.e = ((int)(f1 * 19.0F));
          this.f = ((int)(f1 * 19.0F));
        }
        this.a.setBounds(0, 0, this.e, this.f);
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
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.h) && (paramMotionEvent.getX() > getWidth() - getPaddingRight() - this.a.getIntrinsicWidth())) {
      return this.c.dispatchHoverEvent(paramMotionEvent);
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  protected Drawable getClearBtnDrawable()
  {
    return this.a;
  }
  
  public void onDetachedFromWindow()
  {
    if ((QLog.isColorLevel()) && (QQUIDelegate.c))
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
    this.d = true;
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
    this.i = paramBoolean;
  }
  
  public void setClearButtonStyle(int paramInt)
  {
    this.j = paramInt;
    paramInt = this.j;
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
    if (((paramBoolean) && (this.j == 1)) || ((!paramBoolean) && (this.j == 2))) {
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.a;
    } else {
      localDrawable = null;
    }
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
    if (this.h != paramBoolean) {
      AccessibilityUtil.a(this);
    }
    this.h = paramBoolean;
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && (QQUIDelegate.c) && (this.d))
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
    this.b = paramOnTextClearedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClearableEditText
 * JD-Core Version:    0.7.0.1
 */