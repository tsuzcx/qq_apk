package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleConfig$GetRainbowTableConfigRsp
  extends MessageMicro<GetRainbowTableConfigRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "data", "update", "cookie" }, new Object[] { "", Integer.valueOf(0), "" }, GetRainbowTableConfigRsp.class);
  public final PBStringField cookie = PBField.initString("");
  public final PBStringField data = PBField.initString("");
  public final PBInt32Field update = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleConfig.GetRainbowTableConfigRsp
 * JD-Core Version:    0.7.0.1
 */