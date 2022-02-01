package cooperation.qzone.webviewplugin.personalize;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import bieh;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.Map;

public class QZonePersonalizePlugin
  extends WebViewPlugin
  implements bieh
{
  public static final String CARDTAG = "QZoneCardLogic";
  public static final String TAG = "QZonePersonalizePlugin";
  private BroadcastReceiver preDownloadBrocastReceiver = new QZonePersonalizePlugin.1(this);
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "qzcardstorre", "QzAvatar", "QzFloat" };
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 2L) && (paramString.equals(QZoneFloatJsHandleLogic.url))) {
      QZoneFloatJsHandleLogic.handleDownLoadFloatFinish(this.mRuntime, null);
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePersonalizePlugin", 2, "handleJsRequest \n url: " + paramString1 + "\n pkgName:" + paramString2 + "\n method:" + paramString3);
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
    else
    {
      if (!paramString2.equals("QzAvatar")) {
        break label208;
      }
      if (!paramString3.equals("downloadAvatar")) {
        break label162;
      }
      QZoneFacadeJsHandleLogic.handleDownloadFacadeFinish(this.mRuntime, paramVarArgs);
    }
    label162:
    label208:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (paramString3.equals("setAvatar")) {
            QZoneFacadeJsHandleLogic.handleSetFacadeFinish(this.mRuntime, paramVarArgs);
          } else if (paramString3.equalsIgnoreCase("checkIdList")) {
            QZoneFacadeJsHandleLogic.handleCheckDownloadedIdList(this.mRuntime, new String[0]);
          }
        }
      } while (!paramString2.equals("QzFloat"));
      if (paramString3.equals("downloadFloat"))
      {
        QZoneFloatJsHandleLogic.handleDownLoadFloatFinish(this.mRuntime, paramVarArgs);
        return true;
      }
    } while (!paramString3.equals("setFloat"));
    QZoneFloatJsHandleLogic.handleSetFloatFinish(this.mRuntime, paramVarArgs);
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    registerBroadcastReceiver();
  }
  
  public void onDestroy()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZonePersonalizePlugin
 * JD-Core Version:    0.7.0.1
 */