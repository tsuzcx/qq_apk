import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import org.json.JSONObject;

public class pdu
  implements HttpWebCgiAsyncTask.Callback
{
  public pdu(QQMapRoutingHelper paramQQMapRoutingHelper) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.a.post(new pdv(this, paramJSONObject, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdu
 * JD-Core Version:    0.7.0.1
 */