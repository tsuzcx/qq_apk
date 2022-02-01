package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$AllPushTransInfo
  extends MessageMicro<AllPushTransInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "feedId", "author", "createTs", "msgType" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0) }, AllPushTransInfo.class);
  public final PBStringField author = PBField.initString("");
  public final PBInt64Field createTs = PBField.initInt64(0L);
  public final PBStringField feedId = PBField.initString("");
  public final PBInt32Field msgType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleCounter.AllPushTransInfo
 * JD-Core Version:    0.7.0.1
 */