package com.tencent.mobileqq.kandian.base.utils;

import android.text.TextUtils;
import com.tencent.util.QQDeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/RIJDeviceUtil;", "", "()V", "tryGetIMEITimes", "", "tryGetIMSITimes", "getIMEIForReport", "", "getIMSIForReport", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDeviceUtil
{
  private static int a;
  public static final RIJDeviceUtil a;
  private static int b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsRIJDeviceUtil = new RIJDeviceUtil();
  }
  
  @JvmStatic
  @NotNull
  public static final String a()
  {
    if (jdField_a_of_type_Int >= 10) {
      return "null";
    }
    String str2 = QQDeviceInfo.getIMEI("d059d3", 5);
    String str1 = str2;
    if (TextUtils.isEmpty((CharSequence)str2))
    {
      jdField_a_of_type_Int += 1;
      str1 = "null";
    }
    Intrinsics.checkExpressionValueIsNotNull(str1, "imei");
    return str1;
  }
  
  @JvmStatic
  @NotNull
  public static final String b()
  {
    if (b >= 10) {
      return "null";
    }
    String str2 = QQDeviceInfo.getIMSI("d059d3", 5);
    String str1 = str2;
    if (TextUtils.isEmpty((CharSequence)str2))
    {
      b += 1;
      str1 = "null";
    }
    Intrinsics.checkExpressionValueIsNotNull(str1, "imsi");
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil
 * JD-Core Version:    0.7.0.1
 */