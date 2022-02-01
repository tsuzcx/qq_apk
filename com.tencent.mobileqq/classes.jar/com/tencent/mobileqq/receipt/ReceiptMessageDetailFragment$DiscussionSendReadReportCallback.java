package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x984.oidb_0x984.RspBody;

class ReceiptMessageDetailFragment$DiscussionSendReadReportCallback
  extends ReceiptOidbCallback<ReceiptMessageDetailFragment>
{
  ReceiptMessageDetailFragment$DiscussionSendReadReportCallback(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    super(paramReceiptMessageDetailFragment);
  }
  
  void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new oidb_0x984.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      if (paramBundle.uint32_code.get() != 0)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("getDiscussionSendReadReportCallback fail on code: ");
        paramArrayOfByte.append(paramBundle.uint32_code.get());
        QLog.d("ReceiptMessageDetailFragment", 1, paramArrayOfByte.toString());
        if (paramBundle.uint32_code.get() == 20)
        {
          ReceiptMessageDetailFragment.F((ReceiptMessageDetailFragment)this.a);
          return;
        }
        ReceiptMessageDetailFragment.r((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(5);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "getDiscussionSendReadReportCallback succ");
      }
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, 0, 0, false);
      ReceiptMessageDetailFragment.r((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(4);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label154:
      break label154;
    }
    QLog.d("ReceiptMessageDetailFragment", 1, "Report read status fail on invalid data");
    ReceiptMessageDetailFragment.F((ReceiptMessageDetailFragment)this.a);
    return;
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("getDiscussionSendReadReportCallback error on code: ");
    paramArrayOfByte.append(paramInt);
    QLog.d("ReceiptMessageDetailFragment", 1, paramArrayOfByte.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.DiscussionSendReadReportCallback
 * JD-Core Version:    0.7.0.1
 */