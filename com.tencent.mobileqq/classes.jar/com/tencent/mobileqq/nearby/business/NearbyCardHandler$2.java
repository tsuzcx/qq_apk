package com.tencent.mobileqq.nearby.business;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.nowsummarycard.NowSummaryCard.NearbySummaryCardRsp;
import com.tencent.nowsummarycard.NowSummaryCard.RespNearbySummaryCard;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class NearbyCardHandler$2
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyCardHandler$2(NearbyCardHandler paramNearbyCardHandler, boolean paramBoolean, ToServiceMsg paramToServiceMsg)
  {
    super(paramBoolean);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new NowSummaryCard.RespNearbySummaryCard();
    if (paramInt != 0)
    {
      QLog.e("NearbyCardHandler", 1, "NowSummaryCard error, code=" + paramInt);
      NearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, false, null, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData);
      return;
    }
    NowSummaryCard.NearbySummaryCardRsp localNearbySummaryCardRsp = new NowSummaryCard.NearbySummaryCardRsp();
    try
    {
      localNearbySummaryCardRsp.mergeFrom(paramArrayOfByte);
      if (localNearbySummaryCardRsp.err_msg.has()) {
        QLog.i("NearbyCardHandler", 1, "NowSummaryCard, err_msg=" + localNearbySummaryCardRsp.err_msg.get());
      }
      if (!localNearbySummaryCardRsp.ret_code.has())
      {
        QLog.i("NearbyCardHandler", 1, "NowSummaryCard error, ret_code=" + localNearbySummaryCardRsp.ret_code.get());
        NearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, false, null, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        QLog.i("NearbyCardHandler", 1, "NowSummaryCard, merge error e=" + paramArrayOfByte.toString(), paramArrayOfByte);
      }
      if (localNearbySummaryCardRsp.ret_code.get() == 0) {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyCardHandler", 2, "NowSummaryCard rsp length=" + localNearbySummaryCardRsp.pb_data.get().toByteArray().length);
        }
      }
      for (;;)
      {
        try
        {
          paramBundle.mergeFrom(localNearbySummaryCardRsp.pb_data.get().toByteArray());
          paramInt = 1;
          if (paramInt == 0) {
            break;
          }
          NearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, true, paramBundle, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          QLog.i("NearbyCardHandler", 1, "NowSummaryCard, merge error e=" + paramArrayOfByte.toString(), paramArrayOfByte);
        }
        paramInt = 0;
      }
      NearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, false, null, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.business.NearbyCardHandler.2
 * JD-Core Version:    0.7.0.1
 */