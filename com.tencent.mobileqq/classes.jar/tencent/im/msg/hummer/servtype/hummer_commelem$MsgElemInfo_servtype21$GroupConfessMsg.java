package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype21$GroupConfessMsg
  extends MessageMicro<GroupConfessMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem> confess_items = PBField.initRepeatMessage(hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem.class);
  public final PBUInt32Field uint32_confessor_sex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sysmsg_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_topic_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_confess_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint64_confess_time", "uint64_confessor_uin", "uint32_confessor_sex", "uint32_sysmsg_flag", "confess_items", "uint32_total_topic_count" }, new Object[] { localLong, localLong, localInteger, localInteger, null, localInteger }, GroupConfessMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.GroupConfessMsg
 * JD-Core Version:    0.7.0.1
 */