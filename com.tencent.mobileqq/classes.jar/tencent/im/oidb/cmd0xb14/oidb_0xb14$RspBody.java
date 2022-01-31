package tencent.im.oidb.cmd0xb14;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb14$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "group_id", "infos", "interval" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, RspBody.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_0xb14.UserInfo> infos = PBField.initRepeatMessage(oidb_0xb14.UserInfo.class);
  public final PBUInt32Field interval = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb14.oidb_0xb14.RspBody
 * JD-Core Version:    0.7.0.1
 */