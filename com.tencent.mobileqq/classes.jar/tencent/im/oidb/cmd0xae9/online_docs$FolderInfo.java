package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class online_docs$FolderInfo
  extends MessageMicro<FolderInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field create_ts = PBField.initUInt32(0);
  public final PBStringField folder_id = PBField.initString("");
  public final PBUInt32Field modify_ts = PBField.initUInt32(0);
  public final PBStringField parent_folder_id = PBField.initString("");
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48 }, new String[] { "folder_id", "title", "create_ts", "modify_ts", "parent_folder_id", "status" }, new Object[] { "", "", localInteger, localInteger, "", localInteger }, FolderInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.online_docs.FolderInfo
 * JD-Core Version:    0.7.0.1
 */