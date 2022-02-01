package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$MessageBoxRedPointInfo
  extends MessageMicro<MessageBoxRedPointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "needShow", "wording" }, new Object[] { Boolean.valueOf(false), "" }, MessageBoxRedPointInfo.class);
  public final PBBoolField needShow = PBField.initBool(false);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.MessageBoxRedPointInfo
 * JD-Core Version:    0.7.0.1
 */