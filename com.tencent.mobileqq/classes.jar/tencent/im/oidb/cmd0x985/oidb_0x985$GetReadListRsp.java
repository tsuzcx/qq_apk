package tencent.im.oidb.cmd0x985;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x985$GetReadListRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_read_list", "rpt_msg_unread_list" }, new Object[] { null, null }, GetReadListRsp.class);
  public final PBRepeatMessageField rpt_msg_read_list = PBField.initRepeatMessage(oidb_0x985.UinInfo.class);
  public final PBRepeatMessageField rpt_msg_unread_list = PBField.initRepeatMessage(oidb_0x985.UinInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListRsp
 * JD-Core Version:    0.7.0.1
 */