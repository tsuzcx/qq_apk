package com.tencent.mobileqq.troop.selecttroopmember;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class TroopMemberDataProvider$4
  implements Runnable
{
  TroopMemberDataProvider$4(TroopMemberDataProvider paramTroopMemberDataProvider, String paramString, List paramList, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    if (!this.a.equals(this.this$0.c))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("subThread, curTroopUin != mTroopUin, return, ");
        ((StringBuilder)???).append(this.a);
        ((StringBuilder)???).append(",");
        ((StringBuilder)???).append(this.this$0.c);
        QLog.d("TroopMemberDataProvider", 2, ((StringBuilder)???).toString());
      }
      return;
    }
    Object localObject2 = this.b.subList(this.c, this.d);
    synchronized (this.this$0.e)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject2).next();
        if ((Utils.e(localTroopMemberInfo.memberuin)) && ((TextUtils.isEmpty(localTroopMemberInfo.memberuin)) || (!localTroopMemberInfo.memberuin.equals("50000000"))))
        {
          localTroopMemberInfo.displayedNamePinyinFirst = ChnToSpell.b(ContactUtils.b(this.this$0.a, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin), 2);
          this.this$0.e.add(localTroopMemberInfo);
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("subThread end, id=");
        ((StringBuilder)???).append(Thread.currentThread().getId());
        ((StringBuilder)???).append(", threadCnt=");
        ((StringBuilder)???).append(this.e.get());
        ((StringBuilder)???).append(", curTroopUin=");
        ((StringBuilder)???).append(this.a);
        QLog.d("TroopMemberDataProvider", 2, ((StringBuilder)???).toString());
      }
      if (this.e.getAndDecrement() <= 1)
      {
        ??? = this.this$0.k.obtainMessage(2);
        this.this$0.k.sendMessage((Message)???);
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.4
 * JD-Core Version:    0.7.0.1
 */