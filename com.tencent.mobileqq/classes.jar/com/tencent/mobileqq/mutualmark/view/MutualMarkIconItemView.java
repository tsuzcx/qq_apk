package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import asxh;
import asyb;

public class MutualMarkIconItemView
  extends ImageView
{
  asxh jdField_a_of_type_Asxh;
  asyb jdField_a_of_type_Asyb;
  
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
    if (this.jdField_a_of_type_Asxh != null) {
      return this.jdField_a_of_type_Asxh.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Asyb != null) {
      return this.jdField_a_of_type_Asyb.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asxh != null) {
      this.jdField_a_of_type_Asxh.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Asxh != null) {
      this.jdField_a_of_type_Asxh.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(asyb paramasyb)
  {
    if (this.jdField_a_of_type_Asyb == paramasyb) {}
    do
    {
      return;
      this.jdField_a_of_type_Asyb = paramasyb;
      if (!TextUtils.isEmpty(paramasyb.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Asxh = new asxh(getContext(), paramasyb.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_Asxh);
        return;
      }
    } while (paramasyb.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_Asxh = new asxh(getContext(), paramasyb.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_Asxh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */