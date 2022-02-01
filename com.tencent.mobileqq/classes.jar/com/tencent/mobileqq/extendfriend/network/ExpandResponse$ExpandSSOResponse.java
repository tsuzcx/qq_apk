package com.tencent.mobileqq.extendfriend.network;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import expand.network.gateway.SSODownStream;
import expand.network.gateway.SSODownStreamHead;

public class ExpandResponse$ExpandSSOResponse
  extends ExpandResponse
{
  private gateway.SSODownStream a;
  
  public ExpandResponse$ExpandSSOResponse(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Int == 1000)
    {
      this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream = new gateway.SSODownStream();
      this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream.head = new gateway.SSODownStreamHead();
      try
      {
        this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream.mergeFrom(paramArrayOfByte);
        if (this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream.head.has())
        {
          this.jdField_a_of_type_Int = this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream.head.code.get();
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream.head.msg.get();
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.w("expand.cmd.ExpandSSOResponse", 1, paramArrayOfByte.toString());
        this.jdField_a_of_type_Int = 900000002;
        return;
      }
    }
    QLog.w("expand.cmd.ExpandSSOResponse", 1, "cmd error=" + this.jdField_a_of_type_Int + " msg=" + this.jdField_a_of_type_JavaLangString);
  }
  
  @Nullable
  public byte[] a()
  {
    if ((this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream != null) && (this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream.body.has()) && (this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream.body.get() != null)) {
      return this.jdField_a_of_type_ExpandNetworkGateway$SSODownStream.body.get().toByteArray();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.network.ExpandResponse.ExpandSSOResponse
 * JD-Core Version:    0.7.0.1
 */