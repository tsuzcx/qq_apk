package com.tencent.mobileqq.vashealth;

import android.text.TextUtils;
import apvb;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import nam;
import org.json.JSONObject;

class HealthBusinessPlugin$UploadThread
  extends Thread
{
  String jdField_a_of_type_JavaLangString;
  List<String> jdField_a_of_type_JavaUtilList;
  WeakReference<BaseActivity> jdField_a_of_type_MqqUtilWeakReference;
  public boolean a;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  String c;
  String d;
  
  public HealthBusinessPlugin$UploadThread(BaseActivity paramBaseActivity, List<String> paramList, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramString1);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramList);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramBoolean;
    this.jdField_b_of_type_Boolean = paramString3;
    this.c = paramString4;
    Object localObject;
    this.d = localObject;
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (apvb.a(paramString2))
    {
      localHashMap1 = new HashMap();
      localHashMap1.put("Connection", "keep-alive");
      localHashMap1.put("Referer", "c.yundong.qq.com");
      localHashMap2 = new HashMap();
      localHashMap2.put("picstream", paramString2);
      if (paramMap != null) {
        break label200;
      }
    }
    label200:
    for (paramString2 = new HashMap();; paramString2 = paramMap)
    {
      paramString1 = nam.a(paramString1, paramString3, paramString4, paramString2, localHashMap2, localHashMap1);
      if (QLog.isColorLevel()) {
        QLog.i("HealthBusinessPlugin", 2, "upload result:" + paramString1);
      }
      if (TextUtils.isEmpty(paramString1)) {}
      for (;;)
      {
        return null;
        try
        {
          paramString1 = new JSONObject(paramString1);
          if (paramString1.getInt("code") == 0)
          {
            paramString1 = URLDecoder.decode(paramString1.getJSONObject("data").getString("picUrl"), "utf-8");
            return paramString1;
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("HealthBusinessPlugin", 2, "parse json Err:" + paramString1);
            }
            paramString1 = null;
          }
        }
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   4: ifnonnull +67 -> 71
    //   7: aconst_null
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +21 -> 33
    //   15: aload 4
    //   17: invokevirtual 157	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +56 -> 86
    //   33: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +34 -> 70
    //   39: ldc 90
    //   41: iconst_2
    //   42: new 92	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   49: ldc 159
    //   51: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: return
    //   71: aload_0
    //   72: getfield 37	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   75: invokevirtual 168	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   78: checkcast 153	com/tencent/mobileqq/app/BaseActivity
    //   81: astore 4
    //   83: goto -73 -> 10
    //   86: aload 4
    //   88: invokevirtual 157	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   91: invokevirtual 173	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   94: astore 8
    //   96: aload 4
    //   98: invokevirtual 157	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   101: iconst_2
    //   102: invokevirtual 177	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   105: checkcast 179	mqq/manager/TicketManager
    //   108: aload 8
    //   110: invokeinterface 182 2 0
    //   115: astore 9
    //   117: aload 9
    //   119: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifeq +18 -> 140
    //   125: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -58 -> 70
    //   131: ldc 90
    //   133: iconst_2
    //   134: ldc 184
    //   136: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: return
    //   140: sipush 5381
    //   143: istore_1
    //   144: iconst_0
    //   145: istore_2
    //   146: aload 9
    //   148: invokevirtual 190	java/lang/String:length	()I
    //   151: istore_3
    //   152: iload_2
    //   153: iload_3
    //   154: if_icmpge +23 -> 177
    //   157: iload_1
    //   158: iload_1
    //   159: iconst_5
    //   160: ishl
    //   161: aload 9
    //   163: iload_2
    //   164: invokevirtual 194	java/lang/String:charAt	(I)C
    //   167: iadd
    //   168: iadd
    //   169: istore_1
    //   170: iload_2
    //   171: iconst_1
    //   172: iadd
    //   173: istore_2
    //   174: goto -22 -> 152
    //   177: iload_1
    //   178: ldc 195
    //   180: iand
    //   181: istore_3
    //   182: ldc 90
    //   184: iconst_1
    //   185: new 92	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   192: ldc 197
    //   194: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload_3
    //   198: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_0
    //   208: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_Boolean	Z
    //   211: ifeq +367 -> 578
    //   214: new 92	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   221: ldc 202
    //   223: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: iload_3
    //   227: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore 4
    //   235: aload 4
    //   237: ldc 204
    //   239: aload 8
    //   241: invokestatic 209	bfng:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   244: astore 4
    //   246: aload_0
    //   247: getfield 20	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   250: getfield 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:e	Z
    //   253: ifeq +13 -> 266
    //   256: aload 4
    //   258: ldc 216
    //   260: ldc 218
    //   262: invokevirtual 221	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   265: pop
    //   266: aload_0
    //   267: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_Boolean	Z
    //   270: ifne +333 -> 603
    //   273: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   276: aload_0
    //   277: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   280: invokeinterface 228 2 0
    //   285: ifne +16 -> 301
    //   288: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   291: aload_0
    //   292: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   295: invokeinterface 231 2 0
    //   300: pop
    //   301: new 186	java/lang/String
    //   304: dup
    //   305: invokespecial 232	java/lang/String:<init>	()V
    //   308: pop
    //   309: aload_0
    //   310: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   313: iconst_0
    //   314: invokeinterface 235 2 0
    //   319: checkcast 186	java/lang/String
    //   322: astore 7
    //   324: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq +50 -> 377
    //   330: ldc 90
    //   332: iconst_2
    //   333: new 92	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   340: ldc 237
    //   342: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_0
    //   346: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   349: iconst_0
    //   350: invokeinterface 235 2 0
    //   355: checkcast 186	java/lang/String
    //   358: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 239
    //   363: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 7
    //   368: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload 7
    //   379: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   382: ifne -312 -> 70
    //   385: new 60	java/util/HashMap
    //   388: dup
    //   389: invokespecial 61	java/util/HashMap:<init>	()V
    //   392: astore 6
    //   394: aload 6
    //   396: ldc 241
    //   398: aload_0
    //   399: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   402: invokevirtual 242	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   405: pop
    //   406: new 244	android/os/Bundle
    //   409: dup
    //   410: invokespecial 245	android/os/Bundle:<init>	()V
    //   413: astore 5
    //   415: aload 5
    //   417: ldc 247
    //   419: aload_0
    //   420: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:c	Ljava/lang/String;
    //   423: invokevirtual 251	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: aload 5
    //   428: ldc 253
    //   430: aload_0
    //   431: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   434: invokevirtual 251	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload 5
    //   439: ldc 255
    //   441: aload 7
    //   443: invokevirtual 251	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload 5
    //   448: ldc_w 257
    //   451: new 259	java/io/File
    //   454: dup
    //   455: aload 7
    //   457: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
    //   460: invokevirtual 263	java/io/File:getName	()Ljava/lang/String;
    //   463: invokevirtual 251	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload_0
    //   467: getfield 20	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   470: aload 4
    //   472: aload 7
    //   474: aload 8
    //   476: aload 9
    //   478: aload 6
    //   480: aload 5
    //   482: aload_0
    //   483: invokevirtual 266	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Landroid/os/Bundle;Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread;)V
    //   486: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   489: aload_0
    //   490: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   493: invokeinterface 228 2 0
    //   498: ifeq +16 -> 514
    //   501: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   504: aload_0
    //   505: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   508: invokeinterface 269 2 0
    //   513: pop
    //   514: getstatic 272	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   517: aload_0
    //   518: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   521: invokevirtual 275	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   524: ifnull +14 -> 538
    //   527: getstatic 272	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   530: aload_0
    //   531: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   534: invokevirtual 277	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   537: pop
    //   538: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq -471 -> 70
    //   544: ldc 90
    //   546: iconst_2
    //   547: new 92	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   554: ldc_w 279
    //   557: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   563: invokeinterface 282 1 0
    //   568: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   571: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: return
    //   578: new 92	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 284
    //   588: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload_3
    //   592: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   595: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: astore 4
    //   600: goto -365 -> 235
    //   603: aload_0
    //   604: getfield 37	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   607: invokevirtual 168	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   610: checkcast 153	com/tencent/mobileqq/app/BaseActivity
    //   613: new 92	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   620: aload 8
    //   622: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc_w 286
    //   628: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: iconst_0
    //   635: invokevirtual 290	com/tencent/mobileqq/app/BaseActivity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   638: astore 6
    //   640: aload_0
    //   641: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   644: invokeinterface 294 1 0
    //   649: astore 5
    //   651: iconst_0
    //   652: istore_2
    //   653: iconst_0
    //   654: istore_1
    //   655: aload 5
    //   657: invokeinterface 299 1 0
    //   662: ifeq +257 -> 919
    //   665: aload 5
    //   667: invokeinterface 302 1 0
    //   672: checkcast 186	java/lang/String
    //   675: astore 12
    //   677: aload 6
    //   679: aload_0
    //   680: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   683: aconst_null
    //   684: invokeinterface 306 3 0
    //   689: astore 10
    //   691: aload 12
    //   693: ldc_w 308
    //   696: ldc_w 310
    //   699: invokevirtual 314	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   702: astore 7
    //   704: aload 10
    //   706: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   709: ifeq +13 -> 722
    //   712: ldc 90
    //   714: iconst_1
    //   715: ldc_w 316
    //   718: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: return
    //   722: aload 12
    //   724: iconst_0
    //   725: invokestatic 323	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   728: astore 11
    //   730: aload 11
    //   732: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   735: ifeq +87 -> 822
    //   738: ldc 90
    //   740: iconst_1
    //   741: new 92	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   748: ldc_w 325
    //   751: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload 12
    //   756: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: ldc_w 327
    //   762: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: aload 12
    //   767: invokestatic 58	apvb:a	(Ljava/lang/String;)Z
    //   770: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   773: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   779: aload 10
    //   781: aload 7
    //   783: ldc_w 329
    //   786: invokevirtual 314	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   789: astore 7
    //   791: aload 6
    //   793: invokeinterface 333 1 0
    //   798: aload_0
    //   799: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   802: aload 7
    //   804: invokeinterface 338 3 0
    //   809: invokeinterface 341 1 0
    //   814: pop
    //   815: iload_1
    //   816: iconst_1
    //   817: iadd
    //   818: istore_1
    //   819: goto -164 -> 655
    //   822: new 60	java/util/HashMap
    //   825: dup
    //   826: invokespecial 61	java/util/HashMap:<init>	()V
    //   829: astore 12
    //   831: aload 12
    //   833: ldc_w 343
    //   836: aload_0
    //   837: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   840: invokevirtual 242	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   843: pop
    //   844: aload_0
    //   845: aload 4
    //   847: aload 11
    //   849: aload 8
    //   851: aload 9
    //   853: aload 12
    //   855: invokevirtual 345	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   858: astore 11
    //   860: aload 11
    //   862: ifnull +50 -> 912
    //   865: aload 10
    //   867: aload 7
    //   869: aload 11
    //   871: ldc_w 308
    //   874: ldc_w 310
    //   877: invokevirtual 314	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   880: invokevirtual 314	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   883: astore 7
    //   885: aload 6
    //   887: invokeinterface 333 1 0
    //   892: aload_0
    //   893: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   896: aload 7
    //   898: invokeinterface 338 3 0
    //   903: invokeinterface 341 1 0
    //   908: pop
    //   909: goto -254 -> 655
    //   912: iload_2
    //   913: iconst_1
    //   914: iadd
    //   915: istore_2
    //   916: goto -261 -> 655
    //   919: aconst_null
    //   920: astore 5
    //   922: aconst_null
    //   923: astore 7
    //   925: aload 5
    //   927: astore 4
    //   929: iload_1
    //   930: aload_0
    //   931: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   934: invokeinterface 282 1 0
    //   939: if_icmpne +129 -> 1068
    //   942: aload 5
    //   944: astore 4
    //   946: new 115	org/json/JSONObject
    //   949: dup
    //   950: aload 6
    //   952: aload_0
    //   953: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   956: ldc_w 347
    //   959: invokeinterface 306 3 0
    //   964: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   967: astore 8
    //   969: aload 5
    //   971: astore 4
    //   973: aload 8
    //   975: ldc_w 349
    //   978: iconst_1
    //   979: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   982: pop
    //   983: aload 5
    //   985: astore 4
    //   987: aload 6
    //   989: invokeinterface 333 1 0
    //   994: aload_0
    //   995: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   998: aload 8
    //   1000: invokevirtual 353	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1003: invokeinterface 338 3 0
    //   1008: invokeinterface 341 1 0
    //   1013: pop
    //   1014: aload 5
    //   1016: astore 4
    //   1018: ldc 90
    //   1020: iconst_1
    //   1021: ldc_w 355
    //   1024: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1027: iconst_0
    //   1028: ifeq +11 -> 1039
    //   1031: new 357	java/lang/NullPointerException
    //   1034: dup
    //   1035: invokespecial 358	java/lang/NullPointerException:<init>	()V
    //   1038: athrow
    //   1039: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1042: aload_0
    //   1043: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1046: invokeinterface 228 2 0
    //   1051: ifeq -981 -> 70
    //   1054: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1057: aload_0
    //   1058: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1061: invokeinterface 269 2 0
    //   1066: pop
    //   1067: return
    //   1068: iload_2
    //   1069: ifle +92 -> 1161
    //   1072: aload 5
    //   1074: astore 4
    //   1076: ldc 90
    //   1078: iconst_1
    //   1079: new 92	java/lang/StringBuilder
    //   1082: dup
    //   1083: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1086: ldc_w 360
    //   1089: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: iload_2
    //   1093: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1096: ldc_w 362
    //   1099: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: aload_0
    //   1103: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1106: invokeinterface 282 1 0
    //   1111: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1120: iconst_0
    //   1121: ifeq +11 -> 1132
    //   1124: new 357	java/lang/NullPointerException
    //   1127: dup
    //   1128: invokespecial 358	java/lang/NullPointerException:<init>	()V
    //   1131: athrow
    //   1132: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1135: aload_0
    //   1136: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1139: invokeinterface 228 2 0
    //   1144: ifeq -1074 -> 70
    //   1147: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1150: aload_0
    //   1151: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1154: invokeinterface 269 2 0
    //   1159: pop
    //   1160: return
    //   1161: aload 5
    //   1163: astore 4
    //   1165: new 92	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1172: ldc_w 364
    //   1175: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: iload_3
    //   1179: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1182: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: astore 10
    //   1187: aload 5
    //   1189: astore 4
    //   1191: aload_0
    //   1192: getfield 20	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   1195: getfield 214	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:e	Z
    //   1198: ifeq +17 -> 1215
    //   1201: aload 5
    //   1203: astore 4
    //   1205: aload 10
    //   1207: ldc 216
    //   1209: ldc 218
    //   1211: invokevirtual 221	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1214: pop
    //   1215: aload 5
    //   1217: astore 4
    //   1219: new 366	java/net/URL
    //   1222: dup
    //   1223: aload 10
    //   1225: ldc 204
    //   1227: aload 8
    //   1229: invokestatic 209	bfng:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1232: invokespecial 367	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1235: invokevirtual 371	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1238: checkcast 373	java/net/HttpURLConnection
    //   1241: astore 5
    //   1243: aload 5
    //   1245: sipush 5000
    //   1248: invokevirtual 377	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1251: aload 5
    //   1253: sipush 30000
    //   1256: invokevirtual 380	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1259: aload 5
    //   1261: iconst_1
    //   1262: invokevirtual 384	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1265: aload 5
    //   1267: iconst_1
    //   1268: invokevirtual 387	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1271: aload 5
    //   1273: iconst_0
    //   1274: invokevirtual 390	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1277: aload 5
    //   1279: ldc_w 392
    //   1282: invokevirtual 395	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1285: aload 5
    //   1287: ldc 63
    //   1289: ldc_w 397
    //   1292: invokevirtual 400	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1295: aload 5
    //   1297: ldc_w 402
    //   1300: new 92	java/lang/StringBuilder
    //   1303: dup
    //   1304: ldc_w 404
    //   1307: invokespecial 405	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1310: ldc_w 407
    //   1313: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: getstatic 412	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   1319: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: ldc_w 407
    //   1325: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: getstatic 417	android/os/Build:DEVICE	Ljava/lang/String;
    //   1331: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: ldc_w 407
    //   1337: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: getstatic 420	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   1343: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: ldc_w 407
    //   1349: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: ldc_w 422
    //   1355: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1361: invokevirtual 400	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1364: aload 5
    //   1366: ldc_w 424
    //   1369: ldc_w 426
    //   1372: invokevirtual 400	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: aload 5
    //   1377: ldc_w 428
    //   1380: new 92	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1387: ldc_w 430
    //   1390: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: aload 8
    //   1395: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: ldc_w 432
    //   1401: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: aload 9
    //   1406: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1412: invokevirtual 400	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1415: new 434	java/io/DataOutputStream
    //   1418: dup
    //   1419: aload 5
    //   1421: invokevirtual 438	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1424: invokespecial 441	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1427: astore 4
    //   1429: new 443	java/lang/StringBuffer
    //   1432: dup
    //   1433: invokespecial 444	java/lang/StringBuffer:<init>	()V
    //   1436: astore 7
    //   1438: aload 7
    //   1440: ldc_w 446
    //   1443: invokevirtual 449	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1446: pop
    //   1447: aload 7
    //   1449: aload_0
    //   1450: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1453: invokevirtual 449	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1456: pop
    //   1457: aload 4
    //   1459: aload 7
    //   1461: invokevirtual 450	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1464: invokevirtual 454	java/lang/String:getBytes	()[B
    //   1467: invokevirtual 460	java/io/OutputStream:write	([B)V
    //   1470: aload 4
    //   1472: invokevirtual 463	java/io/OutputStream:flush	()V
    //   1475: aload 4
    //   1477: invokevirtual 466	java/io/OutputStream:close	()V
    //   1480: new 443	java/lang/StringBuffer
    //   1483: dup
    //   1484: invokespecial 444	java/lang/StringBuffer:<init>	()V
    //   1487: astore 7
    //   1489: new 468	java/io/BufferedReader
    //   1492: dup
    //   1493: new 470	java/io/InputStreamReader
    //   1496: dup
    //   1497: aload 5
    //   1499: invokevirtual 474	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1502: invokespecial 477	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1505: invokespecial 480	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1508: astore 4
    //   1510: aload 4
    //   1512: invokevirtual 483	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1515: astore 8
    //   1517: aload 8
    //   1519: ifnull +92 -> 1611
    //   1522: aload 7
    //   1524: aload 8
    //   1526: invokevirtual 449	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1529: ldc_w 485
    //   1532: invokevirtual 449	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1535: pop
    //   1536: goto -26 -> 1510
    //   1539: astore 6
    //   1541: aload 5
    //   1543: astore 4
    //   1545: ldc 90
    //   1547: iconst_2
    //   1548: new 92	java/lang/StringBuilder
    //   1551: dup
    //   1552: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1555: ldc_w 487
    //   1558: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: aload 6
    //   1563: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1566: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1569: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1572: aload 5
    //   1574: ifnull +8 -> 1582
    //   1577: aload 5
    //   1579: invokevirtual 490	java/net/HttpURLConnection:disconnect	()V
    //   1582: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1585: aload_0
    //   1586: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1589: invokeinterface 228 2 0
    //   1594: ifeq -1524 -> 70
    //   1597: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1600: aload_0
    //   1601: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1604: invokeinterface 269 2 0
    //   1609: pop
    //   1610: return
    //   1611: aload 7
    //   1613: invokevirtual 450	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1616: astore 7
    //   1618: aload 7
    //   1620: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1623: ifeq +12 -> 1635
    //   1626: ldc 90
    //   1628: iconst_1
    //   1629: ldc_w 492
    //   1632: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1635: new 115	org/json/JSONObject
    //   1638: dup
    //   1639: aload 7
    //   1641: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1644: ldc 120
    //   1646: invokevirtual 124	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1649: ifne +147 -> 1796
    //   1652: new 115	org/json/JSONObject
    //   1655: dup
    //   1656: aload 6
    //   1658: aload_0
    //   1659: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1662: ldc_w 347
    //   1665: invokeinterface 306 3 0
    //   1670: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1673: astore 8
    //   1675: aload 8
    //   1677: ldc_w 349
    //   1680: iconst_0
    //   1681: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1684: pop
    //   1685: aload 6
    //   1687: invokeinterface 333 1 0
    //   1692: aload_0
    //   1693: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1696: aload 8
    //   1698: invokevirtual 353	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1701: invokeinterface 338 3 0
    //   1706: invokeinterface 341 1 0
    //   1711: pop
    //   1712: ldc 90
    //   1714: iconst_1
    //   1715: new 92	java/lang/StringBuilder
    //   1718: dup
    //   1719: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1722: ldc_w 494
    //   1725: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1728: aload_0
    //   1729: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1732: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: ldc_w 496
    //   1738: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1741: aload 7
    //   1743: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1749: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1752: aload 4
    //   1754: invokevirtual 497	java/io/BufferedReader:close	()V
    //   1757: aload 5
    //   1759: ifnull +8 -> 1767
    //   1762: aload 5
    //   1764: invokevirtual 490	java/net/HttpURLConnection:disconnect	()V
    //   1767: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1770: aload_0
    //   1771: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1774: invokeinterface 228 2 0
    //   1779: ifeq -1709 -> 70
    //   1782: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1785: aload_0
    //   1786: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1789: invokeinterface 269 2 0
    //   1794: pop
    //   1795: return
    //   1796: new 115	org/json/JSONObject
    //   1799: dup
    //   1800: aload 6
    //   1802: aload_0
    //   1803: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1806: ldc_w 347
    //   1809: invokeinterface 306 3 0
    //   1814: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1817: astore 8
    //   1819: aload 8
    //   1821: ldc_w 349
    //   1824: iconst_2
    //   1825: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1828: pop
    //   1829: aload 6
    //   1831: invokeinterface 333 1 0
    //   1836: aload_0
    //   1837: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1840: aload 8
    //   1842: invokevirtual 353	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1845: invokeinterface 338 3 0
    //   1850: invokeinterface 341 1 0
    //   1855: pop
    //   1856: ldc 90
    //   1858: iconst_1
    //   1859: new 92	java/lang/StringBuilder
    //   1862: dup
    //   1863: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1866: ldc_w 499
    //   1869: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1872: aload_0
    //   1873: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1876: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: ldc_w 496
    //   1882: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1885: aload 7
    //   1887: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1893: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1896: goto -144 -> 1752
    //   1899: astore 4
    //   1901: aload 5
    //   1903: astore 6
    //   1905: aload 4
    //   1907: astore 5
    //   1909: aload 6
    //   1911: ifnull +8 -> 1919
    //   1914: aload 6
    //   1916: invokevirtual 490	java/net/HttpURLConnection:disconnect	()V
    //   1919: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1922: aload_0
    //   1923: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1926: invokeinterface 228 2 0
    //   1931: ifeq +16 -> 1947
    //   1934: getstatic 222	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1937: aload_0
    //   1938: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1941: invokeinterface 269 2 0
    //   1946: pop
    //   1947: aload 5
    //   1949: athrow
    //   1950: astore 5
    //   1952: aload 4
    //   1954: astore 6
    //   1956: goto -47 -> 1909
    //   1959: astore 6
    //   1961: aload 7
    //   1963: astore 5
    //   1965: goto -424 -> 1541
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1968	0	this	UploadThread
    //   143	797	1	i	int
    //   145	948	2	j	int
    //   151	1028	3	k	int
    //   8	1745	4	localObject1	Object
    //   1899	54	4	localObject2	Object
    //   413	1535	5	localObject3	Object
    //   1950	1	5	localObject4	Object
    //   1963	1	5	localObject5	Object
    //   392	596	6	localObject6	Object
    //   1539	291	6	localException1	Exception
    //   1903	52	6	localObject7	Object
    //   1959	1	6	localException2	Exception
    //   322	1640	7	localObject8	Object
    //   94	1747	8	localObject9	Object
    //   115	1290	9	str1	String
    //   689	535	10	str2	String
    //   728	142	11	str3	String
    //   675	179	12	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   1243	1510	1539	java/lang/Exception
    //   1510	1517	1539	java/lang/Exception
    //   1522	1536	1539	java/lang/Exception
    //   1611	1635	1539	java/lang/Exception
    //   1635	1752	1539	java/lang/Exception
    //   1752	1757	1539	java/lang/Exception
    //   1796	1896	1539	java/lang/Exception
    //   1243	1510	1899	finally
    //   1510	1517	1899	finally
    //   1522	1536	1899	finally
    //   1611	1635	1899	finally
    //   1635	1752	1899	finally
    //   1752	1757	1899	finally
    //   1796	1896	1899	finally
    //   929	942	1950	finally
    //   946	969	1950	finally
    //   973	983	1950	finally
    //   987	1014	1950	finally
    //   1018	1027	1950	finally
    //   1076	1120	1950	finally
    //   1165	1187	1950	finally
    //   1191	1201	1950	finally
    //   1205	1215	1950	finally
    //   1219	1243	1950	finally
    //   1545	1572	1950	finally
    //   929	942	1959	java/lang/Exception
    //   946	969	1959	java/lang/Exception
    //   973	983	1959	java/lang/Exception
    //   987	1014	1959	java/lang/Exception
    //   1018	1027	1959	java/lang/Exception
    //   1076	1120	1959	java/lang/Exception
    //   1165	1187	1959	java/lang/Exception
    //   1191	1201	1959	java/lang/Exception
    //   1205	1215	1959	java/lang/Exception
    //   1219	1243	1959	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.UploadThread
 * JD-Core Version:    0.7.0.1
 */