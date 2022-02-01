package com.tencent.mobileqq.onlinestatus.config;

import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/config/AutoOnlineStatusParser;", "", "()V", "parse", "Lcom/tencent/mobileqq/onlinestatus/config/AutoStatusElement;", "content", "", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class AutoOnlineStatusParser
{
  public static final AutoOnlineStatusParser a = new AutoOnlineStatusParser();
  
  @JvmStatic
  @NotNull
  public static final AutoStatusElement a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    AutoStatusElement localAutoStatusElement = new AutoStatusElement((List)new ArrayList(), new OnlineStatusItem(), (List)new ArrayList(), "", new OnlineStatusItem());
    try
    {
      Object localObject4 = new JSONObject(paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[status][parser] parse json: ");
        paramString.append(localObject4);
        QLog.d("AutoOnlineStatusParser", 2, paramString.toString());
      }
      Object localObject5 = new HashMap();
      Object localObject3 = ((JSONObject)localObject4).optJSONArray("sensors");
      Object localObject1 = "type";
      int i;
      Object localObject6;
      int k;
      String str1;
      if (localObject3 != null)
      {
        j = ((JSONArray)localObject3).length();
        i = 0;
        while (i < j)
        {
          localObject6 = ((JSONArray)localObject3).getJSONObject(i);
          k = ((JSONObject)localObject6).optInt("id", -1);
          if (k > 0)
          {
            str1 = ((JSONObject)localObject6).optString("type");
            paramString = new Sensor(k, str1, ((JSONObject)localObject6).optInt("min"), ((JSONObject)localObject6).optInt("max"), ((JSONObject)localObject6).optInt("sample_count"));
            if (StringsKt.equals(str1, "step", true))
            {
              int m = ((JSONObject)localObject6).optInt("main_sensor", 1);
              localObject2 = paramString;
              ((Sensor)localObject2).f = m;
              ((Sensor)localObject2).g = ((JSONObject)localObject6).optInt("secondary_sensor", 3);
            }
            if (StringsKt.equals(str1, "gps", true))
            {
              paramString.h = ((JSONObject)localObject6).optInt("internal_update_status", Constant.c / 1000);
              paramString.i = ((JSONObject)localObject6).optInt("slow_mode_count", Constant.p);
              paramString.j = ((JSONObject)localObject6).optInt("fast_mode_count", Constant.q);
              paramString.k = ((JSONObject)localObject6).optInt("internal_slow_mode", Constant.n / 1000);
              paramString.l = ((JSONObject)localObject6).optInt("internal_fast_mode", Constant.o / 1000);
              paramString.m = ((JSONObject)localObject6).optInt("internal_exit_step", Constant.r / 1000);
              paramString.n = ((JSONObject)localObject6).optInt("internal_exit_still", Constant.s / 1000);
              paramString.o = ((JSONObject)localObject6).optInt("session_enter_accuracy", Constant.t);
            }
            if (StringsKt.equals(str1, "dist", true))
            {
              paramString.p = ((JSONObject)localObject6).optInt("dist_accuracy", Constant.G);
              paramString.q = ((JSONObject)localObject6).optInt("dist_thread_hold", Constant.H);
              paramString.r = ((JSONObject)localObject6).optInt("dist_step_thread_hold", Constant.N);
              paramString.s = ((JSONObject)localObject6).optInt("dist_enable", 1);
              paramString.t = ((JSONObject)localObject6).optInt("dist_req_time", Constant.I);
              paramString.u = ((JSONObject)localObject6).optInt("dist_acceler_enable", 1);
              paramString.w = ((JSONObject)localObject6).optInt("dist_speed_req_time", Constant.J);
              paramString.v = ((JSONObject)localObject6).optInt("dist_speed_thread_hold", Constant.K);
              paramString.x = ((JSONObject)localObject6).optInt("dist_moving_max", Constant.L);
              paramString.y = ((JSONObject)localObject6).optInt("dist_not_moving_min", Constant.M);
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[status][parser] parse sensor: ");
              ((StringBuilder)localObject2).append(paramString);
              QLog.d("AutoOnlineStatusParser", 2, ((StringBuilder)localObject2).toString());
            }
            ((Map)localObject5).put(Integer.valueOf(k), paramString);
          }
          paramString = Unit.INSTANCE;
          i += 1;
        }
        paramString = Unit.INSTANCE;
      }
      Object localObject2 = ((JSONObject)localObject4).optJSONArray("auto_status");
      long l;
      if (localObject2 != null)
      {
        i = ((JSONArray)localObject2).length();
        j = 0;
        paramString = (String)localObject1;
        localObject1 = localObject2;
        while (j < i)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(j);
          l = ((JSONObject)localObject3).optLong("id");
          localObject6 = ((JSONObject)localObject3).optString("title");
          str1 = ((JSONObject)localObject3).optString(paramString);
          Object localObject7 = ((JSONObject)localObject3).optJSONObject("category");
          localObject2 = (Category)null;
          if (localObject7 != null)
          {
            localObject2 = new Category(((JSONObject)localObject7).optInt("level", 1), ((JSONObject)localObject7).optString("name"), ((JSONObject)localObject7).optInt("internal", Constant.i / 1000), ((JSONObject)localObject7).optInt("poi_count", Constant.d), ((JSONObject)localObject7).optInt("poi_distance", Constant.g), ((JSONObject)localObject7).optInt("loc_distance", Constant.f), ((JSONObject)localObject7).optInt("loc_accuracy", Constant.e), ((JSONObject)localObject7).optDouble("valid_rate", Constant.h), ((JSONObject)localObject7).optInt("cache_size", Constant.k), ((JSONObject)localObject7).optInt("cache_distance", Constant.m));
            localObject7 = Unit.INSTANCE;
          }
          localObject7 = ((JSONObject)localObject3).optString("icon");
          String str2 = ((JSONObject)localObject3).optString("big_icon");
          k = ((JSONObject)localObject3).optInt("sensor", -1);
          String str3 = ((JSONObject)localObject3).optString("sub_title");
          boolean bool = ((JSONObject)localObject3).optBoolean("hide");
          if (k < 0) {
            localObject3 = null;
          } else {
            localObject3 = (Sensor)((HashMap)localObject5).get(Integer.valueOf(k));
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[status][parser] parse: ");
            localStringBuilder.append((String)localObject6);
            localStringBuilder.append(" sensorId: ");
            localStringBuilder.append(k);
            localStringBuilder.append(" sensor: ");
            localStringBuilder.append(localObject3);
            QLog.d("AutoOnlineStatusParser", 2, localStringBuilder.toString());
          }
          localObject2 = new AutoStatusItem(l, (String)localObject6, str1, (Category)localObject2, (String)localObject7, str2, (Sensor)localObject3, str3, bool);
          localAutoStatusElement.a.add(localObject2);
          localObject2 = Unit.INSTANCE;
          j += 1;
        }
        paramString = Unit.INSTANCE;
      }
      localObject3 = ((JSONObject)localObject4).optJSONObject("smart_status_item");
      if (localObject3 != null)
      {
        l = ((JSONObject)localObject3).optLong("id");
        paramString = ((JSONObject)localObject3).optString("title");
        localObject1 = ((JSONObject)localObject3).optString("icon");
        localObject2 = ((JSONObject)localObject3).optString("big_icon");
        localObject3 = ((JSONObject)localObject3).optString("sub_title");
        paramString = new OnlineStatusItem(l, paramString, (String)localObject1, (String)localObject2);
        paramString.i = ((String)localObject3);
        localAutoStatusElement.b = paramString;
        paramString = Unit.INSTANCE;
      }
      localObject3 = ((JSONObject)localObject4).optJSONObject("smart_status_on_earth");
      if (localObject3 != null)
      {
        l = ((JSONObject)localObject3).optLong("id");
        paramString = ((JSONObject)localObject3).optString("title");
        localObject1 = ((JSONObject)localObject3).optString("icon");
        localObject2 = ((JSONObject)localObject3).optString("big_icon");
        localObject3 = ((JSONObject)localObject3).optString("sub_title");
        paramString = new OnlineStatusItem(l, paramString, (String)localObject1, (String)localObject2);
        paramString.i = ((String)localObject3);
        localAutoStatusElement.e = paramString;
        paramString = Unit.INSTANCE;
      }
      paramString = ((JSONObject)localObject4).optString("weather_jump_schema", "");
      if (paramString != null)
      {
        localAutoStatusElement.c = paramString;
        paramString = Unit.INSTANCE;
      }
      localObject1 = ((JSONObject)localObject4).optJSONArray("weather_url");
      if (localObject1 != null) {
        i = ((JSONArray)localObject1).length();
      } else {
        i = 0;
      }
      int j = 0;
      while (j < i)
      {
        if (localObject1 != null) {
          paramString = ((JSONArray)localObject1).getJSONObject(j);
        } else {
          paramString = null;
        }
        if (paramString != null)
        {
          localObject2 = paramString.optString("weather_id", "");
          localObject3 = paramString.optString("weather_small_url", "");
          localObject4 = paramString.optString("weather_big_url", "");
          localObject5 = paramString.optString("weather_aio_url", "");
          paramString = new WeatherUrl((String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, paramString.optString("big_url", (String)localObject5));
          localAutoStatusElement.d.add(paramString);
          paramString = Unit.INSTANCE;
        }
        j += 1;
      }
      return localAutoStatusElement;
    }
    catch (JSONException paramString) {}
    return localAutoStatusElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.AutoOnlineStatusParser
 * JD-Core Version:    0.7.0.1
 */