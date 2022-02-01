package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb86$NickInfo
  extends MessageMicro<NickInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 104 }, new String[] { "str_nick", "uint64_timestamp" }, new Object[] { "", Long.valueOf(0L) }, NickInfo.class);
  public final PBStringField str_nick = PBField.initString("");
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.NickInfo
 * JD-Core Version:    0.7.0.1
 */