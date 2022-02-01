package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleBase$StPublishButtonAnimationInfo
  extends MessageMicro<StPublishButtonAnimationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field animationShowTime = PBField.initInt64(0L);
  public final PBInt64Field animationStartupTime = PBField.initInt64(0L);
  public final PBStringField backImg = PBField.initString("");
  public final PBStringField hashIcon = PBField.initString("");
  public final PBStringField hashTag = PBField.initString("");
  public final PBInt32Field isShowAnimation = PBField.initInt32(0);
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField operatorIcon = PBField.initString("");
  public final PBStringField reportExt = PBField.initString("");
  public final PBStringField taskId = PBField.initString("");
  public final PBStringField words = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72, 82, 90 }, new String[] { "isShowAnimation", "hashIcon", "hashTag", "words", "backImg", "operatorIcon", "jumpUrl", "animationStartupTime", "animationShowTime", "reportExt", "taskId" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", localLong, localLong, "", "" }, StPublishButtonAnimationInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleBase.StPublishButtonAnimationInfo
 * JD-Core Version:    0.7.0.1
 */