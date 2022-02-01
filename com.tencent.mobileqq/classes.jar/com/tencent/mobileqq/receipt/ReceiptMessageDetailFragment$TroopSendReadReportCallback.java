package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class ReceiptMessageDetailFragment$TroopSendReadReportCallback
  extends ReceiptOidbCallback<ReceiptMessageDetailFragment>
{
  ReceiptMessageDetailFragment$TroopSendReadReportCallback(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    super(paramReceiptMessageDetailFragment);
  }
  
  void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isDebugVersion())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mTroopSendReadReportCallback onRes: ");
      paramArrayOfByte.append(paramInt);
      QLog.d("ReceiptMessageDetailFragment", 4, paramArrayOfByte.toString());
    }
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "mTroopSendReadReportCallback succ");
      }
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, 0, 0, false);
      ReceiptMessageDetailFragment.r((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(4);
      return;
    }
    if (paramInt != 1281)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mTroopSendReadReportCallback fatal error: ");
      paramArrayOfByte.append(paramInt);
      QLog.d("ReceiptMessageDetailFragment", 1, paramArrayOfByte.toString());
      ReceiptMessageDetailFragment.r((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(5);
      return;
    }
    ReceiptMessageDetailFragment.F((ReceiptMessageDetailFragment)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.TroopSendReadReportCallback
 * JD-Core Version:    0.7.0.1
 */