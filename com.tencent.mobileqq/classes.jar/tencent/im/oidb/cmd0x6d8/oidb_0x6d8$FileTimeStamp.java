package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6d8$FileTimeStamp
  extends MessageMicro<FileTimeStamp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_upload_time", "str_file_id" }, new Object[] { Integer.valueOf(0), "" }, FileTimeStamp.class);
  public final PBStringField str_file_id = PBField.initString("");
  public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d8.oidb_0x6d8.FileTimeStamp
 * JD-Core Version:    0.7.0.1
 */