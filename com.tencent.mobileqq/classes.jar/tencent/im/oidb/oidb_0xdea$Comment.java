package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdea$Comment
  extends MessageMicro<Comment>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comment_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pass_through = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_comment_ctime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_comment_location = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 42, 50, 56, 66, 72 }, new String[] { "uint64_comment_uin", "uint64_seq", "uint64_comment_location", "bytes_comment_msg", "bytes_pass_through", "uint32_comment_ctime", "bytes_nick", "uint32_source" }, new Object[] { localLong, localLong, localLong, localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, localInteger }, Comment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdea.Comment
 * JD-Core Version:    0.7.0.1
 */