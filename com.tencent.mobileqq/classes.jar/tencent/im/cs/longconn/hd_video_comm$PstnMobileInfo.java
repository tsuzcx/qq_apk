package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_comm$PstnMobileInfo
  extends MessageMicro<PstnMobileInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nation = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_provider_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_nation", "bytes_prefix", "bytes_mobile", "uint32_provider_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, PstnMobileInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video_comm.PstnMobileInfo
 * JD-Core Version:    0.7.0.1
 */