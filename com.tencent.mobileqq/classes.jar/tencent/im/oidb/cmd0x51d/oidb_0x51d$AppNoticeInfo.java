package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x51d$AppNoticeInfo
  extends MessageMicro<AppNoticeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint64_appdid", "opt_msg_app_notice" }, new Object[] { Long.valueOf(0L), null }, AppNoticeInfo.class);
  public oidb_0x51d.NoticeInfo opt_msg_app_notice = new oidb_0x51d.NoticeInfo();
  public final PBUInt64Field opt_uint64_appdid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51d.oidb_0x51d.AppNoticeInfo
 * JD-Core Version:    0.7.0.1
 */