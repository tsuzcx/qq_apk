package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

public final class AEPbData$FacePose
  extends MessageMicro<FacePose>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 29 }, new String[] { "pitch", "yaw", "roll" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) }, FacePose.class);
  public final PBFloatField pitch = PBField.initFloat(0.0F);
  public final PBFloatField roll = PBField.initFloat(0.0F);
  public final PBFloatField yaw = PBField.initFloat(0.0F);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.FacePose
 * JD-Core Version:    0.7.0.1
 */