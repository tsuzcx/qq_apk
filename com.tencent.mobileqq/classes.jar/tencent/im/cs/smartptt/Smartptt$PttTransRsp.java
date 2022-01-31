package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Smartptt$PttTransRsp
  extends MessageMicro<PttTransRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "uint32_ret_code", "str_voice_id", "uint32_is_final", "str_text", "uint32_offset" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0) }, PttTransRsp.class);
  public final PBStringField str_text = PBField.initString("");
  public final PBStringField str_voice_id = PBField.initString("");
  public final PBUInt32Field uint32_is_final = PBField.initUInt32(0);
  public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.smartptt.Smartptt.PttTransRsp
 * JD-Core Version:    0.7.0.1
 */