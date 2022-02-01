package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VacAdvGetAccess$VacGroupDeleteGoodsReq
  extends MessageMicro<VacGroupDeleteGoodsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "ware_house_id", "media_type", "content_type", "content_id", "product_list" }, new Object[] { Integer.valueOf(100), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L) }, VacGroupDeleteGoodsReq.class);
  public final PBStringField content_id = PBField.initString("");
  public final PBInt32Field content_type = PBField.initInt32(0);
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBRepeatField<Long> product_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBEnumField ware_house_id = PBField.initEnum(100);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.VacGroupDeleteGoodsReq
 * JD-Core Version:    0.7.0.1
 */