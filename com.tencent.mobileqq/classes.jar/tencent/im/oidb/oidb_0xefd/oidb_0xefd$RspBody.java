package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xefd$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "retmsg", "retcode", "result" }, new Object[] { "", Integer.valueOf(0), null }, RspBody.class);
  public oidb_0xefd.RspResult result = new oidb_0xefd.RspResult();
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBStringField retmsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xefd.oidb_0xefd.RspBody
 * JD-Core Version:    0.7.0.1
 */