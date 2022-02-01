package tencent.im.oidb.cmd0xe95;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe95$SendWriteTogetherMsgReq
  extends MessageMicro<SendWriteTogetherMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_global_padid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_get_rev = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_token", "bytes_global_padid", "uint32_get_rev" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, SendWriteTogetherMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe95.oidb_0xe95.SendWriteTogetherMsgReq
 * JD-Core Version:    0.7.0.1
 */