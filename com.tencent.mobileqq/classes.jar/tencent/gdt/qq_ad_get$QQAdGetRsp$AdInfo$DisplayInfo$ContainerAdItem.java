package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$ContainerAdItem
  extends MessageMicro<ContainerAdItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "img_url_list", "desc", "dest_url", "rl", "button_txt" }, new Object[] { "", "", "", "", "" }, ContainerAdItem.class);
  public final PBStringField button_txt = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField dest_url = PBField.initString("");
  public final PBRepeatField<String> img_url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField rl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ContainerAdItem
 * JD-Core Version:    0.7.0.1
 */