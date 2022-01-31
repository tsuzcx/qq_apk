package com.tencent.mobileqq.limitchat;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

public class TopicTextView
  extends TextView
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  
  public TopicTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TopicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TopicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (getMeasuredWidth() <= 0) {
      return null;
    }
    TextPaint localTextPaint = getPaint();
    float f2 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    if (f2 <= 0.0F) {
      return null;
    }
    String[] arrayOfString = paramString.replaceAll("\r", "").split("\n");
    StringBuilder localStringBuilder = new StringBuilder();
    int k = arrayOfString.length;
    int j = 0;
    if (j < k)
    {
      String str = arrayOfString[j];
      if (localTextPaint.measureText(str) <= f2)
      {
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      for (;;)
      {
        j += 1;
        break;
        float f1 = 0.0F;
        int i = 0;
        if (i != str.length())
        {
          char c = str.charAt(i);
          float f3 = localTextPaint.measureText(String.valueOf(c));
          if (f3 > f2) {
            return null;
          }
          f1 += f3;
          if (f1 <= f2) {
            localStringBuilder.append(c);
          }
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder.append("\n");
            f1 = 0.0F;
            i -= 1;
          }
        }
        localStringBuilder.append("\n");
      }
    }
    if (!paramString.endsWith("\n")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Boolean)
    {
      String str = a(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str)) {
        super.setText(str);
      }
    }
  }
  
  public void setTopicText(String paramString)
  {
    super.setText(paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.TopicTextView
 * JD-Core Version:    0.7.0.1
 */