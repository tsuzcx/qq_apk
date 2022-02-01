package com.tencent.mobileqq.qcall;

import android.text.TextUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
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
    int i;
    int j;
    int k;
    label1217:
    label1222:
    label1227:
    label1232:
    label1237:
    label1242:
    label1249:
    label1252:
    label1259:
    label1262:
    label1268:
    label1276:
    synchronized (QCallProxy.b(this.this$0))
    {
      Object localObject3 = new ArrayList();
      Object localObject7 = new ArrayList();
      Object localObject6 = new ArrayList();
      Object localObject4 = new ArrayList();
      Object localObject1 = (IPhoneContactService)QCallProxy.c(this.this$0).getRuntimeService(IPhoneContactService.class, "");
      Object localObject5 = (FriendsManager)QCallProxy.d(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject1 != null) && (((IPhoneContactService)localObject1).isBindContactOk()) && (localObject5 != null))
      {
        Object localObject8 = QCallProxy.b(this.this$0).iterator();
        i = 0;
        Object localObject9;
        Object localObject10;
        while (((Iterator)localObject8).hasNext())
        {
          localObject9 = (QCallRecent)((Iterator)localObject8).next();
          if ((localObject9 != null) && (((QCallRecent)localObject9).uin != null) && (((QCallRecent)localObject9).uin.length() >= 2)) {
            if (((QCallRecent)localObject9).type == 1006)
            {
              localObject10 = ((IPhoneContactService)localObject1).queryContactByCodeNumber(((QCallRecent)localObject9).uin);
              if ((localObject10 == null) || (!((FriendsManager)localObject5).n(((PhoneContact)localObject10).uin))) {
                break label1217;
              }
              j = 1;
              if ((localObject10 == null) || (!TextUtils.isEmpty(((PhoneContact)localObject10).uin))) {
                break label1222;
              }
              k = 1;
              if (j != 0)
              {
                ((List)localObject3).add(localObject9);
                i = 1;
              }
              if (k != 0)
              {
                ((List)localObject7).add(localObject9);
                break label1227;
              }
            }
            else if (((QCallRecent)localObject9).type == 56938)
            {
              localObject10 = ((IPhoneContactService)localObject1).queryPhoneContactByMobile(((QCallRecent)localObject9).uin);
              if ((localObject10 == null) || (!((FriendsManager)localObject5).n(((PhoneContact)localObject10).uin))) {
                break label1232;
              }
              j = 1;
              if ((localObject10 == null) || (TextUtils.isEmpty(((PhoneContact)localObject10).uin))) {
                break label1237;
              }
              k = 1;
              if (j != 0)
              {
                ((List)localObject6).add(localObject9);
                i = 1;
              }
              if (k != 0)
              {
                ((List)localObject4).add(localObject9);
                break label1227;
              }
            }
          }
        }
        localObject8 = ((List)localObject3).iterator();
        int m;
        if (((Iterator)localObject8).hasNext())
        {
          localObject5 = (QCallRecent)((Iterator)localObject8).next();
          localObject9 = ((QCallRecent)localObject5).uin;
          this.this$0.a((QCallRecent)localObject5);
          localObject3 = ((IPhoneContactService)localObject1).queryContactByCodeNumber((String)localObject9);
          if (localObject3 == null) {
            break label1249;
          }
          this.this$0.a((QCallRecent)localObject5);
          localObject10 = ((PhoneContact)localObject3).uin;
          int[] arrayOfInt = UinTypeUtil.d;
          k = arrayOfInt.length;
          j = 0;
          localObject3 = null;
          if (j < k)
          {
            m = arrayOfInt[j];
            localObject3 = this.this$0.d((String)localObject10, m);
            if (localObject3 == null) {
              break label1242;
            }
          }
          if (localObject3 != null)
          {
            if (((QCallRecent)localObject5).lastCallTime > ((QCallRecent)localObject3).lastCallTime)
            {
              ((QCallRecent)localObject5).uin = ((String)localObject10);
              ((QCallRecent)localObject5).type = ((QCallRecent)localObject3).type;
              ((QCallRecent)localObject5).troopUin = ((QCallRecent)localObject3).troopUin;
              ((QCallRecent)localObject5).missedCallCount += ((QCallRecent)localObject3).missedCallCount;
              localObject3 = localObject5;
            }
            else
            {
              ((QCallRecent)localObject3).missedCallCount += ((QCallRecent)localObject5).missedCallCount;
            }
          }
          else
          {
            ((QCallRecent)localObject5).uin = ((String)localObject10);
            ((QCallRecent)localObject5).type = 0;
            localObject3 = localObject5;
          }
          this.this$0.a((String)localObject9, 1006, (String)localObject10, ((QCallRecent)localObject3).type);
          this.this$0.d((QCallRecent)localObject3);
          break label1249;
        }
        else
        {
          localObject3 = ((List)localObject7).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (QCallRecent)((Iterator)localObject3).next();
            this.this$0.a((QCallRecent)localObject5);
            this.this$0.b(((QCallRecent)localObject5).uin, ((QCallRecent)localObject5).type);
          }
          localObject6 = ((List)localObject6).iterator();
          localObject3 = localObject1;
          if (((Iterator)localObject6).hasNext())
          {
            localObject5 = (QCallRecent)((Iterator)localObject6).next();
            localObject1 = ((IPhoneContactService)localObject3).queryPhoneContactByMobile(((QCallRecent)localObject5).uin);
            if (localObject1 == null) {
              break label1262;
            }
            this.this$0.a((QCallRecent)localObject5);
            localObject7 = ((PhoneContact)localObject1).mobileCode;
            localObject8 = ((PhoneContact)localObject1).uin;
            localObject9 = UinTypeUtil.d;
            k = localObject9.length;
            j = 0;
            localObject1 = null;
            if (j < k)
            {
              m = localObject9[j];
              localObject1 = this.this$0.d((String)localObject8, m);
              if (localObject1 == null) {
                break label1252;
              }
            }
            if (localObject1 != null)
            {
              if (((QCallRecent)localObject5).lastCallTime > ((QCallRecent)localObject1).lastCallTime)
              {
                ((QCallRecent)localObject5).uin = ((String)localObject8);
                ((QCallRecent)localObject5).type = ((QCallRecent)localObject1).type;
                ((QCallRecent)localObject5).troopUin = ((QCallRecent)localObject1).troopUin;
                ((QCallRecent)localObject5).missedCallCount += ((QCallRecent)localObject1).missedCallCount;
                localObject1 = localObject5;
                break label1259;
              }
              ((QCallRecent)localObject1).missedCallCount += ((QCallRecent)localObject5).missedCallCount;
              break label1259;
            }
            ((QCallRecent)localObject5).uin = ((String)localObject8);
            ((QCallRecent)localObject5).type = 0;
            localObject1 = localObject5;
            this.this$0.a((String)localObject7, 1006, (String)localObject8, ((QCallRecent)localObject1).type);
            this.this$0.d((QCallRecent)localObject1);
            break label1262;
          }
          localObject1 = ((List)localObject4).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1268;
            }
            localObject4 = (QCallRecent)((Iterator)localObject1).next();
            localObject5 = ((QCallRecent)localObject4).uin;
            localObject6 = ((IPhoneContactService)localObject3).queryPhoneContactByMobile((String)localObject5);
            if (localObject6 == null) {
              break;
            }
            this.this$0.a((QCallRecent)localObject4);
            localObject6 = ((PhoneContact)localObject6).mobileCode;
            this.this$0.a((String)localObject5, 56938, (String)localObject6, 1006);
            ((QCallRecent)localObject4).uin = ((String)localObject6);
            ((QCallRecent)localObject4).type = 1006;
            this.this$0.d((QCallRecent)localObject4);
          }
          if ((i != 0) && (this.a != null))
          {
            localObject1 = new ArrayList();
            localObject3 = QCallProxy.b(this.this$0).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (QCallRecent)((Iterator)localObject3).next();
              if ((localObject4 == null) || (((QCallRecent)localObject4).uin == null) || (((QCallRecent)localObject4).uin.length() < 2)) {
                Utils.a("QCallProxy");
              }
              if ((localObject4 == null) || (((QCallRecent)localObject4).uin == null)) {
                break label1276;
              }
              if (((QCallRecent)localObject4).uin.length() >= 2) {
                ((List)localObject1).add(localObject4);
              }
            }
            this.a.a((List)localObject1);
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallProxy.5
 * JD-Core Version:    0.7.0.1
 */