package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xe5c$VideoReqBody
  extends MessageMicro<VideoReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rowkey", "url", "topic_id" }, new Object[] { "", "", "" }, VideoReqBody.class);
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField topic_id = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c.VideoReqBody
 * JD-Core Version:    0.7.0.1
 */