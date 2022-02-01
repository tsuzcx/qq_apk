package com.tencent.mobileqq.kandian.repo.aladdin.config;

import android.os.Bundle;
import com.tencent.aladdin.config.network.AladdinRequestHandler;
import com.tencent.aladdin.config.network.AladdinResponseHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class QQAladdinRequestHandler
  extends AladdinRequestHandler
{
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  private static void b(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    int i = paramBundle.getInt("key_ret_code", 0);
    localHashMap.put("param_OpCode", String.valueOf(paramBundle.getInt("key_rsp_type", 0)));
    localHashMap.put("param_FailCode", String.valueOf(i));
    long l1 = paramBundle.getLong("key_config_count");
    long l2 = paramBundle.getLong("key_failed_count");
    localHashMap.put("param_ConfigCount", String.valueOf(l1));
    localHashMap.put("param_FailCount", String.valueOf(l2));
    l1 = paramBundle.getLong("key_response_timestamp", 0L) - paramBundle.getLong("key_request_timestamp", 0L);
    localHashMap.put("param_CostTime", String.valueOf(l1));
    paramBundle = StatisticCollector.getInstance(RIJQQAppInterfaceUtil.e().getApplication());
    String str = RIJQQAppInterfaceUtil.d();
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramBundle.collectPerformance(str, "actKanDianAladdinResult", bool, l1, 0L, localHashMap, null, false);
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
  {
    long l = paramArrayOfByte.length;
    int i = (int)l;
    byte[] arrayOfByte = new byte[i + 4];
    PkgTools.dWord2Byte(arrayOfByte, 0, l + 4L);
    PkgTools.copyData(arrayOfByte, 4, paramArrayOfByte, i);
    return arrayOfByte;
  }
  
  protected void onSend(byte[] paramArrayOfByte, Bundle paramBundle, AladdinResponseHandler paramAladdinResponseHandler)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), QQAladdinRequestHandler.AladdinConfigServlet.class);
    localNewIntent.putExtra("key_body_bytes", paramArrayOfByte);
    localNewIntent.putExtra("key_extra_info", paramBundle);
    localNewIntent.putExtra("key_response_handler", paramAladdinResponseHandler);
    localNewIntent.putParcelableArrayListExtra("key_aladdin_listeners", AladdinListenerUtils.a);
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinRequestHandler
 * JD-Core Version:    0.7.0.1
 */