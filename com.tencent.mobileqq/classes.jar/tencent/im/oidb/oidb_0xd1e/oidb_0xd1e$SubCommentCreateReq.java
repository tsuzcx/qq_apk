package tencent.im.oidb.oidb_0xd1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd1e$SubCommentCreateReq
  extends MessageMicro<SubCommentCreateReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField article_id = PBField.initString("");
  public final PBUInt64Field author_id = PBField.initUInt64(0L);
  public final PBStringField business_info = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field content_src = PBField.initUInt32(0);
  public final PBInt64Field create_time = PBField.initInt64(0L);
  public final PBUInt32Field detect_dirty_word = PBField.initUInt32(0);
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBInt32Field hide_name = PBField.initInt32(0);
  public final PBUInt32Field is_anonymous = PBField.initUInt32(0);
  public final PBUInt32Field is_multi_media = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xd1e.LinkData> link_data = PBField.initRepeatMessage(oidb_0xd1e.LinkData.class);
  public oidb_0xd1e.MediaData media_data = new oidb_0xd1e.MediaData();
  public final PBUInt64Field replied_sub_author_id = PBField.initUInt64(0L);
  public final PBStringField replied_sub_comment_id = PBField.initString("");
  public final PBStringField rowkey = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xd1e.RptData> rpt_data = PBField.initRepeatMessage(oidb_0xd1e.RptData.class);
  public final PBRepeatMessageField<oidb_0xd1e.MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_0xd1e.MediaData.class);
  public final PBUInt32Field scene = PBField.initUInt32(0);
  public final PBUInt32Field shared_uin = PBField.initUInt32(0);
  public final PBUInt32Field src = PBField.initUInt32(0);
  public final PBUInt64Field src_author_id = PBField.initUInt64(0L);
  public final PBUInt64Field src_uin = PBField.initUInt64(0L);
  public oidb_0xd1e.UserInfo user_info = new oidb_0xd1e.UserInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58, 64, 72, 80, 90, 96, 106, 114, 120, 130, 136, 144, 152, 162, 170, 184, 194, 200 }, new String[] { "article_id", "first_comment_id", "author_id", "src_author_id", "replied_sub_author_id", "replied_sub_comment_id", "content", "is_anonymous", "content_src", "src", "business_info", "create_time", "media_data", "user_info", "is_multi_media", "rpt_media_data_list", "hide_name", "src_uin", "shared_uin", "rowkey", "rpt_data", "scene", "link_data", "detect_dirty_word" }, new Object[] { "", "", localLong, localLong, localLong, "", "", localInteger, localInteger, localInteger, "", localLong, null, null, localInteger, null, localInteger, localLong, localInteger, "", null, localInteger, null, localInteger }, SubCommentCreateReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateReq
 * JD-Core Version:    0.7.0.1
 */