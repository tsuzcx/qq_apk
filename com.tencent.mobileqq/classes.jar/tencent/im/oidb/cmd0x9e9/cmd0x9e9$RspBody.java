package tencent.im.oidb.cmd0x9e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class cmd0x9e9$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_end = PBField.initBool(false);
  public final PBInt64Field int64_total_divide_point = PBField.initInt64(0L);
  public final PBInt64Field int64_total_point = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int64_total_point", "int64_total_divide_point", "bool_is_end" }, new Object[] { localLong, localLong, Boolean.valueOf(false) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9e9.cmd0x9e9.RspBody
 * JD-Core Version:    0.7.0.1
 */