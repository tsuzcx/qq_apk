package com.tencent.mobileqq.location.net;

import android.os.Bundle;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.RoomOperate.ReqAssemblyPointOperation;
import tencent.im.oidb.location.RoomOperate.RspAssemblyPointOperation;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class VenueOperateHandler
  extends BaseProto<LocationHandler>
{
  private void a(int paramInt1, int paramInt2, long paramLong, LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("operateType: ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" [R_OPT_ADD = 1; R_OPT_UPDATE = 2; R_OPT_DELETE = 3;]");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(", uinType: ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(", sessionUin: ");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(", venue: ");
      ((StringBuilder)localObject2).append(paramVenue);
      QLog.d("VenueOperateHandler", 2, new Object[] { "[venue] requestVenueOperate: invoked. ", localObject1, ((StringBuilder)localObject2).toString() });
    }
    Object localObject1 = new RoomOperate.ReqAssemblyPointOperation();
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    qq_lbs_share.RoomKey localRoomKey = LocationProtoUtil.a((AppRuntime)localObject2, paramInt2, paramLong);
    ((RoomOperate.ReqAssemblyPointOperation)localObject1).room_key.set(localRoomKey);
    ((RoomOperate.ReqAssemblyPointOperation)localObject1).room_key.setHasFlag(true);
    ((RoomOperate.ReqAssemblyPointOperation)localObject1).point_operation.set(paramInt1);
    ((RoomOperate.ReqAssemblyPointOperation)localObject1).poi_name.set(ByteStringMicro.copyFrom(paramVenue.b.getBytes()));
    ((RoomOperate.ReqAssemblyPointOperation)localObject1).poi_address.set(ByteStringMicro.copyFrom(paramVenue.c.getBytes()));
    ((RoomOperate.ReqAssemblyPointOperation)localObject1).lat.set(paramVenue.a.latitude);
    ((RoomOperate.ReqAssemblyPointOperation)localObject1).lon.set(paramVenue.a.longitude);
    localObject2 = new ToServiceMsg("mobileqq.service", ((AppRuntime)localObject2).getAccount(), "QQLBSShareSvc.assembly_point_operation");
    ((ToServiceMsg)localObject2).extraData.putInt("OPT_VENUE_TYPE", paramInt1);
    ((ToServiceMsg)localObject2).extraData.putInt("uintype", paramInt2);
    ((ToServiceMsg)localObject2).extraData.putString("uin", String.valueOf(paramLong));
    ((ToServiceMsg)localObject2).extraData.putParcelable("key_location_venue", paramVenue);
    ((ToServiceMsg)localObject2).putWupBuffer(((RoomOperate.ReqAssemblyPointOperation)localObject1).toByteArray());
    a().sendPbReq((ToServiceMsg)localObject2);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3, LocationRoom.Venue paramVenue)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    LocationProtoUtil.a(localAppRuntime, paramInt1, paramString, false);
    ((ILocationShareService)localAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyStateError(paramInt1, paramString, false);
    a().notifyUI(7, false, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), paramString, paramVenue });
  }
  
  protected LocationHandler a()
  {
    return LocationHandler.a();
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue)
  {
    if (paramRoomKey != null)
    {
      if (paramVenue == null) {
        return;
      }
      a(1, paramRoomKey.a(), Long.parseLong(paramRoomKey.a()), paramVenue);
    }
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject)) {
      try
      {
        i = paramToServiceMsg.extraData.getInt("OPT_VENUE_TYPE");
        int j = paramToServiceMsg.extraData.getInt("uintype", -1);
        paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
        paramToServiceMsg = (LocationRoom.Venue)paramToServiceMsg.extraData.getParcelable("key_location_venue");
        paramObject = (qq_lbs_share.ResultInfo)((RoomOperate.RspAssemblyPointOperation)new RoomOperate.RspAssemblyPointOperation().mergeFrom((byte[])paramObject)).msg_result.get();
        if (LocationProtoUtil.a(paramObject))
        {
          a().notifyUI(7, true, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), paramFromServiceMsg, paramToServiceMsg });
          return;
        }
        a(j, paramFromServiceMsg, paramObject.uint32_result.get(), i, paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("VenueOperateHandler", 1, "[venue] requestOperateRoomResp: failed. ", paramToServiceMsg);
        return;
      }
    }
    if (paramFromServiceMsg != null)
    {
      i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel()) {
        QLog.d("VenueOperateHandler", 2, new Object[] { "[venue] requestOperateRoomResp: invoked. ", " resultCode: ", Integer.valueOf(i) });
      }
    }
    a(-2, "", -10001, -1, (LocationRoom.Venue)paramToServiceMsg.extraData.getParcelable("key_location_venue"));
  }
  
  void b(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue)
  {
    if (paramRoomKey != null)
    {
      if (paramVenue == null) {
        return;
      }
      a(3, paramRoomKey.a(), Long.parseLong(paramRoomKey.a()), paramVenue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.VenueOperateHandler
 * JD-Core Version:    0.7.0.1
 */