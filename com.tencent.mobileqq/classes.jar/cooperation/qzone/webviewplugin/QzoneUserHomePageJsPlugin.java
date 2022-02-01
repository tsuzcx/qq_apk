package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import bgve;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = paramWebViewPlugin.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    paramWebViewPlugin = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).optString("text", "");
      paramWebViewPlugin = paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        QZLog.e("QzoneUserHomePageJsPlugin", "handleSetMessageBoardGate: parse json data error", paramArrayOfString);
      }
    }
    paramArrayOfString = new Intent("QzoneUserHome.ACTION_openKapuHostMsg");
    paramArrayOfString.putExtra("text", paramWebViewPlugin);
    localActivity.sendBroadcast(paramArrayOfString);
    QZLog.i("QzoneUserHomePageJsPlugin", 2, "handleSetKapuHostMessage: sendBroadcast,text:" + paramWebViewPlugin);
  }
  
  private boolean handleSetMessageBoardGate(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    Activity localActivity = paramWebViewPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramWebViewPlugin = new JSONObject(paramArrayOfString[0]);
        i = paramWebViewPlugin.optInt("open_msg_board", 0);
        if (i == 0) {
          bool = false;
        }
      }
      catch (JSONException paramWebViewPlugin) {}
      try
      {
        i = paramWebViewPlugin.optInt("update_msg_board", 1);
        paramWebViewPlugin = new Intent("QzoneUserHome.ACTION_openMsgBoard");
        paramWebViewPlugin.putExtra("openMsgBoard", bool);
        paramWebViewPlugin.putExtra("updateMsgBoard", i);
        localActivity.sendBroadcast(paramWebViewPlugin);
        QZLog.i("QzoneUserHomePageJsPlugin", 2, "handleSetMessageBoardGate: sendBroadcast,isOpenMsgBoard:" + bool + " ,updateType：" + i);
        return true;
      }
      catch (JSONException paramWebViewPlugin)
      {
        break label149;
      }
      bool = true;
      continue;
      label149:
      QZLog.e("QzoneUserHomePageJsPlugin", "handleSetMessageBoardGate: parse json data error", paramWebViewPlugin);
      int i = 1;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals(PKG_NAME)) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUserHomePageJsPlugin
 * JD-Core Version:    0.7.0.1
 */