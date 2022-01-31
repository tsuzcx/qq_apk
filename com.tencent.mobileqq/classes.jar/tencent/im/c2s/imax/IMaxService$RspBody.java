package tencent.im.c2s.imax;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class IMaxService$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_ret", "str_msg" }, new Object[] { Integer.valueOf(0), "" }, RspBody.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBStringField str_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.c2s.imax.IMaxService.RspBody
 * JD-Core Version:    0.7.0.1
 */