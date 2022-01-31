package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public final class vac_adv_get$VacAdvReq
  extends MessageMicro<VacAdvReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "qq", "device_info", "adv_pos", "qzone_busi_info", "attach_info" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(1), null, "" }, VacAdvReq.class);
  public final PBEnumField adv_pos = PBField.initEnum(1);
  public final PBStringField attach_info = PBField.initString("");
  public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
  public final PBUInt64Field qq = PBField.initUInt64(0L);
  public vac_adv_get.QzoneBusiMsg qzone_busi_info = new vac_adv_get.QzoneBusiMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.VacAdvReq
 * JD-Core Version:    0.7.0.1
 */