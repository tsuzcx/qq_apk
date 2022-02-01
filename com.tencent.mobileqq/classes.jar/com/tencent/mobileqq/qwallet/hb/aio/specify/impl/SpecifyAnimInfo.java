package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import java.text.DecimalFormat;

public class SpecifyAnimInfo
{
  public static String a = "https://i.gtimg.cn/channel/exclusive_hb/socialpay_makehb_ani_";
  public static DecimalFormat a;
  private static boolean a = false;
  public static String b = "https://i.gtimg.cn/channel/exclusive_hb/socialpay_aio_ani_";
  public static String c = jdField_a_of_type_JavaLangString;
  private static String d = jdField_b_of_type_JavaLangString;
  public int a;
  public long a;
  public int b;
  public long b;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#0.00");
  }
  
  public static String a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      BaseQQAppInterface localBaseQQAppInterface = QWalletTools.a();
      if (localBaseQQAppInterface != null) {
        d = ((IQWalletConfigService)localBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "")).getString("hb_exclusive", jdField_b_of_type_JavaLangString, new String[] { "aio_red", "prefix" });
      }
    }
    return d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SpecifyAnimInfo{aId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", minPrice=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", maxPrice=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", skinId=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyAnimInfo
 * JD-Core Version:    0.7.0.1
 */