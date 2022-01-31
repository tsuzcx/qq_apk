package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView.BufferType;
import bhus;
import bhuu;
import bhwt;
import com.tencent.mobileqq.widget.ColorNickTextView;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiImageTextView
  extends ColorNickTextView
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList<bhwt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean b;
  
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
    bhus localbhus = new bhus(null);
    localbhus.a = paramDrawable;
    localbhus.a.setBounds(0, 0, paramInt1, paramInt2);
    a(localbhus);
    return this;
  }
  
  public void a(float paramFloat)
  {
    a((int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F));
  }
  
  public void a(int paramInt)
  {
    bhuu localbhuu = new bhuu(null);
    localbhuu.a = paramInt;
    a(localbhuu);
  }
  
  public void a(bhwt parambhwt)
  {
    parambhwt.a = ("[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    parambhwt.b = this.jdField_a_of_type_JavaLangStringBuilder.length();
    parambhwt.c = (parambhwt.b + parambhwt.a.length());
    this.jdField_a_of_type_JavaLangStringBuilder.append(parambhwt.a);
    this.jdField_a_of_type_JavaUtilArrayList.add(parambhwt);
  }
  
  public void append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramCharSequence, paramInt1, paramInt2);
    this.b = true;
    super.append(paramCharSequence, paramInt1, paramInt2);
  }
  
  public void b()
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangStringBuilder);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bhwt)localIterator.next()).a(localSpannableString);
    }
    setText(localSpannableString);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (!this.b)
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
      this.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView
 * JD-Core Version:    0.7.0.1
 */