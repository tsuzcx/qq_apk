package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xea0$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "req_client_type", "version", "channel_id", "channel_name" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), "" }, ReqBody.class);
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBStringField channel_name = PBField.initString("");
  public final PBUInt32Field req_client_type = PBField.initUInt32(0);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.ReqBody
 * JD-Core Version:    0.7.0.1
 */