package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Appconf$ServiceProtocol
  extends MessageMicro<ServiceProtocol>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "name", "url" }, new Object[] { "", "" }, ServiceProtocol.class);
  public final PBStringField name = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     face.qqlogin.Appconf.ServiceProtocol
 * JD-Core Version:    0.7.0.1
 */