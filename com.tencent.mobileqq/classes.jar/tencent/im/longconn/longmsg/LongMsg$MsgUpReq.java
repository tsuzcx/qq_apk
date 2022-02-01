package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LongMsg$MsgUpReq
  extends MessageMicro<MsgUpReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_msg_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_cache = PBField.initUInt32(0);
  public final PBUInt32Field uint32_store_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56 }, new String[] { "uint32_msg_type", "uint64_dst_uin", "uint32_msg_id", "bytes_msg_content", "uint32_store_type", "bytes_msg_ukey", "uint32_need_cache" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localInteger }, MsgUpReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.longconn.longmsg.LongMsg.MsgUpReq
 * JD-Core Version:    0.7.0.1
 */