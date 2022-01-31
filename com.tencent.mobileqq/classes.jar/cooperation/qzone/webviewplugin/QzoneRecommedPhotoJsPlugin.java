package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anlc;
import anld;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneRecommedPhotoJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  private String a;
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return QzoneDynamicAlbumPlugin.a(paramString, 200, 200, true);
    }
    return "";
  }
  
  private void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new anlc(this));
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleGetRecommendphoto error", paramString);
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("photoEventID");
      Intent localIntent = new Intent("action_enter_to_qzone_recommend_photo");
      localIntent.putExtra("param.formSchemeToRecommend", true);
      localIntent.putExtra("param.photoUnikey", paramString);
      QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), QZoneHelper.UserInfo.a(), localIntent, 0);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleForwardToRecommedPhoto error", paramString);
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("recommend_on", paramString.optString("recommend_on"));
      localBundle.putString("recommendPush_on", paramString.optString("recommendPush_on"));
      RemoteHandleManager.a().a().a(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleSetShouldScanPhotoEventState error", paramString);
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getHandler(QzoneVideoTabJsPlugin.class).post(new anld(this));
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleGetShouldScanPhotoEventState error", paramString);
    }
  }
  
  private void e(String paramString)
  {
    if (paramString == null) {
      return;
    }
    QLog.w("QzoneRecommedPhotoJsPlugin", 1, "errorCallBack error");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", -1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "errorCallBack error", paramString);
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("getRecommendPhotoEvent".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      RemoteHandleManager.a().a(this);
      a(paramVarArgs[0]);
      return true;
    }
    if (("enterPhotoEventDetail".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      b(paramVarArgs[0]);
      return true;
    }
    if (("setShouldScanPhotoEventState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      c(paramVarArgs[0]);
      return true;
    }
    if (("getShouldScanPhotoEventState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      RemoteHandleManager.a().a(this);
      d(paramVarArgs[0]);
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    label403:
    label412:
    do
    {
      do
      {
        do
        {
          return;
          if (!"cmd.getRecommedPhoto".equals(paramString)) {
            break label412;
          }
          if (!paramBundle.containsKey("data")) {
            break label403;
          }
          try
          {
            localObject1 = paramBundle.getBundle("data");
            if (localObject1 == null)
            {
              QLog.e("QzoneRecommedPhotoJsPlugin", 1, "call js function,bundle is empty");
              return;
            }
          }
          catch (Exception paramString)
          {
            QLog.w("QzoneRecommedPhotoJsPlugin", 1, "onWebEvent error", paramString);
            e(this.jdField_a_of_type_JavaLangString);
            return;
          }
          paramString = new JSONObject();
          paramString.put("code", 0);
          paramString.put("photoEventID", ((Bundle)localObject1).getString("photoEventID"));
          paramString.put("title", ((Bundle)localObject1).getString("title"));
          paramString.put("time", ((Bundle)localObject1).getString("time"));
          paramString.put("mediaCount", ((Bundle)localObject1).getInt("mediaCount"));
          paramBundle = ((Bundle)localObject1).getIntegerArrayList("dataType");
          Object localObject1 = ((Bundle)localObject1).getStringArrayList("dataPath");
          JSONArray localJSONArray = new JSONArray();
          if ((paramBundle == null) || (paramBundle.size() <= 0) || (localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (paramBundle.size() != ((ArrayList)localObject1).size())) {
            break;
          }
          int i = 0;
          for (;;)
          {
            if (i < paramBundle.size())
            {
              Object localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("imageData", "data:image/jpg;base64," + a((String)((ArrayList)localObject1).get(i)));
              ((JSONObject)localObject2).put("type", paramBundle.get(i));
              localJSONArray.put(localObject2);
              int j = ((Integer)paramBundle.get(i)).intValue();
              if (j == 3) {}
              try
              {
                localObject2 = new File((String)((ArrayList)localObject1).get(i));
                if (((File)localObject2).exists()) {
                  ((File)localObject2).delete();
                }
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  QLog.w("QzoneRecommedPhotoJsPlugin", 1, "delete file error", localException);
                }
              }
            }
          }
          paramString.put("thumbInfos", localJSONArray);
        } while (this.jdField_a_of_type_JavaLangString == null);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
        return;
        e(this.jdField_a_of_type_JavaLangString);
        return;
        e(this.jdField_a_of_type_JavaLangString);
        return;
      } while (!"cmd.getLocalPhotoSwitcher".equals(paramString));
      if (!paramBundle.containsKey("data")) {
        break;
      }
      try
      {
        paramString = paramBundle.getBundle("data");
        if (paramString == null)
        {
          QLog.e("QzoneRecommedPhotoJsPlugin", 1, "call js function,bundle is empty");
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.w("QzoneRecommedPhotoJsPlugin", 1, "onWebEvent error", paramString);
        e(this.jdField_a_of_type_JavaLangString);
        return;
      }
      paramBundle = new JSONObject();
      paramBundle.put("recommend_on", paramString.getString("recommend_on"));
    } while (this.jdField_a_of_type_JavaLangString == null);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
    return;
    e(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin
 * JD-Core Version:    0.7.0.1
 */