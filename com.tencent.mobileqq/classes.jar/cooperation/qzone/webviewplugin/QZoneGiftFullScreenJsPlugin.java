package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneGiftFullScreenActionManager;
import cooperation.qzone.QzoneGiftFullScreenViewController;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.io.File;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneGiftFullScreenJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  public static final String NAMESPACE = "Qzone";
  public static final String QZONE_GIFTDETAILPAGE_URL = "https://h5.qzone.qq.com/gift/detail?_wv=2097155&_proxy=1&uin={uin}&ugcid={ugcid}";
  private static final String TAG = "QZoneGiftFullScreenJsPlugin";
  private String downloadCMD = "";
  private QzoneGiftFullScreenViewController giftController = null;
  
  private void checkGift(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    String str = "";
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = 0;
      if (paramArrayOfString[0] != null)
      {
        try
        {
          paramPluginRuntime = new JSONObject(paramArrayOfString[0]);
          paramWebViewPlugin = paramPluginRuntime.getString("giftid");
          try
          {
            paramPluginRuntime = paramPluginRuntime.getString("callback");
          }
          catch (JSONException paramPluginRuntime) {}
          paramPluginRuntime.printStackTrace();
        }
        catch (JSONException paramPluginRuntime)
        {
          paramWebViewPlugin = "";
        }
        paramPluginRuntime = str;
        if (!TextUtils.isEmpty(paramWebViewPlugin))
        {
          if (TextUtils.isEmpty(paramPluginRuntime)) {
            return;
          }
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append(QzoneGiftFullScreenActionManager.getGiftFullScreenFolderPath(paramWebViewPlugin));
          paramArrayOfString.append(MagicfaceResLoader.a());
          paramWebViewPlugin = new File(paramArrayOfString.toString());
          int i = j;
          if (paramWebViewPlugin.exists())
          {
            i = j;
            if (paramWebViewPlugin.isDirectory()) {
              i = 1;
            }
          }
          if (this.parentPlugin != null)
          {
            paramWebViewPlugin = new StringBuilder();
            paramWebViewPlugin.append("window.");
            paramWebViewPlugin.append(paramPluginRuntime);
            paramWebViewPlugin.append("({checkGift:");
            paramWebViewPlugin.append(i);
            paramWebViewPlugin.append("})");
            paramWebViewPlugin = paramWebViewPlugin.toString();
            this.parentPlugin.callJs(paramWebViewPlugin);
          }
        }
      }
    }
  }
  
  private void downloadGift(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.b().getHandler(QzoneDeviceTagJsPlugin.class).post(new QZoneGiftFullScreenJsPlugin.1(this, paramArrayOfString));
  }
  
  private void playGift(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    Object localObject = "";
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null))
    {
      try
      {
        paramPluginRuntime = new JSONObject(paramArrayOfString[0]);
        paramWebViewPlugin = paramPluginRuntime.getString("giftid");
        try
        {
          paramPluginRuntime = paramPluginRuntime.getString("callback");
        }
        catch (JSONException paramPluginRuntime) {}
        paramPluginRuntime.printStackTrace();
      }
      catch (JSONException paramPluginRuntime)
      {
        paramWebViewPlugin = "";
      }
      paramPluginRuntime = (WebViewPlugin.PluginRuntime)localObject;
      if (!TextUtils.isEmpty(paramWebViewPlugin))
      {
        if (TextUtils.isEmpty(paramPluginRuntime)) {
          return;
        }
        paramArrayOfString = QzoneGiftFullScreenActionManager.getGiftFullScreenFolderPath(paramWebViewPlugin);
        localObject = new File(paramArrayOfString);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          this.giftController = new QzoneGiftFullScreenViewController(this.parentPlugin.mRuntime.d());
          if (QzoneGiftFullScreenViewController.isSupportMagicface()) {
            this.giftController.playMaigcface(paramWebViewPlugin, paramArrayOfString, new QZoneGiftFullScreenJsPlugin.2(this, paramPluginRuntime));
          }
        }
      }
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934601L)
    {
      Object localObject = QzoneConfig.getInstance().getConfig("H5Url", "GiftDetailPage", "https://h5.qzone.qq.com/gift/detail?_wv=2097155&_proxy=1&uin={uin}&ugcid={ugcid}");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i = ((String)localObject).indexOf("?");
        if (i != -1)
        {
          localObject = ((String)localObject).substring(0, i);
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith((String)localObject)))
          {
            localObject = this.giftController;
            if (localObject != null) {
              ((QzoneGiftFullScreenViewController)localObject).onBackEvent();
            }
          }
        }
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("Qzone".equals(paramString2)) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ("checkGift".equalsIgnoreCase(paramString3))
      {
        checkGift(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("downloadGift".equalsIgnoreCase(paramString3))
      {
        RemoteHandleManager.getInstance().addWebEventListener(this);
        downloadGift(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("playGift".equalsIgnoreCase(paramString3))
      {
        playGift(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneGiftFullScreenJsPlugin", 2, "call js function,bundle is empty");
        }
        return;
      }
      if ("cmd.downloadGift".equals(paramString))
      {
        int i = paramBundle.getInt("Gift_DownloadProgress_FullScreen");
        if (i > 0)
        {
          if (i < 100)
          {
            double d = i;
            Double.isNaN(d);
            paramString = String.format("%.1f", new Object[] { Double.valueOf(d * 0.01D) });
          }
          else
          {
            paramString = "1";
          }
        }
        else {
          paramString = "-1";
        }
        if ((this.parentPlugin != null) && (!TextUtils.isEmpty(this.downloadCMD)))
        {
          paramBundle = new StringBuilder();
          paramBundle.append("window.");
          paramBundle.append(this.downloadCMD);
          paramBundle.append("({downloadGift:");
          paramBundle.append(paramString);
          paramBundle.append("})");
          paramString = paramBundle.toString();
          this.parentPlugin.callJs(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */