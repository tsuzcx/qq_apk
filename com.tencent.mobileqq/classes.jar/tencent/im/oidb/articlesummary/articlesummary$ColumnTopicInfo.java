package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$ColumnTopicInfo
  extends MessageMicro<ColumnTopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_id", "str_title", "str_jump_url" }, new Object[] { Long.valueOf(0L), "", "" }, ColumnTopicInfo.class);
  public final PBStringField str_jump_url = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo
 * JD-Core Version:    0.7.0.1
 */