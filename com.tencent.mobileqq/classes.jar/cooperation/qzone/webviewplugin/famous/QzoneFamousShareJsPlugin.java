package cooperation.qzone.webviewplugin.famous;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneFamousShareJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static String EXTRA_FAMOUS_IS_FOLLOWED;
  public static String EXTRA_FAMOUS_SHARE_BACKGROUND_URL = "background_url";
  public static String EXTRA_FAMOUS_SHARE_DESCPTION;
  public static String EXTRA_FAMOUS_SHARE_DETAIL_URL;
  public static String EXTRA_FAMOUS_SHARE_FANS_COUNT;
  public static String EXTRA_FAMOUS_SHARE_H5_DETAIL_URL;
  public static String EXTRA_FAMOUS_SHARE_NICKNAME;
  public static String EXTRA_FAMOUS_SHARE_QRCODE_URL = "qrcode_url";
  public static String EXTRA_FAMOUS_SHARE_SCHEMA_DETAIL_URL;
  public static String EXTRA_FAMOUS_SHARE_SUMMARY;
  public static String EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL;
  public static String EXTRA_FAMOUS_SHARE_TITLE;
  public static String EXTRA_FAMOUS_SHARE_VISITOR_COUNT;
  public static String EXTRA_FAMOUS_SHOW_REPORT_MENU;
  public static String EXTRA_FAMOUS_UIN;
  public static String PKG_NAME = "Qzone";
  public static final String TAG = "QzoneFamousShareJsPlugin";
  
  static
  {
    EXTRA_FAMOUS_UIN = "famous_uin";
    EXTRA_FAMOUS_SHARE_TITLE = "title";
    EXTRA_FAMOUS_SHARE_SUMMARY = "summary";
    EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL = "thumb_photo_url";
    EXTRA_FAMOUS_SHARE_DETAIL_URL = "detail_url";
    EXTRA_FAMOUS_SHARE_H5_DETAIL_URL = "h5_detail_url";
    EXTRA_FAMOUS_SHARE_SCHEMA_DETAIL_URL = "schema_detail_url";
    EXTRA_FAMOUS_IS_FOLLOWED = "is_followed";
    EXTRA_FAMOUS_SHOW_REPORT_MENU = "show_report";
    EXTRA_FAMOUS_SHARE_NICKNAME = "nick_name";
    EXTRA_FAMOUS_SHARE_DESCPTION = "descption";
    EXTRA_FAMOUS_SHARE_FANS_COUNT = "fans_count";
    EXTRA_FAMOUS_SHARE_VISITOR_COUNT = "visitor_count";
  }
  
  private void handleShare(Activity paramActivity, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      String str4 = ((JSONObject)localObject).getString("famous_uin");
      String str5 = ((JSONObject)localObject).getString("title");
      String str6 = ((JSONObject)localObject).getString("summary");
      String str7 = ((JSONObject)localObject).getString("thumb_photo_url");
      String str8 = ((JSONObject)localObject).getString("detail_url");
      paramArrayOfString = null;
      String str1 = null;
      String str2 = null;
      String str3 = null;
      long l = 0L;
      int i = 0;
      if (((JSONObject)localObject).has("nick_name")) {
        paramArrayOfString = ((JSONObject)localObject).getString("nick_name");
      }
      if (((JSONObject)localObject).has("descption")) {
        str1 = ((JSONObject)localObject).getString("descption");
      }
      if (((JSONObject)localObject).has("fans_count")) {
        l = ((JSONObject)localObject).getLong("fans_count");
      }
      if (((JSONObject)localObject).has("visitor_count")) {
        i = ((JSONObject)localObject).getInt("visitor_count");
      }
      if (((JSONObject)localObject).has("background_url")) {
        str2 = ((JSONObject)localObject).getString("background_url");
      }
      if (((JSONObject)localObject).has("qrcode_url")) {
        str3 = ((JSONObject)localObject).getString("qrcode_url");
      }
      System.out.println("---------title:" + str5 + ",summary:" + str6 + ",thumb_photo_url" + str7 + ",detail_url:" + str8);
      localObject = new Intent();
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_UIN, str4);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_TITLE, str5);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_SUMMARY, str6);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL, str7);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_NICKNAME, paramArrayOfString);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_DESCPTION, str1);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_FANS_COUNT, l);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_VISITOR_COUNT, i);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_BACKGROUND_URL, str2);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_QRCODE_URL, str3);
      ((Intent)localObject).putExtra(EXTRA_FAMOUS_SHARE_DETAIL_URL, str8);
      ((Intent)localObject).setClassName(paramActivity, "com.qzone.misc.web.QZoneTranslucentActivity");
      ((Intent)localObject).putExtra("cmd", QZoneJsConstants.METHOD_FAMOUST_SHOW_DIALOG);
      paramActivity.startActivity((Intent)localObject);
      return;
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals(PKG_NAME)) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("showShareMenu")) {
      return false;
    }
    handleShare(this.parentPlugin.mRuntime.a(), paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.famous.QzoneFamousShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */