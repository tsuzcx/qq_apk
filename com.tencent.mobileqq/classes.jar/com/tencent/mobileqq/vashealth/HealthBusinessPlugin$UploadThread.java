package com.tencent.mobileqq.vashealth;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class HealthBusinessPlugin$UploadThread
  extends Thread
{
  public boolean a = false;
  List<String> b;
  WeakReference<QBaseActivity> c;
  String d;
  String e;
  boolean f;
  String g;
  String h;
  
  public HealthBusinessPlugin$UploadThread(QBaseActivity paramQBaseActivity, List<String> paramList, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    this.b = new ArrayList(paramString1);
    this.c = new WeakReference(paramList);
    this.d = paramString2;
    this.e = paramBoolean;
    this.f = paramString3;
    this.g = paramString4;
    Object localObject;
    this.h = localObject;
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    if (FileUtils.fileExists(paramString2))
    {
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("Connection", "keep-alive");
      localHashMap1.put("Referer", "c.yundong.qq.com");
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("picstream", paramString2);
      paramString2 = paramMap;
      if (paramMap == null) {
        paramString2 = new HashMap();
      }
      paramString1 = HttpUtil.uploadImage(paramString1, paramString3, paramString4, paramString2, localHashMap2, localHashMap1);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("upload result:");
        paramString2.append(paramString1);
        QLog.i("HealthBusinessPlugin", 2, paramString2.toString());
      }
      if (TextUtils.isEmpty(paramString1)) {
        return null;
      }
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1.getInt("code") != 0) {
          return null;
        }
        paramString1 = URLDecoder.decode(paramString1.getJSONObject("data").getString("picUrl"), "utf-8");
        return paramString1;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("parse json Err:");
          paramString2.append(paramString1);
          QLog.i("HealthBusinessPlugin", 2, paramString2.toString());
        }
      }
    }
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 161
    //   2: astore 8
    //   4: aload_0
    //   5: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:c	Ljava/lang/ref/WeakReference;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnonnull +9 -> 21
    //   15: aconst_null
    //   16: astore 5
    //   18: goto +13 -> 31
    //   21: aload 5
    //   23: invokevirtual 165	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   26: checkcast 167	com/tencent/mobileqq/app/QBaseActivity
    //   29: astore 5
    //   31: ldc 107
    //   33: astore 9
    //   35: aload 5
    //   37: ifnull +2128 -> 2165
    //   40: aload_0
    //   41: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   44: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +6 -> 53
    //   50: goto +2115 -> 2165
    //   53: aload_0
    //   54: getfield 24	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   57: getfield 173	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   60: invokevirtual 178	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:c	()Lmqq/app/AppRuntime;
    //   63: invokevirtual 183	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   66: astore 12
    //   68: aload_0
    //   69: getfield 24	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   72: getfield 173	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   75: invokevirtual 178	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:c	()Lmqq/app/AppRuntime;
    //   78: iconst_2
    //   79: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   82: checkcast 189	mqq/manager/TicketManager
    //   85: aload 12
    //   87: invokeinterface 192 2 0
    //   92: astore 7
    //   94: aload 7
    //   96: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifeq +18 -> 117
    //   102: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +11 -> 116
    //   108: ldc 107
    //   110: iconst_2
    //   111: ldc 194
    //   113: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: return
    //   117: aload 7
    //   119: invokevirtual 202	java/lang/String:length	()I
    //   122: istore_3
    //   123: iconst_0
    //   124: istore_1
    //   125: sipush 5381
    //   128: istore_2
    //   129: iload_1
    //   130: iload_3
    //   131: if_icmpge +23 -> 154
    //   134: iload_2
    //   135: iload_2
    //   136: iconst_5
    //   137: ishl
    //   138: aload 7
    //   140: iload_1
    //   141: invokevirtual 206	java/lang/String:charAt	(I)C
    //   144: iadd
    //   145: iadd
    //   146: istore_2
    //   147: iload_1
    //   148: iconst_1
    //   149: iadd
    //   150: istore_1
    //   151: goto -22 -> 129
    //   154: iload_2
    //   155: ldc 207
    //   157: iand
    //   158: istore_1
    //   159: new 98	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   166: astore 5
    //   168: aload 5
    //   170: ldc 209
    //   172: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 5
    //   178: iload_1
    //   179: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: ldc 107
    //   185: iconst_1
    //   186: aload 5
    //   188: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_0
    //   195: getfield 49	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:f	Z
    //   198: ifeq +19 -> 217
    //   201: new 98	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   208: astore 5
    //   210: ldc 214
    //   212: astore 6
    //   214: goto +16 -> 230
    //   217: new 98	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   224: astore 5
    //   226: ldc 216
    //   228: astore 6
    //   230: aload 5
    //   232: aload 6
    //   234: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 5
    //   240: iload_1
    //   241: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 5
    //   247: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: astore 5
    //   252: ldc 218
    //   254: astore 6
    //   256: aload 5
    //   258: ldc 218
    //   260: aload 12
    //   262: invokestatic 223	com/tencent/util/URLUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   265: astore 11
    //   267: aload_0
    //   268: getfield 49	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:f	Z
    //   271: ifne +300 -> 571
    //   274: getstatic 225	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   277: aload_0
    //   278: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   281: invokeinterface 231 2 0
    //   286: ifne +16 -> 302
    //   289: getstatic 225	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   292: aload_0
    //   293: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   296: invokeinterface 234 2 0
    //   301: pop
    //   302: aload_0
    //   303: getfield 36	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:b	Ljava/util/List;
    //   306: iconst_0
    //   307: invokeinterface 237 2 0
    //   312: checkcast 198	java/lang/String
    //   315: astore 5
    //   317: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +66 -> 386
    //   323: new 98	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   330: astore 6
    //   332: aload 6
    //   334: ldc 239
    //   336: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 6
    //   342: aload_0
    //   343: getfield 36	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:b	Ljava/util/List;
    //   346: iconst_0
    //   347: invokeinterface 237 2 0
    //   352: checkcast 198	java/lang/String
    //   355: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 6
    //   361: ldc 241
    //   363: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 6
    //   369: aload 5
    //   371: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: ldc 107
    //   377: iconst_2
    //   378: aload 6
    //   380: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload 5
    //   388: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifeq +4 -> 395
    //   394: return
    //   395: new 67	java/util/HashMap
    //   398: dup
    //   399: invokespecial 68	java/util/HashMap:<init>	()V
    //   402: astore 6
    //   404: aload 6
    //   406: ldc 243
    //   408: aload_0
    //   409: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   412: invokevirtual 244	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   415: pop
    //   416: new 246	android/os/Bundle
    //   419: dup
    //   420: invokespecial 247	android/os/Bundle:<init>	()V
    //   423: astore 8
    //   425: aload 8
    //   427: ldc 249
    //   429: aload_0
    //   430: getfield 51	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:g	Ljava/lang/String;
    //   433: invokevirtual 253	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: aload 8
    //   438: ldc 255
    //   440: aload_0
    //   441: getfield 53	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:h	Ljava/lang/String;
    //   444: invokevirtual 253	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 8
    //   449: ldc_w 257
    //   452: aload 5
    //   454: invokevirtual 253	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload 8
    //   459: ldc_w 259
    //   462: new 261	java/io/File
    //   465: dup
    //   466: aload 5
    //   468: invokespecial 262	java/io/File:<init>	(Ljava/lang/String;)V
    //   471: invokevirtual 265	java/io/File:getName	()Ljava/lang/String;
    //   474: invokevirtual 253	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload_0
    //   478: getfield 24	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   481: aload 11
    //   483: aload 5
    //   485: aload 12
    //   487: aload 7
    //   489: aload 6
    //   491: aload 8
    //   493: aload_0
    //   494: invokevirtual 268	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Landroid/os/Bundle;Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread;)V
    //   497: getstatic 225	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   500: aload_0
    //   501: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   504: invokeinterface 271 2 0
    //   509: pop
    //   510: getstatic 274	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:i	Ljava/util/HashMap;
    //   513: aload_0
    //   514: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   517: invokevirtual 277	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   520: pop
    //   521: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +46 -> 570
    //   527: new 98	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   534: astore 5
    //   536: aload 5
    //   538: ldc_w 279
    //   541: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 5
    //   547: getstatic 225	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   550: invokeinterface 282 1 0
    //   555: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: ldc 107
    //   561: iconst_2
    //   562: aload 5
    //   564: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: return
    //   571: aload_0
    //   572: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:c	Ljava/lang/ref/WeakReference;
    //   575: invokevirtual 165	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   578: checkcast 167	com/tencent/mobileqq/app/QBaseActivity
    //   581: astore 5
    //   583: new 98	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   590: astore 10
    //   592: aload 10
    //   594: aload 12
    //   596: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 10
    //   602: ldc_w 284
    //   605: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload 5
    //   611: aload 10
    //   613: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: iconst_0
    //   617: invokevirtual 288	com/tencent/mobileqq/app/QBaseActivity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   620: astore 10
    //   622: aload_0
    //   623: getfield 36	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:b	Ljava/util/List;
    //   626: invokeinterface 292 1 0
    //   631: astore 13
    //   633: iconst_0
    //   634: istore_3
    //   635: iconst_0
    //   636: istore_2
    //   637: aload 9
    //   639: astore 5
    //   641: aload 6
    //   643: astore 9
    //   645: aload 10
    //   647: astore 6
    //   649: aload 13
    //   651: invokeinterface 297 1 0
    //   656: ifeq +273 -> 929
    //   659: aload 13
    //   661: invokeinterface 300 1 0
    //   666: checkcast 198	java/lang/String
    //   669: astore 15
    //   671: aload 6
    //   673: aload_0
    //   674: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   677: aconst_null
    //   678: invokeinterface 304 3 0
    //   683: astore 10
    //   685: aload 15
    //   687: ldc_w 306
    //   690: ldc_w 308
    //   693: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   696: astore 14
    //   698: aload 10
    //   700: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   703: ifeq +13 -> 716
    //   706: aload 5
    //   708: iconst_1
    //   709: ldc_w 314
    //   712: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   715: return
    //   716: aload 15
    //   718: iconst_0
    //   719: invokestatic 319	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   722: astore 16
    //   724: aload 16
    //   726: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifeq +103 -> 832
    //   732: new 98	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   739: astore 16
    //   741: aload 16
    //   743: ldc_w 321
    //   746: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 16
    //   752: aload 15
    //   754: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: pop
    //   758: aload 16
    //   760: ldc_w 323
    //   763: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload 16
    //   769: aload 15
    //   771: invokestatic 65	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   774: invokevirtual 326	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 5
    //   780: iconst_1
    //   781: aload 16
    //   783: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: aload 10
    //   791: aload 14
    //   793: ldc_w 328
    //   796: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   799: astore 10
    //   801: aload 6
    //   803: invokeinterface 332 1 0
    //   808: aload_0
    //   809: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   812: aload 10
    //   814: invokeinterface 337 3 0
    //   819: invokeinterface 340 1 0
    //   824: pop
    //   825: iload_2
    //   826: iconst_1
    //   827: iadd
    //   828: istore_2
    //   829: goto -180 -> 649
    //   832: new 67	java/util/HashMap
    //   835: dup
    //   836: invokespecial 68	java/util/HashMap:<init>	()V
    //   839: astore 15
    //   841: aload 15
    //   843: ldc_w 342
    //   846: aload_0
    //   847: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   850: invokevirtual 244	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   853: pop
    //   854: aload_0
    //   855: aload 11
    //   857: aload 16
    //   859: aload 12
    //   861: aload 7
    //   863: aload 15
    //   865: invokevirtual 344	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   868: astore 15
    //   870: aload 15
    //   872: ifnull +50 -> 922
    //   875: aload 10
    //   877: aload 14
    //   879: aload 15
    //   881: ldc_w 306
    //   884: ldc_w 308
    //   887: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   890: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   893: astore 10
    //   895: aload 6
    //   897: invokeinterface 332 1 0
    //   902: aload_0
    //   903: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   906: aload 10
    //   908: invokeinterface 337 3 0
    //   913: invokeinterface 340 1 0
    //   918: pop
    //   919: goto +7 -> 926
    //   922: iload_3
    //   923: iconst_1
    //   924: iadd
    //   925: istore_3
    //   926: goto -97 -> 829
    //   929: aload_0
    //   930: getfield 36	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:b	Ljava/util/List;
    //   933: invokeinterface 282 1 0
    //   938: istore 4
    //   940: iload_2
    //   941: iload 4
    //   943: if_icmpne +86 -> 1029
    //   946: new 123	org/json/JSONObject
    //   949: dup
    //   950: aload 6
    //   952: aload_0
    //   953: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   956: ldc_w 346
    //   959: invokeinterface 304 3 0
    //   964: invokespecial 126	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   967: astore 7
    //   969: aload 7
    //   971: ldc_w 348
    //   974: iconst_1
    //   975: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   978: pop
    //   979: aload 6
    //   981: invokeinterface 332 1 0
    //   986: aload_0
    //   987: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   990: aload 7
    //   992: invokevirtual 352	org/json/JSONObject:toString	()Ljava/lang/String;
    //   995: invokeinterface 337 3 0
    //   1000: invokeinterface 340 1 0
    //   1005: pop
    //   1006: aload 5
    //   1008: iconst_1
    //   1009: ldc_w 354
    //   1012: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1015: getstatic 225	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   1018: aload_0
    //   1019: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   1022: invokeinterface 271 2 0
    //   1027: pop
    //   1028: return
    //   1029: aload 5
    //   1031: astore 11
    //   1033: iload_3
    //   1034: ifle +77 -> 1111
    //   1037: new 98	java/lang/StringBuilder
    //   1040: dup
    //   1041: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1044: astore 6
    //   1046: aload 6
    //   1048: ldc_w 356
    //   1051: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: pop
    //   1055: aload 6
    //   1057: iload_3
    //   1058: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload 6
    //   1064: ldc_w 358
    //   1067: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: pop
    //   1071: aload 6
    //   1073: aload_0
    //   1074: getfield 36	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:b	Ljava/util/List;
    //   1077: invokeinterface 282 1 0
    //   1082: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1085: pop
    //   1086: aload 11
    //   1088: iconst_1
    //   1089: aload 6
    //   1091: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1097: getstatic 225	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   1100: aload_0
    //   1101: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   1104: invokeinterface 271 2 0
    //   1109: pop
    //   1110: return
    //   1111: new 98	java/lang/StringBuilder
    //   1114: dup
    //   1115: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1118: astore 10
    //   1120: aload 10
    //   1122: ldc_w 360
    //   1125: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: pop
    //   1129: aload 10
    //   1131: iload_1
    //   1132: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: new 362	java/net/URL
    //   1139: dup
    //   1140: aload 10
    //   1142: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: aload 9
    //   1147: aload 12
    //   1149: invokestatic 223	com/tencent/util/URLUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1152: invokespecial 363	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1155: invokevirtual 367	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1158: checkcast 369	java/net/HttpURLConnection
    //   1161: astore 10
    //   1163: aload 10
    //   1165: astore 9
    //   1167: aload 10
    //   1169: sipush 5000
    //   1172: invokevirtual 373	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1175: aload 10
    //   1177: astore 9
    //   1179: aload 10
    //   1181: sipush 30000
    //   1184: invokevirtual 376	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1187: aload 10
    //   1189: astore 9
    //   1191: aload 10
    //   1193: iconst_1
    //   1194: invokevirtual 380	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1197: aload 10
    //   1199: astore 9
    //   1201: aload 10
    //   1203: iconst_1
    //   1204: invokevirtual 383	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1207: aload 10
    //   1209: astore 9
    //   1211: aload 10
    //   1213: iconst_0
    //   1214: invokevirtual 386	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1217: aload 10
    //   1219: astore 9
    //   1221: aload 10
    //   1223: ldc_w 388
    //   1226: invokevirtual 391	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1229: aload 10
    //   1231: astore 9
    //   1233: aload 10
    //   1235: ldc 70
    //   1237: ldc_w 393
    //   1240: invokevirtual 396	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1243: aload 10
    //   1245: astore 9
    //   1247: new 98	java/lang/StringBuilder
    //   1250: dup
    //   1251: ldc_w 398
    //   1254: invokespecial 399	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1257: astore 13
    //   1259: aload 10
    //   1261: astore 9
    //   1263: aload 13
    //   1265: aload 8
    //   1267: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: pop
    //   1271: aload 10
    //   1273: astore 9
    //   1275: aload 13
    //   1277: getstatic 404	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   1280: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: pop
    //   1284: aload 10
    //   1286: astore 9
    //   1288: aload 13
    //   1290: aload 8
    //   1292: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: aload 10
    //   1298: astore 9
    //   1300: aload 13
    //   1302: getstatic 409	android/os/Build:DEVICE	Ljava/lang/String;
    //   1305: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: pop
    //   1309: aload 10
    //   1311: astore 9
    //   1313: aload 13
    //   1315: aload 8
    //   1317: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: aload 10
    //   1323: astore 9
    //   1325: aload 13
    //   1327: getstatic 412	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   1330: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload 10
    //   1336: astore 9
    //   1338: aload 13
    //   1340: aload 8
    //   1342: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: aload 10
    //   1348: astore 9
    //   1350: aload 13
    //   1352: ldc_w 414
    //   1355: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: pop
    //   1359: aload 10
    //   1361: astore 9
    //   1363: aload 10
    //   1365: ldc_w 416
    //   1368: aload 13
    //   1370: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1373: invokevirtual 396	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1376: aload 10
    //   1378: astore 9
    //   1380: aload 10
    //   1382: ldc_w 418
    //   1385: ldc_w 420
    //   1388: invokevirtual 396	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1391: aload 10
    //   1393: astore 9
    //   1395: new 98	java/lang/StringBuilder
    //   1398: dup
    //   1399: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1402: astore 8
    //   1404: aload 10
    //   1406: astore 9
    //   1408: aload 8
    //   1410: ldc_w 422
    //   1413: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: pop
    //   1417: aload 10
    //   1419: astore 9
    //   1421: aload 8
    //   1423: aload 12
    //   1425: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: pop
    //   1429: aload 10
    //   1431: astore 9
    //   1433: aload 8
    //   1435: ldc_w 424
    //   1438: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: pop
    //   1442: aload 10
    //   1444: astore 9
    //   1446: aload 8
    //   1448: aload 7
    //   1450: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: pop
    //   1454: aload 10
    //   1456: astore 9
    //   1458: aload 10
    //   1460: ldc_w 426
    //   1463: aload 8
    //   1465: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1468: invokevirtual 396	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1471: aload 10
    //   1473: astore 9
    //   1475: new 428	java/io/DataOutputStream
    //   1478: dup
    //   1479: aload 10
    //   1481: invokevirtual 432	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1484: invokespecial 435	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1487: astore 7
    //   1489: aload 10
    //   1491: astore 9
    //   1493: new 437	java/lang/StringBuffer
    //   1496: dup
    //   1497: invokespecial 438	java/lang/StringBuffer:<init>	()V
    //   1500: astore 8
    //   1502: aload 10
    //   1504: astore 9
    //   1506: aload 8
    //   1508: ldc_w 440
    //   1511: invokevirtual 443	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1514: pop
    //   1515: aload 10
    //   1517: astore 9
    //   1519: aload 8
    //   1521: aload_0
    //   1522: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   1525: invokevirtual 443	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1528: pop
    //   1529: aload 10
    //   1531: astore 9
    //   1533: aload 7
    //   1535: aload 8
    //   1537: invokevirtual 444	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1540: invokevirtual 448	java/lang/String:getBytes	()[B
    //   1543: invokevirtual 454	java/io/OutputStream:write	([B)V
    //   1546: aload 10
    //   1548: astore 9
    //   1550: aload 7
    //   1552: invokevirtual 457	java/io/OutputStream:flush	()V
    //   1555: aload 10
    //   1557: astore 9
    //   1559: aload 7
    //   1561: invokevirtual 460	java/io/OutputStream:close	()V
    //   1564: aload 10
    //   1566: astore 9
    //   1568: new 437	java/lang/StringBuffer
    //   1571: dup
    //   1572: invokespecial 438	java/lang/StringBuffer:<init>	()V
    //   1575: astore 8
    //   1577: aload 10
    //   1579: astore 9
    //   1581: new 462	java/io/BufferedReader
    //   1584: dup
    //   1585: new 464	java/io/InputStreamReader
    //   1588: dup
    //   1589: aload 10
    //   1591: invokevirtual 468	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1594: invokespecial 471	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1597: invokespecial 474	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1600: astore 7
    //   1602: aload 10
    //   1604: astore 9
    //   1606: aload 7
    //   1608: invokevirtual 477	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1611: astore 12
    //   1613: aload 12
    //   1615: ifnull +31 -> 1646
    //   1618: aload 10
    //   1620: astore 9
    //   1622: aload 8
    //   1624: aload 12
    //   1626: invokevirtual 443	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1629: pop
    //   1630: aload 10
    //   1632: astore 9
    //   1634: aload 8
    //   1636: ldc_w 479
    //   1639: invokevirtual 443	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1642: pop
    //   1643: goto -41 -> 1602
    //   1646: aload 10
    //   1648: astore 9
    //   1650: aload 8
    //   1652: invokevirtual 444	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1655: astore 8
    //   1657: aload 10
    //   1659: astore 9
    //   1661: aload 8
    //   1663: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1666: ifeq +16 -> 1682
    //   1669: aload 10
    //   1671: astore 9
    //   1673: aload 11
    //   1675: iconst_1
    //   1676: ldc_w 481
    //   1679: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1682: aload 10
    //   1684: astore 9
    //   1686: new 123	org/json/JSONObject
    //   1689: dup
    //   1690: aload 8
    //   1692: invokespecial 126	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1695: ldc 128
    //   1697: invokevirtual 132	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1700: istore_1
    //   1701: iload_1
    //   1702: ifne +158 -> 1860
    //   1705: aload 10
    //   1707: astore 9
    //   1709: new 123	org/json/JSONObject
    //   1712: dup
    //   1713: aload 6
    //   1715: aload_0
    //   1716: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   1719: ldc_w 346
    //   1722: invokeinterface 304 3 0
    //   1727: invokespecial 126	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1730: astore 12
    //   1732: aload 10
    //   1734: astore 9
    //   1736: aload 12
    //   1738: ldc_w 348
    //   1741: iconst_0
    //   1742: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1745: pop
    //   1746: aload 10
    //   1748: astore 9
    //   1750: aload 6
    //   1752: invokeinterface 332 1 0
    //   1757: aload_0
    //   1758: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   1761: aload 12
    //   1763: invokevirtual 352	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1766: invokeinterface 337 3 0
    //   1771: invokeinterface 340 1 0
    //   1776: pop
    //   1777: aload 10
    //   1779: astore 9
    //   1781: new 98	java/lang/StringBuilder
    //   1784: dup
    //   1785: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1788: astore 6
    //   1790: aload 10
    //   1792: astore 9
    //   1794: aload 6
    //   1796: ldc_w 483
    //   1799: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: pop
    //   1803: aload 10
    //   1805: astore 9
    //   1807: aload 6
    //   1809: aload_0
    //   1810: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   1813: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: pop
    //   1817: aload 10
    //   1819: astore 9
    //   1821: aload 6
    //   1823: ldc_w 485
    //   1826: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: pop
    //   1830: aload 10
    //   1832: astore 9
    //   1834: aload 6
    //   1836: aload 8
    //   1838: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1841: pop
    //   1842: aload 10
    //   1844: astore 9
    //   1846: aload 11
    //   1848: iconst_1
    //   1849: aload 6
    //   1851: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1854: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1857: goto +155 -> 2012
    //   1860: aload 10
    //   1862: astore 9
    //   1864: new 123	org/json/JSONObject
    //   1867: dup
    //   1868: aload 6
    //   1870: aload_0
    //   1871: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   1874: ldc_w 346
    //   1877: invokeinterface 304 3 0
    //   1882: invokespecial 126	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1885: astore 12
    //   1887: aload 10
    //   1889: astore 9
    //   1891: aload 12
    //   1893: ldc_w 348
    //   1896: iconst_2
    //   1897: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1900: pop
    //   1901: aload 10
    //   1903: astore 9
    //   1905: aload 6
    //   1907: invokeinterface 332 1 0
    //   1912: aload_0
    //   1913: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   1916: aload 12
    //   1918: invokevirtual 352	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1921: invokeinterface 337 3 0
    //   1926: invokeinterface 340 1 0
    //   1931: pop
    //   1932: aload 10
    //   1934: astore 9
    //   1936: new 98	java/lang/StringBuilder
    //   1939: dup
    //   1940: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1943: astore 6
    //   1945: aload 10
    //   1947: astore 9
    //   1949: aload 6
    //   1951: ldc_w 487
    //   1954: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: pop
    //   1958: aload 10
    //   1960: astore 9
    //   1962: aload 6
    //   1964: aload_0
    //   1965: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   1968: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1971: pop
    //   1972: aload 10
    //   1974: astore 9
    //   1976: aload 6
    //   1978: ldc_w 485
    //   1981: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: aload 10
    //   1987: astore 9
    //   1989: aload 6
    //   1991: aload 8
    //   1993: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1996: pop
    //   1997: aload 10
    //   1999: astore 9
    //   2001: aload 11
    //   2003: iconst_1
    //   2004: aload 6
    //   2006: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2009: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2012: aload 10
    //   2014: astore 9
    //   2016: aload 7
    //   2018: invokevirtual 488	java/io/BufferedReader:close	()V
    //   2021: aload 10
    //   2023: ifnull +100 -> 2123
    //   2026: aload 10
    //   2028: astore 6
    //   2030: goto +88 -> 2118
    //   2033: astore 7
    //   2035: aload 10
    //   2037: astore 6
    //   2039: goto +21 -> 2060
    //   2042: astore 7
    //   2044: goto +13 -> 2057
    //   2047: astore 5
    //   2049: aconst_null
    //   2050: astore 9
    //   2052: goto +87 -> 2139
    //   2055: astore 7
    //   2057: aconst_null
    //   2058: astore 6
    //   2060: aload 6
    //   2062: astore 9
    //   2064: new 98	java/lang/StringBuilder
    //   2067: dup
    //   2068: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   2071: astore 8
    //   2073: aload 6
    //   2075: astore 9
    //   2077: aload 8
    //   2079: ldc_w 490
    //   2082: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2085: pop
    //   2086: aload 6
    //   2088: astore 9
    //   2090: aload 8
    //   2092: aload 7
    //   2094: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2097: pop
    //   2098: aload 6
    //   2100: astore 9
    //   2102: aload 5
    //   2104: iconst_2
    //   2105: aload 8
    //   2107: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2110: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2113: aload 6
    //   2115: ifnull +8 -> 2123
    //   2118: aload 6
    //   2120: invokevirtual 493	java/net/HttpURLConnection:disconnect	()V
    //   2123: getstatic 225	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   2126: aload_0
    //   2127: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   2130: invokeinterface 271 2 0
    //   2135: pop
    //   2136: return
    //   2137: astore 5
    //   2139: aload 9
    //   2141: ifnull +8 -> 2149
    //   2144: aload 9
    //   2146: invokevirtual 493	java/net/HttpURLConnection:disconnect	()V
    //   2149: getstatic 225	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:f	Ljava/util/List;
    //   2152: aload_0
    //   2153: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:e	Ljava/lang/String;
    //   2156: invokeinterface 271 2 0
    //   2161: pop
    //   2162: aload 5
    //   2164: athrow
    //   2165: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2168: ifeq +45 -> 2213
    //   2171: new 98	java/lang/StringBuilder
    //   2174: dup
    //   2175: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   2178: astore 5
    //   2180: aload 5
    //   2182: ldc_w 495
    //   2185: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2188: pop
    //   2189: aload 5
    //   2191: aload_0
    //   2192: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   2195: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2198: invokevirtual 326	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2201: pop
    //   2202: ldc 107
    //   2204: iconst_2
    //   2205: aload 5
    //   2207: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2210: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2213: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2214	0	this	UploadThread
    //   124	1578	1	i	int
    //   128	816	2	j	int
    //   122	936	3	k	int
    //   938	6	4	m	int
    //   8	1022	5	localObject1	Object
    //   2047	56	5	str1	String
    //   2137	26	5	localObject2	Object
    //   2178	28	5	localStringBuilder	StringBuilder
    //   212	1907	6	localObject3	Object
    //   92	1925	7	localObject4	Object
    //   2033	1	7	localException1	Exception
    //   2042	1	7	localException2	Exception
    //   2055	38	7	localException3	Exception
    //   2	2104	8	localObject5	Object
    //   33	2112	9	localObject6	Object
    //   590	1446	10	localObject7	Object
    //   265	1737	11	localObject8	Object
    //   66	1851	12	localObject9	Object
    //   631	738	13	localObject10	Object
    //   696	182	14	str2	String
    //   669	211	15	localObject11	Object
    //   722	136	16	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   1167	1175	2033	java/lang/Exception
    //   1179	1187	2033	java/lang/Exception
    //   1191	1197	2033	java/lang/Exception
    //   1201	1207	2033	java/lang/Exception
    //   1211	1217	2033	java/lang/Exception
    //   1221	1229	2033	java/lang/Exception
    //   1233	1243	2033	java/lang/Exception
    //   1247	1259	2033	java/lang/Exception
    //   1263	1271	2033	java/lang/Exception
    //   1275	1284	2033	java/lang/Exception
    //   1288	1296	2033	java/lang/Exception
    //   1300	1309	2033	java/lang/Exception
    //   1313	1321	2033	java/lang/Exception
    //   1325	1334	2033	java/lang/Exception
    //   1338	1346	2033	java/lang/Exception
    //   1350	1359	2033	java/lang/Exception
    //   1363	1376	2033	java/lang/Exception
    //   1380	1391	2033	java/lang/Exception
    //   1395	1404	2033	java/lang/Exception
    //   1408	1417	2033	java/lang/Exception
    //   1421	1429	2033	java/lang/Exception
    //   1433	1442	2033	java/lang/Exception
    //   1446	1454	2033	java/lang/Exception
    //   1458	1471	2033	java/lang/Exception
    //   1475	1489	2033	java/lang/Exception
    //   1493	1502	2033	java/lang/Exception
    //   1506	1515	2033	java/lang/Exception
    //   1519	1529	2033	java/lang/Exception
    //   1533	1546	2033	java/lang/Exception
    //   1550	1555	2033	java/lang/Exception
    //   1559	1564	2033	java/lang/Exception
    //   1568	1577	2033	java/lang/Exception
    //   1581	1602	2033	java/lang/Exception
    //   1606	1613	2033	java/lang/Exception
    //   1622	1630	2033	java/lang/Exception
    //   1634	1643	2033	java/lang/Exception
    //   1650	1657	2033	java/lang/Exception
    //   1661	1669	2033	java/lang/Exception
    //   1673	1682	2033	java/lang/Exception
    //   1686	1701	2033	java/lang/Exception
    //   1709	1732	2033	java/lang/Exception
    //   1736	1746	2033	java/lang/Exception
    //   1750	1777	2033	java/lang/Exception
    //   1781	1790	2033	java/lang/Exception
    //   1794	1803	2033	java/lang/Exception
    //   1807	1817	2033	java/lang/Exception
    //   1821	1830	2033	java/lang/Exception
    //   1834	1842	2033	java/lang/Exception
    //   1846	1857	2033	java/lang/Exception
    //   1864	1887	2033	java/lang/Exception
    //   1891	1901	2033	java/lang/Exception
    //   1905	1932	2033	java/lang/Exception
    //   1936	1945	2033	java/lang/Exception
    //   1949	1958	2033	java/lang/Exception
    //   1962	1972	2033	java/lang/Exception
    //   1976	1985	2033	java/lang/Exception
    //   1989	1997	2033	java/lang/Exception
    //   2001	2012	2033	java/lang/Exception
    //   2016	2021	2033	java/lang/Exception
    //   1006	1015	2042	java/lang/Exception
    //   1037	1097	2042	java/lang/Exception
    //   1111	1163	2042	java/lang/Exception
    //   929	940	2047	finally
    //   946	1006	2047	finally
    //   1006	1015	2047	finally
    //   1037	1097	2047	finally
    //   1111	1163	2047	finally
    //   929	940	2055	java/lang/Exception
    //   946	1006	2055	java/lang/Exception
    //   1167	1175	2137	finally
    //   1179	1187	2137	finally
    //   1191	1197	2137	finally
    //   1201	1207	2137	finally
    //   1211	1217	2137	finally
    //   1221	1229	2137	finally
    //   1233	1243	2137	finally
    //   1247	1259	2137	finally
    //   1263	1271	2137	finally
    //   1275	1284	2137	finally
    //   1288	1296	2137	finally
    //   1300	1309	2137	finally
    //   1313	1321	2137	finally
    //   1325	1334	2137	finally
    //   1338	1346	2137	finally
    //   1350	1359	2137	finally
    //   1363	1376	2137	finally
    //   1380	1391	2137	finally
    //   1395	1404	2137	finally
    //   1408	1417	2137	finally
    //   1421	1429	2137	finally
    //   1433	1442	2137	finally
    //   1446	1454	2137	finally
    //   1458	1471	2137	finally
    //   1475	1489	2137	finally
    //   1493	1502	2137	finally
    //   1506	1515	2137	finally
    //   1519	1529	2137	finally
    //   1533	1546	2137	finally
    //   1550	1555	2137	finally
    //   1559	1564	2137	finally
    //   1568	1577	2137	finally
    //   1581	1602	2137	finally
    //   1606	1613	2137	finally
    //   1622	1630	2137	finally
    //   1634	1643	2137	finally
    //   1650	1657	2137	finally
    //   1661	1669	2137	finally
    //   1673	1682	2137	finally
    //   1686	1701	2137	finally
    //   1709	1732	2137	finally
    //   1736	1746	2137	finally
    //   1750	1777	2137	finally
    //   1781	1790	2137	finally
    //   1794	1803	2137	finally
    //   1807	1817	2137	finally
    //   1821	1830	2137	finally
    //   1834	1842	2137	finally
    //   1846	1857	2137	finally
    //   1864	1887	2137	finally
    //   1891	1901	2137	finally
    //   1905	1932	2137	finally
    //   1936	1945	2137	finally
    //   1949	1958	2137	finally
    //   1962	1972	2137	finally
    //   1976	1985	2137	finally
    //   1989	1997	2137	finally
    //   2001	2012	2137	finally
    //   2016	2021	2137	finally
    //   2064	2073	2137	finally
    //   2077	2086	2137	finally
    //   2090	2098	2137	finally
    //   2102	2113	2137	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.UploadThread
 * JD-Core Version:    0.7.0.1
 */