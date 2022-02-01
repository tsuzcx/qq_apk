package tencent.im.s2c.msgtype0x210.submsgtype0xc1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc1$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_groupid", "uint32_member_num", "string_data" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, MsgBody.class);
  public final PBStringField string_data = PBField.initString("");
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_groupid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc1.submsgtype0xc1.MsgBody
 * JD-Core Version:    0.7.0.1
 */