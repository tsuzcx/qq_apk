package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x51d$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint64_handled_uin", "opt_uint64_office_appid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt64Field opt_uint64_handled_uin = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_office_appid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51d.oidb_0x51d.ReqBody
 * JD-Core Version:    0.7.0.1
 */