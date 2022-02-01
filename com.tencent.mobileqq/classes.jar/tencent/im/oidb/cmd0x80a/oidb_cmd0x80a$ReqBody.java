package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x80a$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0x80a.KDEventReportReq req_kd_event_report_req = new oidb_cmd0x80a.KDEventReportReq();
  public final PBUInt32Field uint32_app_bitmap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_configuration_bitmap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_concise_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_kandian_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_privacy_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 90 }, new String[] { "uint64_uin", "uint32_network_type", "uint32_kandian_mode", "uint32_app_bitmap", "uint32_configuration_bitmap", "uint32_is_concise_mode", "uint32_privacy_status", "req_kd_event_report_req" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.ReqBody
 * JD-Core Version:    0.7.0.1
 */