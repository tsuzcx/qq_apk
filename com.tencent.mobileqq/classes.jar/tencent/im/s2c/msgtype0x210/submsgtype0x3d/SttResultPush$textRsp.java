package tencent.im.s2c.msgtype0x210.submsgtype0x3d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SttResultPush$textRsp
  extends MessageMicro<textRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_len = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 32, 40, 48, 56, 66 }, new String[] { "uint32_total_len", "uint32_seq", "uint32_pos", "uint32_len", "bytes_text" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localByteStringMicro }, textRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.textRsp
 * JD-Core Version:    0.7.0.1
 */