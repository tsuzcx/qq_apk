package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;
import tencent.im.cs.group_file_common.group_file_common.FolderInfo;

public final class oidb_0x6d8$GetFileListRspBody$Item
  extends MessageMicro<Item>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "folder_info", "file_info" }, new Object[] { Integer.valueOf(0), null, null }, Item.class);
  public group_file_common.FileInfo file_info = new group_file_common.FileInfo();
  public group_file_common.FolderInfo folder_info = new group_file_common.FolderInfo();
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListRspBody.Item
 * JD-Core Version:    0.7.0.1
 */