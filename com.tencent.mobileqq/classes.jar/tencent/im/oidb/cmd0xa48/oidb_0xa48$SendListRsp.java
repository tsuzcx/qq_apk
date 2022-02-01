package tencent.im.oidb.cmd0xa48;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xa48$SendListRsp
  extends MessageMicro<SendListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_today_birth", "rpt_send_gift", "rpt_recv_gift" }, new Object[] { null, null, null }, SendListRsp.class);
  public final PBRepeatMessageField<oidb_0xa48.SendItem> rpt_recv_gift = PBField.initRepeatMessage(oidb_0xa48.SendItem.class);
  public final PBRepeatMessageField<oidb_0xa48.SendItem> rpt_send_gift = PBField.initRepeatMessage(oidb_0xa48.SendItem.class);
  public final PBRepeatMessageField<oidb_0xa48.SendItem> rpt_today_birth = PBField.initRepeatMessage(oidb_0xa48.SendItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa48.oidb_0xa48.SendListRsp
 * JD-Core Version:    0.7.0.1
 */