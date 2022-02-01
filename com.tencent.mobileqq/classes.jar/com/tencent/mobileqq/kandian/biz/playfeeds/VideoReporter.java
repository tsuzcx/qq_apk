package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.VideoSessionUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.RIJSoSoUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoReporterConstants;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoReporter
  implements VideoReporterConstants
{
  public static String a = "8.8.17".replace(".", "");
  public static int b;
  public static HashMap<Class<?>, String> c = new HashMap();
  
  public static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 7) {
          return 0;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public static int a(int paramInt, String paramString)
  {
    if (((paramInt == 2) || (paramInt == 3)) && (!TextUtils.isEmpty(paramString))) {
      return paramString.hashCode();
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int j = 2;
    int i;
    if (paramInt == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      i = j;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.g(paramString);
        i = j;
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.wMemberNum;
        }
      }
    }
    else
    {
      i = j;
      if (paramInt == 3000)
      {
        paramQQAppInterface = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        i = j;
        if (paramQQAppInterface != null) {
          i = paramQQAppInterface.c(paramString);
        }
      }
    }
    return i;
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return -1;
    }
    if (paramAbsBaseArticleInfo.videoJumpChannelID > 0) {
      return paramAbsBaseArticleInfo.videoJumpChannelID;
    }
    if (ReadInJoyHelper.j(BaseApplicationImpl.getApplication().getRuntime()) == 1) {
      return 56;
    }
    return 409409;
  }
  
  public static Bundle a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static String a()
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    if (i == 1) {
      return "0";
    }
    if ((i != 3) && (i != 4)) {
      return "2";
    }
    return "1";
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      localJSONObject.put("jump_to_channel", paramInt);
      localJSONObject.put("video_session_id", paramString1);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
  
  public static String a(int paramInt, JSONObject paramJSONObject)
  {
    return a(null, null, null, null, paramInt, paramJSONObject);
  }
  
  public static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("download", paramString);
      a(localJSONObject, 2);
      paramString = b(localJSONObject);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, JSONObject paramJSONObject)
  {
    return a(null, null, paramString1, paramString2, paramInt, paramJSONObject);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channel_id", paramInt);
      label28:
      return a(paramString1, paramString2, paramString3, paramString4, localJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      break label28;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("video_duration", paramLong2);
      label28:
      return a(paramString1, paramString2, paramString3, paramString4, paramLong1, localJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      break label28;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("current_duration", paramLong);
      label28:
      return a(paramString1, paramString2, paramString3, paramString4, localJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      break label28;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      b(paramString1, paramString2, paramString3, paramString4, localJSONObject);
      if (paramJSONObject != null)
      {
        paramString1 = paramJSONObject.keys();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          localJSONObject.put(paramString2, paramJSONObject.getString(paramString2));
        }
      }
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static JSONObject a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
        paramJSONObject = RIJSoSoUtils.a();
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.mLocation;
          double d1 = 0.0D;
          if (paramJSONObject == null) {
            break label160;
          }
          d1 = paramJSONObject.mLon02;
          d2 = paramJSONObject.mLat02;
          localJSONObject.put("longitude", d1);
          localJSONObject.put("latitude", d2);
          if (localContext != null)
          {
            paramJSONObject = RIJNetworkUtils.a(localContext);
            localJSONObject.put("wifi_ssid", RIJNetworkUtils.b(localContext));
            localJSONObject.put("wifi_mac", paramJSONObject);
          }
          localJSONObject.put("imei", RIJDeviceUtil.a());
          localJSONObject.put("imsi", RIJDeviceUtil.b());
          localJSONObject.put("androidid", DeviceInfoUtil.j());
          return localJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localJSONObject;
      }
      paramJSONObject = null;
      continue;
      label160:
      double d2 = 0.0D;
    }
  }
  
  public static JSONObject a(JSONObject paramJSONObject, int paramInt)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("oper_time", System.currentTimeMillis());
      localJSONObject.put("company_id", paramInt);
      return localJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData, int paramInt7, String paramString2, String paramString3)
  {
    ThreadManager.post(new VideoReporter.1(paramInt1, paramLong, paramString1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramVideoExtraRepoerData, paramInt7, paramString2, paramString3), 5, null, true);
  }
  
  public static void a(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData, int paramInt5, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
    localReportInfo.mSource = 0;
    if (paramInt1 == 56) {
      localReportInfo.mOpSource = 11;
    } else {
      localReportInfo.mOpSource = 0;
    }
    localReportInfo.mSourceArticleId = paramLong1;
    localReportInfo.mInnerId = paramString1;
    localReportInfo.mChannelId = paramInt1;
    localReportInfo.mAlgorithmId = paramInt2;
    localReportInfo.mStrategyId = paramInt3;
    localReportInfo.mOperation = paramInt4;
    localReportInfo.mPlayTimeLength = ((int)paramLong2);
    localReportInfo.mVideoExtraRepoerData = paramVideoExtraRepoerData;
    localReportInfo.mColumnID = paramInt5;
    localReportInfo.videoReportInfo = paramString2;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("reportVideoUserOperationByOidbOfFeed--mUin:");
      paramString2.append(localReportInfo.mUin);
      paramString2.append("; mSourceArticleId:");
      paramString2.append(localReportInfo.mSourceArticleId);
      paramString2.append("; mSource:");
      paramString2.append(localReportInfo.mSource);
      paramString2.append("; mOpSource:");
      paramString2.append(localReportInfo.mOpSource);
      paramString2.append("; mInnerId:");
      paramString2.append(localReportInfo.mInnerId);
      paramString2.append("; mChannelId:");
      paramString2.append(localReportInfo.mChannelId);
      paramString2.append("; mAlgorithmId:");
      paramString2.append(localReportInfo.mAlgorithmId);
      paramString2.append("; mStrategyId:");
      paramString2.append(localReportInfo.mStrategyId);
      paramString2.append("; mOperation:");
      paramString2.append(localReportInfo.mOperation);
      paramString2.append("; mPlayTimeLength:");
      paramString2.append(localReportInfo.mPlayTimeLength);
      paramString2.append("; mColumnID:");
      paramString2.append(localReportInfo.mColumnID);
      paramString2.append("; videoReportInfo:");
      paramString2.append(localReportInfo.videoReportInfo);
      paramString2.append("; videoExtraRepoerData:");
      if (paramVideoExtraRepoerData != null) {
        paramString1 = paramVideoExtraRepoerData.toString();
      } else {
        paramString1 = "null";
      }
      paramString2.append(paramString1);
      QLog.d("VideoReporter", 2, paramString2.toString());
    }
    localArrayList.add(localReportInfo);
    UserOperationModule.getInstance().request0x64eUserOperationReport(localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    ThreadManager.executeOnSubThread(new VideoReporter.2(paramInt1, paramQQAppInterface, paramString, paramInt2, paramLong));
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    ThreadManager.executeOnSubThread(new VideoReporter.3(paramMessageRecord));
  }
  
  public static void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData, String paramString)
  {
    long l = paramVideoInfo.u;
    String str = paramVideoInfo.l;
    int j = (int)paramVideoInfo.ah;
    int k = paramVideoInfo.ai;
    int i;
    if (paramVideoInfo.ay != null) {
      i = paramVideoInfo.ay.b;
    } else {
      i = -1;
    }
    a(18, l, str, paramInt1, j, k, paramInt2, paramInt3, paramVideoExtraRepoerData, i, paramVideoInfo.ao, paramString);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, long paramLong, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData)
  {
    long l = paramAbsBaseArticleInfo.mArticleID;
    String str = paramAbsBaseArticleInfo.innerUniqueID;
    int j = (int)paramAbsBaseArticleInfo.mAlgorithmID;
    int k = paramAbsBaseArticleInfo.mStrategyId;
    int i;
    if (paramAbsBaseArticleInfo.mVideoColumnInfo != null) {
      i = paramAbsBaseArticleInfo.mVideoColumnInfo.b;
    } else {
      i = -1;
    }
    a(l, str, paramInt1, j, k, paramInt2, paramLong, paramVideoExtraRepoerData, i, paramAbsBaseArticleInfo.videoReportInfo);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    String str;
    if (paramInt1 == 1008) {
      str = "1";
    } else {
      str = "";
    }
    if (paramInt1 == 0) {
      str = "2";
    }
    for (;;)
    {
      break;
      if (paramInt1 == 1) {
        str = "3";
      } else if (paramInt1 == 3000) {
        str = "4";
      }
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", paramString1, paramString1, 0, 0, str, Integer.toString(paramInt2), paramString3, paramString2, false);
  }
  
  public static String b()
  {
    return VideoSessionUtils.a();
  }
  
  public static String b(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("jump_to_channel", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static String b(JSONObject paramJSONObject)
  {
    return a(null, null, null, null, paramJSONObject);
  }
  
  public static void b(VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData, String paramString)
  {
    long l = paramVideoInfo.u;
    String str = paramVideoInfo.l;
    int j = (int)paramVideoInfo.ah;
    int k = paramVideoInfo.ai;
    int i;
    if (paramVideoInfo.ay != null) {
      i = paramVideoInfo.ay.b;
    } else {
      i = -1;
    }
    a(5, l, str, paramInt1, j, k, paramInt2, paramInt3, paramVideoExtraRepoerData, i, paramVideoInfo.ao, paramString);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject)
  {
    String str = "1";
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramJSONObject.put("md5", paramString1);
        }
        else
        {
          paramJSONObject.put("aid", paramString4);
          paramJSONObject.put("rowkey", paramString4);
          paramJSONObject.put("article_id", paramString4);
          paramJSONObject.put("vid", paramString3);
          paramJSONObject.put("puin", paramString2);
        }
        paramJSONObject.put("network_type", a());
        paramJSONObject.put("os", "1");
        if (a == null) {
          a = "8.8.17".replace(".", "");
        }
        paramJSONObject.put("version", a);
        paramJSONObject.put("imei", RIJDeviceUtil.a());
        paramJSONObject.put("imsi", RIJDeviceUtil.b());
        paramJSONObject.put("kandian_mode_new", c());
        paramJSONObject.put("kandian_mode", RIJAppSetting.b());
        paramJSONObject.put("report_timestamp", System.currentTimeMillis());
        if (CUKingCardUtils.a() != 1) {
          break label280;
        }
        paramString1 = str;
        paramJSONObject.put("simCardType", paramString1);
        paramJSONObject.put("diandianfeeds_type", RecommendFeedsDiandianEntranceManager.getInstance().getEntryFeedsType());
        if (!RIJTransMergeKanDianReport.b) {
          break label286;
        }
        i = 1;
        paramJSONObject.put("from_aio", i);
        paramJSONObject.put("model", DeviceInfoUtil.f());
      }
      catch (JSONException paramString1)
      {
        QLog.e("VideoReporter", 1, "addBaseInfoR5", paramString1);
      }
      a(paramJSONObject);
      return;
      label280:
      paramString1 = "0";
      continue;
      label286:
      int i = 0;
    }
  }
  
  public static int c()
  {
    boolean bool1 = RIJShowKanDianTabSp.c();
    boolean bool2 = ReadInJoyHelper.v();
    if (!bool1) {
      return 0;
    }
    if (bool2) {
      return 3;
    }
    if (RIJXTabConfigHandler.INSTANCE.isXTabMode()) {
      return 4;
    }
    return 1;
  }
  
  public static String d()
  {
    return b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter
 * JD-Core Version:    0.7.0.1
 */