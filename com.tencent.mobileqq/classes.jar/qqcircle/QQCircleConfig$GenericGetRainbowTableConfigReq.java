package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleConfig$GenericGetRainbowTableConfigReq
  extends MessageMicro<GenericGetRainbowTableConfigReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "appId", "group", "cookie", "getOpts" }, new Object[] { "", "", "", null }, GenericGetRainbowTableConfigReq.class);
  public final PBStringField appId = PBField.initString("");
  public final PBStringField cookie = PBField.initString("");
  public final PBRepeatMessageField<QQCircleConfig.GetOpt> getOpts = PBField.initRepeatMessage(QQCircleConfig.GetOpt.class);
  public final PBStringField group = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleConfig.GenericGetRainbowTableConfigReq
 * JD-Core Version:    0.7.0.1
 */