package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$DestroyChan
  extends MessageMicro<DestroyChan>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<servtype.ChannelID> rpt_delete_id = PBField.initRepeatMessage(servtype.ChannelID.class);
  public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 34 }, new String[] { "uint64_guild_id", "uint64_operator_id", "rpt_delete_id" }, new Object[] { localLong, localLong, null }, DestroyChan.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.DestroyChan
 * JD-Core Version:    0.7.0.1
 */