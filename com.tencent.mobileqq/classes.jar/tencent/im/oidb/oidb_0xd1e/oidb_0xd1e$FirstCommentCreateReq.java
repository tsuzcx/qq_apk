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

public final class oidb_0xd1e$FirstCommentCreateReq
  extends MessageMicro<FirstCommentCreateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 56, 64, 74, 80, 88, 98, 106, 112, 120, 130, 138, 152, 162, 168 }, new String[] { "article_id", "author_id", "puin", "content", "is_anonymous", "business_info", "create_time", "is_multi_media", "media_data", "content_src", "src", "user_info", "rpt_media_data_list", "hide_name", "src_uin", "rowkey", "rpt_data", "scene", "link_data", "detect_dirty_word" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0), Long.valueOf(0L), "", null, Integer.valueOf(0), null, Integer.valueOf(0) }, FirstCommentCreateReq.class);
  public final PBStringField article_id = PBField.initString("");
  public final PBUInt64Field author_id = PBField.initUInt64(0L);
  public final PBStringField business_info = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field content_src = PBField.initUInt32(0);
  public final PBInt64Field create_time = PBField.initInt64(0L);
  public final PBUInt32Field detect_dirty_word = PBField.initUInt32(0);
  public final PBInt32Field hide_name = PBField.initInt32(0);
  public final PBInt32Field is_anonymous = PBField.initInt32(0);
  public final PBUInt32Field is_multi_media = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xd1e.LinkData> link_data = PBField.initRepeatMessage(oidb_0xd1e.LinkData.class);
  public oidb_0xd1e.MediaData media_data = new oidb_0xd1e.MediaData();
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField rowkey = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xd1e.RptData> rpt_data = PBField.initRepeatMessage(oidb_0xd1e.RptData.class);
  public final PBRepeatMessageField<oidb_0xd1e.MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_0xd1e.MediaData.class);
  public final PBUInt32Field scene = PBField.initUInt32(0);
  public final PBUInt32Field src = PBField.initUInt32(0);
  public final PBUInt64Field src_uin = PBField.initUInt64(0L);
  public oidb_0xd1e.UserInfo user_info = new oidb_0xd1e.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateReq
 * JD-Core Version:    0.7.0.1
 */