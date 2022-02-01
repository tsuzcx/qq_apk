package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class QZonePublishVoiceShuoShuoH5Plugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  public static final String TAG = "QZonePublishVoiceShuoShuoH5Plugin";
  private static int count = 0;
  public static QZonePublishVoiceShuoShuoH5Plugin my = null;
  private String voicePanelCallback = null;
  
  public QZonePublishVoiceShuoShuoH5Plugin()
  {
    my = this;
  }
  
  public static void onDeleteAudioVoice(String paramString)
  {
    if ((my != null) && (my.parentPlugin != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onDeleteAudioVoice");
      my.parentPlugin.callJs("window.moodVoice.onVoiceDelete('" + paramString + "')");
    }
  }
  
  public static void onNotifyH5CutCancel()
  {
    if ((my != null) && (my.parentPlugin != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onNotifyH5CutCancel");
      my.parentPlugin.callJs("window.moodVoice.cutCancel()");
    }
  }
  
  public static void onNotifyH5RecordOk()
  {
    if ((my != null) && (my.parentPlugin != null)) {
      my.parentPlugin.callJs("window.QZMoodVoiceJSInterface.notifyGetVoiceRecordTime()");
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
  
  public void onDestroy()
  {
    my = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePublishVoiceShuoShuoH5Plugin
 * JD-Core Version:    0.7.0.1
 */