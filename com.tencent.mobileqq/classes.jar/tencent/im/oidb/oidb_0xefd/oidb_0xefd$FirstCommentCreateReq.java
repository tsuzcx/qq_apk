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

public final class oidb_0xefd$FirstCommentCreateReq
  extends MessageMicro<FirstCommentCreateReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField article_id = PBField.initString("");
  public final PBUInt64Field author_id = PBField.initUInt64(0L);
  public final PBStringField business_info = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field content_src = PBField.initUInt32(0);
  public final PBInt64Field create_time = PBField.initInt64(0L);
  public final PBUInt32Field detect_dirty_word = PBField.initUInt32(0);
  public final PBStringField extra_param = PBField.initString("");
  public final PBInt32Field hide_name = PBField.initInt32(0);
  public final PBInt32Field is_anonymous = PBField.initInt32(0);
  public final PBUInt32Field is_multi_media = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xefd.LinkData> link_data = PBField.initRepeatMessage(oidb_0xefd.LinkData.class);
  public oidb_0xefd.MediaData media_data = new oidb_0xefd.MediaData();
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField rowkey = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xefd.RptData> rpt_data = PBField.initRepeatMessage(oidb_0xefd.RptData.class);
  public final PBRepeatMessageField<oidb_0xefd.MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_0xefd.MediaData.class);
  public final PBUInt32Field scene = PBField.initUInt32(0);
  public final PBUInt32Field src = PBField.initUInt32(0);
  public final PBUInt64Field src_uin = PBField.initUInt64(0L);
  public oidb_0xefd.UserInfo user_info = new oidb_0xefd.UserInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 56, 64, 74, 80, 88, 98, 106, 112, 120, 130, 138, 152, 162, 168, 810 }, new String[] { "article_id", "author_id", "puin", "content", "is_anonymous", "business_info", "create_time", "is_multi_media", "media_data", "content_src", "src", "user_info", "rpt_media_data_list", "hide_name", "src_uin", "rowkey", "rpt_data", "scene", "link_data", "detect_dirty_word", "extra_param" }, new Object[] { "", localLong, localLong, "", localInteger, "", localLong, localInteger, null, localInteger, localInteger, null, null, localInteger, localLong, "", null, localInteger, null, localInteger, "" }, FirstCommentCreateReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xefd.oidb_0xefd.FirstCommentCreateReq
 * JD-Core Version:    0.7.0.1
 */