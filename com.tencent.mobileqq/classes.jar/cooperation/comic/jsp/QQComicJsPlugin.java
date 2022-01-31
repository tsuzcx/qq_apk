package cooperation.comic.jsp;

import amjt;
import amju;
import amjv;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.SubTabParam;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.SubTabRedHotParam;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.VipComicHelper;
import cooperation.comic.VipComicReportUtils;
import cooperation.comic.utils.QQComicPluginBridge;
import java.io.File;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQComicJsPlugin
  extends VasWebviewJsPlugin
{
  public static final Handler a;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static String d;
  QQComicJsCallback jdField_a_of_type_CooperationComicJspQQComicJsCallback = new amjt(this);
  public QQComicJsPluginProxy a;
  public String a;
  public final AtomicInteger a;
  public String b;
  String c = null;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QQComicJsPluginDeamon", 0);
    localHandlerThread.start();
    jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public QQComicJsPlugin()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.mPluginNameSpace = "comic";
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
    localObject1 = VipComicReportUtils.a();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject1).append("/tencent/MobileQQ/qqcomic/cache/");
    return ((StringBuilder)localObject1).toString();
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
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: putstatic 87	cooperation/comic/jsp/QQComicJsPlugin:d	Ljava/lang/String;
    //   6: getstatic 24	cooperation/comic/jsp/QQComicJsPlugin:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: getstatic 24	cooperation/comic/jsp/QQComicJsPlugin:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_1
    //   24: invokevirtual 181	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: new 183	amjx
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 184	amjx:<init>	(Lcooperation/comic/jsp/QQComicJsPlugin;)V
    //   35: iconst_5
    //   36: aconst_null
    //   37: iconst_1
    //   38: invokestatic 188	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
  
  public void a(String paramString1, JSONObject paramJSONObject, String paramString2)
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
    jdField_a_of_type_AndroidOsHandler.post(new amjv(this, paramLong, paramString1, paramJSONObject, paramString2));
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934601L) && (!TextUtils.isEmpty(this.c)))
    {
      super.callJs(this.c, new String[] { "" });
      return true;
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = -1;
    int m = 0;
    int k = 0;
    boolean bool2 = false;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQComicJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"comic".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    try
    {
      if (paramVarArgs.length > 0) {}
      for (paramJsBridgeListener = new JSONObject(paramVarArgs[0]);; paramJsBridgeListener = new JSONObject())
      {
        paramString2 = paramJsBridgeListener.optString("callback", "");
        paramString1 = this.mRuntime.a();
        paramVarArgs = this.mRuntime.a();
        if (paramVarArgs != null) {
          break;
        }
        QLog.e("QQComicJsPlugin", 1, "No fragment...");
        return true;
      }
      if ("getFirstShowData".equals(paramString3))
      {
        paramJsBridgeListener = (String)VipComicHelper.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
        paramString1 = new JSONObject();
        if (!TextUtils.isEmpty(paramJsBridgeListener))
        {
          paramString1.put("code", 0);
          paramString1.put("message", "ok");
          paramString1.put("data", paramJsBridgeListener);
        }
        for (;;)
        {
          super.callJs(paramString2, new String[] { paramString1.toString() });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QQComicJsPlugin", 2, "js getFirstShowData:" + paramJsBridgeListener);
          break;
          paramString1.put("code", -1);
          paramString1.put("message", "首屏数据未准备好");
          paramString1.put("data", "");
        }
      }
      if (!"setTitleBarBackground".equals(paramString3)) {
        break label339;
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
      QLog.e("QQComicJsPlugin", 1, "handle js error!", paramJsBridgeListener);
    }
    i = paramJsBridgeListener.optInt("alpha");
    paramVarArgs.a.b(i);
    break label1958;
    label339:
    label1020:
    boolean bool1;
    if ("onWebViewScrollChanged".equals(paramString3))
    {
      paramVarArgs.a.b(paramString2);
    }
    else if ("setTitleName".equals(paramString3))
    {
      paramJsBridgeListener = paramJsBridgeListener.optString("name", "");
      paramVarArgs.a.c(paramJsBridgeListener);
    }
    else
    {
      if ("attachSwitchChannel".equals(paramString3))
      {
        paramString1 = paramJsBridgeListener.optString("switchCallback");
        paramJsBridgeListener = "ok";
        if (TextUtils.isEmpty(paramString1)) {
          paramJsBridgeListener = "the subTabCallback isEmpty";
        }
        for (;;)
        {
          paramString1 = new JSONObject();
          paramString3 = new JSONObject();
          try
          {
            paramString1.put("code", i);
            paramString1.put("message", paramJsBridgeListener);
            paramString3.put("subIndex", paramVarArgs.a.a());
            paramString1.put("data", paramString3);
            super.callJs(paramString2, new String[] { paramString1.toString() });
            break label1958;
            paramVarArgs.a.a.a(paramString1, false);
            i = 0;
          }
          catch (Exception paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
      }
      if ("setSwitchChannel".equals(paramString3))
      {
        k = paramJsBridgeListener.optInt("tabNum", 2);
        m = paramJsBridgeListener.optInt("subIndex");
        paramString1 = paramJsBridgeListener.optString("switchCallback");
        paramString3 = paramJsBridgeListener.optJSONArray("subTextArray");
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          paramJsBridgeListener = new String[paramString3.length()];
          i = j;
          while (i < paramString3.length())
          {
            paramJsBridgeListener[i] = paramString3.getString(i);
            i += 1;
          }
          paramVarArgs.a.a(new SwiftIphoneTitleBarUI.SubTabParam(m, k, paramString1, paramString2, paramJsBridgeListener));
          break label1958;
        }
      }
      else
      {
        if ("getSwitchChannel".equals(paramString3))
        {
          paramJsBridgeListener = new JSONObject();
          paramString1 = new JSONObject();
          try
          {
            paramJsBridgeListener.put("code", 0);
            paramJsBridgeListener.put("message", "ok");
            paramString1.put("subIndex", paramVarArgs.a.a());
            paramJsBridgeListener.put("data", paramString1);
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
        }
        if ("showSwitchChannel".equals(paramString3))
        {
          paramJsBridgeListener = "ok";
          if (!paramVarArgs.a.a(true))
          {
            paramJsBridgeListener = "not exist sub tab";
            label792:
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("code", i);
              paramString1.put("message", paramJsBridgeListener);
              super.callJs(paramString2, new String[] { paramString1.toString() });
            }
            catch (Exception paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
        }
        else
        {
          if ("hideSwitchChannel".equals(paramString3))
          {
            paramJsBridgeListener = "ok";
            i = m;
            if (!paramVarArgs.a.a(false))
            {
              paramJsBridgeListener = "not exist sub tab";
              i = -1;
            }
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("code", i);
              paramString1.put("message", paramJsBridgeListener);
              super.callJs(paramString2, new String[] { paramString1.toString() });
            }
            catch (Exception paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          if ("setTabRedPoint".equals(paramString3))
          {
            j = paramJsBridgeListener.optInt("action");
            paramString3 = paramJsBridgeListener.optJSONArray("subIndexArray");
            if ((paramString3 == null) || (paramString3.length() <= 0)) {
              break label1963;
            }
            paramString1 = new int[paramString3.length()];
            i = k;
            for (;;)
            {
              paramJsBridgeListener = paramString1;
              if (i >= paramString3.length()) {
                break;
              }
              paramString1[i] = paramString3.getInt(i);
              i += 1;
            }
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("code", -1);
            paramJsBridgeListener.put("message", "param is invalid");
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
            break label1958;
            label1065:
            paramVarArgs.a.a(new SwiftIphoneTitleBarUI.SubTabRedHotParam(paramJsBridgeListener, j, paramString2));
            break label1958;
          }
          if ("getTitleBarHeight".equals(paramString3))
          {
            paramJsBridgeListener = new JSONObject();
            paramString1 = new JSONObject();
            j = this.mRuntime.a().getResources().getDimensionPixelSize(2131558448);
            i = j;
            if (ImmersiveUtils.isSupporImmersive() == 1) {
              i = j + ImmersiveUtils.a(this.mRuntime.a());
            }
            paramString1.put("height", i);
            paramJsBridgeListener.put("code", 0);
            paramJsBridgeListener.put("message", "ok");
            paramJsBridgeListener.put("data", paramString1);
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
            break label1958;
          }
          if ("openQQBrowser".equals(paramString3))
          {
            paramString2 = new Intent();
            paramString2.putExtra("url", paramJsBridgeListener.optString("url"));
            VipComicHelper.a(paramString1, paramString2, -1);
            break label1958;
          }
          if ("closeCurrentWebview".equals(paramString3))
          {
            if (paramString1.isFinishing()) {
              break label1958;
            }
            paramString1.finish();
            break label1958;
          }
          if ("setTitleAndBottomBar".equals(paramString3))
          {
            bool1 = paramJsBridgeListener.optBoolean("titleHide");
            boolean bool3 = paramJsBridgeListener.optBoolean("bottomHide");
            paramJsBridgeListener = paramVarArgs.a;
            if (bool1) {
              break label1984;
            }
            bool1 = true;
            label1325:
            paramJsBridgeListener.b(bool1);
            paramJsBridgeListener = (SwiftWebViewFragmentSupporter)paramString1;
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
            paramJsBridgeListener.a(bool1);
            break label1958;
          }
          if ("setLeftCallback".equals(paramString3))
          {
            this.c = paramJsBridgeListener.optString("leftcallback");
            break label1958;
          }
          if ("openView".equals(paramString3))
          {
            paramString2 = paramJsBridgeListener.getJSONObject("options");
            paramJsBridgeListener = paramJsBridgeListener.optString("name");
            paramString3 = new Intent();
            paramString3.setComponent(new ComponentName("com.tencent.mobileqq", paramJsBridgeListener));
            paramString3.putExtra("options", paramString2.toString());
            paramString1.startActivity(paramString3);
            break label1958;
          }
          if ("getReporterInfo".equals(paramString3))
          {
            paramJsBridgeListener = new JSONObject();
            paramString1 = new JSONObject();
            paramString1.put("mod", VipComicHelper.jdField_a_of_type_JavaLangString);
            paramString1.put("land_page", VipComicHelper.c);
            paramString1.put("obj_ownerid", VipComicHelper.b);
            paramJsBridgeListener.put("data", paramString1);
            paramJsBridgeListener.put("resultCode", 0);
            paramJsBridgeListener.put("message", "ok");
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
            break label1958;
          }
          if ("getCacheSize".equals(paramString3))
          {
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("result", 0);
            paramJsBridgeListener.put("message", "ok");
            paramString1 = new JSONObject();
            paramString1.put("size", a());
            if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
              break label1990;
            }
          }
        }
      }
    }
    label1958:
    label1963:
    label1984:
    label1990:
    for (i = 1;; i = 2)
    {
      paramString1.put("status", i);
      paramJsBridgeListener.put("data", paramString1);
      super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      break label1958;
      if ("clearCache".equals(paramString3))
      {
        a(paramString2);
      }
      else if ("initPrivateSettingIcon".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQComicJsPlugin", 2, "initPrivateSettingIcon " + paramJsBridgeListener.optInt("status", -1));
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramJsBridgeListener.optInt("status", -1));
        this.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("name");
        this.b = paramJsBridgeListener.optString("callbackName");
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0) && (!this.mRuntime.a().getApp().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin(), 0).getBoolean("private_read_red_dot", false)))
        {
          paramVarArgs.a.c(true);
          QLog.i("QQComicJsPlugin", 1, "show private read red dot.");
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("code", 0);
          super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
        }
      }
      else if (QQComicPluginBridge.a)
      {
        ThreadManager.getUIHandler().post(new amju(this, paramString3, paramJsBridgeListener, paramString2));
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "js plugin is not ready...");
        }
        a(paramString3, paramJsBridgeListener, paramString2, 3000L);
        break label1958;
        i = 0;
        break label792;
        paramJsBridgeListener = null;
        break;
      }
      return true;
      break;
      paramJsBridgeListener = null;
      if ((j != 1) && (j != 2)) {
        break label1020;
      }
      if (paramJsBridgeListener != null) {
        break label1065;
      }
      break label1020;
      bool1 = false;
      break label1325;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy != null) {
      this.jdField_a_of_type_CooperationComicJspQQComicJsPluginProxy.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.jsp.QQComicJsPlugin
 * JD-Core Version:    0.7.0.1
 */