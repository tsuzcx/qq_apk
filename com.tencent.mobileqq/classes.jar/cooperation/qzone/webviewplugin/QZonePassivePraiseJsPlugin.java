package cooperation.qzone.webviewplugin;

import NS_QMALL_COVER.AlbumThemeSkin;
import amll;
import amlm;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneGiftFullScreenActionManager;
import cooperation.qzone.QzoneGiftFullScreenViewController;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import java.io.File;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QZonePassivePraiseJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  private QzoneGiftFullScreenViewController jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController;
  private String jdField_a_of_type_JavaLangString = "";
  
  private void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
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
          paramWebViewPlugin = paramPluginRuntime.getString("zipUrl");
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
      paramWebViewPlugin = paramWebViewPlugin.replace("sbig", MagicfaceResLoader.a());
      paramWebViewPlugin = new File(QzoneGiftFullScreenActionManager.b(MD5Utils.d(paramWebViewPlugin)) + MagicfaceResLoader.a());
      if ((!paramWebViewPlugin.exists()) || (!paramWebViewPlugin.isDirectory())) {
        break;
      }
      i = 1;
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null);
    paramWebViewPlugin = "window." + paramPluginRuntime + "({checked:" + i + "})";
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramWebViewPlugin);
  }
  
  private void b(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    paramPluginRuntime.a().getHandler(QzoneDeviceTagJsPlugin.class).post(new amll(this, paramArrayOfString));
  }
  
  private void c(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      localObject = "";
    }
    label56:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            paramPluginRuntime = new JSONObject(paramArrayOfString[0]);
            paramWebViewPlugin = paramPluginRuntime.getString("zipUrl");
            paramPluginRuntime.printStackTrace();
          }
          catch (JSONException paramPluginRuntime)
          {
            try
            {
              paramPluginRuntime = paramPluginRuntime.getString("callback");
              if (!TextUtils.isEmpty(paramPluginRuntime)) {
                break;
              }
              return;
            }
            catch (JSONException paramPluginRuntime)
            {
              break label56;
            }
            paramPluginRuntime = paramPluginRuntime;
            paramWebViewPlugin = "";
          }
          paramPluginRuntime = (WebViewPlugin.PluginRuntime)localObject;
        }
        paramArrayOfString = QzoneGiftFullScreenActionManager.b(MD5Utils.d(paramWebViewPlugin.replace("sbig", MagicfaceResLoader.a())));
        localObject = new File(paramArrayOfString);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController = new QzoneGiftFullScreenViewController(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
    } while (!QzoneGiftFullScreenViewController.a());
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.a(paramWebViewPlugin, paramArrayOfString, true, new amlm(this, paramPluginRuntime));
  }
  
  private void d(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    AlbumThemeSkin localAlbumThemeSkin;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null))
    {
      paramPluginRuntime = "";
      localAlbumThemeSkin = new AlbumThemeSkin();
      paramWebViewPlugin = paramPluginRuntime;
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        paramWebViewPlugin = paramPluginRuntime;
        localAlbumThemeSkin.iItemId = paramArrayOfString.getInt("itemId");
        paramWebViewPlugin = paramPluginRuntime;
        if (localAlbumThemeSkin.iItemId != -1) {
          continue;
        }
        paramWebViewPlugin = paramPluginRuntime;
        RemoteHandleManager.a().a().a(0L, localAlbumThemeSkin);
      }
      catch (JSONException paramPluginRuntime)
      {
        paramPluginRuntime.printStackTrace();
        paramPluginRuntime = paramWebViewPlugin;
        continue;
      }
      if (TextUtils.isEmpty(paramPluginRuntime)) {}
      return;
      paramWebViewPlugin = paramPluginRuntime;
      localAlbumThemeSkin.strPicZipUrl = paramArrayOfString.getString("zipurl");
      paramWebViewPlugin = paramPluginRuntime;
      localAlbumThemeSkin.iColor = paramArrayOfString.getInt("icolor");
      paramWebViewPlugin = paramPluginRuntime;
      localAlbumThemeSkin.lTabBarSelectedFontColor = paramArrayOfString.getLong("tabBarFontColorSelected");
      paramWebViewPlugin = paramPluginRuntime;
      localAlbumThemeSkin.lTabBarUnselectedFontColor = paramArrayOfString.getLong("tabBarFontColor");
      paramWebViewPlugin = paramPluginRuntime;
      localAlbumThemeSkin.lVideoButonColor = paramArrayOfString.getLong("videoButonColor");
      paramWebViewPlugin = paramPluginRuntime;
      localAlbumThemeSkin.lVideoButtonBgColor = paramArrayOfString.getLong("videoButtonBgColor");
      paramWebViewPlugin = paramPluginRuntime;
      localAlbumThemeSkin.lTabbarUnderLineColor = paramArrayOfString.getLong("tabbarUnderLineColor");
      paramWebViewPlugin = paramPluginRuntime;
      RemoteHandleManager.a().a().a(0L, localAlbumThemeSkin);
      paramWebViewPlugin = paramPluginRuntime;
      paramArrayOfString = paramArrayOfString.getString("callback");
      paramPluginRuntime = paramArrayOfString;
      paramWebViewPlugin = paramArrayOfString;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)
      {
        paramWebViewPlugin = paramArrayOfString;
        paramPluginRuntime = "window." + paramArrayOfString + "({})";
        paramWebViewPlugin = paramArrayOfString;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramPluginRuntime);
        paramPluginRuntime = paramArrayOfString;
      }
    }
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ("checkAnimationRs".equalsIgnoreCase(paramString3))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("downloadAnimationRs".equalsIgnoreCase(paramString3))
    {
      RemoteHandleManager.a().a(this);
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("playAnimation".equalsIgnoreCase(paramString3))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("SetAlbumListThemeSkin".equalsIgnoreCase(paramString3))
    {
      d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong, Map paramMap)
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
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str)) && (this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController != null)) {
            this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.b();
          }
        }
      }
    }
    return super.a(paramString, paramLong, paramMap);
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
      else if ("cmd.downloadPassivePraise".equals(paramString))
      {
        int i = paramBundle.getInt("Gift_DownloadProgress_FullScreen");
        paramString = "-1";
        if (i > 0) {
          if (i >= 100) {
            break label163;
          }
        }
        label163:
        for (paramString = String.format("%.1f", new Object[] { Double.valueOf(i * 0.01D) }); (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)); paramString = "1")
        {
          paramString = "window." + this.jdField_a_of_type_JavaLangString + "({download:" + paramString + "})";
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin
 * JD-Core Version:    0.7.0.1
 */