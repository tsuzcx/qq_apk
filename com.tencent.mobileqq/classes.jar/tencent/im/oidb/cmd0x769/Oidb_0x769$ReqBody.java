package tencent.im.oidb.cmd0x769;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Oidb_0x769$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 810 }, new String[] { "rpt_config_list", "msg_device_info", "str_info", "province", "city", "req_debug_msg", "query_uin_package_usage_req" }, new Object[] { null, null, "", "", "", Integer.valueOf(0), null }, ReqBody.class);
  public final PBStringField city = PBField.initString("");
  public Oidb_0x769.DeviceInfo msg_device_info = new Oidb_0x769.DeviceInfo();
  public final PBStringField province = PBField.initString("");
  public Oidb_0x769.QueryUinPackageUsageReq query_uin_package_usage_req = new Oidb_0x769.QueryUinPackageUsageReq();
  public final PBInt32Field req_debug_msg = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_config_list = PBField.initRepeatMessage(Oidb_0x769.ConfigSeq.class);
  public final PBStringField str_info = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x769.Oidb_0x769.ReqBody
 * JD-Core Version:    0.7.0.1
 */