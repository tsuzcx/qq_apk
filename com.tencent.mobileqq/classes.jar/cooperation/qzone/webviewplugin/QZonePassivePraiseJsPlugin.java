package cooperation.qzone.webviewplugin;

import NS_QMALL_COVER.AlbumThemeSkin;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import avlx;
import bgve;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
  public static final String NAMESPACE = "Qzone";
  public static final String QZONE_GIFTDETAILPAGE_URL = "https://h5.qzone.qq.com/gift/detail?_wv=2097155&_proxy=1&uin={uin}&ugcid={ugcid}";
  private static final String TAG = "QZoneGiftFullScreenJsPlugin";
  private String downloadCMD = "";
  private QzoneGiftFullScreenViewController giftController;
  
  private void chageAlbumTheme(WebViewPlugin paramWebViewPlugin, bgve parambgve, String[] paramArrayOfString)
  {
    AlbumThemeSkin localAlbumThemeSkin;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null))
    {
      parambgve = "";
      localAlbumThemeSkin = new AlbumThemeSkin();
      paramWebViewPlugin = parambgve;
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        paramWebViewPlugin = parambgve;
        localAlbumThemeSkin.iItemId = paramArrayOfString.getInt("itemId");
        paramWebViewPlugin = parambgve;
        if (localAlbumThemeSkin.iItemId != -1) {
          continue;
        }
        paramWebViewPlugin = parambgve;
        RemoteHandleManager.getInstance().getSender().setAlbumTheme(0L, localAlbumThemeSkin);
      }
      catch (JSONException parambgve)
      {
        parambgve.printStackTrace();
        parambgve = paramWebViewPlugin;
        continue;
      }
      if (TextUtils.isEmpty(parambgve)) {}
      return;
      paramWebViewPlugin = parambgve;
      localAlbumThemeSkin.strPicZipUrl = paramArrayOfString.getString("zipurl");
      paramWebViewPlugin = parambgve;
      localAlbumThemeSkin.iColor = paramArrayOfString.getInt("icolor");
      paramWebViewPlugin = parambgve;
      localAlbumThemeSkin.lTabBarSelectedFontColor = paramArrayOfString.getLong("tabBarFontColorSelected");
      paramWebViewPlugin = parambgve;
      localAlbumThemeSkin.lTabBarUnselectedFontColor = paramArrayOfString.getLong("tabBarFontColor");
      paramWebViewPlugin = parambgve;
      localAlbumThemeSkin.lVideoButonColor = paramArrayOfString.getLong("videoButonColor");
      paramWebViewPlugin = parambgve;
      localAlbumThemeSkin.lVideoButtonBgColor = paramArrayOfString.getLong("videoButtonBgColor");
      paramWebViewPlugin = parambgve;
      localAlbumThemeSkin.lTabbarUnderLineColor = paramArrayOfString.getLong("tabbarUnderLineColor");
      paramWebViewPlugin = parambgve;
      RemoteHandleManager.getInstance().getSender().setAlbumTheme(0L, localAlbumThemeSkin);
      paramWebViewPlugin = parambgve;
      paramArrayOfString = paramArrayOfString.getString("callback");
      parambgve = paramArrayOfString;
      paramWebViewPlugin = paramArrayOfString;
      if (this.parentPlugin != null)
      {
        paramWebViewPlugin = paramArrayOfString;
        parambgve = "window." + paramArrayOfString + "({})";
        paramWebViewPlugin = paramArrayOfString;
        this.parentPlugin.callJs(parambgve);
        parambgve = paramArrayOfString;
      }
    }
  }
  
  private void checkAnimationRs(WebViewPlugin paramWebViewPlugin, bgve parambgve, String[] paramArrayOfString)
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
          parambgve = new JSONObject(paramArrayOfString[0]);
          paramWebViewPlugin = parambgve.getString("zipUrl");
          parambgve.printStackTrace();
        }
        catch (JSONException parambgve)
        {
          try
          {
            parambgve = parambgve.getString("callback");
            if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(parambgve))) {
              break;
            }
            return;
          }
          catch (JSONException parambgve)
          {
            for (;;)
            {
              continue;
              int i = 0;
            }
          }
          parambgve = parambgve;
          paramWebViewPlugin = "";
        }
        parambgve = str;
      }
      paramWebViewPlugin = paramWebViewPlugin.replace("sbig", avlx.a());
      paramWebViewPlugin = new File(QzoneGiftFullScreenActionManager.getPassiveFullScreenFolderPath(MD5Utils.toMD5(paramWebViewPlugin)) + avlx.a());
      if ((!paramWebViewPlugin.exists()) || (!paramWebViewPlugin.isDirectory())) {
        break;
      }
      i = 1;
    } while (this.parentPlugin == null);
    paramWebViewPlugin = "window." + parambgve + "({checked:" + i + "})";
    this.parentPlugin.callJs(paramWebViewPlugin);
  }
  
  private void downloadAnimationRs(WebViewPlugin paramWebViewPlugin, bgve parambgve, String[] paramArrayOfString)
  {
    parambgve.a().getHandler(QzoneDeviceTagJsPlugin.class).post(new QZonePassivePraiseJsPlugin.1(this, paramArrayOfString));
  }
  
  private void playAnimation(WebViewPlugin paramWebViewPlugin, bgve parambgve, String[] paramArrayOfString)
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
            parambgve = new JSONObject(paramArrayOfString[0]);
            paramWebViewPlugin = parambgve.getString("zipUrl");
            parambgve.printStackTrace();
          }
          catch (JSONException parambgve)
          {
            try
            {
              parambgve = parambgve.getString("callback");
              if (!TextUtils.isEmpty(parambgve)) {
                break;
              }
              return;
            }
            catch (JSONException parambgve)
            {
              break label56;
            }
            parambgve = parambgve;
            paramWebViewPlugin = "";
          }
          parambgve = (bgve)localObject;
        }
        paramArrayOfString = QzoneGiftFullScreenActionManager.getPassiveFullScreenFolderPath(MD5Utils.toMD5(paramWebViewPlugin.replace("sbig", avlx.a())));
        localObject = new File(paramArrayOfString);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      this.giftController = new QzoneGiftFullScreenViewController(this.parentPlugin.mRuntime.a());
    } while (!QzoneGiftFullScreenViewController.isSupportMagicface());
    this.giftController.playMaigcface(paramWebViewPlugin, paramArrayOfString, true, new QZonePassivePraiseJsPlugin.2(this, parambgve));
  }
  
  private void refreshPassiveFeeds()
  {
    RemoteHandleManager.getInstance().getSender().refreshPassiveFeeds();
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
    if ("checkAnimationRs".equalsIgnoreCase(paramString3))
    {
      checkAnimationRs(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("downloadAnimationRs".equalsIgnoreCase(paramString3))
    {
      RemoteHandleManager.getInstance().addWebEventListener(this);
      downloadAnimationRs(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("playAnimation".equalsIgnoreCase(paramString3))
    {
      playAnimation(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("SetAlbumListThemeSkin".equalsIgnoreCase(paramString3))
    {
      chageAlbumTheme(this.parentPlugin, this.parentPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("hasClickedHighFiveFromLikeList".equalsIgnoreCase(paramString3))
    {
      refreshPassiveFeeds();
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
      else if ("cmd.downloadPassivePraise".equals(paramString))
      {
        int i = paramBundle.getInt("Gift_DownloadProgress_FullScreen");
        paramString = "-1";
        if (i > 0) {
          if (i >= 100) {
            break label162;
          }
        }
        label162:
        for (paramString = String.format("%.1f", new Object[] { Double.valueOf(i * 0.01D) }); (this.parentPlugin != null) && (!TextUtils.isEmpty(this.downloadCMD)); paramString = "1")
        {
          paramString = "window." + this.downloadCMD + "({download:" + paramString + "})";
          this.parentPlugin.callJs(paramString);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin
 * JD-Core Version:    0.7.0.1
 */