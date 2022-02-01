package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x59f$Guidelines_common
  extends MessageMicro<Guidelines_common>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_welcomepage_flag", "msg_guidelines_web" }, new Object[] { Integer.valueOf(0), null }, Guidelines_common.class);
  public oidb_0x59f.Guidelines_common_web msg_guidelines_web = new oidb_0x59f.Guidelines_common_web();
  public final PBUInt32Field uint32_welcomepage_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_common
 * JD-Core Version:    0.7.0.1
 */