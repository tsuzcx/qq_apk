package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf26$RevokeReq
  extends MessageMicro<RevokeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16 }, new String[] { "auth_group_id" }, new Object[] { Integer.valueOf(0) }, RevokeReq.class);
  public final PBRepeatField<Integer> auth_group_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf26.oidb_0xf26.RevokeReq
 * JD-Core Version:    0.7.0.1
 */