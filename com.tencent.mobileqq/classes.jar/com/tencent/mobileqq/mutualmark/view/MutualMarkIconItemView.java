package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import axso;
import axtj;

public class MutualMarkIconItemView
  extends ImageView
{
  axso jdField_a_of_type_Axso;
  axtj jdField_a_of_type_Axtj;
  
  public MutualMarkIconItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MutualMarkIconItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MutualMarkIconItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Axso != null) {
      return this.jdField_a_of_type_Axso.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Axtj != null) {
      return this.jdField_a_of_type_Axtj.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axso != null) {
      this.jdField_a_of_type_Axso.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Axso != null) {
      this.jdField_a_of_type_Axso.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(axtj paramaxtj)
  {
    if (this.jdField_a_of_type_Axtj == paramaxtj) {}
    do
    {
      return;
      this.jdField_a_of_type_Axtj = paramaxtj;
      if (!TextUtils.isEmpty(paramaxtj.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Axso = new axso(getContext(), paramaxtj.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_Axso);
        return;
      }
    } while (paramaxtj.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_Axso = new axso(getContext(), paramaxtj.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_Axso);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */