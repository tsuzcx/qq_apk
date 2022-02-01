package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import axlx;
import axms;

public class MutualMarkIconItemView
  extends ImageView
{
  axlx jdField_a_of_type_Axlx;
  axms jdField_a_of_type_Axms;
  
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
    if (this.jdField_a_of_type_Axlx != null) {
      return this.jdField_a_of_type_Axlx.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Axms != null) {
      return this.jdField_a_of_type_Axms.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axlx != null) {
      this.jdField_a_of_type_Axlx.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Axlx != null) {
      this.jdField_a_of_type_Axlx.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(axms paramaxms)
  {
    if (this.jdField_a_of_type_Axms == paramaxms) {}
    do
    {
      return;
      this.jdField_a_of_type_Axms = paramaxms;
      if (!TextUtils.isEmpty(paramaxms.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Axlx = new axlx(getContext(), paramaxms.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_Axlx);
        return;
      }
    } while (paramaxms.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_Axlx = new axlx(getContext(), paramaxms.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_Axlx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */