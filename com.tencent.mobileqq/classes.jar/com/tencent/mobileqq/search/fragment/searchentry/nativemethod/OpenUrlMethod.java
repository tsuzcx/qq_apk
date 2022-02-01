package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import anaq;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bbgh;
import bbgk;
import bjnd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.TKDSearchHistoryBean;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

class OpenUrlMethod
  extends SearchNativeMethodBase
{
  public static final String AID = "AID";
  public static final String FROM_WHERE = "FROM_WHERE";
  public static final String HIS_LABEL = "HIS_LABEL";
  public static final String HIS_TITLE = "HIS_TITLE";
  public static final String JSON_STR = "JSON_STR";
  public static final String REOPEN_URL = "REOPEN_URL";
  public static final String URL = "URL";
  
  public OpenUrlMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  private int getFromWhere(@NonNull HippyMap paramHippyMap, String paramString)
  {
    int i = getSafetyInt(paramHippyMap.getString("FROM_WHERE"), 5);
    if (TextUtils.isEmpty(paramString)) {
      return 5;
    }
    return i;
  }
  
  private String getHistoryUrl(HippyMap paramHippyMap)
  {
    String str = getSafetyString(paramHippyMap.getString("URL"));
    paramHippyMap = getSafetyString(paramHippyMap.getString("REOPEN_URL"));
    if (TextUtils.isEmpty(paramHippyMap)) {
      return str;
    }
    return paramHippyMap;
  }
  
  private int getId(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2.hashCode();
    }
    return paramString1.hashCode();
  }
  
  private int getSafetyInt(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  private String getSafetyString(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  private boolean isParamValid(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {}
    String str;
    do
    {
      return false;
      str = getSafetyString(paramHippyMap.getString("URL"));
      paramHippyMap = getSafetyString(paramHippyMap.getString("HIS_TITLE"));
    } while ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(paramHippyMap)));
    return true;
  }
  
  private void openUrl(@NonNull HippyMap paramHippyMap)
  {
    String str1 = getSafetyString(paramHippyMap.getString("URL"));
    String str2 = getSafetyString(paramHippyMap.getString("HIS_TITLE"));
    if (!TextUtils.isEmpty(str1))
    {
      paramHippyMap = str1;
      if (bjnd.a(str1)) {}
    }
    else
    {
      paramHippyMap = bbgh.a(str2, 5, bbgh.b(10));
    }
    bbgk.a(this.app, this.context, paramHippyMap);
  }
  
  private void saveHistory(@NonNull HippyMap paramHippyMap)
  {
    String str1 = getSafetyString(paramHippyMap.getString("HIS_TITLE"));
    String str2 = getSafetyString(paramHippyMap.getString("JSON_STR"));
    String str3 = getSafetyString(paramHippyMap.getString("AID"));
    String str4 = getSafetyString(paramHippyMap.getString("HIS_LABEL"));
    String str5 = getHistoryUrl(paramHippyMap);
    int i = getFromWhere(paramHippyMap, str5);
    paramHippyMap = new TKDSearchHistoryBean();
    paramHippyMap.setFromWhere(i);
    paramHippyMap.setUrl(str5);
    paramHippyMap.setTitle(str1);
    paramHippyMap.setKeyword("");
    paramHippyMap.setAid(str3);
    paramHippyMap.setJsonStr(str2);
    paramHippyMap.setId(getId(str1, str5));
    paramHippyMap.setLabel(str4);
    anaq.a().a(paramHippyMap);
  }
  
  private boolean shouldSaveHistory(@NonNull HippyMap paramHippyMap)
  {
    boolean bool = false;
    if (getSafetyInt(paramHippyMap.getString("DISABLE_SAVE"), 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public String getFuncName()
  {
    return "startPageOpenUrl";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (!isParamValid(paramHippyMap)) {
      return;
    }
    if (shouldSaveHistory(paramHippyMap)) {
      saveHistory(paramHippyMap);
    }
    openUrl(paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.OpenUrlMethod
 * JD-Core Version:    0.7.0.1
 */