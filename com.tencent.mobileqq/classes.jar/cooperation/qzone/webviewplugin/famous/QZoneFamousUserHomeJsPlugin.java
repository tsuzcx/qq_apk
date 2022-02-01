package cooperation.qzone.webviewplugin.famous;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.webviewplugin.FamousSpaceActivityInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneFamousUserHomeJsPlugin
  extends WebViewPlugin
{
  public static String KEY_NICKNAME = "key_nickname";
  public static String KEY_UIN = "key_uin";
  public static String OPENREDPOCKET = "openRedPocket";
  public static String PKG_NAME = "QZFamousUserHome";
  public static String REFER = "famous";
  public static String USERALBUM = "useralbum";
  public static String USERHOME = "userhome";
  public static String USERMOODLIST = "usermoodlist";
  
  public QZoneFamousUserHomeJsPlugin()
  {
    this.mPluginNameSpace = PKG_NAME;
  }
  
  private void openAlbum(String... paramVarArgs)
  {
    try
    {
      long l = new JSONObject(paramVarArgs[0]).getLong("uin");
      paramVarArgs = new Intent();
      QzonePluginProxyActivity.setActivityNameToIntent(paramVarArgs, "com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity");
      paramVarArgs.putExtra("key_left_tab_title", this.mRuntime.d().getString(2131914536));
      paramVarArgs.putExtra("key_right_tab_title", this.mRuntime.d().getString(2131914617));
      paramVarArgs.putExtra("key_album_owner_uin", l);
      paramVarArgs.putExtra("key_selected_tab", 0);
      paramVarArgs.putExtra("refer", REFER);
      QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.d(), this.mRuntime.b().getAccount(), paramVarArgs, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  private void openUserHome(String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramVarArgs[0]);
        long l = ((JSONObject)localObject).getLong("uin");
        if (((JSONObject)localObject).has("actiontype"))
        {
          i = ((JSONObject)localObject).getInt("actiontype");
          boolean bool = ((JSONObject)localObject).has("actionurl");
          String str = "";
          if (!bool) {
            break label387;
          }
          paramVarArgs = ((JSONObject)localObject).optString("actionurl");
          if (!((JSONObject)localObject).has("cover_type")) {
            break label393;
          }
          j = ((JSONObject)localObject).getInt("cover_type");
          if (((JSONObject)localObject).has("action_url")) {
            str = ((JSONObject)localObject).optString("action_url");
          }
          if (!((JSONObject)localObject).has("autoShowTimeLine")) {
            break label398;
          }
          localObject = ((JSONObject)localObject).optString("autoShowTimeLine");
          bool = "1".equals(localObject);
          Intent localIntent = new Intent();
          Activity localActivity = this.mRuntime.d();
          localObject = "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity";
          if ((35 == i) && (paramVarArgs != null) && (paramVarArgs.length() > 0))
          {
            if ((localActivity != null) && ((localActivity instanceof FamousSpaceActivityInterface)) && (((FamousSpaceActivityInterface)localActivity).isShowMyHomePage())) {
              return;
            }
            localIntent.putExtra("famous_space_webview_url", paramVarArgs);
            paramVarArgs = (String[])localObject;
          }
          else if ((j == 35) && (str != null) && (str.length() > 0))
          {
            localIntent.putExtra("famous_space_webview_url", str);
            paramVarArgs = (String[])localObject;
          }
          else
          {
            paramVarArgs = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
            localIntent.setFlags(67108864);
          }
          QzonePluginProxyActivity.setActivityNameToIntent(localIntent, paramVarArgs);
          localIntent.putExtra("qqid", l);
          localIntent.putExtra("refer", REFER);
          localIntent.putExtra("autoShowTimeLine", bool);
          if (bool) {
            localIntent.setFlags(335544320);
          }
          if ((localActivity != null) && (((localActivity instanceof FamousSpaceActivityInterface)) || ((localActivity instanceof BasePluginActivity))))
          {
            localIntent.setClassName(localActivity, paramVarArgs);
            localActivity.startActivity(localIntent);
            return;
          }
          QzonePluginProxyActivity.launchPluingActivityForResult(localActivity, this.mRuntime.b().getAccount(), localIntent, 0);
          return;
        }
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
      int i = 0;
      continue;
      label387:
      paramVarArgs = "";
      continue;
      label393:
      int j = 0;
      continue;
      label398:
      Object localObject = "0";
    }
  }
  
  private void openUserMoodList(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      long l = paramVarArgs.getLong("uin");
      paramVarArgs = paramVarArgs.getString("nick");
      Intent localIntent = new Intent();
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.homepage.ui.activity.QzoneMoodListActivity");
      localIntent.putExtra(KEY_UIN, l);
      if (!TextUtils.isEmpty(paramVarArgs)) {
        localIntent.putExtra(KEY_NICKNAME, paramVarArgs);
      }
      localIntent.putExtra("refer", REFER);
      QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.d(), this.mRuntime.b().getAccount(), localIntent, 0);
      return;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!PKG_NAME.equals(paramString2)) {
      return false;
    }
    if (paramString3.equals(USERMOODLIST))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        openUserMoodList(paramVarArgs);
      }
      return true;
    }
    if (paramString3.equals(USERALBUM))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        openAlbum(paramVarArgs);
      }
      return true;
    }
    if (paramString3.equals(USERHOME))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        openUserHome(paramVarArgs);
      }
      return true;
    }
    if (paramString3.equals(OPENREDPOCKET))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        long l;
        try
        {
          l = Long.parseLong(paramVarArgs[0]);
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          l = 0L;
        }
        if (l != 0L)
        {
          this.mRuntime.d();
          paramJsBridgeListener = new Intent();
          paramJsBridgeListener.setAction("qzoneGrapRedPocket");
          paramJsBridgeListener.putExtra("uin", l);
          if (this.mRuntime.d() != null) {
            this.mRuntime.d().sendBroadcast(paramJsBridgeListener);
          }
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.famous.QZoneFamousUserHomeJsPlugin
 * JD-Core Version:    0.7.0.1
 */