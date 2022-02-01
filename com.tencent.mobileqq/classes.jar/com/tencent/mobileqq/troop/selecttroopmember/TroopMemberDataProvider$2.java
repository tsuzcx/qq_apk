package com.tencent.mobileqq.troop.selecttroopmember;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopMemberDataProvider$2
  extends TroopObserver
{
  TroopMemberDataProvider$2(TroopMemberDataProvider paramTroopMemberDataProvider) {}
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("onOIDB0X899_0_Ret");
      ((StringBuilder)localObject).append("| isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("| troopuin = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("| nFlag = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("| strErorMsg = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TroopMemberDataProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 6)
    {
      if (!this.a.c.equals(String.valueOf(paramLong1))) {
        return;
      }
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
      if (this.a.d != null) {
        this.a.k.sendMessage(this.a.k.obtainMessage(4, paramString));
      }
    }
  }
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!this.a.c.equals(paramString)) {
        return;
      }
      ThreadManager.post(new TroopMemberDataProvider.2.1(this, paramList), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.2
 * JD-Core Version:    0.7.0.1
 */