package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleStorage$RecieveFuel
  extends MessageMicro<RecieveFuel>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "fuels" }, new Object[] { Integer.valueOf(0) }, RecieveFuel.class);
  public final PBUInt32Field fuels = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleStorage.RecieveFuel
 * JD-Core Version:    0.7.0.1
 */