package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class synclogic$ChannelNode
  extends MessageMicro<ChannelNode>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBBytesField channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field channel_type = PBField.initUInt32(0);
  public final PBUInt64Field cnt_seq = PBField.initUInt64(0L);
  public final PBUInt32Field event_time = PBField.initUInt32(0);
  public final PBUInt64Field member_read_cnt_seq = PBField.initUInt64(0L);
  public final PBUInt64Field member_read_msg_seq = PBField.initUInt64(0L);
  public final PBBytesField msg_meta = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field msg_notify_type = PBField.initUInt32(0);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  public final PBUInt64Field msg_time = PBField.initUInt64(0L);
  public final PBBytesField read_msg_meta = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72, 82, 90, 96 }, new String[] { "channel_id", "msg_seq", "cnt_seq", "msg_time", "member_read_msg_seq", "member_read_cnt_seq", "msg_notify_type", "channel_name", "channel_type", "msg_meta", "read_msg_meta", "event_time" }, new Object[] { localLong, localLong, localLong, localLong, localLong, localLong, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localByteStringMicro3, localInteger }, ChannelNode.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.synclogic.synclogic.ChannelNode
 * JD-Core Version:    0.7.0.1
 */