package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_cmd0xc46$PageCookie
  extends MessageMicro<PageCookie>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "index", "last_timestamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, PageCookie.class);
  public final PBInt32Field index = PBField.initInt32(0);
  public final PBInt64Field last_timestamp = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.PageCookie
 * JD-Core Version:    0.7.0.1
 */