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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/config/AutoOnlineStatusParser;", "", "()V", "parse", "Lcom/tencent/mobileqq/onlinestatus/config/AutoStatusElement;", "content", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AutoOnlineStatusParser
{
  public static final AutoOnlineStatusParser a = new AutoOnlineStatusParser();
  
  @JvmStatic
  @NotNull
  public static final AutoStatusElement a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    localAutoStatusElement = new AutoStatusElement((List)new ArrayList(), new OnlineStatusItem(), (List)new ArrayList(), "", new OnlineStatusItem());
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("AutoOnlineStatusParser", 2, "[status][parser] parse json: " + localJSONObject);
      }
      Object localObject2 = new HashMap();
      paramString = localJSONObject.optJSONArray("sensors");
      int j;
      int i;
      int k;
      Object localObject4;
      if (paramString != null)
      {
        j = paramString.length();
        i = 0;
        while (i < j)
        {
          localObject1 = paramString.getJSONObject(i);
          k = ((JSONObject)localObject1).optInt("id", -1);
          if (k > 0)
          {
            localObject3 = ((JSONObject)localObject1).optString("type");
            localObject4 = new Sensor(k, (String)localObject3, ((JSONObject)localObject1).optInt("min"), ((JSONObject)localObject1).optInt("max"), ((JSONObject)localObject1).optInt("sample_count"));
            if (StringsKt.equals((String)localObject3, "step", true))
            {
              ((Sensor)localObject4).e = ((JSONObject)localObject1).optInt("main_sensor", 1);
              ((Sensor)localObject4).f = ((JSONObject)localObject1).optInt("secondary_sensor", 3);
            }
            if (StringsKt.equals((String)localObject3, "gps", true))
            {
              ((Sensor)localObject4).g = ((JSONObject)localObject1).optInt("internal_update_status", Constant.c / 1000);
              ((Sensor)localObject4).h = ((JSONObject)localObject1).optInt("slow_mode_count", Constant.o);
              ((Sensor)localObject4).i = ((JSONObject)localObject1).optInt("fast_mode_count", Constant.p);
              ((Sensor)localObject4).j = ((JSONObject)localObject1).optInt("internal_slow_mode", Constant.m / 1000);
              ((Sensor)localObject4).k = ((JSONObject)localObject1).optInt("internal_fast_mode", Constant.n / 1000);
              ((Sensor)localObject4).l = ((JSONObject)localObject1).optInt("internal_exit_step", Constant.q / 1000);
              ((Sensor)localObject4).m = ((JSONObject)localObject1).optInt("internal_exit_still", Constant.r / 1000);
              ((Sensor)localObject4).n = ((JSONObject)localObject1).optInt("session_enter_accuracy", Constant.s);
            }
            if (StringsKt.equals((String)localObject3, "dist", true))
            {
              ((Sensor)localObject4).o = ((JSONObject)localObject1).optInt("dist_accuracy", Constant.F);
              ((Sensor)localObject4).p = ((JSONObject)localObject1).optInt("dist_thread_hold", Constant.G);
              ((Sensor)localObject4).q = ((JSONObject)localObject1).optInt("dist_step_thread_hold", Constant.M);
              ((Sensor)localObject4).r = ((JSONObject)localObject1).optInt("dist_enable", 1);
              ((Sensor)localObject4).s = ((JSONObject)localObject1).optInt("dist_req_time", Constant.H);
              ((Sensor)localObject4).t = ((JSONObject)localObject1).optInt("dist_acceler_enable", 1);
              ((Sensor)localObject4).v = ((JSONObject)localObject1).optInt("dist_speed_req_time", Constant.I);
              ((Sensor)localObject4).u = ((JSONObject)localObject1).optInt("dist_speed_thread_hold", Constant.J);
              ((Sensor)localObject4).w = ((JSONObject)localObject1).optInt("dist_moving_max", Constant.K);
              ((Sensor)localObject4).x = ((JSONObject)localObject1).optInt("dist_not_moving_min", Constant.L);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AutoOnlineStatusParser", 2, "[status][parser] parse sensor: " + localObject4);
            }
            ((Map)localObject2).put(Integer.valueOf(k), localObject4);
          }
          localObject1 = Unit.INSTANCE;
          i += 1;
        }
        paramString = Unit.INSTANCE;
      }
      Object localObject3 = localJSONObject.optJSONArray("auto_status");
      long l;
      if (localObject3 != null)
      {
        j = ((JSONArray)localObject3).length();
        i = 0;
        if (i < j)
        {
          localObject1 = ((JSONArray)localObject3).getJSONObject(i);
          l = ((JSONObject)localObject1).optLong("id");
          localObject4 = ((JSONObject)localObject1).optString("title");
          String str1 = ((JSONObject)localObject1).optString("type");
          Object localObject5 = ((JSONObject)localObject1).optJSONObject("category");
          paramString = (Category)null;
          label808:
          String str2;
          boolean bool;
          if (localObject5 != null)
          {
            paramString = new Category(((JSONObject)localObject5).optInt("level", 1), ((JSONObject)localObject5).optString("name"), ((JSONObject)localObject5).optInt("internal", Constant.h / 1000), ((JSONObject)localObject5).optInt("poi_count", Constant.d), ((JSONObject)localObject5).optInt("poi_distance", Constant.g), ((JSONObject)localObject5).optInt("loc_distance", Constant.f), ((JSONObject)localObject5).optInt("loc_accuracy", Constant.e), ((JSONObject)localObject5).optDouble("valid_rate", Constant.a), ((JSONObject)localObject5).optInt("cache_size", Constant.j), ((JSONObject)localObject5).optInt("cache_distance", Constant.l));
            localObject5 = Unit.INSTANCE;
            localObject5 = ((JSONObject)localObject1).optString("icon");
            k = ((JSONObject)localObject1).optInt("sensor", -1);
            str2 = ((JSONObject)localObject1).optString("sub_title");
            bool = ((JSONObject)localObject1).optBoolean("hide");
            if (k >= 0) {
              break label958;
            }
          }
          label958:
          for (localObject1 = null;; localObject1 = (Sensor)((HashMap)localObject2).get(Integer.valueOf(k)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AutoOnlineStatusParser", 2, "[status][parser] parse: " + (String)localObject4 + " sensorId: " + k + " sensor: " + localObject1);
            }
            paramString = new AutoStatusItem(l, (String)localObject4, str1, paramString, (String)localObject5, (Sensor)localObject1, str2, bool);
            localAutoStatusElement.jdField_a_of_type_JavaUtilList.add(paramString);
            paramString = Unit.INSTANCE;
            i += 1;
            break;
            break label808;
          }
        }
        paramString = Unit.INSTANCE;
      }
      localObject2 = localJSONObject.optJSONObject("smart_status_item");
      if (localObject2 != null)
      {
        l = ((JSONObject)localObject2).optLong("id");
        paramString = ((JSONObject)localObject2).optString("title");
        localObject1 = ((JSONObject)localObject2).optString("icon");
        localObject2 = ((JSONObject)localObject2).optString("sub_title");
        paramString = new OnlineStatusItem(l, paramString, (String)localObject1);
        paramString.d = ((String)localObject2);
        localAutoStatusElement.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = paramString;
        paramString = Unit.INSTANCE;
      }
      localObject2 = localJSONObject.optJSONObject("smart_status_on_earth");
      if (localObject2 != null)
      {
        l = ((JSONObject)localObject2).optLong("id");
        paramString = ((JSONObject)localObject2).optString("title");
        localObject1 = ((JSONObject)localObject2).optString("icon");
        localObject2 = ((JSONObject)localObject2).optString("sub_title");
        paramString = new OnlineStatusItem(l, paramString, (String)localObject1);
        paramString.d = ((String)localObject2);
        localAutoStatusElement.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = paramString;
        paramString = Unit.INSTANCE;
      }
      paramString = localJSONObject.optString("weather_jump_schema", "");
      if (paramString != null)
      {
        localAutoStatusElement.jdField_a_of_type_JavaLangString = paramString;
        paramString = Unit.INSTANCE;
      }
      Object localObject1 = localJSONObject.optJSONArray("weather_url");
      if (localObject1 != null)
      {
        i = ((JSONArray)localObject1).length();
        j = 0;
        label1191:
        if (j >= i) {
          break label1290;
        }
        if (localObject1 == null) {
          break label1284;
        }
      }
      label1284:
      for (paramString = ((JSONArray)localObject1).getJSONObject(j);; paramString = null)
      {
        if (paramString != null)
        {
          paramString = new WeatherUrl(paramString.optString("weather_id", ""), paramString.optString("weather_small_url", ""), paramString.optString("weather_big_url", ""), paramString.optString("weather_aio_url", ""));
          localAutoStatusElement.jdField_b_of_type_JavaUtilList.add(paramString);
          paramString = Unit.INSTANCE;
        }
        j += 1;
        break label1191;
        i = 0;
        break;
      }
      return localAutoStatusElement;
    }
    catch (JSONException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.AutoOnlineStatusParser
 * JD-Core Version:    0.7.0.1
 */