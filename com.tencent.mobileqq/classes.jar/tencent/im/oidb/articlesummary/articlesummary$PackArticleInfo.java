package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$PackArticleInfo
  extends MessageMicro<PackArticleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_button_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cell_style_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gw_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_report_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public articlesummary.PackFeedsInfo msg_pack_feeds_info = new articlesummary.PackFeedsInfo();
  public articlesummary.PackQuestionAnswerExtraInfo msg_pack_question_answer_info = new articlesummary.PackQuestionAnswerExtraInfo();
  public articlesummary.PackTopicExtraInfo msg_pack_topic_list_info = new articlesummary.PackTopicExtraInfo();
  public articlesummary.PackVideoInfo msg_pack_video_info = new articlesummary.PackVideoInfo();
  public final PBUInt32Field uint32_is_first_page_use_gif = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_gallery = PBField.initUInt32(0);
  public final PBUInt32Field uint32_picture_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_play_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  
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
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 50, 74, 82, 112, 168, 234, 272, 280, 290, 298, 304, 352, 408, 554, 602, 8010, 8018, 8026, 8034 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_article_content_url", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_algorithm_id", "uint32_strategy_id", "bytes_inner_uniq_id", "uint32_is_gallery", "uint32_picture_number", "bytes_button_wording", "bytes_cell_style_id", "uint32_is_first_page_use_gif", "uint32_video_play_count", "uint32_video_comment_count", "bytes_gw_common_data", "bytes_report_common_data", "msg_pack_feeds_info", "msg_pack_video_info", "msg_pack_topic_list_info", "msg_pack_question_answer_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro10, localByteStringMicro11, null, null, null, null }, PackArticleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.PackArticleInfo
 * JD-Core Version:    0.7.0.1
 */