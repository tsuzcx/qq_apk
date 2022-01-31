package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DestInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "dest_url_display_type", "landing_page", "canvas_json", "dest_type" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0) }, DestInfo.class);
  public final PBStringField canvas_json = PBField.initString("");
  public final PBUInt32Field dest_type = PBField.initUInt32(0);
  public final PBUInt32Field dest_url_display_type = PBField.initUInt32(0);
  public final PBStringField landing_page = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo
 * JD-Core Version:    0.7.0.1
 */