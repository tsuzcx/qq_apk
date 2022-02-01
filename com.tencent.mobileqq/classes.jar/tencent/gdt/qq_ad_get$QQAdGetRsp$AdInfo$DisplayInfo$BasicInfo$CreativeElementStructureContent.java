package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo$CreativeElementStructureContent
  extends MessageMicro<CreativeElementStructureContent>
{
  public static final int LABEL_DIRECTION_LEFT = 1;
  public static final int LABEL_DIRECTION_RIGHT = 2;
  public static final int LABEL_DIRECTION_UNKONWN = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "label" }, new Object[] { null }, CreativeElementStructureContent.class);
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> label = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent
 * JD-Core Version:    0.7.0.1
 */