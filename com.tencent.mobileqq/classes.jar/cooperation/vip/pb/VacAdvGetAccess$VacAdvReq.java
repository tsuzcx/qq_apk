package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import common.QqAdGetProtos.QQAdGet.DeviceInfo;

public final class VacAdvGetAccess$VacAdvReq
  extends MessageMicro<VacAdvReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 50 }, new String[] { "qq", "device_info", "adv_pos", "vac_cps_req_info" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), null }, VacAdvReq.class);
  public final PBInt32Field adv_pos = PBField.initInt32(0);
  public QqAdGetProtos.QQAdGet.DeviceInfo device_info = new QqAdGetProtos.QQAdGet.DeviceInfo();
  public final PBUInt64Field qq = PBField.initUInt64(0L);
  public VacAdvGetAccess.VacCpsReqInfo vac_cps_req_info = new VacAdvGetAccess.VacCpsReqInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.VacAdvReq
 * JD-Core Version:    0.7.0.1
 */