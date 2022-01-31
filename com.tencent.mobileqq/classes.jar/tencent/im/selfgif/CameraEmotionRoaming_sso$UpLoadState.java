package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class CameraEmotionRoaming_sso$UpLoadState
  extends MessageMicro<UpLoadState>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_other = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> bytes_text = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBInt32Field int32_upload_state = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "int32_upload_state", "bytes_resource_id", "bytes_text", "bytes_pic_version", "bytes_other" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, UpLoadState.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadState
 * JD-Core Version:    0.7.0.1
 */