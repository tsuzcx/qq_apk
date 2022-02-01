package com.tencent.mobileqq.troop.api.impl;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.TroopMemberCardConstants;
import com.tencent.mobileqq.troop.data.HWTroopMemberCard;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.ReqBody;

public class BizTroopMemberInfoServiceImpl
  implements IBizTroopMemberInfoService
{
  public static final String TAG = "BizTroopMemberInfoServiceImpl";
  protected EntityManager em;
  protected AppRuntime mApp;
  protected LruCache<String, HWTroopMemberCard> mHWTroopMemberCardCache = new LruCache(50);
  protected LruCache<BizTroopMemberInfoServiceImpl.TroopMemberLevelValue, Drawable> mMemberLevelColorCache = new LruCache(10);
  protected LruCache<String, TroopMemberCard> mTroopMemberCardCache = new LruCache(50);
  
  public void asynSaveHomeworkTroopMemberIdentity(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    ThreadManager.post(new BizTroopMemberInfoServiceImpl.1(this, paramString1, paramString2, paramString3, paramInt, paramString4, paramString5), 8, null, false);
  }
  
  public boolean getCalendarNoticeTroopMember(String paramString1, String paramString2, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0x6ef.ReqBody localReqBody = new oidb_cmd0x6ef.ReqBody();
    localReqBody.gc.set(Long.parseLong(paramString1));
    localReqBody.event_id.set(paramString2);
    localReqBody.seq.set(paramLong);
    ProtoUtils.b(this.mApp, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x6ef_0", 1775, 0);
    return false;
  }
  
  public HWTroopMemberCard getHWTroopMemberCard(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    return (HWTroopMemberCard)this.mHWTroopMemberCardCache.get(paramString1);
  }
  
  public MessageRecord getRobotLastSpeakMessage(String paramString1, String paramString2)
  {
    Object localObject1 = TroopMemberCardConstants.a;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      int j = TroopMemberCardConstants.a.length;
      if (j > 0)
      {
        localObject1 = new StringBuilder();
        int i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject1).append(TroopMemberCardConstants.a[i]);
          if (i < j - 1) {
            ((StringBuilder)localObject1).append(" , ");
          }
          i += 1;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        break label88;
      }
    }
    localObject1 = null;
    label88:
    EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    paramString2 = localEntityManager.query(MessageRecord.class, MessageRecord.getTableName(paramString1, 1), false, String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype in (%s)", new Object[] { Long.valueOf(9223372036854775807L), localObject1 }), new String[] { paramString2 }, null, null, "shmsgseq DESC", String.valueOf(1));
    localEntityManager.close();
    paramString1 = localObject2;
    if (paramString2 != null)
    {
      if (paramString2.isEmpty()) {
        return null;
      }
      paramString1 = (MessageRecord)paramString2.get(0);
    }
    return paramString1;
  }
  
  public TroopMemberCard getTroopMemberCard(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    return (TroopMemberCard)this.mTroopMemberCardCache.get(paramString1);
  }
  
  public double getTroopMemberDiatanceToSelf(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    double d = -100.0D;
    if ((!bool) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = ((ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
      if (paramString1 != null) {
        d = paramString1.distanceToSelf;
      }
      return d;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopMemberDistance", 2, "getTroopMemberDiatanceToSelf, uin is null");
    }
    return -100.0D;
  }
  
  public Drawable getTroopMemberLevelDrawable(int paramInt, String paramString)
  {
    BizTroopMemberInfoServiceImpl.TroopMemberLevelValue localTroopMemberLevelValue = new BizTroopMemberInfoServiceImpl.TroopMemberLevelValue(this);
    localTroopMemberLevelValue.a = paramInt;
    localTroopMemberLevelValue.b = paramString;
    return (Drawable)this.mMemberLevelColorCache.get(localTroopMemberLevelValue);
  }
  
  public String getTroopMemberNickNoEmpty(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject1 = ((ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) {
          localObject1 = ((TroopMemberInfo)localObject1).troopnick;
        } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick)) {
          localObject1 = ((TroopMemberInfo)localObject1).friendnick;
        } else {
          localObject1 = paramString2;
        }
      }
      else {
        localObject1 = "";
      }
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).equals(paramString2))
        {
          paramString1 = ((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString1);
          localObject2 = localObject1;
          if (paramString1 != null)
          {
            localObject2 = localObject1;
            if (paramString1.isQidianPrivateTroop()) {
              localObject2 = TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
            }
          }
        }
      }
      return localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BizTroopMemberInfoServiceImpl", 2, "getTroopMemberNick uin is null");
    }
    return "";
  }
  
  public void handleAgreeJion(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.post(new BizTroopMemberInfoServiceImpl.2(this, paramString1, paramString2, paramString3), 8, null, true);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.em = this.mApp.getEntityManagerFactory().createEntityManager();
  }
  
  public void onDestroy() {}
  
  public void saveHWTroopMemberCard(String paramString1, String paramString2, HWTroopMemberCard paramHWTroopMemberCard)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramHWTroopMemberCard != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      this.mHWTroopMemberCardCache.put(paramString1, paramHWTroopMemberCard);
    }
  }
  
  public void saveHomeworkTroopMemberIdentity(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BizTroopMemberInfoServiceImpl", 2, "saveHomeworkTroopMemberIdentity , info is null ... ");
      }
      return;
    }
    TroopMemberCardInfo localTroopMemberCardInfo = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.mApp, paramString1, paramString2);
    int i = 0;
    int j = 0;
    if (paramInt != -100)
    {
      i = j;
      if (paramInt != localTroopMemberInfo.hwIdentity)
      {
        localTroopMemberInfo.hwIdentity = paramInt;
        i = 1;
      }
      if (paramInt != localTroopMemberInfo.level)
      {
        localTroopMemberInfo.level = paramInt;
        if ((localTroopMemberCardInfo != null) && (!TextUtils.equals(String.valueOf(paramInt), localTroopMemberCardInfo.level))) {
          localTroopMemberCardInfo.level = String.valueOf(paramInt);
        }
        i = 1;
      }
    }
    paramInt = i;
    if (!TextUtils.isEmpty(paramString4))
    {
      paramInt = i;
      if (!paramString4.equals(localTroopMemberInfo.hwCourse))
      {
        localTroopMemberInfo.hwCourse = paramString4;
        paramInt = 1;
      }
    }
    i = paramInt;
    if (!TextUtils.isEmpty(paramString5))
    {
      i = paramInt;
      if (!paramString5.equals(localTroopMemberInfo.hwName))
      {
        localTroopMemberInfo.hwName = paramString5;
        i = 1;
      }
    }
    paramInt = i;
    if (paramString3 != null)
    {
      paramInt = i;
      if (!paramString3.equals(localTroopMemberInfo.troopnick))
      {
        localTroopMemberInfo.troopnick = paramString3;
        if ((localTroopMemberCardInfo != null) && (!TextUtils.equals(paramString3, localTroopMemberCardInfo.name))) {
          localTroopMemberCardInfo.name = paramString3;
        }
        paramInt = 1;
      }
    }
    if (paramInt != 0)
    {
      if (localTroopMemberInfo.getStatus() == 1000) {
        localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo);
      }
      paramString1 = this.mApp.getEntityManagerFactory().createEntityManager();
      if (localTroopMemberInfo.getStatus() == 1000)
      {
        paramString1.persistOrReplace(localTroopMemberInfo);
        if (localTroopMemberCardInfo != null) {
          paramString1.persistOrReplace(localTroopMemberCardInfo);
        }
      }
      else
      {
        paramString1.update(localTroopMemberInfo);
        if (localTroopMemberCardInfo != null) {
          paramString1.update(localTroopMemberCardInfo);
        }
      }
      paramString1.close();
    }
  }
  
  public boolean saveTroopMemberGlamourLevel(String paramString1, String paramString2, int paramInt)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    int i;
    if (localTroopMemberInfo == null)
    {
      localTroopMemberInfo = new TroopMemberInfo();
      localTroopMemberInfo.troopuin = paramString1;
      localTroopMemberInfo.memberuin = paramString2;
      localTroopMemberInfo.isTroopFollowed = false;
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (paramInt > 0)
    {
      j = i;
      if (paramInt != localTroopMemberInfo.mGlamourLevel)
      {
        localTroopMemberInfo.mGlamourLevel = paramInt;
        j = 1;
      }
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveTroopMemberEx ,");
      ((StringBuilder)localObject).append(localTroopMemberInfo.toString());
      QLog.d("BizTroopMemberInfoServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (j != 0)
    {
      localObject = this.mApp.getEntityManagerFactory().createEntityManager();
      if (localTroopMemberInfo.getStatus() == 1000)
      {
        localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo);
        ((EntityManager)localObject).persistOrReplace(localTroopMemberInfo);
      }
      else
      {
        ((EntityManager)localObject).update(localTroopMemberInfo);
      }
      ((EntityManager)localObject).close();
      localITroopMemberInfoService.notifyChangeMember(paramString1, paramString2);
      return true;
    }
    return false;
  }
  
  public boolean saveTroopMemberHotChatGlamourLevel(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    int j;
    if (localTroopMemberInfo == null)
    {
      localTroopMemberInfo = new TroopMemberInfo();
      localTroopMemberInfo.troopuin = paramString1;
      localTroopMemberInfo.memberuin = paramString2;
      localTroopMemberInfo.isTroopFollowed = false;
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i = j;
    if (paramInt1 >= 0)
    {
      i = j;
      if (paramInt1 != localTroopMemberInfo.hotChatGlamourLevel)
      {
        localTroopMemberInfo.hotChatGlamourLevel = paramInt1;
        i = 1;
      }
    }
    paramInt1 = i;
    if (paramInt2 >= 0)
    {
      paramInt1 = i;
      if (paramInt2 != localTroopMemberInfo.globalTroopLevel)
      {
        localTroopMemberInfo.globalTroopLevel = paramInt2;
        paramInt1 = 1;
      }
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveTroopMemberHotChatGlamourLevel ,");
      ((StringBuilder)localObject).append(localTroopMemberInfo.toString());
      QLog.d("BizTroopMemberInfoServiceImpl.troop.memberCard", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 != 0)
    {
      localObject = this.mApp.getEntityManagerFactory().createEntityManager();
      if (localTroopMemberInfo.getStatus() == 1000)
      {
        localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo);
        ((EntityManager)localObject).persistOrReplace(localTroopMemberInfo);
      }
      else
      {
        ((EntityManager)localObject).update(localTroopMemberInfo);
      }
      ((EntityManager)localObject).close();
      ((ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "")).notifyChangeMember(paramString1, paramString2);
      return true;
    }
    return false;
  }
  
  public void saveTroopMemberLevelDrawable(int paramInt, String paramString, Drawable paramDrawable)
  {
    BizTroopMemberInfoServiceImpl.TroopMemberLevelValue localTroopMemberLevelValue = new BizTroopMemberInfoServiceImpl.TroopMemberLevelValue(this);
    localTroopMemberLevelValue.a = paramInt;
    localTroopMemberLevelValue.b = paramString;
    this.mMemberLevelColorCache.put(localTroopMemberLevelValue, paramDrawable);
  }
  
  public boolean saveTroopMemberSpearkFlag(String paramString1, String paramString2, byte paramByte)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    if (localTroopMemberInfo == null) {
      return false;
    }
    if (paramByte != -100)
    {
      localTroopMemberInfo.isTroopFollowed = false;
      localTroopMemberInfo.mIsShielded = false;
      if (paramByte == 1) {
        localTroopMemberInfo.isTroopFollowed = true;
      } else if (paramByte == 2) {
        localTroopMemberInfo.mIsShielded = true;
      }
      paramByte = 1;
    }
    else
    {
      paramByte = 0;
    }
    if (paramByte != 0)
    {
      EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
      if (localTroopMemberInfo.getStatus() == 1000)
      {
        localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo);
        localEntityManager.persistOrReplace(localTroopMemberInfo);
      }
      else
      {
        localEntityManager.update(localTroopMemberInfo);
      }
      localEntityManager.close();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.BizTroopMemberInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */