package com.tencent.mobileqq.troop.troopcreate.api.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.InviteMemberInfo;
import com.tencent.mobileqq.troop.handler.TroopMngHandler;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService.NameForCompare;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopCreateServiceImpl
  implements ITroopCreateService
{
  private static final String TAG = "TroopCreateServiceImpl";
  protected static final String TROOP_CREATE_LOG_TAG = "TroopCreate_Log";
  private AppInterface mApp;
  private ITroopCreateInfoService.TroopCreateCallback mCreateCallback;
  private TroopCreateInfo mTroopCreateInfo;
  private ITroopCreateInfoService mTroopCreateInfoService;
  protected TroopMngObserver mTroopMngObserver = new TroopCreateServiceImpl.3(this);
  TroopMngObserver mTroopObserver = new TroopCreateServiceImpl.2(this);
  
  public void createTroop(Activity paramActivity, ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback)
  {
    this.mCreateCallback = paramTroopCreateCallback;
    if (paramActivity == null)
    {
      terminateLogic();
      return;
    }
    paramTroopCreateCallback = this.mTroopCreateInfo;
    if ((paramTroopCreateCallback != null) && (paramTroopCreateCallback.inviteMembers != null))
    {
      paramTroopCreateCallback = this.mCreateCallback;
      if (paramTroopCreateCallback != null)
      {
        createTroop(paramTroopCreateCallback, paramActivity, this.mTroopCreateInfo.inviteMembers);
        return;
      }
    }
    terminateLogic();
  }
  
  public void createTroop(ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback, Activity paramActivity, List<TroopCreateInfo.InviteMemberInfo> paramList)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplication.getContext());
    i = 0;
    if (!bool)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, 2131892104, 0).show();
      terminateLogic();
      return;
    }
    if (this.mTroopCreateInfo == null)
    {
      terminateLogic();
      return;
    }
    if (paramList != null)
    {
      TroopCreateUtils.a(this.mApp, paramList);
      if (paramList.size() > 0)
      {
        if (this.mTroopCreateInfo.inviteMembers != paramList) {
          this.mTroopCreateInfo.inviteMembers = Collections.synchronizedList(paramList);
        }
        paramList = new ArrayList();
        Iterator localIterator = this.mTroopCreateInfo.inviteMembers.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (TroopCreateInfo.InviteMemberInfo)localIterator.next();
          localObject = TroopCreateUtils.a(this.mApp, (TroopCreateInfo.InviteMemberInfo)localObject, null);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramList.add(localObject);
          }
        }
        this.mTroopCreateInfo.name = TroopCreateUtils.a(paramList);
      }
    }
    try
    {
      l3 = Long.parseLong(this.mApp.getCurrentAccountUin());
      paramList = this.mTroopCreateInfo.location.split("\\|");
      j = paramList.length;
      l2 = 0L;
      if (j != 4) {}
    }
    catch (NumberFormatException paramTroopCreateCallback)
    {
      long l3;
      long l2;
      float f;
      long l1;
      label270:
      label273:
      int k;
      break label425;
    }
    try
    {
      j = Integer.parseInt(paramList[0]);
      i = j;
      f = Float.valueOf(paramList[1]).floatValue();
      l1 = (f * 1000000.0F);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      break label270;
    }
    try
    {
      f = Float.valueOf(paramList[2]).floatValue();
      l2 = (f * 1000000.0F);
      i = j;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      i = j;
      break label273;
    }
    l1 = 0L;
    paramList = paramList[3];
    break label293;
    paramList = "";
    l1 = 0L;
    l2 = l1;
    i = 0;
    label293:
    k = this.mTroopCreateInfo.troopType;
    j = k;
    if (k == 2) {
      j = k + 1;
    }
    this.mApp.addObserver(this.mTroopMngObserver);
    this.mCreateCallback = paramTroopCreateCallback;
    ((ITroopMngHandler)this.mApp.getBusinessHandler(TroopMngHandler.class.getName())).a(this.mTroopCreateInfo.groupUin, this.mTroopCreateInfo.troopSize, l3, this.mTroopCreateInfo.verifyType, this.mTroopCreateInfo.name, this.mTroopCreateInfo.introduction, this.mTroopCreateInfo.classify, j, l1, l2, i, paramList, this.mTroopCreateInfo.signOriginal);
    TroopCreateUtils.a(paramActivity, HardCodeUtil.a(2131912551));
    return;
    label425:
    terminateLogic();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface)) {
      this.mApp = ((AppInterface)paramAppRuntime);
    } else {
      this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    }
    this.mTroopCreateInfoService = ((ITroopCreateInfoService)this.mApp.getRuntimeService(ITroopCreateInfoService.class, ""));
    this.mTroopCreateInfo = this.mTroopCreateInfoService.getTroopCreateInfo();
  }
  
  public void onDestroy()
  {
    terminateLogic();
  }
  
  public void onReuseTroop(String paramString)
  {
    ITroopCreateInfoService.TroopCreateCallback localTroopCreateCallback = this.mCreateCallback;
    if (localTroopCreateCallback != null) {
      localTroopCreateCallback.onReusedTroop(paramString);
    }
  }
  
  public void releaseCreateCallback(ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback)
  {
    if (this.mCreateCallback == paramTroopCreateCallback) {
      this.mCreateCallback = null;
    }
  }
  
  public void startCreateTroop(ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback, Activity paramActivity, ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        if (!localResultRecord.uin.equals(this.mApp.getCurrentAccountUin()))
        {
          ITroopCreateService.NameForCompare localNameForCompare = new ITroopCreateService.NameForCompare();
          localNameForCompare.a = localResultRecord.name;
          localNameForCompare.b = ChnToSpell.b(localResultRecord.name, 2);
          localArrayList.add(localNameForCompare);
        }
      }
      Collections.sort(localArrayList);
      TroopCreateUtils.b(this.mApp, paramArrayList);
      localObject = (ITroopSearchService)this.mApp.getRuntimeService(ITroopSearchService.class, "");
      this.mCreateCallback = paramTroopCreateCallback;
      this.mTroopCreateInfo.inviteMembers = Collections.synchronizedList(TroopCreateUtils.a(paramArrayList));
      TroopCreateUtils.a(paramActivity, HardCodeUtil.a(2131912552));
      ((ITroopSearchService)localObject).search(paramArrayList, true, new TroopCreateServiceImpl.1(this, localArrayList, paramActivity, paramTroopCreateCallback, paramArrayList));
    }
  }
  
  public void startCreateTroopSession(Activity paramActivity, int paramInt)
  {
    startCreateTroopSession(paramActivity, paramInt, "DEFAULT");
  }
  
  public void startCreateTroopSession(Activity paramActivity, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startCreateTroopSession: from=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramString);
      QLog.d("Q.troopCreate", 2, localStringBuilder.toString());
    }
    terminateLogic();
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(paramInt) }));
        }
        TroopCreateUtils.a(paramActivity, paramInt);
        return;
      }
      if ((!"1".equals(paramString)) && (!"0".equals(paramString)) && (!"2".equals(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(paramInt) }));
        }
        TroopCreateUtils.a(paramActivity);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreate_Log", 2, String.format("Entering create troop session, From type: %s, Troop type: %s...", new Object[] { Integer.valueOf(paramInt), paramString }));
        }
        TroopCreateUtils.a(paramActivity, paramString);
      }
      paramActivity.finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(paramInt) }));
    }
    TroopCreateUtils.a(paramActivity);
  }
  
  public void terminateLogic()
  {
    Object localObject = this.mApp;
    if (localObject != null) {
      ((AppInterface)localObject).removeObserver(this.mTroopMngObserver);
    }
    TroopCreateUtils.a();
    this.mCreateCallback = null;
    localObject = this.mTroopCreateInfo;
    if (localObject != null) {
      ((TroopCreateInfo)localObject).reset();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "terminateLogic");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl
 * JD-Core Version:    0.7.0.1
 */