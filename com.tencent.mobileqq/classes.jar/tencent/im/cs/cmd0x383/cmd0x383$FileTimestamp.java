package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$FileTimestamp
  extends MessageMicro<FileTimestamp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_upload_time", "str_file_path" }, new Object[] { Integer.valueOf(0), "" }, FileTimestamp.class);
  public final PBStringField str_file_path = PBField.initString("");
  public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.FileTimestamp
 * JD-Core Version:    0.7.0.1
 */