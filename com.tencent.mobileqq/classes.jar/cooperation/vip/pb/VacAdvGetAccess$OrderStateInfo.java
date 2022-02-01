package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VacAdvGetAccess$OrderStateInfo
  extends MessageMicro<OrderStateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "state", "total_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, OrderStateInfo.class);
  public final PBInt32Field state = PBField.initInt32(0);
  public final PBInt32Field total_num = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.OrderStateInfo
 * JD-Core Version:    0.7.0.1
 */