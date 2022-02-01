package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleMsgPaelem$InstInfo
  extends MessageMicro<InstInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_platform_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_device_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_apppid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_open_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  public final PBUInt32Field uint32_productid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sso_bid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ver_max = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ver_min = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 72, 80, 90 }, new String[] { "uint32_apppid", "uint32_instid", "uint32_platform", "uint32_open_appid", "uint32_productid", "uint32_sso_bid", "bytes_guid", "uint32_ver_min", "uint32_ver_max", "enum_device_type", "bytes_platform_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro2 }, InstInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.InstInfo
 * JD-Core Version:    0.7.0.1
 */