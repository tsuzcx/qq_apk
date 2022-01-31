package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchDiscovery$TopicItem
  extends MessageMicro<TopicItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField config_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField config_time = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_hotsearch = PBField.initUInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField title_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField trait_title = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "trait_title", "title_color", "config_time", "config_color", "jump_url", "is_hotsearch" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0) }, TopicItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pb.unify.search.UnifySearchDiscovery.TopicItem
 * JD-Core Version:    0.7.0.1
 */