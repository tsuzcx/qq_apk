package com.tencent.mobileqq.troop.utils;

import auga;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.AppInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;

public final class HWTroopUtils$3
  implements Runnable
{
  public HWTroopUtils$3(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    auga localauga = (auga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    Object localObject = localauga.a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null) {
      try
      {
        oidb_0xaf4.RspBody localRspBody = new oidb_0xaf4.RspBody();
        localRspBody.mergeFrom((byte[])localObject);
        localObject = localRspBody.infos.get();
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("hw_troop", 2, "setAIOHomeworkBtnRedPoint: appList == null || appList.size() == 0");
          }
        }
        else
        {
          Iterator localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext())
          {
            oidb_0xaf4.AppInfo localAppInfo = (oidb_0xaf4.AppInfo)localIterator.next();
            if (localAppInfo.appid.get() == 1104445552L)
            {
              localAppInfo.push_red_point.set(0);
              localRspBody.infos.set((List)localObject);
              localauga.a(this.jdField_a_of_type_JavaLangString, localRspBody.toByteArray());
              return;
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("hw_troop", 2, "setAIOHomeworkBtnRedPoint: InvalidProtocolBufferMicroException.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.HWTroopUtils.3
 * JD-Core Version:    0.7.0.1
 */