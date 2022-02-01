package com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commResponse;
import com.tencent.jungle.videohub.proto.CommonUserProto.LoginCheckRsp;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel.CsChannelObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class ODCsChannelImpl$2
  extends ProtoUtils.TroopProtocolObserver
{
  ODCsChannelImpl$2(ODCsChannelImpl paramODCsChannelImpl, int paramInt1, int paramInt2, byte[] paramArrayOfByte, IODCsChannel.CsChannelObserver paramCsChannelObserver) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("login: errorCode=");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append(" bundle=");
      if (paramBundle == null) {
        localObject1 = "null";
      } else {
        localObject1 = paramBundle.toString();
      }
      localStringBuilder1.append((String)localObject1);
      localStringBuilder1.append(" data=");
      localStringBuilder1.append(Arrays.toString(paramArrayOfByte));
      QLog.d("ODCsChannel", 2, localStringBuilder1.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      localObject1 = new CommProtocolProto.commResponse();
      try
      {
        ((CommProtocolProto.commResponse)localObject1).mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        localInvalidProtocolBufferMicroException1.printStackTrace();
        ((CommProtocolProto.commResponse)localObject1).code.set(-10);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("login: error=");
        localStringBuilder2.append(localInvalidProtocolBufferMicroException1.getMessage());
        QLog.e("ODCsChannel", 2, localStringBuilder2.toString());
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" code=");
        ((StringBuilder)localObject2).append(((CommProtocolProto.commResponse)localObject1).code.get());
        ((StringBuilder)localObject2).append(" msg=");
        ((StringBuilder)localObject2).append(((CommProtocolProto.commResponse)localObject1).msg.get());
        ((StringBuilder)localObject2).append(" seq=");
        ((StringBuilder)localObject2).append(((CommProtocolProto.commResponse)localObject1).seq.get());
        ((StringBuilder)localObject2).append(" data[]=");
        ((StringBuilder)localObject2).append(Arrays.toString(((CommProtocolProto.commResponse)localObject1).body.get().toByteArray()));
        QLog.d("ODCsChannel", 2, new Object[] { "MSF.C.NetConnTag", ((StringBuilder)localObject2).toString() });
      }
      if (((CommProtocolProto.commResponse)localObject1).code.get() == 1008)
      {
        QLog.i("ODCsChannel", 2, "sendPBRequest: fail，token illegal, errorCode=1008");
        ODCsChannelImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, this.b, this.jdField_a_of_type_ArrayOfByte, true, this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
        return;
      }
      if (((CommProtocolProto.commResponse)localObject1).code.get() != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("login: fail，errorCode=");
        ((StringBuilder)localObject2).append(((CommProtocolProto.commResponse)localObject1).code.get());
        ((StringBuilder)localObject2).append(" data=");
        ((StringBuilder)localObject2).append(Arrays.toString(paramArrayOfByte));
        QLog.i("ODCsChannel", 2, ((StringBuilder)localObject2).toString());
        i = this.jdField_a_of_type_Int;
        if (i > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl.login(this.b, this.jdField_a_of_type_ArrayOfByte, i - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
          return;
        }
        ODCsChannelImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, paramInt, null, paramBundle, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
        return;
      }
      Object localObject2 = new CommonUserProto.LoginCheckRsp();
      try
      {
        ((CommonUserProto.LoginCheckRsp)localObject2).mergeFrom(((CommProtocolProto.commResponse)localObject1).body.get().toByteArray());
        ODCsChannelImpl.access$302(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, (CommonUserProto.LoginCheckRsp)localObject2);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        localInvalidProtocolBufferMicroException2.printStackTrace();
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("startGroupVideoOrVoice error=");
        localStringBuilder3.append(localInvalidProtocolBufferMicroException2.getMessage());
        QLog.e("ODCsChannel", 2, localStringBuilder3.toString());
      }
      if (ODCsChannelImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl) == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("login: fail，errorCode=");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" data=");
        ((StringBuilder)localObject2).append(Arrays.toString(paramArrayOfByte));
        QLog.i("ODCsChannel", 2, ((StringBuilder)localObject2).toString());
        i = this.jdField_a_of_type_Int;
        if (i > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl.login(this.b, this.jdField_a_of_type_ArrayOfByte, i - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
          return;
        }
        ODCsChannelImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, paramInt, (CommProtocolProto.commResponse)localObject1, paramBundle, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append(" uid=");
        paramBundle.append(((CommonUserProto.LoginCheckRsp)localObject2).uid.get());
        paramBundle.append(" user_sig=");
        paramBundle.append(((CommonUserProto.LoginCheckRsp)localObject2).user_sig.get());
        QLog.d("ODCsChannel", 2, new Object[] { "MSF.C.NetConnTag", paramBundle.toString() });
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl.sendRequest(this.b, paramArrayOfByte, true, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("login: fail，errorCode=");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" data=");
    ((StringBuilder)localObject1).append(Arrays.toString(paramArrayOfByte));
    QLog.i("ODCsChannel", 2, ((StringBuilder)localObject1).toString());
    int i = this.jdField_a_of_type_Int;
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl.login(this.b, this.jdField_a_of_type_ArrayOfByte, i - 1, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
      return;
    }
    ODCsChannelImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelImplODCsChannelImpl, paramInt, null, paramBundle, this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoCschannelIODCsChannel$CsChannelObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl.ODCsChannelImpl.2
 * JD-Core Version:    0.7.0.1
 */