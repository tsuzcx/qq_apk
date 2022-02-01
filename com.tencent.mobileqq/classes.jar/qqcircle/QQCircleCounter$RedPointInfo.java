package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleCounter$RedPointInfo
  extends MessageMicro<RedPointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 56 }, new String[] { "appid", "redType", "redTotalNum", "rptRedInfo", "pushTime", "extend", "lastVisitTime" }, new Object[] { "", Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(0), "", Long.valueOf(0L) }, RedPointInfo.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField extend = PBField.initString("");
  public final PBInt64Field lastVisitTime = PBField.initInt64(0L);
  public final PBUInt32Field pushTime = PBField.initUInt32(0);
  public final PBUInt32Field redTotalNum = PBField.initUInt32(0);
  public final PBEnumField redType = PBField.initEnum(1);
  public final PBRepeatMessageField<QQCircleCounter.RedDisplayInfo> rptRedInfo = PBField.initRepeatMessage(QQCircleCounter.RedDisplayInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleCounter.RedPointInfo
 * JD-Core Version:    0.7.0.1
 */