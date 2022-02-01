package com.tencent.mobileqq.receipt;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.cmd0x986.oidb_0x986.RspBody;

class ReceiptMessageReadMemberListContainerFragment$TroopFetchReadMemberListCallback
  extends ReceiptOidbCallback<ReceiptMessageReadMemberListContainerFragment>
{
  ReceiptMessageReadMemberListContainerFragment$TroopFetchReadMemberListCallback(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
  {
    super(paramReceiptMessageReadMemberListContainerFragment);
  }
  
  void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("mTroopFetchReadMemberListCallback onRes: ");
      paramBundle.append(paramInt);
      QLog.d("ReceiptMessageReadMemberListContainerFragment", 4, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new oidb_0x986.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = paramBundle.rpt_msg_uin_info.get();
      paramArrayOfByte = ReceiptMessageReadMemberListContainerFragment.b((ReceiptMessageReadMemberListContainerFragment)this.a, paramArrayOfByte).iterator();
      while (paramArrayOfByte.hasNext())
      {
        ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)paramArrayOfByte.next();
        if (!Long.toString(ReceiptMessageReadMemberListContainerFragment.t((ReceiptMessageReadMemberListContainerFragment)this.a)).equals(localMemberInfo.a)) {
          if (localMemberInfo.c > 0L) {
            ReceiptMessageReadMemberListContainerFragment.k((ReceiptMessageReadMemberListContainerFragment)this.a).add(localMemberInfo);
          } else {
            ReceiptMessageReadMemberListContainerFragment.j((ReceiptMessageReadMemberListContainerFragment)this.a).add(localMemberInfo);
          }
        }
      }
      if (paramBundle.uint64_next_uin.get() == 0L)
      {
        ReceiptMessageReadMemberListContainerFragment.f((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(2);
        return;
      }
      paramArrayOfByte = ReceiptMessageReadMemberListContainerFragment.f((ReceiptMessageReadMemberListContainerFragment)this.a).obtainMessage(3, Long.valueOf(paramBundle.uint64_next_uin.get()));
      ReceiptMessageReadMemberListContainerFragment.f((ReceiptMessageReadMemberListContainerFragment)this.a).sendMessage(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      break label262;
    }
    ReceiptMessageReadMemberListContainerFragment.f((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(-1);
    return;
    label262:
    QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "fetch read member fail on invalid data");
    ReceiptMessageReadMemberListContainerFragment.f((ReceiptMessageReadMemberListContainerFragment)this.a).sendEmptyMessage(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.TroopFetchReadMemberListCallback
 * JD-Core Version:    0.7.0.1
 */