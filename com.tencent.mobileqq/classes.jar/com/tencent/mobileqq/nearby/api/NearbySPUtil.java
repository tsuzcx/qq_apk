package com.tencent.mobileqq.nearby.api;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbySPUtil
{
  public static SharedPreferences a(String paramString1, String paramString2, int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), paramInt);
  }
  
  public static Object a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    if ((paramSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramObject == null) {
        return paramObject;
      }
      Object localObject2;
      try
      {
        Object localObject1;
        if (paramObject.getClass() == Boolean.class) {
          localObject1 = Boolean.valueOf(paramSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
        } else if (paramObject.getClass() == Integer.class) {
          localObject1 = Integer.valueOf(paramSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue()));
        } else if (paramObject.getClass() == Long.class) {
          localObject1 = Long.valueOf(paramSharedPreferences.getLong(paramString, ((Long)paramObject).longValue()));
        } else if (paramObject.getClass() == Float.class) {
          localObject1 = Float.valueOf(paramSharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue()));
        } else if (paramObject.getClass() == String.class) {
          localObject1 = paramSharedPreferences.getString(paramString, (String)paramObject);
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("getValue", new Object[] { localThrowable });
        }
        localObject2 = paramObject;
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("getValue", new Object[] { paramSharedPreferences, paramString, paramObject, localObject2, paramObject.getClass() });
      }
      return localObject2;
    }
    return paramObject;
  }
  
  public static Object a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2))) && (!TextUtils.isEmpty(paramString3)) && (paramObject != null))
    {
      if (!a(paramInt)) {
        return paramObject;
      }
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      try
      {
        paramString2 = a(a(paramString1, str, paramInt), paramString3, paramObject);
      }
      catch (Throwable paramString2)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("getValue", new Object[] { paramString2 });
        }
        paramString2 = paramObject;
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("getValue", new Object[] { str, paramString1, paramString3, paramObject, paramString2, paramObject.getClass() });
      }
      return paramString2;
    }
    return paramObject;
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramObject;
    }
    return a(paramString1, "NEARBY_FLAG_SP", 4, paramString2, paramObject);
  }
  
  public static String a()
  {
    return a("nearby_url_params", BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getString("nearby_tab_url_params", "");
  }
  
  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONObject localJSONObject = paramJSONObject1;
    if (paramJSONObject1 == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject1 = paramJSONObject2;
    if (paramJSONObject2 == null) {
      paramJSONObject1 = new JSONObject();
    }
    paramJSONObject2 = paramJSONObject1.keys();
    while (paramJSONObject2.hasNext())
    {
      String str1 = (String)paramJSONObject2.next();
      String str2 = paramJSONObject1.optString(str1);
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals("null"))) {
        try
        {
          localJSONObject.put(str1, str2);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      } else {
        localJSONObject.remove(localJSONException);
      }
    }
    return localJSONObject;
  }
  
  public static void a(String paramString, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("lat", paramSosoLbsInfo.mLocation.mLat02);
        localJSONObject.put("lon", paramSosoLbsInfo.mLocation.mLon02);
        b(paramString, "key_nearby_loc", localJSONObject.toString());
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          paramSosoLbsInfo = new StringBuilder();
          paramSosoLbsInfo.append("setNearbyLastLocation exp:");
          paramSosoLbsInfo.append(paramString.toString());
          QLog.e("NearbySPUtil", 2, paramSosoLbsInfo.toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("setNearbyLastLocation, null return, sosoInfo=");
      paramString.append(paramSosoLbsInfo);
      QLog.e("NearbySPUtil", 2, paramString.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 4);
  }
  
  public static boolean a(String paramString)
  {
    return ((Boolean)a(paramString, BaseApplicationImpl.getApplication().getResources().getString(2131892695), Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean a(String paramString, long paramLong, int paramInt)
  {
    boolean bool;
    try
    {
      bool = a("NEARBY_FLAG_SP", paramString, 4).edit().putLong("vote_count", paramLong).putInt("vote_increment", paramInt).commit();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("setVoteInfo", new Object[] { localThrowable });
      }
      bool = false;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("setVoteInfo", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return a(paramString1, "NEARBY_FLAG_SP", 4, paramString2);
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2))) && (!TextUtils.isEmpty(paramString3)))
    {
      if (!a(paramInt)) {
        return false;
      }
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      boolean bool;
      try
      {
        bool = a(paramString1, str, paramInt).contains(paramString3);
      }
      catch (Throwable paramString2)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("contains", new Object[] { paramString2 });
        }
        bool = false;
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("contains", new Object[] { str, paramString1, paramString3 });
      }
      return bool;
    }
    return false;
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return b(paramString, BaseApplicationImpl.getApplication().getResources().getString(2131892695), Boolean.valueOf(paramBoolean));
  }
  
  public static int b(String paramString1, String paramString2)
  {
    return ((Integer)a(paramString1, "nearby_event_file", 4, paramString2, Integer.valueOf(0))).intValue();
  }
  
  public static String b()
  {
    return a("sp_nearby_live_tab_url_params", BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getString("nearby_live_tab_url_params", "");
  }
  
  public static boolean b(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    if ((paramSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramObject == null) {
        return false;
      }
      boolean bool;
      try
      {
        SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
        if (paramObject.getClass() == Boolean.class) {
          localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        } else if (paramObject.getClass() == Integer.class) {
          localEditor.putInt(paramString, ((Integer)paramObject).intValue());
        } else if (paramObject.getClass() == Long.class) {
          localEditor.putLong(paramString, ((Long)paramObject).longValue());
        } else if (paramObject.getClass() == Float.class) {
          localEditor.putFloat(paramString, ((Float)paramObject).floatValue());
        } else if (paramObject.getClass() == String.class) {
          localEditor.putString(paramString, (String)paramObject);
        }
        bool = localEditor.commit();
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("setValue", new Object[] { localThrowable });
        }
        bool = false;
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("setValue", new Object[] { paramSharedPreferences, paramString, paramObject, Boolean.valueOf(bool), paramObject.getClass() });
      }
      return bool;
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool;
    try
    {
      bool = ((Boolean)a(paramString, BaseApplicationImpl.getApplication().getResources().getString(2131892703), Boolean.valueOf(false))).booleanValue();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("getLocVisiblityForPeople", new Object[] { localThrowable });
      }
      bool = false;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("getLocVisiblityForPeople", new Object[] { paramString, Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static boolean b(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2))) && (!TextUtils.isEmpty(paramString3)) && (paramObject != null))
    {
      if (!a(paramInt)) {
        return false;
      }
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      boolean bool;
      try
      {
        bool = b(a(paramString1, str, paramInt), paramString3, paramObject);
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("setValue", new Object[] { paramString1 });
        }
        bool = false;
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("setValue", new Object[] { str, paramString3, paramObject, Boolean.valueOf(bool), paramObject.getClass() });
      }
      return bool;
    }
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return b(paramString1, "NEARBY_FLAG_SP", 4, paramString2, paramObject);
  }
  
  public static boolean b(String paramString, boolean paramBoolean)
  {
    boolean bool;
    try
    {
      String str = BaseApplicationImpl.getApplication().getResources().getString(2131892703);
      SharedPreferences.Editor localEditor = a("NEARBY_FLAG_SP", paramString, 4).edit();
      localEditor.putBoolean(str, paramBoolean);
      if (!paramBoolean) {
        localEditor.putLong("nearby_enter_time", 0L).commit();
      }
      bool = localEditor.commit();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("setVisibilityForPeople", new Object[] { localThrowable });
      }
      bool = false;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("setVisibilityForPeople", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static void c(String paramString, boolean paramBoolean)
  {
    b(paramString, "key_notify_switch_state", Boolean.valueOf(paramBoolean));
  }
  
  public static Object[] c(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    int i;
    try
    {
      SharedPreferences localSharedPreferences = a("NEARBY_FLAG_SP", paramString, 4);
      l1 = l2;
      l2 = localSharedPreferences.getLong("vote_count", Long.valueOf(0L).longValue());
      l1 = l2;
      i = localSharedPreferences.getInt("vote_increment", Integer.valueOf(0).intValue());
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("getVoteInfo", new Object[] { localThrowable });
      }
      i = 0;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("getVoteInfo", new Object[] { paramString, Long.valueOf(l1), Integer.valueOf(i) });
    }
    return new Object[] { Long.valueOf(l1), Integer.valueOf(i) };
  }
  
  public static boolean d(String paramString)
  {
    return ((Boolean)a(paramString, "key_notify_switch_state", Boolean.valueOf(true))).booleanValue();
  }
  
  public static boolean e(String paramString)
  {
    return ((Boolean)a(paramString, "dating_recv_msg", Boolean.valueOf(true))).booleanValue();
  }
  
  public static void f(String paramString)
  {
    b(paramString, "key_nearby_red_dot_corner_text", "");
    b(paramString, "key_nearby_red_dot_assist_text", "");
  }
  
  public static SosoLbsInfo g(String paramString)
  {
    try
    {
      paramString = new JSONObject((String)a(paramString, "key_nearby_loc", ""));
      if ((paramString.has("lat")) && (paramString.has("lon")))
      {
        localObject = new SosoLbsInfo();
        ((SosoLbsInfo)localObject).mLocation = new SosoLocation();
        ((SosoLbsInfo)localObject).mLocation.mLat02 = paramString.getDouble("lat");
        ((SosoLbsInfo)localObject).mLocation.mLon02 = paramString.getDouble("lon");
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getNearbyLastLocation exp:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("NearbySPUtil", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static boolean h(String paramString)
  {
    boolean bool1;
    try
    {
      paramString = a("nearby_process_preload_file", paramString, 4);
      int i = paramString.getInt("key_preload_fail_count", 0);
      int j = paramString.getInt("key_preload_unhit_count", 0);
      if ((i < 2) && (j < 2)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      try
      {
        if (!QLog.isColorLevel()) {
          break label97;
        }
        NearbyUtils.a("checkPreload", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        return bool1;
      }
      catch (Throwable paramString) {}
      paramString.printStackTrace();
    }
    catch (Throwable paramString)
    {
      bool1 = true;
    }
    boolean bool2 = bool1;
    label97:
    return bool2;
  }
  
  public static void i(String paramString)
  {
    try
    {
      paramString = a("nearby_process_preload_file", paramString, 4);
      int i = paramString.getInt("key_preload_fail_count", 0) + 1;
      paramString.edit().putInt("key_preload_fail_count", i).commit();
      if (QLog.isColorLevel())
      {
        NearbyUtils.a("preloadNearbyprocessStart", new Object[] { "key_preload_fail_count", Integer.valueOf(i) });
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void j(String paramString)
  {
    try
    {
      paramString = a("nearby_process_preload_file", paramString, 4);
      int i = paramString.getInt("key_preload_unhit_count", 0) + 1;
      paramString.edit().putInt("key_preload_fail_count", 0).putInt("key_preload_unhit_count", i).commit();
      if (QLog.isColorLevel())
      {
        NearbyUtils.a("preloadNearbyProcessSuc", new Object[] { "key_preload_unhit_count", Integer.valueOf(i) });
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void k(String paramString)
  {
    try
    {
      a("nearby_process_preload_file", paramString, 4).edit().putInt("key_preload_fail_count", 0).putInt("key_preload_unhit_count", 0).commit();
      if (QLog.isColorLevel())
      {
        NearbyUtils.a("enterNearbyProcess", new Object[0]);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean l(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool1) {
      return false;
    }
    boolean bool2 = ((Boolean)a(paramString, "nearby_need_show_guide", localBoolean)).booleanValue();
    boolean bool3 = ((Boolean)a(paramString, "sp_key_user_skip_guide", localBoolean)).booleanValue();
    if ((true == bool2) && (!bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("isNeedNearbyShowGuide", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    }
    return bool1;
  }
  
  public static void m(String paramString)
  {
    SharedPreferences localSharedPreferences = a("nearby_url_params", BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
    if (!TextUtils.isEmpty(paramString))
    {
      localSharedPreferences.edit().putString("nearby_tab_url_params", paramString).apply();
      if (QLog.isColorLevel()) {
        NearbyUtils.a("saveNearbyTabUrlParams", new Object[] { paramString });
      }
    }
  }
  
  public static void n(String paramString)
  {
    SharedPreferences localSharedPreferences = a("sp_nearby_live_tab_url_params", BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
    if (!TextUtils.isEmpty(paramString))
    {
      localSharedPreferences.edit().putString("nearby_live_tab_url_params", paramString).apply();
      if (QLog.isColorLevel()) {
        NearbyUtils.a("saveLiveTabWebViewUrlParam", new Object[] { paramString });
      }
    }
  }
  
  public static String o(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramString.optString(str1);
        localStringBuilder.append("&");
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        localStringBuilder.append(str2);
      }
      return localStringBuilder.toString();
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbySPUtil
 * JD-Core Version:    0.7.0.1
 */