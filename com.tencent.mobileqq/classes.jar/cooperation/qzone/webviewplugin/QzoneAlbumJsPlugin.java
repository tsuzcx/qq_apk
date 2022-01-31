package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneAlbumJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = QzoneAlbumJsPlugin.class.getSimpleName();
  }
  
  private void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      String str;
      do
      {
        return;
        try
        {
          paramArrayOfString = new JSONObject(paramArrayOfString[0]);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_item_id", paramArrayOfString.optInt("item_id"));
          ((Intent)localObject2).putExtra("key_thumb_url", paramArrayOfString.optString("thumb"));
          ((Intent)localObject2).putExtra("key_item_type", paramArrayOfString.optInt("item_type"));
          ((Intent)localObject2).setAction("action_album_skin_js_to_qzone");
          str = paramArrayOfString.optString("callback");
          localObject1 = paramArrayOfString.optString("entry");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { "{\"result\":\"false\"}" });
            return;
          }
        }
        catch (JSONException paramPluginRuntime)
        {
          paramPluginRuntime.printStackTrace();
          return;
        }
      } while ((!"createAlbum".equals(localObject1)) && (!"editAlbum".equals(localObject1)) && (!"personal".equals(localObject1)) && (!"photolist".equals(localObject1)));
      if (paramPluginRuntime.a() != null) {
        paramPluginRuntime.a().sendBroadcast((Intent)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { "{\"result\":\"true\"}" });
      paramPluginRuntime = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    } while ((!"personal".equals(localObject1)) || (paramPluginRuntime == null));
    Object localObject1 = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject1).jdField_a_of_type_JavaLangString = paramPluginRuntime.getCurrentAccountUin();
    Object localObject2 = new BaseBusinessAlbumInfo();
    ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfString.optString("albumid");
    ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_Long = paramPluginRuntime.getLongAccountUin();
    ((BaseBusinessAlbumInfo)localObject2).c = 0;
    ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_Boolean = true;
    QZoneHelper.a(localActivity, (QZoneHelper.UserInfo)localObject1, (BaseBusinessAlbumInfo)localObject2, -1);
  }
  
  private void b(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_album_comment_list_count", paramArrayOfString.optInt("count"));
        ((Intent)localObject).setAction("broadcastActionUpdateAlbumCommentList");
        if (paramPluginRuntime.a() != null) {
          paramPluginRuntime.a().sendBroadcast((Intent)localObject);
        }
      }
      return;
    }
    catch (Exception paramPluginRuntime)
    {
      paramPluginRuntime.printStackTrace();
    }
  }
  
  private void c(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if ((paramArrayOfString != null) && (!paramArrayOfString.isFinishing()))
      {
        paramArrayOfString = new Intent();
        paramArrayOfString.setAction("broadcastActionRefreshPhotoList");
        if (paramPluginRuntime.a() != null) {
          paramPluginRuntime.a().sendBroadcast(paramArrayOfString);
        }
      }
      return;
    }
    catch (Exception paramPluginRuntime)
    {
      paramPluginRuntime.printStackTrace();
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ((paramString3.equalsIgnoreCase("SetAlbumSkin")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ((paramString3.equalsIgnoreCase("UpdateAlbumCommentList")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("refreshPhotoList".equalsIgnoreCase(paramString3))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneAlbumJsPlugin
 * JD-Core Version:    0.7.0.1
 */