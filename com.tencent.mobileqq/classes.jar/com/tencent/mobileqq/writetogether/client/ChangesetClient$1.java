package com.tencent.mobileqq.writetogether.client;

import com.tencent.mobileqq.writetogether.WriteTogetherOidbObserver;
import com.tencent.mobileqq.writetogether.data.GetChangesetsResp;
import com.tencent.mobileqq.writetogether.data.GetChangesetsResp.Change;
import com.tencent.mobileqq.writetogether.websocket.msg.NewChangesMsg.Data;
import com.tencent.qphone.base.util.QLog;
import java.util.TreeSet;

class ChangesetClient$1
  extends WriteTogetherOidbObserver
{
  ChangesetClient$1(ChangesetClient paramChangesetClient) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "onPullPad");
    }
    if (!(paramObject instanceof GetChangesetsResp)) {
      return;
    }
    paramObject = (GetChangesetsResp)paramObject;
    if (paramBoolean)
    {
      int k = paramObject.changes.length;
      int j = 0;
      int i = 0;
      NewChangesMsg.Data localData;
      if ((k > 0) && (paramObject.changes[0].a.newRev > this.a.b + 1))
      {
        QLog.w("ChangesetClient", 1, "get newer cs, store it");
        paramObject = paramObject.changes;
        j = paramObject.length;
        while (i < j)
        {
          localData = paramObject[i];
          this.a.d.add(localData.a);
          i += 1;
        }
        return;
      }
      paramObject = paramObject.changes;
      k = paramObject.length;
      i = j;
      while (i < k)
      {
        localData = paramObject[i].a;
        if (localData.newRev <= this.a.b)
        {
          QLog.w("ChangesetClient", 1, "get duplicate cs");
        }
        else
        {
          if (localData.newRev > this.a.b + 1)
          {
            QLog.e("ChangesetClient", 1, "get broken cs");
            break;
          }
          ChangesetClient.a(this.a, localData);
        }
        i += 1;
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.ChangesetClient.1
 * JD-Core Version:    0.7.0.1
 */