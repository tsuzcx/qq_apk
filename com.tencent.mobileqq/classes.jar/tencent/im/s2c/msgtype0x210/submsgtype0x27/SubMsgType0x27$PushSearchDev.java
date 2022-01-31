package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$PushSearchDev
  extends MessageMicro<PushSearchDev>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "uint32_msg_type", "msg_gps_info", "uint32_dev_time", "uint32_push_time", "uint64_din", "str_data" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "" }, PushSearchDev.class);
  public SubMsgType0x27.GPS msg_gps_info = new SubMsgType0x27.GPS();
  public final PBStringField str_data = PBField.initString("");
  public final PBUInt32Field uint32_dev_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PushSearchDev
 * JD-Core Version:    0.7.0.1
 */