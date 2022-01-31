package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$CpsRspInfo
  extends MessageMicro<CpsRspInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 96 }, new String[] { "product_id", "img_list", "product_name", "product_price", "sales_tips", "wx_mini_program_path", "qq_mini_program_path", "h5_page", "deep_link", "apurl", "rl", "catelog_id" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), "", "", "", "", "", "", "", Long.valueOf(0L) }, CpsRspInfo.class);
  public final PBStringField apurl = PBField.initString("");
  public final PBUInt64Field catelog_id = PBField.initUInt64(0L);
  public final PBStringField deep_link = PBField.initString("");
  public final PBStringField h5_page = PBField.initString("");
  public final PBRepeatField<String> img_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt64Field product_id = PBField.initUInt64(0L);
  public final PBStringField product_name = PBField.initString("");
  public final PBUInt32Field product_price = PBField.initUInt32(0);
  public final PBStringField qq_mini_program_path = PBField.initString("");
  public final PBStringField rl = PBField.initString("");
  public final PBStringField sales_tips = PBField.initString("");
  public final PBStringField wx_mini_program_path = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.CpsRspInfo
 * JD-Core Version:    0.7.0.1
 */