package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$36
  extends TroopMngObserver
{
  TroopSettingActivity$36(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.a.i != null) {
        bool = true;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (this.a.i == null) {
      return;
    }
    if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.i.cGroupOption == 1)))
    {
      this.a.o();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed(this.a, paramInt2);
      this.a.aa = null;
      return;
    }
    if ((this.a.isResume()) && ((paramInt1 == 2) || (paramInt1 == 9)))
    {
      if (this.a.n == null)
      {
        TroopSettingActivity localTroopSettingActivity = this.a;
        localTroopSettingActivity.n = new QQProgressNotifier(localTroopSettingActivity);
      }
      this.a.n.b(2, 2131889057, 1500);
      this.a.finish();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      String str;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      } else {
        str = paramString;
      }
      if (this.a.i != null) {
        bool = true;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", str, ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (this.a.i == null) {
      return;
    }
    if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.i.cGroupOption == 1)))
    {
      TroopSettingActivity.a(this.a, paramInt2, paramString);
      return;
    }
    if (this.a.isResume())
    {
      if (paramInt1 == 3)
      {
        TroopSettingActivity.a(this.a, paramInt1, paramInt2);
        return;
      }
      if ((paramInt1 == 2) || (paramInt1 == 9)) {
        TroopSettingActivity.b(this.a, paramInt1, paramInt2);
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (!this.a.isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.makeText(this.a, 2, 2131915703, 1).show(this.a.getTitleBarHeight());
    }
    else
    {
      IChatSettingForTroopApi localIChatSettingForTroopApi = (IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class);
      TroopSettingActivity localTroopSettingActivity = this.a;
      localIChatSettingForTroopApi.openAddTroopWeb(localTroopSettingActivity, paramString, localTroopSettingActivity.i.troopUin);
      this.a.overridePendingTransition(2130772014, 2130772007);
    }
    this.a.finish();
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    this.a.o();
    if (this.a.i == null) {
      return;
    }
    if (paramLong != Long.parseLong(this.a.i.troopUin)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.i.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.a.i.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        this.a.a(2131917529, 0);
        return;
      }
      this.a.i.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (!this.a.isResume())
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "ChatSettingForTroop onSend0x88d_1_forJoinTroop_Ret return----------------");
        }
        return;
      }
      if ((this.a.i.isHomeworkTroop()) && (this.a.i.cGroupOption != 3))
      {
        TroopSettingActivity.d(this.a, 2);
        return;
      }
      TroopSettingActivity.c(this.a, null);
      return;
    }
    this.a.a(2131916242, 1);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramBoolean) && (paramInt == 0) && (this.a.i != null) && (!TextUtils.isEmpty(this.a.i.troopUin)))
    {
      if (!this.a.i.troopUin.equals(String.valueOf(paramLong))) {
        return;
      }
      if (this.a.g != null) {
        this.a.g.setText(2131914219);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.36
 * JD-Core Version:    0.7.0.1
 */