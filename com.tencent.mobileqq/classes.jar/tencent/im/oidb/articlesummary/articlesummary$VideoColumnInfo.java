package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$VideoColumnInfo
  extends MessageMicro<VideoColumnInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public articlesummary.UrlJumpInfo app_jump_info = new articlesummary.UrlJumpInfo();
  public final PBBytesField bytes_app_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_card_bg_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_card_bg_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_card_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_name_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_from_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public articlesummary.UrlJumpInfo default_jump_info = new articlesummary.UrlJumpInfo();
  public final PBRepeatMessageField<articlesummary.SubVideoInfo> rpt_sub_video_info = PBField.initRepeatMessage(articlesummary.SubVideoInfo.class);
  public articlesummary.UrlJumpInfo subscribe_jump_info = new articlesummary.UrlJumpInfo();
  public final PBUInt32Field uin32_column_card_bg_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subscribe_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_last_update_time = PBField.initUInt64(0L);
  public articlesummary.UrlJumpInfo video_jump_info = new articlesummary.UrlJumpInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 90, 98, 106, 114, 122, 130, 136, 146, 154, 160, 170, 178 }, new String[] { "uint32_column_id", "bytes_column_name", "bytes_column_icon_url", "uint64_last_update_time", "uint32_video_count", "uint32_subscribe_count", "uint32_is_subscribed", "bytes_column_card_bg_url", "bytes_column_card_bg_color", "bytes_column_card_icon_url", "bytes_app_name", "bytes_app_icon_url", "default_jump_info", "video_jump_info", "subscribe_jump_info", "app_jump_info", "uin32_column_card_bg_style", "rpt_sub_video_info", "bytes_sub_title", "uint32_update_count", "bytes_from_txt", "bytes_column_name_color" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, null, null, null, null, Integer.valueOf(0), null, localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, localByteStringMicro10 }, VideoColumnInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */