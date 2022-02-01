package tencent.im.oidb.cmd0x82a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x82a$MsgStatus
  extends MessageMicro<MsgStatus>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_info", "uint32_status" }, new Object[] { null, Integer.valueOf(0) }, MsgStatus.class);
  public cmd0x82a.MsgInfo msg_info = new cmd0x82a.MsgInfo();
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x82a.cmd0x82a.MsgStatus
 * JD-Core Version:    0.7.0.1
 */