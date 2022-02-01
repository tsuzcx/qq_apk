package com.tencent.protofile.oidb_0xe1f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe1f$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "have_redpacket", "id", "start_time", "end_time" }, new Object[] { Boolean.valueOf(false), "", Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBBoolField have_redpacket = PBField.initBool(false);
  public final PBStringField id = PBField.initString("");
  public final PBUInt32Field start_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.oidb_0xe1f.oidb_0xe1f.RspBody
 * JD-Core Version:    0.7.0.1
 */