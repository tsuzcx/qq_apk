package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x791$SetRotDotAppidsRes
  extends MessageMicro<SetRotDotAppidsRes>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint32_failed_appid" }, new Object[] { Integer.valueOf(0) }, SetRotDotAppidsRes.class);
  public final PBRepeatField<Integer> rpt_uint32_failed_appid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.SetRotDotAppidsRes
 * JD-Core Version:    0.7.0.1
 */