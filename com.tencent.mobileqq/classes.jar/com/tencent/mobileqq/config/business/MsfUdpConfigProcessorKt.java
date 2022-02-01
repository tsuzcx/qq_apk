package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ID", "", "TAG", "", "UDP_MAX_RETRY_COUNT_DEFAULT", "UDP_SEND_TIMEOUT_DEFAULT", "parse", "Lcom/tencent/mobileqq/config/business/MsfUdpConfigBean;", "content", "toJson", "bean", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class MsfUdpConfigProcessorKt
{
  @NotNull
  public static final String a(@Nullable MsfUdpConfigBean paramMsfUdpConfigBean)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMsfUdpConfigBean != null) {
      try
      {
        localJSONObject.put("udpSendSwitchOn", paramMsfUdpConfigBean.a());
        localJSONObject.put("udpMaxRetryCount", paramMsfUdpConfigBean.b());
        localJSONObject.put("udpSendTimeout", paramMsfUdpConfigBean.c());
      }
      catch (JSONException paramMsfUdpConfigBean)
      {
        QLog.e("MsfUdpConfigProcessor", 1, "[toJson] err: ", (Throwable)paramMsfUdpConfigBean);
      }
    }
    paramMsfUdpConfigBean = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramMsfUdpConfigBean, "jsonObject.toString()");
    return paramMsfUdpConfigBean;
  }
  
  private static final MsfUdpConfigBean b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      MsfUdpConfigBean localMsfUdpConfigBean = new MsfUdpConfigBean(false, 0, 0, 7, null);
      paramString = new JSONObject(paramString);
      localMsfUdpConfigBean.a(paramString.optBoolean("udpSendSwitchOn", false));
      localMsfUdpConfigBean.a(paramString.optInt("udpMaxRetryCount", 12));
      localMsfUdpConfigBean.b(paramString.optInt("udpSendTimeout", 3));
      return localMsfUdpConfigBean;
    }
    catch (Exception paramString)
    {
      QLog.e("MSFConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MsfUdpConfigProcessorKt
 * JD-Core Version:    0.7.0.1
 */