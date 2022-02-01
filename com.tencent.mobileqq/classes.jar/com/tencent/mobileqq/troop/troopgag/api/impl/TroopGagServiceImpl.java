package com.tencent.mobileqq.troop.troopgag.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.troopgag.data.MemberGagInfo;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.util.api.ITroopMemberInfoUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopGagServiceImpl
  implements ITroopGagService
{
  public static final String TAG = "TroopGagServiceImpl";
  protected EntityManager em;
  protected AppRuntime mApp;
  
  private String gagTimeToStringCountDown(Context paramContext, long paramLong)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (paramLong <= l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagServiceImpl", 4, String.format("error: gagTimeToStringCountDown gagTime <= currentTimeMs", new Object[0]));
      }
      return "";
    }
    return remainingTimeToStringCountDown(paramContext, paramLong - l, paramLong);
  }
  
  private boolean isAdmin(String paramString)
  {
    Object localObject = ((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    if (localObject == null) {
      return false;
    }
    paramString = this.mApp.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) && (paramString.equals(((TroopInfo)localObject).troopowneruin))) {
      return true;
    }
    if (!TextUtils.isEmpty(((TroopInfo)localObject).Administrator))
    {
      localObject = ((TroopInfo)localObject).Administrator.split("\\|");
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].equalsIgnoreCase(paramString)) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private String remainingTimeToStringCountDown(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject = this.mApp.getApplication().getApplicationContext();
    paramContext = ((Context)localObject).getString(2131895191);
    String str1 = ((Context)localObject).getString(2131895190);
    localObject = ((Context)localObject).getString(2131895189);
    String str2 = HardCodeUtil.a(2131912658);
    if (paramLong1 < 60L) {
      return String.format(str2, new Object[] { Integer.valueOf(1), paramContext });
    }
    if (paramLong1 <= 3540L) {
      return String.format(str2, new Object[] { Long.valueOf((paramLong1 + 57L) / 60L), paramContext });
    }
    if (paramLong1 <= 84600L) {
      return String.format(str2, new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 3600.0F)), str1 });
    }
    return String.format(str2, new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 86400.0F)), localObject });
  }
  
  public SelfGagInfo getSelfGagInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagServiceImpl", 2, String.format("fightgag.getSelfGagInfo240:sUin=%s,", new Object[] { paramString }));
    }
    TroopInfo localTroopInfo = ((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
    if (localTroopInfo == null) {
      return new SelfGagInfo(paramString, false, "", 0L);
    }
    long l = NetConnInfoCenter.getServerTime();
    boolean bool = isAdmin(paramString);
    if ((localTroopInfo.dwGagTimeStamp != 0L) && (!bool))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagServiceImpl", 4, String.format("getTroopGagInfo:sUin=%s, Troop Gag", new Object[] { paramString }));
      }
      return new SelfGagInfo(paramString, true, this.mApp.getApplication().getApplicationContext().getString(2131895004), 60L);
    }
    if ((localTroopInfo.dwGagTimeStamp_me != 0L) && (l < localTroopInfo.dwGagTimeStamp_me + 3L))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fightgag.getSelfGagInfo:sUin= ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",dwGagTimeStamp_me = ");
      ((StringBuilder)localObject).append(localTroopInfo.dwGagTimeStamp_me);
      ((StringBuilder)localObject).append(",lCutTimeStamp  = ");
      ((StringBuilder)localObject).append(l);
      QLog.d("TroopGagServiceImpl", 1, ((StringBuilder)localObject).toString());
      localObject = this.mApp.getApplication().getApplicationContext();
      String str = ((Context)localObject).getString(2131895521);
      l = localTroopInfo.dwGagTimeStamp_me + 3L;
      if (paramBoolean) {
        l = localTroopInfo.dwGagTimeStamp_me - 30L;
      }
      return new SelfGagInfo(paramString, true, String.format(str, new Object[] { gagTimeToStringCountDown((Context)localObject, l) }), 60L);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagServiceImpl", 4, String.format("getTroopGagInfo:sUin=%s, not Gag", new Object[] { paramString }));
    }
    return new SelfGagInfo(paramString, false, "", 0L);
  }
  
  public MemberGagInfo getTroopMemberGagInfo(String paramString1, String paramString2)
  {
    paramString1 = ((ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
    long l;
    if (paramString1 != null) {
      l = paramString1.gagTimeStamp;
    } else {
      l = 0L;
    }
    return new MemberGagInfo(paramString2, l);
  }
  
  public ArrayList<MemberGagInfo> getTroopMemberGagList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      try
      {
        EntityTransaction localEntityTransaction = this.em.getTransaction();
        if (localEntityTransaction != null)
        {
          localObject2 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          localEntityTransaction.begin();
          localObject2 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          long l = NetConnInfoCenter.getServerTime();
          localObject2 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          paramString = this.em.query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
          if (paramString != null)
          {
            localObject2 = localEntityTransaction;
            localObject1 = localEntityTransaction;
            paramString = paramString.iterator();
            for (;;)
            {
              localObject2 = localEntityTransaction;
              localObject1 = localEntityTransaction;
              if (!paramString.hasNext()) {
                break;
              }
              localObject2 = localEntityTransaction;
              localObject1 = localEntityTransaction;
              TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramString.next();
              localObject2 = localEntityTransaction;
              localObject1 = localEntityTransaction;
              if (((ITroopMemberInfoUtilsApi)QRoute.api(ITroopMemberInfoUtilsApi.class)).isValidTroopMemberInfo(localTroopMemberInfo))
              {
                localObject2 = localEntityTransaction;
                localObject1 = localEntityTransaction;
                if (localTroopMemberInfo.gagTimeStamp != 0L)
                {
                  localObject2 = localEntityTransaction;
                  localObject1 = localEntityTransaction;
                  if (localTroopMemberInfo.gagTimeStamp > l)
                  {
                    localObject2 = localEntityTransaction;
                    localObject1 = localEntityTransaction;
                    localArrayList.add(new MemberGagInfo(localTroopMemberInfo.memberuin, localTroopMemberInfo.gagTimeStamp));
                  }
                }
              }
            }
          }
        }
        if (localEntityTransaction == null) {
          break label277;
        }
        localObject1 = localEntityTransaction;
      }
      finally
      {
        if (localObject2 != null) {
          localObject2.end();
        }
      }
    }
    catch (Throwable paramString)
    {
      label267:
      break label267;
    }
    if (localObject1 != null) {
      localObject1.end();
    }
    label277:
    return localArrayList;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.em = this.mApp.getEntityManagerFactory().createEntityManager();
  }
  
  public void onDestroy() {}
  
  public void saveAndUpdateTroopMemberGagStatus(String paramString1, String paramString2, long paramLong)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGagServiceImpl", 2, "saveAndUpdateTroopMemberGagStatus , info is null ... ");
      }
      return;
    }
    if ((paramLong != -100L) && (paramLong != localTroopMemberInfo.gagTimeStamp)) {
      localTroopMemberInfo.gagTimeStamp = paramLong;
    }
    if (localTroopMemberInfo.getStatus() == 1000) {
      localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo);
    }
    ThreadManager.post(new TroopGagServiceImpl.1(this, localTroopMemberInfo, paramString1), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagServiceImpl
 * JD-Core Version:    0.7.0.1
 */