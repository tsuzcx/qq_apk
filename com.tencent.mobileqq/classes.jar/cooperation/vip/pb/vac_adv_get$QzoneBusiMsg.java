package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class vac_adv_get$QzoneBusiMsg
  extends MessageMicro<QzoneBusiMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "page_num", "cur_page_infos", "device_info" }, new Object[] { Integer.valueOf(0), null, "" }, QzoneBusiMsg.class);
  public final PBRepeatMessageField<vac_adv_get.FeedsContextInfo> cur_page_infos = PBField.initRepeatMessage(vac_adv_get.FeedsContextInfo.class);
  public final PBStringField device_info = PBField.initString("");
  public final PBInt32Field page_num = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.QzoneBusiMsg
 * JD-Core Version:    0.7.0.1
 */