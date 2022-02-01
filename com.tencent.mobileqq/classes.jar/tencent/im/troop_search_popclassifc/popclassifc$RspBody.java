package tencent.im.troop_search_popclassifc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class popclassifc$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "banner_card", "pop_card", "uint32_latitude", "uint32_longitude", "str_city_id", "pop_hotword" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), "", null }, RspBody.class);
  public popclassifc.BannerCard banner_card = new popclassifc.BannerCard();
  public popclassifc.PopCard pop_card = new popclassifc.PopCard();
  public popclassifc.PopHotWordCard pop_hotword = new popclassifc.PopHotWordCard();
  public final PBStringField str_city_id = PBField.initString("");
  public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
  public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.troop_search_popclassifc.popclassifc.RspBody
 * JD-Core Version:    0.7.0.1
 */