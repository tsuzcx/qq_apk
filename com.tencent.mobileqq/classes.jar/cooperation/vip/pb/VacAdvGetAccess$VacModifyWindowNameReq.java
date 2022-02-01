package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacModifyWindowNameReq
  extends MessageMicro<VacModifyWindowNameReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "ware_house_id", "media_type", "content_type", "content_id", "content_name" }, new Object[] { Integer.valueOf(100), Integer.valueOf(0), Integer.valueOf(0), "", "" }, VacModifyWindowNameReq.class);
  public final PBStringField content_id = PBField.initString("");
  public final PBStringField content_name = PBField.initString("");
  public final PBInt32Field content_type = PBField.initInt32(0);
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBEnumField ware_house_id = PBField.initEnum(100);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.VacModifyWindowNameReq
 * JD-Core Version:    0.7.0.1
 */