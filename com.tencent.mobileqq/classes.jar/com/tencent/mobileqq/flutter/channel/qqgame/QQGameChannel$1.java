package com.tencent.mobileqq.flutter.channel.qqgame;

import android.os.Build.VERSION;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class QQGameChannel$1
  extends QQGameChannelHandler
{
  QQGameChannel$1(QQGameChannel paramQQGameChannel) {}
  
  protected void a(MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.QQGameChannel", 4, "call getBaseInfo");
    }
    if (paramResult != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("osVersion", Build.VERSION.RELEASE);
      localHashMap.put("qqVersion", "8.7.0.5295");
      localHashMap.put("uin", GameCenterUtil.a());
      paramResult.success(localHashMap);
    }
  }
  
  protected void a(Object paramObject, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.QQGameChannel", 4, "call report");
    }
    try
    {
      if ((paramObject instanceof JSONObject))
      {
        paramObject = new JSONObject(((JSONObject)paramObject).getString("reportInfo"));
        ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).report(paramObject, 0);
        paramResult.success(null);
        return;
      }
    }
    catch (Throwable paramObject)
    {
      paramObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqgame.QQGameChannel.1
 * JD-Core Version:    0.7.0.1
 */