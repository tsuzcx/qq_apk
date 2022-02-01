package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$StQQProfilePointInfo
  extends MessageMicro<StQQProfilePointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "txt", "touin" }, new Object[] { "", "" }, StQQProfilePointInfo.class);
  public final PBStringField touin = PBField.initString("");
  public final PBStringField txt = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StQQProfilePointInfo
 * JD-Core Version:    0.7.0.1
 */