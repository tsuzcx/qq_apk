package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_file_common$FileInfoTmem
  extends MessageMicro<FileInfoTmem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_group_code", "rpt_files" }, new Object[] { Long.valueOf(0L), null }, FileInfoTmem.class);
  public final PBRepeatMessageField<group_file_common.FileInfo> rpt_files = PBField.initRepeatMessage(group_file_common.FileInfo.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common.FileInfoTmem
 * JD-Core Version:    0.7.0.1
 */