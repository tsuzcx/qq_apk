package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$PosAdInfo
  extends MessageMicro<PosAdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ret", "msg", "pos_id", "ads_info", "no_ad_indicator" }, new Object[] { Integer.valueOf(0), "", "", null, null }, PosAdInfo.class);
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo> ads_info = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.class);
  public final PBStringField msg = PBField.initString("");
  public indicator.NoAdIndicator no_ad_indicator = new indicator.NoAdIndicator();
  public final PBStringField pos_id = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo
 * JD-Core Version:    0.7.0.1
 */