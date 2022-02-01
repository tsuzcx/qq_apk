package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class QZonePublishVoiceShuoShuoH5Plugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  public static final String TAG = "QZonePublishVoiceShuoShuoH5Plugin";
  private static int count;
  public static QZonePublishVoiceShuoShuoH5Plugin my;
  private String voicePanelCallback = null;
  
  public QZonePublishVoiceShuoShuoH5Plugin()
  {
    my = this;
  }
  
  public static void onDeleteAudioVoice(String paramString)
  {
    Object localObject = my;
    if ((localObject != null) && (((QZonePublishVoiceShuoShuoH5Plugin)localObject).parentPlugin != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onDeleteAudioVoice");
      localObject = my.parentPlugin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("window.moodVoice.onVoiceDelete('");
      localStringBuilder.append(paramString);
      localStringBuilder.append("')");
      ((WebViewPlugin)localObject).callJs(localStringBuilder.toString());
    }
  }
  
  public static void onNotifyH5CutCancel()
  {
    QZonePublishVoiceShuoShuoH5Plugin localQZonePublishVoiceShuoShuoH5Plugin = my;
    if ((localQZonePublishVoiceShuoShuoH5Plugin != null) && (localQZonePublishVoiceShuoShuoH5Plugin.parentPlugin != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onNotifyH5CutCancel");
      my.parentPlugin.callJs("window.moodVoice.cutCancel()");
    }
  }
  
  public static void onNotifyH5RecordOk()
  {
    QZonePublishVoiceShuoShuoH5Plugin localQZonePublishVoiceShuoShuoH5Plugin = my;
    if ((localQZonePublishVoiceShuoShuoH5Plugin != null) && (localQZonePublishVoiceShuoShuoH5Plugin.parentPlugin != null)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePublishVoiceShuoShuoH5Plugin
 * JD-Core Version:    0.7.0.1
 */