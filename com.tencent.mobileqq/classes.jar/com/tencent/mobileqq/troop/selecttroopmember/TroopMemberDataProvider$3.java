package com.tencent.mobileqq.troop.selecttroopmember;

import android.os.Handler;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopMemberDataProvider$3
  extends TroopBusinessObserver
{
  TroopMemberDataProvider$3(TroopMemberDataProvider paramTroopMemberDataProvider) {}
  
  public void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
      QLog.i("TroopMemberDataProvider", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 != 6) || (!this.a.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramLong1)))) {}
    do
    {
      return;
      paramString = new HashMap();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (oidb_0x899.memberlist)paramList.next();
          if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has()) && (((oidb_0x899.memberlist)localObject).uint32_shutup_timestap.has()))
          {
            paramLong1 = ((oidb_0x899.memberlist)localObject).uint32_shutup_timestap.get();
            paramString.put(String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get()), Long.valueOf(paramLong1));
          }
        }
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack == null);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.3
 * JD-Core Version:    0.7.0.1
 */