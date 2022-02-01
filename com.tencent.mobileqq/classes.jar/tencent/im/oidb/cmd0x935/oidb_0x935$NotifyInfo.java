package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x935$NotifyInfo
  extends MessageMicro<NotifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_notify_gc", "uint32_notify_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, NotifyInfo.class);
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_notify_gc = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x935.oidb_0x935.NotifyInfo
 * JD-Core Version:    0.7.0.1
 */