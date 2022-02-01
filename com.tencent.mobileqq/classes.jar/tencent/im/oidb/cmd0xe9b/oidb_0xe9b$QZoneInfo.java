package tencent.im.oidb.cmd0xe9b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xe9b$QZoneInfo
  extends MessageMicro<QZoneInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_space_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_update_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<String> str_newly_img_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_space_name", "bytes_update_content", "str_newly_img_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, "" }, QZoneInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe9b.oidb_0xe9b.QZoneInfo
 * JD-Core Version:    0.7.0.1
 */