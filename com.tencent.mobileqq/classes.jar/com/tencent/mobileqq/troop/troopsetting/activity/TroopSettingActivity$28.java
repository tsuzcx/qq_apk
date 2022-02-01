package com.tencent.mobileqq.troop.troopsetting.activity;

import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHandler;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopSettingActivity$28
  extends TroopObserver
{
  TroopSettingActivity$28(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void onBatchGetTroopInfoResp(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    if ((this.a.S != null) && (this.a.q != null)) {
      this.a.q.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBatchGetTroopInfoResp, isSucc=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mTroopInfoData IsNull=");
      if (this.a.i == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", resp IsNull=");
      if (paramRespBatchProcess == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.chatopttroop", 2, localStringBuilder.toString());
    }
    if ((paramRespBatchProcess != null) && (paramRespBatchProcess.batch_response_list != null) && (paramRespBatchProcess.batch_response_list.size() != 0) && (this.a.i != null))
    {
      if (!String.valueOf(paramLong).equals(this.a.i.troopUin))
      {
        if (QLog.isColorLevel())
        {
          paramRespBatchProcess = new StringBuilder();
          paramRespBatchProcess.append("onBatchGetTroopInfoResp  fiter resp, curTroopUin = ");
          paramRespBatchProcess.append(this.a.i.troopUin);
          paramRespBatchProcess.append(",respUin = ");
          paramRespBatchProcess.append(paramLong);
          QLog.d("Q.chatopttroop", 2, paramRespBatchProcess.toString());
        }
        return;
      }
      if (paramBundle != null)
      {
        if (paramBundle.getInt("from", 0) != 1) {
          return;
        }
        int j = paramRespBatchProcess.batch_response_list.size();
        while (i < j)
        {
          paramBundle = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
          if ((paramBundle != null) && (paramBundle.result == 0) && (paramBundle.type == 1)) {
            this.a.a(paramBundle);
          }
          i += 1;
        }
        if (j > 0)
        {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.a.t, TroopSettingActivity.a(this.a), this.a.i.isMember);
          this.a.b(true);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.chatopttroop", 2, "onBatchGetTroopInfoResp, return");
    }
  }
  
  protected void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.N != null))
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onBatchTroopCardDefaultNick,memberListForCard.size = ");
        paramObject.append(this.a.N.size());
        QLog.d("Q.chatopttroop", 2, paramObject.toString());
      }
      paramObject = this.a;
      paramObject.a(paramObject.N);
    }
  }
  
  protected void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList, String paramString)
  {
    super.onDeleteTroopMember(paramBoolean, paramInt, paramArrayList, paramString);
    if (!paramBoolean)
    {
      if (paramInt == 2) {
        QQToast.makeText(this.a, 1, HardCodeUtil.a(2131899979), 0).show(this.a.getTitleBarHeight());
      }
      return;
    }
    Object localObject;
    if ((this.a.t != null) && (this.a.t.troopuin != null)) {
      localObject = this.a.t.troopuin;
    } else {
      localObject = "";
    }
    if (this.a.N == null) {
      return;
    }
    HashSet localHashSet = new HashSet();
    if ((paramString != null) && (paramString.equals(localObject)))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (String)paramArrayList.next();
        localObject = this.a.N.iterator();
        while (((Iterator)localObject).hasNext())
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)((Iterator)localObject).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localmemberlist.uint64_member_uin.get());
          localStringBuilder.append("");
          if (paramString.equals(localStringBuilder.toString())) {
            localHashSet.add(localmemberlist);
          }
        }
      }
      paramArrayList = localHashSet.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (oidb_0x899.memberlist)paramArrayList.next();
        this.a.N.remove(paramString);
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("onDeleteTroopMember,memberListForCard.size = ");
      paramArrayList.append(this.a.N.size());
      QLog.d("Q.chatopttroop", 2, paramArrayList.toString());
    }
    paramArrayList = this.a;
    paramArrayList.a(paramArrayList.N);
  }
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.t != null)
    {
      this.a.i.newTroopName = this.a.t.getNewTroopNameOrTroopName();
      this.a.f();
    }
  }
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (this.a.i == null) {
      return;
    }
    if ((paramBoolean) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Object localObject = null;
      int i = 0;
      while ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null)
        {
          localObject = localTroopInfo;
        }
        else
        {
          localObject = localTroopInfo;
          if (!Utils.a(localTroopInfo.troopuin, this.a.i.troopUin)) {
            localObject = null;
          }
        }
        i += 1;
      }
      if (localObject != null)
      {
        paramArrayList = this.a;
        paramArrayList.t = localObject;
        paramArrayList.i.updateForTroopChatSetting(localObject, this.a.getResources(), TroopSettingActivity.a(this.a).getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "onGetMutilTroopInfoResult send MSG_UPDATE_INFO msg");
        }
        this.a.aD.sendEmptyMessage(5);
      }
    }
    try
    {
      long l1 = Long.parseLong(this.a.i.troopUin);
      long l2 = Long.parseLong(this.a.i.troopCode);
      ((ITroopAnnouncementHandler)TroopSettingActivity.a(this.a).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName())).b(0, l2, l1, 0L, "", 0, (short)23, false, false);
      return;
    }
    catch (Exception paramArrayList) {}
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (this.a.i == null) {
      return;
    }
    if (paramBoolean)
    {
      if (!Utils.a(paramString, this.a.i.troopUin)) {
        return;
      }
      TroopInfo localTroopInfo = ((ITroopInfoService)TroopSettingActivity.a(this.a).getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetTroopInfoResult|uin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",tmpTroop = ");
        localStringBuilder.append(localTroopInfo);
        QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
      }
      if (localTroopInfo != null)
      {
        paramString = this.a;
        paramString.t = localTroopInfo;
        paramString.i.updateForTroopChatSetting(localTroopInfo, this.a.getResources(), TroopSettingActivity.a(this.a).getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "onGetTroopInfoResult send MSG_UPDATE_INFO msg");
        }
        this.a.aD.sendEmptyMessage(5);
        TroopSettingActivity.p(this.a);
      }
    }
  }
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2)
  {
    ThreadManager.post(new TroopSettingActivity.28.1(this), 8, null, true);
  }
  
  protected void onModifyTroopInfoPushResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if (this.a.i == null) {
      return;
    }
    if ((paramBoolean) && (paramArrayList != null)) {
      this.a.a(paramArrayList);
    }
  }
  
  protected void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if (this.a.i == null) {
      return;
    }
    boolean bool;
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() != 0)) {
      bool = this.a.a(paramArrayList);
    } else {
      bool = false;
    }
    if (this.a.n == null)
    {
      paramArrayList = this.a;
      paramArrayList.n = new QQProgressNotifier(paramArrayList);
    }
    if ((!paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.a.n.a(2, paramString, 1000);
      return;
    }
    if ((!paramBoolean) && ((this.a.m & 0x1) == 1))
    {
      paramArrayList = this.a;
      paramArrayList.m &= 0xFFFFFFFE;
      this.a.n.b(2, 2131891835, 1000);
      return;
    }
    if ((bool) && ((this.a.m & 0x1) == 1))
    {
      paramArrayList = this.a;
      paramArrayList.m &= 0xFFFFFFFE;
      this.a.n.b(1, 2131891836, 1000);
    }
  }
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_0_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (TextUtils.equals(this.a.i.troopUin, String.valueOf(paramLong1)))
    {
      if (paramInt1 != 5) {
        return;
      }
      if (paramBoolean)
      {
        TroopSettingActivity.a(this.a, paramList);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onOIDB0X899_0_Ret, result = ");
        paramList.append(paramInt2);
        paramList.append("strErrorMsg = ");
        paramList.append(paramString);
        QLog.e("Q.chatopttroop", 2, paramList.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.28
 * JD-Core Version:    0.7.0.1
 */