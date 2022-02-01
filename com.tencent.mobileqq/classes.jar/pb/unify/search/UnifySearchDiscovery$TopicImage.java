package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchDiscovery$TopicImage
  extends MessageMicro<TopicImage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField image_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField image_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_hotsearch = PBField.initUInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "image_url", "image_text", "jump_url", "is_hotsearch" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, TopicImage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     pb.unify.search.UnifySearchDiscovery.TopicImage
 * JD-Core Version:    0.7.0.1
 */