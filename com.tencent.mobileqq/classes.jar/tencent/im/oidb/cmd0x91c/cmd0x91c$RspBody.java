package tencent.im.oidb.cmd0x91c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x91c$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField string_organization_info = PBField.initString("");
  public final PBUInt32Field uint32_certificate_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_organization_type = PBField.initUInt32(0);
  public final PBUInt32Field uint64_application_submit_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_certificate_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "uint64_certificate_time", "string_organization_info", "uint32_organization_type", "uint32_certificate_type", "uint64_application_submit_time", "uint64_group_code" }, new Object[] { localLong, "", localInteger, localInteger, localInteger, localLong }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x91c.cmd0x91c.RspBody
 * JD-Core Version:    0.7.0.1
 */