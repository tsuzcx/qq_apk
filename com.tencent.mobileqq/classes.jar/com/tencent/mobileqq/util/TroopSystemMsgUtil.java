package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TroopSystemMsgUtil
{
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_answer_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (paramContext.contains(paramString)) {
      return paramContext.getString(paramString, null);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    Matcher localMatcher = Pattern.compile("\\d+", 2).matcher(paramString);
    for (paramString = null; localMatcher.find(); paramString = localMatcher.group()) {}
    return paramString;
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    List localList = a(paramString);
    String str1 = paramString;
    if (localList.size() > 0)
    {
      int i = 0;
      str1 = paramString;
      while (i < localList.size())
      {
        String str2 = (String)localList.get(i);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("\"");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append("\"");
        localObject = ((StringBuilder)localObject).toString();
        if (paramString.indexOf((String)localObject) + ((String)localObject).length() == paramString.length()) {
          localObject = ContactUtils.a(paramQQAppInterface, str2, true);
        } else {
          localObject = ContactUtils.a(paramQQAppInterface, str2, true);
        }
        str1 = a(str1, str2, (String)localObject);
        i += 1;
      }
    }
    return str1;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.equals(paramString3)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    paramString3 = new StringBuilder();
    paramString3.append("\"");
    paramString3.append(paramString2);
    paramString3.append("\"");
    return paramString1.replace(paramString3.toString(), localStringBuilder.toString());
  }
  
  private static List<String> a(String paramString)
  {
    Object localObject = Pattern.compile("\"\\d+\"", 2);
    Pattern localPattern = Pattern.compile("\\d+", 2);
    ArrayList localArrayList = new ArrayList();
    paramString = ((Pattern)localObject).matcher(paramString);
    while (paramString.find())
    {
      localObject = localPattern.matcher(paramString.group());
      while (((Matcher)localObject).find()) {
        localArrayList.add(((Matcher)localObject).group());
      }
    }
    return localArrayList;
  }
  
  public static String b(String paramString)
  {
    paramString = Pattern.compile("\"\\d+\"", 2).matcher(paramString);
    if (paramString.find()) {
      return paramString.group();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.TroopSystemMsgUtil
 * JD-Core Version:    0.7.0.1
 */