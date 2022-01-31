package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x51d$GetSubItemNoticeRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint64_appdid", "rpt_msg_subitem_notice" }, new Object[] { Long.valueOf(0L), null }, GetSubItemNoticeRsp.class);
  public final PBUInt64Field opt_uint64_appdid = PBField.initUInt64(0L);
  public final PBRepeatMessageField rpt_msg_subitem_notice = PBField.initRepeatMessage(oidb_0x51d.SubItemNoticeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51d.oidb_0x51d.GetSubItemNoticeRsp
 * JD-Core Version:    0.7.0.1
 */