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
  Drawable a;
  ConfigClearableEditText.OnTextClearedListener b;
  ConfigClearableEditText.ConfigClearableEditTextHelper c;
  public boolean d = false;
  private int e;
  private int f;
  private float g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q;
  private ConfigClearableEditText.CustomClearButtonCallback r = null;
  private ConfigClearableEditText.OnTextContextSelectListener s = null;
  private int t = 0;
  
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
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    this.c = new ConfigClearableEditText.ConfigClearableEditTextHelper(this, this);
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
      this.j = paramContext.getBoolean(R.styleable.fH, false);
      this.k = paramContext.getBoolean(R.styleable.fI, false);
      this.l = paramContext.getBoolean(R.styleable.fJ, false);
      this.m = paramContext.getBoolean(R.styleable.fF, false);
      this.n = paramContext.getBoolean(R.styleable.fK, false);
      this.o = paramContext.getBoolean(R.styleable.fL, false);
      this.p = paramContext.getBoolean(R.styleable.fG, false);
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
      setOnTouchListener(new ConfigClearableEditText.1(this));
      addTextChangedListener(new ConfigClearableEditText.2(this));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private boolean c()
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
  
  private int getClearButtonLeft()
  {
    int i1;
    if (this.r != null) {
      i1 = getWidth();
    }
    for (int i2 = this.r.a();; i2 = this.a.getIntrinsicWidth())
    {
      return i1 - i2;
      i1 = getWidth() - getPaddingRight();
    }
  }
  
  public void a()
  {
    Object localObject = this.r;
    if (localObject != null) {
      ((ConfigClearableEditText.CustomClearButtonCallback)localObject).b(true);
    }
    if ((getCompoundDrawables()[2] == null) && ((!this.h) || (this.r == null))) {
      return;
    }
    setText("");
    setClearButtonVisible(false);
    localObject = this.b;
    if (localObject != null) {
      ((ConfigClearableEditText.OnTextClearedListener)localObject).f();
    }
  }
  
  protected boolean b()
  {
    return this.q;
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.h) && (paramMotionEvent.getX() > getClearButtonLeft())) {
      return this.c.dispatchHoverEvent(paramMotionEvent);
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  protected Drawable getClearBtnDrawable()
  {
    return this.a;
  }
  
  protected String getSimpleClassName()
  {
    return "";
  }
  
  public void onDetachedFromWindow()
  {
    if ((QLog.isColorLevel()) && (AppSetting.f))
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
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    boolean bool = b();
    ConfigClearableEditText.OnTextContextSelectListener localOnTextContextSelectListener = this.s;
    if (localOnTextContextSelectListener != null) {
      localOnTextContextSelectListener.a(paramInt);
    }
    if (bool) {
      return super.onTextContextMenuItem(paramInt);
    }
    return this.p ^ true;
  }
  
  public void setCanMultiLine(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setClearButtonStyle(int paramInt)
  {
    this.t = paramInt;
    paramInt = this.t;
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
    if (((paramBoolean) && (this.t == 1)) || ((!paramBoolean) && (this.t == 2))) {
      return;
    }
    Drawable localDrawable;
    if (paramBoolean) {
      localDrawable = this.a;
    } else {
      localDrawable = null;
    }
    ConfigClearableEditText.CustomClearButtonCallback localCustomClearButtonCallback = this.r;
    if (localCustomClearButtonCallback != null)
    {
      localCustomClearButtonCallback.a(paramBoolean);
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }
    else
    {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
    }
    if (this.h != paramBoolean) {
      AccessibilityUtil.a(this);
    }
    this.h = paramBoolean;
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && (AppSetting.f) && (this.d))
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
    this.r = paramCustomClearButtonCallback;
  }
  
  public void setNeedContextMenu(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setOnTextContextSelectListener(ConfigClearableEditText.OnTextContextSelectListener paramOnTextContextSelectListener)
  {
    this.s = paramOnTextContextSelectListener;
  }
  
  public void setTextClearedListener(ConfigClearableEditText.OnTextClearedListener paramOnTextClearedListener)
  {
    this.b = paramOnTextClearedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ConfigClearableEditText
 * JD-Core Version:    0.7.0.1
 */