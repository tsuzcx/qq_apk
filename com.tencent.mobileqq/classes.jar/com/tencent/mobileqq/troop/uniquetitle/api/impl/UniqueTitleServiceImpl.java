package com.tencent.mobileqq.troop.uniquetitle.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;

public class UniqueTitleServiceImpl
  implements IUniqueTitleService
{
  protected static final String OLDEST_UNIQUE_TITLE_EXPIRE_TIME = "oldestUniqueTitleExpireTime";
  public static final String TAG = "UniqueTitleServiceImpl";
  protected AppRuntime mApp;
  
  public long getOldestUniqueTitleExpireTime(String paramString)
  {
    BaseApplication localBaseApplication = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getLong("oldestUniqueTitleExpireTime", 0L);
  }
  
  public void getTroopMemberUniqueTitle(String paramString, long paramLong1, long paramLong2, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_0x787.Filter localFilter = new oidb_0x787.Filter();
    localFilter.uint32_special_title.set(0);
    localFilter.uint32_nick_name.set(0);
    localFilter.uint32_member_level_info_name.set(0);
    localFilter.uint32_member_level_info_uin.set(0);
    oidb_0x787.ReqBody localReqBody = new oidb_0x787.ReqBody();
    localReqBody.uint64_group_code.set(Long.parseLong(paramString));
    localReqBody.uint64_begin_uin.set(paramLong1);
    localReqBody.uint64_data_time.set(paramLong2);
    localReqBody.opt_filter.set(localFilter);
    ProtoUtils.b(this.mApp, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x787_1", 1927, 1);
  }
  
  public int getUniqueTitleNewFlag()
  {
    BaseApplication localBaseApplication = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    localStringBuilder.append("_troopManager");
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt("uniqueTitleNewFlag", 0);
  }
  
  public boolean hasUniqueTitleExpireNotified(String paramString1, String paramString2)
  {
    BaseApplication localBaseApplication = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(paramString2, false);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void saveTroopMemberUniqueTitle(String paramString1, String paramString2, String paramString3)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo2 = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null)
    {
      localTroopMemberInfo1 = new TroopMemberInfo();
      localTroopMemberInfo1.memberuin = paramString2;
      localTroopMemberInfo1.troopuin = paramString1;
    }
    if ((paramString3 != null) && (!TextUtils.equals(paramString3, localTroopMemberInfo1.mUniqueTitle)))
    {
      localTroopMemberInfo1.mUniqueTitle = paramString3;
      if (localTroopMemberInfo1.getStatus() == 1000) {
        localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo1);
      }
      localITroopMemberInfoService.saveTroopMemberInfoToDB(paramString1, paramString2, localTroopMemberInfo1);
    }
  }
  
  public void saveTroopMemberUniqueTitle(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo2 = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null)
    {
      localTroopMemberInfo1 = new TroopMemberInfo();
      localTroopMemberInfo1.memberuin = paramString2;
      localTroopMemberInfo1.troopuin = paramString1;
    }
    localTroopMemberInfo1.mUniqueTitle = paramString3;
    localTroopMemberInfo1.mUniqueTitleExpire = paramInt;
    paramString3 = this.mApp.getEntityManagerFactory().createEntityManager();
    if (localTroopMemberInfo1.getStatus() == 1000)
    {
      localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo1);
      paramString3.persistOrReplace(localTroopMemberInfo1);
    }
    else
    {
      paramString3.update(localTroopMemberInfo1);
    }
    paramString3.close();
    setUniqueTitleExpireNotified(paramString1, paramString2, false);
  }
  
  public void saveTroopMemberUniqueTitle(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo2 = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null)
    {
      localTroopMemberInfo1 = new TroopMemberInfo();
      localTroopMemberInfo1.memberuin = paramString2;
      localTroopMemberInfo1.troopuin = paramString1;
    }
    int j = 0;
    int i = j;
    if (paramString3 != null)
    {
      i = j;
      if (!TextUtils.equals(paramString3, localTroopMemberInfo1.mUniqueTitle))
      {
        localTroopMemberInfo1.mUniqueTitle = paramString3;
        i = 1;
      }
    }
    j = i;
    if (paramInt1 != 0)
    {
      j = i;
      if (localTroopMemberInfo1.realLevel != paramInt1)
      {
        localTroopMemberInfo1.realLevel = paramInt1;
        j = 1;
      }
    }
    if (localTroopMemberInfo1.newRealLevel != paramInt2)
    {
      localTroopMemberInfo1.newRealLevel = paramInt2;
      j = 1;
    }
    if (j != 0)
    {
      if (localTroopMemberInfo1.getStatus() == 1000) {
        localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo1);
      }
      localITroopMemberInfoService.saveTroopMemberInfoToDB(paramString1, paramString2, localTroopMemberInfo1);
    }
  }
  
  public void saveTroopMemeberUniqueTitleAndExpire(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo2 = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null)
    {
      localTroopMemberInfo1 = new TroopMemberInfo();
      localTroopMemberInfo1.memberuin = paramString2;
      localTroopMemberInfo1.troopuin = paramString1;
    }
    if ((paramString3 != null) && (!TextUtils.equals(paramString3, localTroopMemberInfo1.mUniqueTitle)))
    {
      localTroopMemberInfo1.mUniqueTitle = paramString3;
      localTroopMemberInfo1.mUniqueTitleExpire = paramInt;
      if (localTroopMemberInfo1.getStatus() == 1000) {
        localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo1);
      }
      localITroopMemberInfoService.saveTroopMemberInfoToDB(paramString1, paramString2, localTroopMemberInfo1);
    }
  }
  
  public void setOldestUniqueTitleExpireTime(String paramString, long paramLong)
  {
    BaseApplication localBaseApplication = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong("oldestUniqueTitleExpireTime", paramLong).commit();
  }
  
  public void setUniqueTitleExpireNotified(String paramString1, String paramString2, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(paramString2, paramBoolean).commit();
  }
  
  public void setUniqueTitleNewFlag(int paramInt)
  {
    BaseApplication localBaseApplication = this.mApp.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    localStringBuilder.append("_troopManager");
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("uniqueTitleNewFlag", paramInt).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.uniquetitle.api.impl.UniqueTitleServiceImpl
 * JD-Core Version:    0.7.0.1
 */