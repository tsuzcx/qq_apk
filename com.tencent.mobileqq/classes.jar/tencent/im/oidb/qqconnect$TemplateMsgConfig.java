package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqconnect$TemplateMsgConfig
  extends MessageMicro<TemplateMsgConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "service_msg_uin", "public_msg_uin", "camp_msg_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, TemplateMsgConfig.class);
  public final PBUInt64Field camp_msg_uin = PBField.initUInt64(0L);
  public final PBUInt64Field public_msg_uin = PBField.initUInt64(0L);
  public final PBUInt64Field service_msg_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.TemplateMsgConfig
 * JD-Core Version:    0.7.0.1
 */