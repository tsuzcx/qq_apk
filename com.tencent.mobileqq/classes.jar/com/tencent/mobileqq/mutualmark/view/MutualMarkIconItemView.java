package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import awfv;
import awgq;

public class MutualMarkIconItemView
  extends ImageView
{
  awfv jdField_a_of_type_Awfv;
  awgq jdField_a_of_type_Awgq;
  
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
    if (this.jdField_a_of_type_Awfv != null) {
      return this.jdField_a_of_type_Awfv.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Awgq != null) {
      return this.jdField_a_of_type_Awgq.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Awfv != null) {
      this.jdField_a_of_type_Awfv.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Awfv != null) {
      this.jdField_a_of_type_Awfv.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(awgq paramawgq)
  {
    if (this.jdField_a_of_type_Awgq == paramawgq) {}
    do
    {
      return;
      this.jdField_a_of_type_Awgq = paramawgq;
      if (!TextUtils.isEmpty(paramawgq.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Awfv = new awfv(getContext(), paramawgq.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_Awfv);
        return;
      }
    } while (paramawgq.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_Awfv = new awfv(getContext(), paramawgq.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_Awfv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */