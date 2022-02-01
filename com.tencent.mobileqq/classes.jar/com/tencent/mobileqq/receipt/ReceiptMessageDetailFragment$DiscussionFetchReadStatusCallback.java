package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListRsp;
import tencent.im.oidb.cmd0x985.oidb_0x985.RspBody;

class ReceiptMessageDetailFragment$DiscussionFetchReadStatusCallback
  extends ReceiptOidbCallback<ReceiptMessageDetailFragment>
{
  ReceiptMessageDetailFragment$DiscussionFetchReadStatusCallback(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    super(paramReceiptMessageDetailFragment);
  }
  
  void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new oidb_0x985.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = paramBundle.uint32_code.get();
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReceiptMessageDetailFragment", 2, "mDiscussionFetchReadStatusCallback succ");
        }
        paramBundle = (oidb_0x985.GetReadListRsp)paramBundle.msg_get_read_list_rsp.get();
        paramArrayOfByte = paramBundle.rpt_msg_read_list.get();
        paramBundle = paramBundle.rpt_msg_unread_list.get();
        ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, paramArrayOfByte.size(), paramArrayOfByte.size() + paramBundle.size(), true);
        paramInt = paramArrayOfByte.size();
        ReceiptMessageDetailFragment.a((ReceiptMessageDetailFragment)this.a, paramInt, true);
        return;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mDiscussionFetchReadStatusCallback fail on code: ");
      paramArrayOfByte.append(paramInt);
      QLog.d("ReceiptMessageDetailFragment", 1, paramArrayOfByte.toString());
      ReceiptMessageDetailFragment.r((ReceiptMessageDetailFragment)this.a).sendEmptyMessage(20);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label176:
      break label176;
    }
    QLog.d("ReceiptMessageDetailFragment", 2, "fetch read member fail on invalid data");
    return;
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("mDiscussionFetchReadStatusCallback request error on code: ");
    paramArrayOfByte.append(paramInt);
    QLog.d("ReceiptMessageDetailFragment", 1, paramArrayOfByte.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.DiscussionFetchReadStatusCallback
 * JD-Core Version:    0.7.0.1
 */