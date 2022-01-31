import android.os.Bundle;
import com.tencent.biz.webviewplugin.HotchatPlugin;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;

public class pga
  extends Client.onRemoteRespObserver
{
  public pga(HotchatPlugin paramHotchatPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == HotchatPlugin.a(this.a).key))
    {
      String str1 = paramBundle.getString("cmd");
      String str2 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("request");
      if ((str1 != null) && ("ipc_hotchat_plugin".equals(str1)) && (paramBundle.getString("key_action").endsWith("updateFavoriteFlag")))
      {
        int i = paramBundle.getInt("result", 1);
        this.a.callJs(str2, new String[] { Integer.toString(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pga
 * JD-Core Version:    0.7.0.1
 */