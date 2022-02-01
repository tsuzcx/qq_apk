package com.tencent.mobileqq.qwallet.utils;

import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qwallet.plugin.IQWalletHelper;

public class QWalletValues
{
  public static final String a = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletExternalPath();
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(".tmp/");
    b = localStringBuilder.toString();
    c = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(".tmp/");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append("topay_recommends");
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append("group_available_list_");
    f = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.QWalletValues
 * JD-Core Version:    0.7.0.1
 */