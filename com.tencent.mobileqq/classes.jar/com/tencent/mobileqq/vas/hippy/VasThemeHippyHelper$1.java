package com.tencent.mobileqq.vas.hippy;

import android.os.Bundle;
import android.text.TextUtils;

class VasThemeHippyHelper$1
  implements Runnable
{
  VasThemeHippyHelper$1(VasThemeHippyHelper paramVasThemeHippyHelper, String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("themeId", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("actionResult", this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localBundle.putString("actionName", this.jdField_b_of_type_JavaLangString);
      localBundle.putLong("downloadTime", this.jdField_a_of_type_Long);
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      localBundle.putString("statistic_key", this.jdField_c_of_type_JavaLangString);
      localBundle.putString("param_FailCode", this.d);
    }
    if (!TextUtils.isEmpty(this.e))
    {
      localBundle.putString("from", this.e);
      localBundle.putInt("step", this.jdField_b_of_type_Int);
      localBundle.putInt("code", this.jdField_c_of_type_Int);
      localBundle.putString("version", this.f);
      localBundle.putString("r5", this.g);
      localBundle.putString("path", this.h);
    }
    VasThemeHippyHelper.a(localBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper.1
 * JD-Core Version:    0.7.0.1
 */