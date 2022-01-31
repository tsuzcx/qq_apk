import android.os.Handler;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import org.json.JSONObject;

public class qib
  implements TVK_SDKMgr.InstallListener
{
  private Handler a;
  
  public qib(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onInstallProgress(float paramFloat)
  {
    if (this.a != null) {
      this.a.sendEmptyMessage(2);
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.2.6");
      localJSONObject.put("error_code", paramInt);
      label25:
      ndn.a(null, null, "0X8009752", "0X8009752", 0, 0, "0", pza.a(false), String.valueOf(paramInt), localJSONObject.toString(), false);
      ndn.a(null, null, "0X8009753", "0X8009753", 0, 0, "0", pza.a(false), String.valueOf(paramInt), localJSONObject.toString(), false);
      if (this.a != null) {
        this.a.sendEmptyMessage(1);
      }
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public void onInstalledSuccessed()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.2.6");
      label17:
      ndn.a(null, null, "0X8009753", "0X8009753", 0, 0, "1", pza.a(false), "", localJSONObject.toString(), false);
      if (this.a != null) {
        this.a.sendEmptyMessage(0);
      }
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qib
 * JD-Core Version:    0.7.0.1
 */