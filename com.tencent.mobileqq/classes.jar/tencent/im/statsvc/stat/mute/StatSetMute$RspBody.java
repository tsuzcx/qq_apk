package tencent.im.statsvc.stat.mute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class StatSetMute$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field error_code = PBField.initUInt32(0);
  public final PBStringField error_msg = PBField.initString("");
  public final PBUInt32Field set_mute_resp = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "error_code", "error_msg", "set_mute_resp" }, new Object[] { localInteger, "", localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.statsvc.stat.mute.StatSetMute.RspBody
 * JD-Core Version:    0.7.0.1
 */