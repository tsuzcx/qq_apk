package com.tencent.open.export.js;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.JavaScriptInterface;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipDownloadInterface
  extends BaseInterface
  implements JavaScriptInterface, IJsCallBack
{
  protected final Activity a;
  protected Handler a;
  protected UpdateManager.OnCheckUpdateListener a;
  protected final WebView a;
  protected final String a;
  protected String b = "";
  
  public VipDownloadInterface(Activity paramActivity, WebView paramWebView)
  {
    this.jdField_a_of_type_JavaLangString = VipDownloadInterface.class.getSimpleName();
    LogUtility.c(this.jdField_a_of_type_JavaLangString, "init in");
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof PublicFragmentActivityForTool)) {
      paramActivity = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      DownloadManager.a().a(paramActivity);
      DownloadManager.a();
      LogUtility.c(this.jdField_a_of_type_JavaLangString, "init out");
      return;
      paramActivity = localObject;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
        paramActivity = (AppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      }
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VipDownloadInterface.3(this, paramString));
  }
  
  public boolean cancelDownload(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return false;
    }
    DownloadApi.a(paramString1, paramString2, true);
    return true;
  }
  
  public void cancelNotification(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    DownloadManager.a().a(paramString);
  }
  
  public void checkUpdate(String paramString)
  {
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    LogUtility.c(this.jdField_a_of_type_JavaLangString, "enter checkUpdate json=" + paramString1);
    if (!hasRight()) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString1);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = ((JSONObject)localObject).optString("guid");
      }
      paramString2 = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("packageNames");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString2.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener == null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener = new VipDownloadInterface.JsCheckUpdateCallback(this, paramString1);
        UpdateManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener);
      }
      UpdateManager.a().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c(this.jdField_a_of_type_JavaLangString, "httpRequest JSONException", paramString1);
    }
  }
  
  public void destroy()
  {
    LogUtility.c(this.jdField_a_of_type_JavaLangString, "destroy");
    JsCallbackManager.a().b(this);
    if (UpdateManager.a()) {
      UpdateManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener);
    }
  }
  
  /* Error */
  public void doDownloadAction(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 28	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: new 126	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   14: ldc 217
    //   16: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 219	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 111	com/tencent/open/export/js/VipDownloadInterface:hasRight	()Z
    //   33: ifne +4 -> 37
    //   36: return
    //   37: new 221	android/os/Bundle
    //   40: dup
    //   41: invokespecial 222	android/os/Bundle:<init>	()V
    //   44: astore 6
    //   46: new 138	org/json/JSONObject
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 140	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: astore 7
    //   56: aload 7
    //   58: ldc 224
    //   60: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   63: istore_2
    //   64: aload 7
    //   66: getstatic 233	com/tencent/open/downloadnew/DownloadConstants:C	Ljava/lang/String;
    //   69: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 4
    //   74: aload 4
    //   76: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +870 -> 949
    //   82: aload 4
    //   84: ldc 235
    //   86: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne +860 -> 949
    //   92: aload_0
    //   93: getfield 28	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   96: new 126	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   103: ldc 242
    //   105: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 4
    //   110: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 219	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: iload_2
    //   120: ifne +225 -> 345
    //   123: aload 6
    //   125: getstatic 243	com/tencent/open/downloadnew/DownloadConstants:b	Ljava/lang/String;
    //   128: aload 7
    //   130: ldc 245
    //   132: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 6
    //   140: getstatic 251	com/tencent/open/downloadnew/DownloadConstants:j	Ljava/lang/String;
    //   143: aload 7
    //   145: ldc 253
    //   147: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 6
    //   155: getstatic 256	com/tencent/open/downloadnew/DownloadConstants:f	Ljava/lang/String;
    //   158: aload 7
    //   160: ldc_w 258
    //   163: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 6
    //   171: getstatic 261	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   174: aload 7
    //   176: ldc_w 263
    //   179: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   182: invokevirtual 267	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   185: aload 6
    //   187: getstatic 270	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   190: aload 7
    //   192: ldc_w 272
    //   195: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 6
    //   203: getstatic 275	com/tencent/open/downloadnew/DownloadConstants:l	Ljava/lang/String;
    //   206: aload 7
    //   208: ldc_w 277
    //   211: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload 6
    //   219: getstatic 233	com/tencent/open/downloadnew/DownloadConstants:C	Ljava/lang/String;
    //   222: aload 4
    //   224: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload 7
    //   229: ldc_w 279
    //   232: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   235: astore 4
    //   237: aload 4
    //   239: astore_1
    //   240: aload 4
    //   242: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifeq +11 -> 256
    //   248: aload_0
    //   249: getfield 44	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   252: invokestatic 285	com/tencent/open/appcommon/js/DownloadInterface:getSourceInfoFromActivity	(Landroid/app/Activity;)Ljava/lang/String;
    //   255: astore_1
    //   256: aload_1
    //   257: astore 4
    //   259: ldc_w 287
    //   262: aload_1
    //   263: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifne +8 -> 274
    //   269: ldc_w 289
    //   272: astore 4
    //   274: aload_0
    //   275: getfield 28	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   278: new 126	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 291
    //   288: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 7
    //   293: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   296: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 219	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_0
    //   306: getfield 44	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   309: aload 6
    //   311: aload 4
    //   313: aconst_null
    //   314: iconst_0
    //   315: invokestatic 295	com/tencent/open/downloadnew/DownloadApi:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;Lcom/tencent/apkupdate/logic/data/ApkUpdateDetail;I)V
    //   318: return
    //   319: astore_1
    //   320: aload_0
    //   321: getfield 28	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   324: ldc_w 297
    //   327: aload_1
    //   328: invokestatic 196	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   331: return
    //   332: astore_1
    //   333: aload_0
    //   334: getfield 28	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   337: ldc_w 299
    //   340: aload_1
    //   341: invokestatic 196	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   344: return
    //   345: new 138	org/json/JSONObject
    //   348: dup
    //   349: aload_1
    //   350: invokespecial 140	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   353: astore 7
    //   355: aload 6
    //   357: getstatic 243	com/tencent/open/downloadnew/DownloadConstants:b	Ljava/lang/String;
    //   360: aload 7
    //   362: ldc 245
    //   364: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   367: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload 6
    //   372: getstatic 251	com/tencent/open/downloadnew/DownloadConstants:j	Ljava/lang/String;
    //   375: aload 7
    //   377: ldc 253
    //   379: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   382: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload 6
    //   387: getstatic 256	com/tencent/open/downloadnew/DownloadConstants:f	Ljava/lang/String;
    //   390: aload 7
    //   392: ldc_w 258
    //   395: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   398: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload 6
    //   403: getstatic 261	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   406: aload 7
    //   408: ldc_w 263
    //   411: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   414: invokevirtual 267	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   417: aload 6
    //   419: getstatic 270	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   422: aload 7
    //   424: ldc_w 272
    //   427: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   430: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: aload 6
    //   435: getstatic 275	com/tencent/open/downloadnew/DownloadConstants:l	Ljava/lang/String;
    //   438: aload 7
    //   440: ldc_w 277
    //   443: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   446: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   449: aload 6
    //   451: getstatic 302	com/tencent/open/downloadnew/DownloadConstants:r	Ljava/lang/String;
    //   454: aload 7
    //   456: ldc_w 304
    //   459: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   462: invokestatic 308	com/tencent/open/appcommon/js/DownloadInterface:changeIntToBoolean	(I)Z
    //   465: invokevirtual 312	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   468: aload 6
    //   470: getstatic 315	com/tencent/open/downloadnew/DownloadConstants:p	Ljava/lang/String;
    //   473: aload 7
    //   475: ldc_w 317
    //   478: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   481: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload 6
    //   486: getstatic 233	com/tencent/open/downloadnew/DownloadConstants:C	Ljava/lang/String;
    //   489: aload 4
    //   491: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload 7
    //   496: ldc_w 272
    //   499: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   502: pop
    //   503: aload 7
    //   505: ldc 245
    //   507: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   510: pop
    //   511: aload 7
    //   513: ldc_w 263
    //   516: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   519: pop
    //   520: aload 5
    //   522: astore_1
    //   523: aload 7
    //   525: ldc_w 263
    //   528: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   531: bipush 12
    //   533: if_icmpne +184 -> 717
    //   536: aload 7
    //   538: ldc_w 319
    //   541: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   544: invokestatic 308	com/tencent/open/appcommon/js/DownloadInterface:changeIntToBoolean	(I)Z
    //   547: istore_3
    //   548: aload 6
    //   550: getstatic 322	com/tencent/open/downloadnew/DownloadConstants:o	Ljava/lang/String;
    //   553: iload_3
    //   554: invokevirtual 312	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   557: aload 7
    //   559: ldc_w 324
    //   562: invokevirtual 328	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   565: istore_3
    //   566: aload 5
    //   568: astore_1
    //   569: iload_3
    //   570: ifeq +147 -> 717
    //   573: aload 7
    //   575: ldc_w 324
    //   578: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   581: astore 4
    //   583: aload 4
    //   585: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   588: ifne +356 -> 944
    //   591: new 330	com/tencent/apkupdate/logic/data/ApkUpdateDetail
    //   594: dup
    //   595: invokespecial 331	com/tencent/apkupdate/logic/data/ApkUpdateDetail:<init>	()V
    //   598: astore_1
    //   599: new 138	org/json/JSONObject
    //   602: dup
    //   603: aload 4
    //   605: invokespecial 140	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   608: astore 4
    //   610: aload_1
    //   611: aload 4
    //   613: ldc_w 258
    //   616: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   619: putfield 333	com/tencent/apkupdate/logic/data/ApkUpdateDetail:packageName	Ljava/lang/String;
    //   622: aload_1
    //   623: aload 4
    //   625: ldc_w 335
    //   628: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   631: putfield 338	com/tencent/apkupdate/logic/data/ApkUpdateDetail:newapksize	I
    //   634: aload_1
    //   635: aload 4
    //   637: ldc_w 340
    //   640: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   643: putfield 342	com/tencent/apkupdate/logic/data/ApkUpdateDetail:patchsize	I
    //   646: aload_1
    //   647: aload 4
    //   649: ldc_w 344
    //   652: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   655: putfield 346	com/tencent/apkupdate/logic/data/ApkUpdateDetail:updatemethod	I
    //   658: aload_1
    //   659: aload 4
    //   661: ldc_w 348
    //   664: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   667: putfield 350	com/tencent/apkupdate/logic/data/ApkUpdateDetail:versioncode	I
    //   670: aload_1
    //   671: aload 4
    //   673: ldc_w 352
    //   676: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   679: putfield 354	com/tencent/apkupdate/logic/data/ApkUpdateDetail:versionname	Ljava/lang/String;
    //   682: aload_1
    //   683: aload 4
    //   685: ldc_w 356
    //   688: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   691: putfield 358	com/tencent/apkupdate/logic/data/ApkUpdateDetail:fileMd5	Ljava/lang/String;
    //   694: aload_1
    //   695: aload 4
    //   697: ldc_w 360
    //   700: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   703: putfield 362	com/tencent/apkupdate/logic/data/ApkUpdateDetail:sigMd5	Ljava/lang/String;
    //   706: aload_1
    //   707: aload 4
    //   709: ldc 253
    //   711: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   714: putfield 364	com/tencent/apkupdate/logic/data/ApkUpdateDetail:url	Ljava/lang/String;
    //   717: aload 6
    //   719: getstatic 366	com/tencent/open/downloadnew/DownloadConstants:c	Ljava/lang/String;
    //   722: aload 7
    //   724: ldc_w 368
    //   727: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   730: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload 6
    //   735: getstatic 371	com/tencent/open/downloadnew/DownloadConstants:d	Ljava/lang/String;
    //   738: aload 7
    //   740: ldc_w 373
    //   743: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   746: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   749: aload 6
    //   751: getstatic 376	com/tencent/open/downloadnew/DownloadConstants:e	Ljava/lang/String;
    //   754: aload 7
    //   756: ldc_w 378
    //   759: bipush 246
    //   761: invokevirtual 381	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   764: invokevirtual 267	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   767: aload 6
    //   769: getstatic 384	com/tencent/open/downloadnew/DownloadConstants:n	Ljava/lang/String;
    //   772: aload 7
    //   774: ldc_w 386
    //   777: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   780: invokevirtual 267	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   783: aload 6
    //   785: getstatic 389	com/tencent/open/downloadnew/DownloadConstants:g	Ljava/lang/String;
    //   788: aload 7
    //   790: ldc_w 391
    //   793: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   796: invokestatic 308	com/tencent/open/appcommon/js/DownloadInterface:changeIntToBoolean	(I)Z
    //   799: invokevirtual 312	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   802: aload 6
    //   804: getstatic 394	com/tencent/open/downloadnew/DownloadConstants:h	Ljava/lang/String;
    //   807: aload 7
    //   809: ldc_w 396
    //   812: invokevirtual 228	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   815: invokestatic 308	com/tencent/open/appcommon/js/DownloadInterface:changeIntToBoolean	(I)Z
    //   818: invokevirtual 312	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   821: aload 7
    //   823: ldc_w 279
    //   826: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   829: astore 5
    //   831: aload 5
    //   833: astore 4
    //   835: aload 5
    //   837: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   840: ifeq +12 -> 852
    //   843: aload_0
    //   844: getfield 44	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   847: invokestatic 285	com/tencent/open/appcommon/js/DownloadInterface:getSourceInfoFromActivity	(Landroid/app/Activity;)Ljava/lang/String;
    //   850: astore 4
    //   852: aload_0
    //   853: getfield 28	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   856: new 126	java/lang/StringBuilder
    //   859: dup
    //   860: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   863: ldc_w 291
    //   866: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: aload 7
    //   871: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   874: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 40	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   883: aload_0
    //   884: getfield 44	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   887: aload 6
    //   889: aload 4
    //   891: aload_1
    //   892: iload_2
    //   893: invokestatic 295	com/tencent/open/downloadnew/DownloadApi:a	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;Lcom/tencent/apkupdate/logic/data/ApkUpdateDetail;I)V
    //   896: return
    //   897: astore_1
    //   898: aload_0
    //   899: getfield 28	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   902: ldc_w 299
    //   905: aload_1
    //   906: invokestatic 196	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   909: return
    //   910: astore_1
    //   911: aconst_null
    //   912: astore_1
    //   913: aload_0
    //   914: getfield 28	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   917: ldc_w 398
    //   920: invokestatic 40	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   923: goto -206 -> 717
    //   926: astore_1
    //   927: aload_0
    //   928: getfield 28	com/tencent/open/export/js/VipDownloadInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   931: ldc_w 297
    //   934: aload_1
    //   935: invokestatic 196	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   938: return
    //   939: astore 4
    //   941: goto -28 -> 913
    //   944: aconst_null
    //   945: astore_1
    //   946: goto -229 -> 717
    //   949: ldc 30
    //   951: astore 4
    //   953: goto -861 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	956	0	this	VipDownloadInterface
    //   0	956	1	paramString	String
    //   63	830	2	i	int
    //   547	23	3	bool	boolean
    //   72	818	4	localObject	Object
    //   939	1	4	localException	java.lang.Exception
    //   951	1	4	str1	String
    //   1	835	5	str2	String
    //   44	844	6	localBundle	android.os.Bundle
    //   54	816	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   123	237	319	java/lang/NumberFormatException
    //   240	256	319	java/lang/NumberFormatException
    //   259	269	319	java/lang/NumberFormatException
    //   274	318	319	java/lang/NumberFormatException
    //   46	56	332	org/json/JSONException
    //   345	520	897	org/json/JSONException
    //   523	566	897	org/json/JSONException
    //   573	599	897	org/json/JSONException
    //   599	717	897	org/json/JSONException
    //   717	831	897	org/json/JSONException
    //   835	852	897	org/json/JSONException
    //   852	896	897	org/json/JSONException
    //   913	923	897	org/json/JSONException
    //   573	599	910	java/lang/Exception
    //   345	520	926	java/lang/NumberFormatException
    //   523	566	926	java/lang/NumberFormatException
    //   573	599	926	java/lang/NumberFormatException
    //   599	717	926	java/lang/NumberFormatException
    //   717	831	926	java/lang/NumberFormatException
    //   835	852	926	java/lang/NumberFormatException
    //   852	896	926	java/lang/NumberFormatException
    //   913	923	926	java/lang/NumberFormatException
    //   599	717	939	java/lang/Exception
  }
  
  public String getDownloadVersion()
  {
    return DownloadApi.a() + "";
  }
  
  public String getInterfaceName()
  {
    return "q_download_vip";
  }
  
  public String getJsCallbackMethod()
  {
    return this.b;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    LogUtility.b(this.jdField_a_of_type_JavaLangString, "enter getQueryDownloadAction = " + paramString);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("infolist");
      localObject = ((JSONObject)localObject).getString("guid");
      int j = paramString.length();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.c = localJSONObject.optString("appid");
        localDownloadInfo.j = localJSONObject.optString("myAppId");
        localDownloadInfo.k = localJSONObject.optString("apkId");
        localDownloadInfo.e = localJSONObject.optString("packageName");
        localDownloadInfo.b = localJSONObject.optInt("versionCode");
        localArrayList.add(localDownloadInfo);
        i += 1;
      }
      DownloadApi.a(localArrayList, new VipDownloadInterface.1(this, (String)localObject));
      return;
    }
    catch (JSONException paramString)
    {
      LogUtility.c(this.jdField_a_of_type_JavaLangString, "getQueryDownloadAction>>>", paramString);
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    LogUtility.a(this.jdField_a_of_type_JavaLangString, "enter getQueryDownloadAction = " + paramString1);
    if (!hasRight()) {
      return;
    }
    try
    {
      paramString1 = new JSONArray(paramString1);
      int j = paramString1.length();
      paramString2 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.c = paramString1.getString(i);
        paramString2.add(localDownloadInfo);
        i += 1;
      }
      DownloadApi.a(paramString2, new VipDownloadInterface.2(this));
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c(this.jdField_a_of_type_JavaLangString, "getQueryDownloadAction>>>", paramString1);
    }
  }
  
  public WebView getWebview()
  {
    return this.jdField_a_of_type_ComTencentSmttSdkWebView;
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    JsCallbackManager.a().a(this);
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface
 * JD-Core Version:    0.7.0.1
 */