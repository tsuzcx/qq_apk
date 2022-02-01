package com.tencent.mobileqq.kandian.biz.video;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONObject;

class ReadInJoyWebDataManager$5
  implements Runnable
{
  ReadInJoyWebDataManager$5(ReadInJoyWebDataManager paramReadInJoyWebDataManager, String paramString1, String paramString2, ReadInJoyWebDataManager.HttpFetchBizCallback paramHttpFetchBizCallback, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      Object localObject3 = (QQAppInterface)RIJQQAppInterfaceUtil.a();
      if (localObject3 == null) {
        return;
      }
      Object localObject1 = new Bundle();
      Object localObject4 = (TicketManager)((QQAppInterface)localObject3).getManager(2);
      localObject2 = ((QQAppInterface)localObject3).getAccount();
      localObject3 = ((TicketManager)localObject4).getSkey(((QQAppInterface)localObject3).getCurrentAccountUin());
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("uin=o");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append("; skey=");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((Bundle)localObject1).putString("Cookie", ((StringBuilder)localObject4).toString());
      ((Bundle)localObject1).putString("User-Agent", ReadInJoyWebDataManager.a());
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("BUNDLE", localObject1);
      ((HashMap)localObject2).put("CONTEXT", BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doSendRequestWithExtraHeader:url :");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        QLog.w("ReadInJoyWebDataManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new ReadInJoyWebDataManager.5.1(this);
      new HttpWebCgiAsyncTask2(this.jdField_a_of_type_JavaLangString, "GET", (HttpWebCgiAsyncTask.Callback)localObject1, 0, null).executeOnExecutor(ThreadManagerV2.getNetExcutor(), new HashMap[] { localObject2 });
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doSendRequestWithExtraHeader:request err ");
        ((StringBuilder)localObject2).append(localException);
        QLog.w("ReadInJoyWebDataManager", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager.5
 * JD-Core Version:    0.7.0.1
 */