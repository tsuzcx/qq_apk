package com.tencent.mobileqq.troop.troopcreate.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.TroopCreateResult;
import com.tencent.mobileqq.troop.handler.TroopMngHandler;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class TroopCreateServiceImpl$3
  extends TroopMngObserver
{
  TroopCreateServiceImpl$3(TroopCreateServiceImpl paramTroopCreateServiceImpl) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    TroopCreateServiceImpl.access$100(this.a).removeObserver(this.a.mTroopMngObserver);
    if (TroopCreateServiceImpl.access$200(this.a) == null)
    {
      TroopCreateUtils.a();
      return;
    }
    int i = -1;
    Object localObject1 = null;
    if (paramObject == null)
    {
      QLog.i("TroopCreateServiceImpl", 1, "onGetTroopCreate data null");
      TroopCreateUtils.a();
      TroopCreateServiceImpl.access$200(this.a).onCreateTroopCompletely(-1, "", null);
      TroopCreateServiceImpl.access$202(this.a, null);
      return;
    }
    if (!paramBoolean)
    {
      try
      {
        int j = ((TroopCreateInfo.TroopCreateResult)paramObject).a;
        i = j;
        paramObject = ((TroopCreateInfo.TroopCreateResult)paramObject).b;
        i = j;
      }
      catch (Exception paramObject)
      {
        QLog.i("TroopCreateServiceImpl", 1, "onGetTroopCreate retCode Exeption:", paramObject);
        paramObject = localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetTroopCreate retCode:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("  currentUin:");
      ((StringBuilder)localObject1).append(TroopCreateServiceImpl.access$100(this.a).getCurrentUin());
      QLog.i("TroopCreateServiceImpl", 1, ((StringBuilder)localObject1).toString());
      TroopCreateUtils.a();
      TroopCreateServiceImpl.access$200(this.a).onCreateTroopCompletely(i, "", paramObject);
      return;
    }
    paramObject = (TroopInfo)paramObject;
    localObject1 = paramObject.troopuin;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetTroopCreate troopUin:");
      paramObject.append((String)localObject1);
      QLog.i("TroopCreateServiceImpl", 1, paramObject.toString());
      TroopCreateUtils.a();
      TroopCreateServiceImpl.access$200(this.a).onCreateTroopCompletely(-1, "", null);
      TroopCreateServiceImpl.access$202(this.a, null);
      return;
    }
    TroopCreateServiceImpl.access$000(this.a).troopUin = ((String)localObject1);
    ReportController.b(TroopCreateServiceImpl.access$100(this.a), "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, (String)localObject1, Integer.toString(TroopCreateServiceImpl.access$000(this.a).classify), "", "");
    if (TroopCreateServiceImpl.access$000(this.a).inviteMembers == null) {
      i = 1;
    } else {
      i = TroopCreateServiceImpl.access$000(this.a).inviteMembers.size();
    }
    Object localObject2 = TroopCreateServiceImpl.access$100(this.a);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(TroopCreateServiceImpl.access$000(this.a).createFrom);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_create_new", "", "suc_create", "person_create", 0, 0, (String)localObject1, (String)localObject3, localStringBuilder.toString(), "");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onGetTroopCreate success troopUin:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" number:");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("  createFrom:");
    ((StringBuilder)localObject2).append(TroopCreateServiceImpl.access$000(this.a).createFrom);
    QLog.i("TroopCreateServiceImpl", 1, ((StringBuilder)localObject2).toString());
    ThreadManager.post(new TroopCreateServiceImpl.3.1(this, (String)localObject1, paramObject, i), 8, null, true);
    if (TroopCreateServiceImpl.access$000(this.a).isJumpAio)
    {
      if (QBaseActivity.sTopActivity != null) {
        paramObject = QBaseActivity.sTopActivity;
      } else {
        paramObject = BaseApplication.getContext();
      }
      TroopCreateUtils.a(paramObject, (String)localObject1, TroopCreateServiceImpl.access$000(this.a).name);
    }
    TroopCreateServiceImpl.access$200(this.a).onCreateTroopCompletely(0, (String)localObject1, null);
    if (TroopCreateServiceImpl.access$000(this.a).inviteMembers.size() > 0)
    {
      ((ITroopMngHandler)TroopCreateServiceImpl.access$100(this.a).getBusinessHandler(TroopMngHandler.class.getName())).a((String)localObject1, TroopCreateServiceImpl.access$000(this.a).inviteMembers, "");
      TroopCreateServiceImpl.access$100(this.a).addObserver(this.a.mTroopObserver);
    }
    else
    {
      TroopCreateServiceImpl.access$202(this.a, null);
    }
    TroopCreateUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */