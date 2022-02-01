package com.tencent.mobileqq.qwallet.utils;

import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qwallet.plugin.IQWalletHelper;

public class QWalletValues
{
  public static final String a = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletExternalPath();
  public static final String b = a + ".tmp/";
  public static final String c = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath();
  public static final String d = c + ".tmp/";
  public static final String e = d + "topay_recommends";
  public static final String f = d + "group_available_list_";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.QWalletValues
 * JD-Core Version:    0.7.0.1
 */