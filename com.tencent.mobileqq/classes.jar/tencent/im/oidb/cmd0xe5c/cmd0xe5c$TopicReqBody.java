package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xe5c$TopicReqBody
  extends MessageMicro<TopicReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "topic_id", "url" }, new Object[] { "", "" }, TopicReqBody.class);
  public final PBStringField topic_id = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c.TopicReqBody
 * JD-Core Version:    0.7.0.1
 */