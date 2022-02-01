package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype21$GroupConfessItem
  extends MessageMicro<GroupConfessItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_confess_to_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_confess_to_nick_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_confess_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_topic_id", "uint64_confess_to_uin", "bytes_confess_to_nick", "bytes_topic", "uint32_confess_to_nick_type" }, new Object[] { localInteger, Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localInteger }, GroupConfessItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem
 * JD-Core Version:    0.7.0.1
 */