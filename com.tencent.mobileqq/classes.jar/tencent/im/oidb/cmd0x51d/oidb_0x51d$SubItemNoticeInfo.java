package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x51d$SubItemNoticeInfo
  extends MessageMicro<SubItemNoticeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_subitem_id", "opt_msg_subitem_notice" }, new Object[] { Integer.valueOf(0), null }, SubItemNoticeInfo.class);
  public oidb_0x51d.NoticeInfo opt_msg_subitem_notice = new oidb_0x51d.NoticeInfo();
  public final PBUInt32Field opt_uint32_subitem_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51d.oidb_0x51d.SubItemNoticeInfo
 * JD-Core Version:    0.7.0.1
 */