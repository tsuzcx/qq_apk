package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StNoticeTxtInfo
  extends MessageMicro<StNoticeTxtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48 }, new String[] { "content", "subContent", "summary", "actionType", "schemaUrl", "contentShowCutOff" }, new Object[] { "", "", "", Integer.valueOf(0), "", Boolean.valueOf(false) }, StNoticeTxtInfo.class);
  public final PBUInt32Field actionType = PBField.initUInt32(0);
  public final PBStringField content = PBField.initString("");
  public final PBBoolField contentShowCutOff = PBField.initBool(false);
  public final PBStringField schemaUrl = PBField.initString("");
  public final PBStringField subContent = PBField.initString("");
  public final PBStringField summary = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StNoticeTxtInfo
 * JD-Core Version:    0.7.0.1
 */