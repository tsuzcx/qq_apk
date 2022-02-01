package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AEPbData$SkeletonItem
  extends MessageMicro<SkeletonItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "name", "scale", "position" }, new Object[] { "", null, null }, SkeletonItem.class);
  public final PBStringField name = PBField.initString("");
  public AEPbData.Point3f position = new AEPbData.Point3f();
  public AEPbData.Point3f scale = new AEPbData.Point3f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.SkeletonItem
 * JD-Core Version:    0.7.0.1
 */