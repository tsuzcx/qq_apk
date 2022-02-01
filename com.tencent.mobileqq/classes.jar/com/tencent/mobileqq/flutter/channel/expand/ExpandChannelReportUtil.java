package com.tencent.mobileqq.flutter.channel.expand;

import android.os.Bundle;
import com.tencent.biz.expand.api.GenericSerializable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.HashMap;
import java.util.Map;

public class ExpandChannelReportUtil
{
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel_name", paramString1);
    localHashMap.put("function", paramString2);
    localHashMap.put("type", paramString3);
    localHashMap.put("action", "call");
    a("expand_quality#succ_rate#channel", localHashMap);
  }
  
  public static void a(String paramString, Map<String, String> paramMap)
  {
    Bundle localBundle = new Bundle();
    GenericSerializable localGenericSerializable = new GenericSerializable();
    localGenericSerializable.set(paramMap);
    localBundle.putSerializable("params", localGenericSerializable);
    localBundle.putString("event", paramString);
    QIPCClientHelper.getInstance().getClient().callServer("ExpandFlutterIPCServer", "notifyDoReport", localBundle, new ExpandChannelReportUtil.1());
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel_name", paramString1);
    localHashMap.put("function", paramString2);
    localHashMap.put("type", paramString3);
    localHashMap.put("action", "response");
    if (QLog.isDebugVersion())
    {
      paramString1 = "0";
      localHashMap.put("is_release", paramString1);
      if (!QLog.isDebugVersion()) {
        break label88;
      }
    }
    label88:
    for (paramString1 = "0";; paramString1 = "1")
    {
      localHashMap.put("server_evn", paramString1);
      a("expand_quality#succ_rate#channel", localHashMap);
      return;
      paramString1 = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandChannelReportUtil
 * JD-Core Version:    0.7.0.1
 */