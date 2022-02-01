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
    String str;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      str = "";
    }
    do
    {
      for (;;)
      {
        try
        {
          paramPluginRuntime = new JSONObject(paramArrayOfString[0]);
          paramWebViewPlugin = paramPluginRuntime.getString("giftid");
          paramPluginRuntime.printStackTrace();
        }
        catch (JSONException paramPluginRuntime)
        {
          try
          {
            paramPluginRuntime = paramPluginRuntime.getString("callback");
            if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(paramPluginRuntime))) {
              break;
            }
            return;
          }
          catch (JSONException paramPluginRuntime)
          {
            for (;;)
            {
              continue;
              int i = 0;
            }
          }
          paramPluginRuntime = paramPluginRuntime;
          paramWebViewPlugin = "";
        }
        paramPluginRuntime = str;
      }
      paramWebViewPlugin = new File(QzoneGiftFullScreenActionManager.getGiftFullScreenFolderPath(paramWebViewPlugin) + MagicfaceResLoader.a());
      if ((!paramWebViewPlugin.exists()) || (!paramWebViewPlugin.isDirectory())) {
        break;
      }
      i = 1;
    } while (this.parentPlugin == null);
    paramWebViewPlugin = "window." + paramPluginRuntime + "({checkGift:" + i + "})";
    this.parentPlugin.callJs(paramWebViewPlugin);
  }
  
  private void downloadGift(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.a().getHandler(QzoneDeviceTagJsPlugin.class).post(new QZoneGiftFullScreenJsPlugin.1(this, paramArrayOfString));
  }
  
  private void playGift(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      localObject = "";
    }
    label63:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            paramPluginRuntime = new JSONObject(paramArrayOfString[0]);
            paramWebViewPlugin = paramPluginRuntime.getString("giftid");
            paramPluginRuntime.printStackTrace();
          }
          catch (JSONException paramPluginRuntime)
          {
            try
            {
              paramPluginRuntime = paramPluginRuntime.getString("callback");
              if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(paramPluginRuntime))) {
                break;
              }
              return;
            }
            catch (JSONException paramPluginRuntime)
            {
              break label63;
            }
            paramPluginRuntime = paramPluginRuntime;
            paramWebViewPlugin = "";
          }
          paramPluginRuntime = (WebViewPlugin.PluginRuntime)localObject;
        }
        paramArrayOfString = QzoneGiftFullScreenActionManager.getGiftFullScreenFolderPath(paramWebViewPlugin);
        localObject = new File(paramArrayOfString);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      this.giftController = new QzoneGiftFullScreenViewController(this.parentPlugin.mRuntime.a());
    } while (!QzoneGiftFullScreenViewController.isSupportMagicface());
    this.giftController.playMaigcface(paramWebViewPlugin, paramArrayOfString, new QZoneGiftFullScreenJsPlugin.2(this, paramPluginRuntime));
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934601L)
    {
      String str = QzoneConfig.getInstance().getConfig("H5Url", "GiftDetailPage", "https://h5.qzone.qq.com/gift/detail?_wv=2097155&_proxy=1&uin={uin}&ugcid={ugcid}");
      if (!TextUtils.isEmpty(str))
      {
        int i = str.indexOf("?");
        if (i != -1)
        {
          str = str.substring(0, i);
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str)) && (this.giftController != null)) {
            this.giftController.onBackEvent();
          }
        }
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {
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
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    for (;;)
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneGiftFullScreenJsPlugin", 2, "call js function,bundle is empty");
        }
      }
      else if ("cmd.downloadGift".equals(paramString))
      {
        int i = paramBundle.getInt("Gift_DownloadProgress_FullScreen");
        paramString = "-1";
        if (i > 0) {
          if (i >= 100) {
            break label159;
          }
        }
        label159:
        for (paramString = String.format("%.1f", new Object[] { Double.valueOf(i * 0.01D) }); (this.parentPlugin != null) && (!TextUtils.isEmpty(this.downloadCMD)); paramString = "1")
        {
          paramString = "window." + this.downloadCMD + "({downloadGift:" + paramString + "})";
          this.parentPlugin.callJs(paramString);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */