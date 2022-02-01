package com.tencent.mobileqq.selectmember;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;

class TroopListAdapter$1$1
  implements Runnable
{
  TroopListAdapter$1$1(TroopListAdapter.1 param1, byte[] paramArrayOfByte, AppInterface paramAppInterface, Bundle paramBundle, Handler paramHandler) {}
  
  public void run()
  {
    try
    {
      localObject1 = new oidb_0x88d.RspBody();
      ((oidb_0x88d.RspBody)localObject1).mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      if (((oidb_0x88d.RspBody)localObject1).stzrspgroupinfo.has())
      {
        localObject1 = ((oidb_0x88d.RspBody)localObject1).stzrspgroupinfo.get();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            oidb_0x88d.RspGroupInfo localRspGroupInfo = (oidb_0x88d.RspGroupInfo)((List)localObject1).get(i);
            if (localRspGroupInfo.uint32_result.get() == 0)
            {
              Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(localRspGroupInfo.uint64_group_code.get());
              localStringBuilder.append("");
              localObject2 = CommonUtils.a((AppInterface)localObject2, localStringBuilder.toString());
              ((TroopInfo)localObject2).troopPrivilegeFlag = ((oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get()).uint32_app_privilege_flag.get();
              ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo((TroopInfo)localObject2);
            }
            i += 1;
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      Object localObject1;
      label179:
      break label179;
    }
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("TroopList");
    if (localObject1 != null)
    {
      TroopListAdapter.a((AppInterface)TroopListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter$1.a).mApp.get(), TroopListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter$1.a), (ArrayList)localObject1);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopListAdapter.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */