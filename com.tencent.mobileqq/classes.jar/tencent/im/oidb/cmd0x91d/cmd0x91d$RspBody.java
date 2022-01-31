package tencent.im.oidb.cmd0x91d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x91d$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_update_info", "uint64_last_time" }, new Object[] { null, Long.valueOf(0L) }, RspBody.class);
  public cmd0x91d.LabelUpdateInfo msg_update_info = new cmd0x91d.LabelUpdateInfo();
  public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x91d.cmd0x91d.RspBody
 * JD-Core Version:    0.7.0.1
 */