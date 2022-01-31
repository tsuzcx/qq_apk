package tencent.im.oidb.cmd0x59a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x59a$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_category_id", "msg_expert_info" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public oidb_cmd0x59a.ExpertInfo msg_expert_info = new oidb_cmd0x59a.ExpertInfo();
  public final PBUInt32Field uint32_category_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59a.oidb_cmd0x59a.RspBody
 * JD-Core Version:    0.7.0.1
 */