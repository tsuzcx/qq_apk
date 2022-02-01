package tencent.im.oidb.cmd0xefb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xefb$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "retmsg" }, new Object[] { Integer.valueOf(0), "" }, RspBody.class);
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBStringField retmsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xefb.oidb_cmd0xefb.RspBody
 * JD-Core Version:    0.7.0.1
 */