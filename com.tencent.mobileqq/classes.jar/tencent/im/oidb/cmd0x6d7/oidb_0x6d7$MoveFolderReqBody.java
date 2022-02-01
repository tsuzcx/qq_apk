package tencent.im.oidb.cmd0x6d7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6d7$MoveFolderReqBody
  extends MessageMicro<MoveFolderReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint64_group_code", "uint32_app_id", "str_folder_id", "str_parent_folder_id", "str_dest_folder_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", "" }, MoveFolderReqBody.class);
  public final PBStringField str_dest_folder_id = PBField.initString("");
  public final PBStringField str_folder_id = PBField.initString("");
  public final PBStringField str_parent_folder_id = PBField.initString("");
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d7.oidb_0x6d7.MoveFolderReqBody
 * JD-Core Version:    0.7.0.1
 */