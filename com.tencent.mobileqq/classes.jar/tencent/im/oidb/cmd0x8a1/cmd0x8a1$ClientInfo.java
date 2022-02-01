package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x8a1$ClientInfo
  extends MessageMicro<ClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField string_inst_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pub_no = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_pub_no", "uint32_version", "uint32_app_id", "string_inst_id" }, new Object[] { localInteger, localInteger, localInteger, localByteStringMicro }, ClientInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a1.cmd0x8a1.ClientInfo
 * JD-Core Version:    0.7.0.1
 */