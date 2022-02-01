package com.tencent.pb.remind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class RemindPB$RemindQuota
  extends MessageMicro<RemindQuota>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_comm_quota = PBField.initUInt32(0);
  public final PBUInt32Field uint32_svip_quota = PBField.initUInt32(0);
  public final PBUInt32Field uint32_used = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_quota = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_comm_quota", "uint32_svip_quota", "uint32_user_quota", "uint32_used" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, RemindQuota.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.remind.RemindPB.RemindQuota
 * JD-Core Version:    0.7.0.1
 */