package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "img", "img_s", "txt", "desc" }, new Object[] { "", "", "", "" }, BasicInfo.class);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField img = PBField.initString("");
  public final PBStringField img_s = PBField.initString("");
  public final PBStringField txt = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo
 * JD-Core Version:    0.7.0.1
 */