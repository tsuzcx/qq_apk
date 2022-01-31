package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$MutiPicTextInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "txt", "image", "url" }, new Object[] { "", "", "" }, MutiPicTextInfo.class);
  public final PBRepeatField image = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField txt = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField url = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo
 * JD-Core Version:    0.7.0.1
 */