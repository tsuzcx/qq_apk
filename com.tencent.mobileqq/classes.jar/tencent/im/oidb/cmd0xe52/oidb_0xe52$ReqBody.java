package tencent.im.oidb.cmd0xe52;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe52$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_verify_type", "rpt_uint64_schoolmates", "msg_user_school_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, ReqBody.class);
  public oidb_0xe52.SchoolInfo msg_user_school_info = new oidb_0xe52.SchoolInfo();
  public final PBRepeatField<Long> rpt_uint64_schoolmates = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe52.oidb_0xe52.ReqBody
 * JD-Core Version:    0.7.0.1
 */