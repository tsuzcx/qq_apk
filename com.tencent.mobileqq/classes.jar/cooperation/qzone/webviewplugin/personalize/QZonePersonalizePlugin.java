package cooperation.qzone.webviewplugin.personalize;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import anlx;
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
  private BroadcastReceiver a = new anlx(this);
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("QZoneCardPreDownload");
    localIntentFilter.addAction("action_facade_qzone2js");
    BaseApplication.getContext().registerReceiver(this.a, localIntentFilter);
  }
  
  public void b()
  {
    BaseApplication.getContext().unregisterReceiver(this.a);
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "qzcardstorre", "QzAvatar", "QzFloat" };
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 2L) && (paramString.equals(QZoneFloatJsHandleLogic.a))) {
      QZoneFloatJsHandleLogic.a(this.mRuntime, null);
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePersonalizePlugin", 2, "handleJsRequest \n url: " + paramString1 + "\n pkgName:" + paramString2 + "\n method:" + paramString3);
    }
    if (QZoneJsConstants.a(paramString3)) {
      LocalMultiProcConfig.putBool("qzone_force_refresh", true);
    }
    if (paramString2.equals("qzcardstorre"))
    {
      if (paramString3.equals("closecardpreview")) {
        return true;
      }
      if (paramString3.equals("setcardfinish")) {
        QZoneCardJsHandleLogic.a(this, this.mRuntime, paramVarArgs);
      }
      if (paramString3.equals("downloadcard"))
      {
        QZoneCardJsHandleLogic.a(this.mRuntime, paramVarArgs);
        return true;
      }
    }
    else
    {
      if (!paramString2.equals("QzAvatar")) {
        break label202;
      }
      if (!paramString3.equals("downloadAvatar")) {
        break label156;
      }
      QZoneFacadeJsHandleLogic.b(this.mRuntime, paramVarArgs);
    }
    label156:
    label202:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (paramString3.equals("setAvatar")) {
            QZoneFacadeJsHandleLogic.a(this.mRuntime, paramVarArgs);
          } else if (paramString3.equalsIgnoreCase("checkIdList")) {
            QZoneFacadeJsHandleLogic.c(this.mRuntime, new String[0]);
          }
        }
      } while (!paramString2.equals("QzFloat"));
      if (paramString3.equals("downloadFloat"))
      {
        QZoneFloatJsHandleLogic.a(this.mRuntime, paramVarArgs);
        return true;
      }
    } while (!paramString3.equals("setFloat"));
    QZoneFloatJsHandleLogic.b(this.mRuntime, paramVarArgs);
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZonePersonalizePlugin
 * JD-Core Version:    0.7.0.1
 */