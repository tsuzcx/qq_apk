package tencent.im.oidb.cmd0xf10;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf10$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_list", "total_count", "jump_url" }, new Object[] { null, Integer.valueOf(0), "" }, RspBody.class);
  public final PBStringField jump_url = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xf10.MsgInfo> msg_list = PBField.initRepeatMessage(oidb_0xf10.MsgInfo.class);
  public final PBUInt32Field total_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf10.oidb_0xf10.RspBody
 * JD-Core Version:    0.7.0.1
 */