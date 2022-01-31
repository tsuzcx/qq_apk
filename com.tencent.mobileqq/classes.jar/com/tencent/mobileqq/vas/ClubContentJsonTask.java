package com.tencent.mobileqq.vas;

import akhd;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public static HashMap a;
  public static ClubContentJsonTask.TaskInfo[] a;
  public static ClubContentJsonTask.TaskInfo b;
  public static ClubContentJsonTask.TaskInfo c;
  public static ClubContentJsonTask.TaskInfo d;
  public static ClubContentJsonTask.TaskInfo e;
  public static ClubContentJsonTask.TaskInfo f;
  public static ClubContentJsonTask.TaskInfo g;
  public static ClubContentJsonTask.TaskInfo h;
  public static ClubContentJsonTask.TaskInfo i;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo("recommendEmotion.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/xydata.json", "recommendEmotionVersion", "vipData_emoji_aio_recommend.json");
    b = new ClubContentJsonTask.TaskInfo("IndividuationUrls.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation_url/android.json", "individuationUrlJsonNewVersion", "vipData_individuation_url_json");
    c = new ClubContentJsonTask.TaskInfo("Individuation.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/xydata.json", "IndividuationVersion", "individ_json");
    d = new ClubContentJsonTask.TaskInfo("EmoticonWording.json", "", "http://i.gtimg.cn/club/item/parcel/client_wording.json", "EmoticonWordingVersion", "wording_json");
    e = new ClubContentJsonTask.TaskInfo("WebviewCrashReport.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/vip_crash_report/WebviewCrashReport.json", "WebviewCrashJSONVersion", "WebviewCrashReport.json");
    f = new ClubContentJsonTask.TaskInfo("Qutu_xydata.json", "", "http://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_release_zip/xydata.json", "QutuXYDataJsonVersion", "xydata.json");
    g = new ClubContentJsonTask.TaskInfo("iRedPacket_v2.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/", "http://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/xydata.mobile.v1.json", "vipRedPacketData_json_v2", "vipRedPacketData_json_v2");
    h = new ClubContentJsonTask.TaskInfo("UrlIntercept.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api/android.json", "UrlIntercept_json", "UrlIntercept_json");
    i = new ClubContentJsonTask.TaskInfo("font_info.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data", "http://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data/version.json", "FontInfoList_json", "FontInfoList_json");
    jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo[] { jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo, c, d };
    jdField_a_of_type_JavaLangString = "http://i.gtimg.cn/xydata";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new akhd();
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
    label427:
    label435:
    label441:
    label444:
    for (;;)
    {
      try
      {
        for (;;)
        {
          str1 = paramTaskInfo.b;
          if (paramTaskInfo == null) {
            break label427;
          }
          paramTaskInfo = paramTaskInfo.jdField_a_of_type_JavaLangString;
          paramString = paramBundle.getString("method");
          if (paramString != null) {
            break label444;
          }
          paramString = "other";
          String str2 = paramBundle.getString("ifromet");
          if (str2 != null) {
            break label441;
          }
          str2 = "false";
          if (!paramBundle.containsKey("forceUpdate")) {
            break label435;
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
          paramFile.l = true;
          paramFile.jdField_a_of_type_JavaLangString = paramTaskInfo;
          ((DownloaderFactory)paramAppInterface.getManager(46)).a(1).a(paramFile, jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramBundle);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, paramString + ",cdownloadFile url=" + str1);
          }
          try
          {
            paramString = new HashMap();
            paramString.put("param_key", paramTaskInfo);
            paramString.put("param_ifromet", str2);
            StatisticCollector.a(paramAppInterface.getApplication().getApplicationContext()).a(paramAppInterface.getAccount(), "VipClubContentJsonTaskLoad", true, 1L, 0L, paramString, "", false);
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
          a(paramQQAppInterface, paramTaskInfo, EmosmUtils.a("VIP_emosm", paramTaskInfo.b), localFile, (Bundle)localObject);
          return;
          j = ((String)localObject).length();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, exists.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt, boolean paramBoolean)
  {
    File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("version", paramInt);
    localBundle.putString("version_key", paramTaskInfo.d);
    localBundle.putString("method", "updateJson");
    localBundle.putString("ifromet", String.valueOf(paramBoolean));
    a(paramQQAppInterface, paramTaskInfo, null, localFile, localBundle);
  }
  
  /* Error */
  public static void b(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 454
    //   4: iconst_0
    //   5: aconst_null
    //   6: invokestatic 459	com/tencent/mobileqq/vas/VasQuickUpdateManager:a	(Lmqq/app/AppRuntime;Ljava/lang/String;ZLcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)Lorg/json/JSONObject;
    //   9: astore 6
    //   11: aload 6
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: getstatic 464	com/etrump/mixlayout/FontManager:jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   20: iconst_0
    //   21: invokevirtual 470	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   24: new 472	com/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo
    //   27: dup
    //   28: invokespecial 473	com/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo:<init>	()V
    //   31: putstatic 475	com/tencent/mobileqq/vas/ClubContentJsonTask:jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo;
    //   34: aload 6
    //   36: ldc_w 477
    //   39: invokevirtual 480	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   42: istore_1
    //   43: iload_1
    //   44: ifeq +15 -> 59
    //   47: aload_0
    //   48: ldc_w 482
    //   51: iload_1
    //   52: invokestatic 485	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   55: invokestatic 490	com/tencent/mobileqq/vas/VasUserData:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Z
    //   58: pop
    //   59: aload 6
    //   61: ldc_w 492
    //   64: invokevirtual 495	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   67: ifeq +548 -> 615
    //   70: aload 6
    //   72: ldc_w 492
    //   75: invokevirtual 499	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +168 -> 250
    //   85: aload 4
    //   87: invokevirtual 502	org/json/JSONArray:length	()I
    //   90: ifle +160 -> 250
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: aload 4
    //   98: invokevirtual 502	org/json/JSONArray:length	()I
    //   101: if_icmpge +149 -> 250
    //   104: aload 4
    //   106: iload_1
    //   107: invokevirtual 505	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   110: checkcast 219	org/json/JSONObject
    //   113: astore 5
    //   115: aload 5
    //   117: ldc_w 507
    //   120: invokevirtual 495	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   123: ifeq +498 -> 621
    //   126: aload 5
    //   128: ldc_w 507
    //   131: invokevirtual 509	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   134: istore_2
    //   135: goto +533 -> 668
    //   138: aload 5
    //   140: ldc_w 511
    //   143: invokevirtual 495	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   146: ifeq +480 -> 626
    //   149: aload 5
    //   151: ldc_w 511
    //   154: invokevirtual 512	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 4
    //   159: aload 5
    //   161: ldc_w 514
    //   164: invokevirtual 495	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   167: ifeq +513 -> 680
    //   170: aload 5
    //   172: ldc_w 514
    //   175: invokevirtual 512	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 5
    //   180: getstatic 475	com/tencent/mobileqq/vas/ClubContentJsonTask:jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo;
    //   183: aload 4
    //   185: putfield 515	com/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: getstatic 475	com/tencent/mobileqq/vas/ClubContentJsonTask:jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo;
    //   191: aload 5
    //   193: putfield 516	com/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo:b	Ljava/lang/String;
    //   196: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +51 -> 250
    //   202: ldc 157
    //   204: iconst_2
    //   205: new 159	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 518
    //   215: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload_2
    //   219: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: ldc_w 520
    //   225: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 4
    //   230: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 522
    //   236: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 5
    //   241: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload 6
    //   252: ldc_w 524
    //   255: invokevirtual 528	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   258: astore 4
    //   260: aload 4
    //   262: ifnull +274 -> 536
    //   265: aload 4
    //   267: ldc_w 530
    //   270: invokevirtual 480	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   273: iconst_1
    //   274: if_icmpne +420 -> 694
    //   277: iconst_1
    //   278: istore_3
    //   279: iload_3
    //   280: putstatic 532	com/etrump/mixlayout/FontManager:jdField_e_of_type_Boolean	Z
    //   283: getstatic 532	com/etrump/mixlayout/FontManager:jdField_e_of_type_Boolean	Z
    //   286: ifeq +347 -> 633
    //   289: aload 4
    //   291: ldc_w 534
    //   294: invokevirtual 480	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   297: iconst_1
    //   298: if_icmpne +401 -> 699
    //   301: iconst_1
    //   302: istore_3
    //   303: iload_3
    //   304: putstatic 536	com/etrump/mixlayout/FontManager:jdField_f_of_type_Boolean	Z
    //   307: aload 4
    //   309: ldc_w 538
    //   312: invokevirtual 542	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   315: d2f
    //   316: putstatic 545	com/etrump/mixlayout/FontManager:a	F
    //   319: aload 4
    //   321: ldc_w 547
    //   324: invokevirtual 542	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   327: d2f
    //   328: putstatic 549	com/etrump/mixlayout/FontManager:jdField_b_of_type_Float	F
    //   331: aload 4
    //   333: ldc_w 551
    //   336: invokevirtual 542	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   339: d2f
    //   340: putstatic 553	com/etrump/mixlayout/FontManager:c	F
    //   343: aload 4
    //   345: ldc_w 555
    //   348: invokevirtual 542	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   351: d2f
    //   352: putstatic 557	com/etrump/mixlayout/FontManager:jdField_d_of_type_Float	F
    //   355: aload 4
    //   357: ldc_w 559
    //   360: invokevirtual 542	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   363: d2f
    //   364: putstatic 561	com/etrump/mixlayout/FontManager:jdField_e_of_type_Float	F
    //   367: aload 4
    //   369: ldc_w 563
    //   372: invokevirtual 542	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   375: d2f
    //   376: putstatic 565	com/etrump/mixlayout/FontManager:jdField_f_of_type_Float	F
    //   379: aload 4
    //   381: ldc_w 567
    //   384: invokevirtual 480	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   387: putstatic 570	com/etrump/mixlayout/FontManager:jdField_b_of_type_Int	I
    //   390: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +115 -> 508
    //   396: ldc 157
    //   398: iconst_2
    //   399: new 159	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 572
    //   409: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: getstatic 536	com/etrump/mixlayout/FontManager:jdField_f_of_type_Boolean	Z
    //   415: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   418: ldc_w 574
    //   421: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: getstatic 545	com/etrump/mixlayout/FontManager:a	F
    //   427: invokevirtual 577	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   430: ldc_w 579
    //   433: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: getstatic 549	com/etrump/mixlayout/FontManager:jdField_b_of_type_Float	F
    //   439: invokevirtual 577	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   442: ldc_w 581
    //   445: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: getstatic 553	com/etrump/mixlayout/FontManager:c	F
    //   451: invokevirtual 577	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   454: ldc_w 583
    //   457: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: getstatic 557	com/etrump/mixlayout/FontManager:jdField_d_of_type_Float	F
    //   463: invokevirtual 577	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   466: ldc_w 585
    //   469: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: getstatic 561	com/etrump/mixlayout/FontManager:jdField_e_of_type_Float	F
    //   475: invokevirtual 577	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   478: ldc_w 587
    //   481: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: getstatic 565	com/etrump/mixlayout/FontManager:jdField_f_of_type_Float	F
    //   487: invokevirtual 577	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   490: ldc_w 589
    //   493: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: getstatic 570	com/etrump/mixlayout/FontManager:jdField_b_of_type_Int	I
    //   499: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: getstatic 464	com/etrump/mixlayout/FontManager:jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   511: iconst_1
    //   512: invokevirtual 470	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   515: getstatic 594	com/tencent/mobileqq/activity/aio/item/TextItemBuilder:a	Lcom/tencent/util/LRULinkedHashMap;
    //   518: astore 4
    //   520: aload 4
    //   522: monitorenter
    //   523: getstatic 594	com/tencent/mobileqq/activity/aio/item/TextItemBuilder:a	Lcom/tencent/util/LRULinkedHashMap;
    //   526: invokevirtual 599	com/tencent/util/LRULinkedHashMap:clear	()V
    //   529: aload 4
    //   531: monitorexit
    //   532: aload_0
    //   533: invokestatic 604	com/tencent/mobileqq/utils/VasUtils:a	(Lcom/tencent/common/app/AppInterface;)V
    //   536: aload 6
    //   538: ldc_w 606
    //   541: invokevirtual 528	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   544: astore_0
    //   545: aload_0
    //   546: ifnull +111 -> 657
    //   549: aload_0
    //   550: ldc_w 608
    //   553: iconst_0
    //   554: invokevirtual 610	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: iconst_1
    //   558: if_icmpne +146 -> 704
    //   561: iconst_1
    //   562: istore_3
    //   563: iload_3
    //   564: putstatic 614	com/tencent/mobileqq/app/SignatureManager:b	Z
    //   567: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq -554 -> 16
    //   573: ldc_w 616
    //   576: iconst_2
    //   577: new 159	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 618
    //   587: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: getstatic 614	com/tencent/mobileqq/app/SignatureManager:b	Z
    //   593: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: return
    //   603: astore_0
    //   604: ldc 157
    //   606: iconst_1
    //   607: ldc_w 620
    //   610: aload_0
    //   611: invokestatic 623	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   614: return
    //   615: aconst_null
    //   616: astore 4
    //   618: goto -538 -> 80
    //   621: iconst_m1
    //   622: istore_2
    //   623: goto +45 -> 668
    //   626: ldc 43
    //   628: astore 4
    //   630: goto -471 -> 159
    //   633: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq -128 -> 508
    //   639: ldc 157
    //   641: iconst_2
    //   642: ldc_w 625
    //   645: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: goto -140 -> 508
    //   651: astore_0
    //   652: aload 4
    //   654: monitorexit
    //   655: aload_0
    //   656: athrow
    //   657: ldc_w 627
    //   660: iconst_1
    //   661: ldc_w 629
    //   664: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   667: return
    //   668: iload_2
    //   669: ifeq -531 -> 138
    //   672: iload_2
    //   673: iconst_2
    //   674: if_icmpne +13 -> 687
    //   677: goto -539 -> 138
    //   680: ldc 43
    //   682: astore 5
    //   684: goto -504 -> 180
    //   687: iload_1
    //   688: iconst_1
    //   689: iadd
    //   690: istore_1
    //   691: goto -596 -> 95
    //   694: iconst_0
    //   695: istore_3
    //   696: goto -417 -> 279
    //   699: iconst_0
    //   700: istore_3
    //   701: goto -398 -> 303
    //   704: iconst_0
    //   705: istore_3
    //   706: goto -143 -> 563
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	709	0	paramQQAppInterface	QQAppInterface
    //   42	649	1	j	int
    //   134	541	2	k	int
    //   278	428	3	bool	boolean
    //   113	570	5	localObject2	Object
    //   9	528	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   24	43	603	java/lang/Exception
    //   47	59	603	java/lang/Exception
    //   59	80	603	java/lang/Exception
    //   85	93	603	java/lang/Exception
    //   95	135	603	java/lang/Exception
    //   138	159	603	java/lang/Exception
    //   159	180	603	java/lang/Exception
    //   180	250	603	java/lang/Exception
    //   250	260	603	java/lang/Exception
    //   265	277	603	java/lang/Exception
    //   279	301	603	java/lang/Exception
    //   303	508	603	java/lang/Exception
    //   508	523	603	java/lang/Exception
    //   532	536	603	java/lang/Exception
    //   536	545	603	java/lang/Exception
    //   549	561	603	java/lang/Exception
    //   563	602	603	java/lang/Exception
    //   633	648	603	java/lang/Exception
    //   655	657	603	java/lang/Exception
    //   657	667	603	java/lang/Exception
    //   523	532	651	finally
    //   652	655	651	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ClubContentJsonTask
 * JD-Core Version:    0.7.0.1
 */