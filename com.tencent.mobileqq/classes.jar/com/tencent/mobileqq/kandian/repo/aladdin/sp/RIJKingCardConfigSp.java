package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJKingCardConfigSp
{
  public static String a()
  {
    String str = (String)RIJSPUtils.a("readinjoy_kingcard_gudieurl", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getKingCardGuideUrl result=");
      localStringBuilder.append(str);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateKingCardSwitch value=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_kingcard_switch", Integer.valueOf(paramInt));
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateKingCardGuideUrl value=");
      localStringBuilder.append(paramString);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_kingcard_gudieurl", paramString);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    int i = ((Integer)RIJSPUtils.a("readinjoy_kingcard_switch", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getKingCardSwitch result=");
      localStringBuilder.append(i);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static String b()
  {
    String str = (String)RIJSPUtils.a("readinjoy_kingcard_tiptext", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getKingCardTipText result=");
      localStringBuilder.append(str);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateKingCardTipText value=");
      localStringBuilder.append(paramString);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_kingcard_tiptext", paramString);
  }
  
  public static String c()
  {
    String str = (String)RIJSPUtils.a("readinjoy_kingcard_jumptext", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getKingCardJumpText result=");
      localStringBuilder.append(str);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  public static void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateKingCardJumpText value=");
      localStringBuilder.append(paramString);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_kingcard_jumptext", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJKingCardConfigSp
 * JD-Core Version:    0.7.0.1
 */