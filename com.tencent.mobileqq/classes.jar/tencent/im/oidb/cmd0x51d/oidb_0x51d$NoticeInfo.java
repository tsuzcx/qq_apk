package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x51d$NoticeInfo
  extends MessageMicro<NoticeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint32_notice_count", "opt_uint32_notice_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, NoticeInfo.class);
  public final PBUInt32Field opt_uint32_notice_count = PBField.initUInt32(0);
  public final PBUInt32Field opt_uint32_notice_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51d.oidb_0x51d.NoticeInfo
 * JD-Core Version:    0.7.0.1
 */