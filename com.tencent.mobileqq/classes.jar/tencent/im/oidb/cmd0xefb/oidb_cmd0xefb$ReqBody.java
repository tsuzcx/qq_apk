package tencent.im.oidb.cmd0xefb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xefb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "timestamp", "timeInterval" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field timeInterval = PBField.initUInt32(0);
  public final PBInt64Field timestamp = PBField.initInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xefb.oidb_cmd0xefb.ReqBody
 * JD-Core Version:    0.7.0.1
 */