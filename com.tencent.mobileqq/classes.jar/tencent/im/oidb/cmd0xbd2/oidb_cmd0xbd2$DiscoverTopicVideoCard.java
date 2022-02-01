package tencent.im.oidb.cmd0xbd2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.UGCVideoInfo;

public final class oidb_cmd0xbd2$DiscoverTopicVideoCard
  extends MessageMicro<DiscoverTopicVideoCard>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_corner_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sort_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField feeds_type = PBField.initEnum(0);
  public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<feeds_info.UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(feeds_info.UGCVideoInfo.class);
  public final PBUInt32Field uint32_is_ugc = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 64, 74, 82, 90, 98, 104, 114, 120, 130, 136, 146 }, new String[] { "bytes_corner_icon_url", "bytes_cover_url", "uint64_feeds_id", "feeds_type", "bytes_rowkey", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_article_content_url", "uint64_time", "json_video_list", "uint32_is_ugc", "msg_ugc_video_info_list", "uint64_cuin", "bytes_sort_data" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localLong, localInteger, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localLong, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localLong, localByteStringMicro10, localInteger, null, localLong, localByteStringMicro11 }, DiscoverTopicVideoCard.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd2.oidb_cmd0xbd2.DiscoverTopicVideoCard
 * JD-Core Version:    0.7.0.1
 */