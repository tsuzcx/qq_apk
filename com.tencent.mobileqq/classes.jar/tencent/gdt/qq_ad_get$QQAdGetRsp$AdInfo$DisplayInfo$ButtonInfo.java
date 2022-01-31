package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$ButtonInfo
  extends MessageMicro<ButtonInfo>
{
  public static final int BUTTON_POS_LEFT_BOTTOM_CORNER = 1;
  public static final int BUTTON_POS_RIGHT_BOTTOM_CORNER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "txt", "url", "pos" }, new Object[] { "", "", Integer.valueOf(1) }, ButtonInfo.class);
  public final PBEnumField pos = PBField.initEnum(1);
  public final PBStringField txt = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo
 * JD-Core Version:    0.7.0.1
 */