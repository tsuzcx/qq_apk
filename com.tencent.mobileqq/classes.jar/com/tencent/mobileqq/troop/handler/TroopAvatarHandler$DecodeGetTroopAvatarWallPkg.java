package com.tencent.mobileqq.troop.handler;

import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class TroopAvatarHandler$DecodeGetTroopAvatarWallPkg
{
  private byte[] b;
  private int c;
  private oidb_sso.OIDBSSOPkg d;
  
  public TroopAvatarHandler$DecodeGetTroopAvatarWallPkg(TroopAvatarHandler paramTroopAvatarHandler, byte[] paramArrayOfByte, int paramInt)
  {
    this.b = paramArrayOfByte;
    this.c = paramInt;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public oidb_sso.OIDBSSOPkg b()
  {
    return this.d;
  }
  
  public DecodeGetTroopAvatarWallPkg c()
  {
    this.d = new oidb_sso.OIDBSSOPkg();
    try
    {
      this.d = ((oidb_sso.OIDBSSOPkg)this.d.mergeFrom(this.b));
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handle_oidb_0x88d_7|oidb_sso parseFrom byte ");
        localStringBuilder.append(localInvalidProtocolBufferMicroException.toString());
        QLog.d("Q.troopdisband.", 2, localStringBuilder.toString());
      }
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      this.c = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("oidb_sso.OIDBSSOPkg(oidb_0x88d_7): {\n");
        ((StringBuilder)localObject).append(OidbWrapper.proto2String(this.d));
        ((StringBuilder)localObject).append("}");
        QLog.d("TroopAvatarHandler", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handle_oidb_0x88d_7|oidb_sso.OIDBSSOPkg.result ");
        ((StringBuilder)localObject).append(this.c);
        QLog.d("Q.troopdisband.", 2, ((StringBuilder)localObject).toString());
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopAvatarHandler.DecodeGetTroopAvatarWallPkg
 * JD-Core Version:    0.7.0.1
 */