package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$GenericSubCmd
  extends MessageMicro<GenericSubCmd>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_support_auth = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint64_sessionid", "uint32_size", "uint32_index", "uint32_type", "bytes_buf", "uint32_support_auth" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localByteStringMicro, localInteger }, GenericSubCmd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd
 * JD-Core Version:    0.7.0.1
 */