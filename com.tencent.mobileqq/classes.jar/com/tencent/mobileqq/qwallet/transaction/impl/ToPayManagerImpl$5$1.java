package com.tencent.mobileqq.qwallet.transaction.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppActivity;

class ToPayManagerImpl$5$1
  implements Runnable
{
  ToPayManagerImpl$5$1(ToPayManagerImpl.5 param5, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    AppActivity localAppActivity = (AppActivity)this.this$0.a.get();
    if (localAppActivity != null)
    {
      if (localAppActivity.isFinishing()) {
        return;
      }
      ToPayManagerImpl.access$000(localAppActivity, false);
      if (this.a == 0)
      {
        this.this$0.b.send(1, new Bundle());
        ReportController.b(QWalletTools.b(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.aio.send", 0, 0, "", "", "", "");
        int i = localAppActivity.getIntent().getIntExtra("iPayFrom", -1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("iPayFrom : ");
          ((StringBuilder)localObject1).append(i);
          QLog.e("TopayManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (i == 1)
        {
          ToPayManagerImpl.access$100(localAppActivity, this.this$0.c, this.this$0.d);
          return;
        }
        ToPayManagerImpl.access$200(localAppActivity, this.this$0.c, this.this$0.d);
        return;
      }
      Object localObject1 = null;
      Object localObject2 = this.b;
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getString("retmsg");
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = localAppActivity.getResources().getString(R.string.m);
      }
      DialogUtil.a(localAppActivity, 231, null, (CharSequence)localObject2, localAppActivity.getResources().getString(R.string.l), null, null, new ToPayManagerImpl.5.1.1(this)).show();
      ReportController.b(QWalletTools.b(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.errwinshow", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.5.1
 * JD-Core Version:    0.7.0.1
 */