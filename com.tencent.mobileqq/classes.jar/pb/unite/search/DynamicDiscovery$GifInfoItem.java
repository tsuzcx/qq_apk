package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class DynamicDiscovery$GifInfoItem
  extends MessageMicro<GifInfoItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField gif_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField gif_url_night = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "gif_url", "gif_url_night", "gif_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, GifInfoItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pb.unite.search.DynamicDiscovery.GifInfoItem
 * JD-Core Version:    0.7.0.1
 */