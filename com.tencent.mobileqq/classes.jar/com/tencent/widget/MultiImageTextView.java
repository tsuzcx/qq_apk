package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView.BufferType;
import blnn;
import blnp;
import blpo;
import com.tencent.mobileqq.widget.ColorNickTextView;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiImageTextView
  extends ColorNickTextView
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList<blpo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
    blnn localblnn = new blnn(null);
    localblnn.a = paramDrawable;
    localblnn.a.setBounds(0, 0, paramInt1, paramInt2);
    a(localblnn);
    return this;
  }
  
  public void a(float paramFloat)
  {
    a((int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F));
  }
  
  public void a(int paramInt)
  {
    blnp localblnp = new blnp(null);
    localblnp.a = paramInt;
    a(localblnp);
  }
  
  public void a(blpo paramblpo)
  {
    paramblpo.a = ("[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    paramblpo.b = this.jdField_a_of_type_JavaLangStringBuilder.length();
    paramblpo.c = (paramblpo.b + paramblpo.a.length());
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramblpo.a);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramblpo);
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
      ((blpo)localIterator.next()).a(localSpannableString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.MultiImageTextView
 * JD-Core Version:    0.7.0.1
 */