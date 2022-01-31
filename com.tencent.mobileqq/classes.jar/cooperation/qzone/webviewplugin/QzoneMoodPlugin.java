package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneMoodPlugin
  extends QzoneInternalWebViewPlugin
{
  private boolean a;
  
  private boolean a(String paramString)
  {
    try
    {
      Object localObject2 = new JSONObject(paramString);
      String str1 = ((JSONObject)localObject2).getString("text");
      paramString = ((JSONObject)localObject2).getJSONArray("photoList");
      ArrayList localArrayList = new ArrayList();
      if ((paramString != null) && (paramString.length() > 0))
      {
        i = 0;
        while (i < paramString.length())
        {
          localArrayList.add(paramString.getJSONObject(i).getString("url"));
          i += 1;
        }
      }
      Object localObject1 = null;
      String str2 = ((JSONObject)localObject2).optString("tagId");
      String str3 = ((JSONObject)localObject2).optString("tagTitle");
      String str4 = ((JSONObject)localObject2).optString("tagUrl");
      String str5 = ((JSONObject)localObject2).optString("tagProtocol");
      String str6 = ((JSONObject)localObject2).optString("desc");
      int i = ((JSONObject)localObject2).optInt("isfromfeedcombine");
      String str7 = ((JSONObject)localObject2).optString("descTruncateNum");
      paramString = (String)localObject1;
      if (!TextUtils.isEmpty(str2))
      {
        paramString = (String)localObject1;
        if (!TextUtils.isEmpty(str3))
        {
          paramString = (String)localObject1;
          if (!TextUtils.isEmpty(str4))
          {
            paramString = (String)localObject1;
            if (!TextUtils.isEmpty(str5))
            {
              localObject1 = new PublishEventTag();
              ((PublishEventTag)localObject1).c = str2;
              ((PublishEventTag)localObject1).a = str3;
              ((PublishEventTag)localObject1).b = str4;
              ((PublishEventTag)localObject1).d = str5;
              paramString = (String)localObject1;
              if (i == 1)
              {
                paramString = (String)localObject1;
                if (!TextUtils.isEmpty(str6))
                {
                  paramString = (String)localObject1;
                  if (!TextUtils.isEmpty(str7))
                  {
                    ((PublishEventTag)localObject1).b = "http://qzonestyle.gtimg.cn/aoi/sola/20170323194618_Xgy5reWQh0.png";
                    ((PublishEventTag)localObject1).e = str6;
                    ((PublishEventTag)localObject1).f = str7;
                    paramString = (String)localObject1;
                  }
                }
              }
            }
          }
        }
      }
      localObject2 = ((JSONObject)localObject2).optString("singlePic");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (localObject1 != null))
      {
        localObject2 = QzoneUploadInterface.a((Context)localObject1, (String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localArrayList.add(localObject2);
        }
      }
      if (localObject1 != null) {
        if (i == 1) {
          QZoneHelper.b((Activity)localObject1, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getCurrentAccountUin(), str1, localArrayList, paramString, -1);
        } else {
          QZoneHelper.a((Activity)localObject1, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getCurrentAccountUin(), str1, localArrayList, paramString, -1);
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QzoneMoodPlugin", 1, paramString.getMessage());
      return false;
    }
    return false;
    return true;
  }
  
  private void b()
  {
    RemoteHandleManager.a().a().t();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      RemoteHandleManager.a().a();
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("signInSuccess".equals(paramString3))
    {
      try
      {
        paramString3 = new JSONObject(paramVarArgs[0]);
        if (paramString3.optBoolean("shareToWX"))
        {
          paramJsBridgeListener = paramString3.optString("image");
          paramString1 = paramString3.optString("text");
          paramString2 = paramString3.optString("fontId");
          paramString3 = paramString3.optString("fontUrl");
          RemoteHandleManager.a().a().a(paramString1, paramJsBridgeListener, paramString2, paramString3);
          this.jdField_a_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() == null) {
          break label207;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
        return true;
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("QzoneMoodPlugin", 1, paramJsBridgeListener.getMessage());
        return false;
      }
    }
    else if ("editMoodSuccess".equals(paramString3))
    {
      paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setResult(-1);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
        return true;
      }
    }
    else
    {
      if (QZoneJsConstants.h.equals(paramString3)) {
        return a(paramVarArgs[0]);
      }
      if ("deleteUnpublishedShuoShuo".equals(paramString3))
      {
        b();
        return true;
      }
    }
    label207:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneMoodPlugin
 * JD-Core Version:    0.7.0.1
 */