package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$FileControl
  extends MessageMicro<FileControl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64 }, new String[] { "uint64_sessionid", "uint32_operate", "uint32_seq", "uint32_code", "str_msg", "uint32_group_id", "uint32_group_curindex", "uint32_batchID" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FileControl.class);
  public final PBStringField str_msg = PBField.initString("");
  public final PBUInt32Field uint32_batchID = PBField.initUInt32(0);
  public final PBUInt32Field uint32_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_curindex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_operate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FileControl
 * JD-Core Version:    0.7.0.1
 */