package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xab.SubMsgType0xab.MsgBody;

public class TroopRewardMgr
  implements Manager
{
  public static int b = 1080;
  public static int c = 1920;
  QQAppInterface a;
  
  public TroopRewardMgr(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private MessageForTroopReward a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    MessageForTroopReward localMessageForTroopReward = new MessageForTroopReward();
    localMessageForTroopReward.selfuin = this.a.getCurrentAccountUin();
    localMessageForTroopReward.frienduin = paramString1;
    localMessageForTroopReward.senderuin = this.a.getCurrentAccountUin();
    localMessageForTroopReward.msgUid = MessageUtils.a(paramInt1);
    localMessageForTroopReward.msg = MsgUtils.a(null);
    localMessageForTroopReward.msgtype = -2048;
    localMessageForTroopReward.isread = true;
    localMessageForTroopReward.issend = 1;
    localMessageForTroopReward.istroop = 1;
    localMessageForTroopReward.time = MessageCache.c();
    localMessageForTroopReward.rewardCreateTime = ((int)(System.currentTimeMillis() / 1000L));
    localMessageForTroopReward.rewardMoney = paramInt2;
    localMessageForTroopReward.rewardContent = paramString2;
    localMessageForTroopReward.rewardType = paramInt3;
    localMessageForTroopReward.mediaPath = paramString3;
    localMessageForTroopReward.rewardStatus = 10000;
    localMessageForTroopReward.rewardSeq = localMessageForTroopReward.uniseq;
    localMessageForTroopReward.prewrite();
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "buildTroopRewardMgr success");
    }
    return localMessageForTroopReward;
  }
  
  private String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "PayReward parsePublishableJson jsonObject is null");
      }
      return null;
    }
    int i = -1;
    if (paramJSONObject.has("ec")) {
      i = paramJSONObject.optInt("ec");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PayReward parsePublishableJson errorCode is ");
      localStringBuilder.append(i);
      QLog.d(".troop.troop_reward", 2, localStringBuilder.toString());
    }
    if (i == 0) {
      return paramJSONObject.optString("token_id");
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean)
  {
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("https://qun.qq.com/qunpay/reward/index.html?_wv=1039&_bid=2313&gc=");
    paramQQAppInterface.append(paramString);
    paramQQAppInterface = paramQQAppInterface.toString();
    paramString = new Intent(paramContext, QQBrowserActivity.class);
    paramString.putExtra("url", paramQQAppInterface);
    if (paramBoolean) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("openNewReward:");
      paramContext.append(paramQQAppInterface);
      QLog.d(".troop.troop_reward", 2, paramContext.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0xab.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramMsgBody.uint64_gc.get());
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramMsgBody.uint64_uin.get());
    ((StringBuilder)localObject2).append("");
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = paramMsgBody.string_reward_id.get();
    int i = paramMsgBody.uint32_reward_status.get();
    if (QLog.isColorLevel())
    {
      paramMsgBody = new StringBuilder();
      paramMsgBody.append("onLinePush receive 0x210_0xab: gc=");
      paramMsgBody.append((String)localObject1);
      paramMsgBody.append(", ownerUin=");
      paramMsgBody.append((String)localObject3);
      paramMsgBody.append(", id=");
      paramMsgBody.append((String)localObject2);
      paramMsgBody.append(", status=");
      paramMsgBody.append(i);
      QLog.d(".troop.troop_reward.push", 2, paramMsgBody.toString());
    }
    paramMsgBody = (TroopRewardMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_REWARD_MGR);
    localObject3 = paramMsgBody.a((String)localObject1, (String)localObject2);
    if (localObject3 != null)
    {
      ((MessageForTroopReward)localObject3).rewardStatus = i;
      paramMsgBody.a((MessageForTroopReward)localObject3);
      paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER).notifyUI(TroopOnlinePushObserver.TYPE_NOTIFY_TROOP_REWARD_CHANGE, true, new Object[] { localObject1, localObject2 });
    }
  }
  
  private boolean a(JSONObject paramJSONObject, MessageForTroopReward paramMessageForTroopReward)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "CreateReward parsePublishableJson jsonObject is null");
      }
      return false;
    }
    int i = -1;
    if (paramJSONObject.has("ec")) {
      i = paramJSONObject.optInt("ec");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CreateReward parsePublishableJson errorCode is ");
      localStringBuilder.append(i);
      QLog.d(".troop.troop_reward", 2, localStringBuilder.toString());
    }
    if (i == 0)
    {
      paramMessageForTroopReward.rewardId = paramJSONObject.optString("reward_id");
      paramMessageForTroopReward.resq = new TroopBarShortVideoUploadUtil.ApplyUploadRsp();
      paramMessageForTroopReward.resq.a = paramJSONObject.optString("serverip");
      paramMessageForTroopReward.resq.b = paramJSONObject.optString("serverport");
      paramMessageForTroopReward.resq.c = paramJSONObject.optString("checkkey");
      paramMessageForTroopReward.resq.e = paramJSONObject.optString("uin");
      paramMessageForTroopReward.resq.f = paramJSONObject.optString("vid");
      paramMessageForTroopReward.resq.g = paramJSONObject.optString("fid");
      i = paramJSONObject.optInt("obj_timeout");
      paramMessageForTroopReward.vid = paramMessageForTroopReward.resq.f;
      paramMessageForTroopReward.expiredTimeStamp = ((int)(System.currentTimeMillis() / 1000L) + i);
      return true;
    }
    return false;
  }
  
  public MessageForTroopReward a(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    if (this.a.getMessageProxy(1) == null) {
      return null;
    }
    Object localObject3 = a(paramString1, 1);
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      do
      {
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (MessageRecord)((Iterator)localObject3).next();
        } while (!(localObject1 instanceof MessageForTroopReward));
        localObject1 = (MessageForTroopReward)localObject1;
      } while (!paramString2.equals(((MessageForTroopReward)localObject1).rewardId));
    }
    if (localObject1 == null)
    {
      paramString1 = this.a.getMessageFacade().a(paramString1, 1, new int[] { -2048 }).iterator();
      while (paramString1.hasNext())
      {
        localObject2 = (MessageRecord)paramString1.next();
        if ((localObject2 instanceof MessageForTroopReward))
        {
          localObject2 = (MessageForTroopReward)localObject2;
          ((MessageForTroopReward)localObject2).parse();
          if (paramString2.equals(((MessageForTroopReward)localObject2).rewardId)) {
            return localObject2;
          }
        }
      }
    }
    return localObject1;
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt)
  {
    MsgPool localMsgPool = this.a.getMessageProxy(0).a();
    Lock localLock = localMsgPool.a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = (List)localMsgPool.b().get(b(paramString, paramInt));
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void a(MessageForTroopReward paramMessageForTroopReward)
  {
    if (paramMessageForTroopReward != null)
    {
      paramMessageForTroopReward.prewrite();
      this.a.getMessageFacade().a(paramMessageForTroopReward.frienduin, 1, paramMessageForTroopReward.uniseq, paramMessageForTroopReward.msgData);
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.troop_reward", 2, "insertAIOMsg troop uin empty");
      }
      return;
    }
    paramString1 = a(paramString1, Math.abs(new Random().nextInt()), paramInt1, paramString2, paramString3, paramInt2);
    this.a.getMessageFacade().a(paramString1, this.a.getCurrentAccountUin());
  }
  
  protected String b(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardMgr
 * JD-Core Version:    0.7.0.1
 */