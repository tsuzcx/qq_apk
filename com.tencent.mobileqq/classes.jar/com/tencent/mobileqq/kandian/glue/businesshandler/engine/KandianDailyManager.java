package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotification;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class KandianDailyManager
  implements Manager
{
  public static final String a = HardCodeUtil.a(2131903864);
  QQAppInterface b;
  KandianDailyManager.DailySetTopInfo c;
  KandianRedDotInfo d;
  IReadInJoyUserInfoModule.RefreshUserInfoCallBack e = new KandianDailyManager.2(this);
  
  public KandianDailyManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    paramQQAppInterface = RIJSPUtils.a(paramQQAppInterface, "readinjoy_daily_settop_info_key", true);
    if ((paramQQAppInterface instanceof KandianDailyManager.DailySetTopInfo))
    {
      this.c = ((KandianDailyManager.DailySetTopInfo)paramQQAppInterface);
      return;
    }
    this.c = new KandianDailyManager.DailySetTopInfo();
  }
  
  private MessageRecord a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
    localMessageForStructing.msgtype = -2011;
    localMessageForStructing.structingMsg = StructMsgFactory.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 142;
    localMessageForStructing.structingMsg.mMsgBrief = paramString2;
    localMessageForStructing.structingMsg.mOrangeWord = paramString1;
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("puinName", paramString3);
      localMessageForStructing.structingMsg.mExtraData = paramString1.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    localMessageForStructing.selfuin = this.b.getCurrentUin();
    localMessageForStructing.frienduin = AppConstants.KANDIAN_DAILY_UIN;
    localMessageForStructing.senderuin = AppConstants.KANDIAN_DAILY_UIN;
    localMessageForStructing.istroop = 1008;
    localMessageForStructing.issend = 0;
    localMessageForStructing.isread = true;
    localMessageForStructing.extLong = 0;
    localMessageForStructing.time = paramLong;
    localMessageForStructing.createMessageUniseq();
    localMessageForStructing.saveExtInfoToExtStr("puin", paramString4);
    localMessageForStructing.doPrewrite();
    return localMessageForStructing;
  }
  
  public static String a(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {
      return a;
    }
    if (!paramMessageForStructing.mIsParsed) {
      paramMessageForStructing.parse();
    }
    if ((paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mExtraData))) {
      try
      {
        paramMessageForStructing = new JSONObject(paramMessageForStructing.structingMsg.mExtraData).optString("puinName", a);
        return paramMessageForStructing;
      }
      catch (JSONException paramMessageForStructing)
      {
        paramMessageForStructing.printStackTrace();
        return a;
      }
    }
    return a;
  }
  
  private static String e()
  {
    MessageRecord localMessageRecord = ((QQAppInterface)ReadInJoyUtils.b()).getMessageFacade().r(AppConstants.KANDIAN_DAILY_UIN, 1008);
    if ((localMessageRecord instanceof MessageForStructing)) {
      return a((MessageForStructing)localMessageRecord);
    }
    return a;
  }
  
  public void a()
  {
    if (this.c != null) {
      ThreadManager.executeOnSubThread(new KandianDailyManager.1(this));
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramMessageRecord.frienduin = AppConstants.KANDIAN_DAILY_UIN;
    b(paramMessageRecord);
    this.d = RIJKanDianRedDotUtils.a(paramMessageRecord, "kandian_daily_red_pnt");
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("receive lock screen msg : ");
    paramMessageRecord.append(this.d);
    QLog.d("KandianDailyManager", 1, paramMessageRecord.toString());
    ThreadManager.post(new KandianDailyManager.3(this), 8, null, false);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = ReadinjoyReportUtils.a(paramAbsBaseArticleInfo, this.e);
    if (paramAbsBaseArticleInfo.msgBoxBriefPreFixType == 2) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.msgBoxBriefPreFix;
    } else {
      paramAbsBaseArticleInfo = null;
    }
    paramAbsBaseArticleInfo = a("", str, e(), NetConnInfoCenter.getServerTime(), paramAbsBaseArticleInfo);
    RIJMergeKanDianMessage.a(AppConstants.KANDIAN_DAILY_UIN, this.b);
    this.b.getMessageFacade().a(paramAbsBaseArticleInfo, this.b.getCurrentUin());
  }
  
  public MessageRecord b()
  {
    MessageRecord localMessageRecord = this.b.getMessageFacade().r(AppConstants.KANDIAN_DAILY_UIN, 1008);
    if (RIJPushNotification.a(localMessageRecord)) {
      return localMessageRecord;
    }
    return null;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    if (!(paramMessageRecord instanceof MessageForStructing))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramMessageRecord.msgtype);
      ((StringBuilder)localObject1).append(", msg : ");
      ((StringBuilder)localObject1).append(paramMessageRecord);
      QLog.e("KandianDailyManager", 1, new Object[] { "receive new msg but not struct msg. type : ", ((StringBuilder)localObject1).toString() });
      return;
    }
    paramMessageRecord = (MessageForStructing)paramMessageRecord;
    if (!paramMessageRecord.mIsParsed) {
      paramMessageRecord.parse();
    }
    if (paramMessageRecord != null) {}
    try
    {
      if (paramMessageRecord.structingMsg != null)
      {
        Object localObject2 = new JSONObject(paramMessageRecord.structingMsg.mExtraData);
        localObject1 = ((JSONObject)localObject2).optString("cmd", "");
        String str = ((JSONObject)localObject2).optString("refreshMode", "");
        localObject2 = ((JSONObject)localObject2).optString("channelID", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ReadInJoyHelper.j((String)localObject1);
        }
        if (!TextUtils.isEmpty(str)) {
          RIJSPUtils.a("readinjoy_daily_mode_refresh_mode", str);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("channelId: ");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("KandianDailyManager", 1, ((StringBuilder)localObject1).toString());
          RIJSPUtils.a("readinjoy_daily_mode_channel_id", Integer.valueOf((String)localObject2));
        }
      }
    }
    catch (Exception localException)
    {
      label219:
      break label219;
    }
    if (paramMessageRecord.structingMsg != null)
    {
      localObject1 = new StringBuilder("receive new msg : ");
      ((StringBuilder)localObject1).append("orange : ");
      ((StringBuilder)localObject1).append(paramMessageRecord.structingMsg.mOrangeWord);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append("brief  : ");
      ((StringBuilder)localObject1).append(paramMessageRecord.structingMsg.mMsgBrief);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append("actionData : ");
      ((StringBuilder)localObject1).append(paramMessageRecord.structingMsg.mMsgActionData);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append("extraData : ");
      ((StringBuilder)localObject1).append(paramMessageRecord.structingMsg.mExtraData);
      QLog.d("KandianDailyManager", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public KandianRedDotInfo c()
  {
    return RIJKanDianRedDotUtils.a(this.b.getMessageFacade().r(AppConstants.KANDIAN_DAILY_UIN, 1008), "kandian_daily_red_pnt");
  }
  
  public KandianRedDotInfo d()
  {
    KandianRedDotInfo localKandianRedDotInfo = this.d;
    this.d = null;
    return localKandianRedDotInfo;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager
 * JD-Core Version:    0.7.0.1
 */