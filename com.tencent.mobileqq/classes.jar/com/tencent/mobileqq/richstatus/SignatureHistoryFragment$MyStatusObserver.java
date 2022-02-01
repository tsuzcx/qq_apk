package com.tencent.mobileqq.richstatus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class SignatureHistoryFragment$MyStatusObserver
  extends StatusObserver
{
  private SignatureHistoryFragment$MyStatusObserver(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  protected void a(boolean paramBoolean, List<byte[]> paramList, List<Integer> paramList1)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDeleteStatus. isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", keyListSize=");
      localStringBuilder.append(paramList.size());
      localStringBuilder.append(", errorCodeSize=");
      if (paramList1 == null) {
        paramList1 = "null";
      } else {
        paramList1 = Integer.valueOf(paramList1.size());
      }
      localStringBuilder.append(paramList1);
      QLog.d("SignatureHistoryFragment", 2, localStringBuilder.toString());
    }
    SignatureHistoryFragment.a(this.a, paramBoolean, paramList);
    if ((paramBoolean) && (this.a.getBaseActivity() != null))
    {
      paramList = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
      paramList1 = new StringBuilder();
      paramList1.append(SignatureHistoryFragment.h(this.a));
      paramList1.append("_has_history_sig_del_key");
      paramList.putBoolean(paramList1.toString(), true).apply();
      if (this.a.d != null) {
        this.a.d.a(Long.parseLong(SignatureHistoryFragment.c(this.a)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.MyStatusObserver
 * JD-Core Version:    0.7.0.1
 */