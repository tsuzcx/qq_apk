package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import baul;
import bdxb;
import bdxc;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.ProfileNameView;
import xod;

public class ProfileTemplateNickNameContainer
  extends ViewGroup
{
  private int jdField_a_of_type_Int;
  private bdxc jdField_a_of_type_Bdxc = new bdxc();
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
    localURLDrawableOptions.mLoadingDrawable = baul.a;
    localURLDrawableOptions.mFailedDrawable = baul.a;
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
    int n = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.a();
    int k = this.jdField_a_of_type_Int;
    int m = this.jdField_a_of_type_Int + n;
    int j;
    int i;
    if (m > paramInt3 - paramInt1)
    {
      j = Math.max(0, paramInt3 - n);
      i = paramInt3 - paramInt1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.layout(j, 0, i, paramInt4 - paramInt2);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Bdxc.a(i - j, paramInt4 - paramInt2);
      URLDrawable localURLDrawable = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bdxc);
      bdxb.a(localURLDrawable, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setBackgroundDrawable(localURLDrawable);
      return;
      i = m;
      j = k;
      if (this.jdField_a_of_type_Boolean)
      {
        j = (paramInt3 - paramInt1) / 2 - (m - k) / 2;
        i = j + n;
      }
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
      int i = xod.b(getContext());
      this.b = ((int)(i * 0.005D));
      this.c = ((int)(i * 0.03D));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.a().setPadding(this.c, this.b, this.c, this.b);
      return;
      this.b = 0;
      this.c = 0;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setBackgroundDrawable(null);
    }
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