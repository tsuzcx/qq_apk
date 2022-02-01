package tencent.im.oidb.cmd0xef7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xef7$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "idol_info", "rank" }, new Object[] { null, Long.valueOf(0L) }, RspBody.class);
  public oidb_0xef7.IdolInfo idol_info = new oidb_0xef7.IdolInfo();
  public final PBUInt64Field rank = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef7.oidb_0xef7.RspBody
 * JD-Core Version:    0.7.0.1
 */