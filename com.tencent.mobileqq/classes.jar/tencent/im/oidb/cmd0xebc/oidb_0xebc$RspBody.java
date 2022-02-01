package tencent.im.oidb.cmd0xebc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xebc$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "type", "rank" }, new Object[] { "", Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field rank = PBField.initUInt32(0);
  public final PBStringField type = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xebc.oidb_0xebc.RspBody
 * JD-Core Version:    0.7.0.1
 */