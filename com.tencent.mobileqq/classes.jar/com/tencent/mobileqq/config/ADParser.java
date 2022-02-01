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
      str = PkgTools.GetParaVal("RESPCONDITION", paramString);
      if (PkgTools.GetParaVal("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
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
    localADMsg.a = PkgTools.Decodecgi(PkgTools.GetParaVal("DESC", paramString));
    localADMsg.b = PkgTools.Decodecgi(PkgTools.GetParaVal("SUBJECT", paramString));
    localADMsg.c = PkgTools.GetParaVal("RESPCONDITION", paramString);
    if ((!localADMsg.c.equals("MANUAL")) && (!localADMsg.c.equals("AUTO")) && (!localADMsg.c.equals("SEMIAUTO"))) {
      return null;
    }
    localADMsg.d = PkgTools.GetParaVal("RESPDESC", paramString);
    localADMsg.e = PkgTools.GetParaVal("RESPCONTENTTYPES", paramString);
    localADMsg.f = PkgTools.GetParaVal("RESPDEST", paramString);
    localADMsg.g = PkgTools.GetParaVal("RESPCONTENTS", paramString);
    localADMsg.d = PkgTools.Decodecgi(localADMsg.d);
    localADMsg.f = PkgTools.Decodecgi(localADMsg.f).trim();
    localADMsg.g = PkgTools.Decodecgi(localADMsg.g);
    return localADMsg;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return PkgTools.GetParaVal("RESPCONTENTTYPES", paramString);
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
    return PkgTools.replace(PkgTools.replace(paramString, 0, "||QQNO||", Config.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ADParser
 * JD-Core Version:    0.7.0.1
 */