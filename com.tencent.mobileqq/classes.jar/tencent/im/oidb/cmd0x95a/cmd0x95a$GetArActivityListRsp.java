package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x95a$GetArActivityListRsp
  extends MessageMicro<GetArActivityListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFixed32Field fixed32_get_time = PBField.initFixed32(0);
  public final PBRepeatMessageField<cmd0x95a.ArActivityItem> rpt_msg_ar_activity_item = PBField.initRepeatMessage(cmd0x95a.ArActivityItem.class);
  public final PBUInt32Field uint32_completed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_now_pos = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 42 }, new String[] { "uint64_uin", "fixed32_get_time", "uint32_completed", "uint32_now_pos", "rpt_msg_ar_activity_item" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, null }, GetArActivityListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityListRsp
 * JD-Core Version:    0.7.0.1
 */