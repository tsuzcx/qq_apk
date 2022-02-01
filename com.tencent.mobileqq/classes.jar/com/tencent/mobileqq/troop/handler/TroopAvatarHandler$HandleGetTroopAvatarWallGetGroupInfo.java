package com.tencent.mobileqq.troop.handler;

import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;

class TroopAvatarHandler$HandleGetTroopAvatarWallGetGroupInfo
{
  private String b;
  private long c;
  private int d;
  private byte[] e;
  private oidb_0x88d.GroupInfo f;
  
  public TroopAvatarHandler$HandleGetTroopAvatarWallGetGroupInfo(TroopAvatarHandler paramTroopAvatarHandler, String paramString, long paramLong, int paramInt, byte... paramVarArgs)
  {
    this.b = paramString;
    this.c = paramLong;
    this.d = paramInt;
    this.e = paramVarArgs;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public oidb_0x88d.GroupInfo c()
  {
    return this.f;
  }
  
  public HandleGetTroopAvatarWallGetGroupInfo d()
  {
    oidb_0x88d.RspBody localRspBody = new oidb_0x88d.RspBody();
    localRspBody.mergeFrom(this.e);
    if ((this.d != 0) && (localRspBody.str_errorinfo.has())) {
      this.b = String.valueOf(localRspBody.str_errorinfo.get().toByteArray());
    }
    this.f = null;
    Object localObject = localRspBody.stzrspgroupinfo.get();
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    while ((this.f == null) && (j < i))
    {
      oidb_0x88d.RspGroupInfo localRspGroupInfo = (oidb_0x88d.RspGroupInfo)((List)localObject).get(j);
      if ((localRspGroupInfo != null) && (localRspGroupInfo.uint64_group_code.get() == this.c))
      {
        this.d = localRspGroupInfo.uint32_result.get();
        if ((this.d == 0) && (localRspGroupInfo.stgroupinfo.has())) {
          this.f = ((oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get());
        }
      }
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("oidb_0x88d_7.RspBody: {\n");
      ((StringBuilder)localObject).append(OidbWrapper.proto2String(localRspBody));
      ((StringBuilder)localObject).append("}");
      QLog.d("TroopAvatarHandler", 2, ((StringBuilder)localObject).toString());
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopAvatarHandler.HandleGetTroopAvatarWallGetGroupInfo
 * JD-Core Version:    0.7.0.1
 */