package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSwitch$StFirstSetCircleSwichMsg
  extends MessageMicro<StFirstSetCircleSwichMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "uid", "ts", "scence" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0) }, StFirstSetCircleSwichMsg.class);
  public final PBInt32Field scence = PBField.initInt32(0);
  public final PBInt64Field ts = PBField.initInt64(0L);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.StFirstSetCircleSwichMsg
 * JD-Core Version:    0.7.0.1
 */