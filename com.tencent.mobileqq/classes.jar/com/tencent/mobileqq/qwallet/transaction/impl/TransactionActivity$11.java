package com.tencent.mobileqq.qwallet.transaction.impl;

import android.widget.TextView;
import com.qwallet.temp.FriendListObserverTemp;
import com.qwallet.temp.IQwTemp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.util.DisplayUtil;

class TransactionActivity$11
  implements FriendListObserverTemp
{
  TransactionActivity$11(TransactionActivity paramTransactionActivity) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramString == null) {
        return;
      }
      TransactionActivity.access$1902(this.a, ((IQwTemp)QRoute.api(IQwTemp.class)).ContactUtils$getBuddyName(this.a.getAppRuntime(), TransactionActivity.access$2000(this.a), true));
      paramString = QWalletTools.a(TransactionActivity.access$1300(this.a), TransactionActivity.access$1900(this.a), DisplayUtil.a(TransactionActivity.access$1300(this.a), TransactionActivity.access$2100(this.a)), TransactionActivity.access$2200(this.a).getPaint());
      TextView localTextView = TransactionActivity.access$2200(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(TransactionActivity.access$2000(this.a));
      localStringBuilder.append(")");
      localTextView.setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.11
 * JD-Core Version:    0.7.0.1
 */