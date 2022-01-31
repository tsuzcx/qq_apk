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
  public static String a;
  public static String b = "famous_uin";
  public static String c = "title";
  public static String d = "summary";
  public static String e = "thumb_photo_url";
  public static String f = "detail_url";
  public static String g = "h5_detail_url";
  public static String h = "schema_detail_url";
  public static String i = "is_followed";
  public static String j = "show_report";
  public static String k = "nick_name";
  public static String l = "descption";
  public static String m = "fans_count";
  public static String n = "visitor_count";
  public static String o = "background_url";
  public static String p = "qrcode_url";
  
  static
  {
    jdField_a_of_type_JavaLangString = "Qzone";
  }
  
  private void a(Activity paramActivity, String[] paramArrayOfString)
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
      long l1 = 0L;
      int i1 = 0;
      if (((JSONObject)localObject).has("nick_name")) {
        paramArrayOfString = ((JSONObject)localObject).getString("nick_name");
      }
      if (((JSONObject)localObject).has("descption")) {
        str1 = ((JSONObject)localObject).getString("descption");
      }
      if (((JSONObject)localObject).has("fans_count")) {
        l1 = ((JSONObject)localObject).getLong("fans_count");
      }
      if (((JSONObject)localObject).has("visitor_count")) {
        i1 = ((JSONObject)localObject).getInt("visitor_count");
      }
      if (((JSONObject)localObject).has("background_url")) {
        str2 = ((JSONObject)localObject).getString("background_url");
      }
      if (((JSONObject)localObject).has("qrcode_url")) {
        str3 = ((JSONObject)localObject).getString("qrcode_url");
      }
      System.out.println("---------title:" + str5 + ",summary:" + str6 + ",thumb_photo_url" + str7 + ",detail_url:" + str8);
      localObject = new Intent();
      ((Intent)localObject).putExtra(b, str4);
      ((Intent)localObject).putExtra(c, str5);
      ((Intent)localObject).putExtra(d, str6);
      ((Intent)localObject).putExtra(e, str7);
      ((Intent)localObject).putExtra(k, paramArrayOfString);
      ((Intent)localObject).putExtra(l, str1);
      ((Intent)localObject).putExtra(m, l1);
      ((Intent)localObject).putExtra(n, i1);
      ((Intent)localObject).putExtra(o, str2);
      ((Intent)localObject).putExtra(p, str3);
      ((Intent)localObject).putExtra(f, str8);
      ((Intent)localObject).setClassName(paramActivity, "com.qzone.web.QZoneTranslucentActivity");
      ((Intent)localObject).putExtra("cmd", QZoneJsConstants.jdField_a_of_type_JavaLangString);
      paramActivity.startActivity((Intent)localObject);
      return;
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals(jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("showShareMenu")) {
      return false;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.famous.QzoneFamousShareJsPlugin
 * JD-Core Version:    0.7.0.1
 */