import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class lay
  extends QIPCModule
{
  private lba a;
  
  private lay()
  {
    super("AioShareMusicIPCWebClient");
  }
  
  public static lay a()
  {
    return lbb.a();
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
  
  public void a(lba paramlba)
  {
    if (this.a != null) {}
    for (;;)
    {
      return;
      try
      {
        lay locallay = a();
        this.a = paramlba;
        QIPCClientHelper.getInstance().register(locallay);
        if (QLog.isColorLevel())
        {
          QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "register real");
          return;
        }
      }
      catch (Exception paramlba)
      {
        QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "register ipc module error.", paramlba);
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
 * Qualified Name:     lay
 * JD-Core Version:    0.7.0.1
 */