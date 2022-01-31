package tencent.im.oidb.cmd0xb70;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb70$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "appid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb70.oidb_0xb70.ReqBody
 * JD-Core Version:    0.7.0.1
 */