package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VacAdvGetAccess$GoodsInfo
  extends MessageMicro<GoodsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66, 72, 80, 88, 98, 106, 112, 122, 130, 138, 146, 152, 160, 169, 176, 184, 192, 202, 208, 218, 226, 234 }, new String[] { "goods_id", "ware_house_id", "source", "source_str", "source_product_id", "main_img_url", "goods_name", "goods_desc", "cur_price", "org_price", "inventory", "sale_tip", "sell_points", "category_id", "category_name", "ext_img_urls", "shop_name", "qq_mini_program_url", "state", "audit_state", "share", "commission", "update_time", "is_bind", "production_token", "living_stream_state", "wx_mini_program_url", "h5_url", "mini_program_username" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Double.valueOf(0.0D), Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false), "", Integer.valueOf(0), "", "", "" }, GoodsInfo.class);
  public final PBInt32Field audit_state = PBField.initInt32(0);
  public final PBInt32Field category_id = PBField.initInt32(0);
  public final PBStringField category_name = PBField.initString("");
  public final PBInt32Field commission = PBField.initInt32(0);
  public final PBInt32Field cur_price = PBField.initInt32(0);
  public final PBRepeatField<String> ext_img_urls = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField goods_desc = PBField.initString("");
  public final PBStringField goods_id = PBField.initString("");
  public final PBStringField goods_name = PBField.initString("");
  public final PBStringField h5_url = PBField.initString("");
  public final PBInt32Field inventory = PBField.initInt32(0);
  public final PBBoolField is_bind = PBField.initBool(false);
  public final PBInt32Field living_stream_state = PBField.initInt32(0);
  public final PBStringField main_img_url = PBField.initString("");
  public final PBStringField mini_program_username = PBField.initString("");
  public final PBInt32Field org_price = PBField.initInt32(0);
  public final PBStringField production_token = PBField.initString("");
  public final PBStringField qq_mini_program_url = PBField.initString("");
  public final PBStringField sale_tip = PBField.initString("");
  public final PBRepeatField<String> sell_points = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBDoubleField share = PBField.initDouble(0.0D);
  public final PBStringField shop_name = PBField.initString("");
  public final PBInt32Field source = PBField.initInt32(0);
  public final PBStringField source_product_id = PBField.initString("");
  public final PBStringField source_str = PBField.initString("");
  public final PBInt32Field state = PBField.initInt32(0);
  public final PBUInt64Field update_time = PBField.initUInt64(0L);
  public final PBInt32Field ware_house_id = PBField.initInt32(0);
  public final PBStringField wx_mini_program_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.GoodsInfo
 * JD-Core Version:    0.7.0.1
 */