package com.tencent.mobileqq.selectmember;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class TroopMemberListInnerFrame$5
  implements Runnable
{
  TroopMemberListInnerFrame$5(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, List paramList, int paramInt1, int paramInt2, String paramString1, String paramString2, TroopInfo paramTroopInfo, Map paramMap, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    Iterator localIterator = this.a.subList(this.b, this.c).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
      Object localObject1;
      if (!this.d.equals(this.this$0.c))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("subThread, curTroopUin != mTroopUin, return, ");
          ((StringBuilder)localObject1).append(this.d);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(this.this$0.c);
          QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if (((!this.this$0.f.mShowMyself) || (this.this$0.f.mIsPutMySelfFirst)) && (this.e.equalsIgnoreCase(localTroopMemberInfo.memberuin))) {
        this.this$0.n = localTroopMemberInfo;
      } else if ((!this.this$0.f.mUinsToHide.contains(localTroopMemberInfo.memberuin)) && (Utils.e(localTroopMemberInfo.memberuin))) {
        if ((this.f != null) && (this.this$0.u == 2) && (!this.f.isTroopAdmin(localTroopMemberInfo.memberuin)) && (!this.f.isTroopOwner(localTroopMemberInfo.memberuin)))
        {
          this.this$0.f.mUinsToHide.add(localTroopMemberInfo.memberuin);
        }
        else
        {
          localTroopMemberInfo.displayedNamePinyinFirst = ChnToSpell.b(CommonUtils.a(this.this$0.h, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin), 2);
          if ((localTroopMemberInfo.displayedNamePinyinFirst != null) && (localTroopMemberInfo.displayedNamePinyinFirst.length() != 0)) {
            localObject1 = localTroopMemberInfo.displayedNamePinyinFirst.substring(0, 1);
          } else {
            localObject1 = "#";
          }
          int j = ((String)localObject1).charAt(0);
          if (((65 <= j) && (j <= 90)) || ((97 <= j) && (j <= 122))) {
            localObject1 = ((String)localObject1).toUpperCase();
          } else {
            localObject1 = "#";
          }
          synchronized (this.g)
          {
            if (this.g.get(localObject1) == null) {
              this.g.put(localObject1, new ArrayList());
            }
            ((List)this.g.get(localObject1)).add(localTroopMemberInfo);
            i += 1;
          }
        }
      }
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("subThread end, id=");
      ((StringBuilder)localObject3).append(Thread.currentThread().getId());
      ((StringBuilder)localObject3).append(", threadCnt=");
      ((StringBuilder)localObject3).append(this.h.get());
      ((StringBuilder)localObject3).append(", curTroopUin=");
      ((StringBuilder)localObject3).append(this.d);
      QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject3).toString());
    }
    if (this.h.getAndDecrement() <= 1)
    {
      localObject3 = this.this$0.C.obtainMessage(3);
      ((Message)localObject3).arg1 = i;
      ((Message)localObject3).obj = new Object[] { this.g, this.d };
      this.this$0.C.sendMessage((Message)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.5
 * JD-Core Version:    0.7.0.1
 */