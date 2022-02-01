package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.widget.ColorNickTextView;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiImageTextView
  extends ColorNickTextView
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList<SpanAdapter> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean b = false;
  
  public MultiImageTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MultiImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MultiImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public MultiImageTextView a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    MultiImageTextView.IconIDString localIconIDString = new MultiImageTextView.IconIDString(null);
    localIconIDString.a = paramDrawable;
    localIconIDString.a.setBounds(0, 0, paramInt1, paramInt2);
    a(localIconIDString);
    return this;
  }
  
  public void a(float paramFloat)
  {
    a((int)(paramFloat * getResources().getDisplayMetrics().density + 0.5F));
  }
  
  public void a(int paramInt)
  {
    MultiImageTextView.MarginStyle localMarginStyle = new MultiImageTextView.MarginStyle(null);
    localMarginStyle.a = paramInt;
    a(localMarginStyle);
  }
  
  public void a(SpanAdapter paramSpanAdapter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
    localStringBuilder.append("]");
    paramSpanAdapter.apendString = localStringBuilder.toString();
    paramSpanAdapter.start = this.jdField_a_of_type_JavaLangStringBuilder.length();
    paramSpanAdapter.end = (paramSpanAdapter.start + paramSpanAdapter.apendString.length());
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramSpanAdapter.apendString);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramSpanAdapter);
  }
  
  public void append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramCharSequence, paramInt1, paramInt2);
    this.b = true;
    super.append(paramCharSequence, paramInt1, paramInt2);
  }
  
  public void c()
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangStringBuilder);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((SpanAdapter)localIterator.next()).getSpan(localSpannableString);
    }
    setText(localSpannableString);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (!this.b)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList != null) {
        localArrayList.clear();
      }
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(paramCharSequence);
    }
    else
    {
      this.b = false;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView
 * JD-Core Version:    0.7.0.1
 */