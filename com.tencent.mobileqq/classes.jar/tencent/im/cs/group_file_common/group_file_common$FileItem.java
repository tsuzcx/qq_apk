package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_file_common$FileItem
  extends MessageMicro<FileItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "folder_info", "file_info" }, new Object[] { Integer.valueOf(0), null, null }, FileItem.class);
  public group_file_common.FileInfo file_info = new group_file_common.FileInfo();
  public group_file_common.FolderInfo folder_info = new group_file_common.FolderInfo();
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common.FileItem
 * JD-Core Version:    0.7.0.1
 */