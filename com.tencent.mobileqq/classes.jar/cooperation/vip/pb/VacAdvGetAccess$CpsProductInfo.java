package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VacAdvGetAccess$CpsProductInfo
  extends MessageMicro<CpsProductInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "product_id", "catelog_id", "product_token" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, CpsProductInfo.class);
  public final PBUInt64Field catelog_id = PBField.initUInt64(0L);
  public final PBUInt64Field product_id = PBField.initUInt64(0L);
  public final PBStringField product_token = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.CpsProductInfo
 * JD-Core Version:    0.7.0.1
 */