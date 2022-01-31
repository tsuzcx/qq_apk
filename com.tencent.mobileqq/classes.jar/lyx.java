import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class lyx
  implements Runnable
{
  public lyx(ReadInJoyWebDataManager paramReadInJoyWebDataManager, String paramString1, String paramString2, lzc paramlzc, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      Object localObject3 = (QQAppInterface)ReadInJoyUtils.a();
      if (localObject3 == null) {
        return;
      }
      Object localObject1 = new Bundle();
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject3).getManager(2);
      Object localObject2 = ((QQAppInterface)localObject3).getAccount();
      localObject3 = localTicketManager.getSkey(((QQAppInterface)localObject3).getCurrentAccountUin());
      ((Bundle)localObject1).putString("Cookie", "uin=o" + (String)localObject2 + "; skey=" + (String)localObject3);
      ((Bundle)localObject1).putString("User-Agent", ReadInJoyWebDataManager.d());
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("BUNDLE", localObject1);
      ((HashMap)localObject2).put("CONTEXT", BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:url :" + this.jdField_a_of_type_JavaLangString);
      }
      localObject1 = new lyy(this);
      new HttpWebCgiAsyncTask2(this.jdField_a_of_type_JavaLangString, "GET", (HttpWebCgiAsyncTask.Callback)localObject1, 0, null).execute(new HashMap[] { localObject2 });
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:request err " + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyx
 * JD-Core Version:    0.7.0.1
 */