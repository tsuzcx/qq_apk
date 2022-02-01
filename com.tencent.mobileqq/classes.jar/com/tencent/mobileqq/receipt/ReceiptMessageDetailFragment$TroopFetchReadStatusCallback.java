package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x986.oidb_0x986.RspBody;

class ReceiptMessageDetailFragment$TroopFetchReadStatusCallback
  extends ReceiptOidbCallback<ReceiptMessageDetailFragment>
{
  ReceiptMessageDetailFragment$TroopFetchReadStatusCallback(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    super(paramReceiptMessageDetailFragment);
  }
  
  void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("mTroopFetchReadStatusCallback onRes: ");
      paramBundle.append(paramInt);
      QLog.d("ReceiptMessageDetailFragment", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageDetailFragment", 2, "mTroopFetchReadStatusCallback succ");
      }
      paramBundle = new oidb_0x986.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = paramBundle.uint32_read_uin_num.get();
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, paramInt, true);
      ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, paramInt, 2147483647, true);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      break label125;
    }
    ReceiptMessageDetailFragment.r((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(20);
    return;
    label125:
    QLog.d("ReceiptMessageDetailFragment", 1, "fetch read member fail on invalid data");
    ReceiptMessageDetailFragment.r((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.TroopFetchReadStatusCallback
 * JD-Core Version:    0.7.0.1
 */