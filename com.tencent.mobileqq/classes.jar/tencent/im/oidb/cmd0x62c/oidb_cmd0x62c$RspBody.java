package tencent.im.oidb.cmd0x62c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x62c$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_tinyid_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0x62c.TinyIDInfo> msg_tinyid_info = PBField.initRepeatMessage(oidb_cmd0x62c.TinyIDInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x62c.oidb_cmd0x62c.RspBody
 * JD-Core Version:    0.7.0.1
 */