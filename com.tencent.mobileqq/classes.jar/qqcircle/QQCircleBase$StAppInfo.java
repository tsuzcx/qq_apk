package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleBase$StAppInfo
  extends MessageMicro<StAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "app_version", "qua", "platform" }, new Object[] { "", "", "" }, StAppInfo.class);
  public final PBStringField app_version = PBField.initString("");
  public final PBStringField platform = PBField.initString("");
  public final PBStringField qua = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleBase.StAppInfo
 * JD-Core Version:    0.7.0.1
 */