package com.tencent.mobileqq.kandian.biz.reddot;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class KandianSubscribeReportUtils
{
  private static Map<String, String> a = new HashMap();
  
  static
  {
    b();
  }
  
  public static void a()
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getMessageFacade().r(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    if ((localObject != null) && (!((MessageRecord)localObject).isread))
    {
      if (((MessageRecord)localObject).extLong != 1) {
        return;
      }
      ThreadManager.post(new KandianSubscribeReportUtils.1((MessageRecord)localObject), 8, null, false);
      a("0X80093FF", (MessageRecord)localObject);
      b();
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    a("0X8009400", paramMessageRecord);
  }
  
  private static void a(String paramString, MessageRecord paramMessageRecord)
  {
    String str1 = b(paramMessageRecord);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getPubAccountRecentUserPosInMessageList(AppConstants.KANDIAN_SUBSCRIBE_UIN));
    ((StringBuilder)localObject1).append("");
    String str2 = ((StringBuilder)localObject1).toString();
    KandianRedDotInfo localKandianRedDotInfo = RIJKanDianRedDotUtils.a(paramMessageRecord, "kandian_dt_red_dot_info");
    int j = 0;
    Object localObject5 = null;
    Object localObject2 = null;
    Object localObject3;
    Object localObject4;
    if (localKandianRedDotInfo != null)
    {
      localObject1 = localObject2;
      if (localKandianRedDotInfo.articleIDList != null)
      {
        localObject1 = localObject2;
        if (!localKandianRedDotInfo.articleIDList.isEmpty())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localKandianRedDotInfo.articleIDList.get(0));
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localKandianRedDotInfo.strategyID);
      ((StringBuilder)localObject2).append("");
      localObject3 = ((StringBuilder)localObject2).toString();
      localObject4 = localKandianRedDotInfo.forderStatus;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localKandianRedDotInfo.algorithmID);
      ((StringBuilder)localObject2).append("");
      localObject5 = ((StringBuilder)localObject2).toString();
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
    }
    else
    {
      localObject4 = null;
      localObject1 = localObject4;
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = localObject5;
    }
    localObject5 = localObject1;
    if ("0X8009400".equals(paramString))
    {
      localObject5 = localObject1;
      if (paramMessageRecord.isread) {
        localObject5 = "0";
      }
    }
    int i;
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).caculateMsgTabRedPntExcludeSelf(AppConstants.KANDIAN_SUBSCRIBE_UIN) > 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = "1".equals(paramMessageRecord.getExtInfoFromExtStr("public_account_msg_unread_flag"));
    paramMessageRecord = new JSONObject();
    for (;;)
    {
      try
      {
        paramMessageRecord.put("folder_status", localObject5);
        paramMessageRecord.put("message_status", i);
        paramMessageRecord.put("algorithm_id", localObject4);
        paramMessageRecord.put("reddot_style", bool ^ true);
        paramMessageRecord.put("os", "1");
        if (!TextUtils.isEmpty(str1)) {
          break label428;
        }
        i = j;
        paramMessageRecord.put("avatar", i);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      PublicAccountReportUtils.a(null, "CliOper", "", str1, paramString, paramString, 0, 0, str2, (String)localObject2, (String)localObject3, paramMessageRecord.toString(), false);
      return;
      label428:
      i = 1;
    }
  }
  
  private static String b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      if (!(paramMessageRecord instanceof MessageForStructing)) {
        return null;
      }
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
      if (paramMessageRecord.structingMsg != null)
      {
        if (TextUtils.isEmpty(paramMessageRecord.structingMsg.mExtraData)) {
          return null;
        }
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord.structingMsg.mExtraData).optString("uin", "");
          return paramMessageRecord;
        }
        catch (JSONException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static void b()
  {
    Map localMap = e();
    if (localMap != null)
    {
      a = localMap;
      QLog.d(KandianSubscribeReportUtils.class.getSimpleName(), 2, "update kandian subscribe red pnt info success ");
    }
  }
  
  public static String c()
  {
    String str2 = (String)a.get("folder_status");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    else
    {
      str1 = "1";
    }
    return str1;
  }
  
  public static Map<String, String> d()
  {
    return a;
  }
  
  private static Map<String, String> e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("folder_status", "1");
    localHashMap.put("algorithm_id", "0");
    localHashMap.put("strategy_id", "0");
    localHashMap.put("action_data", "");
    Object localObject = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject == null) {
      return localHashMap;
    }
    localObject = ((QQAppInterface)localObject).getMessageFacade();
    if (localObject == null) {
      return localHashMap;
    }
    localObject = ((QQMessageFacade)localObject).r(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    if (localObject == null) {
      return localHashMap;
    }
    if (((MessageRecord)localObject).isread) {
      return localHashMap;
    }
    if ((localObject instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)localObject;
      if (!((MessageForStructing)localObject).mIsParsed) {
        ((MessageForStructing)localObject).parse();
      }
      if (((MessageForStructing)localObject).structingMsg == null) {
        return localHashMap;
      }
      localHashMap.put("folder_status", ((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
      localHashMap.put("algorithm_id", ((MessageForStructing)localObject).structingMsg.mAlgorithmIds);
      localHashMap.put("strategy_id", ((MessageForStructing)localObject).structingMsg.mStrategyIds);
      localHashMap.put("action_data", ((MessageForStructing)localObject).structingMsg.mMsgAction);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.KandianSubscribeReportUtils
 * JD-Core Version:    0.7.0.1
 */