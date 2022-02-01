package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleConfig$GetRainbowKVConfReq
  extends MessageMicro<GetRainbowKVConfReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "appId", "group", "key", "cookie" }, new Object[] { "", "", "", "" }, GetRainbowKVConfReq.class);
  public final PBStringField appId = PBField.initString("");
  public final PBStringField cookie = PBField.initString("");
  public final PBStringField group = PBField.initString("");
  public final PBStringField key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleConfig.GetRainbowKVConfReq
 * JD-Core Version:    0.7.0.1
 */