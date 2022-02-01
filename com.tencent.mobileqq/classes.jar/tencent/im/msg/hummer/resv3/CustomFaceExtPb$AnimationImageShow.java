package tencent.im.msg.hummer.resv3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class CustomFaceExtPb$AnimationImageShow
  extends MessageMicro<AnimationImageShow>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_animation_param = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_effect_id = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_effect_id", "bytes_animation_param" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, AnimationImageShow.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.resv3.CustomFaceExtPb.AnimationImageShow
 * JD-Core Version:    0.7.0.1
 */