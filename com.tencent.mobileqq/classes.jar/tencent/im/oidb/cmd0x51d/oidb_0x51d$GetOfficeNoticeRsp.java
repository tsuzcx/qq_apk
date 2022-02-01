package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x51d$GetOfficeNoticeRsp
  extends MessageMicro<GetOfficeNoticeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "opt_msg_office_notice" }, new Object[] { null }, GetOfficeNoticeRsp.class);
  public oidb_0x51d.NoticeInfo opt_msg_office_notice = new oidb_0x51d.NoticeInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51d.oidb_0x51d.GetOfficeNoticeRsp
 * JD-Core Version:    0.7.0.1
 */