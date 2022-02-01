package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$QQProfilePointInfo
  extends MessageMicro<QQProfilePointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "txt", "touin" }, new Object[] { "", "" }, QQProfilePointInfo.class);
  public final PBStringField touin = PBField.initString("");
  public final PBStringField txt = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleCounter.QQProfilePointInfo
 * JD-Core Version:    0.7.0.1
 */