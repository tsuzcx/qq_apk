package tencent.im.oidb.cmd0xbe7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbe7$Cookies
  extends MessageMicro<Cookies>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_page_index", "int64_timestamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, Cookies.class);
  public final PBInt64Field int64_timestamp = PBField.initInt64(0L);
  public final PBUInt32Field uint32_page_index = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe7.oidb_cmd0xbe7.Cookies
 * JD-Core Version:    0.7.0.1
 */