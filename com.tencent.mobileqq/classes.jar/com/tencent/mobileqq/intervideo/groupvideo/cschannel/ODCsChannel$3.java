package com.tencent.mobileqq.intervideo.groupvideo.cschannel;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class ODCsChannel$3
  extends ProtoUtils.TroopProtocolObserver
{
  ODCsChannel$3(ODCsChannel paramODCsChannel, int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, ODCsChannel.CsChannelObserver paramCsChannelObserver) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("sendPBRequest errorCode=").append(paramInt).append(" bundle=");
      if (paramBundle == null)
      {
        localObject = "null";
        localStringBuilder = localStringBuilder.append((String)localObject).append(" data=");
        if (paramArrayOfByte != null) {
          break label174;
        }
        localObject = "is null";
        label59:
        QLog.d("ODCsChannel", 2, (String)localObject);
      }
    }
    else
    {
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break label206;
      }
      localObject = new StringBuilder().append("login: fail，errorCode=").append(paramInt).append(" data=");
      if (paramArrayOfByte != null) {
        break label183;
      }
    }
    label174:
    label183:
    for (paramArrayOfByte = "is null";; paramArrayOfByte = Arrays.toString(paramArrayOfByte))
    {
      QLog.i("ODCsChannel", 2, paramArrayOfByte);
      if (this.jdField_a_of_type_Int <= 0) {
        break label191;
      }
      ODCsChannel.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel, this.c, this.jdField_a_of_type_ArrayOfByte, this.b, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel$CsChannelObserver);
      return;
      localObject = paramBundle.toString();
      break;
      localObject = Arrays.toString(paramArrayOfByte);
      break label59;
    }
    label191:
    ODCsChannel.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel, paramInt, null, paramBundle, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel$CsChannelObserver);
    return;
    label206:
    Object localObject = new CommProtocolProto.commResponse();
    try
    {
      ((CommProtocolProto.commResponse)localObject).mergeFrom(paramArrayOfByte);
      if (((CommProtocolProto.commResponse)localObject).code.get() == 1008)
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，token illegal, errorCode=1008");
        ODCsChannel.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel, this.c, this.jdField_a_of_type_ArrayOfByte, this.b, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel$CsChannelObserver);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        ((CommProtocolProto.commResponse)localObject).code.set(-10);
        QLog.e("ODCsChannel", 2, "sendPBRequest: error=" + paramArrayOfByte.getMessage());
      }
      if (((CommProtocolProto.commResponse)localObject).code.get() == 1006)
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，user sig illegal, errorCode=1006");
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel.a(this.c, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel$CsChannelObserver);
        return;
      }
      if ((((CommProtocolProto.commResponse)localObject).code.get() != 0) && (this.jdField_a_of_type_Int > 0))
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，errorCode=" + ((CommProtocolProto.commResponse)localObject).code.get());
        ODCsChannel.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel, this.c, this.jdField_a_of_type_ArrayOfByte, this.b, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel$CsChannelObserver);
        return;
      }
      ODCsChannel.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel, paramInt, (CommProtocolProto.commResponse)localObject, paramBundle, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelODCsChannel$CsChannelObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.cschannel.ODCsChannel.3
 * JD-Core Version:    0.7.0.1
 */