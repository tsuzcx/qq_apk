package tencent.im.oidb.cmd0x6ef;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x6ef$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "gc", "event_id", "seq" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L) }, ReqBody.class);
  public final PBStringField event_id = PBField.initString("");
  public final PBUInt64Field gc = PBField.initUInt64(0L);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.ReqBody
 * JD-Core Version:    0.7.0.1
 */