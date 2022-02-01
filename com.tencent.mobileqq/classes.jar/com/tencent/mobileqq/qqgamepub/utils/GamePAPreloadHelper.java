package com.tencent.mobileqq.qqgamepub.utils;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class GamePAPreloadHelper
{
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static WeakReference<GamePAPreloadHelper.OnPreloadFeedsListener> jdField_a_of_type_MqqUtilWeakReference;
  private static long b;
  private static long c;
  
  public static long a()
  {
    return c;
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManagerV2.excute(new GamePAPreloadHelper.1(), 32, null, true);
  }
  
  public static void a(long paramLong)
  {
    c = paramLong;
  }
  
  public static void a(GamePAPreloadHelper.OnPreloadFeedsListener paramOnPreloadFeedsListener)
  {
    jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnPreloadFeedsListener);
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static long b()
  {
    return jdField_a_of_type_Long;
  }
  
  private static long b(String paramString)
  {
    int j = 5381;
    int i = 0;
    while (i < paramString.length())
    {
      j += (j << 5) + Character.codePointAt(paramString, i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  private static String b(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString);
    }
    catch (Throwable paramString)
    {
      QLog.e("feedsPreload_QQGamePub_GamePAPreloadHelper", 1, paramString, new Object[0]);
    }
    return localJSONObject.toString();
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_Long = 0L;
    b = 0L;
    c = 0L;
    jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  private static void b(Bundle paramBundle1, Bundle paramBundle2, String paramString, JSONArray paramJSONArray)
  {
    ThreadManagerV2.excute(new GamePAPreloadHelper.2(paramBundle1, paramString, paramBundle2, paramJSONArray), 128, null, true);
  }
  
  public static void b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(25), paramString);
    paramString = new StringBuilder();
    paramString.append(Math.max(c() - b(), 0L));
    paramString.append("");
    localHashMap.put(Integer.valueOf(26), paramString.toString());
    paramString = new StringBuilder();
    paramString.append(Math.max(a() - b(), 0L));
    paramString.append("");
    localHashMap.put(Integer.valueOf(27), paramString.toString());
    paramString = new StringBuilder();
    paramString.append(Math.max(System.currentTimeMillis() - b(), 0L));
    paramString.append("");
    localHashMap.put(Integer.valueOf(28), paramString.toString());
    try
    {
      paramString = new JSONObject(jdField_a_of_type_JavaLangString);
      localHashMap.put(Integer.valueOf(29), paramString.optString("code"));
      localHashMap.put(Integer.valueOf(30), paramString.optString("message"));
    }
    catch (Throwable paramString)
    {
      QLog.e("QQGamePub_GamePAPreloadHelper", 1, paramString, new Object[0]);
    }
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "760", "208137", "", "104705", "1", "160", localHashMap);
  }
  
  public static long c()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper
 * JD-Core Version:    0.7.0.1
 */