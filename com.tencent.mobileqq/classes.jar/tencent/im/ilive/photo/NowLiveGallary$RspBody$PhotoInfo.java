package tencent.im.ilive.photo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowLiveGallary$RspBody$PhotoInfo
  extends MessageMicro<PhotoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  public final PBBytesField video = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "video", "cover", "timestamp" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L) }, PhotoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.ilive.photo.NowLiveGallary.RspBody.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */