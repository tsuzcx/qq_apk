package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StNoticeTxtInfo
  extends MessageMicro<StNoticeTxtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "content", "actionType", "schemaUrl" }, new Object[] { "", Integer.valueOf(0), "" }, StNoticeTxtInfo.class);
  public final PBUInt32Field actionType = PBField.initUInt32(0);
  public final PBStringField content = PBField.initString("");
  public final PBStringField schemaUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StNoticeTxtInfo
 * JD-Core Version:    0.7.0.1
 */