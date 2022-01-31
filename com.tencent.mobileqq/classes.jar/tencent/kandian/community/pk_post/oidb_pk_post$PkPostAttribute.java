package tencent.kandian.community.pk_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x2060.oidb_cmd0x2060.RspBody;

public final class oidb_pk_post$PkPostAttribute
  extends MessageMicro<PkPostAttribute>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66, 74, 82, 90, 170 }, new String[] { "string_post_id", "string_title", "string_content", "uint64_ts", "uint64_start_ts", "uint64_end_ts", "uint32_post_type", "string_source", "side_A", "side_B", "string_type", "msg_statistics_info" }, new Object[] { "", "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", null, null, "", null }, PkPostAttribute.class);
  public oidb_cmd0x2060.RspBody msg_statistics_info = new oidb_cmd0x2060.RspBody();
  public oidb_pk_post.Side side_A = new oidb_pk_post.Side();
  public oidb_pk_post.Side side_B = new oidb_pk_post.Side();
  public final PBStringField string_content = PBField.initString("");
  public final PBStringField string_post_id = PBField.initString("");
  public final PBStringField string_source = PBField.initString("");
  public final PBStringField string_title = PBField.initString("");
  public final PBStringField string_type = PBField.initString("");
  public final PBUInt32Field uint32_post_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_end_ts = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_ts = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.kandian.community.pk_post.oidb_pk_post.PkPostAttribute
 * JD-Core Version:    0.7.0.1
 */