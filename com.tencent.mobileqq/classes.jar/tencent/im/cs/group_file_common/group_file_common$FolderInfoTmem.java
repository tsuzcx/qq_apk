package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_file_common$FolderInfoTmem
  extends MessageMicro<FolderInfoTmem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_group_code", "rpt_folders" }, new Object[] { Long.valueOf(0L), null }, FolderInfoTmem.class);
  public final PBRepeatMessageField<group_file_common.FolderInfo> rpt_folders = PBField.initRepeatMessage(group_file_common.FolderInfo.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common.FolderInfoTmem
 * JD-Core Version:    0.7.0.1
 */