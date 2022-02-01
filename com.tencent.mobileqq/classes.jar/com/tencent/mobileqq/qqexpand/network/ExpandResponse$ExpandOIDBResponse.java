package com.tencent.mobileqq.qqexpand.network;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ExpandResponse$ExpandOIDBResponse
  extends ExpandResponse
{
  private oidb_sso.OIDBSSOPkg d;
  
  public ExpandResponse$ExpandOIDBResponse(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d = new oidb_sso.OIDBSSOPkg();
    if (this.a == 1000)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        this.d.mergeFrom(paramArrayOfByte);
        this.a = this.d.uint32_result.get();
        this.b = this.d.str_error_msg.get();
        localStringBuilder.append("parseOIDBPkg, errMsg: ");
        localStringBuilder.append(this.b);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        localStringBuilder.append("parseOIDBPkg, oidb_sso, parseFrom byte ");
        localStringBuilder.append(paramArrayOfByte.toString());
        paramArrayOfByte.printStackTrace();
      }
      if ((localStringBuilder.length() > 0) && (QLog.isDevelopLevel())) {
        QLog.i("expand.cmd.ExpandOIDBResponse", 4, localStringBuilder.toString());
      }
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("cmd error=");
      paramArrayOfByte.append(this.a);
      paramArrayOfByte.append(" msg=");
      paramArrayOfByte.append(this.b);
      QLog.w("expand.cmd.ExpandOIDBResponse", 1, paramArrayOfByte.toString());
    }
  }
  
  @Nullable
  public byte[] a()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = this.d;
    if ((localOIDBSSOPkg != null) && (localOIDBSSOPkg.bytes_bodybuffer.has()) && (this.d.bytes_bodybuffer.get() != null)) {
      return this.d.bytes_bodybuffer.get().toByteArray();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandResponse.ExpandOIDBResponse
 * JD-Core Version:    0.7.0.1
 */