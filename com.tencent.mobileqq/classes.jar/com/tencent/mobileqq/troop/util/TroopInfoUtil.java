package com.tencent.mobileqq.troop.util;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class TroopInfoUtil
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject1 = new String[27];
    int i = 0;
    localObject1[0] = "li";
    localObject1[1] = "del";
    localObject1[2] = "ins";
    localObject1[3] = "fieldset";
    localObject1[4] = "legend";
    localObject1[5] = "tr";
    localObject1[6] = "th";
    localObject1[7] = "caption";
    localObject1[8] = "thead";
    localObject1[9] = "tbody";
    localObject1[10] = "tfoot";
    localObject1[11] = "p";
    localObject1[12] = "h[1-6]";
    localObject1[13] = "dl";
    localObject1[14] = "dt";
    localObject1[15] = "dd";
    localObject1[16] = "ol";
    localObject1[17] = "ul";
    localObject1[18] = "dir";
    localObject1[19] = "address";
    localObject1[20] = "blockquote";
    localObject1[21] = "center";
    localObject1[22] = "hr";
    localObject1[23] = "pre";
    localObject1[24] = "form";
    localObject1[25] = "textarea";
    localObject1[26] = "table";
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<(\\s*");
      ((StringBuilder)localObject2).append(localObject1[i]);
      ((StringBuilder)localObject2).append(")[^>]*>");
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString()).matcher(paramString);
      if (((Matcher)localObject2).find()) {
        paramString = ((Matcher)localObject2).replaceAll(" ");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("</?(\\s*");
      ((StringBuilder)localObject2).append(localObject1[i]);
      ((StringBuilder)localObject2).append(")[^>]*>");
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString()).matcher(paramString);
      if (((Matcher)localObject2).find()) {
        paramString = ((Matcher)localObject2).replaceAll("\n");
      }
      i += 1;
    }
    localObject1 = Pattern.compile("<br>").matcher(paramString);
    if (((Matcher)localObject1).find()) {
      paramString = ((Matcher)localObject1).replaceAll("\n");
    }
    return paramString.replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    paramAppRuntime = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString1);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.isTroopOwner(paramString2);
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.TroopInfoUtil
 * JD-Core Version:    0.7.0.1
 */