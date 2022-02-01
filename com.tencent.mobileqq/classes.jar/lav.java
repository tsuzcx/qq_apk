import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class lav
  extends QIPCModule
{
  private lax a;
  
  private lav()
  {
    super("AioShareMusicIPCWebClient");
  }
  
  public static lav a()
  {
    return lay.a();
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("AioShareMusicIPCMainClient", paramString, localBundle, paramEIPCResultCallback);
  }
  
  public void a()
  {
    try
    {
      this.a = null;
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
        if (QLog.isColorLevel()) {
          QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "unregister real");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "unregister ipc module error.", localException);
    }
  }
  
  public void a(lax paramlax)
  {
    if (this.a != null) {}
    for (;;)
    {
      return;
      try
      {
        lav locallav = a();
        this.a = paramlax;
        QIPCClientHelper.getInstance().register(locallav);
        if (QLog.isColorLevel())
        {
          QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "register real");
          return;
        }
      }
      catch (Exception paramlax)
      {
        QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "register ipc module error.", paramlax);
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    try
    {
      paramBundle = new JSONObject(paramBundle.getString("data"));
      if (this.a != null) {
        this.a.a(paramString, paramBundle);
      }
      return null;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lav
 * JD-Core Version:    0.7.0.1
 */