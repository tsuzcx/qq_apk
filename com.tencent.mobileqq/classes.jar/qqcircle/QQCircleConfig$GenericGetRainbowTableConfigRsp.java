package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleConfig$GenericGetRainbowTableConfigRsp
  extends MessageMicro<GenericGetRainbowTableConfigRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField cookie = PBField.initString("");
  public final PBStringField data = PBField.initString("");
  public final PBInt32Field fetchInterval = PBField.initInt32(0);
  public final PBInt32Field update = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "data", "update", "cookie", "fetchInterval" }, new Object[] { "", localInteger, "", localInteger }, GenericGetRainbowTableConfigRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleConfig.GenericGetRainbowTableConfigRsp
 * JD-Core Version:    0.7.0.1
 */