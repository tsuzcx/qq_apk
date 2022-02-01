package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$GroupPointInfo
  extends MessageMicro<GroupPointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "touin", "num", "jumpSchema" }, new Object[] { "", Integer.valueOf(0), "" }, GroupPointInfo.class);
  public final PBStringField jumpSchema = PBField.initString("");
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBStringField touin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleCounter.GroupPointInfo
 * JD-Core Version:    0.7.0.1
 */