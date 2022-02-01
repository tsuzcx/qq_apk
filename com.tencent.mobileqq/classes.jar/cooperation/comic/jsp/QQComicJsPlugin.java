package cooperation.comic.jsp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.SubTabParam;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.SubTabRedHotParam;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.VipComicHelper;
import cooperation.comic.VipComicHelper.ExtraParams;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.webbundle.WebBundleReportUtils;
import java.io.File;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQComicJsPlugin
  extends VasWebviewJsPlugin
{
  public static final Handler a;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static String f = null;
  public int a;
  QQComicJsCallback jdField_a_of_type_CooperationComicJspQQComicJsCallback = new QQComicJsPlugin.1(this);
  public QQComicJsPluginProxy a;
  public String a;
  public final AtomicInteger a;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public String b = null;
  public String c = "";
  public String d = "";
  String e = null;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QQComicJsPluginDeamon", 0);
    localHandlerThread.start();
    jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public QQComicJsPlugin()
  {
    this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_Int = 0;
    this.mPluginNameSpace = "comic";
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.remove("openWithWebBundle");
      paramBundle.remove("real_url");
      paramBundle.remove("preload_url");
      paramBundle.remove("bundle_data");
    }
  }
  
  private void a(String paramString, WebViewFragment paramWebViewFragment)
  {
    Object localObject;
    int i;
    if (paramWebViewFragment != null)
    {
      localObject = "ok";
      if (paramWebViewFragment.mSwiftTitleUI.a(false)) {
        break label101;
      }
      i = -1;
    }
    for (paramWebViewFragment = "not exist sub tab";; paramWebViewFragment = (WebViewFragment)localObject)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("code", i);
        ((JSONObject)localObject).put("message", paramWebViewFragment);
        super.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (JSONException paramWebViewFragment)
      {
        for (;;)
        {
          QLog.e("QQComicJsPlugin", 1, paramWebViewFragment, new Object[0]);
          a(paramString, paramWebViewFragment.getMessage());
        }
      }
      a(paramString, "webViewFragment == null");
      return;
      label101:
      i = 0;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", -1);
      localJSONObject.put("msg", paramString2);
      super.callJs(paramString1 + "&&" + paramString1 + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.e("QQComicJsPlugin", 2, "callbackId->" + paramString1 + " errorMsg: " + paramString2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQComicJsPlugin", 2, localException.getMessage());
        }
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = paramJSONObject.optInt("type");
  }
  
  private void a(JSONObject paramJSONObject, String paramString, SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewFragment paramWebViewFragment)
  {
    boolean bool2 = true;
    if (paramWebViewFragment != null)
    {
      boolean bool1 = paramJSONObject.optBoolean("titleHide");
      boolean bool3 = paramJSONObject.optBoolean("bottomHide");
      paramJSONObject = paramWebViewFragment.mSwiftTitleUI;
      if (!bool1)
      {
        bool1 = true;
        paramJSONObject.b(bool1);
        if (bool3) {
          break label70;
        }
      }
      label70:
      for (bool1 = bool2;; bool1 = false)
      {
        paramSwiftWebViewFragmentSupporter.setBottomBarVisibility(bool1);
        return;
        bool1 = false;
        break;
      }
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void a(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQComicJsPlugin", 2, "initPrivateSettingIcon " + paramJSONObject.optInt("status", -1));
    }
    if (paramWebViewFragment != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramJSONObject.optInt("status", -1));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
      this.b = paramJSONObject.optString("callbackName");
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0) && (!BaseApplicationImpl.getApplication().getSharedPreferences("boodo_" + this.mRuntime.a().getCurrentAccountUin(), 0).getBoolean("private_read_red_dot", false)))
      {
        paramWebViewFragment.mSwiftTitleUI.d(true);
        QLog.i("QQComicJsPlugin", 1, "show private read red dot.");
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("code", 0);
        super.callJs(paramString, new String[] { paramJSONObject.toString() });
      }
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      VipComicHelper.jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams.b(this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicJsPlugin", 2, "setContainerInfo success on Resume extrasParams: " + VipComicHelper.jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams.toString());
    }
  }
  
  private void b(String paramString, WebViewFragment paramWebViewFragment)
  {
    Object localObject;
    int i;
    if (paramWebViewFragment != null)
    {
      localObject = "ok";
      if (paramWebViewFragment.mSwiftTitleUI.a(true)) {
        break label101;
      }
      i = -1;
    }
    for (paramWebViewFragment = "not exist sub tab";; paramWebViewFragment = (WebViewFragment)localObject)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("code", i);
        ((JSONObject)localObject).put("message", paramWebViewFragment);
        super.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (JSONException paramWebViewFragment)
      {
        for (;;)
        {
          QLog.e("QQComicJsPlugin", 1, paramWebViewFragment, new Object[0]);
          a(paramString, paramWebViewFragment.getMessage());
        }
      }
      a(paramString, "webViewFragment == null");
      return;
      label101:
      i = 0;
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    VipComicHelper.a(paramJSONObject.optInt("useWebBundle"));
  }
  
  private void b(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      int j = paramJSONObject.optInt("action");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("subIndexArray");
      Object localObject = null;
      paramJSONObject = localObject;
      if (localJSONArray != null)
      {
        paramJSONObject = localObject;
        if (localJSONArray.length() > 0)
        {
          paramJSONObject = new int[localJSONArray.length()];
          int i = 0;
          while (i < localJSONArray.length())
          {
            paramJSONObject[i] = localJSONArray.getInt(i);
            i += 1;
          }
        }
      }
      if (((j != 1) && (j != 2)) || (paramJSONObject == null))
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("code", -1);
        paramJSONObject.put("message", "param is invalid");
        super.callJs(paramString, new String[] { paramJSONObject.toString() });
        return;
      }
      paramWebViewFragment.mSwiftTitleUI.a(new SwiftIphoneTitleBarUI.SubTabRedHotParam(paramJSONObject, j, paramString));
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private static String c()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getCacheDir();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((File)localObject1).getAbsolutePath() + "/qqcomic/cache/";
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (!Environment.getExternalStorageState().equals("mounted"));
      localObject1 = localObject2;
    } while (!Environment.getExternalStorageDirectory().exists());
    localObject1 = BaseApplicationImpl.getApplication().getExternalCacheDir();
    if (localObject1 != null) {
      return ((File)localObject1).getAbsolutePath() + "/qqcomic/cache/";
    }
    return VFSAssistantUtils.getSDKPrivatePath("tencent/MobileQQ/qqcomic/cache/");
  }
  
  private void c(String paramString, WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject1.put("code", 0);
        localJSONObject1.put("message", "ok");
        localJSONObject2.put("subIndex", paramWebViewFragment.mSwiftTitleUI.a());
        localJSONObject1.put("data", localJSONObject2);
        super.callJs(paramString, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException paramWebViewFragment)
      {
        for (;;)
        {
          QLog.e("QQComicJsPlugin", 1, paramWebViewFragment, new Object[0]);
          a(paramString, paramWebViewFragment.getMessage());
        }
      }
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    String str2 = paramJSONObject.optString("bundle_url", "");
    paramJSONObject.optString("preloadSource", "");
    paramJSONObject = this.mRuntime.a();
    Intent localIntent;
    if (paramJSONObject != null)
    {
      localIntent = new Intent();
      localIntent.putExtra("url", str1);
      VipComicHelper.a(localIntent);
      if (localJSONObject == null) {
        break label131;
      }
      localIntent.putExtra("openWithWebBundle", true);
      if (!WebBundleManager.getInstance("comic").openWebViewWithWebBundle(paramJSONObject, str1, localJSONObject, localIntent, str2)) {}
    }
    else
    {
      return;
    }
    WebBundleReportUtils.a(str1, false, WebBundleReportUtils.b);
    for (;;)
    {
      a(localIntent.getExtras());
      VipComicHelper.a(paramJSONObject, localIntent, 100);
      return;
      label131:
      WebBundleReportUtils.a(str1, false, WebBundleReportUtils.e);
    }
  }
  
  private void c(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    int j = paramJSONObject.optInt("tabNum", 2);
    int k = paramJSONObject.optInt("subIndex");
    String str = paramJSONObject.optString("switchCallback");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("subTextArray");
    String[] arrayOfString = null;
    paramJSONObject = arrayOfString;
    if (localJSONArray != null)
    {
      paramJSONObject = arrayOfString;
      if (localJSONArray.length() > 0)
      {
        arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        for (;;)
        {
          paramJSONObject = arrayOfString;
          if (i >= localJSONArray.length()) {
            break;
          }
          arrayOfString[i] = localJSONArray.getString(i);
          i += 1;
        }
      }
    }
    if (paramWebViewFragment != null)
    {
      paramWebViewFragment.mSwiftTitleUI.a(new SwiftIphoneTitleBarUI.SubTabParam(k, j, str, paramString, paramJSONObject));
      return;
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void d(String paramString, WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      paramWebViewFragment.mSwiftTitleUI.b(paramString);
      return;
    }
    QLog.e("QQComicJsPlugin", 1, "webViewFragment == null");
    a(paramString, "webViewFragment == null");
  }
  
  private void d(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    Object localObject = paramJSONObject.optString("switchCallback");
    paramJSONObject = "ok";
    int i;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      i = -1;
      paramJSONObject = "the subTabCallback isEmpty";
    }
    for (;;)
    {
      if (paramWebViewFragment != null)
      {
        localObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("code", i);
          ((JSONObject)localObject).put("message", paramJSONObject);
          localJSONObject.put("subIndex", paramWebViewFragment.mSwiftTitleUI.a());
          ((JSONObject)localObject).put("data", localJSONObject);
          super.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
          return;
          if (paramWebViewFragment != null) {
            paramWebViewFragment.mSwiftTitleUI.a.a((String)localObject, false);
          }
          i = 0;
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            QLog.e("QQComicJsPlugin", 1, paramJSONObject, new Object[0]);
            a(paramString, paramJSONObject.getMessage());
          }
        }
      }
    }
    a(paramString, "webViewFragment == null");
  }
  
  private void e(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    paramJSONObject = paramJSONObject.optString("name", "");
    if (paramWebViewFragment != null)
    {
      paramWebViewFragment.mSwiftTitleUI.c(paramJSONObject);
      return;
    }
    QLog.e("QQComicJsPlugin", 1, "webViewFragment == null");
    a(paramString, "webViewFragment == null");
  }
  
  private void f(JSONObject paramJSONObject, String paramString, WebViewFragment paramWebViewFragment)
  {
    int i = paramJSONObject.optInt("alpha");
    if (paramWebViewFragment != null)
    {
      paramWebViewFragment.mSwiftTitleUI.b(i);
      return;
    }
    QLog.e("QQComicJsPlugin", 1, "webViewFragment == null");
    a(paramString, "webViewFragment == null");
  }
  
  public long a()
  {
    long l1 = 0L;
    for (;;)
    {
      try
      {
        Object localObject2 = c();
        if (localObject2 == null) {
          return l1;
        }
        Stack localStack = new Stack();
        localStack.push(localObject2);
        l1 = 0L;
        int i;
        if (!localStack.isEmpty())
        {
          localObject2 = new File((String)localStack.pop());
          l2 = l1;
          if (((File)localObject2).isDirectory())
          {
            String[] arrayOfString = ((File)localObject2).list();
            l2 = l1;
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              i = 0;
              if (i >= j) {
                break label178;
              }
              File localFile = new File((File)localObject2, arrayOfString[i]);
              if (localFile.isDirectory())
              {
                localStack.push(localFile.getAbsolutePath());
                break label171;
              }
              l1 += localFile.length();
              break label171;
            }
          }
          l1 = ((File)localObject2).length();
          l1 = l2 + l1;
        }
        else
        {
          continue;
        }
        i += 1;
      }
      finally {}
      label171:
      continue;
      label178:
      long l2 = l1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy != null) {
      this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy.a();
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: putstatic 30	cooperation/comic/jsp/QQComicJsPlugin:f	Ljava/lang/String;
    //   6: getstatic 28	cooperation/comic/jsp/QQComicJsPlugin:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: invokevirtual 516	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: getstatic 28	cooperation/comic/jsp/QQComicJsPlugin:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_1
    //   24: invokevirtual 518	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: new 520	cooperation/comic/jsp/QQComicJsPlugin$4
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 521	cooperation/comic/jsp/QQComicJsPlugin$4:<init>	(Lcooperation/comic/jsp/QQComicJsPlugin;)V
    //   35: iconst_5
    //   36: aconst_null
    //   37: iconst_1
    //   38: invokestatic 525	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   41: goto -24 -> 17
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	QQComicJsPlugin
    //   0	49	1	paramString	String
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	44	finally
    //   20	41	44	finally
  }
  
  void a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "create a new js plugin");
      }
      this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy = QQComicPluginBridge.a(this.mRuntime, this.jdField_a_of_type_CooperationComicJspQQComicJsCallback);
    }
    if (this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy != null) {
      this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy.a(paramString1, paramJSONObject);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "create js plugin failed");
      }
    } while (TextUtils.isEmpty(paramString2));
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("code", 2002);
      paramString1.put("message", "create js plugin failed");
      super.callJs(paramString2, new String[] { paramString1.toString() });
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, JSONObject paramJSONObject, String paramString2, long paramLong)
  {
    jdField_a_of_type_AndroidOsHandler.post(new QQComicJsPlugin.3(this, paramLong, paramString1, paramJSONObject, paramString2));
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 258L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934601L)
    {
      if (!TextUtils.isEmpty(this.e))
      {
        super.callJs(this.e, new String[] { "" });
        return true;
      }
    }
    else if ((paramLong == 2L) || (paramLong == 256L)) {
      b();
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"comic".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        if (paramVarArgs.length > 0)
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("callback", "");
          paramString2 = this.mRuntime.a();
          paramVarArgs = (WebViewFragment)this.mRuntime.a();
          if (!"getFirstShowData".equals(paramString3)) {
            break;
          }
          paramJsBridgeListener = (String)VipComicHelper.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
          paramString2 = new JSONObject();
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2.put("code", 0);
            paramString2.put("message", "ok");
            paramString2.put("data", paramJsBridgeListener);
            super.callJs(paramString1, new String[] { paramString2.toString() });
            if (!QLog.isColorLevel()) {
              break label1313;
            }
            QLog.d("QQComicJsPlugin", 2, "js getFirstShowData:" + paramJsBridgeListener);
            break label1313;
          }
        }
        else
        {
          paramJsBridgeListener = new JSONObject();
          continue;
        }
        paramString2.put("code", -1);
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        QLog.e("QQComicJsPlugin", 1, "handle js error!", paramJsBridgeListener);
      }
      paramString2.put("message", HardCodeUtil.a(2131710146));
      paramString2.put("data", "");
    }
    if ("setTitleBarBackground".equals(paramString3))
    {
      f(paramJsBridgeListener, paramString1, paramVarArgs);
    }
    else if ("onWebViewScrollChanged".equals(paramString3))
    {
      d(paramString1, paramVarArgs);
    }
    else if ("setTitleName".equals(paramString3))
    {
      e(paramJsBridgeListener, paramString1, paramVarArgs);
    }
    else if ("attachSwitchChannel".equals(paramString3))
    {
      d(paramJsBridgeListener, paramString1, paramVarArgs);
    }
    else if ("setSwitchChannel".equals(paramString3))
    {
      c(paramJsBridgeListener, paramString1, paramVarArgs);
    }
    else if ("getSwitchChannel".equals(paramString3))
    {
      c(paramString1, paramVarArgs);
    }
    else if ("showSwitchChannel".equals(paramString3))
    {
      b(paramString1, paramVarArgs);
    }
    else if ("hideSwitchChannel".equals(paramString3))
    {
      a(paramString1, paramVarArgs);
    }
    else if ("setTabRedPoint".equals(paramString3))
    {
      b(paramJsBridgeListener, paramString1, paramVarArgs);
    }
    else if ("getTitleBarHeight".equals(paramString3))
    {
      paramJsBridgeListener = new JSONObject();
      paramString2 = new JSONObject();
      int j = this.mRuntime.a().getResources().getDimensionPixelSize(2131299166);
      i = j;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i = j + ImmersiveUtils.getStatusBarHeight(this.mRuntime.a());
      }
      paramString2.put("height", i);
      paramJsBridgeListener.put("code", 0);
      paramJsBridgeListener.put("message", "ok");
      paramJsBridgeListener.put("data", paramString2);
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
    }
    else if ("openQQBrowser".equals(paramString3))
    {
      paramString1 = new Intent();
      paramString1.putExtra("url", paramJsBridgeListener.optString("url"));
      VipComicHelper.a(paramString2, paramString1, -1);
    }
    else if ("closeCurrentWebview".equals(paramString3))
    {
      if (!paramString2.isFinishing()) {
        paramString2.finish();
      }
    }
    else if ("setTitleAndBottomBar".equals(paramString3))
    {
      a(paramJsBridgeListener, paramString1, (SwiftWebViewFragmentSupporter)paramString2, paramVarArgs);
    }
    else if ("setLeftCallback".equals(paramString3))
    {
      this.e = paramJsBridgeListener.optString("leftcallback");
    }
    else if ("openView".equals(paramString3))
    {
      paramString1 = paramJsBridgeListener.getJSONObject("options");
      paramJsBridgeListener = paramJsBridgeListener.optString("name");
      paramString3 = new Intent();
      paramString3.setComponent(new ComponentName("com.tencent.mobileqq", paramJsBridgeListener));
      paramString3.putExtra("options", paramString1.toString());
      paramString2.startActivity(paramString3);
    }
    else if ("getReporterInfo".equals(paramString3))
    {
      paramJsBridgeListener = new JSONObject();
      paramString2 = new JSONObject();
      paramString2.put("mod", VipComicHelper.jdField_a_of_type_JavaLangString);
      paramString2.put("land_page", VipComicHelper.c);
      paramString2.put("obj_ownerid", VipComicHelper.b);
      paramJsBridgeListener.put("data", paramString2);
      paramJsBridgeListener.put("resultCode", 0);
      paramJsBridgeListener.put("message", "ok");
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
    }
    else if ("getCacheSize".equals(paramString3))
    {
      paramJsBridgeListener = new JSONObject();
      paramJsBridgeListener.put("result", 0);
      paramJsBridgeListener.put("message", "ok");
      paramString2 = new JSONObject();
      paramString2.put("size", a());
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label1315;
      }
    }
    label1313:
    label1315:
    for (int i = 1;; i = 2)
    {
      paramString2.put("status", i);
      paramJsBridgeListener.put("data", paramString2);
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
      break label1313;
      if ("clearCache".equals(paramString3))
      {
        a(paramString1);
      }
      else if ("initPrivateSettingIcon".equals(paramString3))
      {
        a(paramJsBridgeListener, paramString1, paramVarArgs);
      }
      else if ("openWebBundleView".equals(paramString3))
      {
        c(paramJsBridgeListener);
      }
      else if ("setColorfulTabInfo".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicJsPlugin", 2, "setColorfulTabInfo " + paramJsBridgeListener.optString("tabTitle", "fail"));
        }
        this.c = paramJsBridgeListener.optString("tabTitle", "");
        this.d = paramJsBridgeListener.optString("tabSubTitle", "");
      }
      else if ("setWebBundleOption".equals(paramString3))
      {
        b(paramJsBridgeListener);
      }
      else if ("setShareOption".equals(paramString3))
      {
        a(paramJsBridgeListener);
      }
      else if ("setContainerInfo".equals(paramString3))
      {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramJsBridgeListener.optString("read_params"));
        VipComicHelper.jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams.b(this.jdField_a_of_type_OrgJsonJSONObject);
        if (QLog.isColorLevel()) {
          QLog.d("QQComicJsPlugin", 2, "setContainerInfo success extrasParams: " + VipComicHelper.jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams.toString());
        }
      }
      else if (QQComicPluginBridge.a)
      {
        ThreadManager.getUIHandler().post(new QQComicJsPlugin.2(this, paramString3, paramJsBridgeListener, paramString1));
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "js plugin is not ready...");
        }
        a(paramString3, paramJsBridgeListener, paramString1, 3000L);
      }
      return true;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy != null) {
      this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.jsp.QQComicJsPlugin
 * JD-Core Version:    0.7.0.1
 */