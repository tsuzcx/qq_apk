package com.tencent.mobileqq.vashealth;

import akjj;
import akjk;
import akjl;
import akjo;
import akjp;
import akjq;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HealthStepCounterPlugin
  extends VasWebviewJsPlugin
  implements DialogInterface.OnDismissListener
{
  public static int a;
  public static long a;
  private static akjq jdField_a_of_type_Akjq;
  public static boolean a;
  public static int b;
  public static boolean b;
  public Activity a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString = null;
  public HashMap a;
  public AtomicBoolean a;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new akjo(this);
  String b;
  public HashMap b;
  public int c;
  String c;
  public HashMap c;
  public int d;
  String d;
  public String e = null;
  public String f = null;
  public String g = null;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Boolean = true;
  }
  
  public HealthStepCounterPlugin()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.mPluginNameSpace = "healthkit";
  }
  
  private JSONObject a(String paramString)
  {
    label260:
    do
    {
      do
      {
        try
        {
          localJSONObject = new JSONObject();
          paramString = new JSONObject(paramString);
          str = paramString.getString("callback");
          i = paramString.optInt("x");
          j = paramString.optInt("y");
          k = paramString.optInt("w");
          m = paramString.optInt("h");
          paramString = this.mRuntime.a();
          if (QLog.isColorLevel()) {
            QLog.i("HealthStepCounterPlugin", 2, "webview:" + paramString.getWidth() + "," + paramString.getHeight());
          }
          localObject = Bitmap.createBitmap(paramString.getWidth(), paramString.getHeight(), Bitmap.Config.ARGB_8888);
          paramString.draw(new Canvas((Bitmap)localObject));
          int n = this.mRuntime.a().getWindowManager().getDefaultDisplay().getWidth();
          int i1 = this.mRuntime.a().getWindowManager().getDefaultDisplay().getHeight();
          if ((i >= 0) && (j >= 0) && (k <= n) && (m <= i1)) {
            break label260;
          }
          localJSONObject.put("code", -1);
          localJSONObject.put("image_url", "");
          callJs(str, new String[] { localJSONObject.toString() });
          paramString = localJSONObject;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            paramString = localJSONObject;
          }
        }
        catch (Exception paramString)
        {
          JSONObject localJSONObject;
          String str;
          int i;
          int j;
          int k;
          int m;
          Object localObject;
          if (!QLog.isColorLevel()) {
            break label580;
          }
          QLog.e("HealthStepCounterPlugin", 2, "Exception:" + paramString.toString());
          paramString = null;
          return null;
        }
        finally
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
            break label613;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        return paramString;
        paramString = (String)localObject;
        if (k > 0)
        {
          paramString = (String)localObject;
          if (m > 0) {
            paramString = Bitmap.createBitmap((Bitmap)localObject, i, j, k, m);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("HealthStepCounterPlugin", 2, "bitmap size:" + paramString.getByteCount());
        }
        localObject = new File(Environment.getExternalStorageDirectory(), "/Android/data/" + this.jdField_a_of_type_AndroidAppActivity.getPackageName() + "/cache/");
        ((File)localObject).mkdirs();
        localObject = ((File)localObject).getAbsolutePath();
        localObject = (String)localObject + File.separator + System.currentTimeMillis() + ".png";
        ImageUtil.a(paramString, new File((String)localObject));
        if (paramString == null) {
          break;
        }
        localJSONObject.put("code", 0);
        localJSONObject.put("image_url", localObject);
        callJs(str, new String[] { localJSONObject.toString() });
        paramString = localJSONObject;
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return localJSONObject;
      localJSONObject.put("code", -2);
      localJSONObject.put("image_url", "");
      callJs(str, new String[] { localJSONObject.toString() });
      paramString = localJSONObject;
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    return localJSONObject;
  }
  
  private void a(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (jdField_a_of_type_Akjq == null)
    {
      localObject1 = new akjq(null);
      localObject2 = (SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor");
      ((SensorManager)localObject2).registerListener((SensorEventListener)localObject1, ((SensorManager)localObject2).getDefaultSensor(1), 0);
      jdField_a_of_type_Akjq = (akjq)localObject1;
      QLog.d("HealthStepCounterPlugin", 1, "register shakelistener");
    }
    try
    {
      this.e = new JSONObject(paramString).getString("callback");
      label71:
      if (!TextUtils.isEmpty(this.e))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localObject1 = (SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor");
        localObject2 = ((SensorManager)localObject1).getDefaultSensor(19);
        if ((Build.VERSION.SDK_INT >= 19) && (localObject2 != null)) {
          break label180;
        }
        this.f = "Unsupported model found.";
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("retCode", jdField_a_of_type_Int);
        paramString.put("msg", this.f);
        label160:
        callJs(this.e, new String[] { paramString.toString() });
        return;
        label180:
        akjp localakjp = new akjp(this);
        ((SensorManager)localObject1).registerListener(localakjp, (Sensor)localObject2, 3, 0);
        ((SensorManager)localObject1).flush(localakjp);
        localObject1 = new NewIntent(this.mRuntime.a().getApplication(), StepCounterServlert.class);
        ((NewIntent)localObject1).putExtra("msf_cmd_type", "cmd_refresh_steps");
        ((NewIntent)localObject1).putExtra("json_string", paramString);
        ((NewIntent)localObject1).setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.mRuntime.a().startServlet((NewIntent)localObject1);
        return;
      }
      catch (Exception localException)
      {
        break label160;
      }
    }
    catch (Throwable localThrowable)
    {
      break label71;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject1;
    label132:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject1 = new JSONObject(paramString1);
              paramString1 = ((JSONObject)localObject1).getString("callback");
              if (!TextUtils.isEmpty(paramString1))
              {
                if (NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)) {
                  break label132;
                }
                paramString2 = new JSONObject();
                paramString2.put("ssoRet", 103);
                paramString2.put("businessRet", 0);
                paramString2.put("msg", "MSF未连接");
                super.callJs(paramString1, new String[] { paramString2.toString() });
                return;
              }
            }
            catch (Exception paramString1) {}
          }
        } while (!QLog.isColorLevel());
        QLog.e("HealthStepCounterPlugin", 2, "Exception:" + paramString1);
        return;
        l1 = 10240L;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("yundong_report.steps")) {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get("yundong_report.steps")).longValue();
        }
        if ((l1 > 0L) && (((JSONObject)localObject1).toString().getBytes().length > l1))
        {
          paramString2 = new JSONObject();
          paramString2.put("ssoRet", 101);
          paramString2.put("businessRet", 0);
          paramString2.put("msg", "请求数据过大");
          super.callJs(paramString1, new String[] { paramString2.toString() });
          return;
        }
        if (this.jdField_c_of_type_JavaUtilHashMap.containsKey("yundong_report.steps"))
        {
          long l2 = ((Long)this.jdField_c_of_type_JavaUtilHashMap.get("yundong_report.steps")).longValue();
          l1 = 1000L;
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey("yundong_report.steps")) {
            l1 = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get("yundong_report.steps")).longValue();
          }
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 < l1))
          {
            paramString2 = new JSONObject();
            paramString2.put("ssoRet", 102);
            paramString2.put("businessRet", 0);
            paramString2.put("msg", "请求过于频繁");
            super.callJs(paramString1, new String[] { paramString2.toString() });
            this.jdField_c_of_type_JavaUtilHashMap.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
            return;
          }
        }
        this.jdField_c_of_type_JavaUtilHashMap.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
        paramString2 = new JSONObject(paramString2);
        if (!paramString2.getBoolean("isStepCounterEnable"))
        {
          QLog.i("HealthStepCounterPlugin", 1, "web process report step found step counter off!");
          return;
        }
        localObject2 = String.valueOf(SSOHttpUtils.a());
      } while ((paramString2 == null) || (!paramString2.has((String)localObject2 + "_total")) || (!paramString2.has((String)localObject2 + "_init")) || (!paramString2.has((String)localObject2 + "_offset")));
      int i = paramString2.getInt((String)localObject2 + "_total");
      int j = paramString2.getInt((String)localObject2 + "_init");
      int k = paramString2.getInt((String)localObject2 + "_offset");
      long l1 = NetConnInfoCenter.getServerTime();
      paramString2 = new JSONArray();
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("type", 1);
      ((JSONObject)localObject2).put("time", l1);
      ((JSONObject)localObject2).put("steps", k + (i - j));
      paramString2.put(localObject2);
      ((JSONObject)localObject1).put("oauth_consumer_key", 1002);
      ((JSONObject)localObject1).put("data", paramString2);
      ((JSONObject)localObject1).put("version", "7.6.3");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = URLEncoder.encode(Build.MODEL, "utf-8");
      }
      ((JSONObject)localObject1).put("model", this.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        paramString2 = TimeZone.getDefault();
        this.jdField_c_of_type_JavaLangString = (paramString2.getDisplayName(false, 0) + " " + paramString2.getID());
      }
      ((JSONObject)localObject1).put("zone", String.valueOf(this.jdField_c_of_type_JavaLangString));
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = MobileInfoUtil.c();
      }
      ((JSONObject)localObject1).put("imei", String.valueOf(this.jdField_b_of_type_JavaLangString));
      if (this.jdField_d_of_type_JavaLangString == null) {
        this.jdField_d_of_type_JavaLangString = DeviceInfoUtil.d(BaseApplicationImpl.getApplication().getApplicationContext());
      }
      ((JSONObject)localObject1).put("mac", String.valueOf(this.jdField_d_of_type_JavaLangString));
      if (QLog.isColorLevel()) {
        QLog.i("HealthStepCounterPlugin", 2, "parameters:" + ((JSONObject)localObject1).toString());
      }
      localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("7.6.3");
      paramString2 = new WebSSOAgent.UniSsoServerReq();
      paramString2.comm.set((MessageMicro)localObject2);
      paramString2.reqdata.set(((JSONObject)localObject1).toString());
      localObject1 = new akjl(this);
    } while (this.mRuntime == null);
    Object localObject2 = new NewIntent(this.mRuntime.a().getApplicationContext(), WebSSOAgentServlet.class);
    ((NewIntent)localObject2).putExtra("extra_cmd", "yundong_report.steps");
    ((NewIntent)localObject2).putExtra("extra_data", paramString2.toByteArray());
    ((NewIntent)localObject2).putExtra("extra_callbackid", paramString1);
    ((NewIntent)localObject2).setObserver((BusinessObserver)localObject1);
    this.mRuntime.a().startServlet((NewIntent)localObject2);
  }
  
  /* Error */
  private JSONObject b(String paramString)
  {
    // Byte code:
    //   0: new 83	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 84	org/json/JSONObject:<init>	()V
    //   7: astore 9
    //   9: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: aload_0
    //   14: getfield 109	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   17: ifnull +1104 -> 1121
    //   20: aload_0
    //   21: getfield 242	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   24: ifnull +1097 -> 1121
    //   27: iconst_0
    //   28: istore 5
    //   30: new 83	org/json/JSONObject
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 87	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_1
    //   40: ldc 89
    //   42: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 10
    //   47: aload 10
    //   49: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +6 -> 58
    //   55: aload 9
    //   57: areturn
    //   58: aload_1
    //   59: ldc_w 612
    //   62: invokevirtual 452	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   65: istore_2
    //   66: aload_1
    //   67: ldc 201
    //   69: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 11
    //   74: new 614	android/graphics/BitmapFactory$Options
    //   77: dup
    //   78: invokespecial 615	android/graphics/BitmapFactory$Options:<init>	()V
    //   81: astore_1
    //   82: aload_1
    //   83: iconst_1
    //   84: putfield 618	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   87: aload 11
    //   89: aload_1
    //   90: invokestatic 624	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   93: astore 8
    //   95: aload_1
    //   96: iconst_0
    //   97: putfield 618	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   100: aload 11
    //   102: aload_1
    //   103: invokestatic 624	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   106: astore_1
    //   107: aload_1
    //   108: astore 8
    //   110: new 232	java/io/File
    //   113: dup
    //   114: aload 11
    //   116: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +126 -> 247
    //   124: new 626	java/io/FileOutputStream
    //   127: dup
    //   128: aload_1
    //   129: invokespecial 629	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore 7
    //   134: aload 7
    //   136: astore_1
    //   137: aload 8
    //   139: getstatic 635	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   142: bipush 80
    //   144: aload 7
    //   146: invokevirtual 639	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   149: istore 6
    //   151: aload 7
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 215	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   158: ifnull +966 -> 1124
    //   161: aload 7
    //   163: astore_1
    //   164: aload_0
    //   165: getfield 215	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   168: invokevirtual 642	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   171: ifeq +953 -> 1124
    //   174: aload 7
    //   176: astore_1
    //   177: aload_0
    //   178: getfield 215	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   181: invokevirtual 220	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   184: goto +940 -> 1124
    //   187: aload 7
    //   189: astore_1
    //   190: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +36 -> 229
    //   196: aload 7
    //   198: astore_1
    //   199: ldc 122
    //   201: iconst_2
    //   202: new 124	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 644
    //   212: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   218: lload_3
    //   219: lsub
    //   220: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iload 6
    //   231: istore 5
    //   233: aload 7
    //   235: ifnull +12 -> 247
    //   238: aload 7
    //   240: invokevirtual 647	java/io/FileOutputStream:close	()V
    //   243: iload 6
    //   245: istore 5
    //   247: new 83	org/json/JSONObject
    //   250: dup
    //   251: invokespecial 84	org/json/JSONObject:<init>	()V
    //   254: astore_1
    //   255: iload 5
    //   257: ifeq +789 -> 1046
    //   260: aload_1
    //   261: ldc_w 649
    //   264: iconst_0
    //   265: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload_1
    //   270: ldc_w 332
    //   273: ldc_w 651
    //   276: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload_1
    //   281: ldc_w 653
    //   284: aload 11
    //   286: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   289: pop
    //   290: aload 9
    //   292: ldc 195
    //   294: iconst_0
    //   295: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   298: pop
    //   299: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +12 -> 314
    //   305: ldc 122
    //   307: iconst_2
    //   308: ldc_w 655
    //   311: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload_0
    //   315: aload 10
    //   317: iconst_1
    //   318: anewarray 208	java/lang/String
    //   321: dup
    //   322: iconst_0
    //   323: aload 9
    //   325: invokevirtual 209	org/json/JSONObject:toString	()Ljava/lang/String;
    //   328: aastore
    //   329: invokevirtual 213	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   332: aload 9
    //   334: areturn
    //   335: astore_1
    //   336: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +782 -> 1121
    //   342: ldc 122
    //   344: iconst_2
    //   345: new 124	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 278
    //   355: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_1
    //   359: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   362: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aload 9
    //   373: areturn
    //   374: astore_1
    //   375: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +32 -> 410
    //   381: ldc 122
    //   383: iconst_2
    //   384: new 124	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 278
    //   394: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_1
    //   398: invokevirtual 656	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   401: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: goto -300 -> 110
    //   413: aload 7
    //   415: astore_1
    //   416: new 658	android/os/Bundle
    //   419: dup
    //   420: invokespecial 659	android/os/Bundle:<init>	()V
    //   423: astore 8
    //   425: aload 7
    //   427: astore_1
    //   428: aload 8
    //   430: ldc_w 661
    //   433: iconst_1
    //   434: invokevirtual 665	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   437: aload 7
    //   439: astore_1
    //   440: aload 8
    //   442: ldc_w 667
    //   445: aload 11
    //   447: invokevirtual 670	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload 7
    //   452: astore_1
    //   453: aload 8
    //   455: ldc_w 672
    //   458: aload 11
    //   460: invokevirtual 670	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: aload 7
    //   465: astore_1
    //   466: aload 8
    //   468: ldc_w 674
    //   471: aload 11
    //   473: invokevirtual 670	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: aload 7
    //   478: astore_1
    //   479: aload 8
    //   481: ldc_w 676
    //   484: aload 11
    //   486: invokevirtual 670	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload 7
    //   491: astore_1
    //   492: aload 8
    //   494: ldc_w 678
    //   497: iconst_1
    //   498: invokevirtual 682	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   501: aload 7
    //   503: astore_1
    //   504: new 684	android/content/Intent
    //   507: dup
    //   508: invokespecial 685	android/content/Intent:<init>	()V
    //   511: astore 12
    //   513: aload 7
    //   515: astore_1
    //   516: aload 12
    //   518: aload 8
    //   520: invokevirtual 689	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   523: pop
    //   524: aload 7
    //   526: astore_1
    //   527: aload_0
    //   528: getfield 242	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   531: aload 12
    //   533: bipush 21
    //   535: invokestatic 694	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/app/Activity;Landroid/content/Intent;I)V
    //   538: goto -351 -> 187
    //   541: astore 8
    //   543: aload 7
    //   545: astore_1
    //   546: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq +36 -> 585
    //   552: aload 7
    //   554: astore_1
    //   555: ldc 122
    //   557: iconst_2
    //   558: new 124	java/lang/StringBuilder
    //   561: dup
    //   562: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   565: ldc_w 278
    //   568: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: aload 8
    //   573: invokevirtual 695	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   576: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: iconst_0
    //   586: istore 6
    //   588: iload 6
    //   590: istore 5
    //   592: aload 7
    //   594: ifnull -347 -> 247
    //   597: aload 7
    //   599: invokevirtual 647	java/io/FileOutputStream:close	()V
    //   602: iload 6
    //   604: istore 5
    //   606: goto -359 -> 247
    //   609: astore_1
    //   610: iload 6
    //   612: istore 5
    //   614: goto -367 -> 247
    //   617: aload 7
    //   619: astore_1
    //   620: new 658	android/os/Bundle
    //   623: dup
    //   624: invokespecial 659	android/os/Bundle:<init>	()V
    //   627: astore 8
    //   629: aload 7
    //   631: astore_1
    //   632: new 697	java/util/ArrayList
    //   635: dup
    //   636: invokespecial 698	java/util/ArrayList:<init>	()V
    //   639: astore 12
    //   641: aload 7
    //   643: astore_1
    //   644: aload 12
    //   646: aload 11
    //   648: invokestatic 703	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   651: invokevirtual 706	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   654: pop
    //   655: aload 7
    //   657: astore_1
    //   658: aload 8
    //   660: ldc_w 708
    //   663: aload 12
    //   665: invokevirtual 712	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   668: aload 7
    //   670: astore_1
    //   671: aload 8
    //   673: ldc_w 714
    //   676: ldc_w 716
    //   679: invokevirtual 670	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: aload 7
    //   684: astore_1
    //   685: aload 8
    //   687: ldc_w 718
    //   690: bipush 7
    //   692: invokevirtual 665	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   695: aload 7
    //   697: astore_1
    //   698: aload 8
    //   700: ldc_w 720
    //   703: iconst_0
    //   704: invokevirtual 682	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   707: aload 7
    //   709: astore_1
    //   710: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +33 -> 746
    //   716: aload 7
    //   718: astore_1
    //   719: ldc 122
    //   721: iconst_2
    //   722: new 124	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 722
    //   732: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 8
    //   737: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aload 7
    //   748: astore_1
    //   749: aload_0
    //   750: getfield 109	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   753: invokevirtual 347	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   756: aload_0
    //   757: getfield 109	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   760: invokevirtual 177	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   763: aload 8
    //   765: aload_0
    //   766: invokestatic 727	cooperation/qzone/QZoneShareManager:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnDismissListener;)V
    //   769: goto -582 -> 187
    //   772: astore 8
    //   774: aload_1
    //   775: astore 7
    //   777: aload 8
    //   779: astore_1
    //   780: aload 7
    //   782: ifnull +8 -> 790
    //   785: aload 7
    //   787: invokevirtual 647	java/io/FileOutputStream:close	()V
    //   790: aload_1
    //   791: athrow
    //   792: aload 7
    //   794: astore_1
    //   795: invokestatic 732	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   798: invokevirtual 734	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Z
    //   801: ifeq +20 -> 821
    //   804: aload 7
    //   806: astore_1
    //   807: invokestatic 732	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   810: aload 11
    //   812: aload 8
    //   814: iconst_1
    //   815: invokevirtual 737	com/tencent/mobileqq/wxapi/WXShareHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   818: goto -631 -> 187
    //   821: aload 7
    //   823: astore_1
    //   824: aload_0
    //   825: getfield 109	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   828: invokevirtual 114	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   831: new 739	akjm
    //   834: dup
    //   835: aload_0
    //   836: invokespecial 740	akjm:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;)V
    //   839: invokevirtual 744	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   842: pop
    //   843: goto -656 -> 187
    //   846: aload 7
    //   848: astore_1
    //   849: invokestatic 732	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   852: invokevirtual 734	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Z
    //   855: ifeq +20 -> 875
    //   858: aload 7
    //   860: astore_1
    //   861: invokestatic 732	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   864: aload 11
    //   866: aload 8
    //   868: iconst_0
    //   869: invokevirtual 737	com/tencent/mobileqq/wxapi/WXShareHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   872: goto -685 -> 187
    //   875: aload 7
    //   877: astore_1
    //   878: aload_0
    //   879: getfield 109	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   882: invokevirtual 114	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   885: new 746	akjn
    //   888: dup
    //   889: aload_0
    //   890: invokespecial 747	akjn:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;)V
    //   893: invokevirtual 744	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   896: pop
    //   897: goto -710 -> 187
    //   900: aload 7
    //   902: astore_1
    //   903: new 232	java/io/File
    //   906: dup
    //   907: new 124	java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   914: getstatic 752	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   917: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: getstatic 259	java/io/File:separator	Ljava/lang/String;
    //   923: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   929: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   932: ldc_w 270
    //   935: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   944: astore 12
    //   946: aload 7
    //   948: astore_1
    //   949: aload 8
    //   951: aload 12
    //   953: invokestatic 276	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   956: aload 7
    //   958: astore_1
    //   959: new 684	android/content/Intent
    //   962: dup
    //   963: ldc_w 754
    //   966: invokespecial 755	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   969: astore 8
    //   971: aload 7
    //   973: astore_1
    //   974: aload 8
    //   976: aload 12
    //   978: invokestatic 761	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   981: invokevirtual 765	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   984: pop
    //   985: aload 7
    //   987: astore_1
    //   988: aload_0
    //   989: getfield 109	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   992: invokevirtual 177	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   995: invokevirtual 588	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   998: aload 8
    //   1000: invokevirtual 771	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   1003: aload 7
    //   1005: astore_1
    //   1006: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1009: ifeq -822 -> 187
    //   1012: aload 7
    //   1014: astore_1
    //   1015: ldc 122
    //   1017: iconst_2
    //   1018: new 124	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   1025: ldc_w 773
    //   1028: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: getstatic 752	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   1034: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: goto -856 -> 187
    //   1046: aload_1
    //   1047: ldc_w 649
    //   1050: iconst_m1
    //   1051: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1054: pop
    //   1055: aload_1
    //   1056: ldc_w 332
    //   1059: ldc_w 775
    //   1062: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1065: pop
    //   1066: aload 9
    //   1068: ldc 195
    //   1070: iconst_m1
    //   1071: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1074: pop
    //   1075: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1078: ifeq -764 -> 314
    //   1081: ldc 122
    //   1083: iconst_2
    //   1084: ldc_w 777
    //   1087: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: goto -776 -> 314
    //   1093: astore_1
    //   1094: iload 6
    //   1096: istore 5
    //   1098: goto -851 -> 247
    //   1101: astore 7
    //   1103: goto -313 -> 790
    //   1106: astore_1
    //   1107: aconst_null
    //   1108: astore 7
    //   1110: goto -330 -> 780
    //   1113: astore 8
    //   1115: aconst_null
    //   1116: astore 7
    //   1118: goto -575 -> 543
    //   1121: aload 9
    //   1123: areturn
    //   1124: iload_2
    //   1125: tableswitch	default:+35 -> 1160, 1:+-712->413, 2:+-508->617, 3:+-279->846, 4:+-333->792, 5:+-225->900
    //   1161: <illegal opcode>
    //   1162: baload
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1163	0	this	HealthStepCounterPlugin
    //   0	1163	1	paramString	String
    //   65	1060	2	i	int
    //   12	207	3	l	long
    //   28	1069	5	j	int
    //   149	946	6	bool	boolean
    //   132	881	7	localObject1	Object
    //   1101	1	7	localIOException	java.io.IOException
    //   1108	9	7	localObject2	Object
    //   93	426	8	localObject3	Object
    //   541	31	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   627	137	8	localBundle	android.os.Bundle
    //   772	178	8	localBitmap	Bitmap
    //   969	30	8	localIntent	Intent
    //   1113	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   7	1115	9	localJSONObject	JSONObject
    //   45	271	10	str1	String
    //   72	793	11	str2	String
    //   511	466	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   30	55	335	java/lang/Exception
    //   58	100	335	java/lang/Exception
    //   100	107	335	java/lang/Exception
    //   110	120	335	java/lang/Exception
    //   238	243	335	java/lang/Exception
    //   247	255	335	java/lang/Exception
    //   260	314	335	java/lang/Exception
    //   314	332	335	java/lang/Exception
    //   375	410	335	java/lang/Exception
    //   597	602	335	java/lang/Exception
    //   785	790	335	java/lang/Exception
    //   790	792	335	java/lang/Exception
    //   1046	1090	335	java/lang/Exception
    //   100	107	374	java/lang/OutOfMemoryError
    //   137	151	541	java/io/FileNotFoundException
    //   154	161	541	java/io/FileNotFoundException
    //   164	174	541	java/io/FileNotFoundException
    //   177	184	541	java/io/FileNotFoundException
    //   190	196	541	java/io/FileNotFoundException
    //   199	229	541	java/io/FileNotFoundException
    //   416	425	541	java/io/FileNotFoundException
    //   428	437	541	java/io/FileNotFoundException
    //   440	450	541	java/io/FileNotFoundException
    //   453	463	541	java/io/FileNotFoundException
    //   466	476	541	java/io/FileNotFoundException
    //   479	489	541	java/io/FileNotFoundException
    //   492	501	541	java/io/FileNotFoundException
    //   504	513	541	java/io/FileNotFoundException
    //   516	524	541	java/io/FileNotFoundException
    //   527	538	541	java/io/FileNotFoundException
    //   620	629	541	java/io/FileNotFoundException
    //   632	641	541	java/io/FileNotFoundException
    //   644	655	541	java/io/FileNotFoundException
    //   658	668	541	java/io/FileNotFoundException
    //   671	682	541	java/io/FileNotFoundException
    //   685	695	541	java/io/FileNotFoundException
    //   698	707	541	java/io/FileNotFoundException
    //   710	716	541	java/io/FileNotFoundException
    //   719	746	541	java/io/FileNotFoundException
    //   749	769	541	java/io/FileNotFoundException
    //   795	804	541	java/io/FileNotFoundException
    //   807	818	541	java/io/FileNotFoundException
    //   824	843	541	java/io/FileNotFoundException
    //   849	858	541	java/io/FileNotFoundException
    //   861	872	541	java/io/FileNotFoundException
    //   878	897	541	java/io/FileNotFoundException
    //   903	946	541	java/io/FileNotFoundException
    //   949	956	541	java/io/FileNotFoundException
    //   959	971	541	java/io/FileNotFoundException
    //   974	985	541	java/io/FileNotFoundException
    //   988	1003	541	java/io/FileNotFoundException
    //   1006	1012	541	java/io/FileNotFoundException
    //   1015	1043	541	java/io/FileNotFoundException
    //   597	602	609	java/io/IOException
    //   137	151	772	finally
    //   154	161	772	finally
    //   164	174	772	finally
    //   177	184	772	finally
    //   190	196	772	finally
    //   199	229	772	finally
    //   416	425	772	finally
    //   428	437	772	finally
    //   440	450	772	finally
    //   453	463	772	finally
    //   466	476	772	finally
    //   479	489	772	finally
    //   492	501	772	finally
    //   504	513	772	finally
    //   516	524	772	finally
    //   527	538	772	finally
    //   546	552	772	finally
    //   555	585	772	finally
    //   620	629	772	finally
    //   632	641	772	finally
    //   644	655	772	finally
    //   658	668	772	finally
    //   671	682	772	finally
    //   685	695	772	finally
    //   698	707	772	finally
    //   710	716	772	finally
    //   719	746	772	finally
    //   749	769	772	finally
    //   795	804	772	finally
    //   807	818	772	finally
    //   824	843	772	finally
    //   849	858	772	finally
    //   861	872	772	finally
    //   878	897	772	finally
    //   903	946	772	finally
    //   949	956	772	finally
    //   959	971	772	finally
    //   974	985	772	finally
    //   988	1003	772	finally
    //   1006	1012	772	finally
    //   1015	1043	772	finally
    //   238	243	1093	java/io/IOException
    //   785	790	1101	java/io/IOException
    //   124	134	1106	finally
    //   124	134	1113	java/io/FileNotFoundException
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("HealthStepCounterPlugin", 2, "handleJsRequest!!");
    }
    if ((paramString1 == null) || (!"healthkit".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    try
    {
      if (!paramString3.equals("readHKData")) {
        break label275;
      }
      if (paramVarArgs.length <= 0) {
        break label273;
      }
      paramJsBridgeListener = (SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor");
      if ((Build.VERSION.SDK_INT < 19) || (paramJsBridgeListener.getDefaultSensor(19) == null))
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
        if (TextUtils.isEmpty(paramJsBridgeListener)) {
          return false;
        }
        paramString1 = new JSONObject();
        paramString1.put("ssoRet", 255);
        paramString1.put("businessRet", 0);
        paramString1.put("msg", "设备不支持");
        super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      }
      else
      {
        paramJsBridgeListener = new NewIntent(this.mRuntime.a().getApplication(), StepCounterServlert.class);
        paramJsBridgeListener.putExtra("msf_cmd_type", "cmd_refresh_steps");
        paramJsBridgeListener.putExtra("json_string", paramVarArgs[0]);
        paramJsBridgeListener.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.mRuntime.a().startServlet(paramJsBridgeListener);
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      QLog.d("HealthStepCounterPlugin", 2, "Err:" + paramJsBridgeListener.toString());
    }
    return false;
    label273:
    return true;
    label275:
    int i;
    if (paramString3.equals("healthSwitch"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("HealthStepCounterPlugin", 2, "healthSwitch:" + paramVarArgs[0]);
      }
      paramJsBridgeListener = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.health_ban.name(), "");
      if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (Integer.parseInt(paramJsBridgeListener) == 0))
      {
        paramJsBridgeListener = new JSONObject();
        paramString1 = new JSONObject(paramVarArgs[0]).getString("callback");
        paramJsBridgeListener.put("businessRet", 202);
        paramJsBridgeListener.put("msg", "该机型黑名单");
        super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
        return true;
      }
      paramJsBridgeListener = new JSONObject();
      paramString2 = new JSONObject(paramVarArgs[0]);
      paramString1 = paramString2.getString("callback");
      boolean bool = paramString2.getBoolean("isOpen");
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break label1083;
      }
      paramString2 = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, StepCounterServlert.class);
      paramString2.putExtra("msf_cmd_type", "cmd_health_switch");
      paramString2.putExtra("isOpen", bool);
      this.mRuntime.a().startServlet(paramString2);
      paramJsBridgeListener.put("businessRet", 0);
      paramJsBridgeListener.put("msg", "操作成功");
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramJsBridgeListener.put("businessRet", 201);
        paramJsBridgeListener.put("msg", "操作异常");
        super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
        break label1091;
        if (paramString3.equals("shareSnapshot"))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
          {
            paramJsBridgeListener = localObject2;
            if (this.mRuntime.a() != null) {
              paramJsBridgeListener = this.mRuntime.a().a().a();
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = paramJsBridgeListener;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435483);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          }
          ThreadManager.post(new akjj(this, paramVarArgs[0]), 5, null, true);
          return true;
        }
        if (paramString3.equals("snapshot"))
        {
          paramString1 = paramVarArgs[0];
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
          {
            if (this.mRuntime.a() != null) {
              paramJsBridgeListener = this.mRuntime.a().a().a();
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = paramJsBridgeListener;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435483);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          }
          ThreadManager.post(new akjk(this, paramString1), 5, null, true);
          return true;
        }
        if (paramString3.equals("TestReport"))
        {
          a(paramVarArgs[0]);
          break;
        }
        if (paramString3.equals("getCurrentStep"))
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
          paramString1 = new NewIntent(this.mRuntime.a().getApplication(), StepCounterServlert.class);
          paramString1.putExtra("msf_cmd_type", "cmd_refresh_steps");
          paramString1.putExtra("json_string", paramVarArgs[0]);
          paramString1.putExtra("json_getstepcallback", paramJsBridgeListener);
          paramString1.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
          this.mRuntime.a().startServlet(paramString1);
          break;
        }
        if (!"jumpToSetting".equals(paramString3)) {
          break;
        }
        paramString2 = new JSONObject();
        paramJsBridgeListener = localObject1;
        try
        {
          paramString3 = this.mRuntime.a();
          paramJsBridgeListener = localObject1;
          paramString1 = new JSONObject(paramVarArgs[0]).getString("callback");
          paramJsBridgeListener = paramString1;
          paramVarArgs = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
          paramJsBridgeListener = paramString1;
          paramVarArgs.setData(Uri.parse("package:" + paramString3.getPackageName()));
          paramJsBridgeListener = paramString1;
          paramString3.startActivity(paramVarArgs);
          paramJsBridgeListener = paramString1;
          paramString2.put("ret", 0);
          paramJsBridgeListener = paramString1;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            try
            {
              paramString2.put("ret", -1);
            }
            catch (JSONException paramString1) {}
          }
        }
        if (TextUtils.isEmpty(paramJsBridgeListener)) {
          break;
        }
        callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
        break;
        label1083:
        i = 0;
        continue;
        return true;
      }
    }
    label1091:
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (jdField_a_of_type_Akjq != null)
    {
      ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor")).unregisterListener(jdField_a_of_type_Akjq);
      jdField_a_of_type_Akjq = null;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin
 * JD-Core Version:    0.7.0.1
 */