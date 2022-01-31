import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class muz
  implements HttpWebCgiAsyncTask.Callback
{
  muz(muy parammuy) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null) {
      if (QLog.isColorLevel()) {
        QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:return result :" + paramJSONObject);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:return result null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     muz
 * JD-Core Version:    0.7.0.1
 */