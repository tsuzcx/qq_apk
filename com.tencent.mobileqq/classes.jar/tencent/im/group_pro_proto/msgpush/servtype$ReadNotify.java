package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.group_pro.comm.common.MsgSeq;

public final class servtype$ReadNotify
  extends MessageMicro<ReadNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_read_msg_meta = PBField.initBytes(ByteStringMicro.EMPTY);
  public common.MsgSeq msg_read_cnt_msg_seq = new common.MsgSeq();
  public common.MsgSeq msg_read_msg_seq = new common.MsgSeq();
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint64_channel_id", "uint64_guild_id", "msg_read_msg_seq", "msg_read_cnt_msg_seq", "bytes_read_msg_meta" }, new Object[] { localLong, localLong, null, null, localByteStringMicro }, ReadNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.ReadNotify
 * JD-Core Version:    0.7.0.1
 */