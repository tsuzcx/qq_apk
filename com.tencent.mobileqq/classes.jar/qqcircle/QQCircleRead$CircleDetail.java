package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRead$CircleDetail
  extends MessageMicro<CircleDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 58 }, new String[] { "id", "name", "circleType", "memberCount", "avatarUrl" }, new Object[] { "", "", Integer.valueOf(0), Long.valueOf(0L), "" }, CircleDetail.class);
  public final PBStringField avatarUrl = PBField.initString("");
  public final PBInt32Field circleType = PBField.initInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBInt64Field memberCount = PBField.initInt64(0L);
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleRead.CircleDetail
 * JD-Core Version:    0.7.0.1
 */