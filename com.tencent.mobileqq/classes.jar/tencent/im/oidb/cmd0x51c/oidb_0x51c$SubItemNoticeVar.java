package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x51c$SubItemNoticeVar
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_subitem_id", "opt_msg_subitem_noticevar" }, new Object[] { Integer.valueOf(0), null }, SubItemNoticeVar.class);
  public oidb_0x51c.NoticeVar opt_msg_subitem_noticevar = new oidb_0x51c.NoticeVar();
  public final PBUInt32Field opt_uint32_subitem_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51c.oidb_0x51c.SubItemNoticeVar
 * JD-Core Version:    0.7.0.1
 */