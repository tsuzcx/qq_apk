package com.tencent.mobileqq.qqexpand.network;

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
  private gateway.SSODownStream d;
  
  public ExpandResponse$ExpandSSOResponse(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.a == 1000)
    {
      this.d = new gateway.SSODownStream();
      this.d.head = new gateway.SSODownStreamHead();
      try
      {
        this.d.mergeFrom(paramArrayOfByte);
        if (!this.d.head.has()) {
          return;
        }
        this.a = this.d.head.code.get();
        this.b = this.d.head.msg.get();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.w("expand.cmd.ExpandSSOResponse", 1, paramArrayOfByte.toString());
        this.a = 900000002;
        return;
      }
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("cmd error=");
      paramArrayOfByte.append(this.a);
      paramArrayOfByte.append(" msg=");
      paramArrayOfByte.append(this.b);
      QLog.w("expand.cmd.ExpandSSOResponse", 1, paramArrayOfByte.toString());
    }
  }
  
  @Nullable
  public byte[] a()
  {
    gateway.SSODownStream localSSODownStream = this.d;
    if ((localSSODownStream != null) && (localSSODownStream.body.has()) && (this.d.body.get() != null)) {
      return this.d.body.get().toByteArray();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandResponse.ExpandSSOResponse
 * JD-Core Version:    0.7.0.1
 */