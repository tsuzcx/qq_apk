package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyFeedMsgV2RspBody
  extends MessageMicro<ApplyFeedMsgV2RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 88 }, new String[] { "uint32_total_file_num", "uint32_file_num", "uint32_bus_id", "str_file_path1", "str_file_path2", "str_file_path3", "bool_safe_check_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Boolean.valueOf(false) }, ApplyFeedMsgV2RspBody.class);
  public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
  public final PBStringField str_file_path1 = PBField.initString("");
  public final PBStringField str_file_path2 = PBField.initString("");
  public final PBStringField str_file_path3 = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyFeedMsgV2RspBody
 * JD-Core Version:    0.7.0.1
 */