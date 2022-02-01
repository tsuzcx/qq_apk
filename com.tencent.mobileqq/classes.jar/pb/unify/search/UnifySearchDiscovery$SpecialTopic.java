package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchDiscovery$SpecialTopic
  extends MessageMicro<SpecialTopic>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_hotsearch = PBField.initUInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField left_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField more_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field show_type = PBField.initUInt32(0);
  public final PBBytesField title_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<UnifySearchDiscovery.TopicImage> topic_images = PBField.initRepeatMessage(UnifySearchDiscovery.TopicImage.class);
  public final PBRepeatMessageField<UnifySearchDiscovery.TopicItem> topic_items = PBField.initRepeatMessage(UnifySearchDiscovery.TopicItem.class);
  public final PBBytesField topic_title = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 74, 80 }, new String[] { "topic_title", "title_color", "icon_url", "topic_items", "jump_url", "show_type", "left_icon_url", "more_text", "topic_images", "is_hotsearch" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, null, Integer.valueOf(0) }, SpecialTopic.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pb.unify.search.UnifySearchDiscovery.SpecialTopic
 * JD-Core Version:    0.7.0.1
 */