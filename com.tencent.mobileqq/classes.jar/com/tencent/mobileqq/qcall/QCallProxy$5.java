package com.tencent.mobileqq.qcall;

import android.text.TextUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class QCallProxy$5
  implements Runnable
{
  QCallProxy$5(QCallProxy paramQCallProxy, QCallProxy.QueryRecentCallsListener paramQueryRecentCallsListener) {}
  
  public void run()
  {
    Object localObject8;
    Object localObject6;
    Object localObject5;
    Object localObject4;
    int k;
    int i;
    int j;
    Object localObject9;
    Object localObject10;
    label226:
    label244:
    int m;
    for (;;)
    {
      Object localObject11;
      synchronized (QCallProxy.a(this.this$0))
      {
        Object localObject1 = new ArrayList();
        localObject8 = new ArrayList();
        localObject7 = new ArrayList();
        localObject6 = new ArrayList();
        localObject5 = (PhoneContactManager)QCallProxy.a(this.this$0).getManager(QQManagerFactory.CONTACT_MANAGER);
        localObject4 = (FriendsManager)QCallProxy.b(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
        k = 0;
        i = 0;
        j = k;
        if (localObject5 == null) {
          break label1090;
        }
        j = k;
        if (!((PhoneContactManager)localObject5).d()) {
          break label1090;
        }
        j = k;
        if (localObject4 == null) {
          break label1090;
        }
        localObject9 = QCallProxy.a(this.this$0).iterator();
        if (((Iterator)localObject9).hasNext())
        {
          localObject10 = (QCallRecent)((Iterator)localObject9).next();
          j = i;
          if (localObject10 == null) {
            break label1229;
          }
          j = i;
          if (((QCallRecent)localObject10).uin == null) {
            break label1229;
          }
          j = i;
          if (((QCallRecent)localObject10).uin.length() < 2) {
            break label1229;
          }
          if (((QCallRecent)localObject10).type == 1006)
          {
            localObject11 = ((PhoneContactManager)localObject5).c(((QCallRecent)localObject10).uin);
            if ((localObject11 == null) || (!((FriendsManager)localObject4).b(((PhoneContact)localObject11).uin))) {
              break label1234;
            }
            j = 1;
            if ((localObject11 == null) || (!TextUtils.isEmpty(((PhoneContact)localObject11).uin))) {
              break label1239;
            }
            k = 1;
            if (j != 0)
            {
              ((List)localObject1).add(localObject10);
              i = 1;
            }
            j = i;
            if (k == 0) {
              break label1229;
            }
            ((List)localObject8).add(localObject10);
            i = 1;
            break label1231;
          }
          j = i;
          if (((QCallRecent)localObject10).type != 56938) {
            break label1229;
          }
          localObject11 = ((PhoneContactManager)localObject5).b(((QCallRecent)localObject10).uin);
          if ((localObject11 == null) || (!((FriendsManager)localObject4).b(((PhoneContact)localObject11).uin))) {
            break label1244;
          }
          j = 1;
          label327:
          if ((localObject11 == null) || (TextUtils.isEmpty(((PhoneContact)localObject11).uin))) {
            break label1249;
          }
          k = 1;
          label345:
          if (j != 0)
          {
            ((List)localObject7).add(localObject10);
            i = 1;
          }
          j = i;
          if (k == 0) {
            break label1229;
          }
          ((List)localObject6).add(localObject10);
          i = 1;
          break label1231;
        }
        localObject9 = ((List)localObject1).iterator();
        if (!((Iterator)localObject9).hasNext()) {
          break;
        }
        localObject4 = (QCallRecent)((Iterator)localObject9).next();
        localObject10 = ((QCallRecent)localObject4).uin;
        this.this$0.a((QCallRecent)localObject4);
        localObject1 = ((PhoneContactManager)localObject5).c((String)localObject10);
        if (localObject1 == null) {
          continue;
        }
        this.this$0.a((QCallRecent)localObject4);
        localObject11 = ((PhoneContact)localObject1).uin;
        int[] arrayOfInt = UinTypeUtil.c;
        k = arrayOfInt.length;
        localObject1 = null;
        j = 0;
        if (j < k)
        {
          m = arrayOfInt[j];
          localObject1 = this.this$0.b((String)localObject11, m);
          if (localObject1 == null) {}
        }
        else
        {
          if (localObject1 == null) {
            break label639;
          }
          if (((QCallRecent)localObject4).lastCallTime <= ((QCallRecent)localObject1).lastCallTime) {
            break label618;
          }
          ((QCallRecent)localObject4).uin = ((String)localObject11);
          ((QCallRecent)localObject4).type = ((QCallRecent)localObject1).type;
          ((QCallRecent)localObject4).troopUin = ((QCallRecent)localObject1).troopUin;
          j = ((QCallRecent)localObject4).missedCallCount;
          ((QCallRecent)localObject1).missedCallCount += j;
          localObject1 = localObject4;
          this.this$0.a((String)localObject10, 1006, (String)localObject11, ((QCallRecent)localObject1).type);
          this.this$0.d((QCallRecent)localObject1);
        }
      }
      j += 1;
      continue;
      label618:
      j = localObject2.missedCallCount;
      localObject2.missedCallCount = (((QCallRecent)localObject4).missedCallCount + j);
      continue;
      label639:
      ((QCallRecent)localObject4).uin = ((String)localObject11);
      ((QCallRecent)localObject4).type = 0;
      localObject3 = localObject4;
    }
    Object localObject3 = ((List)localObject8).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (QCallRecent)((Iterator)localObject3).next();
      this.this$0.a((QCallRecent)localObject4);
      this.this$0.a(((QCallRecent)localObject4).uin, ((QCallRecent)localObject4).type);
    }
    Object localObject7 = ((List)localObject7).iterator();
    while (((Iterator)localObject7).hasNext())
    {
      localObject4 = (QCallRecent)((Iterator)localObject7).next();
      localObject3 = ((PhoneContactManager)localObject5).b(((QCallRecent)localObject4).uin);
      if (localObject3 != null)
      {
        this.this$0.a((QCallRecent)localObject4);
        localObject8 = ((PhoneContact)localObject3).mobileCode;
        localObject9 = ((PhoneContact)localObject3).uin;
        localObject10 = UinTypeUtil.c;
        k = localObject10.length;
        localObject3 = null;
        j = 0;
      }
    }
    for (;;)
    {
      if (j < k)
      {
        m = localObject10[j];
        localObject3 = this.this$0.b((String)localObject9, m);
        if (localObject3 == null) {}
      }
      else
      {
        if (localObject3 != null) {
          if (((QCallRecent)localObject4).lastCallTime > ((QCallRecent)localObject3).lastCallTime)
          {
            ((QCallRecent)localObject4).uin = ((String)localObject9);
            ((QCallRecent)localObject4).type = ((QCallRecent)localObject3).type;
            ((QCallRecent)localObject4).troopUin = ((QCallRecent)localObject3).troopUin;
            j = ((QCallRecent)localObject4).missedCallCount;
            ((QCallRecent)localObject3).missedCallCount += j;
            localObject3 = localObject4;
          }
        }
        for (;;)
        {
          this.this$0.a((String)localObject8, 1006, (String)localObject9, ((QCallRecent)localObject3).type);
          this.this$0.d((QCallRecent)localObject3);
          break;
          j = ((QCallRecent)localObject3).missedCallCount;
          ((QCallRecent)localObject4).missedCallCount += j;
          continue;
          ((QCallRecent)localObject4).uin = ((String)localObject9);
          ((QCallRecent)localObject4).type = 0;
          localObject3 = localObject4;
        }
        localObject3 = ((List)localObject6).iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (QCallRecent)((Iterator)localObject3).next();
          localObject6 = ((QCallRecent)localObject4).uin;
          localObject7 = ((PhoneContactManager)localObject5).b((String)localObject6);
          if (localObject7 != null)
          {
            this.this$0.a((QCallRecent)localObject4);
            localObject7 = ((PhoneContact)localObject7).mobileCode;
            this.this$0.a((String)localObject6, 56938, (String)localObject7, 1006);
            ((QCallRecent)localObject4).uin = ((String)localObject7);
            ((QCallRecent)localObject4).type = 1006;
            this.this$0.d((QCallRecent)localObject4);
          }
        }
        label1090:
        if ((j != 0) && (this.a != null))
        {
          localObject3 = new ArrayList();
          localObject4 = QCallProxy.a(this.this$0).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (QCallRecent)((Iterator)localObject4).next();
            if ((localObject5 == null) || (((QCallRecent)localObject5).uin == null) || (((QCallRecent)localObject5).uin.length() < 2)) {
              Utils.a("QCallProxy");
            }
            if ((localObject5 != null) && (((QCallRecent)localObject5).uin != null) && (((QCallRecent)localObject5).uin.length() >= 2)) {
              ((List)localObject3).add(localObject5);
            }
          }
          this.a.a((List)localObject3);
        }
        return;
        label1229:
        i = j;
        label1231:
        break;
        label1234:
        j = 0;
        break label226;
        label1239:
        k = 0;
        break label244;
        label1244:
        j = 0;
        break label327;
        label1249:
        k = 0;
        break label345;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy.5
 * JD-Core Version:    0.7.0.1
 */