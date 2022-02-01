package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

class TroopFeedsDataManager$3$2
  implements Runnable
{
  TroopFeedsDataManager$3$2(TroopFeedsDataManager.3 param3, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.b.a.g);
    localObject2 = TroopFeedParserHelper.a((JSONObject)localObject1, ((StringBuilder)localObject2).toString(), this.b.a.f.getCurrentAccountUin());
    localObject1 = (List)localObject2[0];
    localObject2 = (List)localObject2[1];
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return;
      }
      Object localObject3 = localObject1.toString();
      int i = ((List)localObject1).size() - 1;
      Object localObject4;
      while (i >= 0)
      {
        localObject4 = (String)((List)localObject1).get(i);
        if (!this.b.a.k.containsKey(localObject4)) {
          ((List)localObject1).remove(localObject4);
        }
        i -= 1;
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("cgi callback ids, beforeFilter:");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append("|afterFilter ids:");
        ((StringBuilder)localObject4).append(localObject1.toString());
        QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, ((StringBuilder)localObject4).toString());
      }
      this.b.a.k.clear();
      localObject3 = this.b.a.i.obtainMessage(4);
      ((Message)localObject3).obj = this.b.a.a((List)localObject1, (List)localObject2);
      this.b.a.i.sendMessage((Message)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.2
 * JD-Core Version:    0.7.0.1
 */