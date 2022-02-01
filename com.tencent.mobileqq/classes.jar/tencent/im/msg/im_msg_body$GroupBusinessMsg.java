package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$GroupBusinessMsg
  extends MessageMicro<GroupBusinessMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_head_clk_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rank = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rank_bgcolor = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rank_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uint32_flags", "bytes_head_url", "bytes_head_clk_url", "bytes_nick", "bytes_nick_color", "bytes_rank", "bytes_rank_color", "bytes_rank_bgcolor" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, GroupBusinessMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.GroupBusinessMsg
 * JD-Core Version:    0.7.0.1
 */