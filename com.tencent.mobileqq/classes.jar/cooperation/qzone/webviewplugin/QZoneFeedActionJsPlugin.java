package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import anjl;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneFeedActionJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static String a;
  public static boolean a;
  private BroadcastReceiver a;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    QLog.d("QZoneFeedActionJsPlugin", 2, "action : " + paramIntent.getAction());
    if ("FeedActionPanelActivity.content".equals(paramIntent.getAction())) {
      c(paramIntent);
    }
    do
    {
      return;
      if ("FeedActionPanelActivity.inputpanel_height".equals(paramIntent.getAction()))
      {
        a(paramIntent);
        return;
      }
    } while (!"FeedActionPanelActivity.inputpanel_closed".equals(paramIntent.getAction()));
    b(paramIntent);
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("panel_height", -1);
    QLog.d("QZoneFeedActionJsPlugin", 2, "Input FeedActionPanel totalHeight : " + i);
    if (i == -1) {}
    do
    {
      return;
      try
      {
        paramIntent = "{event_type:\"HEIGHT_CHANGED\",height:\"" + i + "\"}";
        paramIntent = "window." + jdField_a_of_type_JavaLangString + "(" + paramIntent + ");";
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "invoke callback js:" + paramIntent);
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().c(paramIntent);
        return;
      }
      catch (Throwable paramIntent) {}
    } while (!QLog.isColorLevel());
    QLog.d("QZoneFeedActionJsPlugin", 2, "notifyPanelHeightChanged: ", paramIntent);
  }
  
  private void a(String paramString)
  {
    Object localObject1 = new Intent("action_js2qzone");
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("cmd", "H5PayCallSucess");
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFeedActionJsPlugin", 2, "handleWriteBlog actionString: " + ((Intent)localObject1).getAction());
    }
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), QZoneHelper.UserInfo.a(), (Intent)localObject1);
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject1 = new JSONObject();
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("vipType", paramString);
      ((JSONObject)localObject1).put("type", "YellowInfo");
      ((JSONObject)localObject1).put("data", localObject2);
      localObject2 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("*.qzone.qq.com");
      ((JSONObject)localObject2).put("echo", true);
      ((JSONObject)localObject2).put("broadcast", true);
      ((JSONObject)localObject2).put("domains", localJSONArray);
      a("openVipInfo", (JSONObject)localObject1, (JSONObject)localObject2);
      if (("normalVip".equals(paramString)) || ("highVip".equals(paramString)))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
        if (paramString != null) {
          paramString.finish();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", localException);
        }
      }
    }
  }
  
  private void a(String... paramVarArgs)
  {
    if (LocalMultiProcConfig.getBool("FeedAction#isActive", false)) {
      return;
    }
    LocalMultiProcConfig.putBool("FeedAction#isActive", true);
    String str2 = "";
    String str3 = "";
    int i16 = 0;
    i3 = 0;
    int i15 = 0;
    i4 = 0;
    int i14 = 0;
    i5 = 0;
    int i13 = 0;
    i6 = 0;
    int i12 = 0;
    i7 = 0;
    String str1 = "";
    int i11 = 0;
    i8 = 0;
    int i10 = 0;
    i9 = 0;
    boolean bool8 = false;
    bool3 = false;
    boolean bool7 = false;
    bool4 = false;
    bool6 = false;
    bool5 = bool6;
    bool2 = bool4;
    bool1 = bool3;
    localObject6 = str2;
    localObject5 = str3;
    i2 = i7;
    i1 = i4;
    n = i3;
    m = i5;
    k = i6;
    localObject4 = str1;
    j = i8;
    i = i9;
    if (paramVarArgs != null)
    {
      bool5 = bool6;
      bool2 = bool4;
      bool1 = bool3;
      localObject6 = str2;
      localObject5 = str3;
      i2 = i7;
      i1 = i4;
      n = i3;
      m = i5;
      k = i6;
      localObject4 = str1;
      j = i8;
      i = i9;
      if (paramVarArgs.length > 0)
      {
        bool3 = bool7;
        bool4 = bool8;
        localObject1 = str2;
        localObject2 = str3;
        i3 = i12;
        i4 = i15;
        i5 = i16;
        i6 = i14;
        i7 = i13;
        localObject3 = str1;
        i8 = i11;
        i9 = i10;
      }
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = str2;
      localObject2 = str3;
      i3 = i12;
      i4 = i15;
      i5 = i16;
      i6 = i14;
      i7 = i13;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      localObject5 = paramVarArgs.optString("content");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = str2;
      localObject2 = localObject5;
      i3 = i12;
      i4 = i15;
      i5 = i16;
      i6 = i14;
      i7 = i13;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      localObject6 = paramVarArgs.optString("placeholder");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i12;
      i4 = i15;
      i5 = i16;
      i6 = i14;
      i7 = i13;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      n = paramVarArgs.optInt("needEmoticonBtn");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i12;
      i4 = i15;
      i5 = n;
      i6 = i14;
      i7 = i13;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      i1 = paramVarArgs.optInt("needAtBtn");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i12;
      i4 = i1;
      i5 = n;
      i6 = i14;
      i7 = i13;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      m = paramVarArgs.optInt("needPrivateBtn");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i12;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = i13;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      k = paramVarArgs.optInt("isReply");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i12;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      i2 = paramVarArgs.optInt("privateCommentStatus");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i2;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      jdField_a_of_type_JavaLangString = paramVarArgs.optString("callback");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i2;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      this.b = paramVarArgs.optBoolean("acceptEncoded");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i2;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      jdField_a_of_type_Boolean = this.b;
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i2;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = str1;
      i8 = i11;
      i9 = i10;
      localObject4 = paramVarArgs.optString("btntext");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i2;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = localObject4;
      i8 = i11;
      i9 = i10;
      j = paramVarArgs.optInt("maxTextLength");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i2;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = localObject4;
      i8 = j;
      i9 = i10;
      i = paramVarArgs.optInt("groupdId");
      bool3 = bool7;
      bool4 = bool8;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i2;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = localObject4;
      i8 = j;
      i9 = i;
      bool1 = paramVarArgs.optBoolean("disableAutoClose");
      bool3 = bool7;
      bool4 = bool1;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i2;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = localObject4;
      i8 = j;
      i9 = i;
      bool2 = paramVarArgs.optBoolean("catchHeightChange");
      bool3 = bool2;
      bool4 = bool1;
      localObject1 = localObject6;
      localObject2 = localObject5;
      i3 = i2;
      i4 = i1;
      i5 = n;
      i6 = m;
      i7 = k;
      localObject3 = localObject4;
      i8 = j;
      i9 = i;
      bool5 = paramVarArgs.optBoolean("catchClosePanel");
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        bool5 = bool6;
        bool2 = bool3;
        bool1 = bool4;
        localObject6 = localObject1;
        localObject5 = localObject2;
        i2 = i3;
        i1 = i4;
        n = i5;
        m = i6;
        k = i7;
        localObject4 = localObject3;
        j = i8;
        i = i9;
        if (QLog.isColorLevel())
        {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleFeedActionPanel: ", paramVarArgs);
          bool5 = bool6;
          bool2 = bool3;
          bool1 = bool4;
          localObject6 = localObject1;
          localObject5 = localObject2;
          i2 = i3;
          i1 = i4;
          n = i5;
          m = i6;
          k = i7;
          localObject4 = localObject3;
          j = i8;
          i = i9;
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneFeedActionJsPlugin", 4, new Object[] { "handleFeedActionPanel hint is: " + (String)localObject6 + "\t autofill:" + (String)localObject5 + ",needEmoticonBtn: " + n + ",needAtBtn: " + i1 + ",needPrivateBtn: " + m + ",isReply: " + k + ",privateCommentStatus: " + i2 + ",maxLen: " + j + ",troopid: " + i, "acceptEncoded:" + this.b + " disableAutoClose:" + bool1 + " cachePanelHeight:" + bool2 + " cahcePanelClose:" + bool5 });
    }
    paramVarArgs = new Bundle();
    paramVarArgs.putBoolean("disableAutoClose", bool1);
    paramVarArgs.putBoolean("catchHeightChange", bool2);
    paramVarArgs.putBoolean("catchClosePanel", bool5);
    i3 = QZoneWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, 2);
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), QZoneHelper.UserInfo.a(), i3, (String)localObject6, (String)localObject5, "", "", i2, i1, n, 0, m, k, (String)localObject4, j, i, false, "", false, paramVarArgs);
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new anjl(this);
    }
    if (!this.c)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("FeedActionPanelActivity.content");
      localIntentFilter.addAction("FeedActionPanelActivity.inputpanel_height");
      localIntentFilter.addAction("FeedActionPanelActivity.inputpanel_closed");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void b(Intent paramIntent)
  {
    QLog.d("QZoneFeedActionJsPlugin", 2, "notifyInputPanelClosed");
    try
    {
      paramIntent = "window." + jdField_a_of_type_JavaLangString + "(" + "{event_type:\"PANEL_CLOSED\"}" + ");";
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFeedActionJsPlugin", 2, "invoke callback js:" + paramIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().c(paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QZoneFeedActionJsPlugin", 2, "notifyInputPanelClosed: ", paramIntent);
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.c)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    this.c = false;
  }
  
  private void c(Intent paramIntent)
  {
    int i = 0;
    boolean bool = paramIntent.getBooleanExtra("extraPrivateComment", false);
    String str = paramIntent.getStringExtra("contentIntentKey");
    for (;;)
    {
      try
      {
        if (this.b)
        {
          paramIntent = URLEncoder.encode(str, "utf-8");
          paramIntent = paramIntent.replace("\\", "\\\\").replace("\"", "\\\"");
          paramIntent = new StringBuilder().append("{content:\"").append(paramIntent).append("\",privateComment:\"");
          if (bool) {
            i = 1;
          }
          paramIntent = i + "\"}";
          paramIntent = "window." + jdField_a_of_type_JavaLangString + "(" + paramIntent + ");";
          if (QLog.isColorLevel()) {
            QLog.d("QZoneFeedActionJsPlugin", 2, "invoke callback js:" + paramIntent);
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().c(paramIntent);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QZoneFeedActionJsPlugin", 2, "content:" + str, paramIntent);
        return;
      }
      paramIntent = str;
    }
  }
  
  public void a()
  {
    LocalMultiProcConfig.putBool("FeedAction#isActive", false);
    c();
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    default: 
      return;
    }
    if (paramInt == -1) {
      c(paramIntent);
    }
    c();
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    super.a(paramWebViewPlugin);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest \n url: " + paramString1 + "\n pkgName:" + paramString2 + "\n method:" + paramString3);
    }
    if ("TopicComment".equalsIgnoreCase(paramString3))
    {
      a(paramVarArgs);
      return true;
    }
    if ("H5PayCallBack".equalsIgnoreCase(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if ((paramJsBridgeListener.has("status")) && ("success".equalsIgnoreCase(paramJsBridgeListener.getString("status"))))
        {
          a(paramJsBridgeListener.optString("vipType", null));
          return true;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneFeedActionJsPlugin", 2, "handleJsRequest: ", paramJsBridgeListener);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneFeedActionJsPlugin
 * JD-Core Version:    0.7.0.1
 */