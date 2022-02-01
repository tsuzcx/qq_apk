package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VacAdvGetAccess$VacMemberGetOrderListRsp
  extends MessageMicro<VacMemberGetOrderListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "order_states" }, new Object[] { null }, VacMemberGetOrderListRsp.class);
  public final PBRepeatMessageField<VacAdvGetAccess.OrderStateInfo> order_states = PBField.initRepeatMessage(VacAdvGetAccess.OrderStateInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.VacMemberGetOrderListRsp
 * JD-Core Version:    0.7.0.1
 */