package com.tencent.mobileqq.location.net;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.RoomOperate.ReqRoomQuery;
import tencent.im.oidb.location.RoomOperate.RspRoomQuery;
import tencent.im.oidb.location.RoomOperate.UserData;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class RoomQueryHandler
  extends BaseProto<LocationHandler>
{
  private final Handler a = new Handler(ThreadManager.getSubThreadLooper());
  private long b;
  private final AtomicBoolean c = new AtomicBoolean(true);
  private final AtomicInteger d = new AtomicInteger(0);
  private Runnable e;
  
  private void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoom: invoked. ", " uinType: ", Integer.valueOf(paramInt), " sessionUin: ", Long.valueOf(paramLong), " noLimitReq: ", Boolean.valueOf(paramBoolean) });
    }
    long l = System.currentTimeMillis();
    if ((l - this.b < this.d.get() * 1000L) && (!paramBoolean))
    {
      QLog.d("RoomQueryHandler", 1, new Object[] { "[queryLocationRoom] requestQueryRoomNoLimit: invoked. frequency limited", " requestIntervalSecond: ", this.d });
      return;
    }
    this.b = l;
    RoomOperate.ReqRoomQuery localReqRoomQuery = new RoomOperate.ReqRoomQuery();
    localReqRoomQuery.no_limit.set(paramBoolean);
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    qq_lbs_share.RoomKey localRoomKey = LocationProtoUtil.a((AppRuntime)localObject, paramInt, paramLong);
    localReqRoomQuery.room_key.set(localRoomKey);
    localReqRoomQuery.room_key.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", ((AppRuntime)localObject).getAccount(), "QQLBSShareSvc.room_query");
    ((ToServiceMsg)localObject).extraData.putInt("uintype", paramInt);
    ((ToServiceMsg)localObject).extraData.putString("uin", String.valueOf(paramLong));
    ((ToServiceMsg)localObject).putWupBuffer(localReqRoomQuery.toByteArray());
    b().sendPbReq((ToServiceMsg)localObject);
  }
  
  private void c(int paramInt, String paramString)
  {
    long l;
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", paramString);
      l = 0L;
    }
    a(paramInt, l, false);
  }
  
  private void d()
  {
    b().notifyUI(2, false, null);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] stopRequestQueryRoomInLoop: invoked. ", " loopQueryStopped: ", this.c });
    }
    this.c.set(true);
    this.a.removeCallbacks(this.e);
  }
  
  public void a(int paramInt, String paramString)
  {
    long l;
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", localNumberFormatException);
      l = 0L;
    }
    LocationHandler.a().a(paramInt, paramString);
    a(paramInt, l, true);
  }
  
  protected LocationHandler b()
  {
    return LocationHandler.a();
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!this.c.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoomInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", paramString });
      }
      return;
    }
    this.c.set(false);
    this.e = new RoomQueryHandler.1(this, paramInt, paramString);
    this.a.post(this.e);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject)) {
      try
      {
        paramFromServiceMsg = (RoomOperate.RspRoomQuery)new RoomOperate.RspRoomQuery().mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.room_state.get();
        if (QLog.isColorLevel())
        {
          Object localObject = paramFromServiceMsg.user_list.get();
          paramObject = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramObject.add(Long.valueOf(((RoomOperate.UserData)((Iterator)localObject).next()).uin.get()));
          }
          QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoomResp: invoked. ", " roomState: ", Integer.valueOf(i), " OPEN = 1; //开启中 CLOSED = 2; //已关闭 \n users: ", paramObject });
        }
        if (LocationProtoUtil.a((qq_lbs_share.ResultInfo)paramFromServiceMsg.msg_result.get()))
        {
          int j = paramFromServiceMsg.req_interval.get();
          this.d.set(j);
          j = paramToServiceMsg.extraData.getInt("uintype", -1);
          paramToServiceMsg = paramToServiceMsg.extraData.getString("uin");
          if (i == 2)
          {
            a();
            LocationHandler.a().b(new LocationRoom.RoomKey(j, paramToServiceMsg), -1);
            LocationProtoUtil.a(MobileQQ.sMobileQQ.waitAppRuntime(null), j, paramToServiceMsg, false);
          }
          b().notifyUI(2, true, new Object[] { paramFromServiceMsg, Integer.valueOf(j), paramToServiceMsg });
          return;
        }
        d();
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoomResp: failed. ", paramToServiceMsg);
        return;
      }
    }
    if (paramFromServiceMsg != null)
    {
      i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel()) {
        QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoomResp: invoked. ", " resultCode: ", Integer.valueOf(i) });
      }
    }
    d();
  }
  
  public void c()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.RoomQueryHandler
 * JD-Core Version:    0.7.0.1
 */