package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class topic_info$TopicInfo
  extends MessageMicro<TopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 104, 120, 130, 138, 144, 152, 160, 170, 176, 184, 192, 200, 208, 216, 242, 248, 256, 264, 274, 280, 288 }, new String[] { "id", "title", "intro", "cover_img", "icon_img", "pendant_img", "type1", "type2", "type3", "create_time", "tags", "source", "status", "ui_type", "cover_color", "video_url", "topic_type", "topic_valid", "creator_uid", "rowkey", "is_default", "is_undistribute", "audit_status", "submit_permission", "last_update_ts", "version", "ext", "super_submit_permission", "is_show_timestamp", "payment_type", "payinfo", "sort_type", "is_high_quality" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Boolean.valueOf(false) }, TopicInfo.class);
  public final PBUInt32Field audit_status = PBField.initUInt32(0);
  public final PBStringField cover_color = PBField.initString("");
  public final PBStringField cover_img = PBField.initString("");
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBUInt64Field creator_uid = PBField.initUInt64(0L);
  public topic_info.TopicInfoExt ext = new topic_info.TopicInfoExt();
  public final PBStringField icon_img = PBField.initString("");
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBStringField intro = PBField.initString("");
  public final PBBoolField is_default = PBField.initBool(false);
  public final PBBoolField is_high_quality = PBField.initBool(false);
  public final PBUInt32Field is_show_timestamp = PBField.initUInt32(0);
  public final PBBoolField is_undistribute = PBField.initBool(false);
  public final PBUInt64Field last_update_ts = PBField.initUInt64(0L);
  public topic_info.PaymentInfo payinfo = new topic_info.PaymentInfo();
  public final PBUInt32Field payment_type = PBField.initUInt32(0);
  public final PBStringField pendant_img = PBField.initString("");
  public final PBStringField rowkey = PBField.initString("");
  public final PBUInt32Field sort_type = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBUInt32Field submit_permission = PBField.initUInt32(0);
  public final PBUInt32Field super_submit_permission = PBField.initUInt32(0);
  public final PBStringField tags = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field topic_type = PBField.initUInt32(0);
  public final PBUInt32Field topic_valid = PBField.initUInt32(0);
  public final PBUInt32Field type1 = PBField.initUInt32(0);
  public final PBUInt32Field type2 = PBField.initUInt32(0);
  public final PBUInt32Field type3 = PBField.initUInt32(0);
  public final PBUInt32Field ui_type = PBField.initUInt32(0);
  public final PBUInt64Field version = PBField.initUInt64(0L);
  public final PBStringField video_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.TopicInfo
 * JD-Core Version:    0.7.0.1
 */