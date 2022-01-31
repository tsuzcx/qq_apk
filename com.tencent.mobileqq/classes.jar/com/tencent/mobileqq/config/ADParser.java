package com.tencent.mobileqq.config;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.struct.ADMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;

public class ADParser
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = b(paramString);
      str = PkgTools.a("RESPCONDITION", paramString);
      if (PkgTools.a("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
        return 3;
      }
      if (str.equals("MANUAL")) {
        return 0;
      }
      if (str.equals("AUTO")) {
        return 1;
      }
    } while (!str.equals("SEMIAUTO"));
    return 2;
  }
  
  public static ADMsg a(String paramString)
  {
    ADMsg localADMsg = new ADMsg();
    paramString = b(paramString);
    localADMsg.a = PkgTools.a(PkgTools.a("DESC", paramString));
    localADMsg.b = PkgTools.a(PkgTools.a("SUBJECT", paramString));
    localADMsg.c = PkgTools.a("RESPCONDITION", paramString);
    if ((!localADMsg.c.equals("MANUAL")) && (!localADMsg.c.equals("AUTO")) && (!localADMsg.c.equals("SEMIAUTO"))) {
      return null;
    }
    localADMsg.d = PkgTools.a("RESPDESC", paramString);
    localADMsg.e = PkgTools.a("RESPCONTENTTYPES", paramString);
    localADMsg.f = PkgTools.a("RESPDEST", paramString);
    localADMsg.g = PkgTools.a("RESPCONTENTS", paramString);
    localADMsg.d = PkgTools.a(localADMsg.d);
    localADMsg.f = PkgTools.a(localADMsg.f).trim();
    localADMsg.g = PkgTools.a(localADMsg.g);
    return localADMsg;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return PkgTools.a("RESPCONTENTTYPES", paramString);
  }
  
  public static ADMsg b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {}
    do
    {
      return paramString;
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
    } while (!paramString.c.equals("SEMIAUTO"));
    paramString.a();
    return paramString;
  }
  
  private static String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    return PkgTools.a(PkgTools.a(paramString, 0, "||QQNO||", Config.a()), 0, "||LICENCE||", AppSetting.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ADParser
 * JD-Core Version:    0.7.0.1
 */