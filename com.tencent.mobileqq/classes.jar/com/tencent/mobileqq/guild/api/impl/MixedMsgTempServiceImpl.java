package com.tencent.mobileqq.guild.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IMixedMsgTempService;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler.MixMsgParams;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler.MixMsgParams.PicInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoItem;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MixedMsgTempServiceImpl
  implements IMixedMsgTempService
{
  public static final String TAG = "MixedMsgTempServiceImpl";
  AppRuntime app;
  
  private MessageForMixedMsg constructMixedMr(List<MessageRecord> paramList, ArrayList<AtTroopMemberInfo> paramArrayList, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgTempServiceImpl", 2, "constructMixedMr, input elemList is null, return...");
      }
      return null;
    }
    Object localObject1 = paramArrayList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((AtTroopMemberInfo)((Iterator)localObject1).next()).isResvAttr = true;
    }
    localObject1 = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
    Object localObject2 = (MessageRecord)paramList.get(0);
    ((MessageRecord)localObject2).longMsgId = 0;
    MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, (MessageRecord)localObject2);
    if ((paramSourceMsgInfo != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramSourceMsgInfo = new JSONObject();
      try
      {
        localObject2 = new JSONArray();
        int i = 0;
        while (i < paramArrayList.size())
        {
          ((JSONArray)localObject2).put(i, ((AtTroopMemberInfo)paramArrayList.get(i)).toJsonObject());
          i += 1;
        }
        paramSourceMsgInfo.put("0", localObject2);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("MixedMsgTempServiceImpl", 1, localJSONException, new Object[0]);
      }
      AtTroopMemberSpan.a(paramInt, paramSourceMsgInfo.toString(), (ChatMessage)localObject1);
    }
    ((MessageForMixedMsg)localObject1).uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    ((MessageForMixedMsg)localObject1).issend = 1;
    ((MessageForMixedMsg)localObject1).msgtype = -1035;
    ((MessageForMixedMsg)localObject1).extraflag = 32772;
    ((MessageForMixedMsg)localObject1).msgElemList = paramList;
    ((MessageForMixedMsg)localObject1).mRobotFlag = -1;
    ((MessageForMixedMsg)localObject1).atInfoList = paramArrayList;
    ((MessageForMixedMsg)localObject1).prewrite();
    return localObject1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void sendTextPicsMixedMsg(AppInterface paramAppInterface, IGuildSendMessageHandler.MixMsgParams paramMixMsgParams, boolean paramBoolean)
  {
    MixedMsgManager localMixedMsgManager = (MixedMsgManager)paramAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
    MixedMsgInfo localMixedMsgInfo = new MixedMsgInfo();
    localMixedMsgInfo.a(new MixedMsgInfo.TextMsgNode(paramMixMsgParams.d));
    Object localObject = paramMixMsgParams.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      IGuildSendMessageHandler.MixMsgParams.PicInfo localPicInfo = (IGuildSendMessageHandler.MixMsgParams.PicInfo)((Iterator)localObject).next();
      localMixedMsgInfo.a(new MixedMsgInfo.PhotoMsgNode(new MixedMsgInfo.PhotoItem(localPicInfo.a, localPicInfo.b)));
    }
    localObject = new HashMap();
    localMixedMsgManager.a(constructMixedMr(MixedMsgManager.a((QQAppInterface)paramAppInterface, paramMixMsgParams.e, localMixedMsgInfo, null, paramMixMsgParams.c, 10014, (Map)localObject), paramMixMsgParams.e, null, 10014), paramMixMsgParams.e, paramMixMsgParams.c, (Map)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.MixedMsgTempServiceImpl
 * JD-Core Version:    0.7.0.1
 */