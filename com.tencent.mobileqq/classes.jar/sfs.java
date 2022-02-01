import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.6;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class sfs
  implements bghi
{
  public sfs(ReadInJoyWebDataManager.6 param6) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfs
 * JD-Core Version:    0.7.0.1
 */