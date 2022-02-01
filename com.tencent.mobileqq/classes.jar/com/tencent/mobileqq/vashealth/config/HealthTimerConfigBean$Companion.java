package com.tencent.mobileqq.vashealth.config;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/HealthTimerConfigBean$Companion;", "", "()V", "DEFAULT_END_HOUR_1", "", "DEFAULT_END_HOUR_2", "DEFAULT_END_MIN_1", "DEFAULT_MAX_INCREMENT", "DEFAULT_MAX_INTERVAL", "DEFAULT_RETRY_TIMES", "DEFAULT_START_HOUR_1", "DEFAULT_START_HOUR_2", "DEFAULT_START_MIN_1", "DEFAULT_TIMER1_INCREMENT", "DEFAULT_TIMER1_INTERVAL", "DEFAULT_TIMER1_SPAN_MINUTE", "DEFAULT_TIMER2_INTERVAL", "KEY_END_HOUR_1", "", "KEY_END_HOUR_2", "KEY_END_MIN_1", "KEY_MAX_INCREMENT", "KEY_MAX_INTERVAL", "KEY_RETRY_TIMES", "KEY_START_HOUR_1", "KEY_START_HOUR_2", "KEY_START_MIN_1", "KEY_TIMER1_INCREMENT", "KEY_TIMER1_INTERVAL", "KEY_TIMER1_SPAN_MINUTE", "KEY_TIMER2_INTERVAL", "TAG", "parse", "Lcom/tencent/mobileqq/vashealth/config/HealthTimerConfigBean;", "content", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class HealthTimerConfigBean$Companion
{
  @JvmStatic
  @NotNull
  public final HealthTimerConfigBean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse from:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(' ');
      QLog.d("HealthTimerConfigBean", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject(paramString).getJSONObject("android");
      localObject = new HealthTimerConfigBean(((JSONObject)localObject).optInt("max_interval", 1800000), ((JSONObject)localObject).optInt("max_increment", 300), ((JSONObject)localObject).optInt("timer1_start_hour", 20), ((JSONObject)localObject).optInt("timer1_start_min", 20), ((JSONObject)localObject).optInt("timer1_end_hour", 21), ((JSONObject)localObject).optInt("timer1_end_min", 20), ((JSONObject)localObject).optInt("timer1_interval", 900000), ((JSONObject)localObject).optInt("timer1_increment", 200), ((JSONObject)localObject).optInt("timer1_span_minute", 20), ((JSONObject)localObject).optInt("timer2_start_hour", 23), ((JSONObject)localObject).optInt("timer2_end_hour", 7), ((JSONObject)localObject).optInt("timer2_interval", 600000), ((JSONObject)localObject).optInt("timer2_retry_times", 10), true);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error parse weather manage content:");
      localStringBuilder.append(paramString);
      QLog.e("HealthTimerConfigBean", 1, localStringBuilder.toString(), (Throwable)localJSONException);
    }
    return new HealthTimerConfigBean(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 16383, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.HealthTimerConfigBean.Companion
 * JD-Core Version:    0.7.0.1
 */