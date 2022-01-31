package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import asxj;
import asyd;

public class MutualMarkIconItemView
  extends ImageView
{
  asxj jdField_a_of_type_Asxj;
  asyd jdField_a_of_type_Asyd;
  
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
    if (this.jdField_a_of_type_Asxj != null) {
      return this.jdField_a_of_type_Asxj.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Asyd != null) {
      return this.jdField_a_of_type_Asyd.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asxj != null) {
      this.jdField_a_of_type_Asxj.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Asxj != null) {
      this.jdField_a_of_type_Asxj.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(asyd paramasyd)
  {
    if (this.jdField_a_of_type_Asyd == paramasyd) {}
    do
    {
      return;
      this.jdField_a_of_type_Asyd = paramasyd;
      if (!TextUtils.isEmpty(paramasyd.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Asxj = new asxj(getContext(), paramasyd.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_Asxj);
        return;
      }
    } while (paramasyd.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_Asxj = new asxj(getContext(), paramasyd.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_Asxj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */