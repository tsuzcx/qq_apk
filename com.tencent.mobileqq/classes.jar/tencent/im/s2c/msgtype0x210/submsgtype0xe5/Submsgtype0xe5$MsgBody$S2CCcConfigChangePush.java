package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0xe5$MsgBody$S2CCcConfigChangePush
  extends MessageMicro<S2CCcConfigChangePush>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_optype" }, new Object[] { Integer.valueOf(0) }, S2CCcConfigChangePush.class);
  public final PBUInt32Field uint32_optype = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CCcConfigChangePush
 * JD-Core Version:    0.7.0.1
 */