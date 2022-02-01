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
  String jdField_a_of_type_JavaLangString;
  WeakReference<QBaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList;
  public boolean a;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  String c;
  String d;
  
  public HealthBusinessPlugin$UploadThread(QBaseActivity paramQBaseActivity, List<String> paramList, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramString1);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramList);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramBoolean;
    this.jdField_b_of_type_Boolean = paramString3;
    this.c = paramString4;
    Object localObject;
    this.d = localObject;
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
    //   0: ldc 157
    //   2: astore 8
    //   4: aload_0
    //   5: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnonnull +9 -> 21
    //   15: aconst_null
    //   16: astore 5
    //   18: goto +13 -> 31
    //   21: aload 5
    //   23: invokevirtual 161	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   26: checkcast 163	com/tencent/mobileqq/app/QBaseActivity
    //   29: astore 5
    //   31: ldc 103
    //   33: astore 9
    //   35: aload 5
    //   37: ifnull +2126 -> 2163
    //   40: aload_0
    //   41: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   44: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +6 -> 53
    //   50: goto +2113 -> 2163
    //   53: aload_0
    //   54: getfield 20	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   57: getfield 169	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   60: invokevirtual 174	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lmqq/app/AppRuntime;
    //   63: invokevirtual 179	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   66: astore 12
    //   68: aload_0
    //   69: getfield 20	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   72: getfield 169	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   75: invokevirtual 174	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lmqq/app/AppRuntime;
    //   78: iconst_2
    //   79: invokevirtual 183	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   82: checkcast 185	mqq/manager/TicketManager
    //   85: aload 12
    //   87: invokeinterface 188 2 0
    //   92: astore 7
    //   94: aload 7
    //   96: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifeq +18 -> 117
    //   102: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +11 -> 116
    //   108: ldc 103
    //   110: iconst_2
    //   111: ldc 190
    //   113: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: return
    //   117: aload 7
    //   119: invokevirtual 198	java/lang/String:length	()I
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
    //   141: invokevirtual 202	java/lang/String:charAt	(I)C
    //   144: iadd
    //   145: iadd
    //   146: istore_2
    //   147: iload_1
    //   148: iconst_1
    //   149: iadd
    //   150: istore_1
    //   151: goto -22 -> 129
    //   154: iload_2
    //   155: ldc 203
    //   157: iand
    //   158: istore_1
    //   159: new 94	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   166: astore 5
    //   168: aload 5
    //   170: ldc 205
    //   172: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 5
    //   178: iload_1
    //   179: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: ldc 103
    //   185: iconst_1
    //   186: aload 5
    //   188: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_0
    //   195: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_Boolean	Z
    //   198: ifeq +19 -> 217
    //   201: new 94	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   208: astore 5
    //   210: ldc 210
    //   212: astore 6
    //   214: goto +16 -> 230
    //   217: new 94	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   224: astore 5
    //   226: ldc 212
    //   228: astore 6
    //   230: aload 5
    //   232: aload 6
    //   234: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 5
    //   240: iload_1
    //   241: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 5
    //   247: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: astore 5
    //   252: ldc 214
    //   254: astore 6
    //   256: aload 5
    //   258: ldc 214
    //   260: aload 12
    //   262: invokestatic 219	com/tencent/util/URLUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   265: astore 11
    //   267: aload_0
    //   268: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_Boolean	Z
    //   271: ifne +298 -> 569
    //   274: getstatic 220	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   277: aload_0
    //   278: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   281: invokeinterface 226 2 0
    //   286: ifne +16 -> 302
    //   289: getstatic 220	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   292: aload_0
    //   293: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   296: invokeinterface 229 2 0
    //   301: pop
    //   302: aload_0
    //   303: getfield 32	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   306: iconst_0
    //   307: invokeinterface 232 2 0
    //   312: checkcast 194	java/lang/String
    //   315: astore 5
    //   317: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +66 -> 386
    //   323: new 94	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   330: astore 6
    //   332: aload 6
    //   334: ldc 234
    //   336: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 6
    //   342: aload_0
    //   343: getfield 32	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   346: iconst_0
    //   347: invokeinterface 232 2 0
    //   352: checkcast 194	java/lang/String
    //   355: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 6
    //   361: ldc 236
    //   363: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 6
    //   369: aload 5
    //   371: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: ldc 103
    //   377: iconst_2
    //   378: aload 6
    //   380: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload 5
    //   388: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifeq +4 -> 395
    //   394: return
    //   395: new 63	java/util/HashMap
    //   398: dup
    //   399: invokespecial 64	java/util/HashMap:<init>	()V
    //   402: astore 6
    //   404: aload 6
    //   406: ldc 238
    //   408: aload_0
    //   409: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   412: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   415: pop
    //   416: new 241	android/os/Bundle
    //   419: dup
    //   420: invokespecial 242	android/os/Bundle:<init>	()V
    //   423: astore 8
    //   425: aload 8
    //   427: ldc 244
    //   429: aload_0
    //   430: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:c	Ljava/lang/String;
    //   433: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: aload 8
    //   438: ldc 250
    //   440: aload_0
    //   441: getfield 49	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   444: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 8
    //   449: ldc 252
    //   451: aload 5
    //   453: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload 8
    //   458: ldc 254
    //   460: new 256	java/io/File
    //   463: dup
    //   464: aload 5
    //   466: invokespecial 257	java/io/File:<init>	(Ljava/lang/String;)V
    //   469: invokevirtual 260	java/io/File:getName	()Ljava/lang/String;
    //   472: invokevirtual 248	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: aload_0
    //   476: getfield 20	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   479: aload 11
    //   481: aload 5
    //   483: aload 12
    //   485: aload 7
    //   487: aload 6
    //   489: aload 8
    //   491: aload_0
    //   492: invokevirtual 263	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Landroid/os/Bundle;Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread;)V
    //   495: getstatic 220	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   498: aload_0
    //   499: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   502: invokeinterface 266 2 0
    //   507: pop
    //   508: getstatic 269	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   511: aload_0
    //   512: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   515: invokevirtual 272	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   518: pop
    //   519: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +46 -> 568
    //   525: new 94	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   532: astore 5
    //   534: aload 5
    //   536: ldc_w 274
    //   539: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 5
    //   545: getstatic 220	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   548: invokeinterface 277 1 0
    //   553: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: ldc 103
    //   559: iconst_2
    //   560: aload 5
    //   562: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: return
    //   569: aload_0
    //   570: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   573: invokevirtual 161	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   576: checkcast 163	com/tencent/mobileqq/app/QBaseActivity
    //   579: astore 5
    //   581: new 94	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   588: astore 10
    //   590: aload 10
    //   592: aload 12
    //   594: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload 10
    //   600: ldc_w 279
    //   603: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload 5
    //   609: aload 10
    //   611: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: iconst_0
    //   615: invokevirtual 283	com/tencent/mobileqq/app/QBaseActivity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   618: astore 10
    //   620: aload_0
    //   621: getfield 32	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   624: invokeinterface 287 1 0
    //   629: astore 13
    //   631: iconst_0
    //   632: istore_3
    //   633: iconst_0
    //   634: istore_2
    //   635: aload 9
    //   637: astore 5
    //   639: aload 6
    //   641: astore 9
    //   643: aload 10
    //   645: astore 6
    //   647: aload 13
    //   649: invokeinterface 292 1 0
    //   654: ifeq +273 -> 927
    //   657: aload 13
    //   659: invokeinterface 295 1 0
    //   664: checkcast 194	java/lang/String
    //   667: astore 15
    //   669: aload 6
    //   671: aload_0
    //   672: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   675: aconst_null
    //   676: invokeinterface 299 3 0
    //   681: astore 10
    //   683: aload 15
    //   685: ldc_w 301
    //   688: ldc_w 303
    //   691: invokevirtual 307	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   694: astore 14
    //   696: aload 10
    //   698: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   701: ifeq +13 -> 714
    //   704: aload 5
    //   706: iconst_1
    //   707: ldc_w 309
    //   710: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: return
    //   714: aload 15
    //   716: iconst_0
    //   717: invokestatic 315	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   720: astore 16
    //   722: aload 16
    //   724: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   727: ifeq +103 -> 830
    //   730: new 94	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   737: astore 16
    //   739: aload 16
    //   741: ldc_w 317
    //   744: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 16
    //   750: aload 15
    //   752: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload 16
    //   758: ldc_w 319
    //   761: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload 16
    //   767: aload 15
    //   769: invokestatic 61	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   772: invokevirtual 322	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload 5
    //   778: iconst_1
    //   779: aload 16
    //   781: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: aload 10
    //   789: aload 14
    //   791: ldc_w 324
    //   794: invokevirtual 307	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   797: astore 10
    //   799: aload 6
    //   801: invokeinterface 328 1 0
    //   806: aload_0
    //   807: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   810: aload 10
    //   812: invokeinterface 333 3 0
    //   817: invokeinterface 336 1 0
    //   822: pop
    //   823: iload_2
    //   824: iconst_1
    //   825: iadd
    //   826: istore_2
    //   827: goto -180 -> 647
    //   830: new 63	java/util/HashMap
    //   833: dup
    //   834: invokespecial 64	java/util/HashMap:<init>	()V
    //   837: astore 15
    //   839: aload 15
    //   841: ldc_w 338
    //   844: aload_0
    //   845: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   848: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   851: pop
    //   852: aload_0
    //   853: aload 11
    //   855: aload 16
    //   857: aload 12
    //   859: aload 7
    //   861: aload 15
    //   863: invokevirtual 340	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   866: astore 15
    //   868: aload 15
    //   870: ifnull +50 -> 920
    //   873: aload 10
    //   875: aload 14
    //   877: aload 15
    //   879: ldc_w 301
    //   882: ldc_w 303
    //   885: invokevirtual 307	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   888: invokevirtual 307	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   891: astore 10
    //   893: aload 6
    //   895: invokeinterface 328 1 0
    //   900: aload_0
    //   901: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   904: aload 10
    //   906: invokeinterface 333 3 0
    //   911: invokeinterface 336 1 0
    //   916: pop
    //   917: goto +7 -> 924
    //   920: iload_3
    //   921: iconst_1
    //   922: iadd
    //   923: istore_3
    //   924: goto -97 -> 827
    //   927: aload_0
    //   928: getfield 32	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   931: invokeinterface 277 1 0
    //   936: istore 4
    //   938: iload_2
    //   939: iload 4
    //   941: if_icmpne +86 -> 1027
    //   944: new 119	org/json/JSONObject
    //   947: dup
    //   948: aload 6
    //   950: aload_0
    //   951: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   954: ldc_w 342
    //   957: invokeinterface 299 3 0
    //   962: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   965: astore 7
    //   967: aload 7
    //   969: ldc_w 344
    //   972: iconst_1
    //   973: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   976: pop
    //   977: aload 6
    //   979: invokeinterface 328 1 0
    //   984: aload_0
    //   985: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   988: aload 7
    //   990: invokevirtual 348	org/json/JSONObject:toString	()Ljava/lang/String;
    //   993: invokeinterface 333 3 0
    //   998: invokeinterface 336 1 0
    //   1003: pop
    //   1004: aload 5
    //   1006: iconst_1
    //   1007: ldc_w 350
    //   1010: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1013: getstatic 220	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1016: aload_0
    //   1017: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1020: invokeinterface 266 2 0
    //   1025: pop
    //   1026: return
    //   1027: aload 5
    //   1029: astore 11
    //   1031: iload_3
    //   1032: ifle +77 -> 1109
    //   1035: new 94	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1042: astore 6
    //   1044: aload 6
    //   1046: ldc_w 352
    //   1049: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: pop
    //   1053: aload 6
    //   1055: iload_3
    //   1056: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload 6
    //   1062: ldc_w 354
    //   1065: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aload 6
    //   1071: aload_0
    //   1072: getfield 32	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1075: invokeinterface 277 1 0
    //   1080: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload 11
    //   1086: iconst_1
    //   1087: aload 6
    //   1089: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1092: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1095: getstatic 220	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1098: aload_0
    //   1099: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1102: invokeinterface 266 2 0
    //   1107: pop
    //   1108: return
    //   1109: new 94	java/lang/StringBuilder
    //   1112: dup
    //   1113: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1116: astore 10
    //   1118: aload 10
    //   1120: ldc_w 356
    //   1123: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: aload 10
    //   1129: iload_1
    //   1130: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1133: pop
    //   1134: new 358	java/net/URL
    //   1137: dup
    //   1138: aload 10
    //   1140: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1143: aload 9
    //   1145: aload 12
    //   1147: invokestatic 219	com/tencent/util/URLUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1150: invokespecial 359	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1153: invokevirtual 363	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1156: checkcast 365	java/net/HttpURLConnection
    //   1159: astore 10
    //   1161: aload 10
    //   1163: astore 9
    //   1165: aload 10
    //   1167: sipush 5000
    //   1170: invokevirtual 369	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1173: aload 10
    //   1175: astore 9
    //   1177: aload 10
    //   1179: sipush 30000
    //   1182: invokevirtual 372	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1185: aload 10
    //   1187: astore 9
    //   1189: aload 10
    //   1191: iconst_1
    //   1192: invokevirtual 376	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1195: aload 10
    //   1197: astore 9
    //   1199: aload 10
    //   1201: iconst_1
    //   1202: invokevirtual 379	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1205: aload 10
    //   1207: astore 9
    //   1209: aload 10
    //   1211: iconst_0
    //   1212: invokevirtual 382	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1215: aload 10
    //   1217: astore 9
    //   1219: aload 10
    //   1221: ldc_w 384
    //   1224: invokevirtual 387	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1227: aload 10
    //   1229: astore 9
    //   1231: aload 10
    //   1233: ldc 66
    //   1235: ldc_w 389
    //   1238: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1241: aload 10
    //   1243: astore 9
    //   1245: new 94	java/lang/StringBuilder
    //   1248: dup
    //   1249: ldc_w 394
    //   1252: invokespecial 395	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1255: astore 13
    //   1257: aload 10
    //   1259: astore 9
    //   1261: aload 13
    //   1263: aload 8
    //   1265: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: pop
    //   1269: aload 10
    //   1271: astore 9
    //   1273: aload 13
    //   1275: getstatic 400	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   1278: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload 10
    //   1284: astore 9
    //   1286: aload 13
    //   1288: aload 8
    //   1290: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: pop
    //   1294: aload 10
    //   1296: astore 9
    //   1298: aload 13
    //   1300: getstatic 405	android/os/Build:DEVICE	Ljava/lang/String;
    //   1303: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: aload 10
    //   1309: astore 9
    //   1311: aload 13
    //   1313: aload 8
    //   1315: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: pop
    //   1319: aload 10
    //   1321: astore 9
    //   1323: aload 13
    //   1325: getstatic 408	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   1328: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: aload 10
    //   1334: astore 9
    //   1336: aload 13
    //   1338: aload 8
    //   1340: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: aload 10
    //   1346: astore 9
    //   1348: aload 13
    //   1350: ldc_w 410
    //   1353: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: pop
    //   1357: aload 10
    //   1359: astore 9
    //   1361: aload 10
    //   1363: ldc_w 412
    //   1366: aload 13
    //   1368: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1374: aload 10
    //   1376: astore 9
    //   1378: aload 10
    //   1380: ldc_w 414
    //   1383: ldc_w 416
    //   1386: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1389: aload 10
    //   1391: astore 9
    //   1393: new 94	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1400: astore 8
    //   1402: aload 10
    //   1404: astore 9
    //   1406: aload 8
    //   1408: ldc_w 418
    //   1411: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: pop
    //   1415: aload 10
    //   1417: astore 9
    //   1419: aload 8
    //   1421: aload 12
    //   1423: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: pop
    //   1427: aload 10
    //   1429: astore 9
    //   1431: aload 8
    //   1433: ldc_w 420
    //   1436: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload 10
    //   1442: astore 9
    //   1444: aload 8
    //   1446: aload 7
    //   1448: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: pop
    //   1452: aload 10
    //   1454: astore 9
    //   1456: aload 10
    //   1458: ldc_w 422
    //   1461: aload 8
    //   1463: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1466: invokevirtual 392	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1469: aload 10
    //   1471: astore 9
    //   1473: new 424	java/io/DataOutputStream
    //   1476: dup
    //   1477: aload 10
    //   1479: invokevirtual 428	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1482: invokespecial 431	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1485: astore 7
    //   1487: aload 10
    //   1489: astore 9
    //   1491: new 433	java/lang/StringBuffer
    //   1494: dup
    //   1495: invokespecial 434	java/lang/StringBuffer:<init>	()V
    //   1498: astore 8
    //   1500: aload 10
    //   1502: astore 9
    //   1504: aload 8
    //   1506: ldc_w 436
    //   1509: invokevirtual 439	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1512: pop
    //   1513: aload 10
    //   1515: astore 9
    //   1517: aload 8
    //   1519: aload_0
    //   1520: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1523: invokevirtual 439	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1526: pop
    //   1527: aload 10
    //   1529: astore 9
    //   1531: aload 7
    //   1533: aload 8
    //   1535: invokevirtual 440	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1538: invokevirtual 444	java/lang/String:getBytes	()[B
    //   1541: invokevirtual 450	java/io/OutputStream:write	([B)V
    //   1544: aload 10
    //   1546: astore 9
    //   1548: aload 7
    //   1550: invokevirtual 453	java/io/OutputStream:flush	()V
    //   1553: aload 10
    //   1555: astore 9
    //   1557: aload 7
    //   1559: invokevirtual 456	java/io/OutputStream:close	()V
    //   1562: aload 10
    //   1564: astore 9
    //   1566: new 433	java/lang/StringBuffer
    //   1569: dup
    //   1570: invokespecial 434	java/lang/StringBuffer:<init>	()V
    //   1573: astore 8
    //   1575: aload 10
    //   1577: astore 9
    //   1579: new 458	java/io/BufferedReader
    //   1582: dup
    //   1583: new 460	java/io/InputStreamReader
    //   1586: dup
    //   1587: aload 10
    //   1589: invokevirtual 464	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1592: invokespecial 467	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1595: invokespecial 470	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1598: astore 7
    //   1600: aload 10
    //   1602: astore 9
    //   1604: aload 7
    //   1606: invokevirtual 473	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1609: astore 12
    //   1611: aload 12
    //   1613: ifnull +31 -> 1644
    //   1616: aload 10
    //   1618: astore 9
    //   1620: aload 8
    //   1622: aload 12
    //   1624: invokevirtual 439	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1627: pop
    //   1628: aload 10
    //   1630: astore 9
    //   1632: aload 8
    //   1634: ldc_w 475
    //   1637: invokevirtual 439	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1640: pop
    //   1641: goto -41 -> 1600
    //   1644: aload 10
    //   1646: astore 9
    //   1648: aload 8
    //   1650: invokevirtual 440	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1653: astore 8
    //   1655: aload 10
    //   1657: astore 9
    //   1659: aload 8
    //   1661: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1664: ifeq +16 -> 1680
    //   1667: aload 10
    //   1669: astore 9
    //   1671: aload 11
    //   1673: iconst_1
    //   1674: ldc_w 477
    //   1677: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1680: aload 10
    //   1682: astore 9
    //   1684: new 119	org/json/JSONObject
    //   1687: dup
    //   1688: aload 8
    //   1690: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1693: ldc 124
    //   1695: invokevirtual 128	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1698: istore_1
    //   1699: iload_1
    //   1700: ifne +158 -> 1858
    //   1703: aload 10
    //   1705: astore 9
    //   1707: new 119	org/json/JSONObject
    //   1710: dup
    //   1711: aload 6
    //   1713: aload_0
    //   1714: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1717: ldc_w 342
    //   1720: invokeinterface 299 3 0
    //   1725: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1728: astore 12
    //   1730: aload 10
    //   1732: astore 9
    //   1734: aload 12
    //   1736: ldc_w 344
    //   1739: iconst_0
    //   1740: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1743: pop
    //   1744: aload 10
    //   1746: astore 9
    //   1748: aload 6
    //   1750: invokeinterface 328 1 0
    //   1755: aload_0
    //   1756: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1759: aload 12
    //   1761: invokevirtual 348	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1764: invokeinterface 333 3 0
    //   1769: invokeinterface 336 1 0
    //   1774: pop
    //   1775: aload 10
    //   1777: astore 9
    //   1779: new 94	java/lang/StringBuilder
    //   1782: dup
    //   1783: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1786: astore 6
    //   1788: aload 10
    //   1790: astore 9
    //   1792: aload 6
    //   1794: ldc_w 479
    //   1797: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1800: pop
    //   1801: aload 10
    //   1803: astore 9
    //   1805: aload 6
    //   1807: aload_0
    //   1808: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1811: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: pop
    //   1815: aload 10
    //   1817: astore 9
    //   1819: aload 6
    //   1821: ldc_w 481
    //   1824: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: pop
    //   1828: aload 10
    //   1830: astore 9
    //   1832: aload 6
    //   1834: aload 8
    //   1836: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: pop
    //   1840: aload 10
    //   1842: astore 9
    //   1844: aload 11
    //   1846: iconst_1
    //   1847: aload 6
    //   1849: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1852: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1855: goto +155 -> 2010
    //   1858: aload 10
    //   1860: astore 9
    //   1862: new 119	org/json/JSONObject
    //   1865: dup
    //   1866: aload 6
    //   1868: aload_0
    //   1869: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1872: ldc_w 342
    //   1875: invokeinterface 299 3 0
    //   1880: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1883: astore 12
    //   1885: aload 10
    //   1887: astore 9
    //   1889: aload 12
    //   1891: ldc_w 344
    //   1894: iconst_2
    //   1895: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1898: pop
    //   1899: aload 10
    //   1901: astore 9
    //   1903: aload 6
    //   1905: invokeinterface 328 1 0
    //   1910: aload_0
    //   1911: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1914: aload 12
    //   1916: invokevirtual 348	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1919: invokeinterface 333 3 0
    //   1924: invokeinterface 336 1 0
    //   1929: pop
    //   1930: aload 10
    //   1932: astore 9
    //   1934: new 94	java/lang/StringBuilder
    //   1937: dup
    //   1938: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1941: astore 6
    //   1943: aload 10
    //   1945: astore 9
    //   1947: aload 6
    //   1949: ldc_w 483
    //   1952: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1955: pop
    //   1956: aload 10
    //   1958: astore 9
    //   1960: aload 6
    //   1962: aload_0
    //   1963: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1966: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1969: pop
    //   1970: aload 10
    //   1972: astore 9
    //   1974: aload 6
    //   1976: ldc_w 481
    //   1979: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: pop
    //   1983: aload 10
    //   1985: astore 9
    //   1987: aload 6
    //   1989: aload 8
    //   1991: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1994: pop
    //   1995: aload 10
    //   1997: astore 9
    //   1999: aload 11
    //   2001: iconst_1
    //   2002: aload 6
    //   2004: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2007: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2010: aload 10
    //   2012: astore 9
    //   2014: aload 7
    //   2016: invokevirtual 484	java/io/BufferedReader:close	()V
    //   2019: aload 10
    //   2021: ifnull +100 -> 2121
    //   2024: aload 10
    //   2026: astore 6
    //   2028: goto +88 -> 2116
    //   2031: astore 7
    //   2033: aload 10
    //   2035: astore 6
    //   2037: goto +21 -> 2058
    //   2040: astore 7
    //   2042: goto +13 -> 2055
    //   2045: astore 5
    //   2047: aconst_null
    //   2048: astore 9
    //   2050: goto +87 -> 2137
    //   2053: astore 7
    //   2055: aconst_null
    //   2056: astore 6
    //   2058: aload 6
    //   2060: astore 9
    //   2062: new 94	java/lang/StringBuilder
    //   2065: dup
    //   2066: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   2069: astore 8
    //   2071: aload 6
    //   2073: astore 9
    //   2075: aload 8
    //   2077: ldc_w 486
    //   2080: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2083: pop
    //   2084: aload 6
    //   2086: astore 9
    //   2088: aload 8
    //   2090: aload 7
    //   2092: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2095: pop
    //   2096: aload 6
    //   2098: astore 9
    //   2100: aload 5
    //   2102: iconst_2
    //   2103: aload 8
    //   2105: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2108: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2111: aload 6
    //   2113: ifnull +8 -> 2121
    //   2116: aload 6
    //   2118: invokevirtual 489	java/net/HttpURLConnection:disconnect	()V
    //   2121: getstatic 220	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2124: aload_0
    //   2125: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2128: invokeinterface 266 2 0
    //   2133: pop
    //   2134: return
    //   2135: astore 5
    //   2137: aload 9
    //   2139: ifnull +8 -> 2147
    //   2142: aload 9
    //   2144: invokevirtual 489	java/net/HttpURLConnection:disconnect	()V
    //   2147: getstatic 220	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2150: aload_0
    //   2151: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2154: invokeinterface 266 2 0
    //   2159: pop
    //   2160: aload 5
    //   2162: athrow
    //   2163: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2166: ifeq +45 -> 2211
    //   2169: new 94	java/lang/StringBuilder
    //   2172: dup
    //   2173: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   2176: astore 5
    //   2178: aload 5
    //   2180: ldc_w 491
    //   2183: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: pop
    //   2187: aload 5
    //   2189: aload_0
    //   2190: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2193: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2196: invokevirtual 322	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2199: pop
    //   2200: ldc 103
    //   2202: iconst_2
    //   2203: aload 5
    //   2205: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2208: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2211: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2212	0	this	UploadThread
    //   124	1576	1	i	int
    //   128	814	2	j	int
    //   122	934	3	k	int
    //   936	6	4	m	int
    //   8	1020	5	localObject1	Object
    //   2045	56	5	str1	String
    //   2135	26	5	localObject2	Object
    //   2176	28	5	localStringBuilder	StringBuilder
    //   212	1905	6	localObject3	Object
    //   92	1923	7	localObject4	Object
    //   2031	1	7	localException1	Exception
    //   2040	1	7	localException2	Exception
    //   2053	38	7	localException3	Exception
    //   2	2102	8	localObject5	Object
    //   33	2110	9	localObject6	Object
    //   588	1446	10	localObject7	Object
    //   265	1735	11	localObject8	Object
    //   66	1849	12	localObject9	Object
    //   629	738	13	localObject10	Object
    //   694	182	14	str2	String
    //   667	211	15	localObject11	Object
    //   720	136	16	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   1165	1173	2031	java/lang/Exception
    //   1177	1185	2031	java/lang/Exception
    //   1189	1195	2031	java/lang/Exception
    //   1199	1205	2031	java/lang/Exception
    //   1209	1215	2031	java/lang/Exception
    //   1219	1227	2031	java/lang/Exception
    //   1231	1241	2031	java/lang/Exception
    //   1245	1257	2031	java/lang/Exception
    //   1261	1269	2031	java/lang/Exception
    //   1273	1282	2031	java/lang/Exception
    //   1286	1294	2031	java/lang/Exception
    //   1298	1307	2031	java/lang/Exception
    //   1311	1319	2031	java/lang/Exception
    //   1323	1332	2031	java/lang/Exception
    //   1336	1344	2031	java/lang/Exception
    //   1348	1357	2031	java/lang/Exception
    //   1361	1374	2031	java/lang/Exception
    //   1378	1389	2031	java/lang/Exception
    //   1393	1402	2031	java/lang/Exception
    //   1406	1415	2031	java/lang/Exception
    //   1419	1427	2031	java/lang/Exception
    //   1431	1440	2031	java/lang/Exception
    //   1444	1452	2031	java/lang/Exception
    //   1456	1469	2031	java/lang/Exception
    //   1473	1487	2031	java/lang/Exception
    //   1491	1500	2031	java/lang/Exception
    //   1504	1513	2031	java/lang/Exception
    //   1517	1527	2031	java/lang/Exception
    //   1531	1544	2031	java/lang/Exception
    //   1548	1553	2031	java/lang/Exception
    //   1557	1562	2031	java/lang/Exception
    //   1566	1575	2031	java/lang/Exception
    //   1579	1600	2031	java/lang/Exception
    //   1604	1611	2031	java/lang/Exception
    //   1620	1628	2031	java/lang/Exception
    //   1632	1641	2031	java/lang/Exception
    //   1648	1655	2031	java/lang/Exception
    //   1659	1667	2031	java/lang/Exception
    //   1671	1680	2031	java/lang/Exception
    //   1684	1699	2031	java/lang/Exception
    //   1707	1730	2031	java/lang/Exception
    //   1734	1744	2031	java/lang/Exception
    //   1748	1775	2031	java/lang/Exception
    //   1779	1788	2031	java/lang/Exception
    //   1792	1801	2031	java/lang/Exception
    //   1805	1815	2031	java/lang/Exception
    //   1819	1828	2031	java/lang/Exception
    //   1832	1840	2031	java/lang/Exception
    //   1844	1855	2031	java/lang/Exception
    //   1862	1885	2031	java/lang/Exception
    //   1889	1899	2031	java/lang/Exception
    //   1903	1930	2031	java/lang/Exception
    //   1934	1943	2031	java/lang/Exception
    //   1947	1956	2031	java/lang/Exception
    //   1960	1970	2031	java/lang/Exception
    //   1974	1983	2031	java/lang/Exception
    //   1987	1995	2031	java/lang/Exception
    //   1999	2010	2031	java/lang/Exception
    //   2014	2019	2031	java/lang/Exception
    //   1004	1013	2040	java/lang/Exception
    //   1035	1095	2040	java/lang/Exception
    //   1109	1161	2040	java/lang/Exception
    //   927	938	2045	finally
    //   944	1004	2045	finally
    //   1004	1013	2045	finally
    //   1035	1095	2045	finally
    //   1109	1161	2045	finally
    //   927	938	2053	java/lang/Exception
    //   944	1004	2053	java/lang/Exception
    //   1165	1173	2135	finally
    //   1177	1185	2135	finally
    //   1189	1195	2135	finally
    //   1199	1205	2135	finally
    //   1209	1215	2135	finally
    //   1219	1227	2135	finally
    //   1231	1241	2135	finally
    //   1245	1257	2135	finally
    //   1261	1269	2135	finally
    //   1273	1282	2135	finally
    //   1286	1294	2135	finally
    //   1298	1307	2135	finally
    //   1311	1319	2135	finally
    //   1323	1332	2135	finally
    //   1336	1344	2135	finally
    //   1348	1357	2135	finally
    //   1361	1374	2135	finally
    //   1378	1389	2135	finally
    //   1393	1402	2135	finally
    //   1406	1415	2135	finally
    //   1419	1427	2135	finally
    //   1431	1440	2135	finally
    //   1444	1452	2135	finally
    //   1456	1469	2135	finally
    //   1473	1487	2135	finally
    //   1491	1500	2135	finally
    //   1504	1513	2135	finally
    //   1517	1527	2135	finally
    //   1531	1544	2135	finally
    //   1548	1553	2135	finally
    //   1557	1562	2135	finally
    //   1566	1575	2135	finally
    //   1579	1600	2135	finally
    //   1604	1611	2135	finally
    //   1620	1628	2135	finally
    //   1632	1641	2135	finally
    //   1648	1655	2135	finally
    //   1659	1667	2135	finally
    //   1671	1680	2135	finally
    //   1684	1699	2135	finally
    //   1707	1730	2135	finally
    //   1734	1744	2135	finally
    //   1748	1775	2135	finally
    //   1779	1788	2135	finally
    //   1792	1801	2135	finally
    //   1805	1815	2135	finally
    //   1819	1828	2135	finally
    //   1832	1840	2135	finally
    //   1844	1855	2135	finally
    //   1862	1885	2135	finally
    //   1889	1899	2135	finally
    //   1903	1930	2135	finally
    //   1934	1943	2135	finally
    //   1947	1956	2135	finally
    //   1960	1970	2135	finally
    //   1974	1983	2135	finally
    //   1987	1995	2135	finally
    //   1999	2010	2135	finally
    //   2014	2019	2135	finally
    //   2062	2071	2135	finally
    //   2075	2084	2135	finally
    //   2088	2096	2135	finally
    //   2100	2111	2135	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.UploadThread
 * JD-Core Version:    0.7.0.1
 */