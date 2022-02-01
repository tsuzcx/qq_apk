package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Appconf$Wording
  extends MessageMicro<Wording>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "serviceType", "Text" }, new Object[] { Integer.valueOf(0), "" }, Wording.class);
  public final PBStringField Text = PBField.initString("");
  public final PBInt32Field serviceType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     face.qqlogin.Appconf.Wording
 * JD-Core Version:    0.7.0.1
 */