package com.tencent.mobileqq.qassistant.config;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QAssistantConfigUtils
{
  private static int a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return 0;
    }
    if (paramString.equalsIgnoreCase("scan")) {
      return 8;
    }
    if (paramString.equalsIgnoreCase("openreadinjoy")) {
      return 11;
    }
    if (paramString.equalsIgnoreCase("qassistantnearby")) {
      return 14;
    }
    if (paramString.equalsIgnoreCase("qsettings")) {
      return 6;
    }
    if (paramString.equalsIgnoreCase("searchpage")) {
      return 7;
    }
    if (paramString.equalsIgnoreCase("qinterest")) {
      return 12;
    }
    if (paramString.equalsIgnoreCase("ecchat")) {
      return 16;
    }
    if (paramString.equalsIgnoreCase("confessmsg")) {
      return 17;
    }
    if (paramString.equalsIgnoreCase("weishi")) {
      return 18;
    }
    if (paramString.equalsIgnoreCase("qqgame")) {
      return 19;
    }
    return 0;
  }
  
  public static QAssistantConfigItem a(Intent paramIntent)
  {
    String[] arrayOfString1 = null;
    if (paramIntent != null)
    {
      if (!paramIntent.hasExtra("q_qssistant_str_name")) {
        return null;
      }
      QAssistantConfigItem localQAssistantConfigItem = QAssistantConfigItemFactory.a(paramIntent.getStringExtra("q_qssistant_openaction"));
      localQAssistantConfigItem.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("q_qssistant_str_name");
      localQAssistantConfigItem.b = paramIntent.getStringExtra("q_qssistant_str_scheme");
      localQAssistantConfigItem.e = paramIntent.getStringExtra("q_qssistant_str_package");
      localQAssistantConfigItem.c = paramIntent.getStringExtra("q_qssistant_str_server");
      localQAssistantConfigItem.d = paramIntent.getStringExtra("q_qssistant_str_action");
      int j = 0;
      localQAssistantConfigItem.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("q_qssistant_openenable", false);
      localQAssistantConfigItem.g = paramIntent.getStringExtra("q_qssistant_jump_host");
      if (paramIntent.hasExtra("q_qssistant_extra_field_key"))
      {
        String[] arrayOfString2 = paramIntent.getStringArrayExtra("q_qssistant_extra_field_key");
        int i = j;
        if (paramIntent.hasExtra("q_qssistant_extra_field_value"))
        {
          arrayOfString1 = paramIntent.getStringArrayExtra("q_qssistant_extra_field_value");
          i = j;
        }
        while (i < arrayOfString2.length)
        {
          HashMap localHashMap = localQAssistantConfigItem.jdField_a_of_type_JavaUtilHashMap;
          String str = arrayOfString2[i];
          if ((arrayOfString1 != null) && (arrayOfString1.length > i)) {
            paramIntent = arrayOfString1[i];
          } else {
            paramIntent = "";
          }
          localHashMap.put(str, paramIntent);
          i += 1;
        }
      }
      return localQAssistantConfigItem;
    }
    return null;
  }
  
  public static QAssistantConfigItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (!paramJSONObject.has("str_name")) {
        return null;
      }
      Object localObject = paramJSONObject.optString("str_name", "");
      String str1 = paramJSONObject.optString("str_scheme", "");
      String str2 = paramJSONObject.optString("str_server", "");
      String str3 = paramJSONObject.optString("str_action", "");
      String str4 = paramJSONObject.optString("str_package", "");
      int i = 0;
      boolean bool = paramJSONObject.optBoolean("openenable", false);
      String str5 = paramJSONObject.optString("openaction", "");
      QAssistantConfigItem localQAssistantConfigItem = QAssistantConfigItemFactory.a(str5);
      localQAssistantConfigItem.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (!StringUtil.a(str1)) {
        localQAssistantConfigItem.b = str1;
      }
      if (!StringUtil.a(str2)) {
        localQAssistantConfigItem.c = str2;
      }
      if (!StringUtil.a(str3)) {
        localQAssistantConfigItem.d = str3;
      }
      if (!StringUtil.a(str4)) {
        localQAssistantConfigItem.e = str4;
      }
      localQAssistantConfigItem.jdField_a_of_type_Boolean = bool;
      if (!StringUtil.a(str5)) {
        localQAssistantConfigItem.f = str5;
      }
      if (paramJSONObject.has("extra_field_key"))
      {
        localObject = paramJSONObject.optJSONArray("extra_field_key");
        if (paramJSONObject.has("extra_field_value")) {
          paramJSONObject = paramJSONObject.optJSONArray("extra_field_value");
        } else {
          paramJSONObject = null;
        }
      }
      else
      {
        paramJSONObject = null;
        localObject = paramJSONObject;
      }
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        while (i < ((JSONArray)localObject).length())
        {
          str2 = ((JSONArray)localObject).optString(i, null);
          if (!StringUtil.a(str2))
          {
            if ((paramJSONObject != null) && (paramJSONObject.length() > i)) {
              str1 = paramJSONObject.optString(i, null);
            } else {
              str1 = null;
            }
            localQAssistantConfigItem.jdField_a_of_type_JavaUtilHashMap.put(str2, str1);
          }
          i += 1;
        }
      }
      return localQAssistantConfigItem;
    }
    return null;
  }
  
  public static String a()
  {
    SharedPreferences localSharedPreferences = AssistantUtils.a().getSharedPreferences("MOBILEQQ_QASSISTANT_CONFIG", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QASSISTANT_CONTEXT");
    localStringBuilder.append(AssistantUtils.a().getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public static List<QAssistantConfigItem> a(String paramString, List<String> paramList)
  {
    if (StringUtil.a(paramString)) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseJson  strJson = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("QAssistantConfigUtils", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        boolean bool = ((JSONObject)localObject2).has("qassistantconfigs");
        int j = 0;
        if (bool)
        {
          JSONArray localJSONArray = ((JSONObject)localObject2).getJSONArray("qassistantconfigs");
          i = 0;
          if (i < localJSONArray.length())
          {
            QAssistantConfigItem localQAssistantConfigItem = a(localJSONArray.getJSONObject(i));
            if (localQAssistantConfigItem == null) {
              break label239;
            }
            ((List)localObject1).add(localQAssistantConfigItem);
            break label239;
          }
        }
        if ((((JSONObject)localObject2).has("qassistantsupporthost")) && (paramList != null))
        {
          paramList.clear();
          localObject2 = ((JSONObject)localObject2).getJSONArray("qassistantsupporthost");
          i = j;
          if (i < ((JSONArray)localObject2).length())
          {
            paramList.add(((JSONArray)localObject2).getString(i));
            i += 1;
            continue;
          }
        }
        return localObject1;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseJson has exception strJson = ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e("QAssistantConfigUtils", 2, ((StringBuilder)localObject2).toString(), paramList);
      }
      label239:
      i += 1;
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if (paramString == null) {
      return;
    }
    SharedPreferences.Editor localEditor = AssistantUtils.a().getSharedPreferences("MOBILEQQ_QASSISTANT_CONFIG", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QASSISTANT_CONTEXT");
    localStringBuilder.append(paramBaseQQAppInterface.getCurrentAccountUin());
    localEditor.putString(localStringBuilder.toString(), paramString);
    localEditor.apply();
  }
  
  public static void a(QAssistantConfigItem paramQAssistantConfigItem, boolean paramBoolean, ActivityURIRequest paramActivityURIRequest)
  {
    if (paramQAssistantConfigItem != null)
    {
      if (paramActivityURIRequest == null) {
        return;
      }
      paramActivityURIRequest.extra().putBoolean("q_qssistant_debug_mode", paramBoolean);
      Object localObject2 = paramActivityURIRequest.extra();
      Object localObject1;
      if (paramQAssistantConfigItem.jdField_a_of_type_JavaLangString == null) {
        localObject1 = "";
      } else {
        localObject1 = paramQAssistantConfigItem.jdField_a_of_type_JavaLangString;
      }
      ((Bundle)localObject2).putString("q_qssistant_str_name", (String)localObject1);
      localObject2 = paramActivityURIRequest.extra();
      if (paramQAssistantConfigItem.b == null) {
        localObject1 = "";
      } else {
        localObject1 = paramQAssistantConfigItem.b;
      }
      ((Bundle)localObject2).putString("q_qssistant_str_scheme", (String)localObject1);
      localObject2 = paramActivityURIRequest.extra();
      if (paramQAssistantConfigItem.e == null) {
        localObject1 = "";
      } else {
        localObject1 = paramQAssistantConfigItem.e;
      }
      ((Bundle)localObject2).putString("q_qssistant_str_package", (String)localObject1);
      localObject2 = paramActivityURIRequest.extra();
      if (paramQAssistantConfigItem.c == null) {
        localObject1 = "";
      } else {
        localObject1 = paramQAssistantConfigItem.c;
      }
      ((Bundle)localObject2).putString("q_qssistant_str_server", (String)localObject1);
      localObject2 = paramActivityURIRequest.extra();
      if (paramQAssistantConfigItem.d == null) {
        localObject1 = "";
      } else {
        localObject1 = paramQAssistantConfigItem.d;
      }
      ((Bundle)localObject2).putString("q_qssistant_str_action", (String)localObject1);
      paramActivityURIRequest.extra().putBoolean("q_qssistant_openenable", paramQAssistantConfigItem.jdField_a_of_type_Boolean);
      localObject2 = paramActivityURIRequest.extra();
      if (paramQAssistantConfigItem.f == null) {
        localObject1 = "";
      } else {
        localObject1 = paramQAssistantConfigItem.f;
      }
      ((Bundle)localObject2).putString("q_qssistant_openaction", (String)localObject1);
      localObject2 = paramActivityURIRequest.extra();
      if (paramQAssistantConfigItem.g == null) {
        localObject1 = "";
      } else {
        localObject1 = paramQAssistantConfigItem.g;
      }
      ((Bundle)localObject2).putString("q_qssistant_jump_host", (String)localObject1);
      int i = paramQAssistantConfigItem.jdField_a_of_type_JavaUtilHashMap.size();
      if (i > 0)
      {
        localObject2 = new String[i];
        String[] arrayOfString = new String[i];
        i = 0;
        Iterator localIterator = paramQAssistantConfigItem.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          paramQAssistantConfigItem = (String)((Map.Entry)localObject1).getKey();
          localObject1 = (String)((Map.Entry)localObject1).getValue();
          localObject2[i] = paramQAssistantConfigItem;
          paramQAssistantConfigItem = (QAssistantConfigItem)localObject1;
          if (localObject1 == null) {
            paramQAssistantConfigItem = "";
          }
          arrayOfString[i] = paramQAssistantConfigItem;
          i += 1;
        }
        paramActivityURIRequest.extra().putStringArray("q_qssistant_extra_field_key", (String[])localObject2);
        paramActivityURIRequest.extra().putStringArray("q_qssistant_extra_field_value", arrayOfString);
      }
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject1 = Build.BRAND;
    Object localObject2 = localObject1;
    if (StringUtil.a((String)localObject1)) {
      localObject2 = Build.MANUFACTURER;
    }
    localObject1 = localObject2;
    if (StringUtil.a((String)localObject2)) {
      localObject1 = Build.PRODUCT;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reportQAssistantJump openAction: ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" strBrand: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("QAssistantConfigUtils", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(a(paramString));
    paramString = ((StringBuilder)localObject2).toString();
    if (localObject1 == null) {
      localObject1 = "";
    }
    ReportController.b(null, "dc00898", "", "", "0X800A99A", "0X800A99A", 0, 0, paramString, "", (String)localObject1, Build.MODEL);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportQAssistantJumpMonitor host: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" openAction: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" result: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QAssistantConfigUtils", 2, ((StringBuilder)localObject).toString());
    }
    HashMap localHashMap = new HashMap();
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    localHashMap.put("host", localObject);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localHashMap.put("openJumpAction", paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramInt);
    paramString1.append("");
    localHashMap.put("result", paramString1.toString());
    paramString1 = StatisticCollector.getInstance(BaseApplication.getContext());
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramString1.collectPerformance(null, "qAudioAssistantJumpMonitor", bool, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.config.QAssistantConfigUtils
 * JD-Core Version:    0.7.0.1
 */