package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacMemberGetOrderListReq
  extends MessageMicro<VacMemberGetOrderListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 800, 808 }, new String[] { "ware_house_id", "media_type", "buyer_id", "state_flag", "state", "only_num", "limit", "offset" }, new Object[] { Integer.valueOf(100), Integer.valueOf(0), "", Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, VacMemberGetOrderListReq.class);
  public final PBStringField buyer_id = PBField.initString("");
  public final PBInt32Field limit = PBField.initInt32(0);
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBInt32Field offset = PBField.initInt32(0);
  public final PBBoolField only_num = PBField.initBool(false);
  public final PBInt32Field state = PBField.initInt32(0);
  public final PBBoolField state_flag = PBField.initBool(false);
  public final PBEnumField ware_house_id = PBField.initEnum(100);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.VacMemberGetOrderListReq
 * JD-Core Version:    0.7.0.1
 */