package com.tencent.mobileqq.troop.troopcard.ui;

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
      this.a.j();
      return;
    }
    if (paramMessage.what == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_OWNER_NAME");
      }
      paramMessage = this.a;
      paramMessage.a(2, paramMessage.f.getTroopOwnerName(), this.a.f.isFetchedTroopOwnerUin());
      return;
    }
    if (paramMessage.what == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "MSG_UPDATE_INFO");
      }
      if ((this.a.f.dwGroupFlagExt & 0x800) != 0L)
      {
        paramMessage = this.a;
        paramMessage.a(7, paramMessage.f.troopAuthenticateInfo, false);
      }
      paramMessage = this.a;
      paramMessage.a(2, paramMessage.f.troopOwnerNick, this.a.f.isFetchedTroopOwnerUin());
      if ((this.a.f.troopOwnerNick == null) && (!TextUtils.isEmpty(this.a.f.troopowneruin))) {
        TroopInfoActivity.c(this.a);
      }
      this.a.o();
      this.a.d();
      this.a.c();
      if (!TextUtils.isEmpty(this.a.f.mRichFingerMemo)) {
        paramMessage = this.a.f.mRichFingerMemo;
      } else {
        paramMessage = this.a.getResources().getString(2131893929);
      }
      TroopInfoActivity localTroopInfoActivity = this.a;
      localTroopInfoActivity.a(6, paramMessage, localTroopInfoActivity.f.isOwnerOrAdim());
      if (this.a.f.troopClass == null) {
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
        paramMessage.a(4, paramMessage.f.troopClass, this.a.f.isOwnerOrAdim());
        return;
      }
      if (paramMessage.what == 6)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_TAGS");
        }
        paramMessage = this.a;
        paramMessage = TroopInfoActivity.a(paramMessage, paramMessage.f);
        this.a.a(8, paramMessage, true, 2, true);
        return;
      }
      if (paramMessage.what == 7)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_INTEREST");
        }
        paramMessage = new ArrayList();
        if (!TextUtils.isEmpty(this.a.f.tribeName)) {
          paramMessage.add(this.a.f.tribeName);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.18
 * JD-Core Version:    0.7.0.1
 */