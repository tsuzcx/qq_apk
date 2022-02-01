package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_file_common$FolderInfo
  extends MessageMicro<FolderInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_creator_name = PBField.initString("");
  public final PBStringField str_folder_id = PBField.initString("");
  public final PBStringField str_folder_name = PBField.initString("");
  public final PBStringField str_modify_name = PBField.initString("");
  public final PBStringField str_parent_folder_id = PBField.initString("");
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_file_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_modify_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 64, 72, 82, 88 }, new String[] { "str_folder_id", "str_parent_folder_id", "str_folder_name", "uint32_create_time", "uint32_modify_time", "uint64_create_uin", "str_creator_name", "uint32_total_file_count", "uint64_modify_uin", "str_modify_name", "uint64_used_space" }, new Object[] { "", "", "", localInteger, localInteger, localLong, "", localInteger, localLong, "", localLong }, FolderInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common.FolderInfo
 * JD-Core Version:    0.7.0.1
 */