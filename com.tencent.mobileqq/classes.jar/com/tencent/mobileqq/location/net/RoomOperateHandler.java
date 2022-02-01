package com.tencent.mobileqq.location.net;

import android.os.Bundle;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.RoomOperate.ReqRoomOperation;
import tencent.im.oidb.location.RoomOperate.RspRoomOperation;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class RoomOperateHandler
  extends BaseProto<LocationHandler>
{
  private void a(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject1 = LocationShareLocationManager.a().a();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("operateType = [");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("] ");
      QLog.d("RoomOperateHandler", 2, new Object[] { "requestOperateRoom: invoked. ", ((StringBuilder)localObject2).toString(), " R_OPT_CREATE = 1; //创建房间", " R_OPT_JOIN = 2; //加入", " R_OPT_QUIT = 3; //退出\n", ", uinType = [", Integer.valueOf(paramInt2), "], sessionUin = [", Long.valueOf(paramLong), "], location = [", localObject1, "]" });
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new RoomOperate.ReqRoomOperation();
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    qq_lbs_share.RoomKey localRoomKey = LocationProtoUtil.a(localAppRuntime, paramInt2, paramLong);
    ((RoomOperate.ReqRoomOperation)localObject2).room_key.set(localRoomKey);
    ((RoomOperate.ReqRoomOperation)localObject2).room_key.setHasFlag(true);
    ((RoomOperate.ReqRoomOperation)localObject2).room_operation.set(paramInt1);
    ((RoomOperate.ReqRoomOperation)localObject2).lat.set(((LatLng)localObject1).latitude);
    ((RoomOperate.ReqRoomOperation)localObject2).lon.set(((LatLng)localObject1).longitude);
    localObject1 = new ToServiceMsg("mobileqq.service", localAppRuntime.getAccount(), "QQLBSShareSvc.room_operation");
    ((ToServiceMsg)localObject1).extraData.putInt("OPT_ROOM_TYPE", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putInt("uintype", paramInt2);
    ((ToServiceMsg)localObject1).extraData.putString("uin", String.valueOf(paramLong));
    ((ToServiceMsg)localObject1).putWupBuffer(((RoomOperate.ReqRoomOperation)localObject2).toByteArray());
    a().sendPbReq((ToServiceMsg)localObject1);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    LocationProtoUtil.a(localAppRuntime, paramInt1, paramString, false);
    ((ILocationShareService)localAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyStateError(paramInt1, paramString, false);
    a().notifyUI(1, false, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), paramString });
  }
  
  protected LocationHandler a()
  {
    return LocationHandler.a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      a(paramInt1, paramInt2, l);
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("RoomOperateHandler", 1, "requestOperateRoom: failed. ", paramString);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject)) {
      try
      {
        i = paramToServiceMsg.extraData.getInt("OPT_ROOM_TYPE");
        int j = paramToServiceMsg.extraData.getInt("uintype", -1);
        paramToServiceMsg = paramToServiceMsg.extraData.getString("uin");
        paramFromServiceMsg = (qq_lbs_share.ResultInfo)((RoomOperate.RspRoomOperation)new RoomOperate.RspRoomOperation().mergeFrom((byte[])paramObject)).msg_result.get();
        if (LocationProtoUtil.a(paramFromServiceMsg))
        {
          a().notifyUI(1, true, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
          return;
        }
        a(j, paramToServiceMsg, paramFromServiceMsg.uint32_result.get(), i);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("RoomOperateHandler", 1, "requestOperateRoomResp: failed. ", paramToServiceMsg);
        return;
      }
    }
    if (paramFromServiceMsg != null)
    {
      i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel()) {
        QLog.d("RoomOperateHandler", 2, new Object[] { "requestOperateRoomResp: invoked. ", " resultCode: ", Integer.valueOf(i) });
      }
    }
    a(-2, "", -10001, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.RoomOperateHandler
 * JD-Core Version:    0.7.0.1
 */