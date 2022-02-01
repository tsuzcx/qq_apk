package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AEPbData$ColorItem
  extends MessageMicro<ColorItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "name", "hsv", "rgb" }, new Object[] { "", null, null }, ColorItem.class);
  public AEPbData.Point3f hsv = new AEPbData.Point3f();
  public final PBStringField name = PBField.initString("");
  public AEPbData.Point3f rgb = new AEPbData.Point3f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.ColorItem
 * JD-Core Version:    0.7.0.1
 */