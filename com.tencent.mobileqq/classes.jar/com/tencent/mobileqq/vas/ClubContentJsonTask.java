package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ClubContentJsonTask
{
  public static ClubContentJsonTask.PersonalCardUrlInfo a;
  public static ClubContentJsonTask.TaskInfo a;
  static DownloadListener a;
  public static String a;
  public static HashMap<String, Boolean> a;
  public static ClubContentJsonTask.TaskInfo[] a;
  public static ClubContentJsonTask.TaskInfo b;
  public static String b;
  public static ClubContentJsonTask.TaskInfo c;
  public static ClubContentJsonTask.TaskInfo d;
  public static ClubContentJsonTask.TaskInfo e;
  public static ClubContentJsonTask.TaskInfo f;
  public static ClubContentJsonTask.TaskInfo g;
  public static ClubContentJsonTask.TaskInfo h;
  public static ClubContentJsonTask.TaskInfo i;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo("recommendEmotion.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/xydata.json", "recommendEmotionVersion", "vipData_emoji_aio_recommend.json");
    jdField_b_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo("IndividuationUrls.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation_url/android.json", "individuationUrlJsonNewVersion", "vipData_individuation_url_json");
    c = new ClubContentJsonTask.TaskInfo("Individuation.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/xydata.json", "IndividuationVersion", "individ_json");
    d = new ClubContentJsonTask.TaskInfo("EmoticonWording.json", "", "https://i.gtimg.cn/club/item/parcel/client_wording.json", "EmoticonWordingVersion", "wording_json");
    e = new ClubContentJsonTask.TaskInfo("WebviewCrashReport.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vip_crash_report/WebviewCrashReport.json", "WebviewCrashJSONVersion", "WebviewCrashReport.json");
    f = new ClubContentJsonTask.TaskInfo("Qutu_xydata.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_release_zip/xydata.json", "QutuXYDataJsonVersion", "xydata.json");
    g = new ClubContentJsonTask.TaskInfo("iRedPacket_v2.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/xydata.mobile.v1.json", "vipRedPacketData_json_v2", "vipRedPacketData_json_v2");
    h = new ClubContentJsonTask.TaskInfo("UrlIntercept.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api/android.json", "UrlIntercept_json", "UrlIntercept_json");
    jdField_a_of_type_JavaLangString = "clubContentPendantMarketJsonUpdate";
    i = new ClubContentJsonTask.TaskInfo("font_info.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data", "https://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data/version.json", "FontInfoList_json", "FontInfoList_json");
    jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo[] { jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo, c, d };
    jdField_b_of_type_JavaLangString = "https://i.gtimg.cn/xydata";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new ClubContentJsonTask.1();
    jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo = null;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("clubContentVersion", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "--getJsonVersion ,key=" + paramString + ",version:" + paramContext.getInt(paramString, 0));
    }
    return paramContext.getInt(paramString, 0);
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, boolean paramBoolean)
  {
    Object localObject = paramQQAppInterface.getApplication().getApplicationContext();
    String str = paramTaskInfo.jdField_a_of_type_JavaLangString;
    localObject = new File(((Context)localObject).getFilesDir(), str);
    if (((File)localObject).exists()) {
      try
      {
        paramQQAppInterface = FileUtils.a((File)localObject, -1);
        if (paramQQAppInterface == null) {}
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          try
          {
            paramQQAppInterface = new JSONObject(paramQQAppInterface);
            return paramQQAppInterface;
          }
          catch (Throwable paramQQAppInterface)
          {
            QLog.e("ClubContentJsonTask", 2, "getJsonFromLocalFile new Json err,json_name:" + str + ", msg:" + paramQQAppInterface.getMessage());
            ((File)localObject).delete();
          }
          paramQQAppInterface = paramQQAppInterface;
          QLog.e("ClubContentJsonTask", 2, "getJsonFromLocalFile err,json_name:" + str + ", msg:" + paramQQAppInterface.getMessage());
          paramQQAppInterface = null;
        }
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.w("ClubContentJsonTask", 2, "getJsonFromLocalFile not exist,json_name:" + str + " _ " + paramBoolean);
      }
      if (paramBoolean) {
        a(paramQQAppInterface, paramTaskInfo);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "setJsonVersion ,key=" + paramString + ",version:" + paramInt);
    }
    paramContext.getSharedPreferences("clubContentVersion", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(AppInterface paramAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, String paramString, File paramFile, Bundle paramBundle)
  {
    if (paramFile == null) {}
    String str1;
    do
    {
      return;
      str1 = paramString;
    } while ((paramString == null) && (paramTaskInfo == null));
    label428:
    label436:
    label442:
    label445:
    for (;;)
    {
      try
      {
        for (;;)
        {
          str1 = paramTaskInfo.jdField_b_of_type_JavaLangString;
          if (paramTaskInfo == null) {
            break label428;
          }
          paramTaskInfo = paramTaskInfo.jdField_a_of_type_JavaLangString;
          paramString = paramBundle.getString("method");
          if (paramString != null) {
            break label445;
          }
          paramString = "other";
          String str2 = paramBundle.getString("ifromet");
          if (str2 != null) {
            break label442;
          }
          str2 = "false";
          if (!paramBundle.containsKey("forceUpdate")) {
            break label436;
          }
          bool = paramBundle.getBoolean("forceUpdate");
          int j = paramBundle.getInt("version", 0);
          String str3 = paramTaskInfo + "_" + j;
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "club_downloadFile,method:" + paramString + ",key:" + paramTaskInfo + ", server version:" + j + ",ifromet:" + str2);
          }
          if ((!bool) && (jdField_a_of_type_JavaUtilHashMap.containsKey(str3)) && (((Boolean)jdField_a_of_type_JavaUtilHashMap.get(str3)).booleanValue())) {
            break;
          }
          jdField_a_of_type_JavaUtilHashMap.put(str3, Boolean.valueOf(true));
          paramFile = new DownloadTask(str1, paramFile);
          paramFile.n = true;
          paramFile.jdField_a_of_type_JavaLangString = paramTaskInfo;
          ((DownloaderFactory)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a(paramFile, jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramBundle);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, paramString + ",cdownloadFile url=" + str1);
          }
          try
          {
            paramString = new HashMap();
            paramString.put("param_key", paramTaskInfo);
            paramString.put("param_ifromet", str2);
            StatisticCollector.getInstance(paramAppInterface.getApplication().getApplicationContext()).collectPerformance(paramAppInterface.getAccount(), "VipClubContentJsonTaskLoad", true, 1L, 0L, paramString, "", false);
          }
          catch (Exception paramAppInterface) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ClubContentJsonTask", 2, "downloadFile, downloadFile error=" + paramAppInterface.toString());
        break;
      }
      finally {}
      paramTaskInfo = paramFile.getName();
      continue;
      boolean bool = false;
      continue;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApplication().getApplicationContext();
    int j = 0;
    while (j < jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo.length)
    {
      a(paramQQAppInterface, jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo[j]);
      j += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo)
  {
    int j = 10;
    int k = 0;
    if ((paramQQAppInterface == null) || (paramTaskInfo == null)) {}
    do
    {
      return;
      File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.jdField_a_of_type_JavaLangString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, not exist: " + paramTaskInfo.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          try
          {
            localObject = String.valueOf(NetConnInfoCenter.getServerTime());
            if (((String)localObject).length() <= 10) {
              continue;
            }
            localObject = ((String)localObject).substring(0, j);
            j = k;
            if (Long.parseLong((String)localObject) < 2147483647L) {
              j = Integer.parseInt((String)localObject);
            }
          }
          catch (Exception localException)
          {
            Object localObject;
            QLog.e("ClubContentJsonTask", 1, "downloadIfNotExist, Integer.parseInt Err:" + localException.getMessage());
            j = k;
            continue;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("version", j);
          ((Bundle)localObject).putString("version_key", paramTaskInfo.d);
          ((Bundle)localObject).putString("method", "downloadIfNotExist");
          ((Bundle)localObject).putString("ifromet", "null1");
          a(paramQQAppInterface, paramTaskInfo, EmosmUtils.a("VIP_emosm", paramTaskInfo.jdField_b_of_type_JavaLangString), localFile, (Bundle)localObject);
          return;
          j = ((String)localObject).length();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, exists.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt, boolean paramBoolean)
  {
    Context localContext = paramQQAppInterface.getApplication().getApplicationContext();
    Bundle localBundle = new Bundle();
    localBundle.putInt("version", paramInt);
    localBundle.putString("version_key", paramTaskInfo.d);
    localBundle.putString("method", "updateJson");
    localBundle.putString("ifromet", String.valueOf(paramBoolean));
    a(paramQQAppInterface, paramTaskInfo, null, new File(localContext.getFilesDir(), paramTaskInfo.jdField_a_of_type_JavaLangString), localBundle);
  }
  
  /* Error */
  public static void b(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 468
    //   4: iconst_0
    //   5: aconst_null
    //   6: invokestatic 473	com/tencent/mobileqq/vas/updatesystem/VasUpdateUtil:a	(Lmqq/app/AppRuntime;Ljava/lang/String;ZLcom/tencent/mobileqq/vas/updatesystem/callback/CallBacker;)Lorg/json/JSONObject;
    //   9: astore 6
    //   11: aload 6
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: getstatic 478	com/etrump/mixlayout/FontManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   20: iconst_0
    //   21: invokevirtual 484	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   24: new 486	com/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo
    //   27: dup
    //   28: invokespecial 487	com/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo:<init>	()V
    //   31: putstatic 145	com/tencent/mobileqq/vas/ClubContentJsonTask:jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo;
    //   34: aload 6
    //   36: ldc_w 489
    //   39: invokevirtual 492	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   42: istore_1
    //   43: iload_1
    //   44: ifeq +15 -> 59
    //   47: aload_0
    //   48: ldc_w 494
    //   51: iload_1
    //   52: invokestatic 497	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   55: invokestatic 502	com/tencent/mobileqq/vas/VasUserData:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Z
    //   58: pop
    //   59: aload 6
    //   61: ldc_w 504
    //   64: invokevirtual 507	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   67: ifeq +689 -> 756
    //   70: aload 6
    //   72: ldc_w 504
    //   75: invokevirtual 511	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +168 -> 250
    //   85: aload 4
    //   87: invokevirtual 514	org/json/JSONArray:length	()I
    //   90: ifle +160 -> 250
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: aload 4
    //   98: invokevirtual 514	org/json/JSONArray:length	()I
    //   101: if_icmpge +149 -> 250
    //   104: aload 4
    //   106: iload_1
    //   107: invokevirtual 517	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   110: checkcast 226	org/json/JSONObject
    //   113: astore 5
    //   115: aload 5
    //   117: ldc_w 519
    //   120: invokevirtual 507	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   123: ifeq +639 -> 762
    //   126: aload 5
    //   128: ldc_w 519
    //   131: invokevirtual 521	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   134: istore_2
    //   135: goto +686 -> 821
    //   138: aload 5
    //   140: ldc_w 523
    //   143: invokevirtual 507	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   146: ifeq +621 -> 767
    //   149: aload 5
    //   151: ldc_w 523
    //   154: invokevirtual 524	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 4
    //   159: aload 5
    //   161: ldc_w 526
    //   164: invokevirtual 507	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   167: ifeq +666 -> 833
    //   170: aload 5
    //   172: ldc_w 526
    //   175: invokevirtual 524	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 5
    //   180: getstatic 145	com/tencent/mobileqq/vas/ClubContentJsonTask:jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo;
    //   183: aload 4
    //   185: putfield 527	com/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: getstatic 145	com/tencent/mobileqq/vas/ClubContentJsonTask:jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo;
    //   191: aload 5
    //   193: putfield 528	com/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   196: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +51 -> 250
    //   202: ldc 164
    //   204: iconst_2
    //   205: new 166	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 530
    //   215: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload_2
    //   219: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: ldc_w 532
    //   225: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 4
    //   230: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 534
    //   236: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 5
    //   241: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload 6
    //   252: ldc_w 536
    //   255: invokevirtual 540	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   258: astore 4
    //   260: aload 4
    //   262: ifnull +274 -> 536
    //   265: aload 4
    //   267: ldc_w 542
    //   270: invokevirtual 492	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   273: iconst_1
    //   274: if_icmpne +573 -> 847
    //   277: iconst_1
    //   278: istore_3
    //   279: iload_3
    //   280: putstatic 544	com/etrump/mixlayout/FontManager:jdField_e_of_type_Boolean	Z
    //   283: getstatic 544	com/etrump/mixlayout/FontManager:jdField_e_of_type_Boolean	Z
    //   286: ifeq +488 -> 774
    //   289: aload 4
    //   291: ldc_w 546
    //   294: invokevirtual 492	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   297: iconst_1
    //   298: if_icmpne +554 -> 852
    //   301: iconst_1
    //   302: istore_3
    //   303: iload_3
    //   304: putstatic 548	com/etrump/mixlayout/FontManager:jdField_f_of_type_Boolean	Z
    //   307: aload 4
    //   309: ldc_w 550
    //   312: invokevirtual 554	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   315: d2f
    //   316: putstatic 557	com/etrump/mixlayout/FontManager:a	F
    //   319: aload 4
    //   321: ldc_w 559
    //   324: invokevirtual 554	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   327: d2f
    //   328: putstatic 561	com/etrump/mixlayout/FontManager:jdField_b_of_type_Float	F
    //   331: aload 4
    //   333: ldc_w 563
    //   336: invokevirtual 554	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   339: d2f
    //   340: putstatic 565	com/etrump/mixlayout/FontManager:jdField_c_of_type_Float	F
    //   343: aload 4
    //   345: ldc_w 567
    //   348: invokevirtual 554	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   351: d2f
    //   352: putstatic 569	com/etrump/mixlayout/FontManager:d	F
    //   355: aload 4
    //   357: ldc_w 571
    //   360: invokevirtual 554	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   363: d2f
    //   364: putstatic 573	com/etrump/mixlayout/FontManager:jdField_e_of_type_Float	F
    //   367: aload 4
    //   369: ldc_w 575
    //   372: invokevirtual 554	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   375: d2f
    //   376: putstatic 577	com/etrump/mixlayout/FontManager:jdField_f_of_type_Float	F
    //   379: aload 4
    //   381: ldc_w 579
    //   384: invokevirtual 492	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   387: putstatic 581	com/etrump/mixlayout/FontManager:jdField_b_of_type_Int	I
    //   390: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +115 -> 508
    //   396: ldc 164
    //   398: iconst_2
    //   399: new 166	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 583
    //   409: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: getstatic 548	com/etrump/mixlayout/FontManager:jdField_f_of_type_Boolean	Z
    //   415: invokevirtual 250	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   418: ldc_w 585
    //   421: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: getstatic 557	com/etrump/mixlayout/FontManager:a	F
    //   427: invokevirtual 588	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   430: ldc_w 590
    //   433: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: getstatic 561	com/etrump/mixlayout/FontManager:jdField_b_of_type_Float	F
    //   439: invokevirtual 588	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   442: ldc_w 592
    //   445: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: getstatic 565	com/etrump/mixlayout/FontManager:jdField_c_of_type_Float	F
    //   451: invokevirtual 588	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   454: ldc_w 594
    //   457: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: getstatic 569	com/etrump/mixlayout/FontManager:d	F
    //   463: invokevirtual 588	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   466: ldc_w 596
    //   469: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: getstatic 573	com/etrump/mixlayout/FontManager:jdField_e_of_type_Float	F
    //   475: invokevirtual 588	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   478: ldc_w 598
    //   481: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: getstatic 577	com/etrump/mixlayout/FontManager:jdField_f_of_type_Float	F
    //   487: invokevirtual 588	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   490: ldc_w 600
    //   493: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: getstatic 581	com/etrump/mixlayout/FontManager:jdField_b_of_type_Int	I
    //   499: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: getstatic 478	com/etrump/mixlayout/FontManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   511: iconst_1
    //   512: invokevirtual 484	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   515: getstatic 605	com/tencent/mobileqq/activity/aio/item/TextItemBuilder:a	Lcom/tencent/util/LRULinkedHashMap;
    //   518: astore 4
    //   520: aload 4
    //   522: monitorenter
    //   523: getstatic 605	com/tencent/mobileqq/activity/aio/item/TextItemBuilder:a	Lcom/tencent/util/LRULinkedHashMap;
    //   526: invokevirtual 610	com/tencent/util/LRULinkedHashMap:clear	()V
    //   529: aload 4
    //   531: monitorexit
    //   532: aload_0
    //   533: invokestatic 615	com/tencent/mobileqq/utils/VasUtils:a	(Lcom/tencent/common/app/AppInterface;)V
    //   536: aload 6
    //   538: ldc_w 617
    //   541: invokevirtual 540	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   544: astore_0
    //   545: aload_0
    //   546: ifnull +252 -> 798
    //   549: aload_0
    //   550: ldc_w 619
    //   553: iconst_0
    //   554: invokevirtual 621	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: iconst_1
    //   558: if_icmpne +299 -> 857
    //   561: iconst_1
    //   562: istore_3
    //   563: iload_3
    //   564: putstatic 625	com/tencent/mobileqq/app/SignatureManager:a	Z
    //   567: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +32 -> 602
    //   573: ldc_w 627
    //   576: iconst_2
    //   577: new 166	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 629
    //   587: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: getstatic 625	com/tencent/mobileqq/app/SignatureManager:a	Z
    //   593: invokevirtual 250	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload 6
    //   604: ldc_w 631
    //   607: invokevirtual 540	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   610: astore_0
    //   611: aload_0
    //   612: ifnull +16 -> 628
    //   615: aload_0
    //   616: ldc_w 633
    //   619: sipush 300
    //   622: invokevirtual 621	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   625: putstatic 637	com/tencent/mobileqq/hiboom/HiBoomManager:jdField_a_of_type_Int	I
    //   628: aload 6
    //   630: ldc_w 639
    //   633: invokevirtual 540	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   636: astore_0
    //   637: aload_0
    //   638: ifnull +68 -> 706
    //   641: aload_0
    //   642: ldc_w 641
    //   645: invokevirtual 492	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   648: istore_1
    //   649: iload_1
    //   650: ifle +19 -> 669
    //   653: new 643	java/util/Random
    //   656: dup
    //   657: invokespecial 644	java/util/Random:<init>	()V
    //   660: iload_1
    //   661: invokevirtual 648	java/util/Random:nextInt	(I)I
    //   664: iconst_1
    //   665: iadd
    //   666: putstatic 651	com/etrump/mixlayout/FontReportUtils:jdField_a_of_type_Int	I
    //   669: getstatic 654	com/etrump/mixlayout/FontReportUtils:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   672: aload_0
    //   673: ldc_w 656
    //   676: invokevirtual 492	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   679: invokevirtual 661	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   682: getstatic 663	com/etrump/mixlayout/FontReportUtils:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   685: astore 4
    //   687: aload_0
    //   688: ldc_w 665
    //   691: invokevirtual 492	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   694: iconst_1
    //   695: if_icmpne +116 -> 811
    //   698: iconst_1
    //   699: istore_3
    //   700: aload 4
    //   702: iload_3
    //   703: invokevirtual 484	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   706: aload 6
    //   708: ldc_w 667
    //   711: invokevirtual 540	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   714: astore_0
    //   715: aload_0
    //   716: ifnull -700 -> 16
    //   719: getstatic 670	com/tencent/mobileqq/vas/ColorNickManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   722: astore 4
    //   724: aload_0
    //   725: ldc_w 542
    //   728: invokevirtual 492	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   731: iconst_1
    //   732: if_icmpne +84 -> 816
    //   735: iconst_1
    //   736: istore_3
    //   737: aload 4
    //   739: iload_3
    //   740: invokevirtual 484	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   743: return
    //   744: astore_0
    //   745: ldc 164
    //   747: iconst_1
    //   748: ldc_w 672
    //   751: aload_0
    //   752: invokestatic 675	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   755: return
    //   756: aconst_null
    //   757: astore 4
    //   759: goto -679 -> 80
    //   762: iconst_m1
    //   763: istore_2
    //   764: goto +57 -> 821
    //   767: ldc 44
    //   769: astore 4
    //   771: goto -612 -> 159
    //   774: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq -269 -> 508
    //   780: ldc 164
    //   782: iconst_2
    //   783: ldc_w 677
    //   786: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: goto -281 -> 508
    //   792: astore_0
    //   793: aload 4
    //   795: monitorexit
    //   796: aload_0
    //   797: athrow
    //   798: ldc_w 679
    //   801: iconst_1
    //   802: ldc_w 681
    //   805: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: goto -206 -> 602
    //   811: iconst_0
    //   812: istore_3
    //   813: goto -113 -> 700
    //   816: iconst_0
    //   817: istore_3
    //   818: goto -81 -> 737
    //   821: iload_2
    //   822: ifeq -684 -> 138
    //   825: iload_2
    //   826: iconst_2
    //   827: if_icmpne +13 -> 840
    //   830: goto -692 -> 138
    //   833: ldc 44
    //   835: astore 5
    //   837: goto -657 -> 180
    //   840: iload_1
    //   841: iconst_1
    //   842: iadd
    //   843: istore_1
    //   844: goto -749 -> 95
    //   847: iconst_0
    //   848: istore_3
    //   849: goto -570 -> 279
    //   852: iconst_0
    //   853: istore_3
    //   854: goto -551 -> 303
    //   857: iconst_0
    //   858: istore_3
    //   859: goto -296 -> 563
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	862	0	paramQQAppInterface	QQAppInterface
    //   42	802	1	j	int
    //   134	694	2	k	int
    //   278	581	3	bool	boolean
    //   113	723	5	localObject2	Object
    //   9	698	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   24	43	744	java/lang/Exception
    //   47	59	744	java/lang/Exception
    //   59	80	744	java/lang/Exception
    //   85	93	744	java/lang/Exception
    //   95	135	744	java/lang/Exception
    //   138	159	744	java/lang/Exception
    //   159	180	744	java/lang/Exception
    //   180	250	744	java/lang/Exception
    //   250	260	744	java/lang/Exception
    //   265	277	744	java/lang/Exception
    //   279	301	744	java/lang/Exception
    //   303	508	744	java/lang/Exception
    //   508	523	744	java/lang/Exception
    //   532	536	744	java/lang/Exception
    //   536	545	744	java/lang/Exception
    //   549	561	744	java/lang/Exception
    //   563	602	744	java/lang/Exception
    //   602	611	744	java/lang/Exception
    //   615	628	744	java/lang/Exception
    //   628	637	744	java/lang/Exception
    //   641	649	744	java/lang/Exception
    //   653	669	744	java/lang/Exception
    //   669	698	744	java/lang/Exception
    //   700	706	744	java/lang/Exception
    //   706	715	744	java/lang/Exception
    //   719	735	744	java/lang/Exception
    //   737	743	744	java/lang/Exception
    //   774	789	744	java/lang/Exception
    //   796	798	744	java/lang/Exception
    //   798	808	744	java/lang/Exception
    //   523	532	792	finally
    //   793	796	792	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ClubContentJsonTask
 * JD-Core Version:    0.7.0.1
 */