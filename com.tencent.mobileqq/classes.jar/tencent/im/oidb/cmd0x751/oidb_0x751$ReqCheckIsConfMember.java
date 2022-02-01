package tencent.im.oidb.cmd0x751;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x751$ReqCheckIsConfMember
  extends MessageMicro<ReqCheckIsConfMember>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_conf_uin" }, new Object[] { Long.valueOf(0L) }, ReqCheckIsConfMember.class);
  public final PBRepeatField<Long> rpt_uint64_conf_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x751.oidb_0x751.ReqCheckIsConfMember
 * JD-Core Version:    0.7.0.1
 */