package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

public final class AEImageStylizeReqData$Point
  extends MessageMicro<Point>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21 }, new String[] { "x", "y" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F) }, Point.class);
  public final PBFloatField x = PBField.initFloat(0.0F);
  public final PBFloatField y = PBField.initFloat(0.0F);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.Point
 * JD-Core Version:    0.7.0.1
 */