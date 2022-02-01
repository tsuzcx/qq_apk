package com.tencent.mobileqq.config;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.struct.ADMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;

public class ADParser
{
  public static ADMsg a(String paramString)
  {
    ADMsg localADMsg = new ADMsg();
    paramString = e(paramString);
    localADMsg.a = PkgTools.decodeCgi(PkgTools.getParaVal("DESC", paramString));
    localADMsg.b = PkgTools.decodeCgi(PkgTools.getParaVal("SUBJECT", paramString));
    localADMsg.c = PkgTools.getParaVal("RESPCONDITION", paramString);
    if ((!localADMsg.c.equals("MANUAL")) && (!localADMsg.c.equals("AUTO")) && (!localADMsg.c.equals("SEMIAUTO"))) {
      return null;
    }
    localADMsg.d = PkgTools.getParaVal("RESPDESC", paramString);
    localADMsg.e = PkgTools.getParaVal("RESPCONTENTTYPES", paramString);
    localADMsg.f = PkgTools.getParaVal("RESPDEST", paramString);
    localADMsg.g = PkgTools.getParaVal("RESPCONTENTS", paramString);
    localADMsg.d = PkgTools.decodeCgi(localADMsg.d);
    localADMsg.f = PkgTools.decodeCgi(localADMsg.f).trim();
    localADMsg.g = PkgTools.decodeCgi(localADMsg.g);
    return localADMsg;
  }
  
  public static int b(String paramString)
  {
    int j = -1;
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return -1;
      }
      paramString = e(paramString);
      String str = PkgTools.getParaVal("RESPCONDITION", paramString);
      if (PkgTools.getParaVal("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
        return 3;
      }
      if (str.equals("MANUAL")) {
        return 0;
      }
      if (str.equals("AUTO")) {
        return 1;
      }
      i = j;
      if (str.equals("SEMIAUTO")) {
        i = 2;
      }
    }
    return i;
  }
  
  public static String c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return PkgTools.getParaVal("RESPCONTENTTYPES", paramString);
    }
    return null;
  }
  
  public static ADMsg d(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return paramString;
    }
    if (paramString.c.equals("MANUAL"))
    {
      paramString.a(false);
      return paramString;
    }
    if (paramString.c.equals("AUTO"))
    {
      paramString.a();
      return paramString;
    }
    if (paramString.c.equals("SEMIAUTO")) {
      paramString.a();
    }
    return paramString;
  }
  
  private static String e(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return PkgTools.replace(PkgTools.replace(paramString, 0, "||QQNO||", Config.a()), 0, "||LICENCE||", AppSetting.f());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.ADParser
 * JD-Core Version:    0.7.0.1
 */