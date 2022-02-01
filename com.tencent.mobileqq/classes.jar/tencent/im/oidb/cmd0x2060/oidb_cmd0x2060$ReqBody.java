package tencent.im.oidb.cmd0x2060;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x2060$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_bid", "string_pid" }, new Object[] { Long.valueOf(0L), "" }, ReqBody.class);
  public final PBStringField string_pid = PBField.initString("");
  public final PBUInt64Field uint64_bid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x2060.oidb_cmd0x2060.ReqBody
 * JD-Core Version:    0.7.0.1
 */