import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public final class lyz
  implements Runnable
{
  public lyz(AppRuntime paramAppRuntime, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new Bundle();
      Object localObject2 = (TicketManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(2);
      Object localObject3 = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
      localObject2 = ((TicketManager)localObject2).getSkey(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
      ((Bundle)localObject1).putString("Cookie", "uin=o" + (String)localObject3 + "; skey=" + (String)localObject2);
      ((Bundle)localObject1).putString("User-Agent", ReadInJoyWebDataManager.d());
      ((Bundle)localObject1).putString("qq", this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
      ((Bundle)localObject1).putString("bid", "2");
      ((Bundle)localObject1).putString("logArray", this.jdField_a_of_type_JavaLangString);
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("BUNDLE", localObject1);
      ((HashMap)localObject3).put("CONTEXT", BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "sendLog :content :" + this.jdField_a_of_type_JavaLangString);
      }
      localObject1 = new lza(this);
      new HttpWebCgiAsyncTask2("http://node.kandian.qq.com/cgi/stats/multy?g_tk=" + ReadInJoyWebDataManager.a((String)localObject2), "POST", (HttpWebCgiAsyncTask.Callback)localObject1, 0, null).execute(new HashMap[] { localObject3 });
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("ReadInJoyWebDataManager", 2, "sendLog:request err " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyz
 * JD-Core Version:    0.7.0.1
 */