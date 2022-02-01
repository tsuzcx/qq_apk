package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class OlympicTorchSvc$SceneWording
  extends MessageMicro<SceneWording>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_line1", "str_line2", "str_link_word", "str_link_url" }, new Object[] { "", "", "", "" }, SceneWording.class);
  public final PBStringField str_line1 = PBField.initString("");
  public final PBStringField str_line2 = PBField.initString("");
  public final PBStringField str_link_url = PBField.initString("");
  public final PBStringField str_link_word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.olympic.OlympicTorchSvc.SceneWording
 * JD-Core Version:    0.7.0.1
 */