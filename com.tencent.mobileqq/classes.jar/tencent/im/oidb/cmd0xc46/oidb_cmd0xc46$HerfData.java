package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xc46$HerfData
  extends MessageMicro<HerfData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "content", "url", "topic_id" }, new Object[] { "", "", "" }, HerfData.class);
  public final PBStringField content = PBField.initString("");
  public final PBStringField topic_id = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.HerfData
 * JD-Core Version:    0.7.0.1
 */