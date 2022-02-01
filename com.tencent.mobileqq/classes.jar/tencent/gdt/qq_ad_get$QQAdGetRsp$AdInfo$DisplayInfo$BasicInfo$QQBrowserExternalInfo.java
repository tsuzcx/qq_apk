package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo$QQBrowserExternalInfo
  extends MessageMicro<QQBrowserExternalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field ad_timeout = PBField.initUInt64(0L);
  public final PBStringField domain = PBField.initString("");
  public final PBStringField floating_red_string = PBField.initString("");
  public final PBUInt32Field pos_pic_h = PBField.initUInt32(0);
  public final PBUInt32Field pos_pic_w = PBField.initUInt32(0);
  public final PBStringField qq_browser_ext = PBField.initString("");
  public final PBStringField trl = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "ad_timeout", "qq_browser_ext", "domain", "trl", "pos_pic_h", "pos_pic_w", "floating_red_string" }, new Object[] { Long.valueOf(0L), "", "", "", localInteger, localInteger, "" }, QQBrowserExternalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.QQBrowserExternalInfo
 * JD-Core Version:    0.7.0.1
 */