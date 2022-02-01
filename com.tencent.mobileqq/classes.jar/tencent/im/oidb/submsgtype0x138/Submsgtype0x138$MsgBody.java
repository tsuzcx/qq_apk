package tencent.im.oidb.submsgtype0x138;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0x138$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bussi_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_bussi_type", "bytes_msg_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.submsgtype0x138.Submsgtype0x138.MsgBody
 * JD-Core Version:    0.7.0.1
 */