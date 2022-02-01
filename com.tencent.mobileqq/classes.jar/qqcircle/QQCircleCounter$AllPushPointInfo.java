package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleCounter$AllPushPointInfo
  extends MessageMicro<AllPushPointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "wording", "msgType", "tabTipWording" }, new Object[] { "", Integer.valueOf(0), "" }, AllPushPointInfo.class);
  public final PBUInt32Field msgType = PBField.initUInt32(0);
  public final PBStringField tabTipWording = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCounter.AllPushPointInfo
 * JD-Core Version:    0.7.0.1
 */