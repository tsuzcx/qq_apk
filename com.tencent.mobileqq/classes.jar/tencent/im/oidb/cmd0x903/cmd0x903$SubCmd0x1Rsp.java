package tencent.im.oidb.cmd0x903;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x903$SubCmd0x1Rsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_group_code" }, new Object[] { Long.valueOf(0L) }, SubCmd0x1Rsp.class);
  public final PBRepeatField rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x903.cmd0x903.SubCmd0x1Rsp
 * JD-Core Version:    0.7.0.1
 */