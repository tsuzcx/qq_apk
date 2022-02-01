package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VacAdvGetAccess$VacCpsReqInfo
  extends MessageMicro<VacCpsReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26 }, new String[] { "product_info" }, new Object[] { null }, VacCpsReqInfo.class);
  public final PBRepeatMessageField<VacAdvGetAccess.CpsProductInfo> product_info = PBField.initRepeatMessage(VacAdvGetAccess.CpsProductInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.VacCpsReqInfo
 * JD-Core Version:    0.7.0.1
 */