package tencent.im.oidb.cmd0xef0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xef0$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "rpt_uint64_group_code", "msg_group_info_ext" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public oidb_0xef0.GroupInfoExt msg_group_info_ext = new oidb_0xef0.GroupInfoExt();
  public final PBRepeatField<Long> rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef0.oidb_0xef0.ReqBody
 * JD-Core Version:    0.7.0.1
 */