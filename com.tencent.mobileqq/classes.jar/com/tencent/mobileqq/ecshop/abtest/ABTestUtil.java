package com.tencent.mobileqq.ecshop.abtest;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.SharedPreferencesUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ABTestUtil
{
  public static Map<String, ABTestInfo> a()
  {
    HashMap localHashMap = new HashMap();
    try
    {
      Object localObject = AppUtils.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ab_test_info_");
      localStringBuilder.append(((AppRuntime)localObject).getAccount());
      localObject = SharedPreferencesUtil.a(localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a(localHashMap, (String)localObject);
        return localHashMap;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Ecshop_ABTestUtil", 1, localException, new Object[0]);
    }
    return localHashMap;
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    AppRuntime localAppRuntime = AppUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ab_test_info_");
    localStringBuilder.append(localAppRuntime.getAccount());
    SharedPreferencesUtil.a(localStringBuilder.toString(), paramString);
  }
  
  private static void a(Map<String, ABTestInfo> paramMap, String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("MBucketTest");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramString.optJSONObject(str);
        if (localJSONObject != null) {
          paramMap.put(str, ABTestInfo.a(localJSONObject));
        }
      }
      return;
    }
    catch (Exception paramMap)
    {
      QLog.e("Ecshop_ABTestUtil", 1, paramMap, new Object[0]);
    }
  }
  
  @Nullable
  public static ABTestInfo b(String paramString)
  {
    return (ABTestInfo)a().get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.abtest.ABTestUtil
 * JD-Core Version:    0.7.0.1
 */