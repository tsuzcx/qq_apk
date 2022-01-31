import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class lcb
  extends QIPCModule
{
  private lcd a;
  
  private lcb()
  {
    super("AioShareMusicIPCWebClient");
  }
  
  public static lcb a()
  {
    return lce.a();
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
  
  public void a(lcd paramlcd)
  {
    if (this.a != null) {}
    for (;;)
    {
      return;
      try
      {
        lcb locallcb = a();
        this.a = paramlcd;
        QIPCClientHelper.getInstance().register(locallcb);
        if (QLog.isColorLevel())
        {
          QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "register real");
          return;
        }
      }
      catch (Exception paramlcd)
      {
        QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "register ipc module error.", paramlcd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     lcb
 * JD-Core Version:    0.7.0.1
 */