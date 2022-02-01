package tencent.im.statsvc.business.info;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xe62.ReqBody;

public final class businessinfo$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_business_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_battery_status = PBField.initInt32(0);
  public cmd0xe62.ReqBody private_info = new cmd0xe62.ReqBody();
  public final PBUInt32Field uint32_ext_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint32_status", "uint32_ext_status", "int32_battery_status", "bytes_business_info", "private_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.statsvc.business.info.businessinfo.ReqBody
 * JD-Core Version:    0.7.0.1
 */