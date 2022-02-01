package com.tencent.mobileqq.search.util.intercept.bean;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SogouInterceptRuleListHolder
{
  private static String a = "";
  private static List<SogouInterceptRuleItem> b;
  
  @NonNull
  public static List<SogouInterceptRuleItem> a()
  {
    try
    {
      if ((b == null) || (b.size() <= 0)) {
        b();
      }
      List localList = b;
      return localList;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    try
    {
      a = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static void b()
  {
    try
    {
      b = new ArrayList();
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("初始化域名规则:");
        ((StringBuilder)localObject1).append(a);
        QLog.d("搜狗结果页拦截", 2, ((StringBuilder)localObject1).toString());
      }
      boolean bool = TextUtils.isEmpty(a);
      if (bool) {
        return;
      }
      try
      {
        localObject1 = new JSONArray(a);
        int i = 0;
        Object localObject3;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject3 == null) {
            return;
          }
          SogouInterceptRuleItem localSogouInterceptRuleItem = new SogouInterceptRuleItem();
          localSogouInterceptRuleItem.a((JSONObject)localObject3);
          b.add(localSogouInterceptRuleItem);
          if (QLog.isColorLevel()) {
            QLog.d("搜狗结果页拦截", 2, "初始化域名规则成功");
          }
          i += 1;
        }
        localObject2 = finally;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("初始化失败：");
          ((StringBuilder)localObject3).append(localJSONException.getLocalizedMessage());
          QLog.d("搜狗结果页拦截", 2, ((StringBuilder)localObject3).toString());
        }
        return;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.intercept.bean.SogouInterceptRuleListHolder
 * JD-Core Version:    0.7.0.1
 */