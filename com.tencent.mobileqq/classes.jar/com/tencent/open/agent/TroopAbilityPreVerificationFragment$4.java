package com.tencent.open.agent;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeRsp;
import tencent.im.oidb.oidb_0xb60.RspBody;

class TroopAbilityPreVerificationFragment$4
  extends ProtoUtils.TroopProtocolObserver
{
  TroopAbilityPreVerificationFragment$4(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onResult type=");
    paramBundle.append(this.a.m);
    paramBundle.append(", appid=");
    paramBundle.append(this.a.h);
    paramBundle.append(", code=");
    paramBundle.append(paramInt);
    QLog.i("TroopAbility.PreVerification", 1, paramBundle.toString());
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xb60.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.get_privilege_rsp.api_groups.has()) && (paramBundle.get_privilege_rsp.next_req_duration.has()))
        {
          TroopAbilityPreVerificationFragment.a(paramBundle);
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("receive api_groups:");
          paramArrayOfByte.append(paramBundle.get_privilege_rsp.api_groups.get());
          paramArrayOfByte.append(", api_names:");
          paramArrayOfByte.append(paramBundle.get_privilege_rsp.api_names.get());
          QLog.d("TroopAbility.PreVerification", 1, paramArrayOfByte.toString());
          paramArrayOfByte = new HashSet();
          localObject = paramBundle.get_privilege_rsp.api_groups.get().iterator();
          while (((Iterator)localObject).hasNext()) {
            paramArrayOfByte.add((Integer)((Iterator)localObject).next());
          }
          boolean bool = this.a.a(paramArrayOfByte);
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("check permission result:");
          paramArrayOfByte.append(bool);
          QLog.i("TroopAbility.PreVerification", 1, paramArrayOfByte.toString());
          this.a.a(bool);
          TroopAbilityPreVerificationFragment.a(paramBundle.get_privilege_rsp.next_req_duration.get());
          TroopAbilityPreVerificationFragment.b(NetConnInfoCenter.getServerTime());
          return;
        }
        QLog.i("TroopAbility.PreVerification", 1, "rsp invalid");
        this.a.c(HardCodeUtil.a(2131912406));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("TroopAbility.PreVerification", 1, "parse rsp error", paramArrayOfByte);
        this.a.c(HardCodeUtil.a(2131912411));
        return;
      }
    }
    if ((!QLog.isColorLevel()) || (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = ((oidb_0xb60.RspBody)new oidb_0xb60.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label397:
      break label397;
    }
    paramBundle = "";
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("req error code=");
    ((StringBuilder)localObject).append(paramInt);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = ", data=null";
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(", msg=");
      paramArrayOfByte.append(paramBundle);
      paramArrayOfByte = paramArrayOfByte.toString();
    }
    ((StringBuilder)localObject).append(paramArrayOfByte);
    QLog.i("TroopAbility.PreVerification", 1, ((StringBuilder)localObject).toString());
    this.a.c(HardCodeUtil.a(2131912414));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityPreVerificationFragment.4
 * JD-Core Version:    0.7.0.1
 */