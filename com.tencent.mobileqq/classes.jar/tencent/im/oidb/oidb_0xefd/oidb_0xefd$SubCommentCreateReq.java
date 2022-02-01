package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xefd$SubCommentCreateReq
  extends MessageMicro<SubCommentCreateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58, 64, 72, 80, 90, 96, 106, 114, 120, 130, 136, 144, 152, 162, 184, 194, 810 }, new String[] { "article_id", "first_comment_id", "author_id", "src_author_id", "replied_sub_author_id", "replied_sub_comment_id", "content", "is_anonymous", "content_src", "src", "business_info", "create_time", "media_data", "user_info", "is_multi_media", "rpt_media_data_list", "hide_name", "src_uin", "shared_uin", "rowkey", "scene", "link_data", "extra_param" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), null, null, Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), null, "" }, SubCommentCreateReq.class);
  public final PBStringField article_id = PBField.initString("");
  public final PBUInt64Field author_id = PBField.initUInt64(0L);
  public final PBStringField business_info = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field content_src = PBField.initUInt32(0);
  public final PBInt64Field create_time = PBField.initInt64(0L);
  public final PBStringField extra_param = PBField.initString("");
  public final PBStringField first_comment_id = PBField.initString("");
  public final PBInt32Field hide_name = PBField.initInt32(0);
  public final PBUInt32Field is_anonymous = PBField.initUInt32(0);
  public final PBUInt32Field is_multi_media = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xefd.LinkData> link_data = PBField.initRepeatMessage(oidb_0xefd.LinkData.class);
  public oidb_0xefd.MediaData media_data = new oidb_0xefd.MediaData();
  public final PBUInt64Field replied_sub_author_id = PBField.initUInt64(0L);
  public final PBStringField replied_sub_comment_id = PBField.initString("");
  public final PBStringField rowkey = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xefd.MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_0xefd.MediaData.class);
  public final PBUInt32Field scene = PBField.initUInt32(0);
  public final PBUInt32Field shared_uin = PBField.initUInt32(0);
  public final PBUInt32Field src = PBField.initUInt32(0);
  public final PBUInt64Field src_author_id = PBField.initUInt64(0L);
  public final PBUInt64Field src_uin = PBField.initUInt64(0L);
  public oidb_0xefd.UserInfo user_info = new oidb_0xefd.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xefd.oidb_0xefd.SubCommentCreateReq
 * JD-Core Version:    0.7.0.1
 */