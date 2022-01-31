package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneVideoEditPlugin
  extends QzoneInternalWebViewPlugin
{
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("getVideoEditMusicInfo")) {
      return false;
    }
    try
    {
      if (this.a.mRuntime.a() != null)
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if (paramJsBridgeListener != null)
        {
          paramString1 = new Intent("action_music_info_js_to_qzone");
          paramString1.putExtra("key_music_url", paramJsBridgeListener.optString("music_url", ""));
          paramString1.putExtra("key_is_paly_music", paramJsBridgeListener.optInt("is_select_music", 0));
          paramString1.putExtra("key_song_id", paramJsBridgeListener.optString("songid", ""));
          paramString1.putExtra("key_song_interval", paramJsBridgeListener.optString("interval", ""));
          BaseApplicationImpl.getApplication().getSharedPreferences("sp_is_cancel_from_music", 4).edit().putBoolean("sp_is_cancel_from_music_key", false).commit();
          this.a.mRuntime.a().sendBroadcast(paramString1);
        }
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVideoEditPlugin
 * JD-Core Version:    0.7.0.1
 */