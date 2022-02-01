package com.tencent.mobileqq.kandian.repo.reddot;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.feeds.entity.DailyFloatingWindowData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJKanDianRedDotUtils
{
  public static MessageRecord a(byte[] paramArrayOfByte, String paramString)
  {
    MessageForStructing localMessageForStructing = new MessageForStructing();
    localMessageForStructing.msgData = paramArrayOfByte;
    localMessageForStructing.parse();
    if ((TextUtils.equals(paramString, "kandian_dt_red_dot_info")) || (TextUtils.equals(paramString, "kandian_red_pnt_lock_screen"))) {
      localMessageForStructing.extInt = 1;
    }
    return localMessageForStructing;
  }
  
  public static KandianRedDotInfo a(MessageRecord paramMessageRecord, String paramString)
  {
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      return null;
    }
    Object localObject1 = (MessageForStructing)paramMessageRecord;
    ((MessageForStructing)localObject1).parse();
    if (((MessageForStructing)localObject1).structingMsg == null) {
      return null;
    }
    KandianRedDotInfo localKandianRedDotInfo = new KandianRedDotInfo(paramString);
    localKandianRedDotInfo.cookie = ((MessageForStructing)localObject1).structingMsg.mMsgActionData;
    localKandianRedDotInfo.forderStatus = ((MessageForStructing)localObject1).structingMsg.reportEventFolderStatusValue;
    localKandianRedDotInfo.extInfo = ((MessageForStructing)localObject1).structingMsg.mExtraData;
    localKandianRedDotInfo.msgData = paramMessageRecord.msgData;
    try
    {
      localKandianRedDotInfo.algorithmID = Long.parseLong(((MessageForStructing)localObject1).structingMsg.mAlgorithmIds);
      localKandianRedDotInfo.strategyID = Long.parseLong(((MessageForStructing)localObject1).structingMsg.mStrategyIds);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("createRedDotFromMessageRecord | mr isRead ");
    ((StringBuilder)localObject2).append(paramMessageRecord.isread);
    QLog.d("RIJKanDianRedDotUtils", 1, ((StringBuilder)localObject2).toString());
    if (("kandian_daily_red_pnt".equalsIgnoreCase(paramString)) && (!paramMessageRecord.isread)) {
      try
      {
        paramString = new JSONObject(((MessageForStructing)localObject1).structingMsg.mMsgActionData);
        if (localKandianRedDotInfo.floatingWinData == null) {
          localKandianRedDotInfo.floatingWinData = new DailyFloatingWindowData();
        }
        localObject2 = localKandianRedDotInfo.floatingWinData;
        boolean bool = false;
        ((DailyFloatingWindowData)localObject2).type = paramString.optInt("type", 0);
        localKandianRedDotInfo.floatingWinData.url = paramString.optString("url", "");
        int i = paramString.optInt("remove", 0);
        localObject2 = localKandianRedDotInfo.floatingWinData;
        if (i == 1) {
          bool = true;
        }
        ((DailyFloatingWindowData)localObject2).remove = bool;
        localKandianRedDotInfo.floatingWinData.topicID = paramString.optString("topicID", "");
        localKandianRedDotInfo.rowkey = paramString.optString("push_rowkey", "");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("createRedDotFromMessageRecord | init floatingWindowData  ");
        ((StringBuilder)localObject2).append(localKandianRedDotInfo.floatingWinData.toString());
        QLog.d("RIJKanDianRedDotUtils", 1, ((StringBuilder)localObject2).toString());
        paramString.put("algorithmIds", ((MessageForStructing)localObject1).structingMsg.mAlgorithmIds);
        paramString.put("reportEventFolderStatusValue", ((MessageForStructing)localObject1).structingMsg.reportEventFolderStatusValue);
        paramString.put("strategyIds", ((MessageForStructing)localObject1).structingMsg.mStrategyIds);
        localKandianRedDotInfo.cookie = paramString.toString();
        paramString = new StringBuilder();
        paramString.append("createRedDotFromMessageRecord | origin_actionData is ");
        paramString.append(((MessageForStructing)localObject1).structingMsg.mMsgActionData);
        paramString.append("\n recombined_actionData is ");
        paramString.append(localKandianRedDotInfo.cookie);
        QLog.d("RIJKanDianRedDotUtils", 1, paramString.toString());
      }
      catch (JSONException paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("createRedDotFromMessageRecord | exception ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.d("RIJKanDianRedDotUtils", 2, ((StringBuilder)localObject1).toString());
      }
    }
    paramMessageRecord = a(paramMessageRecord);
    if ((paramMessageRecord != null) && (!paramMessageRecord.isEmpty()))
    {
      paramMessageRecord = paramMessageRecord.iterator();
      while (paramMessageRecord.hasNext())
      {
        paramString = (String)paramMessageRecord.next();
        try
        {
          localKandianRedDotInfo.articleIDList.add(Long.valueOf(paramString));
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return localKandianRedDotInfo;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = (MessageForStructing)a(paramArrayOfByte, paramString);
      if ((paramArrayOfByte.structingMsg != null) && (!TextUtils.isEmpty(paramArrayOfByte.structingMsg.mMsgActionData)))
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.structingMsg.mMsgActionData).optString("push_rowkey", "");
        return paramArrayOfByte;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("RIJKanDianRedDotUtils", 2, paramArrayOfByte, new Object[0]);
    }
    return "";
  }
  
  private static List<String> a(MessageRecord paramMessageRecord)
  {
    boolean bool = paramMessageRecord instanceof MessageForStructing;
    Object localObject1 = null;
    if (!bool) {
      return null;
    }
    Object localObject2 = (MessageForStructing)paramMessageRecord;
    ((MessageForStructing)localObject2).parse();
    paramMessageRecord = localObject1;
    if (((MessageForStructing)localObject2).structingMsg != null)
    {
      if (TextUtils.isEmpty(((MessageForStructing)localObject2).structingMsg.mArticleIds)) {
        return null;
      }
      localObject2 = ((MessageForStructing)localObject2).structingMsg.mArticleIds.split("\\|");
      paramMessageRecord = localObject1;
      if (localObject2.length > 0) {
        paramMessageRecord = Arrays.asList((Object[])localObject2);
      }
    }
    return paramMessageRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils
 * JD-Core Version:    0.7.0.1
 */