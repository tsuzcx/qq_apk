package tencent.im.oidb.cmd0xdad;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xdad$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "errmsg" }, new Object[] { Long.valueOf(0L), "" }, RspBody.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBInt64Field retcode = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdad.cmd0xdad.RspBody
 * JD-Core Version:    0.7.0.1
 */