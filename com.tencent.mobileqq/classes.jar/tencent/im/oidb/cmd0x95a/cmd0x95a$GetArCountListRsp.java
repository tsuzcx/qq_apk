package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x95a$GetArCountListRsp
  extends MessageMicro<GetArCountListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "rpt_msg_ar_count_item" }, new Object[] { Long.valueOf(0L), null }, GetArCountListRsp.class);
  public final PBRepeatMessageField<cmd0x95a.ArCountItem> rpt_msg_ar_count_item = PBField.initRepeatMessage(cmd0x95a.ArCountItem.class);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.GetArCountListRsp
 * JD-Core Version:    0.7.0.1
 */