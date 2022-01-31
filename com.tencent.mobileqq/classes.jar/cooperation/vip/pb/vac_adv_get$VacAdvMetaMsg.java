package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class vac_adv_get$VacAdvMetaMsg
  extends MessageMicro<VacAdvMetaMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "adv_rsp", "insert_pos", "recomm_cookie" }, new Object[] { null, Integer.valueOf(0), "" }, VacAdvMetaMsg.class);
  public qq_ad_get.QQAdGetRsp.AdInfo adv_rsp = new qq_ad_get.QQAdGetRsp.AdInfo();
  public final PBInt32Field insert_pos = PBField.initInt32(0);
  public final PBStringField recomm_cookie = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.VacAdvMetaMsg
 * JD-Core Version:    0.7.0.1
 */