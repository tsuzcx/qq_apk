package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleConfig$GetRainbowTableConfigReq
  extends MessageMicro<GetRainbowTableConfigReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "group", "uid", "qua", "cookie", "version", "platform" }, new Object[] { "", "", "", "", "", Integer.valueOf(0) }, GetRainbowTableConfigReq.class);
  public final PBStringField cookie = PBField.initString("");
  public final PBStringField group = PBField.initString("");
  public final PBInt32Field platform = PBField.initInt32(0);
  public final PBStringField qua = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleConfig.GetRainbowTableConfigReq
 * JD-Core Version:    0.7.0.1
 */