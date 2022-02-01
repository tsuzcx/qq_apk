package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.RecordAndChangeVoiceService;
import org.json.JSONException;
import org.json.JSONObject;

public class QZonePublishSecretShuoShuoH5Plugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  public static final int NOTIFY_EDIT_LEFT = 3;
  public static final int NOTIFY_EDIT_RIGHT = 4;
  public static final int NOTIFY_H5_CANCEL = 6;
  public static final int NOTIFY_H5_OK = 1;
  public static final int NOTIFY_RIGHT_BTN = 2;
  public static final String TAG = "QZonePublishSecretShuoShuoH5Plugin";
  public static QZonePublishSecretShuoShuoH5Plugin my = null;
  private BroadcastReceiver msgBrocastReceiver = new QZonePublishSecretShuoShuoH5Plugin.1(this);
  
  private void dispatchTasks(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return;
    case 1: 
      onNotifyH5RecordOk();
      return;
    case 2: 
      onRightButtonClick();
      return;
    case 3: 
      onEditLeftButtonClick();
      return;
    case 4: 
      onEditRightButtonClick();
      return;
    }
    onNotifyH5RecordCancel();
  }
  
  private void registerReceiver()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.syncSecretShuoshuoMsg");
      this.parentPlugin.mRuntime.a().registerReceiver(this.msgBrocastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QZonePublishSecretShuoShuoH5Plugin", 1, "registerMsgReceiver----", localException);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int k = 0;
    int j = 0;
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    do
    {
      return false;
      if (paramString3.equalsIgnoreCase("updateFeedsAndPopup"))
      {
        paramJsBridgeListener = this.parentPlugin.mRuntime.a();
        if ((paramJsBridgeListener instanceof QzonePublishSecretShuoShuoH5PluginInterface)) {
          ((QzonePublishSecretShuoShuoH5PluginInterface)paramJsBridgeListener).updateFeedAndPopup();
        }
        return true;
      }
      if (paramString3.equalsIgnoreCase("editTitleButtons"))
      {
        paramJsBridgeListener = this.parentPlugin.mRuntime.a();
        if ((paramJsBridgeListener instanceof QzonePublishSecretShuoShuoH5PluginInterface)) {
          ((QzonePublishSecretShuoShuoH5PluginInterface)paramJsBridgeListener).editTitleButtons();
        }
        return true;
      }
      if (paramString3.equalsIgnoreCase("getMoodVoiceRecordTime"))
      {
        paramString1 = "";
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1;
          if (paramString2 != null) {
            paramJsBridgeListener = paramString2.optString("callback");
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
            paramJsBridgeListener = paramString1;
          }
        }
        RecordAndChangeVoiceService.getInstance().getMoodVoiceRecordTime(paramJsBridgeListener, this);
        return true;
      }
      int i;
      if (paramString3.equalsIgnoreCase("playMoodVoice"))
      {
        paramString1 = "";
        paramJsBridgeListener = paramString1;
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          i = j;
          paramJsBridgeListener = paramString1;
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            paramString1 = paramString2.optString("callback");
            paramJsBridgeListener = paramString1;
            i = paramString2.optInt("voiceID");
            paramJsBridgeListener = paramString1;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            i = j;
          }
        }
        RecordAndChangeVoiceService.getInstance().playMoodVoice(paramJsBridgeListener, i, this);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getMoodVoiceData"))
      {
        paramString1 = "";
        paramJsBridgeListener = paramString1;
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          i = k;
          paramJsBridgeListener = paramString1;
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            paramString1 = paramString2.optString("callback");
            paramJsBridgeListener = paramString1;
            i = paramString2.optInt("voiceID");
            paramJsBridgeListener = paramString1;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            i = k;
          }
        }
        RecordAndChangeVoiceService.getInstance().getMoodVoiceData(paramJsBridgeListener, i, this);
        return true;
      }
      if (paramString3.equalsIgnoreCase("stopPlayingMoodVoice"))
      {
        RecordAndChangeVoiceService.getInstance().stopPlayingMoodVoice();
        return true;
      }
    } while (!paramString3.equalsIgnoreCase("didPublishMoodVoice"));
    paramJsBridgeListener = this.parentPlugin.mRuntime.a();
    if ((paramJsBridgeListener instanceof QZonePublishVoiceShuoShuoH5PluginInterface)) {
      ((QZonePublishVoiceShuoShuoH5PluginInterface)paramJsBridgeListener).didPushMoodVoice();
    }
    return true;
  }
  
  public void initRuntime(WebViewPlugin paramWebViewPlugin)
  {
    super.initRuntime(paramWebViewPlugin);
    registerReceiver();
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    default: 
      return;
    }
    if (paramInt == -1)
    {
      RecordAndChangeVoiceService.getInstance().onReceiveRecordData(paramIntent, 0);
      return;
    }
    onNotifyH5RecordCancel();
  }
  
  public void onDestroy()
  {
    try
    {
      this.parentPlugin.mRuntime.a().unregisterReceiver(this.msgBrocastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, localException, new Object[0]);
    }
  }
  
  public void onEditLeftButtonClick()
  {
    if (this.parentPlugin != null) {
      this.parentPlugin.callJs("window.secret.onEditLeftButtonClick()");
    }
  }
  
  public void onEditRightButtonClick()
  {
    if (this.parentPlugin != null) {
      this.parentPlugin.callJs("window.secret.onEditRightButtonClick()");
    }
  }
  
  public void onNotifyH5RecordCancel()
  {
    if (this.parentPlugin != null) {
      this.parentPlugin.callJs("try { window.QZMoodVoiceJSInterface.onRecordCancel() } catch (error) {}");
    }
  }
  
  public void onNotifyH5RecordOk()
  {
    if (this.parentPlugin != null) {
      this.parentPlugin.callJs("window.QZMoodVoiceJSInterface.onRecordDone()");
    }
  }
  
  public void onReplyGetMoodVoiceData(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("ret", 0);
        localJSONObject.put("voiceData", paramString2);
        localJSONObject.put("voiceFormat", "amr");
        paramString2 = localJSONObject.toString();
        if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null))
        {
          this.parentPlugin.mRuntime.a().callJs(paramString1, new String[] { paramString2 });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString1.getMessage());
      }
    }
  }
  
  public void onReplyGetMoodVoiceRecordTime(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("voiceTime", paramLong);
        localObject = ((JSONObject)localObject).toString();
        if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null))
        {
          this.parentPlugin.mRuntime.a().callJs(paramString, new String[] { localObject });
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString.getMessage());
      }
    }
  }
  
  public void onReplyPlayMoodVoice(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("voiceTime", paramLong);
        localObject = ((JSONObject)localObject).toString();
        if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null))
        {
          this.parentPlugin.mRuntime.a().callJs(paramString, new String[] { localObject });
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString.getMessage());
      }
    }
  }
  
  public void onRightButtonClick()
  {
    if (this.parentPlugin != null) {
      this.parentPlugin.callJs("window.secret.onRightButtonClick()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePublishSecretShuoShuoH5Plugin
 * JD-Core Version:    0.7.0.1
 */