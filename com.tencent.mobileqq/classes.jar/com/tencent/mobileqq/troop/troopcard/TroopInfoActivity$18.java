package com.tencent.mobileqq.troop.troopcard;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopInfoActivity$18
  extends Handler
{
  TroopInfoActivity$18(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.a.h();
      return;
    }
    if (paramMessage.what == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_OWNER_NAME");
      }
      paramMessage = this.a;
      paramMessage.a(2, paramMessage.a.getTroopOwnerName(), this.a.a.isFetchedTroopOwnerUin());
      return;
    }
    if (paramMessage.what == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "MSG_UPDATE_INFO");
      }
      if ((this.a.a.dwGroupFlagExt & 0x800) != 0L)
      {
        paramMessage = this.a;
        paramMessage.a(7, paramMessage.a.troopAuthenticateInfo, false);
      }
      paramMessage = this.a;
      paramMessage.a(2, paramMessage.a.troopOwnerNick, this.a.a.isFetchedTroopOwnerUin());
      if ((this.a.a.troopOwnerNick == null) && (!TextUtils.isEmpty(this.a.a.troopowneruin))) {
        TroopInfoActivity.c(this.a);
      }
      this.a.m();
      this.a.c();
      this.a.b();
      if (!TextUtils.isEmpty(this.a.a.mRichFingerMemo)) {
        paramMessage = this.a.a.mRichFingerMemo;
      } else {
        paramMessage = this.a.getResources().getString(2131696163);
      }
      TroopInfoActivity localTroopInfoActivity = this.a;
      localTroopInfoActivity.a(6, paramMessage, localTroopInfoActivity.a.isOwnerOrAdim());
      if (this.a.a.troopClass == null) {
        TroopInfoActivity.d(this.a);
      }
    }
    else
    {
      if (paramMessage.what == 5)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_CLASS");
        }
        paramMessage = this.a;
        paramMessage.a(4, paramMessage.a.troopClass, this.a.a.isOwnerOrAdim());
        return;
      }
      if (paramMessage.what == 6)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_TAGS");
        }
        paramMessage = this.a;
        paramMessage = TroopInfoActivity.a(paramMessage, paramMessage.a);
        this.a.a(8, paramMessage, true, 2, true);
        return;
      }
      if (paramMessage.what == 7)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_INTEREST");
        }
        paramMessage = new ArrayList();
        if (!TextUtils.isEmpty(this.a.a.tribeName)) {
          paramMessage.add(this.a.a.tribeName);
        }
        this.a.a(9, paramMessage, true, 1, true);
        TroopInfoActivity.e(this.a);
        return;
      }
      if (paramMessage.what == 8) {
        TroopInfoActivity.e(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.18
 * JD-Core Version:    0.7.0.1
 */