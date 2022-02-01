package com.tencent.mobileqq.qwallet.transaction.impl;

import Wallet.PfaFriend;
import Wallet.PfaFriendRsp;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppActivity;

class ToPayManagerImpl$4
  implements DialogInterface.OnClickListener
{
  ToPayManagerImpl$4(ToPayManagerImpl paramToPayManagerImpl, WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof QQCustomDialog))
    {
      if (paramInt != 1) {
        return;
      }
      ToPayManagerImpl.sendTopay((AppActivity)this.a.get(), this.b, (QQCustomDialog)paramDialogInterface);
      if ((ToPayManagerImpl.mData != null) && (ToPayManagerImpl.mData.vecRec != null) && (ToPayManagerImpl.mData.vecRec.size() > 0))
      {
        paramInt = 0;
        while (paramInt < this.b.size())
        {
          int i = 0;
          while (i < ToPayManagerImpl.mData.vecRec.size())
          {
            if (((ResultRecord)this.b.get(paramInt)).uin.equals(((PfaFriend)ToPayManagerImpl.mData.vecRec.get(i)).uin))
            {
              paramDialogInterface = "friendpay.selectpage.recommendfriclick";
              break label141;
            }
            i += 1;
          }
          paramDialogInterface = "friendpay.selectpage.unrecomchoosefriclick";
          label141:
          ReportController.b(QWalletTools.b(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramDialogInterface, 0, 0, "", "", "", "");
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */