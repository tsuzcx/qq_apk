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
    int j = 0;
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetClient", 2, "onPullPad");
    }
    if (!(paramObject instanceof GetChangesetsResp)) {}
    NewChangesMsg.Data localData;
    for (;;)
    {
      return;
      paramObject = (GetChangesetsResp)paramObject;
      if (paramBoolean)
      {
        if ((paramObject.changes.length <= 0) || (paramObject.changes[0].a.newRev <= this.a.jdField_a_of_type_Int + 1)) {
          break;
        }
        QLog.w("ChangesetClient", 1, "get newer cs, store it");
        paramObject = paramObject.changes;
        j = paramObject.length;
        while (i < j)
        {
          localData = paramObject[i];
          this.a.jdField_a_of_type_JavaUtilTreeSet.add(localData.a);
          i += 1;
        }
      }
    }
    paramObject = paramObject.changes;
    int k = paramObject.length;
    i = j;
    if (i < k)
    {
      localData = paramObject[i].a;
      if (localData.newRev <= this.a.jdField_a_of_type_Int) {
        QLog.w("ChangesetClient", 1, "get duplicate cs");
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (localData.newRev > this.a.jdField_a_of_type_Int + 1)
      {
        QLog.e("ChangesetClient", 1, "get broken cs");
        this.a.b();
        return;
      }
      ChangesetClient.a(this.a, localData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.ChangesetClient.1
 * JD-Core Version:    0.7.0.1
 */