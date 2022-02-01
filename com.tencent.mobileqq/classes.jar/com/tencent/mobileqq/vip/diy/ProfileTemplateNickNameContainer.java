package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase.BackGroundUpdateListener;
import com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase.NinePatchDecoderHandler;
import com.tencent.mobileqq.widget.ProfileNameView;

public class ProfileTemplateNickNameContainer
  extends ViewGroup
{
  private int jdField_a_of_type_Int;
  private ProfileTemplateBase.NinePatchDecoderHandler jdField_a_of_type_ComTencentMobileqqVipDiyTemplateProfileTemplateBase$NinePatchDecoderHandler = new ProfileTemplateBase.NinePatchDecoderHandler();
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public ProfileTemplateNickNameContainer(Context paramContext, ProfileNameView paramProfileNameView)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = paramProfileNameView;
    addView(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
  }
  
  protected URLDrawable a(@NonNull String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mPlayGifImage = false;
    if (paramDecodeHandler != null) {
      localURLDrawableOptions.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(paramDecodeHandler);
    return paramString;
  }
  
  public ETTextViewPlus a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.a();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.b();
    int i = this.jdField_a_of_type_Int;
    int j = i + m;
    int k = paramInt3 - paramInt1;
    if (j > k)
    {
      paramInt1 = Math.max(0, paramInt3 - m);
      paramInt3 = k;
    }
    else
    {
      paramInt1 = i;
      paramInt3 = j;
      if (this.jdField_a_of_type_Boolean)
      {
        paramInt1 = k / 2 - (j - i) / 2;
        paramInt3 = paramInt1 + m;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
    paramInt2 = paramInt4 - paramInt2;
    ((ProfileNameView)localObject).layout(paramInt1, 0, paramInt3, paramInt2);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDiyTemplateProfileTemplateBase$NinePatchDecoderHandler.a(paramInt3 - paramInt1, paramInt2);
      localObject = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqVipDiyTemplateProfileTemplateBase$NinePatchDecoderHandler);
      ProfileTemplateBase.BackGroundUpdateListener.a((URLDrawable)localObject, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setBackgroundDrawable((Drawable)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setBackgroundDrawable(null);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.measure(paramInt2, paramInt2);
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.getMeasuredHeight());
  }
  
  public void setTextBgUrl(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      double d = UIUtils.b(getContext());
      Double.isNaN(d);
      this.b = ((int)(0.005D * d));
      Double.isNaN(d);
      this.c = ((int)(d * 0.03D));
    }
    else
    {
      this.b = 0;
      this.c = 0;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setBackgroundDrawable(null);
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.a();
    int i = this.c;
    int j = this.b;
    paramString.setPadding(i, j, i, j);
  }
  
  public void setTextCenter()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setTextViewX(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ProfileTemplateNickNameContainer
 * JD-Core Version:    0.7.0.1
 */