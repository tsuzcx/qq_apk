package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$SmallRedPointInfoExt
  extends MessageMicro<SmallRedPointInfoExt>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "unreadMsg", "wording" }, new Object[] { "", "" }, SmallRedPointInfoExt.class);
  public final PBStringField unreadMsg = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCounter.SmallRedPointInfoExt
 * JD-Core Version:    0.7.0.1
 */