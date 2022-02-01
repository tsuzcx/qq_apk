package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import org.json.JSONObject;

class TroopFeedsDataManager$3$1
  implements Runnable
{
  TroopFeedsDataManager$3$1(TroopFeedsDataManager.3 param3, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.b.a.g);
    localObject2 = TroopFeedParserHelper.a((JSONObject)localObject1, ((StringBuilder)localObject2).toString(), this.b.a.f.getCurrentAccountUin());
    localObject1 = (List)localObject2[0];
    localObject2 = (List)localObject2[1];
    ((List)localObject2).addAll(this.b.a.d);
    Message localMessage = this.b.a.i.obtainMessage(3);
    localMessage.obj = this.b.a.a((List)localObject1, (List)localObject2);
    this.b.a.i.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.1
 * JD-Core Version:    0.7.0.1
 */