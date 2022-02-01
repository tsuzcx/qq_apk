package cooperation.qzone.webviewplugin.personalize;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.Map;

public class QZonePersonalizePlugin
  extends WebViewPlugin
  implements MultiNameSpacePluginCompact
{
  public static final String CARDTAG = "QZoneCardLogic";
  public static final String TAG = "QZonePersonalizePlugin";
  private BroadcastReceiver preDownloadBrocastReceiver = new QZonePersonalizePlugin.1(this);
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "qzcardstorre", "QzAvatar", "QzFloat" };
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    if ((!"qzcardstorre".equals(paramString)) && (!"QzAvatar".equals(paramString)) && (!"QzFloat".equals(paramString))) {
      return super.getWebViewEventByNameSpace(paramString);
    }
    return 2L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 2L) && (paramString.equals(QZoneFloatJsHandleLogic.url))) {
      QZoneFloatJsHandleLogic.handleDownLoadFloatFinish(this.mRuntime, null);
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest \n url: ");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append("\n pkgName:");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append("\n method:");
      paramJsBridgeListener.append(paramString3);
      QLog.d("QZonePersonalizePlugin", 2, paramJsBridgeListener.toString());
    }
    if (QZoneJsConstants.isForce(paramString3))
    {
      LocalMultiProcConfig.putBool("qzone_force_refresh", true);
      LocalMultiProcConfig.putBool("qzone_force_refresh_passive", true);
    }
    if (paramString2.equals("qzcardstorre"))
    {
      if (paramString3.equals("closecardpreview")) {
        return true;
      }
      if (paramString3.equals("setcardfinish")) {
        QZoneCardJsHandleLogic.handleSetSkinFinish(this, this.mRuntime, paramVarArgs);
      }
      if (paramString3.equals("downloadcard"))
      {
        QZoneCardJsHandleLogic.handleDownCardMethod(this.mRuntime, paramVarArgs);
        return true;
      }
    }
    else if (paramString2.equals("QzAvatar"))
    {
      if (paramString3.equals("downloadAvatar"))
      {
        QZoneFacadeJsHandleLogic.handleDownloadFacadeFinish(this.mRuntime, paramVarArgs);
        return false;
      }
      if (paramString3.equals("setAvatar"))
      {
        QZoneFacadeJsHandleLogic.handleSetFacadeFinish(this.mRuntime, paramVarArgs);
        return false;
      }
      if (paramString3.equalsIgnoreCase("checkIdList"))
      {
        QZoneFacadeJsHandleLogic.handleCheckDownloadedIdList(this.mRuntime, new String[0]);
        return false;
      }
    }
    else if (paramString2.equals("QzFloat"))
    {
      if (paramString3.equals("downloadFloat"))
      {
        QZoneFloatJsHandleLogic.handleDownLoadFloatFinish(this.mRuntime, paramVarArgs);
        return true;
      }
      if (paramString3.equals("setFloat"))
      {
        QZoneFloatJsHandleLogic.handleSetFloatFinish(this.mRuntime, paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    registerBroadcastReceiver();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unRegisterBroadcastReceiver();
  }
  
  public void registerBroadcastReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("QZoneCardPreDownload");
    localIntentFilter.addAction("action_facade_qzone2js");
    BaseApplication.getContext().registerReceiver(this.preDownloadBrocastReceiver, localIntentFilter);
  }
  
  public void unRegisterBroadcastReceiver()
  {
    BaseApplication.getContext().unregisterReceiver(this.preDownloadBrocastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZonePersonalizePlugin
 * JD-Core Version:    0.7.0.1
 */