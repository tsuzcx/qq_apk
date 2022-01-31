package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad$QQAdGetRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 42, 50, 56 }, new String[] { "ret", "pos_ads_info", "msg", "is_boss_qq" }, new Object[] { Integer.valueOf(0), null, "", Boolean.valueOf(false) }, QQAdGetRsp.class);
  public final PBBoolField is_boss_qq = PBField.initBool(false);
  public final PBStringField msg = PBField.initString("");
  public final PBRepeatMessageField pos_ads_info = PBField.initRepeatMessage(qq_ad.QQAdGetRsp.PosAdInfo.class);
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp
 * JD-Core Version:    0.7.0.1
 */