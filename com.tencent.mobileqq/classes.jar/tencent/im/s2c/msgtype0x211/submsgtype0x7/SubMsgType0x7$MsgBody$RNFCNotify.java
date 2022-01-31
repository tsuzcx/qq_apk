package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$RNFCNotify
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_svrTaskId = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 29, 32, 40 }, new String[] { "uint64_sessionid", "bytes_token", "fixed32_ip", "uint32_port", "uint64_svrTaskId" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, RNFCNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.RNFCNotify
 * JD-Core Version:    0.7.0.1
 */