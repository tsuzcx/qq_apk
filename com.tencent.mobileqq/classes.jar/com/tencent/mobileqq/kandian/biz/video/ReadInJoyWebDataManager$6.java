package com.tencent.mobileqq.kandian.biz.video;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

final class ReadInJoyWebDataManager$6
  implements Runnable
{
  ReadInJoyWebDataManager$6(AppRuntime paramAppRuntime, String paramString) {}
  
  public void run()
  {
    try
    {
      localObject2 = new Bundle();
      Object localObject1 = (TicketManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(2);
      Object localObject3 = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
      localObject1 = ((TicketManager)localObject1).getSkey(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=o");
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append("; skey=");
      localStringBuilder.append((String)localObject1);
      ((Bundle)localObject2).putString("Cookie", localStringBuilder.toString());
      ((Bundle)localObject2).putString("User-Agent", ReadInJoyWebDataManager.a());
      ((Bundle)localObject2).putString("qq", this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
      ((Bundle)localObject2).putString("bid", "2");
      ((Bundle)localObject2).putString("logArray", this.jdField_a_of_type_JavaLangString);
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("BUNDLE", localObject2);
      ((HashMap)localObject3).put("CONTEXT", BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendLog :content :");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        QLog.w("ReadInJoyWebDataManager", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new ReadInJoyWebDataManager.6.1(this);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://node.kandian.qq.com/cgi/stats/multy?g_tk=");
      localStringBuilder.append(ReadInJoyWebDataManager.a((String)localObject1));
      new HttpWebCgiAsyncTask2(localStringBuilder.toString(), "POST", (HttpWebCgiAsyncTask.Callback)localObject2, 0, null).executeOnExecutor(ThreadManagerV2.getNetExcutor(), new HashMap[] { localObject3 });
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendLog:request err ");
        ((StringBuilder)localObject2).append(localException);
        QLog.w("ReadInJoyWebDataManager", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager.6
 * JD-Core Version:    0.7.0.1
 */