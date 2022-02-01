package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class topic_info$CooperatorUser
  extends MessageMicro<CooperatorUser>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_head_url", "nick_name", "latest_op_time", "uid" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L) }, CooperatorUser.class);
  public final PBUInt64Field latest_op_time = PBField.initUInt64(0L);
  public final PBStringField nick_name = PBField.initString("");
  public final PBStringField str_head_url = PBField.initString("");
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.CooperatorUser
 * JD-Core Version:    0.7.0.1
 */