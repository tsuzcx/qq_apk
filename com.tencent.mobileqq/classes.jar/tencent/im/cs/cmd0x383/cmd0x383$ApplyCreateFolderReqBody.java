package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyCreateFolderReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_bus_id", "str_folder_name", "str_parent_folder_path" }, new Object[] { Integer.valueOf(0), "", "" }, ApplyCreateFolderReqBody.class);
  public final PBStringField str_folder_name = PBField.initString("");
  public final PBStringField str_parent_folder_path = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyCreateFolderReqBody
 * JD-Core Version:    0.7.0.1
 */