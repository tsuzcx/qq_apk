package tencent.im.oidb.inner.cmd0xca02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xca02$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_type", "rpt_app_ids", "msg_app_info", "uint64_group_code", "uint32_group_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public cmd0xca02.AppInfo msg_app_info = new cmd0xca02.AppInfo();
  public final PBRepeatField<Integer> rpt_app_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.inner.cmd0xca02.cmd0xca02.ReqBody
 * JD-Core Version:    0.7.0.1
 */