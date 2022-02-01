package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x346$RecallFileRsp
  extends MessageMicro<RecallFileRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_ret_code", "str_ret_msg" }, new Object[] { Integer.valueOf(0), "" }, RecallFileRsp.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.RecallFileRsp
 * JD-Core Version:    0.7.0.1
 */