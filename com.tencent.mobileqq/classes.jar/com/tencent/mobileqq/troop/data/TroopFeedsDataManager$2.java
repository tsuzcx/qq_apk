package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

class TroopFeedsDataManager$2
  implements Runnable
{
  TroopFeedsDataManager$2(TroopFeedsDataManager paramTroopFeedsDataManager, List paramList, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = new Bundle();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.this$0.g);
    ((Bundle)localObject1).putString("qid", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("fnum", "1");
    ((Bundle)localObject1).putString("fids", this.this$0.a(this.a));
    ((Bundle)localObject1).putString("ver", "8.8.17");
    ((Bundle)localObject1).putString("src", "1");
    ((Bundle)localObject1).putString("platform", "android");
    TroopFeedsDataManager.a(this.this$0, (Bundle)localObject1);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("BUNDLE", localObject1);
    this.this$0.f.getApplication();
    ((HashMap)localObject2).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("https://web.qun.qq.com/cgi-bin/notice/get_data_new", "GET", this.this$0.j, this.b, null, true).execute(new HashMap[] { localObject2 });
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get feed from server start: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("TroopFeedsDataManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.2
 * JD-Core Version:    0.7.0.1
 */