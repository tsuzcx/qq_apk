package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x346$ApplyCopyToRsp
  extends MessageMicro<ApplyCopyToRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242 }, new String[] { "int32_ret_code", "str_ret_msg", "str_file_key" }, new Object[] { Integer.valueOf(0), "", "" }, ApplyCopyToRsp.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_file_key = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp
 * JD-Core Version:    0.7.0.1
 */