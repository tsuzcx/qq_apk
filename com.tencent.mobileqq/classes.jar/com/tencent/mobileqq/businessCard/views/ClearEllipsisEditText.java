package com.tencent.mobileqq.businessCard.views;

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
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 2147483647;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 2;
  private boolean jdField_d_of_type_Boolean = false;
  
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
      str = paramString;
      if (this.jdField_d_of_type_Int == 1)
      {
        i = paramString.getBytes().length;
        str = paramString;
      }
      while (i > this.jdField_c_of_type_Int)
      {
        paramString = str.substring(0, str.length() - 1);
        i = paramString.length();
        str = paramString;
        if (this.jdField_d_of_type_Int == 1)
        {
          i = paramString.getBytes().length;
          str = paramString;
        }
      }
      return str;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
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
    addTextChangedListener(new ClearEllipsisEditText.1(this));
    setOnTouchListener(new ClearEllipsisEditText.2(this));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
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
    String str;
    if (paramString == null) {
      str = "";
    } else {
      str = paramString;
    }
    this.jdField_a_of_type_JavaLangString = a(paramString);
    int i = this.jdField_b_of_type_Int;
    if (i <= 0)
    {
      post(new ClearEllipsisEditText.3(this, str));
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    setText(a(str, i));
  }
  
  public void setMaxLength(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 1) && (paramInt2 != 2)) {
      this.jdField_d_of_type_Int = 2;
    } else {
      this.jdField_d_of_type_Int = paramInt2;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText
 * JD-Core Version:    0.7.0.1
 */