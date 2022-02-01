package com.tencent.mobileqq.kandian.biz.push;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJLockScreenPushReport
{
  private static String a(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData)) {
      paramString = new JSONObject(paramMessageForStructing.structingMsg.mMsgActionData).optString("push_rowkey");
    }
    return paramString;
  }
  
  public static void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if (localQQAppInterface == null) {
      return;
    }
    a(((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).e());
  }
  
  private static void a(Intent paramIntent, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg.mExtraData != null) {
      paramIntent.putExtra("arg_channel_cover_id", Integer.parseInt(new JSONObject(paramMessageForStructing.structingMsg.mExtraData).optString("channel_id", "0")));
    }
  }
  
  private static void a(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      JSONObject localJSONObject;
      if (!TextUtils.isEmpty(paramMessageRecord.extStr)) {
        localJSONObject = new JSONObject(paramMessageRecord.extStr);
      } else {
        localJSONObject = new JSONObject();
      }
      localJSONObject.put("sp_last_locksc_kadnian_red_pnt_exposure_time_key", NetConnInfoCenter.getServerTime());
      paramMessageRecord.extStr = localJSONObject.toString();
      paramQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
    }
  }
  
  public static void a(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, Intent paramIntent)
  {
    try
    {
      a(paramQQMessageFacade, paramMessageRecord);
      localMessageForStructing = new MessageForStructing(paramMessageRecord);
      if (localMessageForStructing.structingMsg == null) {
        localMessageForStructing.parse();
      }
      int i = localMessageForStructing.extInt;
      localObject2 = "0";
      str2 = "";
      if (i == 1)
      {
        paramQQMessageFacade = d("", localMessageForStructing);
        str1 = c("0", localMessageForStructing);
        str2 = b("", localMessageForStructing);
        a(paramIntent, localMessageForStructing);
        localObject2 = a("", localMessageForStructing);
        localObject1 = localMessageForStructing.structingMsg.reportEventFolderStatusValue;
        paramIntent = paramQQMessageFacade;
        paramQQMessageFacade = (QQMessageFacade)localObject2;
      }
      else
      {
        if (paramMessageRecord.extInt != 5) {
          break label350;
        }
        str1 = "0";
        paramQQMessageFacade = "";
        localObject1 = paramQQMessageFacade;
        paramIntent = (Intent)localObject2;
      }
    }
    catch (JSONException paramQQMessageFacade)
    {
      MessageForStructing localMessageForStructing;
      Object localObject2;
      String str2;
      break label332;
    }
    catch (NumberFormatException paramQQMessageFacade)
    {
      for (;;)
      {
        label332:
        continue;
        label350:
        String str1 = "0";
        paramQQMessageFacade = "";
        paramIntent = paramQQMessageFacade;
        Object localObject1 = paramIntent;
      }
    }
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("algorithm_id", str2);
    ((JSONObject)localObject2).put("rowkey", paramQQMessageFacade);
    ((JSONObject)localObject2).put("folder_status", localObject1);
    ((JSONObject)localObject2).put("report_time", NetConnInfoCenter.getServerTimeMillis());
    a(paramMessageRecord, localMessageForStructing, (JSONObject)localObject2);
    PublicAccountReportUtils.a(null, "CliOper", "", paramMessageRecord.senderuin, "0X80081DC", "0X80081DC", 0, 0, "", paramIntent, str1, ((JSONObject)localObject2).toString(), false);
    ReadinjoySPEventReport.a(40, Integer.parseInt((String)localObject1), Integer.parseInt(str2), Integer.parseInt(str1));
    paramQQMessageFacade = new ReportInfo();
    paramQQMessageFacade.mUin = RIJQQAppInterfaceUtil.c();
    paramQQMessageFacade.mSourceArticleId = new BigInteger(paramIntent).longValue();
    paramQQMessageFacade.mAlgorithmId = Integer.parseInt(str2);
    paramQQMessageFacade.mStrategyId = Integer.parseInt(str1);
    paramQQMessageFacade.mOperation = 54;
    paramQQMessageFacade.mFolderStatus = Integer.parseInt((String)localObject1);
    paramMessageRecord = new ArrayList();
    paramMessageRecord.add(paramQQMessageFacade);
    ReadInJoyLogicEngine.a().a(paramMessageRecord);
    return;
    QLog.d("RIJLockScreenPushReport", 1, "reportForLockScreenExposure number format error");
    return;
    QLog.d("RIJLockScreenPushReport", 1, "reportForLockScreenExposure parse json error");
  }
  
  private static void a(MessageRecord paramMessageRecord, MessageForStructing paramMessageForStructing, JSONObject paramJSONObject)
  {
    if (!paramMessageRecord.isread)
    {
      String str = paramMessageRecord.senderuin;
      JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
      paramMessageRecord = str;
      if (localJSONObject.has("kdUin")) {
        paramMessageRecord = localJSONObject.getString("kdUin");
      }
      paramJSONObject.put("feeds_source", paramMessageRecord);
      if (paramMessageForStructing.structingMsg != null)
      {
        paramJSONObject.put("load_mode", RIJKanDianTabReport.b(paramMessageForStructing.structingMsg.mExtraData));
        paramJSONObject.put("push_type", RIJKanDianTabReport.c(paramMessageForStructing.structingMsg.mExtraData));
        paramJSONObject.put("landing_type", b(paramMessageForStructing));
      }
    }
  }
  
  public static void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo != null) {
      try
      {
        if (paramKandianRedDotInfo.hasArticleID())
        {
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("algorithm_id", paramKandianRedDotInfo.algorithmID);
          Object localObject2 = (MessageForStructing)paramKandianRedDotInfo.getMessageRecord();
          if ((localObject2 != null) && (((MessageForStructing)localObject2).structingMsg != null))
          {
            ((JSONObject)localObject1).put("rowkey", paramKandianRedDotInfo.getRowKey());
            ((JSONObject)localObject1).put("load_mode", RIJKanDianTabReport.b(((MessageForStructing)localObject2).structingMsg.mExtraData));
            ((JSONObject)localObject1).put("push_type", RIJKanDianTabReport.c(((MessageForStructing)localObject2).structingMsg.mExtraData));
            ((JSONObject)localObject1).put("landing_type", b(paramKandianRedDotInfo.getMessageRecord()));
          }
          ((JSONObject)localObject1).put("folder_status", paramKandianRedDotInfo.forderStatus);
          ((JSONObject)localObject1).put("report_time", NetConnInfoCenter.getServerTimeMillis());
          ((JSONObject)localObject1).put("articleID", paramKandianRedDotInfo.articleIDList.get(0));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramKandianRedDotInfo.articleIDList.get(0));
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramKandianRedDotInfo.strategyID);
          localStringBuilder.append("");
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80081DB", "0X80081DB", 0, 0, "", (String)localObject2, localStringBuilder.toString(), ((JSONObject)localObject1).toString(), false);
          ReadinjoySPEventReport.a(41, Integer.parseInt(paramKandianRedDotInfo.forderStatus), (int)paramKandianRedDotInfo.algorithmID, (int)paramKandianRedDotInfo.strategyID);
          localObject1 = new ReportInfo();
          ((ReportInfo)localObject1).mUin = RIJQQAppInterfaceUtil.c();
          ((ReportInfo)localObject1).mSourceArticleId = ((Long)paramKandianRedDotInfo.articleIDList.get(0)).longValue();
          ((ReportInfo)localObject1).mAlgorithmId = ((int)paramKandianRedDotInfo.algorithmID);
          ((ReportInfo)localObject1).mStrategyId = ((int)paramKandianRedDotInfo.strategyID);
          ((ReportInfo)localObject1).mOperation = 55;
          ((ReportInfo)localObject1).mFolderStatus = Integer.parseInt(paramKandianRedDotInfo.forderStatus);
          paramKandianRedDotInfo = new ArrayList();
          paramKandianRedDotInfo.add(localObject1);
          ReadInJoyLogicEngine.a().a(paramKandianRedDotInfo);
          return;
        }
      }
      catch (Exception paramKandianRedDotInfo)
      {
        QLog.e("RIJLockScreenPushReport", 1, paramKandianRedDotInfo, new Object[0]);
      }
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return b(paramMessageRecord) == 1;
  }
  
  public static int b(MessageRecord paramMessageRecord)
  {
    j = 1;
    if (paramMessageRecord == null) {
      return 1;
    }
    i = j;
    Object localObject;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)paramMessageRecord;
      i = j;
      if (((MessageForStructing)localObject).structingMsg != null) {
        localObject = ((MessageForStructing)localObject).structingMsg.mExtraData;
      }
    }
    try
    {
      i = new JSONObject((String)localObject).optInt("sceneType", 1);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isDailyLockScreen, ret=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", mr=");
      ((StringBuilder)localObject).append(paramMessageRecord);
      QLog.d("RIJLockScreenPushReport", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  private static String b(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg.mAlgorithmIds != null) {
      paramString = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
    }
    return paramString;
  }
  
  private static String c(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg.mStrategyIds != null) {
      paramString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
    }
    return paramString;
  }
  
  private static String d(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mArticleIds)) {
      paramString = paramMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJLockScreenPushReport
 * JD-Core Version:    0.7.0.1
 */