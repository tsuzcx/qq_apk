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
  private int e;
  private int f;
  private String g = "";
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private int k = 2147483647;
  private int l = 2;
  
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
    if ((paramString != null) && (this.j))
    {
      int m = paramString.length();
      str = paramString;
      if (this.l == 1)
      {
        m = paramString.getBytes().length;
        str = paramString;
      }
      while (m > this.k)
      {
        paramString = str.substring(0, str.length() - 1);
        m = paramString.length();
        str = paramString;
        if (this.l == 1)
        {
          m = paramString.getBytes().length;
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
  
  public String getTotalText()
  {
    return this.g;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean) {}
    try
    {
      this.h = false;
      this.g = getText().toString();
      setEllipsisText(getText().toString());
      return;
    }
    catch (Throwable paramRect)
    {
      QLog.e("ClearEllipsisEditText", 1, "onFocusChanged fail!", paramRect);
    }
    this.h = true;
    setText(this.g);
    return;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.e = getMeasuredHeight();
    this.f = getMeasuredWidth();
  }
  
  public void setEllipsisText(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    } else {
      str = paramString;
    }
    this.g = a(paramString);
    int m = this.f;
    if (m <= 0)
    {
      post(new ClearEllipsisEditText.3(this, str));
      return;
    }
    this.i = true;
    setText(a(str, m));
  }
  
  public void setMaxLength(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 1) && (paramInt2 != 2)) {
      this.l = 2;
    } else {
      this.l = paramInt2;
    }
    this.j = true;
    this.k = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText
 * JD-Core Version:    0.7.0.1
 */