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
  private oidb_sso.OIDBSSOPkg a;
  
  public ExpandResponse$ExpandOIDBResponse(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    if (this.jdField_a_of_type_Int == 1000)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.mergeFrom(paramArrayOfByte);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.uint32_result.get();
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.str_error_msg.get();
        localStringBuilder.append("parseOIDBPkg, errMsg: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
      paramArrayOfByte.append(this.jdField_a_of_type_Int);
      paramArrayOfByte.append(" msg=");
      paramArrayOfByte.append(this.jdField_a_of_type_JavaLangString);
      QLog.w("expand.cmd.ExpandOIDBResponse", 1, paramArrayOfByte.toString());
    }
  }
  
  @Nullable
  public byte[] a()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg;
    if ((localOIDBSSOPkg != null) && (localOIDBSSOPkg.bytes_bodybuffer.has()) && (this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.bytes_bodybuffer.get() != null)) {
      return this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandResponse.ExpandOIDBResponse
 * JD-Core Version:    0.7.0.1
 */