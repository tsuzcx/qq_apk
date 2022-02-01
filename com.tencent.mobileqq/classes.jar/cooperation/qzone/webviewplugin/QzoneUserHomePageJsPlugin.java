package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.util.QZLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneUserHomePageJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String ACTION_OPEN_KAPU_HOST_MESSAGE_SETTING = "QzoneUserHome.ACTION_openKapuHostMsg";
  public static final String ACTION_OPEN_MESSAGE_BOARD = "QzoneUserHome.ACTION_openMsgBoard";
  private static final int CLOSE_MESSAGE_BOARD = 0;
  public static final String KEY_KAPU_HOST_MESSAGE_SETTING = "text";
  public static final String KEY_OPEN_MESSAGE_BOARD = "openMsgBoard";
  public static final String KEY_UPDATE_MESSAGE_BOARD = "updateMsgBoard";
  public static String PKG_NAME = "Qzone";
  public static final String TAG = "QzoneUserHomePageJsPlugin";
  public static final int UPDATE_MSG_COUNT = 1;
  public static final int UPDATE_MSG_COUNT_AND_BULLET_SCREEN = 2;
  
  private void handleSetKapuHostMessage(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    String str = "";
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return;
      }
      Activity localActivity = paramWebViewPlugin.mRuntime.d();
      if (localActivity != null)
      {
        if (localActivity.isFinishing()) {
          return;
        }
        try
        {
          paramWebViewPlugin = new JSONObject(paramArrayOfString[0]).optString("text", "");
        }
        catch (JSONException paramWebViewPlugin)
        {
          QZLog.e("QzoneUserHomePageJsPlugin", "handleSetMessageBoardGate: parse json data error", paramWebViewPlugin);
          paramWebViewPlugin = str;
        }
        paramArrayOfString = new Intent("QzoneUserHome.ACTION_openKapuHostMsg");
        paramArrayOfString.putExtra("text", paramWebViewPlugin);
        localActivity.sendBroadcast(paramArrayOfString);
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("handleSetKapuHostMessage: sendBroadcast,text:");
        paramArrayOfString.append(paramWebViewPlugin);
        QZLog.i("QzoneUserHomePageJsPlugin", 2, paramArrayOfString.toString());
      }
    }
  }
  
  private boolean handleSetMessageBoardGate(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.d();
      if (paramWebViewPlugin != null)
      {
        if (paramWebViewPlugin.isFinishing()) {
          return false;
        }
        bool2 = bool3;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        bool2 = bool3;
        if (paramArrayOfString.optInt("open_msg_board", 0) != 0) {
          break label181;
        }
        bool2 = bool1;
        i = paramArrayOfString.optInt("update_msg_board", 1);
      }
      catch (JSONException paramArrayOfString)
      {
        QZLog.e("QzoneUserHomePageJsPlugin", "handleSetMessageBoardGate: parse json data error", paramArrayOfString);
        i = 1;
        bool1 = bool2;
      }
      paramArrayOfString = new Intent("QzoneUserHome.ACTION_openMsgBoard");
      paramArrayOfString.putExtra("openMsgBoard", bool1);
      paramArrayOfString.putExtra("updateMsgBoard", i);
      paramWebViewPlugin.sendBroadcast(paramArrayOfString);
      paramWebViewPlugin = new StringBuilder();
      paramWebViewPlugin.append("handleSetMessageBoardGate: sendBroadcast,isOpenMsgBoard:");
      paramWebViewPlugin.append(bool1);
      paramWebViewPlugin.append(" ,updateType：");
      paramWebViewPlugin.append(i);
      QZLog.i("QzoneUserHomePageJsPlugin", 2, paramWebViewPlugin.toString());
      return true;
      return false;
      label181:
      bool1 = true;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals(PKG_NAME)) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (QZoneJsConstants.METHOD_SETTING_MESSAGE_BOARD_GATE.equalsIgnoreCase(paramString3))
      {
        handleSetMessageBoardGate(this.parentPlugin, paramVarArgs);
        return true;
      }
      if (QZoneJsConstants.METHOD_SETTING_KAPU_HOST_MESSAGE.equalsIgnoreCase(paramString3))
      {
        handleSetKapuHostMessage(this.parentPlugin, paramVarArgs);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUserHomePageJsPlugin
 * JD-Core Version:    0.7.0.1
 */