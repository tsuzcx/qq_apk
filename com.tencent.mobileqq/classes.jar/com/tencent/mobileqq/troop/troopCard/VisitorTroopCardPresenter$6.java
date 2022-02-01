package com.tencent.mobileqq.troop.troopCard;

import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class VisitorTroopCardPresenter$6
  extends TroopBusinessObserver
{
  VisitorTroopCardPresenter$6(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void onBatchGetTroopInfoResp(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    if ((paramRespBatchProcess == null) || (paramRespBatchProcess.batch_response_list == null) || (paramRespBatchProcess.batch_response_list.size() == 0) || (VisitorTroopCardPresenter.a(this.a) == null)) {}
    int j;
    do
    {
      do
      {
        do
        {
          return;
        } while ((!String.valueOf(paramLong).equals(VisitorTroopCardPresenter.a(this.a).troopUin)) || (VisitorTroopCardPresenter.a(this.a) == null) || (VisitorTroopCardPresenter.a(this.a) == null));
        if (VisitorTroopCardPresenter.a(this.a).a != null) {
          VisitorTroopCardPresenter.a(this.a).a.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      } while (!String.valueOf(paramLong).equals(VisitorTroopCardPresenter.a(this.a).troopUin));
      j = paramRespBatchProcess.batch_response_list.size();
      int i = 0;
      if (i < j)
      {
        paramBundle = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((paramBundle == null) || (paramBundle.result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (paramBundle.type == 1) {
            VisitorTroopCardPresenter.a(this.a, paramBundle);
          }
        }
      }
    } while (j <= 0);
    this.a.c();
  }
  
  public void onCmdTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if ((VisitorTroopCardPresenter.a(this.a) == null) || (VisitorTroopCardPresenter.a(this.a) == null)) {}
    while (!Utils.a(paramString1, VisitorTroopCardPresenter.a(this.a).troopUin)) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.a.a(paramList, true);
      return;
    }
    this.a.a(paramList, true);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramInt1 != 1) {
        break label106;
      }
      paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131696052);
    }
    for (;;)
    {
      VisitorTroopCardPresenter.a(this.a).a(paramString1);
      return;
      label106:
      if (paramInt1 == 2) {
        paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131696050);
      } else if (paramInt1 == 3) {
        paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131696063);
      } else if (paramInt1 == 4) {
        paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131696064);
      } else {
        paramString1 = VisitorTroopCardPresenter.a(this.a).getString(2131696061);
      }
    }
  }
  
  public void onGetAddTroopWebInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (VisitorTroopCardPresenter.a(this.a) == null) {
      return;
    }
    VisitorTroopCardPresenter.a(this.a).d(paramString);
  }
  
  public void onGetTroopAuthSubmitTime(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (VisitorTroopCardPresenter.a(this.a) != null) && (paramString.equals(VisitorTroopCardPresenter.a(this.a).troopUin))) {
      this.a.a = paramInt;
    }
  }
  
  public void onGetTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if ((VisitorTroopCardPresenter.a(this.a) == null) || (VisitorTroopCardPresenter.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!Utils.a(paramString1, VisitorTroopCardPresenter.a(this.a).troopUin)));
      if (paramInt1 == 0)
      {
        this.a.a(paramList, true);
        return;
      }
    } while (paramString2 != null);
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      paramString2 = VisitorTroopCardPresenter.a(this.a).getString(2131696052);
    }
    for (;;)
    {
      VisitorTroopCardPresenter.a(this.a).a(paramString2);
      return;
      if (paramInt1 == 19) {
        paramString2 = VisitorTroopCardPresenter.a(this.a).getString(2131696050);
      } else if (paramInt1 == 65) {
        paramString2 = VisitorTroopCardPresenter.a(this.a).getString(2131696051);
      }
    }
  }
  
  public void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (VisitorTroopCardPresenter.a(this.a) != null) && (VisitorTroopCardPresenter.a(this.a) != null) && (!TextUtils.isEmpty(VisitorTroopCardPresenter.a(this.a).troopUin)) && (VisitorTroopCardPresenter.a(this.a).troopUin.equals(paramString1))) {
      VisitorTroopCardPresenter.a(this.a).a(paramBoolean, paramString1, paramString2);
    }
  }
  
  public void onJoinTroopSecurityTips(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "onTroopRankSwitchUpdate. troopUin = " + paramString + ",isSucc = " + paramBoolean + ", tId" + paramInt + ",time = " + paramLong);
    }
    if ((VisitorTroopCardPresenter.a(this.a) == null) || (TextUtils.isEmpty(VisitorTroopCardPresenter.a(this.a).troopUin)) || (TextUtils.isEmpty(paramString)) || (!VisitorTroopCardPresenter.a(this.a).troopUin.equals(paramString)) || (paramBoolean)) {
      return;
    }
    VisitorTroopCardPresenter.a(this.a).a(paramBoolean, paramString, paramInt, paramLong);
  }
  
  public void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if ((VisitorTroopCardPresenter.a(this.a) == null) || (VisitorTroopCardPresenter.a(this.a) == null)) {
      return;
    }
    VisitorTroopCardPresenter.a(this.a).a(paramBoolean, paramLong, paramTroopInfo);
  }
  
  public void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_1_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (paramInt1 != 2) {}
    while ((!paramBoolean) || (VisitorTroopCardPresenter.a(this.a) == null) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    VisitorTroopCardPresenter.a(this.a).a(paramLong1, paramList);
  }
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        break label86;
      }
    }
    for (;;)
    {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
      if ((VisitorTroopCardPresenter.a(this.a) != null) && (VisitorTroopCardPresenter.a(this.a) != null)) {
        break;
      }
      return;
      label86:
      bool = false;
    }
    VisitorTroopCardPresenter.a(this.a).a(paramInt1, paramInt2);
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label111;
      }
      str = "";
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        break label117;
      }
    }
    label111:
    label117:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", str, ", hasTroopInfoData=", Boolean.valueOf(bool) });
      if ((VisitorTroopCardPresenter.a(this.a) != null) && (VisitorTroopCardPresenter.a(this.a) != null)) {
        break label123;
      }
      return;
      str = paramString;
      break;
    }
    label123:
    VisitorTroopCardPresenter.a(this.a).a(paramInt1, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.6
 * JD-Core Version:    0.7.0.1
 */