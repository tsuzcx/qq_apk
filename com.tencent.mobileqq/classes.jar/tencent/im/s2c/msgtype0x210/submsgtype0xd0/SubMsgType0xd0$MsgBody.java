package tencent.im.s2c.msgtype0x210.submsgtype0xd0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xd0$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_big_v_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hot_topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_link = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pgc_column_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_type = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pgc_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_big_v_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_hot_topic_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 56, 66, 74, 82, 90 }, new String[] { "uint32_msg_type", "bytes_msg_info", "uint64_hot_topic_id", "bytes_hot_topic_name", "uint64_big_v_id", "bytes_big_v_union_id", "uint32_pgc_type", "bytes_pgc_column_union_id", "bytes_link", "bytes_sub_type", "bytes_cover_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xd0.SubMsgType0xd0.MsgBody
 * JD-Core Version:    0.7.0.1
 */