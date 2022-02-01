package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x6d6$MoveFileRspBody
  extends MessageMicro<MoveFileRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "str_parent_folder_id" }, new Object[] { Integer.valueOf(0), "", "", "" }, MoveFileRspBody.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBStringField str_parent_folder_id = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d6.oidb_0x6d6.MoveFileRspBody
 * JD-Core Version:    0.7.0.1
 */