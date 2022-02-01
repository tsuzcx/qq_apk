package com.tencent.mobileqq.onlinestatus.weather;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xca6.WeatherReportStore.TipsItem;
import tencent.im.oidb.cmd0xca6.WeatherReportStore.TipsList;
import tencent.im.oidb.cmd0xca6.WeatherReportStore.WeatherInfo;
import tencent.im.oidb.cmd0xca6.oidb_0xca6.ReqBody;
import tencent.im.oidb.cmd0xca6.oidb_0xca6.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class OnlineStatusWeatherServlet
  extends MSFServlet
{
  public static NewIntent a(AppRuntime paramAppRuntime, ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), OnlineStatusWeatherServlet.class);
    localNewIntent.putExtra("type", paramArrayList);
    localNewIntent.putExtra("adcode", paramInt1);
    localNewIntent.putExtra("request_from", paramInt2);
    localNewIntent.putExtra("request_bundle", paramBundle);
    paramAppRuntime.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherServlet", 2, "packWeatherPackage");
    }
    Object localObject = paramIntent.getIntegerArrayListExtra("type");
    int i = paramIntent.getIntExtra("adcode", 0);
    paramIntent = new oidb_0xca6.ReqBody();
    if (localObject != null) {
      paramIntent.type.set((List)localObject);
    }
    paramIntent.adcode.set(i);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3238);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(4);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0xca6_4");
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  private void a(oidb_0xca6.RspBody paramRspBody, Intent paramIntent, int paramInt)
  {
    int i = paramIntent.getIntExtra("adcode", 0);
    String str1 = paramRspBody.weather_info.temper.get();
    String str2 = paramRspBody.weather_info.weather_type.get();
    String str3 = paramRspBody.weather_info.weather_type_id.get();
    List localList = paramRspBody.tips_list.tips.get();
    if (MobileQQ.sProcessId == 1)
    {
      AppRuntime localAppRuntime = getAppRuntime();
      IFriendDataService localIFriendDataService = (IFriendDataService)localAppRuntime.getRuntimeService(IFriendDataService.class, "");
      Friends localFriends = localIFriendDataService.getFriend(localAppRuntime.getCurrentUin(), true, true, true);
      localFriends.temper = str1;
      localFriends.weatherType = str2;
      localFriends.weatherTypeId = str3;
      localFriends.weatherUpdateTime = NetConnInfoCenter.getServerTime();
      localFriends.adCode = String.valueOf(i);
      localFriends.city = paramRspBody.city.get();
      localFriends.area = paramRspBody.area.get();
      if ((localList != null) && (localList.size() > 0))
      {
        localFriends.weatherTip = ((WeatherReportStore.TipsItem)localList.get(0)).content.get();
        localFriends.weatherDecs = ((WeatherReportStore.TipsItem)localList.get(0)).content.get();
      }
      if (QLog.isColorLevel())
      {
        paramRspBody = new StringBuilder("handleWeatherPackage temper:");
        paramRspBody.append(str1);
        paramRspBody.append(" weatherType=");
        paramRspBody.append(str2);
        paramRspBody.append(" weatherTypeId=");
        paramRspBody.append(str3);
        paramRspBody.append(" weatherUpdateTime=");
        paramRspBody.append(localFriends.weatherUpdateTime);
        paramRspBody.append(" adCode=");
        paramRspBody.append(localFriends.adCode);
        paramRspBody.append(" city=");
        paramRspBody.append(localFriends.city);
        paramRspBody.append(" area=");
        paramRspBody.append(localFriends.area);
        QLog.d("WeatherServlet", 2, paramRspBody.toString());
      }
      localFriends.weatherFlag = (OnlineStatusUtil.d(localFriends) ^ true);
      localIFriendDataService.saveFriend(localFriends);
      ((OnlineStatusDataManager)((IOnlineStatusManagerService)localAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class)).b(paramInt, paramIntent);
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramIntent.getIntExtra("request_from", 0);
    Object localObject2;
    if (paramFromServiceMsg.isSuccess())
    {
      try
      {
        Object localObject1 = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
          Object localObject3 = new byte[paramFromServiceMsg.getInt() - 4];
          paramFromServiceMsg.get((byte[])localObject3);
          ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])localObject3);
          localObject3 = localObject1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          localObject1 = localInvalidProtocolBufferMicroException2;
        }
        localFromServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        paramFromServiceMsg = null;
      }
      FromServiceMsg localFromServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("WeatherServlet", 2, "handleWeatherPackage parseFrom byte", localInvalidProtocolBufferMicroException1);
        localFromServiceMsg = paramFromServiceMsg;
      }
      int j = localFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("WeatherServlet", 2, new Object[] { "handleWeatherPackage | result = ", Integer.valueOf(j) });
      }
      if ((j == 0) && (localFromServiceMsg.bytes_bodybuffer.has()) && (localFromServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramFromServiceMsg = localFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        try
        {
          localObject2 = new oidb_0xca6.RspBody();
          ((oidb_0xca6.RspBody)localObject2).mergeFrom(paramFromServiceMsg);
          if ((!((oidb_0xca6.RspBody)localObject2).ret.has()) || (((oidb_0xca6.RspBody)localObject2).ret.get() != 0) || (!((oidb_0xca6.RspBody)localObject2).weather_info.has()) || (!((oidb_0xca6.RspBody)localObject2).tips_list.has())) {
            break label342;
          }
          a((oidb_0xca6.RspBody)localObject2, paramIntent, i);
          paramFromServiceMsg = new Bundle();
          paramFromServiceMsg.putInt("request_from", i);
          notifyObserver(paramIntent, 1, true, paramFromServiceMsg, WeatherObserver.class);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            break label342;
          }
        }
        QLog.d("WeatherServlet", 2, "handleWeatherPackage erro ", paramFromServiceMsg);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleWeatherPackage | response.result = ");
      ((StringBuilder)localObject2).append(paramFromServiceMsg.getResultCode());
      QLog.d("WeatherServlet", 2, ((StringBuilder)localObject2).toString());
    }
    label342:
    notifyObserver(paramIntent, 1, false, null, WeatherObserver.class);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    a(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherServlet
 * JD-Core Version:    0.7.0.1
 */