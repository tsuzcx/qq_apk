package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class HistoryChatMsgSearchKeyUtil
{
  private static String a(String paramString)
  {
    return paramString;
  }
  
  public static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("history_chat_msg_search_key", 0).edit();
    localEditor.remove(a(paramString));
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject1;
    String str1;
    int j;
    SharedPreferences localSharedPreferences;
    Object localObject2;
    if (paramString2 != null)
    {
      if (paramString2.length() == 0) {
        return;
      }
      localObject1 = paramString2.toLowerCase();
      str1 = a(paramString1);
      paramString1 = BaseApplication.getContext();
      j = 0;
      localSharedPreferences = paramString1.getSharedPreferences("history_chat_msg_search_key", 0);
      paramString1 = localSharedPreferences.getString(str1, "");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("in storeKeyword(),content is:");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(",keyword is:");
        ((StringBuilder)localObject2).append(paramString2);
        QLog.d("HistoryChatMsgSearchKeyUtil", 2, ((StringBuilder)localObject2).toString());
      }
      if ((paramString1 == null) || (paramString1.trim().length() <= 0)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        localObject2 = new JSONArray(paramString1);
        HashMap localHashMap = new HashMap();
        int k = ((JSONArray)localObject2).length();
        paramString1 = new ArrayList();
        i = 0;
        if (i < k)
        {
          String str2 = ((JSONArray)localObject2).optString(i, "");
          if ((str2 == null) || (str2.length() <= 0)) {
            break label540;
          }
          paramString1.add(str2);
          break label540;
        }
        k = paramString1.size();
        i = 0;
        if (i < k)
        {
          localHashMap.put(((String)paramString1.get(i)).toLowerCase(), Integer.valueOf(i));
          i += 1;
          continue;
        }
        localObject2 = (Integer)localHashMap.get(localObject1);
        if (localObject2 == null)
        {
          j = k - 10 + 1;
          i = j;
          if (j < 0) {
            i = 0;
          }
          localObject1 = new JSONArray();
          if (i < k)
          {
            ((JSONArray)localObject1).put((String)paramString1.get(i));
            i += 1;
            continue;
          }
          ((JSONArray)localObject1).put(paramString2);
          paramString1 = ((JSONArray)localObject1).toString();
        }
        else
        {
          localObject1 = new JSONArray();
          int m = ((Integer)localObject2).intValue();
          i = j;
          if (i < k)
          {
            localObject2 = (String)paramString1.get(i);
            if (i == m) {
              break label547;
            }
            ((JSONArray)localObject1).put(localObject2);
            break label547;
          }
          ((JSONArray)localObject1).put(paramString2);
          paramString1 = ((JSONArray)localObject1).toString();
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("storeKeyword(),parse string failed,error msg is:");
          ((StringBuilder)localObject1).append(paramString1.getMessage());
          QLog.d("HistoryChatMsgSearchKeyUtil", 2, ((StringBuilder)localObject1).toString(), paramString1);
        }
        paramString1 = new JSONArray();
        paramString1.put(paramString2);
        paramString1 = paramString1.toString();
      }
      paramString1 = new JSONArray();
      paramString1.put(paramString2);
      paramString1 = paramString1.toString();
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("lastSaveContent is:");
        paramString2.append(paramString1);
        QLog.d("HistoryChatMsgSearchKeyUtil", 2, paramString2.toString());
      }
      paramString2 = localSharedPreferences.edit();
      paramString2.putString(str1, paramString1);
      paramString2.commit();
      return;
      label540:
      i += 1;
      continue;
      label547:
      i += 1;
    }
  }
  
  public static String[] a(String paramString)
  {
    paramString = a(paramString);
    paramString = BaseApplication.getContext().getSharedPreferences("history_chat_msg_search_key", 0).getString(paramString, "");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("in getKeywords(),content is:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("HistoryChatMsgSearchKeyUtil", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString != null) && (paramString.trim().length() > 0)) {}
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = paramString.length();
        localObject = new ArrayList(i);
        if (i >= 0)
        {
          String str = paramString.optString(i, "");
          if ((str == null) || (str.length() <= 0)) {
            break label187;
          }
          ((ArrayList)localObject).add(str);
          break label187;
        }
        paramString = (String[])((ArrayList)localObject).toArray(new String[0]);
        return paramString;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getKeywords(),parse string failed,error msg is:");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.d("HistoryChatMsgSearchKeyUtil", 2, ((StringBuilder)localObject).toString(), paramString);
        }
      }
      return null;
      label187:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil
 * JD-Core Version:    0.7.0.1
 */