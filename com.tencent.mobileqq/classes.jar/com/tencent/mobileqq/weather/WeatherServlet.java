package com.tencent.mobileqq.weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.jungle.weather.proto.WeatherReportInfo.Area;
import com.tencent.jungle.weather.proto.WeatherReportInfo.GetWeatherByLbsReq;
import com.tencent.jungle.weather.proto.WeatherReportInfo.GetWeatherByLbsRsp;
import com.tencent.jungle.weather.proto.WeatherReportInfo.PbRspMsgHead;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weather.api.impl.WeatherRuntimeServiceImpl;
import com.tencent.mobileqq.weather.proto.WeatherPush.PushRequest;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class WeatherServlet
  extends MSFServlet
{
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, AppActivity paramAppActivity)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, WeatherServlet.class);
    localNewIntent.putExtra("cmd", "QQWeatherReport.getWeatherByLbs");
    localNewIntent.putExtra("req_type", 8888);
    localNewIntent.putExtra("latitide", paramInt1);
    localNewIntent.putExtra("longtitude", paramInt2);
    a(paramAppInterface, localNewIntent, paramAppActivity);
  }
  
  public static void a(AppInterface paramAppInterface, AppActivity paramAppActivity)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, WeatherServlet.class);
    localNewIntent.putExtra("cmd", "QQWeatherReport.getWeatherByLbs");
    localNewIntent.putExtra("req_type", 6666);
    localNewIntent.putExtra("uin", Long.parseLong(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin()));
    a(paramAppInterface, localNewIntent, paramAppActivity);
  }
  
  private static void a(AppInterface paramAppInterface, NewIntent paramNewIntent, AppActivity paramAppActivity)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("public_account_weather", 0);
        long l1 = localSharedPreferences.getLong("drawer_last_location_auth_dialog_time", 0L);
        long l2 = System.currentTimeMillis();
        if (l2 - l1 > 172800000L)
        {
          localSharedPreferences.edit().putLong("drawer_last_location_auth_dialog_time", l2).apply();
          b(paramAppInterface, paramNewIntent, paramAppActivity);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WeatherServlet", 1, "without 24 hour from last location auth dialog");
        }
        paramNewIntent.putExtra("adcode", 0);
        paramAppInterface.startServlet(paramNewIntent);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WeatherServlet", 1, "location permitted above android M");
      }
      b(paramAppInterface, paramNewIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WeatherServlet", 1, "direct locate in system below android M");
    }
    b(paramAppInterface, paramNewIntent);
  }
  
  public static void a(AppActivity paramAppActivity, String paramString, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, WeatherServlet.class);
    localNewIntent.putExtra("cmd", "trpc.qqweather.trpc_trpc_proxy.trpc_trpc_proxy.DoPush");
    localNewIntent.putExtra("req_type", 9999);
    localNewIntent.putExtra("uin", Long.parseLong(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin()));
    try
    {
      i = Integer.parseInt(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label64:
      StringBuilder localStringBuilder;
      break label64;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fail to convert adCode ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" to integer");
    QLog.e("WeatherServlet", 1, localStringBuilder.toString());
    i = 0;
    localNewIntent.putExtra("adcode", i);
    localNewIntent.putExtra("hide_red_point", paramBoolean);
    paramAppActivity.getAppRuntime().startServlet(localNewIntent);
  }
  
  private static void b(AppInterface paramAppInterface, NewIntent paramNewIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherServlet", 2, "startLocation onLocationStart");
    }
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new WeatherServlet.2("qq_weather", false, paramNewIntent, paramAppInterface));
  }
  
  private static void b(AppInterface paramAppInterface, NewIntent paramNewIntent, AppActivity paramAppActivity)
  {
    paramAppInterface = new WeatherServlet.1(paramAppActivity, paramAppInterface, paramNewIntent);
    paramAppInterface = DialogUtil.a(paramAppActivity, 230, paramAppActivity.getString(2131720361), paramAppActivity.getString(2131720360), 2131720359, 2131720358, paramAppInterface, paramAppInterface);
    if (paramAppInterface != null) {
      paramAppInterface.show();
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (!"QQWeatherReport.getWeatherByLbs".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    boolean bool2 = paramFromServiceMsg.isSuccess();
    int i = paramIntent.getIntExtra("req_type", 0);
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramIntent.getExtras());
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WeatherServlet onReceive isSucess1:");
      ((StringBuilder)localObject).append(bool2);
      QLog.d("WeatherServlet", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = bool2;
    if (bool2) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject);
        paramFromServiceMsg = new WeatherReportInfo.GetWeatherByLbsRsp();
        paramFromServiceMsg.mergeFrom((byte[])localObject);
        if (paramFromServiceMsg.pbRspMsgHead.uint32_result.get() != 0) {
          break label411;
        }
        bool1 = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("WeatherServlet onReceive isSucess2:");
          ((StringBuilder)localObject).append(bool1);
          QLog.d("WeatherServlet", 2, ((StringBuilder)localObject).toString());
        }
        if (bool1)
        {
          localBundle.putString("KEY_TEMPER", paramFromServiceMsg.temper.get());
          localBundle.putString("o_wea_code", paramFromServiceMsg.o_wea_code.get());
          localBundle.putString("wea_desc", paramFromServiceMsg.wea_desc.get());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramFromServiceMsg.area.city.get());
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramFromServiceMsg.area.area_name.get());
          localBundle.putString("area_info", ((StringBuilder)localObject).toString());
          localBundle.putInt("adcode", paramFromServiceMsg.area.area_id.get());
          localBundle.putInt("show_flag", paramFromServiceMsg.show_flag.get());
        }
        else
        {
          localBundle.putInt("uint32_result", paramFromServiceMsg.pbRspMsgHead.uint32_result.get());
          localBundle.putString("string_err_msg", paramFromServiceMsg.pbRspMsgHead.string_err_msg.get());
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        bool1 = false;
      }
      notifyObserver(paramIntent, i, bool1, localBundle, WeatherRuntimeServiceImpl.class);
      return;
      label411:
      bool1 = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("req_type", 0);
    String str = paramIntent.getStringExtra("cmd");
    int j = paramIntent.getIntExtra("adcode", 0);
    if (i != 6666)
    {
      if (i != 8888)
      {
        if (i == 9999)
        {
          localObject = new WeatherPush.PushRequest();
          ((WeatherPush.PushRequest)localObject).adcode.set(paramIntent.getIntExtra("adcode", 0));
          ((WeatherPush.PushRequest)localObject).hideRedPoint.set(paramIntent.getBooleanExtra("hide_red_point", false));
          ((WeatherPush.PushRequest)localObject).uin.set(paramIntent.getLongExtra("uin", 0L));
          paramIntent = ((WeatherPush.PushRequest)localObject).toByteArray();
        }
        else
        {
          paramIntent = new StringBuilder();
          paramIntent.append("Weatherservlet unknow req_type: ");
          paramIntent.append(i);
          throw new RuntimeException(paramIntent.toString());
        }
      }
      else
      {
        localObject = new WeatherReportInfo.GetWeatherByLbsReq();
        ((WeatherReportInfo.GetWeatherByLbsReq)localObject).lat.set(paramIntent.getIntExtra("latitide", 0));
        ((WeatherReportInfo.GetWeatherByLbsReq)localObject).lng.set(paramIntent.getIntExtra("longtitude", 0));
        ((WeatherReportInfo.GetWeatherByLbsReq)localObject).adcode_from_mapsdk.set(j);
        paramIntent = ((WeatherReportInfo.GetWeatherByLbsReq)localObject).toByteArray();
      }
    }
    else
    {
      localObject = new WeatherReportInfo.GetWeatherByLbsReq();
      ((WeatherReportInfo.GetWeatherByLbsReq)localObject).uin.set(paramIntent.getLongExtra("uin", 0L));
      ((WeatherReportInfo.GetWeatherByLbsReq)localObject).adcode_from_mapsdk.set(j);
      paramIntent = ((WeatherReportInfo.GetWeatherByLbsReq)localObject).toByteArray();
    }
    Object localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4).put(paramIntent);
    paramPacket.setSSOCommand(str);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.WeatherServlet
 * JD-Core Version:    0.7.0.1
 */