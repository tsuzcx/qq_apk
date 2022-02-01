package com.tencent.mobileqq.kandian.repo.aladdin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.aladdin.config.utils.Log;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQAladdinPrefUtils
{
  public static int a(int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null)
    {
      Log.e("AladdinPrefUtils", "getConfigVersionById: return 0 for sp is null");
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config_version_");
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  private static SharedPreferences a()
  {
    AppRuntime localAppRuntime = ((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if (localAppRuntime == null)
    {
      Log.e("AladdinPrefUtils", "getSharedPreferences: null for runtime is null");
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("readinjoy_sp_aladdin_");
    ((StringBuilder)localObject).append(localAppRuntime.getAccount());
    localObject = ((StringBuilder)localObject).toString();
    return localAppRuntime.getApplication().getSharedPreferences((String)localObject, 0);
  }
  
  public static String a()
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((SharedPreferences)localObject1).getAll();
      Object localObject2 = new StringBuilder();
      Iterator localIterator = ((Map)localObject1).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((StringBuilder)localObject2).append("key=");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(", value=");
        ((StringBuilder)localObject2).append(((Map)localObject1).get(str));
        ((StringBuilder)localObject2).append("\n");
      }
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "empty";
      }
      return localObject1;
    }
    return "error";
  }
  
  public static void a()
  {
    Log.d("AladdinPrefUtils", "clearAladdinCommonConfigs");
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null)
    {
      Log.d("AladdinPrefUtils", "clearAladdinCommonConfigs: sp is null");
      return;
    }
    localSharedPreferences.edit().clear().apply();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = a();
    if (localObject == null)
    {
      Log.e("AladdinPrefUtils", "setConfigVersionById: sp is null");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config_version_");
    localStringBuilder.append(paramInt1);
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt2).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.QQAladdinPrefUtils
 * JD-Core Version:    0.7.0.1
 */