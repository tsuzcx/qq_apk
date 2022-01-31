package dov.com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import aoic;
import aoid;
import aoie;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class ExtendEditText
  extends EditText
{
  public static final ExtendEditText.LengthConvertor a;
  private static final ExtendEditText.LengthConvertor jdField_c_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = new aoic();
  protected int a;
  private ExtendEditText.LimitListener jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText$LimitListener;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = -1;
  private ExtendEditText.LengthConvertor jdField_b_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor;
  private int jdField_c_of_type_Int = 4;
  
  static
  {
    jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = new aoid();
  }
  
  public ExtendEditText(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.EditText);
    setClearFocusOnBack(paramContext.getBoolean(0, false));
    this.jdField_b_of_type_Int = paramContext.getInteger(1, -1);
    paramContext.recycle();
    d();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Int >= 0) {
      setFilters(new InputFilter[] { new aoie(this, this.jdField_b_of_type_Int) });
    }
  }
  
  private void e()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  @TargetApi(14)
  int a()
  {
    int j = 0;
    int i;
    try
    {
      if (getLayout() == null) {
        return 0;
      }
      i = Build.VERSION.SDK_INT;
      if (i > 13)
      {
        try
        {
          i = getOffsetForPosition(getX(), getY());
          i = getLayout().getLineForOffset(i);
          return i;
        }
        catch (Exception localException1)
        {
          i = j;
          if (!QLog.isColorLevel()) {
            return i;
          }
        }
        QLog.w("ExtendEditText", 2, "", localException1);
        return 0;
      }
    }
    catch (Exception localException2)
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.w("ExtendEditText", 2, "", localException2);
        return 0;
        if (i > 10) {
          return a(getY());
        }
        i = a(getTop());
      }
    }
    return i;
  }
  
  int a(float paramFloat)
  {
    if ((this == null) || (getLayout() == null)) {
      return 0;
    }
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f));
  }
  
  protected void a()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int j = a();
    int i = localLayout.getLineTop(j);
    j = localLayout.getLineBottom(j);
    int m = getScrollY();
    int k = getScrollX();
    if (Math.abs(m - i) <= Math.abs(j - m)) {}
    for (;;)
    {
      scrollTo(k, i);
      return;
      i = j;
    }
  }
  
  protected void b()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int i = localLayout.getLineBottom(a());
    scrollTo(getScrollX(), i);
  }
  
  public boolean bringPointIntoView(int paramInt)
  {
    return false;
  }
  
  protected void c()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {}
    do
    {
      return;
      i = a() - 1;
    } while (i < 0);
    int i = localLayout.getLineTop(i);
    scrollTo(getScrollX(), i);
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      e();
      clearFocus();
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    a();
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramInt1 = getLineCount();
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      if (this.jdField_a_of_type_Int < paramInt1)
      {
        if (paramInt1 > this.jdField_c_of_type_Int) {
          b();
        }
        return;
      }
      c();
      return;
    }
    a();
  }
  
  public void setBeforeChangeLineCount(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setClearFocusOnBack(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLimitListener(ExtendEditText.LimitListener paramLimitListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText$LimitListener = paramLimitListener;
  }
  
  public void setMaxLengthConvertor(ExtendEditText.LengthConvertor paramLengthConvertor)
  {
    this.jdField_b_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = paramLengthConvertor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.view.ExtendEditText
 * JD-Core Version:    0.7.0.1
 */