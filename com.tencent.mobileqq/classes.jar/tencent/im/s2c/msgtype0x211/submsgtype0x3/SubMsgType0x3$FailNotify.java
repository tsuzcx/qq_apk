package tencent.im.s2c.msgtype0x211.submsgtype0x3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x3$FailNotify
  extends MessageMicro<FailNotify>
{
  public static final int BYTES_REASON_FIELD_NUMBER = 3;
  public static final int UINT32_RETCODE_FIELD_NUMBER = 2;
  public static final int UINT32_SESSIONID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_retCode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sessionid = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_sessionid", "uint32_retCode", "bytes_reason" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, FailNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.FailNotify
 * JD-Core Version:    0.7.0.1
 */