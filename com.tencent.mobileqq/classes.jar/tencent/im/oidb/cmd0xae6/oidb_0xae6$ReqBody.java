package tencent.im.oidb.cmd0xae6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xae6$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "type", "source", "group_id", "quote_msg_info", "comment_msg_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null }, ReqBody.class);
  public oidb_0xae6.MsgInfo comment_msg_info = new oidb_0xae6.MsgInfo();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public oidb_0xae6.MsgInfo quote_msg_info = new oidb_0xae6.MsgInfo();
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae6.oidb_0xae6.ReqBody
 * JD-Core Version:    0.7.0.1
 */