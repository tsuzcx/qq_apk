package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListRsp;
import tencent.im.oidb.cmd0x985.oidb_0x985.RspBody;

class ReceiptMessageReadMemberListContainerFragment$DiscussionFetchReadStatusCallback
  extends ReceiptOidbCallback<ReceiptMessageReadMemberListContainerFragment>
{
  ReceiptMessageReadMemberListContainerFragment$DiscussionFetchReadStatusCallback(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
  {
    super(paramReceiptMessageReadMemberListContainerFragment);
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
        paramBundle = (oidb_0x985.GetReadListRsp)paramBundle.msg_get_read_list_rsp.get();
        paramArrayOfByte = paramBundle.rpt_msg_read_list.get();
        paramBundle = paramBundle.rpt_msg_unread_list.get();
        ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a, ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a, paramArrayOfByte));
        ReceiptMessageReadMemberListContainerFragment.b((ReceiptMessageReadMemberListContainerFragment)this.a, ReceiptMessageReadMemberListContainerFragment.a((ReceiptMessageReadMemberListContainerFragment)this.a, paramBundle));
        ReceiptMessageReadMemberListContainerFragment.f((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(2);
        return;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mGetMemberList fail on code: ");
      paramArrayOfByte.append(paramInt);
      QLog.d("ReceiptMessageReadMemberListContainerFragment", 1, paramArrayOfByte.toString());
      if (paramInt == 5)
      {
        ReceiptMessageReadMemberListContainerFragment.f((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(-1);
        return;
      }
      if (paramInt != 20) {
        break label206;
      }
      ReceiptMessageReadMemberListContainerFragment.f((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(-1);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label198:
      break label198;
    }
    QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "fetch read member fail on invalid data");
    label206:
    return;
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mGetMemberList request error on code: ");
      paramArrayOfByte.append(paramInt);
      QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.DiscussionFetchReadStatusCallback
 * JD-Core Version:    0.7.0.1
 */