package com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commResponse;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel.CsChannelObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class ODCsChannelImpl$3
  extends ProtoUtils.TroopProtocolObserver
{
  ODCsChannelImpl$3(ODCsChannelImpl paramODCsChannelImpl, int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, IODCsChannel.CsChannelObserver paramCsChannelObserver) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = QLog.isColorLevel();
    Object localObject2 = "is null";
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPBRequest errorCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" bundle=");
      if (paramBundle == null) {
        localObject1 = "null";
      } else {
        localObject1 = paramBundle.toString();
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" data=");
      if (paramArrayOfByte == null) {
        localObject1 = "is null";
      } else {
        localObject1 = Arrays.toString(paramArrayOfByte);
      }
      localStringBuilder.append((String)localObject1);
      QLog.d("ODCsChannel", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      localObject1 = new CommProtocolProto.commResponse();
      try
      {
        ((CommProtocolProto.commResponse)localObject1).mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ((CommProtocolProto.commResponse)localObject1).code.set(-10);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendPBRequest: error=");
        ((StringBuilder)localObject2).append(paramArrayOfByte.getMessage());
        QLog.e("ODCsChannel", 2, ((StringBuilder)localObject2).toString());
      }
      if (((CommProtocolProto.commResponse)localObject1).code.get() == 1008)
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，token illegal, errorCode=1008");
        ODCsChannelImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, this.b, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
        return;
      }
      if (((CommProtocolProto.commResponse)localObject1).code.get() == 1006)
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，user sig illegal, errorCode=1006");
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl.login(this.b, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
        return;
      }
      if ((((CommProtocolProto.commResponse)localObject1).code.get() != 0) && (this.jdField_a_of_type_Int > 0))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("sendPBRequest: fail，errorCode=");
        paramArrayOfByte.append(((CommProtocolProto.commResponse)localObject1).code.get());
        QLog.i("ODCsChannel", 2, paramArrayOfByte.toString());
        ODCsChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, this.b, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
        return;
      }
      ODCsChannelImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, paramInt, (CommProtocolProto.commResponse)localObject1, paramBundle, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("login: fail，errorCode=");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" data=");
    if (paramArrayOfByte == null) {
      paramArrayOfByte = (byte[])localObject2;
    } else {
      paramArrayOfByte = Arrays.toString(paramArrayOfByte);
    }
    ((StringBuilder)localObject1).append(paramArrayOfByte);
    QLog.i("ODCsChannel", 2, ((StringBuilder)localObject1).toString());
    int i = this.jdField_a_of_type_Int;
    if (i > 0)
    {
      ODCsChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, this.b, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Boolean, i - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
      return;
    }
    ODCsChannelImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, paramInt, null, paramBundle, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl.ODCsChannelImpl.3
 * JD-Core Version:    0.7.0.1
 */