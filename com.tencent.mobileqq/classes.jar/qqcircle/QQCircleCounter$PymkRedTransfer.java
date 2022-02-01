package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCircleCounter$PymkRedTransfer
  extends MessageMicro<PymkRedTransfer>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "msgType", "createTs" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, PymkRedTransfer.class);
  public final PBInt64Field createTs = PBField.initInt64(0L);
  public final PBInt32Field msgType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCounter.PymkRedTransfer
 * JD-Core Version:    0.7.0.1
 */