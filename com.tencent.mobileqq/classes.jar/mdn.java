import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class mdn
  implements HttpWebCgiAsyncTask.Callback
{
  mdn(mdm parammdm) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    QLog.w("ReadInJoyWebDataManager", 2, Long.toString(Thread.currentThread().getId()));
    if (paramJSONObject != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.w("ReadInJoyWebDataManager", 2, "sendLog result:" + paramJSONObject.toString());
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("ReadInJoyWebDataManager", 2, "sendLog result Exception :" + paramJSONObject);
        return;
      }
    }
    QLog.w("ReadInJoyWebDataManager", 2, "sendLog result null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdn
 * JD-Core Version:    0.7.0.1
 */