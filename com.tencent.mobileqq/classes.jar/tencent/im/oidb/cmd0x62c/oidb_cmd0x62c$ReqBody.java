package tencent.im.oidb.cmd0x62c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x62c$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16 }, new String[] { "uint64_tinyid" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
  public final PBRepeatField<Long> uint64_tinyid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x62c.oidb_cmd0x62c.ReqBody
 * JD-Core Version:    0.7.0.1
 */