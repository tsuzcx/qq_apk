package tencent.im.oidb.cmd0xd6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd6b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 88 }, new String[] { "max_pkg_size", "start_time", "rpt_uin_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt32Field max_pkg_size = PBField.initUInt32(0);
  public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.ReqBody
 * JD-Core Version:    0.7.0.1
 */