package tencent.im.s2c.msgtype0x210.submsgtype0xc5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc5$LikeInfo
  extends MessageMicro<LikeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_op = PBField.initUInt32(0);
  public final PBUInt64Field uint64_like_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 34 }, new String[] { "uint64_like_uin", "uint32_op", "bytes_reply_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, LikeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.LikeInfo
 * JD-Core Version:    0.7.0.1
 */