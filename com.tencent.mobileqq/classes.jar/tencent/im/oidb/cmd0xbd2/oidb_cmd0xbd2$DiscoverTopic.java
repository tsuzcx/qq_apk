package tencent.im.oidb.cmd0xbd2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbd2$DiscoverTopic
  extends MessageMicro<DiscoverTopic>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subtitle = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xbd2.DiscoverTopicVideoCard> rpt_video_card_list = PBField.initRepeatMessage(oidb_cmd0xbd2.DiscoverTopicVideoCard.class);
  public final PBUInt32Field uint32_effective_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expiation_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_has_recomment = PBField.initUInt32(0);
  public final PBBytesField uint64_play_count = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 72, 82, 162 }, new String[] { "uint64_topic_id", "bytes_title", "bytes_cover_url", "bytes_subtitle", "uint64_play_count", "bytes_url", "uint32_has_recomment", "uint32_effective_time", "uint32_expiation_time", "bytes_common_data", "rpt_video_card_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, null }, DiscoverTopic.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd2.oidb_cmd0xbd2.DiscoverTopic
 * JD-Core Version:    0.7.0.1
 */