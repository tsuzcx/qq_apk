package tencent.im.oidb.cmd0xbd6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbd6$Invitee
  extends MessageMicro<Invitee>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_uin", "uint32_from", "uint32_ts" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, Invitee.class);
  public final PBStringField str_uin = PBField.initString("");
  public final PBUInt32Field uint32_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.Invitee
 * JD-Core Version:    0.7.0.1
 */