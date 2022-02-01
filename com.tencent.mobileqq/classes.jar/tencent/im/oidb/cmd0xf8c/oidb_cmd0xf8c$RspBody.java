package tencent.im.oidb.cmd0xf8c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf8c$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "irest", "giftmsg" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xf8c.GiftMsg> giftmsg = PBField.initRepeatMessage(oidb_cmd0xf8c.GiftMsg.class);
  public final PBUInt32Field irest = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.RspBody
 * JD-Core Version:    0.7.0.1
 */