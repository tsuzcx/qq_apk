package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.group_pro.comm.common.MsgSeq;

public final class servtype$ChangeChanInfo
  extends MessageMicro<ChangeChanInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public servtype.ChannelInfo msg_chan_info = new servtype.ChannelInfo();
  public servtype.ChanInfoFilter msg_chan_info_filter = new servtype.ChanInfoFilter();
  public common.MsgSeq msg_info_seq = new common.MsgSeq();
  public final PBUInt32Field uint32_update_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_chan_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58 }, new String[] { "uint64_guild_id", "uint64_chan_id", "uint64_operator_id", "msg_info_seq", "uint32_update_type", "msg_chan_info_filter", "msg_chan_info" }, new Object[] { localLong, localLong, localLong, null, Integer.valueOf(0), null, null }, ChangeChanInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.ChangeChanInfo
 * JD-Core Version:    0.7.0.1
 */