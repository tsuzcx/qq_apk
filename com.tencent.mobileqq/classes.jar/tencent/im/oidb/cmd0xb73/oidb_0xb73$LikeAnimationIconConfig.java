package tencent.im.oidb.cmd0xb73;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0xb73$LikeAnimationIconConfig
  extends MessageMicro<LikeAnimationIconConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_icon_url" }, new Object[] { localByteStringMicro }, LikeAnimationIconConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb73.oidb_0xb73.LikeAnimationIconConfig
 * JD-Core Version:    0.7.0.1
 */