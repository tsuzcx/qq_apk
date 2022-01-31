package tencent.im.statsvc.stat.mute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class StatSetMute$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "error_code", "error_msg", "set_mute_resp" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field error_code = PBField.initUInt32(0);
  public final PBStringField error_msg = PBField.initString("");
  public final PBUInt32Field set_mute_resp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.statsvc.stat.mute.StatSetMute.RspBody
 * JD-Core Version:    0.7.0.1
 */