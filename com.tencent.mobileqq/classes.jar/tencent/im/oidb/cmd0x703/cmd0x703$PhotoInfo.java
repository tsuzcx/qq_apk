package tencent.im.oidb.cmd0x703;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x703$PhotoInfo
  extends MessageMicro<PhotoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34, 40 }, new String[] { "uint32_id", "uint32_is_invalid", "str_url", "uint32_timestamp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, PhotoInfo.class);
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_invalid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x703.cmd0x703.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */