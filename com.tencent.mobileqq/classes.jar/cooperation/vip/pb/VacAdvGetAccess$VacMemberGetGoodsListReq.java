package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import common.QqAdGetProtos.QQAdGet.DeviceInfo;

public final class VacAdvGetAccess$VacMemberGetGoodsListReq
  extends MessageMicro<VacMemberGetGoodsListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 72, 82, 90 }, new String[] { "ware_house_id", "media_type", "content_type", "content_id", "trace_id", "buyer_id", "seller_id", "page_number", "page_size", "group_member_openid", "device_info" }, new Object[] { Integer.valueOf(100), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", null }, VacMemberGetGoodsListReq.class);
  public final PBStringField buyer_id = PBField.initString("");
  public final PBStringField content_id = PBField.initString("");
  public final PBInt32Field content_type = PBField.initInt32(0);
  public QqAdGetProtos.QQAdGet.DeviceInfo device_info = new QqAdGetProtos.QQAdGet.DeviceInfo();
  public final PBStringField group_member_openid = PBField.initString("");
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBInt32Field page_number = PBField.initInt32(0);
  public final PBInt32Field page_size = PBField.initInt32(0);
  public final PBStringField seller_id = PBField.initString("");
  public final PBStringField trace_id = PBField.initString("");
  public final PBEnumField ware_house_id = PBField.initEnum(100);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.VacMemberGetGoodsListReq
 * JD-Core Version:    0.7.0.1
 */