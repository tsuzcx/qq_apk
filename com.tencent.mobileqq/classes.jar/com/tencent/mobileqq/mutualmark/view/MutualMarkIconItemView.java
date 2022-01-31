package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import asbd;
import asbx;

public class MutualMarkIconItemView
  extends ImageView
{
  asbd jdField_a_of_type_Asbd;
  asbx jdField_a_of_type_Asbx;
  
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
    if (this.jdField_a_of_type_Asbd != null) {
      return this.jdField_a_of_type_Asbd.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Asbx != null) {
      return this.jdField_a_of_type_Asbx.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asbd != null) {
      this.jdField_a_of_type_Asbd.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Asbd != null) {
      this.jdField_a_of_type_Asbd.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(asbx paramasbx)
  {
    if (this.jdField_a_of_type_Asbx == paramasbx) {}
    do
    {
      return;
      this.jdField_a_of_type_Asbx = paramasbx;
      if (!TextUtils.isEmpty(paramasbx.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Asbd = new asbd(getContext(), paramasbx.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_Asbd);
        return;
      }
    } while (paramasbx.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_Asbd = new asbd(getContext(), paramasbx.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_Asbd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */