package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$CpsRspInfo
  extends MessageMicro<CpsRspInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField apurl = PBField.initString("");
  public final PBUInt64Field catelog_id = PBField.initUInt64(0L);
  public final PBStringField chantag = PBField.initString("");
  public final PBStringField deep_link = PBField.initString("");
  public final PBStringField h5_page = PBField.initString("");
  public final PBRepeatField<String> img_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt64Field product_id = PBField.initUInt64(0L);
  public final PBStringField product_id_str = PBField.initString("");
  public final PBStringField product_name = PBField.initString("");
  public final PBUInt32Field product_original_price = PBField.initUInt32(0);
  public final PBUInt32Field product_price = PBField.initUInt32(0);
  public QqAdGetProtos.QQAdGetRsp.AdInfo.QQAppInfo qq_app_info = new QqAdGetProtos.QQAdGetRsp.AdInfo.QQAppInfo();
  public final PBStringField rl = PBField.initString("");
  public final PBStringField sales_tips = PBField.initString("");
  public final PBUInt32Field source = PBField.initUInt32(0);
  public QqAdGetProtos.QQAdGetRsp.AdInfo.WeChatAppInfo wechat_app_info = new QqAdGetProtos.QQAdGetRsp.AdInfo.WeChatAppInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 88, 98, 106, 112, 122, 8018 }, new String[] { "product_id", "img_list", "product_name", "product_price", "sales_tips", "h5_page", "deep_link", "apurl", "rl", "catelog_id", "source", "wechat_app_info", "qq_app_info", "product_original_price", "chantag", "product_id_str" }, new Object[] { Long.valueOf(0L), "", "", localInteger, "", "", "", "", "", Long.valueOf(0L), localInteger, null, null, localInteger, "", "" }, CpsRspInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.CpsRspInfo
 * JD-Core Version:    0.7.0.1
 */