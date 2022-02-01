package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6d8$GetFileInfoReqBody
  extends MessageMicro<GetFileInfoReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_file_id = PBField.initString("");
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_field_flag = PBField.initUInt32(16777215);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "uint32_field_flag" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, "", Integer.valueOf(16777215) }, GetFileInfoReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileInfoReqBody
 * JD-Core Version:    0.7.0.1
 */