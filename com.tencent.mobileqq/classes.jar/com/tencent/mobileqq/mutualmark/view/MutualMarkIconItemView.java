package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import auog;
import aupa;

public class MutualMarkIconItemView
  extends ImageView
{
  auog jdField_a_of_type_Auog;
  aupa jdField_a_of_type_Aupa;
  
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
    if (this.jdField_a_of_type_Auog != null) {
      return this.jdField_a_of_type_Auog.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Aupa != null) {
      return this.jdField_a_of_type_Aupa.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Auog != null) {
      this.jdField_a_of_type_Auog.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Auog != null) {
      this.jdField_a_of_type_Auog.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(aupa paramaupa)
  {
    if (this.jdField_a_of_type_Aupa == paramaupa) {}
    do
    {
      return;
      this.jdField_a_of_type_Aupa = paramaupa;
      if (!TextUtils.isEmpty(paramaupa.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Auog = new auog(getContext(), paramaupa.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_Auog);
        return;
      }
    } while (paramaupa.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_Auog = new auog(getContext(), paramaupa.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_Auog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */