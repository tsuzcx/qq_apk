package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$MQQCampusNotify
  extends MessageMicro<MQQCampusNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint64_from_uin", "str_wording", "str_target", "uint32_type", "str_source" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), "" }, MQQCampusNotify.class);
  public final PBStringField str_source = PBField.initString("");
  public final PBStringField str_target = PBField.initString("");
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MQQCampusNotify
 * JD-Core Version:    0.7.0.1
 */