package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x51c$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "opt_uint64_handled_uin", "opt_msg_office_noticevar", "rpt_msg_app_noticevar" }, new Object[] { Long.valueOf(0L), null, null }, ReqBody.class);
  public oidb_0x51c.NoticeVar opt_msg_office_noticevar = new oidb_0x51c.NoticeVar();
  public final PBUInt64Field opt_uint64_handled_uin = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_0x51c.AppNoticeVar> rpt_msg_app_noticevar = PBField.initRepeatMessage(oidb_0x51c.AppNoticeVar.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51c.oidb_0x51c.ReqBody
 * JD-Core Version:    0.7.0.1
 */