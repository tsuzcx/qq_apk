package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import behj;
import behq;
import bekr;
import bekz;
import bema;
import betc;
import com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.ui.MiniTranslucentFragmentActivity;
import org.json.JSONObject;

public class NavigationJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NavigationJsPlugin";
  private static final int navigateBackByAPPInfo = bema.a("MiniApp", "mini_app_navigate_back_by_appinfo", 1);
  
  private static void navigateBackMiniApp(Activity paramActivity, String paramString, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("mini_appid", paramString);
    if (paramLaunchParam != null)
    {
      paramLaunchParam.b = 1;
      localIntent.putExtra("mini_launch_param", paramLaunchParam);
    }
    localIntent.putExtra("mini_receiver", paramResultReceiver);
    localIntent.putExtra("public_fragment_window_feature", 1);
    MiniTranslucentFragmentActivity.a(paramActivity, localIntent, MiniAppInfoLoadingFragment.class);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void navigateBackMiniApp(MiniAppInfo paramMiniAppInfo, String paramString, ResultReceiver paramResultReceiver)
  {
    MiniAppInfo localMiniAppInfo = MiniAppInfo.copy(paramMiniAppInfo);
    localMiniAppInfo.launchParam.jdField_a_of_type_JavaLangString = paramMiniAppInfo.appId;
    localMiniAppInfo.launchParam.jdField_a_of_type_Int = 1038;
    localMiniAppInfo.launchParam.e = paramString;
    localMiniAppInfo.launchParam.b = 1;
    localMiniAppInfo.launchParam.f = this.mMiniAppInfo.launchParam.jdField_a_of_type_JavaLangString;
    behj.a(this.mMiniAppContext.a(), localMiniAppInfo, new Bundle(), paramResultReceiver);
  }
  
  private boolean navigateBackMiniApp(String paramString1, String paramString2)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.jdField_a_of_type_JavaLangString = paramString1;
    localLaunchParam.jdField_a_of_type_Int = 1038;
    localLaunchParam.e = paramString2;
    localLaunchParam.f = this.mMiniAppInfo.launchParam.jdField_a_of_type_JavaLangString;
    navigateBackMiniApp(this.mMiniAppContext.a(), paramString1, localLaunchParam, new NavigationJsPlugin.3(this, new Handler(Looper.getMainLooper())));
    return true;
  }
  
  public void exitMiniProgram(bekr parambekr)
  {
    bekz.a(new NavigationJsPlugin.4(this, this.mMiniAppContext.a()));
    parambekr.a();
  }
  
  public void navigateBackMiniProgram(bekr parambekr)
  {
    new JSONObject();
    Object localObject2;
    String str;
    do
    {
      do
      {
        try
        {
          Object localObject1 = new JSONObject(parambekr.b);
          if (navigateBackByAPPInfo == 0) {
            if (localObject1 != null)
            {
              localObject1 = ((JSONObject)localObject1).optString("extraData");
              localObject2 = this.mMiniAppInfo.launchParam.f;
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (navigateBackMiniApp((String)localObject2, (String)localObject1))) {
                parambekr.a();
              }
            }
            else
            {
              return;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            betc.d("NavigationJsPlugin", localThrowable.getMessage(), localThrowable);
            str = null;
          }
          parambekr.b();
          return;
        }
      } while ((navigateBackByAPPInfo != 1) || (str == null));
      str = str.optString("extraData");
      localObject2 = this.mMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    } while (localObject2 == null);
    navigateBackMiniApp((MiniAppInfo)localObject2, str, new NavigationJsPlugin.2(this, new Handler(Looper.getMainLooper()), parambekr));
  }
  
  /* Error */
  public void navigateToMiniProgram(bekr parambekr)
  {
    // Byte code:
    //   0: sipush 2001
    //   3: istore_3
    //   4: new 156	org/json/JSONObject
    //   7: dup
    //   8: aload_1
    //   9: getfield 159	bekr:b	Ljava/lang/String;
    //   12: invokespecial 162	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: ifnull +190 -> 209
    //   22: aload 5
    //   24: ldc 201
    //   26: invokevirtual 168	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 7
    //   31: aload 5
    //   33: invokestatic 205	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:createMiniAppInfo	(Lorg/json/JSONObject;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   36: astore 8
    //   38: aload_0
    //   39: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   42: getfield 80	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   45: getfield 208	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   48: astore 9
    //   50: aload 8
    //   52: ifnull +232 -> 284
    //   55: ldc 210
    //   57: ldc 212
    //   59: ldc 214
    //   61: invokestatic 217	bema:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: aload_0
    //   65: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   68: getfield 83	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   71: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifeq +153 -> 227
    //   77: sipush 2077
    //   80: istore_2
    //   81: aload 5
    //   83: ldc 164
    //   85: invokevirtual 227	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   88: astore 6
    //   90: aload 6
    //   92: ifnull +152 -> 244
    //   95: aload 6
    //   97: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
    //   100: astore 6
    //   102: new 41	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   105: dup
    //   106: invokespecial 116	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   109: astore 10
    //   111: aload 10
    //   113: iload_2
    //   114: putfield 87	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_Int	I
    //   117: aload 10
    //   119: aload_0
    //   120: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   123: getfield 80	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   126: getfield 85	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   129: putfield 97	com/tencent/qqmini/sdk/launcher/model/LaunchParam:f	Ljava/lang/String;
    //   132: aload 10
    //   134: aload 6
    //   136: putfield 90	com/tencent/qqmini/sdk/launcher/model/LaunchParam:e	Ljava/lang/String;
    //   139: aload 9
    //   141: ifnull +10 -> 151
    //   144: aload 10
    //   146: aload 9
    //   148: putfield 208	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   151: aload_0
    //   152: getfield 101	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppContext	Lbehq;
    //   155: invokeinterface 106 1 0
    //   160: aload 8
    //   162: invokestatic 233	behj:a	(Landroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)V
    //   165: aload_1
    //   166: invokevirtual 151	bekr:a	()Ljava/lang/String;
    //   169: pop
    //   170: ldc 8
    //   172: new 235	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   179: ldc 238
    //   181: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 8
    //   186: invokevirtual 243	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:toString	()Ljava/lang/String;
    //   189: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 247	betc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload 8
    //   200: getfield 250	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:verType	I
    //   203: istore_2
    //   204: iload_2
    //   205: iconst_3
    //   206: if_icmpne +3 -> 209
    //   209: return
    //   210: astore 5
    //   212: ldc 8
    //   214: ldc 252
    //   216: aload 5
    //   218: invokestatic 185	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   221: aconst_null
    //   222: astore 5
    //   224: goto -207 -> 17
    //   227: aload_0
    //   228: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   231: invokevirtual 256	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   234: ifeq +447 -> 681
    //   237: sipush 2001
    //   240: istore_2
    //   241: goto +437 -> 678
    //   244: ldc 252
    //   246: astore 6
    //   248: goto -146 -> 102
    //   251: astore 6
    //   253: ldc 8
    //   255: new 235	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 258
    //   265: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 6
    //   270: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   273: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: aload 6
    //   281: invokestatic 185	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   284: aload 5
    //   286: ldc_w 261
    //   289: invokevirtual 265	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   292: istore_2
    //   293: aload 5
    //   295: ldc_w 266
    //   298: invokevirtual 168	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   301: astore 6
    //   303: iload_2
    //   304: ifne +368 -> 672
    //   307: aload 5
    //   309: ldc_w 268
    //   312: invokevirtual 168	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   315: astore 8
    //   317: aload 5
    //   319: ldc_w 270
    //   322: invokevirtual 168	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   325: astore 9
    //   327: aload 5
    //   329: ldc 164
    //   331: invokevirtual 227	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   334: astore 5
    //   336: aload 5
    //   338: ifnull +258 -> 596
    //   341: aload 5
    //   343: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
    //   346: astore 5
    //   348: new 41	com/tencent/qqmini/sdk/launcher/model/LaunchParam
    //   351: dup
    //   352: invokespecial 116	com/tencent/qqmini/sdk/launcher/model/LaunchParam:<init>	()V
    //   355: astore 10
    //   357: aload_0
    //   358: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   361: invokevirtual 256	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isAppStoreMiniApp	()Z
    //   364: ifeq +239 -> 603
    //   367: iload_3
    //   368: istore_2
    //   369: aload 10
    //   371: iload_2
    //   372: putfield 87	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_Int	I
    //   375: aload 10
    //   377: aload 8
    //   379: putfield 273	com/tencent/qqmini/sdk/launcher/model/LaunchParam:c	Ljava/lang/String;
    //   382: aload 10
    //   384: aload 5
    //   386: putfield 90	com/tencent/qqmini/sdk/launcher/model/LaunchParam:e	Ljava/lang/String;
    //   389: aload 10
    //   391: aload_0
    //   392: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   395: getfield 80	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   398: getfield 85	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   401: putfield 97	com/tencent/qqmini/sdk/launcher/model/LaunchParam:f	Ljava/lang/String;
    //   404: aload 10
    //   406: aload_0
    //   407: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   410: getfield 80	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   413: getfield 208	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   416: putfield 208	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel	Lcom/tencent/qqmini/sdk/launcher/model/EntryModel;
    //   419: aload 10
    //   421: aload 9
    //   423: putfield 276	com/tencent/qqmini/sdk/launcher/model/LaunchParam:i	Ljava/lang/String;
    //   426: aload_0
    //   427: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   430: invokevirtual 279	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isSpecialMiniApp	()Z
    //   433: ifne +34 -> 467
    //   436: getstatic 24	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:navigateBackByAPPInfo	I
    //   439: iconst_1
    //   440: if_icmpne +27 -> 467
    //   443: aload 10
    //   445: aload_0
    //   446: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   449: invokevirtual 282	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:getVerTypeStr	()Ljava/lang/String;
    //   452: putfield 285	com/tencent/qqmini/sdk/launcher/model/LaunchParam:j	Ljava/lang/String;
    //   455: aload 10
    //   457: aload_0
    //   458: getfield 94	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   461: invokestatic 76	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:copy	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   464: putfield 189	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   467: aload 7
    //   469: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   472: ifne +150 -> 622
    //   475: aload 10
    //   477: new 287	java/util/HashMap
    //   480: dup
    //   481: invokespecial 288	java/util/HashMap:<init>	()V
    //   484: putfield 291	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   487: aload 7
    //   489: ldc_w 293
    //   492: invokevirtual 297	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   495: astore 5
    //   497: aload 5
    //   499: arraylength
    //   500: istore_3
    //   501: iconst_0
    //   502: istore_2
    //   503: iload_2
    //   504: iload_3
    //   505: if_icmpge +117 -> 622
    //   508: aload 5
    //   510: iload_2
    //   511: aaload
    //   512: astore 11
    //   514: aload 11
    //   516: ldc_w 299
    //   519: invokevirtual 302	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   522: istore 4
    //   524: iload 4
    //   526: ifle +63 -> 589
    //   529: iload 4
    //   531: aload 11
    //   533: invokevirtual 306	java/lang/String:length	()I
    //   536: iconst_1
    //   537: isub
    //   538: if_icmpge +51 -> 589
    //   541: aload 11
    //   543: iconst_0
    //   544: iload 4
    //   546: invokevirtual 310	java/lang/String:substring	(II)Ljava/lang/String;
    //   549: ldc_w 312
    //   552: invokestatic 318	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   555: astore 7
    //   557: aload 11
    //   559: iload 4
    //   561: iconst_1
    //   562: iadd
    //   563: invokevirtual 321	java/lang/String:substring	(I)Ljava/lang/String;
    //   566: ldc_w 312
    //   569: invokestatic 318	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   572: astore 11
    //   574: aload 10
    //   576: getfield 291	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   579: aload 7
    //   581: aload 11
    //   583: invokeinterface 327 3 0
    //   588: pop
    //   589: iload_2
    //   590: iconst_1
    //   591: iadd
    //   592: istore_2
    //   593: goto -90 -> 503
    //   596: ldc 252
    //   598: astore 5
    //   600: goto -252 -> 348
    //   603: sipush 1037
    //   606: istore_2
    //   607: goto -238 -> 369
    //   610: astore 5
    //   612: ldc 8
    //   614: ldc_w 329
    //   617: aload 5
    //   619: invokestatic 185	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   622: aload_0
    //   623: getfield 101	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin:mMiniAppContext	Lbehq;
    //   626: invokeinterface 106 1 0
    //   631: aload 6
    //   633: aload 10
    //   635: getfield 87	com/tencent/qqmini/sdk/launcher/model/LaunchParam:jdField_a_of_type_Int	I
    //   638: aload 8
    //   640: aload 9
    //   642: aload 10
    //   644: new 331	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin$1
    //   647: dup
    //   648: aload_0
    //   649: new 120	android/os/Handler
    //   652: dup
    //   653: invokestatic 126	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   656: invokespecial 129	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   659: aload_1
    //   660: invokespecial 332	com/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin$1:<init>	(Lcom/tencent/qqmini/sdk/core/plugins/NavigationJsPlugin;Landroid/os/Handler;Lbekr;)V
    //   663: invokestatic 335	behj:a	(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;Landroid/os/ResultReceiver;)V
    //   666: aload_1
    //   667: invokevirtual 151	bekr:a	()Ljava/lang/String;
    //   670: pop
    //   671: return
    //   672: iload_2
    //   673: iconst_1
    //   674: if_icmpne -465 -> 209
    //   677: return
    //   678: goto -597 -> 81
    //   681: sipush 1037
    //   684: istore_2
    //   685: goto -7 -> 678
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	this	NavigationJsPlugin
    //   0	688	1	parambekr	bekr
    //   80	605	2	i	int
    //   3	503	3	j	int
    //   522	41	4	k	int
    //   15	67	5	localJSONObject	JSONObject
    //   210	7	5	localThrowable	Throwable
    //   222	377	5	localObject1	Object
    //   610	8	5	localException1	java.lang.Exception
    //   88	159	6	localObject2	Object
    //   251	29	6	localException2	java.lang.Exception
    //   301	331	6	str1	String
    //   29	551	7	str2	String
    //   36	603	8	localObject3	Object
    //   48	593	9	localObject4	Object
    //   109	534	10	localLaunchParam	LaunchParam
    //   512	70	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   4	17	210	java/lang/Throwable
    //   55	77	251	java/lang/Exception
    //   81	90	251	java/lang/Exception
    //   95	102	251	java/lang/Exception
    //   102	139	251	java/lang/Exception
    //   144	151	251	java/lang/Exception
    //   151	204	251	java/lang/Exception
    //   227	237	251	java/lang/Exception
    //   475	501	610	java/lang/Exception
    //   514	524	610	java/lang/Exception
    //   529	589	610	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */