package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CameraEmotionRoaming_sso$UploadImgInfo
  extends MessageMicro<UploadImgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_img_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_img_other = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_img_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_img_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_img_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "bytes_img_md5", "uint32_img_width", "uint32_img_height", "uint64_img_size", "bytes_img_other" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2 }, UploadImgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso.UploadImgInfo
 * JD-Core Version:    0.7.0.1
 */