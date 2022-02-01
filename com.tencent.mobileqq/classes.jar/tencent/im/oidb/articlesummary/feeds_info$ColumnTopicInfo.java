package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_info$ColumnTopicInfo
  extends MessageMicro<ColumnTopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_id", "str_title" }, new Object[] { Integer.valueOf(0), "" }, ColumnTopicInfo.class);
  public final PBStringField str_title = PBField.initString("");
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.ColumnTopicInfo
 * JD-Core Version:    0.7.0.1
 */