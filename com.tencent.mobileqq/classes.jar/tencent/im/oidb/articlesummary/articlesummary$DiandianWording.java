package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$DiandianWording
  extends MessageMicro<DiandianWording>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uin_or_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_uin_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_uin_or_nick", "bytes_msg_wording", "uint32_uin_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, DiandianWording.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.DiandianWording
 * JD-Core Version:    0.7.0.1
 */