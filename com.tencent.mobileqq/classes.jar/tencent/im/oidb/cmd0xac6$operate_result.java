package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xac6$operate_result
  extends MessageMicro<operate_result>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_id", "int32_result", "str_errmsg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, operate_result.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac6.operate_result
 * JD-Core Version:    0.7.0.1
 */