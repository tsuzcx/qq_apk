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
  private boolean jdField_a_of_type_Boolean;
  private QzoneInternalWebViewPlugin[] jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
  
  public static int a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, int paramInt)
  {
    paramPluginRuntime = paramPluginRuntime.a(paramPluginRuntime.a());
    int i = paramInt;
    if ((paramPluginRuntime instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)paramPluginRuntime).a(paramWebViewPlugin, (byte)paramInt);
    }
    return i;
  }
  
  private void a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin == null) || (this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin.length == 0))
    {
      this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin = new QzoneInternalWebViewPlugin[] { new QZonePublishSecretShuoShuoH5Plugin(), new QzoneUgcSettingJsPlugin(), new QzoneVipPaymentJsPlugin(), new QzoneBlogJsPlugin(), new QzonePersonalizeJsPlugin(), new QzoneMoodPlugin(), new QzoneDeviceTagJsPlugin(), new QZoneFeedActionJsPlugin(), new QzoneDynamicAlbumPlugin(), new QzonePhotoWallPlugin(), new QZoneGiftFullScreenJsPlugin(), new QZonePassivePraiseJsPlugin(), new QzoneQunFeedJsPlugin(), new QzoneAlbumSelectJSPlugin(), new QzoneAlbumJsPlugin(), new QzoneReactMessageDeliverPlugin(), new QZoneLiveJsPlugin(), new QzoneVideoTabJsPlugin(), new QzoneFamousShareJsPlugin(), new QZoneEventTagJsPlugin(), new QzoneSettingJsPlugin(), new QzoneBasicJsPlugin(), new QzoneVideoEditPlugin(), new QzoneInterActiveVideoPlugin(), new QzoneUiJsPlugin(), new QZoneDNSAnalyzeJsPlugin(), new QzoneUploadPlugin(), new QzoneSoundPlugin(), new QZoneRedPocketGiftJsPlugin(), new QZoneSharePictureJsPlugin(), new QzoneCommonJsPlugin(), new QzoneAudioRecordPlugin(), new QzoneBannerJsPlugin(), new QZonePublishVoiceShuoShuoH5Plugin(), new QzoneWanbaJsPlugin(), new QzoneHomePageJsPlugin(), new QzoneRecommedPhotoJsPlugin(), new QzoneUserHomePageJsPlugin(), new QzoneWidgetAIJsPlugin(), new QZoneCategoryAlbumPlugin() };
      QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
      int j = arrayOfQzoneInternalWebViewPlugin.length;
      while (i < j)
      {
        arrayOfQzoneInternalWebViewPlugin[i].a(this);
        i += 1;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    try
    {
      Object localObject = this.mRuntime.a().getIntent();
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("fromQZone", false))) {}
      for (boolean bool = true;; bool = false)
      {
        CustomWebView localCustomWebView = this.mRuntime.a();
        localObject = null;
        if (localCustomWebView != null) {
          localObject = localCustomWebView.getUrl();
        }
        bool = QzoneStringMatcher.a((String)localObject, paramString, bool);
        if (!bool) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneWebViewPlugin", 1, "handleBanUrlOrScheme error", paramString);
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    super.callJs(paramString, paramVarArgs);
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "Qzone", "qzDynamicAlbum", "QZImagePicker", "qzlive", "qzui", "QzoneUpload", "QzoneAudio", "Qzone" };
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    a();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfQzoneInternalWebViewPlugin[i].a(paramString, paramLong);
      if (localObject != null) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934601L) && (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/sendGift/index.html")) || (paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/gift/mall.html"))))
    {
      paramString = new Intent();
      this.mRuntime.a().setResult(0, paramString);
      this.mRuntime.a().finish();
    }
    label114:
    do
    {
      return true;
      a();
      QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
      int j = arrayOfQzoneInternalWebViewPlugin.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label114;
        }
        if (arrayOfQzoneInternalWebViewPlugin[i].a(paramString, paramLong, paramMap)) {
          break;
        }
        i += 1;
      }
      if ((paramLong == 8589934594L) && (this.jdField_a_of_type_Boolean))
      {
        paramMap = null;
        if (this.mRuntime != null) {
          paramMap = this.mRuntime.a();
        }
        if (paramMap != null) {
          paramMap.clearHistory();
        }
        this.jdField_a_of_type_Boolean = false;
      }
    } while ((1024L == paramLong) && (a(paramString)));
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) && (!paramString2.equals("qzDynamicAlbum")) && (!paramString2.equals("QZImagePicker")) && (!paramString2.equals("qzlive")) && (!paramString2.equals("qzui")) && (!paramString2.equals("QzoneUpload")) && (!paramString2.equals("QzoneAudio"))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneWebViewPlugin", 2, "handleJsRequest pkgName: " + paramString2 + ",method: " + paramString3);
    }
    a();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfQzoneInternalWebViewPlugin[i].a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs)) {
        return true;
      }
      i += 1;
    }
    return QZoneWebViewJsHandleLogic.a(this, this.mRuntime, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    a();
    Object localObject = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].a(paramIntent, paramByte, paramInt);
      i += 1;
    }
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt != -1);
      this.mRuntime.a().finish();
      return;
    } while (paramInt != -1);
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
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    QzoneInternalWebViewPlugin[] arrayOfQzoneInternalWebViewPlugin = this.jdField_a_of_type_ArrayOfCooperationQzoneWebviewpluginQzoneInternalWebViewPlugin;
    int j = arrayOfQzoneInternalWebViewPlugin.length;
    int i = 0;
    while (i < j)
    {
      arrayOfQzoneInternalWebViewPlugin[i].a();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */