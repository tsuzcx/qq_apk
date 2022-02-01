package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QzoneStringMatcher;
import cooperation.qzone.webviewplugin.famous.QzoneFamousShareJsPlugin;
import cooperation.qzone.webviewplugin.famous.QzoneHomePageJsPlugin;
import cooperation.qzone.webviewplugin.sound.QzoneSoundPlugin;
import cooperation.qzone.webviewplugin.ugcsetting.QzoneUgcSettingJsPlugin;
import java.util.Map;
import org.json.JSONObject;

public class QZoneWebViewPlugin
  extends WebViewPlugin
  implements MultiNameSpacePluginCompact
{
  public static final int RESULT_OK = -1;
  private static final String TAG = "QZoneWebViewPlugin";
  private QzoneInternalWebViewPlugin[] insidePlugins;
  private boolean needClearHistory;
  
  public static int generateRequestCode(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, int paramInt)
  {
    paramPluginRuntime = paramPluginRuntime.a(paramPluginRuntime.a());
    int i = paramInt;
    if ((paramPluginRuntime instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)paramPluginRuntime).switchRequestCode(paramWebViewPlugin, (byte)paramInt);
    }
    return i;
  }
  
  private boolean handleBanUrlOrScheme(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = this.mRuntime.a().getIntent();
        if ((localObject == null) || (!((Intent)localObject).getBooleanExtra("fromQZone", false))) {
          break label77;
        }
        bool = true;
        CustomWebView localCustomWebView = this.mRuntime.a();
        localObject = null;
        if (localCustomWebView != null) {
          localObject = localCustomWebView.getUrl();
        }
        bool = QzoneStringMatcher.needIgoreUrl((String)localObject, paramString, bool);
        if (bool) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZoneWebViewPlugin", 1, "handleBanUrlOrScheme error", paramString);
      }
      return false;
      label77:
      boolean bool = false;
    }
  }
  
  private void initInsidePlugins()
  {
    Object localObject = this.insidePlugins;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new QZonePublishSecretShuoShuoH5Plugin();
      int i = 0;
      this.insidePlugins = new QzoneInternalWebViewPlugin[] { localObject, new QzoneUgcSettingJsPlugin(), new QzoneVipPaymentJsPlugin(), new QzoneBlogJsPlugin(), new QzonePersonalizeJsPlugin(), new QzoneMoodPlugin(), new QzoneDeviceTagJsPlugin(), new QZoneFeedActionJsPlugin(), new QzoneDynamicAlbumPlugin(), new QzonePhotoWallPlugin(), new QZoneGiftFullScreenJsPlugin(), new QZonePassivePraiseJsPlugin(), new QzoneQunFeedJsPlugin(), new QzoneAlbumSelectJSPlugin(), new QzoneAlbumJsPlugin(), new QzoneReactMessageDeliverPlugin(), new QZoneLiveJsPlugin(), new QzoneVideoTabJsPlugin(), new QzoneFamousShareJsPlugin(), new QZoneEventTagJsPlugin(), new QzoneSettingJsPlugin(), new QzoneBasicJsPlugin(), new QzoneInterActiveVideoPlugin(), new QzoneUiJsPlugin(), new QZoneDNSAnalyzeJsPlugin(), new QzoneUploadPlugin(), new QzoneSoundPlugin(), new QZoneRedPocketGiftJsPlugin(), new QZoneSharePictureJsPlugin(), new QzoneCommonJsPlugin(), new QzoneBannerJsPlugin(), new QZonePublishVoiceShuoShuoH5Plugin(), new QzoneWanbaJsPlugin(), new QzoneHomePageJsPlugin(), new QzoneRecommedPhotoJsPlugin(), new QzoneUserHomePageJsPlugin(), new QZoneCategoryAlbumPlugin(), new QzoneNuanProfileJsPlugin(), new QZoneECLiveJsPlugin(), new AdvFloatVideoJsPlugin() };
      localObject = this.insidePlugins;
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].initRuntime(this);
        i += 1;
      }
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    super.callJs(paramString, paramVarArgs);
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "Qzone", "qzDynamicAlbum", "QZImagePicker", "qzlive", "qqexplive", "qzui", "QzoneUpload", "QzoneAudio", "Qzone", "checkin" };
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    if ((!"Qzone".equals(paramString)) && (!"qzDynamicAlbum".equals(paramString)) && (!"QZImagePicker".equals(paramString)) && (!"checkin".equals(paramString)) && (!"qzlive".equals(paramString)))
    {
      if ("gdtReportPlugin".equals(paramString)) {
        return 2L;
      }
      return super.getWebViewEventByNameSpace(paramString);
    }
    return 8589934591L;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    if ((!"Qzone".equals(paramString)) && (!"qzDynamicAlbum".equals(paramString)) && (!"QZImagePicker".equals(paramString)) && (!"checkin".equals(paramString)) && (!"qzlive".equals(paramString))) {
      return super.getWebViewSchemaByNameSpace(paramString);
    }
    return 4294967295L;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    initInsidePlugins();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.insidePlugins;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfQzoneInternalWebViewPlugin[i].handleEvent(paramString, paramLong);
      if (localObject != null) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934601L) && (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/sendGift/index.html")) || (paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/gift/mall.html"))))
    {
      paramString = new Intent();
      this.mRuntime.a().setResult(0, paramString);
      this.mRuntime.a().finish();
      return true;
    }
    initInsidePlugins();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.insidePlugins;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfQzoneInternalWebViewPlugin[i].handleEvent(paramString, paramLong, paramMap)) {
        return true;
      }
      i += 1;
    }
    if ((paramLong == 8589934594L) && (this.needClearHistory))
    {
      paramMap = null;
      if (this.mRuntime != null) {
        paramMap = this.mRuntime.a();
      }
      if (paramMap != null) {
        paramMap.clearHistory();
      }
      this.needClearHistory = false;
    }
    return (1024L == paramLong) && (handleBanUrlOrScheme(paramString));
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = paramString2.equals("Qzone");
    int i = 0;
    if ((!bool) && (!paramString2.equals("qzDynamicAlbum")) && (!paramString2.equals("QZImagePicker")) && (!paramString2.equals("qzlive")) && (!paramString2.equals("qzui")) && (!paramString2.equals("QzoneUpload")) && (!paramString2.equals("QzoneAudio")) && (!paramString2.equals("qqexplive")) && (!paramString2.equals("checkin"))) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleJsRequest pkgName: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",method: ");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("QZoneWebViewPlugin", 2, ((StringBuilder)localObject).toString());
    }
    initInsidePlugins();
    Object localObject = this.insidePlugins;
    int j = localObject.length;
    while (i < j)
    {
      if (localObject[i].handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs)) {
        return true;
      }
      i += 1;
    }
    return QZoneWebViewJsHandleLogic.disPatchMethod(this, this.mRuntime, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    initInsidePlugins();
    Object localObject = this.insidePlugins;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].onActivityResult(paramIntent, paramByte, paramInt);
      i += 1;
    }
    if (paramByte != 1)
    {
      if (paramByte != 3) {
        return;
      }
      if (paramInt != -1) {
        return;
      }
      try
      {
        localObject = paramIntent.getStringExtra("uin");
        paramIntent = paramIntent.getStringExtra("cellid");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", paramIntent);
        localJSONObject.put("uin", localObject);
        dispatchJsEvent("deleteMessageSuccess", localJSONObject, new JSONObject());
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if (paramInt == -1) {
      this.mRuntime.a().finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    initInsidePlugins();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.insidePlugins;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    while (i < j)
    {
      arrayOfQzoneInternalWebViewPlugin[i].onDestroy();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */