package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x83e$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_default_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
  public final PBUInt32Field uint32_operation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ugc_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 66, 72 }, new String[] { "uint64_uin", "uint32_operation", "uint64_feeds_id", "bytes_comment_id", "bytes_rowkey", "uint32_ugc_status", "bytes_default_comments", "bytes_sub_comment_id", "uint32_is_like" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody
 * JD-Core Version:    0.7.0.1
 */