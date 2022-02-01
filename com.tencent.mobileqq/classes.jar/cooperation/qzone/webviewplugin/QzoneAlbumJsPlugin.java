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
  public static final String NAMESPACE = "Qzone";
  private static String TAG = "QzoneAlbumJsPlugin";
  
  private void defaultHandleMethodByBroadcast(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString, String paramString)
  {
    try
    {
      paramArrayOfString = this.parentPlugin.mRuntime.d();
      if ((paramArrayOfString != null) && (!paramArrayOfString.isFinishing()))
      {
        paramArrayOfString = new Intent();
        paramArrayOfString.setAction(paramString);
        if (paramPluginRuntime.d() != null)
        {
          paramPluginRuntime.d().sendBroadcast(paramArrayOfString);
          return;
        }
      }
    }
    catch (Exception paramPluginRuntime)
    {
      paramPluginRuntime.printStackTrace();
    }
  }
  
  private void handleAlbumFacadeCate(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    Activity localActivity = this.parentPlugin.mRuntime.d();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_item_id", paramArrayOfString.optInt("item_id"));
        ((Intent)localObject2).putExtra("key_thumb_url", paramArrayOfString.optString("thumb"));
        ((Intent)localObject2).putExtra("key_item_type", paramArrayOfString.optInt("item_type"));
        ((Intent)localObject2).setAction("action_album_skin_js_to_qzone");
        String str = paramArrayOfString.optString("callback");
        Object localObject1 = paramArrayOfString.optString("entry");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.parentPlugin.callJs(str, new String[] { "{\"result\":\"false\"}" });
          return;
        }
        boolean bool = "createAlbum".equals(localObject1);
        if ((bool) || ("editAlbum".equals(localObject1)) || ("personal".equals(localObject1)) || ("photolist".equals(localObject1)))
        {
          if (paramPluginRuntime.d() != null) {
            paramPluginRuntime.d().sendBroadcast((Intent)localObject2);
          }
          this.parentPlugin.callJs(str, new String[] { "{\"result\":\"true\"}" });
          paramPluginRuntime = this.parentPlugin.mRuntime.b();
          if (("personal".equals(localObject1)) && (paramPluginRuntime != null))
          {
            localObject1 = QZoneHelper.UserInfo.getInstance();
            ((QZoneHelper.UserInfo)localObject1).qzone_uin = paramPluginRuntime.getCurrentAccountUin();
            localObject2 = new BaseBusinessAlbumInfo();
            ((BaseBusinessAlbumInfo)localObject2).mAlbumId = paramArrayOfString.optString("albumid");
            ((BaseBusinessAlbumInfo)localObject2).mUin = paramPluginRuntime.getLongAccountUin();
            ((BaseBusinessAlbumInfo)localObject2).mAlbumType = 0;
            ((BaseBusinessAlbumInfo)localObject2).isIndividualityAlbum = true;
            QZoneHelper.forwardToPersonalAlbumPhotoList(localActivity, (QZoneHelper.UserInfo)localObject1, (BaseBusinessAlbumInfo)localObject2, -1);
            return;
          }
        }
      }
      catch (JSONException paramPluginRuntime)
      {
        paramPluginRuntime.printStackTrace();
      }
    }
  }
  
  private void handleNotifyShareData(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    try
    {
      Object localObject = this.parentPlugin.mRuntime.d();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("broadcastActionBlogShareData");
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
          ((Intent)localObject).putExtra("share_data", paramArrayOfString[0]);
        }
        if (paramPluginRuntime.d() != null)
        {
          paramPluginRuntime.d().sendBroadcast((Intent)localObject);
          return;
        }
      }
    }
    catch (Exception paramPluginRuntime)
    {
      paramPluginRuntime.printStackTrace();
    }
  }
  
  private void handleRefreshAlbumList(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    defaultHandleMethodByBroadcast(paramPluginRuntime, paramArrayOfString, "broadcastActionRefreshAlbumList");
  }
  
  private void handleRefreshPhotoList(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    defaultHandleMethodByBroadcast(paramPluginRuntime, paramArrayOfString, "broadcastActionRefreshPhotoList");
  }
  
  private void handleUpdateAlbumCommentList(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    try
    {
      Object localObject = this.parentPlugin.mRuntime.d();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_album_comment_list_count", paramArrayOfString.optInt("count"));
        ((Intent)localObject).setAction("broadcastActionUpdateAlbumCommentList");
        if (paramPluginRuntime.d() != null)
        {
          paramPluginRuntime.d().sendBroadcast((Intent)localObject);
          return;
        }
      }
    }
    catch (Exception paramPluginRuntime)
    {
      paramPluginRuntime.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ((paramString3.equalsIgnoreCase("SetAlbumSkin")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        handleAlbumFacadeCate(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ((paramString3.equalsIgnoreCase("UpdateAlbumCommentList")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        handleUpdateAlbumCommentList(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("refreshPhotoList".equalsIgnoreCase(paramString3))
      {
        handleRefreshPhotoList(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("RefreshAlbumList".equalsIgnoreCase(paramString3))
      {
        handleRefreshAlbumList(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("getBlogArkShareData".equalsIgnoreCase(paramString3))
      {
        handleNotifyShareData(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneAlbumJsPlugin
 * JD-Core Version:    0.7.0.1
 */