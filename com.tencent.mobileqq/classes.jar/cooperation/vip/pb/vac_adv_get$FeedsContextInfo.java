package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class vac_adv_get$FeedsContextInfo
  extends MessageMicro<FeedsContextInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "index", "ugckey" }, new Object[] { Integer.valueOf(0), "" }, FeedsContextInfo.class);
  public final PBInt32Field index = PBField.initInt32(0);
  public final PBStringField ugckey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.FeedsContextInfo
 * JD-Core Version:    0.7.0.1
 */