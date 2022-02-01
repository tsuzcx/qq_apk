package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x85f$CommParamReq
  extends MessageMicro<CommParamReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
  public final PBUInt32Field uint32_use_uin = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_portal", "bytes_version", "uint32_platform", "uint32_use_uin" }, new Object[] { localInteger, localByteStringMicro, localInteger, localInteger }, CommParamReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.CommParamReq
 * JD-Core Version:    0.7.0.1
 */