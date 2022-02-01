package tencent.im.nearfield_date;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class nearby_date$BusiReqHead
  extends MessageMicro<BusiReqHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_version", "int32_seq" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, BusiReqHead.class);
  public final PBInt32Field int32_seq = PBField.initInt32(0);
  public final PBInt32Field int32_version = PBField.initInt32(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.nearfield_date.nearby_date.BusiReqHead
 * JD-Core Version:    0.7.0.1
 */