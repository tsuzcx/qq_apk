package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import awzv;
import axap;

public class MutualMarkIconItemView
  extends ImageView
{
  awzv jdField_a_of_type_Awzv;
  axap jdField_a_of_type_Axap;
  
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
    if (this.jdField_a_of_type_Awzv != null) {
      return this.jdField_a_of_type_Awzv.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Axap != null) {
      return this.jdField_a_of_type_Axap.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Awzv != null) {
      this.jdField_a_of_type_Awzv.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Awzv != null) {
      this.jdField_a_of_type_Awzv.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(axap paramaxap)
  {
    if (this.jdField_a_of_type_Axap == paramaxap) {}
    do
    {
      return;
      this.jdField_a_of_type_Axap = paramaxap;
      if (!TextUtils.isEmpty(paramaxap.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Awzv = new awzv(getContext(), paramaxap.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_Awzv);
        return;
      }
    } while (paramaxap.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_Awzv = new awzv(getContext(), paramaxap.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_Awzv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */