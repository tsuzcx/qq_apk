package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp;
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

public class TroopRewardMgr
  implements Manager
{
  public static int a;
  public static int b = 1920;
  QQAppInterface a;
  
  static
  {
    jdField_a_of_type_Int = 1080;
  }
  
  public TroopRewardMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private MessageForTroopReward a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    MessageForTroopReward localMessageForTroopReward = new MessageForTroopReward();
    localMessageForTroopReward.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForTroopReward.frienduin = paramString1;
    localMessageForTroopReward.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForTroopReward.msgUid = MessageUtils.a(paramInt1);
    localMessageForTroopReward.msg = MsgUtils.a(null);
    localMessageForTroopReward.msgtype = -2048;
    localMessageForTroopReward.isread = true;
    localMessageForTroopReward.issend = 1;
    localMessageForTroopReward.istroop = 1;
    localMessageForTroopReward.time = MessageCache.a();
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
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "PayReward parsePublishableJson errorCode is " + i);
    }
    if (i == 0) {
      return paramJSONObject.optString("token_id");
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean)
  {
    paramQQAppInterface = "https://qun.qq.com/qunpay/reward/index.html?_wv=1039&_bid=2313&gc=" + paramString;
    paramString = new Intent(paramContext, QQBrowserActivity.class);
    paramString.putExtra("url", paramQQAppInterface);
    if (paramBoolean) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "openNewReward:" + paramQQAppInterface);
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
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "CreateReward parsePublishableJson errorCode is " + i);
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
      paramMessageForTroopReward.expiredTimeStamp = (i + (int)(System.currentTimeMillis() / 1000L));
      return true;
    }
    return false;
  }
  
  public MessageForTroopReward a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1) == null) {
      return null;
    }
    Object localObject1 = a(paramString1, 1);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof MessageForTroopReward)) || (!paramString2.equals(((MessageForTroopReward)localObject2).rewardId)));
    }
    for (localObject1 = (MessageForTroopReward)localObject2;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, 1, new int[] { -2048 }).iterator();
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
  }
  
  protected String a(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt)
  {
    MsgPool localMsgPool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).a();
    Lock localLock = localMsgPool.a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = (List)localMsgPool.b().get(a(paramString, paramInt));
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageForTroopReward.frienduin, 1, paramMessageForTroopReward.uniseq, paramMessageForTroopReward.msgData);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardMgr
 * JD-Core Version:    0.7.0.1
 */