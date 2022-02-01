package com.tencent.mobileqq.location.net;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.location.api.impl.C2CLocationPushDecoder;
import com.tencent.mobileqq.location.bean.C2COptPushRespBean;
import com.tencent.mobileqq.location.bean.KickOffRespBean;
import com.tencent.mobileqq.location.bean.OptRoomRespBean;
import com.tencent.mobileqq.location.bean.QueryRoomRespBean;
import com.tencent.mobileqq.location.bean.RoomClosePushRespBean;
import com.tencent.mobileqq.location.bean.TroopOptPushRespBean;
import com.tencent.mobileqq.location.bean.VenueOptRespBean;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.TroopLbsSharePushInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.location.RoomOperate.RspRoomQuery;
import tencent.im.oidb.location.RoomOperate.UserData;
import tencent.im.oidb.location.qq_lbs_share.AssemblyPointData;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125.MsgBody;

public final class LocationObserver
  extends LocationObserverBase
{
  private LocationRoom.Venue a(qq_lbs_share.AssemblyPointData paramAssemblyPointData)
  {
    if (paramAssemblyPointData != null)
    {
      int i = paramAssemblyPointData.operation.get();
      if (((i == 1) || (i == 2)) && (paramAssemblyPointData.operator.get() > 0L))
      {
        LocationRoom.Venue localVenue = new LocationRoom.Venue();
        localVenue.b = String.valueOf(paramAssemblyPointData.operator.get());
        localVenue.e = new LatLng(paramAssemblyPointData.lat.get(), paramAssemblyPointData.lon.get());
        boolean bool = paramAssemblyPointData.poi_name.has();
        String str2 = "";
        if (bool) {
          str1 = paramAssemblyPointData.poi_name.get().toStringUtf8();
        } else {
          str1 = "";
        }
        localVenue.c = str1;
        String str1 = str2;
        if (paramAssemblyPointData.poi_address.has()) {
          str1 = paramAssemblyPointData.poi_address.get().toStringUtf8();
        }
        localVenue.d = str1;
        return localVenue;
      }
    }
    return null;
  }
  
  protected void a(C2COptPushRespBean paramC2COptPushRespBean)
  {
    int i = paramC2COptPushRespBean.a().uint32_msg_type.get();
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserver", 2, new Object[] { "decodeMsg: invoked. ", " optType: ", Integer.valueOf(i) });
    }
    if ((i != 1) && (i != 2) && (i != 3))
    {
      switch (i)
      {
      default: 
        return;
      }
      C2CLocationPushDecoder.a(paramC2COptPushRespBean.a(), i);
      return;
    }
    C2CLocationPushDecoder.a(paramC2COptPushRespBean.a());
  }
  
  protected void a(KickOffRespBean paramKickOffRespBean)
  {
    LocationRoom.RoomKey localRoomKey = new LocationRoom.RoomKey(paramKickOffRespBean.a(), paramKickOffRespBean.b());
    LocationHandler.a().a(localRoomKey, paramKickOffRespBean.c());
  }
  
  protected void a(OptRoomRespBean paramOptRoomRespBean)
  {
    boolean bool = paramOptRoomRespBean.a();
    int i = 3;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationObserver", 2, new Object[] { "onOperateRoom: invoked. ", " uin: ", paramOptRoomRespBean.e(), " uinType: ", Integer.valueOf(paramOptRoomRespBean.d()), " optType: ", Integer.valueOf(paramOptRoomRespBean.c()) });
      }
      LocationShareRoomManager.a().c.a(paramOptRoomRespBean.d(), paramOptRoomRespBean.e());
      LocationShareRoomManager.a().c.b(paramOptRoomRespBean.d(), paramOptRoomRespBean.e());
      if (QLog.isColorLevel()) {
        QLog.d("LocationObserver", 2, new Object[] { "onOperateRoom: invoked. real report invoked. ", " optType: ", Integer.valueOf(paramOptRoomRespBean.c()) });
      }
      if (paramOptRoomRespBean.c() == 1)
      {
        LocationShareLocationManager.a().a(paramOptRoomRespBean.d(), paramOptRoomRespBean.e());
        ReportController.b(null, "CliOper", "", "", "0X800A764", "0X800A764", 0, 0, "", "0", "0", "");
      }
      else if (paramOptRoomRespBean.c() == 2)
      {
        LocationShareLocationManager.a().a(paramOptRoomRespBean.d(), paramOptRoomRespBean.e());
        if (LocationShareRoomManager.a().b()) {
          ReportController.b(null, "CliOper", "", "", "0X800A76B", "0X800A76B", LocationHandler.a(LocationHandler.a().b()), 0, "", "0", "0", "");
        }
      }
      LocationShareRoomManager.a().a(false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserver", 2, new Object[] { "onOperateRoom: invoked. ", " errorCode: ", Integer.valueOf(paramOptRoomRespBean.b()) });
    }
    LocationRoom.RoomKey localRoomKey = new LocationRoom.RoomKey(paramOptRoomRespBean.d(), paramOptRoomRespBean.e());
    LocationShareLocationManager.a().a(localRoomKey, true);
    LocationHandler.a().a(localRoomKey, paramOptRoomRespBean.b(), paramOptRoomRespBean.c());
    if (paramOptRoomRespBean.b() != 10101) {
      if ((paramOptRoomRespBean.b() != 10001) && (paramOptRoomRespBean.b() != 10003) && (paramOptRoomRespBean.b() != 10004) && (paramOptRoomRespBean.b() != 10100)) {
        i = 0;
      } else {
        i = 2;
      }
    }
    LocationShareRoomManager.a().a(paramOptRoomRespBean.d(), paramOptRoomRespBean.e(), LocationHandler.a().b(), i);
  }
  
  @SuppressLint({"SimpleDateFormat"})
  protected void a(QueryRoomRespBean paramQueryRoomRespBean)
  {
    LocationRoom.Venue localVenue = a((qq_lbs_share.AssemblyPointData)paramQueryRoomRespBean.a().assembly_Point.get());
    Object localObject1 = paramQueryRoomRespBean.a().user_list.get();
    int i = paramQueryRoomRespBean.a().room_state.get();
    if (((List)localObject1).size() <= 0)
    {
      QLog.e("LocationObserver", 1, new Object[] { "[queryLocationRoom][error] onQueryRoom: invoked. sessionUin: ", paramQueryRoomRespBean.c(), " roomState: ", Integer.valueOf(i), " userDataList: ", Integer.valueOf(((List)localObject1).size()), " venue: ", localVenue });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserver", 2, new Object[] { "[queryLocationRoom] onQueryRoom: invoked. sessionUin: ", paramQueryRoomRespBean.c(), " userDataList: ", Integer.valueOf(((List)localObject1).size()), " venue: ", localVenue });
    }
    LocationRoom.RoomKey localRoomKey = new LocationRoom.RoomKey(paramQueryRoomRespBean.b(), paramQueryRoomRespBean.c());
    LocationRoom localLocationRoom = LocationHandler.a().b(localRoomKey);
    ArrayList localArrayList = new ArrayList(20);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      RoomOperate.UserData localUserData = (RoomOperate.UserData)((Iterator)localObject1).next();
      String str = String.valueOf(localUserData.uin.get());
      LocationItem localLocationItem = new LocationItem(str, new LatLng(localUserData.lat.get(), localUserData.lon.get()), localUserData.direction.get());
      if ((localLocationItem.a().latitude == 0.0D) && (localLocationItem.a().longitude == 0.0D))
      {
        paramQueryRoomRespBean = localLocationRoom.a(str);
        if (paramQueryRoomRespBean != null)
        {
          localLocationItem.a(paramQueryRoomRespBean.a(), Double.valueOf(paramQueryRoomRespBean.b()));
          localArrayList.add(localLocationItem);
          paramQueryRoomRespBean = "[filter]";
        }
        else
        {
          paramQueryRoomRespBean = "[killed]";
        }
      }
      else
      {
        localArrayList.add(localLocationItem);
        paramQueryRoomRespBean = "[data]";
      }
      if (QLog.isColorLevel())
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[queryLocationRoom]");
        ((StringBuilder)localObject2).append(paramQueryRoomRespBean);
        ((StringBuilder)localObject2).append(" onQueryRoom invoked  roomState == open: ");
        paramQueryRoomRespBean = ((StringBuilder)localObject2).toString();
        boolean bool;
        if (i == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(localUserData.join_time.get() * 1000L));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" update: ");
        localStringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(localUserData.lbs_update_ts.get() * 1000L)));
        QLog.d("LocationObserver", 2, new Object[] { paramQueryRoomRespBean, Boolean.valueOf(bool), " uin: ", str, " locationItem: ", localLocationItem, " join: ", localObject2, localStringBuilder.toString() });
      }
    }
    LocationHandler.a().a(localRoomKey, localVenue, localArrayList);
  }
  
  protected void a(RoomClosePushRespBean paramRoomClosePushRespBean)
  {
    paramRoomClosePushRespBean = new LocationRoom.RoomKey(paramRoomClosePushRespBean.a(), paramRoomClosePushRespBean.b());
    LocationHandler.a().b(paramRoomClosePushRespBean, -1);
  }
  
  protected void a(TroopOptPushRespBean paramTroopOptPushRespBean)
  {
    int i = paramTroopOptPushRespBean.a().a;
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserver", 2, new Object[] { "onTroopOptPush: invoked. ", " msgType: ", Integer.valueOf(i) });
    }
    if (i == 1)
    {
      TroopLocationPushDecoder.a(paramTroopOptPushRespBean.a());
      return;
    }
    if (i == 2)
    {
      TroopLocationPushDecoder.a(paramTroopOptPushRespBean.a());
      return;
    }
    if (i == 3)
    {
      TroopLocationPushDecoder.a(paramTroopOptPushRespBean.a());
      return;
    }
    if (i == 101)
    {
      TroopLocationPushDecoder.a(paramTroopOptPushRespBean.a(), i);
      return;
    }
    if (i == 102)
    {
      TroopLocationPushDecoder.a(paramTroopOptPushRespBean.a(), i);
      return;
    }
    if (i == 103) {
      TroopLocationPushDecoder.a(paramTroopOptPushRespBean.a(), i);
    }
  }
  
  protected void a(VenueOptRespBean paramVenueOptRespBean)
  {
    LocationShareVenueManager.a().a(new LocationRoom.RoomKey(paramVenueOptRespBean.d(), paramVenueOptRespBean.e()), paramVenueOptRespBean.f(), paramVenueOptRespBean.c(), paramVenueOptRespBean.a(), paramVenueOptRespBean.b());
    if (!paramVenueOptRespBean.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationObserver", 2, new Object[] { "[venue] onVenueOpt: invoked. failed ", " errorCode: ", Integer.valueOf(paramVenueOptRespBean.b()) });
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserver", 2, new Object[] { "[venue] onVenueOpt: invoked. success ", " uin: ", paramVenueOptRespBean.e(), " uinType: ", Integer.valueOf(paramVenueOptRespBean.d()), " optType: ", Integer.valueOf(paramVenueOptRespBean.c()) });
    }
    LocationShareRoomManager.a().c.a(paramVenueOptRespBean.d(), paramVenueOptRespBean.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationObserver
 * JD-Core Version:    0.7.0.1
 */