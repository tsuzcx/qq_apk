package com.tencent.mobileqq.kandian.biz.video.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;

public class ReadInJoyVideoTopicTextView
  extends TextView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  
  public ReadInJoyVideoTopicTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ReadInJoyVideoTopicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ReadInJoyVideoTopicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt)
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangString);
    Object localObject = new ForegroundColorSpan(Color.parseColor("#737373"));
    int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.5F);
    if (paramInt == 1)
    {
      localObject = getResources().getDrawable(2130843320);
      paramInt = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
      ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
      setCompoundDrawablePadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F));
      setCompoundDrawables((Drawable)localObject, null, null, null);
      paramInt = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.5F);
      setTextSize(2, 12.0F);
    }
    else
    {
      if (paramInt == 2)
      {
        localSpannableString.setSpan(localObject, 0, this.jdField_a_of_type_JavaLangString.length(), 34);
        setHeight(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 27.0F));
        setTextSize(2, 14.0F);
      }
      paramInt = i;
    }
    setTextColor(Color.parseColor("#737373"));
    setText(localSpannableString);
    setIncludeFontPadding(false);
    setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), paramInt, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), paramInt);
    setClickable(true);
    setFocusable(true);
    setBackgroundResource(2130843317);
    setSingleLine(true);
    setGravity(17);
  }
  
  public int a()
  {
    Rect localRect = new Rect();
    TextPaint localTextPaint = getPaint();
    String str = this.jdField_a_of_type_JavaLangString;
    localTextPaint.getTextBounds(str, 0, str.length(), localRect);
    return localRect.width() + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F) * 2;
  }
  
  public void setSubChannelText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(2);
  }
  
  public void setTopicText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyVideoTopicTextView
 * JD-Core Version:    0.7.0.1
 */