package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

public final class AEPbData$Point3f
  extends MessageMicro<Point3f>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 29 }, new String[] { "x", "y", "z" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) }, Point3f.class);
  public final PBFloatField x = PBField.initFloat(0.0F);
  public final PBFloatField y = PBField.initFloat(0.0F);
  public final PBFloatField z = PBField.initFloat(0.0F);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.Point3f
 * JD-Core Version:    0.7.0.1
 */