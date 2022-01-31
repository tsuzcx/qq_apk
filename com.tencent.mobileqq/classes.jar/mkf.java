import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAllInOneBar;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class mkf
  implements HttpWebCgiAsyncTask.Callback
{
  public mkf(ReadInJoyAllInOneBar paramReadInJoyAllInOneBar) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((paramInt != 1000) || (paramJSONObject != null)) {}
    for (;;)
    {
      try
      {
        if (paramJSONObject.optInt("ret") == 0) {
          break label61;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e(ReadInJoyAllInOneBar.a, 1, "requestCode == REQUEST_CODE_COMMENT. parse result failed. result=" + paramJSONObject);
        return;
      }
      ReadInJoyAllInOneBar.a(this.a, bool);
      return;
      label61:
      boolean bool = true;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkf
 * JD-Core Version:    0.7.0.1
 */