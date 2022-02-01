package com.tencent.mobileqq.troop.handler;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class TroopInfoHandler$HandleOidb0x88d10InitPkg
{
  private int jdField_a_of_type_Int;
  private oidb_sso.OIDBSSOPkg jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public TroopInfoHandler$HandleOidb0x88d10InitPkg(TroopInfoHandler paramTroopInfoHandler, byte[] paramArrayOfByte, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public HandleOidb0x88d10InitPkg a()
  {
    this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg = null;
    try
    {
      this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg = ((oidb_sso.OIDBSSOPkg)this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.mergeFrom(this.jdField_a_of_type_ArrayOfByte));
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handle_0x88d_10|oidb_sso parseFrom byte ");
        localStringBuilder.append(localInvalidProtocolBufferMicroException.toString());
        QLog.d("Q.troopdisband.", 2, localStringBuilder.toString());
      }
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    Object localObject = this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg;
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handle_0x88d_10|oidb_sso.OIDBSSOPkg.result ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("TroopInfoHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    return this;
  }
  
  public oidb_sso.OIDBSSOPkg a()
  {
    return this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopInfoHandler.HandleOidb0x88d10InitPkg
 * JD-Core Version:    0.7.0.1
 */