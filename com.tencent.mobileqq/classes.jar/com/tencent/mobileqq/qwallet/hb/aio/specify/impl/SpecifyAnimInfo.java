package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import java.text.DecimalFormat;

public class SpecifyAnimInfo
{
  public static String e = "https://i.gtimg.cn/channel/exclusive_hb/socialpay_makehb_ani_";
  public static String f = "https://i.gtimg.cn/channel/exclusive_hb/socialpay_aio_ani_";
  public static String g = e;
  public static DecimalFormat h = new DecimalFormat("#0.00");
  private static String i = f;
  private static boolean j = false;
  public int a;
  public long b;
  public long c;
  public int d;
  
  public static String a()
  {
    if (!j)
    {
      BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
      if (localBaseQQAppInterface != null) {
        i = ((IQWalletConfigService)localBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "")).getString("hb_exclusive", f, new String[] { "aio_red", "prefix" });
      }
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SpecifyAnimInfo{aId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", minPrice=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", maxPrice=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", skinId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyAnimInfo
 * JD-Core Version:    0.7.0.1
 */