package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xfc2$SecurityStrikeReq
  extends MessageMicro<SecurityStrikeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "msg_cmd", "str_fileid", "uint64_seq", "msg_key" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), null }, SecurityStrikeReq.class);
  public final PBEnumField msg_cmd = PBField.initEnum(0);
  public oidb_0xfc2.MsgKey msg_key = new oidb_0xfc2.MsgKey();
  public final PBStringField str_fileid = PBField.initString("");
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.SecurityStrikeReq
 * JD-Core Version:    0.7.0.1
 */