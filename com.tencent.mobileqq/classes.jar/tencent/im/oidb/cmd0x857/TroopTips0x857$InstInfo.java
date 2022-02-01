package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$InstInfo
  extends MessageMicro<InstInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
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
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 72 }, new String[] { "uint32_apppid", "uint32_instid", "uint32_platform", "uint32_open_appid", "uint32_productid", "uint32_sso_bid", "bytes_guid", "uint32_ver_min", "uint32_ver_max" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro, localInteger, localInteger }, InstInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.InstInfo
 * JD-Core Version:    0.7.0.1
 */