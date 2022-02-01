package com.tencent.mobileqq.selectmember;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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

class TroopAddFrdsInnerFrame$5
  implements Runnable
{
  TroopAddFrdsInnerFrame$5(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame, List paramList1, int paramInt1, int paramInt2, String paramString1, String paramString2, Map paramMap, List paramList2, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    Object localObject1 = this.a.subList(this.b, this.c);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    int i = 0;
    TroopMemberInfo localTroopMemberInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
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
    } while (((!this.this$0.f.mShowMyself) && (this.e.equalsIgnoreCase(localTroopMemberInfo.memberuin))) || (this.this$0.f.mUinsToHide.contains(localTroopMemberInfo.memberuin)) || (!Utils.e(localTroopMemberInfo.memberuin)));
    for (;;)
    {
      try
      {
        for (;;)
        {
          long l = Long.valueOf(localTroopMemberInfo.memberuin).longValue();
          if (l < 0L) {
            break;
          }
          localObject1 = null;
          if (this.this$0.z == TroopAddFrdsInnerFrame.x)
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
          }
          else if (this.this$0.z == TroopAddFrdsInnerFrame.y)
          {
            if ((!TextUtils.isEmpty(TroopAddFrdsInnerFrame.a(this.this$0))) && (TroopAddFrdsInnerFrame.a(this.this$0).equalsIgnoreCase(localTroopMemberInfo.memberuin))) {
              localTroopMemberInfo.addState = 1;
            } else {
              localTroopMemberInfo.addState = TroopAddFrdsInnerFrame.a(this.this$0, localTroopMemberInfo.memberuin);
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(localTroopMemberInfo.addState);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          if ((localTroopMemberInfo.commonFrdCnt == -2147483648) && (!localTroopMemberInfo.memberuin.equals(this.e))) {
            localArrayList.add(localTroopMemberInfo.memberuin);
          }
          synchronized (this.f)
          {
            if (this.f.get(localObject1) == null) {
              this.f.put(localObject1, new ArrayList());
            }
            ((List)this.f.get(localObject1)).add(localTroopMemberInfo);
            i += 1;
          }
        }
      }
      catch (Exception localException)
      {
        continue;
      }
      synchronized (this.g)
      {
        this.g.addAll(localArrayList);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("subThread end, id=");
          ((StringBuilder)???).append(Thread.currentThread().getId());
          ((StringBuilder)???).append(", threadCnt=");
          ((StringBuilder)???).append(this.h.get());
          ((StringBuilder)???).append(", curTroopUin=");
          ((StringBuilder)???).append(this.d);
          QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)???).toString());
        }
        if (this.h.getAndDecrement() <= 1)
        {
          ??? = this.this$0.C.obtainMessage(3);
          ((Message)???).arg1 = i;
          ((Message)???).obj = new Object[] { this.f, this.d };
          this.this$0.C.sendMessage((Message)???);
          if (this.g.size() > 0)
          {
            ??? = this.this$0.B.obtainMessage(5);
            ((Message)???).obj = this.g;
            this.this$0.B.sendMessage((Message)???);
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.5
 * JD-Core Version:    0.7.0.1
 */