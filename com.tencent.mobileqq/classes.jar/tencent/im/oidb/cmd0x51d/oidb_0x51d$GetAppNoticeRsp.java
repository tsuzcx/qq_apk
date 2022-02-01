package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x51d$GetAppNoticeRsp
  extends MessageMicro<GetAppNoticeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_app_notice" }, new Object[] { null }, GetAppNoticeRsp.class);
  public final PBRepeatMessageField<oidb_0x51d.AppNoticeInfo> rpt_msg_app_notice = PBField.initRepeatMessage(oidb_0x51d.AppNoticeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51d.oidb_0x51d.GetAppNoticeRsp
 * JD-Core Version:    0.7.0.1
 */