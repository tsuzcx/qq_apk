package tencent.im.oidb.cmd0x5ba;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5ba$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_page_index = PBField.initInt32(0);
  public final PBInt32Field int32_page_size = PBField.initInt32(0);
  public final PBStringField string_appversion = PBField.initString("");
  public final PBStringField string_cli_cmd = PBField.initString("");
  public final PBStringField string_guid = PBField.initString("");
  public final PBStringField string_reward_id = PBField.initString("");
  public final PBStringField string_vid = PBField.initString("");
  public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  public final PBUInt64Field uint64_gc = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pay_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64, 72, 82, 90, 162 }, new String[] { "uint32_channel", "uint64_request_uin", "uint64_pay_uin", "uint64_gc", "string_reward_id", "string_vid", "int32_page_index", "int32_page_size", "uint32_platform", "string_appversion", "string_guid", "string_cli_cmd" }, new Object[] { localInteger, localLong, localLong, localLong, "", "", localInteger, localInteger, localInteger, "", "", "" }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5ba.oidb_0x5ba.ReqBody
 * JD-Core Version:    0.7.0.1
 */