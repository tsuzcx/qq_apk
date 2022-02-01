package com.tencent.mobileqq.vashealth.config;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/StepConfigBean$Companion;", "", "()V", "TAG", "", "parse", "Lcom/tencent/mobileqq/vashealth/config/StepConfigBean;", "content", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class StepConfigBean$Companion
{
  @JvmStatic
  @NotNull
  public final StepConfigBean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse from:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(' ');
      QLog.d("StepCounterConfigBean", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject(paramString);
      localObject = new StepConfigBean(((JSONObject)localObject).getInt("stepCounterMode"), ((JSONObject)localObject).getInt("stepCadence"), ((JSONObject)localObject).getInt("activeReportInterval"), ((JSONObject)localObject).getInt("passiveReportInterval"), ((JSONObject)localObject).getInt("maxRecordDays"));
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error parse weather manage content:");
      localStringBuilder.append(paramString);
      QLog.e("StepCounterConfigBean", 1, localStringBuilder.toString(), (Throwable)localJSONException);
    }
    return new StepConfigBean(0, 0, 0, 0, 0, 31, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.StepConfigBean.Companion
 * JD-Core Version:    0.7.0.1
 */