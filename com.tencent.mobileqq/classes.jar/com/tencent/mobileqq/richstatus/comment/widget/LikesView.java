package com.tencent.mobileqq.richstatus.comment.widget;

import aepi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import ayej;
import ayek;
import ayel;
import ayeu;
import ayev;
import ayew;
import bamp;
import com.tencent.mobileqq.R.styleable;
import java.util.List;

public class LikesView
  extends TextView
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ayew jdField_a_of_type_Ayew;
  private String jdField_a_of_type_JavaLangString = "LikesView";
  private List<ayej> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  
  public LikesView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public LikesView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
    a(paramAttributeSet);
  }
  
  public LikesView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
    a(paramAttributeSet);
  }
  
  private SpannableString a()
  {
    SpannableString localSpannableString = new SpannableString("  ");
    int i = aepi.a(20.0F, getResources());
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i, i);
    localSpannableString.setSpan(new ImageSpan(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 0), 0, 1, 33);
    return localSpannableString;
  }
  
  private SpannableString a(String paramString1, String paramString2)
  {
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new ayev(this, this.jdField_a_of_type_Int, paramString2), 0, paramString1.length(), 33);
    return paramString1;
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.LikesView, 0, 0);
    try
    {
      this.jdField_a_of_type_Int = paramAttributeSet.getColor(0, getResources().getColor(2131166372));
      this.b = paramAttributeSet.getColor(1, getResources().getColor(2131166834));
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void b()
  {
    this.c = getResources().getColor(2131166369);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846977);
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      setVisibility(0);
      localSpannableStringBuilder.append(a());
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ayej localayej = (ayej)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localayej != null)
        {
          localSpannableStringBuilder.append(a(localayej.a.b, localayej.a.jdField_a_of_type_JavaLangString));
          if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {
            localSpannableStringBuilder.append(", ");
          }
        }
        i += 1;
      }
      if (this.jdField_a_of_type_Long > 1L) {
        localSpannableStringBuilder.append(String.format(getContext().getResources().getString(2131720208), new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
      }
      for (;;)
      {
        setText(new bamp(localSpannableStringBuilder, 3, 12));
        setTextColor(this.c);
        setMovementMethod(new ayel(this.b, getContext().getResources().getColor(2131167140)));
        setOnClickListener(new ayeu(this));
        return;
        localSpannableStringBuilder.append(getContext().getResources().getString(2131720207));
      }
    }
    setVisibility(8);
  }
  
  public void a(List<ayej> paramList, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
  }
  
  public void setItemColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setLikSpanDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setNormalTextColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOnItemClickListener(ayew paramayew)
  {
    this.jdField_a_of_type_Ayew = paramayew;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.LikesView
 * JD-Core Version:    0.7.0.1
 */