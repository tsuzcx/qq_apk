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
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new NowSummaryCard.RespNearbySummaryCard();
    if (paramInt != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("NowSummaryCard error, code=");
      paramArrayOfByte.append(paramInt);
      QLog.e("NearbyCardHandler", 1, paramArrayOfByte.toString());
      NearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, false, null, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData);
      return;
    }
    Object localObject = new NowSummaryCard.NearbySummaryCardRsp();
    try
    {
      ((NowSummaryCard.NearbySummaryCardRsp)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NowSummaryCard, merge error e=");
      localStringBuilder.append(paramArrayOfByte.toString());
      QLog.i("NearbyCardHandler", 1, localStringBuilder.toString(), paramArrayOfByte);
    }
    if (((NowSummaryCard.NearbySummaryCardRsp)localObject).err_msg.has())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("NowSummaryCard, err_msg=");
      paramArrayOfByte.append(((NowSummaryCard.NearbySummaryCardRsp)localObject).err_msg.get());
      QLog.i("NearbyCardHandler", 1, paramArrayOfByte.toString());
    }
    if (!((NowSummaryCard.NearbySummaryCardRsp)localObject).ret_code.has())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("NowSummaryCard error, ret_code=");
      paramArrayOfByte.append(((NowSummaryCard.NearbySummaryCardRsp)localObject).ret_code.get());
      QLog.i("NearbyCardHandler", 1, paramArrayOfByte.toString());
      NearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, false, null, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData);
      return;
    }
    if (((NowSummaryCard.NearbySummaryCardRsp)localObject).ret_code.get() == 0)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("NowSummaryCard rsp length=");
        paramArrayOfByte.append(((NowSummaryCard.NearbySummaryCardRsp)localObject).pb_data.get().toByteArray().length);
        QLog.i("NearbyCardHandler", 2, paramArrayOfByte.toString());
      }
      try
      {
        paramBundle.mergeFrom(((NowSummaryCard.NearbySummaryCardRsp)localObject).pb_data.get().toByteArray());
        paramInt = 1;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NowSummaryCard, merge error e=");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        QLog.i("NearbyCardHandler", 1, ((StringBuilder)localObject).toString(), paramArrayOfByte);
      }
    }
    else
    {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      NearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, true, paramBundle, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData);
      return;
    }
    NearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, false, null, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.business.NearbyCardHandler.2
 * JD-Core Version:    0.7.0.1
 */