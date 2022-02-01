package com.tencent.mobileqq.troop.homework.api.impl;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;

class HWTroopUtilsApiImpl$1
  implements Runnable
{
  HWTroopUtilsApiImpl$1(HWTroopUtilsApiImpl paramHWTroopUtilsApiImpl, AppRuntime paramAppRuntime, String paramString) {}
  
  public void run()
  {
    Object localObject = ((ITroopManagerService)this.a.getRuntimeService(ITroopManagerService.class, "")).getTroopAppListData(this.b);
    if (localObject != null) {}
    try
    {
      oidb_0xe83.RspBody localRspBody = new oidb_0xe83.RspBody();
      localRspBody.mergeFrom((byte[])localObject);
      localObject = localRspBody.infos.get();
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        Iterator localIterator = ((List)localObject).iterator();
        oidb_0xe83.AppInfo localAppInfo;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localAppInfo = (oidb_0xe83.AppInfo)localIterator.next();
        } while (localAppInfo.appid.get() != 1104445552L);
        localAppInfo.push_red_point.set(0);
        localRspBody.infos.set((List)localObject);
        ((ITroopManagerService)this.a.getRuntimeService(ITroopManagerService.class, "")).setTroopAppListData(this.b, localRspBody.toByteArray());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("HWTroopUtilsApiImpl", 2, "setAIOHomeworkBtnRedPoint: appList == null || appList.size() == 0");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label168:
      break label168;
    }
    if (QLog.isColorLevel()) {
      QLog.e("HWTroopUtilsApiImpl", 2, "setAIOHomeworkBtnRedPoint: InvalidProtocolBufferMicroException.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.api.impl.HWTroopUtilsApiImpl.1
 * JD-Core Version:    0.7.0.1
 */