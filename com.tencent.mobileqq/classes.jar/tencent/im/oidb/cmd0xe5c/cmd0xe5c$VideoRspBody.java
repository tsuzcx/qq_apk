package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xe5c$VideoRspBody
  extends MessageMicro<VideoRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "url", "watch_word", "is_open" }, new Object[] { "", "", Boolean.valueOf(false) }, VideoRspBody.class);
  public final PBBoolField is_open = PBField.initBool(false);
  public final PBStringField url = PBField.initString("");
  public final PBStringField watch_word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c.VideoRspBody
 * JD-Core Version:    0.7.0.1
 */