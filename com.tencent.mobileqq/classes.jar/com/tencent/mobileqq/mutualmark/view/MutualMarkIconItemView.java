package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.mutualmark.MutualMarkIconProxyDrawable;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;

public class MutualMarkIconItemView
  extends ImageView
{
  MutualMarkIconProxyDrawable jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable;
  MutualMarkForDisplayInfo jdField_a_of_type_ComTencentMobileqqMutualmarkInfoMutualMarkForDisplayInfo;
  
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
    if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable != null) {
      return this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkInfoMutualMarkForDisplayInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqMutualmarkInfoMutualMarkForDisplayInfo.a;
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable.a(paramString);
    }
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkInfoMutualMarkForDisplayInfo == paramMutualMarkForDisplayInfo) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqMutualmarkInfoMutualMarkForDisplayInfo = paramMutualMarkForDisplayInfo;
      if (!TextUtils.isEmpty(paramMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable = new MutualMarkIconProxyDrawable(getContext(), paramMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString);
        setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable);
        return;
      }
    } while (paramMutualMarkForDisplayInfo.jdField_c_of_type_Int == 0);
    this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable = new MutualMarkIconProxyDrawable(getContext(), paramMutualMarkForDisplayInfo.jdField_c_of_type_Int);
    setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqMutualmarkMutualMarkIconProxyDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */