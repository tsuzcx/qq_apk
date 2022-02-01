package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class AEPbData$FaceInfo
  extends MessageMicro<FaceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 29, 37, 45, 50 }, new String[] { "pos", "rc_face", "rc_leftEye", "rc_rightEye", "rc_mouth", "face_pose" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), null }, FaceInfo.class);
  public AEPbData.FacePose face_pose = new AEPbData.FacePose();
  public final PBRepeatField<Float> pos = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> rc_face = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> rc_leftEye = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> rc_mouth = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> rc_rightEye = PBField.initRepeat(PBFloatField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.FaceInfo
 * JD-Core Version:    0.7.0.1
 */