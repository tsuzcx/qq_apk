package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class vac_adv_get$VacFeedsAdvMetaInfo
  extends MessageMicro<VacFeedsAdvMetaInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "adv_rsp", "default_conf", "droplist", "recomm_cookie" }, new Object[] { null, null, null, "" }, VacFeedsAdvMetaInfo.class);
  public qq_ad_get.QQAdGetRsp.AdInfo adv_rsp = new qq_ad_get.QQAdGetRsp.AdInfo();
  public vac_adv_get.DefaultConf default_conf = new vac_adv_get.DefaultConf();
  public final PBRepeatMessageField<vac_adv_get.DropList> droplist = PBField.initRepeatMessage(vac_adv_get.DropList.class);
  public final PBStringField recomm_cookie = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaInfo
 * JD-Core Version:    0.7.0.1
 */