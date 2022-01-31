package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc32$SetVisibleListReqBody
  extends MessageMicro<SetVisibleListReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_operator", "uint64_feeds_id", "rpt_uint64_visible_uins" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, SetVisibleListReqBody.class);
  public final PBRepeatField<Long> rpt_uint64_visible_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_operator = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.SetVisibleListReqBody
 * JD-Core Version:    0.7.0.1
 */