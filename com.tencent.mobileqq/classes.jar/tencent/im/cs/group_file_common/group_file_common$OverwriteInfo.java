package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_file_common$OverwriteInfo
  extends MessageMicro<OverwriteInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_file_id", "uint32_download_times" }, new Object[] { "", Integer.valueOf(0) }, OverwriteInfo.class);
  public final PBStringField str_file_id = PBField.initString("");
  public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common.OverwriteInfo
 * JD-Core Version:    0.7.0.1
 */