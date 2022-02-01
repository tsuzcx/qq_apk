package com.tencent.mobileqq.vashealth;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
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
    if (FileUtil.isFileExists(paramString2))
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
      paramString1 = HttpUtil.uploadImage(paramString1, paramString3, paramString4, paramString2, localHashMap2, localHashMap1);
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
    //   17: invokevirtual 159	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +56 -> 86
    //   33: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +34 -> 70
    //   39: ldc 92
    //   41: iconst_2
    //   42: new 94	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   49: ldc 161
    //   51: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: return
    //   71: aload_0
    //   72: getfield 37	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   75: invokevirtual 170	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   78: checkcast 155	com/tencent/mobileqq/app/BaseActivity
    //   81: astore 4
    //   83: goto -73 -> 10
    //   86: aload 4
    //   88: invokevirtual 159	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   91: invokevirtual 175	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   94: astore 8
    //   96: aload 4
    //   98: invokevirtual 159	com/tencent/mobileqq/app/BaseActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   101: iconst_2
    //   102: invokevirtual 179	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   105: checkcast 181	mqq/manager/TicketManager
    //   108: aload 8
    //   110: invokeinterface 184 2 0
    //   115: astore 9
    //   117: aload 9
    //   119: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifeq +18 -> 140
    //   125: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -58 -> 70
    //   131: ldc 92
    //   133: iconst_2
    //   134: ldc 186
    //   136: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: return
    //   140: sipush 5381
    //   143: istore_2
    //   144: iconst_0
    //   145: istore_1
    //   146: aload 9
    //   148: invokevirtual 192	java/lang/String:length	()I
    //   151: istore_3
    //   152: iload_1
    //   153: iload_3
    //   154: if_icmpge +23 -> 177
    //   157: iload_2
    //   158: iload_2
    //   159: iconst_5
    //   160: ishl
    //   161: aload 9
    //   163: iload_1
    //   164: invokevirtual 196	java/lang/String:charAt	(I)C
    //   167: iadd
    //   168: iadd
    //   169: istore_2
    //   170: iload_1
    //   171: iconst_1
    //   172: iadd
    //   173: istore_1
    //   174: goto -22 -> 152
    //   177: iload_2
    //   178: ldc 197
    //   180: iand
    //   181: istore_3
    //   182: ldc 92
    //   184: iconst_1
    //   185: new 94	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   192: ldc 199
    //   194: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload_3
    //   198: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 109	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_0
    //   208: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_Boolean	Z
    //   211: ifeq +368 -> 579
    //   214: new 94	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   221: ldc 204
    //   223: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: iload_3
    //   227: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore 4
    //   235: aload 4
    //   237: ldc 206
    //   239: aload 8
    //   241: invokestatic 211	bjnd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   244: astore 4
    //   246: aload_0
    //   247: getfield 20	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   250: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:e	Z
    //   253: ifeq +13 -> 266
    //   256: aload 4
    //   258: ldc 218
    //   260: ldc 220
    //   262: invokevirtual 223	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   265: pop
    //   266: aload_0
    //   267: getfield 43	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_Boolean	Z
    //   270: ifne +334 -> 604
    //   273: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   276: aload_0
    //   277: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   280: invokeinterface 230 2 0
    //   285: ifne +16 -> 301
    //   288: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   291: aload_0
    //   292: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   295: invokeinterface 233 2 0
    //   300: pop
    //   301: new 188	java/lang/String
    //   304: dup
    //   305: invokespecial 234	java/lang/String:<init>	()V
    //   308: pop
    //   309: aload_0
    //   310: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   313: iconst_0
    //   314: invokeinterface 237 2 0
    //   319: checkcast 188	java/lang/String
    //   322: astore 5
    //   324: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq +50 -> 377
    //   330: ldc 92
    //   332: iconst_2
    //   333: new 94	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   340: ldc 239
    //   342: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_0
    //   346: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   349: iconst_0
    //   350: invokeinterface 237 2 0
    //   355: checkcast 188	java/lang/String
    //   358: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 241
    //   363: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 5
    //   368: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload 5
    //   379: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   382: ifne -312 -> 70
    //   385: new 61	java/util/HashMap
    //   388: dup
    //   389: invokespecial 62	java/util/HashMap:<init>	()V
    //   392: astore 6
    //   394: aload 6
    //   396: ldc 243
    //   398: aload_0
    //   399: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   402: invokevirtual 244	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   405: pop
    //   406: new 246	android/os/Bundle
    //   409: dup
    //   410: invokespecial 247	android/os/Bundle:<init>	()V
    //   413: astore 7
    //   415: aload 7
    //   417: ldc 249
    //   419: aload_0
    //   420: getfield 45	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:c	Ljava/lang/String;
    //   423: invokevirtual 253	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: aload 7
    //   428: ldc 255
    //   430: aload_0
    //   431: getfield 47	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:d	Ljava/lang/String;
    //   434: invokevirtual 253	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload 7
    //   439: ldc_w 257
    //   442: aload 5
    //   444: invokevirtual 253	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 7
    //   449: ldc_w 259
    //   452: new 261	java/io/File
    //   455: dup
    //   456: aload 5
    //   458: invokespecial 262	java/io/File:<init>	(Ljava/lang/String;)V
    //   461: invokevirtual 265	java/io/File:getName	()Ljava/lang/String;
    //   464: invokevirtual 253	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload_0
    //   468: getfield 20	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   471: aload 4
    //   473: aload 5
    //   475: aload 8
    //   477: aload 9
    //   479: aload 6
    //   481: aload 7
    //   483: aload_0
    //   484: invokevirtual 268	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Landroid/os/Bundle;Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread;)V
    //   487: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   490: aload_0
    //   491: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   494: invokeinterface 230 2 0
    //   499: ifeq +16 -> 515
    //   502: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   505: aload_0
    //   506: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   509: invokeinterface 271 2 0
    //   514: pop
    //   515: getstatic 274	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   518: aload_0
    //   519: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   522: invokevirtual 277	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   525: ifnull +14 -> 539
    //   528: getstatic 274	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:c	Ljava/util/HashMap;
    //   531: aload_0
    //   532: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   535: invokevirtual 279	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   538: pop
    //   539: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq -472 -> 70
    //   545: ldc 92
    //   547: iconst_2
    //   548: new 94	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 281
    //   558: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   564: invokeinterface 284 1 0
    //   569: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: return
    //   579: new 94	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 286
    //   589: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: iload_3
    //   593: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: astore 4
    //   601: goto -366 -> 235
    //   604: aload_0
    //   605: getfield 37	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   608: invokevirtual 170	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   611: checkcast 155	com/tencent/mobileqq/app/BaseActivity
    //   614: new 94	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   621: aload 8
    //   623: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc_w 288
    //   629: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: iconst_0
    //   636: invokevirtual 292	com/tencent/mobileqq/app/BaseActivity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   639: astore 6
    //   641: aload_0
    //   642: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   645: invokeinterface 296 1 0
    //   650: astore 5
    //   652: iconst_0
    //   653: istore_2
    //   654: iconst_0
    //   655: istore_1
    //   656: aload 5
    //   658: invokeinterface 301 1 0
    //   663: ifeq +257 -> 920
    //   666: aload 5
    //   668: invokeinterface 304 1 0
    //   673: checkcast 188	java/lang/String
    //   676: astore 12
    //   678: aload 6
    //   680: aload_0
    //   681: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   684: aconst_null
    //   685: invokeinterface 308 3 0
    //   690: astore 10
    //   692: aload 12
    //   694: ldc_w 310
    //   697: ldc_w 312
    //   700: invokevirtual 316	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   703: astore 7
    //   705: aload 10
    //   707: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   710: ifeq +13 -> 723
    //   713: ldc 92
    //   715: iconst_1
    //   716: ldc_w 318
    //   719: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: return
    //   723: aload 12
    //   725: iconst_0
    //   726: invokestatic 325	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   729: astore 11
    //   731: aload 11
    //   733: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   736: ifeq +87 -> 823
    //   739: ldc 92
    //   741: iconst_1
    //   742: new 94	java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   749: ldc_w 327
    //   752: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: aload 12
    //   757: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: ldc_w 329
    //   763: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: aload 12
    //   768: invokestatic 59	com/tencent/mobileqq/filemanager/util/FileUtil:isFileExists	(Ljava/lang/String;)Z
    //   771: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   774: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   780: aload 10
    //   782: aload 7
    //   784: ldc_w 331
    //   787: invokevirtual 316	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   790: astore 7
    //   792: aload 6
    //   794: invokeinterface 335 1 0
    //   799: aload_0
    //   800: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   803: aload 7
    //   805: invokeinterface 340 3 0
    //   810: invokeinterface 343 1 0
    //   815: pop
    //   816: iload_1
    //   817: iconst_1
    //   818: iadd
    //   819: istore_1
    //   820: goto -164 -> 656
    //   823: new 61	java/util/HashMap
    //   826: dup
    //   827: invokespecial 62	java/util/HashMap:<init>	()V
    //   830: astore 12
    //   832: aload 12
    //   834: ldc_w 345
    //   837: aload_0
    //   838: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   841: invokevirtual 244	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   844: pop
    //   845: aload_0
    //   846: aload 4
    //   848: aload 11
    //   850: aload 8
    //   852: aload 9
    //   854: aload 12
    //   856: invokevirtual 347	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   859: astore 11
    //   861: aload 11
    //   863: ifnull +50 -> 913
    //   866: aload 10
    //   868: aload 7
    //   870: aload 11
    //   872: ldc_w 310
    //   875: ldc_w 312
    //   878: invokevirtual 316	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   881: invokevirtual 316	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   884: astore 7
    //   886: aload 6
    //   888: invokeinterface 335 1 0
    //   893: aload_0
    //   894: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   897: aload 7
    //   899: invokeinterface 340 3 0
    //   904: invokeinterface 343 1 0
    //   909: pop
    //   910: goto -254 -> 656
    //   913: iload_2
    //   914: iconst_1
    //   915: iadd
    //   916: istore_2
    //   917: goto -261 -> 656
    //   920: aconst_null
    //   921: astore 5
    //   923: aconst_null
    //   924: astore 7
    //   926: aload 5
    //   928: astore 4
    //   930: iload_1
    //   931: aload_0
    //   932: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   935: invokeinterface 284 1 0
    //   940: if_icmpne +129 -> 1069
    //   943: aload 5
    //   945: astore 4
    //   947: new 117	org/json/JSONObject
    //   950: dup
    //   951: aload 6
    //   953: aload_0
    //   954: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   957: ldc_w 349
    //   960: invokeinterface 308 3 0
    //   965: invokespecial 120	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   968: astore 8
    //   970: aload 5
    //   972: astore 4
    //   974: aload 8
    //   976: ldc_w 351
    //   979: iconst_1
    //   980: invokevirtual 354	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   983: pop
    //   984: aload 5
    //   986: astore 4
    //   988: aload 6
    //   990: invokeinterface 335 1 0
    //   995: aload_0
    //   996: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   999: aload 8
    //   1001: invokevirtual 355	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1004: invokeinterface 340 3 0
    //   1009: invokeinterface 343 1 0
    //   1014: pop
    //   1015: aload 5
    //   1017: astore 4
    //   1019: ldc 92
    //   1021: iconst_1
    //   1022: ldc_w 357
    //   1025: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1028: iconst_0
    //   1029: ifeq +11 -> 1040
    //   1032: new 359	java/lang/NullPointerException
    //   1035: dup
    //   1036: invokespecial 360	java/lang/NullPointerException:<init>	()V
    //   1039: athrow
    //   1040: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1043: aload_0
    //   1044: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1047: invokeinterface 230 2 0
    //   1052: ifeq -982 -> 70
    //   1055: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1058: aload_0
    //   1059: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1062: invokeinterface 271 2 0
    //   1067: pop
    //   1068: return
    //   1069: iload_2
    //   1070: ifle +92 -> 1162
    //   1073: aload 5
    //   1075: astore 4
    //   1077: ldc 92
    //   1079: iconst_1
    //   1080: new 94	java/lang/StringBuilder
    //   1083: dup
    //   1084: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1087: ldc_w 362
    //   1090: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: iload_2
    //   1094: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1097: ldc_w 364
    //   1100: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: aload_0
    //   1104: getfield 30	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1107: invokeinterface 284 1 0
    //   1112: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1115: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1118: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1121: iconst_0
    //   1122: ifeq +11 -> 1133
    //   1125: new 359	java/lang/NullPointerException
    //   1128: dup
    //   1129: invokespecial 360	java/lang/NullPointerException:<init>	()V
    //   1132: athrow
    //   1133: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1136: aload_0
    //   1137: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1140: invokeinterface 230 2 0
    //   1145: ifeq -1075 -> 70
    //   1148: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1151: aload_0
    //   1152: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1155: invokeinterface 271 2 0
    //   1160: pop
    //   1161: return
    //   1162: aload 5
    //   1164: astore 4
    //   1166: new 94	java/lang/StringBuilder
    //   1169: dup
    //   1170: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1173: ldc_w 366
    //   1176: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: iload_3
    //   1180: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: astore 10
    //   1188: aload 5
    //   1190: astore 4
    //   1192: aload_0
    //   1193: getfield 20	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   1196: getfield 216	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:e	Z
    //   1199: ifeq +17 -> 1216
    //   1202: aload 5
    //   1204: astore 4
    //   1206: aload 10
    //   1208: ldc 218
    //   1210: ldc 220
    //   1212: invokevirtual 223	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1215: pop
    //   1216: aload 5
    //   1218: astore 4
    //   1220: new 368	java/net/URL
    //   1223: dup
    //   1224: aload 10
    //   1226: ldc 206
    //   1228: aload 8
    //   1230: invokestatic 211	bjnd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1233: invokespecial 369	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1236: invokevirtual 373	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1239: checkcast 375	java/net/HttpURLConnection
    //   1242: astore 5
    //   1244: aload 5
    //   1246: sipush 5000
    //   1249: invokevirtual 379	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1252: aload 5
    //   1254: sipush 30000
    //   1257: invokevirtual 382	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1260: aload 5
    //   1262: iconst_1
    //   1263: invokevirtual 386	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1266: aload 5
    //   1268: iconst_1
    //   1269: invokevirtual 389	java/net/HttpURLConnection:setDoInput	(Z)V
    //   1272: aload 5
    //   1274: iconst_0
    //   1275: invokevirtual 392	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   1278: aload 5
    //   1280: ldc_w 394
    //   1283: invokevirtual 397	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   1286: aload 5
    //   1288: ldc 64
    //   1290: ldc_w 399
    //   1293: invokevirtual 402	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1296: aload 5
    //   1298: ldc_w 404
    //   1301: new 94	java/lang/StringBuilder
    //   1304: dup
    //   1305: ldc_w 406
    //   1308: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1311: ldc_w 409
    //   1314: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: getstatic 414	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   1320: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: ldc_w 409
    //   1326: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: getstatic 419	android/os/Build:DEVICE	Ljava/lang/String;
    //   1332: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: ldc_w 409
    //   1338: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: getstatic 422	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   1344: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: ldc_w 409
    //   1350: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: ldc_w 424
    //   1356: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1362: invokevirtual 402	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1365: aload 5
    //   1367: ldc_w 426
    //   1370: ldc_w 428
    //   1373: invokevirtual 402	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1376: aload 5
    //   1378: ldc_w 430
    //   1381: new 94	java/lang/StringBuilder
    //   1384: dup
    //   1385: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1388: ldc_w 432
    //   1391: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: aload 8
    //   1396: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: ldc_w 434
    //   1402: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: aload 9
    //   1407: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1413: invokevirtual 402	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1416: new 436	java/io/DataOutputStream
    //   1419: dup
    //   1420: aload 5
    //   1422: invokevirtual 440	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1425: invokespecial 443	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1428: astore 7
    //   1430: new 445	java/lang/StringBuffer
    //   1433: dup
    //   1434: invokespecial 446	java/lang/StringBuffer:<init>	()V
    //   1437: astore 4
    //   1439: aload 4
    //   1441: ldc_w 448
    //   1444: invokevirtual 451	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1447: pop
    //   1448: aload 4
    //   1450: aload_0
    //   1451: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1454: invokevirtual 451	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1457: pop
    //   1458: aload 7
    //   1460: aload 4
    //   1462: invokevirtual 452	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1465: invokevirtual 456	java/lang/String:getBytes	()[B
    //   1468: invokevirtual 462	java/io/OutputStream:write	([B)V
    //   1471: aload 7
    //   1473: invokevirtual 465	java/io/OutputStream:flush	()V
    //   1476: aload 7
    //   1478: invokevirtual 468	java/io/OutputStream:close	()V
    //   1481: new 445	java/lang/StringBuffer
    //   1484: dup
    //   1485: invokespecial 446	java/lang/StringBuffer:<init>	()V
    //   1488: astore 7
    //   1490: new 470	java/io/BufferedReader
    //   1493: dup
    //   1494: new 472	java/io/InputStreamReader
    //   1497: dup
    //   1498: aload 5
    //   1500: invokevirtual 476	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1503: invokespecial 479	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1506: invokespecial 482	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1509: astore 4
    //   1511: aload 4
    //   1513: invokevirtual 485	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1516: astore 8
    //   1518: aload 8
    //   1520: ifnull +92 -> 1612
    //   1523: aload 7
    //   1525: aload 8
    //   1527: invokevirtual 451	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1530: ldc_w 487
    //   1533: invokevirtual 451	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1536: pop
    //   1537: goto -26 -> 1511
    //   1540: astore 6
    //   1542: aload 5
    //   1544: astore 4
    //   1546: ldc 92
    //   1548: iconst_2
    //   1549: new 94	java/lang/StringBuilder
    //   1552: dup
    //   1553: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1556: ldc_w 489
    //   1559: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: aload 6
    //   1564: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1567: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1573: aload 5
    //   1575: ifnull +8 -> 1583
    //   1578: aload 5
    //   1580: invokevirtual 492	java/net/HttpURLConnection:disconnect	()V
    //   1583: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1586: aload_0
    //   1587: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1590: invokeinterface 230 2 0
    //   1595: ifeq -1525 -> 70
    //   1598: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1601: aload_0
    //   1602: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1605: invokeinterface 271 2 0
    //   1610: pop
    //   1611: return
    //   1612: aload 7
    //   1614: invokevirtual 452	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1617: astore 7
    //   1619: aload 7
    //   1621: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1624: ifeq +12 -> 1636
    //   1627: ldc 92
    //   1629: iconst_1
    //   1630: ldc_w 494
    //   1633: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1636: new 117	org/json/JSONObject
    //   1639: dup
    //   1640: aload 7
    //   1642: invokespecial 120	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1645: ldc 122
    //   1647: invokevirtual 126	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1650: ifne +147 -> 1797
    //   1653: new 117	org/json/JSONObject
    //   1656: dup
    //   1657: aload 6
    //   1659: aload_0
    //   1660: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1663: ldc_w 349
    //   1666: invokeinterface 308 3 0
    //   1671: invokespecial 120	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1674: astore 8
    //   1676: aload 8
    //   1678: ldc_w 351
    //   1681: iconst_0
    //   1682: invokevirtual 354	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1685: pop
    //   1686: aload 6
    //   1688: invokeinterface 335 1 0
    //   1693: aload_0
    //   1694: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1697: aload 8
    //   1699: invokevirtual 355	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1702: invokeinterface 340 3 0
    //   1707: invokeinterface 343 1 0
    //   1712: pop
    //   1713: ldc 92
    //   1715: iconst_1
    //   1716: new 94	java/lang/StringBuilder
    //   1719: dup
    //   1720: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1723: ldc_w 496
    //   1726: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: aload_0
    //   1730: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1733: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1736: ldc_w 498
    //   1739: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: aload 7
    //   1744: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1747: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1750: invokestatic 109	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1753: aload 4
    //   1755: invokevirtual 499	java/io/BufferedReader:close	()V
    //   1758: aload 5
    //   1760: ifnull +8 -> 1768
    //   1763: aload 5
    //   1765: invokevirtual 492	java/net/HttpURLConnection:disconnect	()V
    //   1768: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1771: aload_0
    //   1772: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1775: invokeinterface 230 2 0
    //   1780: ifeq -1710 -> 70
    //   1783: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1786: aload_0
    //   1787: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1790: invokeinterface 271 2 0
    //   1795: pop
    //   1796: return
    //   1797: new 117	org/json/JSONObject
    //   1800: dup
    //   1801: aload 6
    //   1803: aload_0
    //   1804: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1807: ldc_w 349
    //   1810: invokeinterface 308 3 0
    //   1815: invokespecial 120	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1818: astore 8
    //   1820: aload 8
    //   1822: ldc_w 351
    //   1825: iconst_2
    //   1826: invokevirtual 354	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1829: pop
    //   1830: aload 6
    //   1832: invokeinterface 335 1 0
    //   1837: aload_0
    //   1838: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1841: aload 8
    //   1843: invokevirtual 355	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1846: invokeinterface 340 3 0
    //   1851: invokeinterface 343 1 0
    //   1856: pop
    //   1857: ldc 92
    //   1859: iconst_1
    //   1860: new 94	java/lang/StringBuilder
    //   1863: dup
    //   1864: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1867: ldc_w 501
    //   1870: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1873: aload_0
    //   1874: getfield 39	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1877: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: ldc_w 498
    //   1883: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1886: aload 7
    //   1888: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1891: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1894: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1897: goto -144 -> 1753
    //   1900: astore 4
    //   1902: aload 4
    //   1904: astore 6
    //   1906: aload 5
    //   1908: ifnull +8 -> 1916
    //   1911: aload 5
    //   1913: invokevirtual 492	java/net/HttpURLConnection:disconnect	()V
    //   1916: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1919: aload_0
    //   1920: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1923: invokeinterface 230 2 0
    //   1928: ifeq +16 -> 1944
    //   1931: getstatic 224	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1934: aload_0
    //   1935: getfield 41	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$UploadThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1938: invokeinterface 271 2 0
    //   1943: pop
    //   1944: aload 6
    //   1946: athrow
    //   1947: astore 6
    //   1949: aload 4
    //   1951: astore 5
    //   1953: goto -47 -> 1906
    //   1956: astore 6
    //   1958: aload 7
    //   1960: astore 5
    //   1962: goto -420 -> 1542
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1965	0	this	UploadThread
    //   145	796	1	i	int
    //   143	951	2	j	int
    //   151	1029	3	k	int
    //   8	1746	4	localObject1	Object
    //   1900	50	4	localObject2	Object
    //   322	1639	5	localObject3	Object
    //   392	597	6	localObject4	Object
    //   1540	291	6	localException1	Exception
    //   1904	41	6	localObject5	Object
    //   1947	1	6	localObject6	Object
    //   1956	1	6	localException2	Exception
    //   413	1546	7	localObject7	Object
    //   94	1748	8	localObject8	Object
    //   115	1291	9	str1	String
    //   690	535	10	str2	String
    //   729	142	11	str3	String
    //   676	179	12	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   1244	1511	1540	java/lang/Exception
    //   1511	1518	1540	java/lang/Exception
    //   1523	1537	1540	java/lang/Exception
    //   1612	1636	1540	java/lang/Exception
    //   1636	1753	1540	java/lang/Exception
    //   1753	1758	1540	java/lang/Exception
    //   1797	1897	1540	java/lang/Exception
    //   1244	1511	1900	finally
    //   1511	1518	1900	finally
    //   1523	1537	1900	finally
    //   1612	1636	1900	finally
    //   1636	1753	1900	finally
    //   1753	1758	1900	finally
    //   1797	1897	1900	finally
    //   930	943	1947	finally
    //   947	970	1947	finally
    //   974	984	1947	finally
    //   988	1015	1947	finally
    //   1019	1028	1947	finally
    //   1077	1121	1947	finally
    //   1166	1188	1947	finally
    //   1192	1202	1947	finally
    //   1206	1216	1947	finally
    //   1220	1244	1947	finally
    //   1546	1573	1947	finally
    //   930	943	1956	java/lang/Exception
    //   947	970	1956	java/lang/Exception
    //   974	984	1956	java/lang/Exception
    //   988	1015	1956	java/lang/Exception
    //   1019	1028	1956	java/lang/Exception
    //   1077	1121	1956	java/lang/Exception
    //   1166	1188	1956	java/lang/Exception
    //   1192	1202	1956	java/lang/Exception
    //   1206	1216	1956	java/lang/Exception
    //   1220	1244	1956	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.UploadThread
 * JD-Core Version:    0.7.0.1
 */