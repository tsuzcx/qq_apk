package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_common$DeviceExt$IosQaidInfo
  extends MessageMicro<IosQaidInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "st", "cy", "la", "dn_h", "ma", "pm", "hd", "sut", "dm", "tz" }, new Object[] { "", "", "", "", "", "", "", "", "", "" }, IosQaidInfo.class);
  public final PBStringField cy = PBField.initString("");
  public final PBStringField dm = PBField.initString("");
  public final PBStringField dn_h = PBField.initString("");
  public final PBStringField hd = PBField.initString("");
  public final PBStringField la = PBField.initString("");
  public final PBStringField ma = PBField.initString("");
  public final PBStringField pm = PBField.initString("");
  public final PBStringField st = PBField.initString("");
  public final PBStringField sut = PBField.initString("");
  public final PBStringField tz = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt.IosQaidInfo
 * JD-Core Version:    0.7.0.1
 */