package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_info$PGCFeedsInfo
  extends MessageMicro<PGCFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pgc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_pgc_feeds_card_type = PBField.initEnum(0);
  public final PBEnumField enum_pgc_feeds_type = PBField.initEnum(0);
  public feeds_info.GalleryPGCFeedsInfo msg_gallery_feeds_info = new feeds_info.GalleryPGCFeedsInfo();
  public final PBRepeatMessageField<feeds_info.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(feeds_info.PGCPicInfo.class);
  public final PBRepeatMessageField<feeds_info.PGCVideoInfo> msg_pgc_video_info_list = PBField.initRepeatMessage(feeds_info.PGCVideoInfo.class);
  public final PBUInt32Field uint32_article_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_follow_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 112, 120, 160, 170 }, new String[] { "enum_pgc_feeds_card_type", "uint64_puin", "uint32_article_type", "msg_pgc_pic_info_list", "msg_pgc_video_info_list", "bytes_pgc_comments", "uint32_myself_follow_status", "uint32_follow_counts", "enum_pgc_feeds_type", "msg_gallery_feeds_info" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, null, null, localByteStringMicro, localInteger, localInteger, localInteger, null }, PGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.PGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */