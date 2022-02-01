package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.location.bean.C2COptPushRespBean;
import com.tencent.mobileqq.location.bean.KickOffRespBean;
import com.tencent.mobileqq.location.bean.OptRoomRespBean;
import com.tencent.mobileqq.location.bean.QueryRoomRespBean;
import com.tencent.mobileqq.location.bean.RoomClosePushRespBean;
import com.tencent.mobileqq.location.bean.TroopOptPushRespBean;
import com.tencent.mobileqq.location.bean.VenueOptRespBean;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.TroopLbsSharePushInfo;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.location.RoomOperate.RspRoomQuery;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125.MsgBody;

class LocationObserverBase
  implements BusinessObserver
{
  protected void a(C2COptPushRespBean paramC2COptPushRespBean) {}
  
  protected void a(KickOffRespBean paramKickOffRespBean) {}
  
  protected void a(OptRoomRespBean paramOptRoomRespBean) {}
  
  protected void a(QueryRoomRespBean paramQueryRoomRespBean) {}
  
  protected void a(RoomClosePushRespBean paramRoomClosePushRespBean) {}
  
  protected void a(TroopOptPushRespBean paramTroopOptPushRespBean) {}
  
  protected void a(VenueOptRespBean paramVenueOptRespBean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserverBase", 2, new Object[] { "onUpdate: invoked. ", " type: ", Integer.valueOf(paramInt), " isSuccess: ", Boolean.valueOf(paramBoolean), " data: ", paramObject });
    }
    Object localObject;
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      paramObject = (Object[])paramObject;
      if (paramObject != null)
      {
        if (paramObject.length == 0) {
          return;
        }
        localObject = new VenueOptRespBean();
        ((VenueOptRespBean)localObject).a(paramBoolean);
        ((VenueOptRespBean)localObject).a(((Integer)paramObject[0]).intValue());
        ((VenueOptRespBean)localObject).b(((Integer)paramObject[1]).intValue());
        ((VenueOptRespBean)localObject).c(((Integer)paramObject[2]).intValue());
        ((VenueOptRespBean)localObject).a((String)paramObject[3]);
        ((VenueOptRespBean)localObject).a((LocationRoom.Venue)paramObject[4]);
        a((VenueOptRespBean)localObject);
        return;
      }
      return;
    case 6: 
      localObject = new KickOffRespBean();
      paramObject = (Object[])paramObject;
      ((KickOffRespBean)localObject).a(((Integer)paramObject[0]).intValue());
      ((KickOffRespBean)localObject).a(String.valueOf(paramObject[1]));
      ((KickOffRespBean)localObject).b(((Integer)paramObject[2]).intValue());
      a((KickOffRespBean)localObject);
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      localObject = new RoomClosePushRespBean();
      ((RoomClosePushRespBean)localObject).a(((Integer)paramObject[0]).intValue());
      ((RoomClosePushRespBean)localObject).a(String.valueOf(paramObject[1]));
      a((RoomClosePushRespBean)localObject);
      return;
    case 4: 
      if (!paramBoolean) {
        return;
      }
      paramObject = (Object[])paramObject;
      localObject = new C2COptPushRespBean();
      ((C2COptPushRespBean)localObject).a((submsgtype0x125.MsgBody)paramObject[0]);
      a((C2COptPushRespBean)localObject);
      return;
    case 3: 
      if (!paramBoolean) {
        return;
      }
      paramObject = (Object[])paramObject;
      localObject = new TroopOptPushRespBean();
      ((TroopOptPushRespBean)localObject).a((TroopLbsSharePushInfo)paramObject[0]);
      a((TroopOptPushRespBean)localObject);
      return;
    case 2: 
      if (!paramBoolean) {
        return;
      }
      paramObject = (Object[])paramObject;
      localObject = new QueryRoomRespBean();
      ((QueryRoomRespBean)localObject).a((RoomOperate.RspRoomQuery)paramObject[0]);
      ((QueryRoomRespBean)localObject).a(((Integer)paramObject[1]).intValue());
      ((QueryRoomRespBean)localObject).a((String)paramObject[2]);
      a((QueryRoomRespBean)localObject);
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramObject != null)
    {
      if (paramObject.length == 0) {
        return;
      }
      localObject = new OptRoomRespBean();
      ((OptRoomRespBean)localObject).a(paramBoolean);
      ((OptRoomRespBean)localObject).a(((Integer)paramObject[0]).intValue());
      ((OptRoomRespBean)localObject).b(((Integer)paramObject[1]).intValue());
      ((OptRoomRespBean)localObject).c(((Integer)paramObject[2]).intValue());
      ((OptRoomRespBean)localObject).a((String)paramObject[3]);
      a((OptRoomRespBean)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationObserverBase
 * JD-Core Version:    0.7.0.1
 */