package com.tencent.pb.pendant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class DiyAddonPbInfo$AddonGetDiyInfoRsp
  extends MessageMicro<AddonGetDiyInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "userdiyinfo" }, new Object[] { null }, AddonGetDiyInfoRsp.class);
  public final PBRepeatMessageField<DiyAddonUser.UserDiyInfo> userdiyinfo = PBField.initRepeatMessage(DiyAddonUser.UserDiyInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.pendant.DiyAddonPbInfo.AddonGetDiyInfoRsp
 * JD-Core Version:    0.7.0.1
 */