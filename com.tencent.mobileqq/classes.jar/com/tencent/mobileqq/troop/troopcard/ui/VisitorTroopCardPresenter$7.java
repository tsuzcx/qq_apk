package com.tencent.mobileqq.troop.troopcard.ui;

import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class VisitorTroopCardPresenter$7
  extends TroopObserver
{
  VisitorTroopCardPresenter$7(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  protected void onBatchGetTroopInfoResp(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    if ((paramRespBatchProcess != null) && (paramRespBatchProcess.batch_response_list != null) && (paramRespBatchProcess.batch_response_list.size() != 0))
    {
      if (VisitorTroopCardPresenter.d(this.a) == null) {
        return;
      }
      if (!String.valueOf(paramLong).equals(VisitorTroopCardPresenter.d(this.a).troopUin)) {
        return;
      }
      if (VisitorTroopCardPresenter.j(this.a) != null)
      {
        if (VisitorTroopCardPresenter.c(this.a) == null) {
          return;
        }
        if (VisitorTroopCardPresenter.j(this.a).c != null) {
          VisitorTroopCardPresenter.j(this.a).c.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        if (!String.valueOf(paramLong).equals(VisitorTroopCardPresenter.d(this.a).troopUin)) {
          return;
        }
        int j = paramRespBatchProcess.batch_response_list.size();
        int i = 0;
        while (i < j)
        {
          paramBundle = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
          if ((paramBundle != null) && (paramBundle.result == 0) && (paramBundle.type == 1)) {
            VisitorTroopCardPresenter.a(this.a, paramBundle);
          }
          i += 1;
        }
        if (j > 0) {
          this.a.c();
        }
      }
    }
  }
  
  protected void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (VisitorTroopCardPresenter.b(this.a) != null) && (VisitorTroopCardPresenter.d(this.a) != null) && (!TextUtils.isEmpty(VisitorTroopCardPresenter.d(this.a).troopUin)) && (VisitorTroopCardPresenter.d(this.a).troopUin.equals(paramString1))) {
      VisitorTroopCardPresenter.b(this.a).a(paramBoolean, paramString1, paramString2);
    }
  }
  
  protected void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_1_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (paramInt1 != 2) {
      return;
    }
    if ((paramBoolean) && (VisitorTroopCardPresenter.b(this.a) != null) && (paramList != null) && (!paramList.isEmpty())) {
      VisitorTroopCardPresenter.b(this.a).a(paramLong1, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter.7
 * JD-Core Version:    0.7.0.1
 */