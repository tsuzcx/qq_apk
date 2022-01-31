package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad$QQAdGetRsp$PosAdInfo
  extends MessageMicro<PosAdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 32, 42 }, new String[] { "ret", "msg", "pos_id", "ads_info" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), null }, PosAdInfo.class);
  public final PBRepeatMessageField<qq_ad.QQAdGetRsp.AdInfo> ads_info = PBField.initRepeatMessage(qq_ad.QQAdGetRsp.AdInfo.class);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt64Field pos_id = PBField.initUInt64(0L);
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.PosAdInfo
 * JD-Core Version:    0.7.0.1
 */