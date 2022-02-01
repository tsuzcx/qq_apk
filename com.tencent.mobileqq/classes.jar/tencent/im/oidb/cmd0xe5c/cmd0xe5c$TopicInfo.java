package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xe5c$TopicInfo
  extends MessageMicro<TopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "icon", "title", "topic_id" }, new Object[] { "", "", "" }, TopicInfo.class);
  public final PBStringField icon = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField topic_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c.TopicInfo
 * JD-Core Version:    0.7.0.1
 */