package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleConfig$GetRainbowTableConfigReq
  extends MessageMicro<GetRainbowTableConfigReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "group", "uid", "qua", "cookie", "version" }, new Object[] { "", "", "", "", "" }, GetRainbowTableConfigReq.class);
  public final PBStringField cookie = PBField.initString("");
  public final PBStringField group = PBField.initString("");
  public final PBStringField qua = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleConfig.GetRainbowTableConfigReq
 * JD-Core Version:    0.7.0.1
 */