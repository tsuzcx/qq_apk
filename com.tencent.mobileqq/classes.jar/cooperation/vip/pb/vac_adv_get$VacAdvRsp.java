package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class vac_adv_get$VacAdvRsp
  extends MessageMicro<VacAdvRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "err_code", "err_msg", "vac_adv_msgs", "attach_info" }, new Object[] { Integer.valueOf(0), "", null, "" }, VacAdvRsp.class);
  public final PBStringField attach_info = PBField.initString("");
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBRepeatMessageField<vac_adv_get.VacAdvMetaMsg> vac_adv_msgs = PBField.initRepeatMessage(vac_adv_get.VacAdvMetaMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.VacAdvRsp
 * JD-Core Version:    0.7.0.1
 */