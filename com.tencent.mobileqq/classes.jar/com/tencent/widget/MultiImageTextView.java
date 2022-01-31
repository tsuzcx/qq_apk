package com.tencent.widget;

import amkc;
import amke;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiImageTextView
  extends TextView
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  
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
  
  public MultiImageTextView a(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    a(localDrawable, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return this;
  }
  
  public MultiImageTextView a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    amkc localamkc = new amkc(this);
    localamkc.a = paramDrawable;
    localamkc.a.setBounds(0, 0, paramInt1, paramInt2);
    a(localamkc);
    return this;
  }
  
  public void a()
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangStringBuilder);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((SpanAdapter)localIterator.next()).a(localSpannableString);
    }
    setText(localSpannableString);
  }
  
  public void a(float paramFloat)
  {
    a((int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F));
  }
  
  public void a(int paramInt)
  {
    amke localamke = new amke(this);
    localamke.a = paramInt;
    a(localamke);
  }
  
  public void a(SpanAdapter paramSpanAdapter)
  {
    paramSpanAdapter.a = ("[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    paramSpanAdapter.b = this.jdField_a_of_type_JavaLangStringBuilder.length();
    paramSpanAdapter.c = (paramSpanAdapter.b + paramSpanAdapter.a.length());
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramSpanAdapter.a);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramSpanAdapter);
  }
  
  public void append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramCharSequence, paramInt1, paramInt2);
    this.jdField_a_of_type_Boolean = true;
    super.append(paramCharSequence, paramInt1, paramInt2);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(paramCharSequence);
    }
    for (;;)
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView
 * JD-Core Version:    0.7.0.1
 */