package tencent.im.oidb.cmd0xf8b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xf8b$TweetInfo
  extends MessageMicro<TweetInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0xf8b.BiuMultiLevel biu_multi_level = new oidb_cmd0xf8b.BiuMultiLevel();
  public final PBBytesField bytes_position = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xf8b.Picture> pictures = PBField.initRepeatMessage(oidb_cmd0xf8b.Picture.class);
  public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "biu_multi_level", "pictures", "bytes_position", "text" }, new Object[] { null, null, localByteStringMicro1, localByteStringMicro2 }, TweetInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.TweetInfo
 * JD-Core Version:    0.7.0.1
 */