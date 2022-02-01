package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip_2$CmdGetCallTypeRspBody
  extends MessageMicro<CmdGetCallTypeRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_call_phone = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_call_ability = PBField.initUInt32(0);
  public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tiny_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_call_type", "uint64_tiny_id", "bytes_call_id", "bytes_call_phone", "uint32_call_ability" }, new Object[] { localInteger, Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localInteger }, CmdGetCallTypeRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.CmdGetCallTypeRspBody
 * JD-Core Version:    0.7.0.1
 */