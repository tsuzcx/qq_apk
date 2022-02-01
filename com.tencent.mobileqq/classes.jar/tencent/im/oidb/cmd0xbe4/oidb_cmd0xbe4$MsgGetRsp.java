package tencent.im.oidb.cmd0xbe4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbe4$MsgGetRsp
  extends MessageMicro<MsgGetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_unread", "uint64_max_seq", "msg_body" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, MsgGetRsp.class);
  public oidb_cmd0xbe4.MsgBody msg_body = new oidb_cmd0xbe4.MsgBody();
  public final PBUInt64Field uint64_max_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_unread = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetRsp
 * JD-Core Version:    0.7.0.1
 */