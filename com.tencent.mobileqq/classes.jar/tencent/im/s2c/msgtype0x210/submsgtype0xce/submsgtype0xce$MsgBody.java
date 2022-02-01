package tencent.im.s2c.msgtype0x210.submsgtype0xce;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class submsgtype0xce$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field int64_endTime = PBField.initInt64(0L);
  public final PBInt64Field int64_startTime = PBField.initInt64(0L);
  public final PBStringField string_params = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int64_startTime", "int64_endTime", "string_params" }, new Object[] { localLong, localLong, "" }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xce.submsgtype0xce.MsgBody
 * JD-Core Version:    0.7.0.1
 */