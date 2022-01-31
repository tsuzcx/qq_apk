package com.tencent.mobileqq.businessCard.views;

import amex;
import amey;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;

public class ClearEllipsisEditText
  extends ClearableEditText
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2147483647;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 2;
  private boolean jdField_d_of_type_Boolean;
  
  public ClearEllipsisEditText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ClearEllipsisEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ClearEllipsisEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private String a(String paramString)
  {
    if ((paramString != null) && (this.jdField_d_of_type_Boolean))
    {
      int i = paramString.length();
      String str1 = paramString;
      if (this.jdField_d_of_type_Int == 1)
      {
        i = paramString.getBytes().length;
        str1 = paramString;
      }
      for (;;)
      {
        str2 = str1;
        if (i <= this.jdField_c_of_type_Int) {
          break;
        }
        paramString = str1.substring(0, str1.length() - 1);
        i = paramString.length();
        str1 = paramString;
        if (this.jdField_d_of_type_Int == 1)
        {
          i = paramString.getBytes().length;
          str1 = paramString;
        }
      }
    }
    String str2 = paramString;
    if (paramString == null) {
      str2 = "";
    }
    return str2;
  }
  
  private String a(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      TextPaint localTextPaint = getPaint();
      return (String)TextUtils.ellipsize(paramString, localTextPaint, paramInt - 20 - (int)localTextPaint.measureText("B"), TextUtils.TruncateAt.END);
    }
    return "";
  }
  
  private void a()
  {
    addTextChangedListener(new amex(this));
    setOnTouchListener(new amey(this));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean) {}
    try
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = getText().toString();
      setEllipsisText(getText().toString());
      return;
    }
    catch (Throwable paramRect)
    {
      QLog.e("ClearEllipsisEditText", 1, "onFocusChanged fail!", paramRect);
    }
    this.jdField_b_of_type_Boolean = true;
    setText(this.jdField_a_of_type_JavaLangString);
    return;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = getMeasuredHeight();
    this.jdField_b_of_type_Int = getMeasuredWidth();
  }
  
  public void setEllipsisText(String paramString)
  {
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      this.jdField_a_of_type_JavaLangString = a(paramString);
      if (this.jdField_b_of_type_Int <= 0)
      {
        post(new ClearEllipsisEditText.3(this, str));
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      setText(a(str, this.jdField_b_of_type_Int));
      return;
    }
  }
  
  public void setMaxLength(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 1) || (paramInt2 == 2)) {}
    for (this.jdField_d_of_type_Int = paramInt2;; this.jdField_d_of_type_Int = 2)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_c_of_type_Int = paramInt1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText
 * JD-Core Version:    0.7.0.1
 */