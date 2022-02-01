package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.etrump.mixlayout.FontReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--getJsonVersion ,key=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",version:");
      localStringBuilder.append(paramContext.getInt(paramString, 0));
      QLog.d("ClubContentJsonTask", 2, localStringBuilder.toString());
    }
    return paramContext.getInt(paramString, 0);
  }
  
  public static JSONObject a(AppInterface paramAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, boolean paramBoolean)
  {
    Object localObject = paramAppInterface.getApplicationContext();
    String str = paramTaskInfo.jdField_a_of_type_JavaLangString;
    localObject = new File(((Context)localObject).getFilesDir(), str);
    if (((File)localObject).exists())
    {
      try
      {
        paramAppInterface = FileUtils.readFileToStringEx((File)localObject, -1);
      }
      catch (Throwable paramAppInterface)
      {
        paramTaskInfo = new StringBuilder();
        paramTaskInfo.append("getJsonFromLocalFile err,json_name:");
        paramTaskInfo.append(str);
        paramTaskInfo.append(", msg:");
        paramTaskInfo.append(paramAppInterface.getMessage());
        QLog.e("ClubContentJsonTask", 2, paramTaskInfo.toString());
        paramAppInterface = null;
      }
      if (paramAppInterface == null) {
        break label230;
      }
      try
      {
        paramAppInterface = new JSONObject(paramAppInterface);
        return paramAppInterface;
      }
      catch (Throwable paramAppInterface)
      {
        paramTaskInfo = new StringBuilder();
        paramTaskInfo.append("getJsonFromLocalFile new Json err,json_name:");
        paramTaskInfo.append(str);
        paramTaskInfo.append(", msg:");
        paramTaskInfo.append(paramAppInterface.getMessage());
        QLog.e("ClubContentJsonTask", 2, paramTaskInfo.toString());
        ((File)localObject).delete();
        return null;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getJsonFromLocalFile not exist,json_name:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" _ ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.w("ClubContentJsonTask", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean) {
      a(paramAppInterface, paramTaskInfo);
    }
    label230:
    return null;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setJsonVersion ,key=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",version:");
      localStringBuilder.append(paramInt);
      QLog.d("ClubContentJsonTask", 2, localStringBuilder.toString());
    }
    paramContext.getSharedPreferences("clubContentVersion", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    paramAppInterface.getApplication().getApplicationContext();
    int j = 0;
    for (;;)
    {
      ClubContentJsonTask.TaskInfo[] arrayOfTaskInfo = jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo;
      if (j >= arrayOfTaskInfo.length) {
        break;
      }
      a(paramAppInterface, arrayOfTaskInfo[j]);
      j += 1;
    }
  }
  
  public static void a(AppInterface paramAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo)
  {
    if (paramAppInterface != null)
    {
      if (paramTaskInfo == null) {
        return;
      }
      File localFile = new File(paramAppInterface.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.jdField_a_of_type_JavaLangString);
      if (!localFile.exists())
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("downloadIfNotExist, not exist: ");
          ((StringBuilder)localObject).append(paramTaskInfo.jdField_a_of_type_JavaLangString);
          QLog.d("ClubContentJsonTask", 2, ((StringBuilder)localObject).toString());
        }
        int k = 0;
        int j;
        try
        {
          localObject = String.valueOf(NetConnInfoCenter.getServerTime());
          int m = ((String)localObject).length();
          j = 10;
          if (m <= 10) {
            j = ((String)localObject).length();
          }
          localObject = ((String)localObject).substring(0, j);
          j = k;
          if (Long.parseLong((String)localObject) < 2147483647L) {
            j = Integer.parseInt((String)localObject);
          }
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadIfNotExist, Integer.parseInt Err:");
          localStringBuilder.append(localException.getMessage());
          QLog.e("ClubContentJsonTask", 1, localStringBuilder.toString());
          j = k;
        }
        Bundle localBundle = new Bundle();
        localBundle.putInt("version", j);
        localBundle.putString("version_key", paramTaskInfo.d);
        localBundle.putString("method", "downloadIfNotExist");
        localBundle.putString("ifromet", "null1");
        a(paramAppInterface, paramTaskInfo, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).insertMtype("VIP_emosm", paramTaskInfo.jdField_b_of_type_JavaLangString), localFile, localBundle);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, exists.");
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt, boolean paramBoolean)
  {
    Context localContext = paramAppInterface.getApplication().getApplicationContext();
    Bundle localBundle = new Bundle();
    localBundle.putInt("version", paramInt);
    localBundle.putString("version_key", paramTaskInfo.d);
    localBundle.putString("method", "updateJson");
    localBundle.putString("ifromet", String.valueOf(paramBoolean));
    a(paramAppInterface, paramTaskInfo, null, new File(localContext.getFilesDir(), paramTaskInfo.jdField_a_of_type_JavaLangString), localBundle);
  }
  
  public static void a(AppInterface paramAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, String paramString, File paramFile, Bundle paramBundle)
  {
    if (paramFile == null) {
      return;
    }
    String str1 = paramString;
    if ((paramString != null) || (paramTaskInfo != null)) {}
    try
    {
      str1 = paramTaskInfo.jdField_b_of_type_JavaLangString;
      break label35;
      return;
      label35:
      if (paramTaskInfo != null) {
        paramTaskInfo = paramTaskInfo.jdField_a_of_type_JavaLangString;
      } else {
        paramTaskInfo = paramFile.getName();
      }
      String str2 = paramBundle.getString("method");
      paramString = str2;
      if (str2 == null) {
        paramString = "other";
      }
      a(paramAppInterface, str1, paramFile, paramBundle, paramTaskInfo, paramString);
      return;
    }
    finally {}
  }
  
  private static void a(AppInterface paramAppInterface, String paramString1, File paramFile, Bundle paramBundle, String paramString2, String paramString3)
  {
    Object localObject2 = paramBundle.getString("ifromet");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "false";
    }
    boolean bool;
    if (paramBundle.containsKey("forceUpdate")) {
      bool = paramBundle.getBoolean("forceUpdate");
    } else {
      bool = false;
    }
    int j = paramBundle.getInt("version", 0);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(j);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("club_downloadFile,method:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", server version:");
      localStringBuilder.append(j);
      localStringBuilder.append(",ifromet:");
      localStringBuilder.append((String)localObject1);
      QLog.d("ClubContentJsonTask", 2, localStringBuilder.toString());
    }
    if ((bool) || (!jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) || (!((Boolean)jdField_a_of_type_JavaUtilHashMap.get(localObject2)).booleanValue()))
    {
      jdField_a_of_type_JavaUtilHashMap.put(localObject2, Boolean.valueOf(true));
      paramFile = new DownloadTask(paramString1, paramFile);
      paramFile.n = true;
      paramFile.jdField_a_of_type_JavaLangString = paramString2;
      ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1).startDownload(paramFile, jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramBundle);
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append(paramString3);
        paramFile.append(",cdownloadFile url=");
        paramFile.append(paramString1);
        QLog.d("ClubContentJsonTask", 2, paramFile.toString());
      }
      try
      {
        paramString1 = new HashMap();
        paramString1.put("param_key", paramString2);
        paramString1.put("param_ifromet", localObject1);
        StatisticCollector.getInstance(paramAppInterface.getApplication().getApplicationContext()).collectPerformance(paramAppInterface.getAccount(), "VipClubContentJsonTaskLoad", true, 1L, 0L, paramString1, "", false);
        return;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("downloadFile, downloadFile error=");
          paramString1.append(paramAppInterface.toString());
          QLog.i("ClubContentJsonTask", 2, paramString1.toString());
        }
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    int j = 0;
    while (j < paramJSONArray.length())
    {
      Object localObject = (JSONObject)paramJSONArray.get(j);
      int k;
      if (((JSONObject)localObject).has("platformid")) {
        k = ((JSONObject)localObject).getInt("platformid");
      } else {
        k = -1;
      }
      if ((k != 0) && (k != 2))
      {
        j += 1;
      }
      else
      {
        boolean bool = ((JSONObject)localObject).has("masterUrl");
        String str = "";
        if (bool) {
          paramJSONArray = ((JSONObject)localObject).getString("masterUrl");
        } else {
          paramJSONArray = "";
        }
        if (((JSONObject)localObject).has("guestUrl")) {
          str = ((JSONObject)localObject).getString("guestUrl");
        }
        localObject = jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo;
        ((ClubContentJsonTask.PersonalCardUrlInfo)localObject).jdField_a_of_type_JavaLangString = paramJSONArray;
        ((ClubContentJsonTask.PersonalCardUrlInfo)localObject).jdField_b_of_type_JavaLangString = str;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("personalcardurlInfo : platformId = ");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(";masterUrl = ");
          ((StringBuilder)localObject).append(paramJSONArray);
          ((StringBuilder)localObject).append(";guestUrl = ");
          ((StringBuilder)localObject).append(str);
          QLog.d("ClubContentJsonTask", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("hiBoomConfig");
    if (localObject != null) {
      ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).setHiBoomMaxSize(((JSONObject)localObject).optInt("androidViewMaxSize", 300));
    }
    localObject = paramJSONObject.optJSONObject("FounderFontReport");
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null)
    {
      int j = ((JSONObject)localObject).optInt("maxIndex");
      if (j > 0) {
        FontReportUtils.jdField_a_of_type_Int = new Random().nextInt(j) + 1;
      }
      FontReportUtils.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(((JSONObject)localObject).optInt("reportInteval"));
      AtomicBoolean localAtomicBoolean = FontReportUtils.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (((JSONObject)localObject).optInt("reportEnable") == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localAtomicBoolean.set(bool1);
    }
    paramJSONObject = paramJSONObject.optJSONObject("ColorNickConfig");
    if (paramJSONObject != null)
    {
      localObject = (IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class);
      bool1 = bool2;
      if (paramJSONObject.optInt("enable") == 1) {
        bool1 = true;
      }
      ((IVasCommonAdapter)localObject).setColorNickEnabke(bool1);
    }
  }
  
  public static void b(AppInterface paramAppInterface)
  {
    Object localObject = null;
    boolean bool2 = false;
    JSONObject localJSONObject = VasUpdateUtil.a(paramAppInterface, "vip_personal_card.json", false, null);
    if (localJSONObject == null) {
      return;
    }
    FontManagerConstants.magicFontConfigInited.set(false);
    for (;;)
    {
      try
      {
        jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PersonalCardUrlInfo = new ClubContentJsonTask.PersonalCardUrlInfo();
        int j = localJSONObject.optInt("frequency");
        if (j != 0) {
          VasUserData.a(paramAppInterface, "ticketInterval", Integer.toString(j));
        }
        if (localJSONObject.has("vipPersonalCard")) {
          localObject = localJSONObject.getJSONArray("vipPersonalCard");
        }
        if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
          a((JSONArray)localObject);
        }
        localObject = localJSONObject.optJSONObject("magicFont");
        if (localObject != null)
        {
          if (((JSONObject)localObject).optInt("enable") == 1)
          {
            bool1 = true;
            FontManagerConstants.magicFontEnable = bool1;
            if (FontManagerConstants.magicFontEnable)
            {
              bool1 = bool2;
              if (((JSONObject)localObject).optInt("changeRuleOneWordEnable") == 1) {
                bool1 = true;
              }
              FontManagerConstants.magicFontOneWordEnable = bool1;
              FontManagerConstants.magicFontSize1Number = (float)((JSONObject)localObject).optDouble("changeRuleFontSize1");
              FontManagerConstants.magicFontSize2Number = (float)((JSONObject)localObject).optDouble("changeRuleFontSize2");
              FontManagerConstants.magicFontNormalSize1 = (float)((JSONObject)localObject).optDouble("fontSizeNormal1");
              FontManagerConstants.magicFontNormalSize2 = (float)((JSONObject)localObject).optDouble("fontSizeNormal2");
              FontManagerConstants.magicFontMaxSize1 = (float)((JSONObject)localObject).optDouble("fontSizeMax1");
              FontManagerConstants.magicFontMaxSize2 = (float)((JSONObject)localObject).optDouble("fontSizeMax2");
              FontManagerConstants.magicFontGroupSize = ((JSONObject)localObject).optInt("groupSize");
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("parseMagicFontConfig oneWordEnable = ");
                ((StringBuilder)localObject).append(FontManagerConstants.magicFontOneWordEnable);
                ((StringBuilder)localObject).append(" magicFontSize1Number = ");
                ((StringBuilder)localObject).append(FontManagerConstants.magicFontSize1Number);
                ((StringBuilder)localObject).append(" magicFontSize2Number = ");
                ((StringBuilder)localObject).append(FontManagerConstants.magicFontSize2Number);
                ((StringBuilder)localObject).append(" magicFontNormalSize1 = ");
                ((StringBuilder)localObject).append(FontManagerConstants.magicFontNormalSize1);
                ((StringBuilder)localObject).append(" magicFontNormalSize2 = ");
                ((StringBuilder)localObject).append(FontManagerConstants.magicFontNormalSize2);
                ((StringBuilder)localObject).append(" magicFontMaxSize1 = ");
                ((StringBuilder)localObject).append(FontManagerConstants.magicFontMaxSize1);
                ((StringBuilder)localObject).append(" magicFontMaxSize2 = ");
                ((StringBuilder)localObject).append(FontManagerConstants.magicFontMaxSize2);
                ((StringBuilder)localObject).append(" magicFontGroupSize = ");
                ((StringBuilder)localObject).append(FontManagerConstants.magicFontGroupSize);
                QLog.d("ClubContentJsonTask", 2, ((StringBuilder)localObject).toString());
              }
            }
            else
            {
              QLog.d("ClubContentJsonTask", 2, "parseMagicFontConfig enable = false");
            }
            FontManagerConstants.magicFontConfigInited.set(true);
            ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).clearMagicFontCache(paramAppInterface);
          }
        }
        else
        {
          b(localJSONObject);
          a(localJSONObject);
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        QLog.e("ClubContentJsonTask", 1, "getPersonalCardUrlInfo error: ", paramAppInterface);
        return;
      }
      boolean bool1 = false;
    }
  }
  
  private static void b(DownloadTask paramDownloadTask, Bundle paramBundle, AppRuntime paramAppRuntime)
  {
    String str = paramBundle.getString("version_key");
    boolean bool2 = false;
    if (str != null) {
      a(MobileQQ.sMobileQQ.getApplicationContext(), str, paramBundle.getInt("version", 0));
    }
    if ((paramDownloadTask.jdField_a_of_type_JavaLangString != null) && (paramAppRuntime != null))
    {
      if (c.jdField_a_of_type_JavaLangString.equals(paramDownloadTask.jdField_a_of_type_JavaLangString))
      {
        paramDownloadTask = c;
        paramDownloadTask.jdField_a_of_type_OrgJsonJSONObject = null;
        paramDownloadTask.a(paramAppRuntime.getApplication());
        return;
      }
      if (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(f.jdField_a_of_type_JavaLangString))
      {
        ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).resolveFunnyPicJson(paramAppRuntime);
        return;
      }
      if (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(jdField_b_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(h.jdField_a_of_type_JavaLangString))
      {
        ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).parseURLJson(paramAppRuntime);
        return;
      }
      if (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(d.jdField_a_of_type_JavaLangString))
      {
        paramDownloadTask = d;
        paramDownloadTask.jdField_a_of_type_OrgJsonJSONObject = null;
        paramDownloadTask.a(paramAppRuntime.getApplication());
        return;
      }
      if (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(i.jdField_a_of_type_JavaLangString)) {
        paramDownloadTask = (IFontManagerService)paramAppRuntime.getRuntimeService(IFontManagerService.class, "");
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("jsonDownloadListener, app == null:");
      if (paramAppRuntime == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramBundle.append(bool1);
      paramBundle.append(",key == null:");
      boolean bool1 = bool2;
      if (paramDownloadTask.jdField_a_of_type_JavaLangString == null) {
        bool1 = true;
      }
      paramBundle.append(bool1);
      QLog.e("ClubContentJsonTask", 2, paramBundle.toString());
    }
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("diySignatureConfig");
    boolean bool = true;
    if (paramJSONObject != null)
    {
      Object localObject = (IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class);
      if (paramJSONObject.optInt("diySignatureEnable", 0) != 1) {
        bool = false;
      }
      ((IVasCommonAdapter)localObject).setSignatureEnable(bool);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("diySigEnable = ");
        ((StringBuilder)localObject).append(paramJSONObject.optInt("diySignatureEnable", 0));
        QLog.d("DiySignature", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      QLog.e("Signature", 1, "no diy signature config");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ClubContentJsonTask
 * JD-Core Version:    0.7.0.1
 */