package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xeac$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 80 }, new String[] { "wording", "digest_uin", "digest_time", "error_code" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field digest_time = PBField.initUInt32(0);
  public final PBUInt64Field digest_uin = PBField.initUInt64(0L);
  public final PBUInt32Field error_code = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.RspBody
 * JD-Core Version:    0.7.0.1
 */