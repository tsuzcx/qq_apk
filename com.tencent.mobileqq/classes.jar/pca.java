import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import org.json.JSONObject;

public class pca
  implements HttpWebCgiAsyncTask.Callback
{
  public pca(QQMapRoutingHelper paramQQMapRoutingHelper) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.a.post(new pcb(this, paramJSONObject, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pca
 * JD-Core Version:    0.7.0.1
 */