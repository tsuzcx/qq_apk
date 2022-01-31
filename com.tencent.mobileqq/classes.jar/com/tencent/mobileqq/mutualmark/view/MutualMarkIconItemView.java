package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import ausp;
import autj;

public class MutualMarkIconItemView
  extends ImageView
{
  ausp jdField_a_of_type_Ausp;
  autj jdField_a_of_type_Autj;
  
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
    if (this.jdField_a_of_type_Ausp != null) {
      return this.jdField_a_of_type_Ausp.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Autj != null) {
      return this.jdField_a_of_type_Autj.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ausp != null) {
      this.jdField_a_of_type_Ausp.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Ausp != null) {
      this.jdField_a_of_type_Ausp.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(autj paramautj)
  {
    if (this.jdField_a_of_type_Autj == paramautj) {}
    do
    {
      return;
      this.jdField_a_of_type_Autj = paramautj;
      if (!TextUtils.isEmpty(paramautj.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Ausp = new ausp(getContext(), paramautj.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_Ausp);
        return;
      }
    } while (paramautj.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_Ausp = new ausp(getContext(), paramautj.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_Ausp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */