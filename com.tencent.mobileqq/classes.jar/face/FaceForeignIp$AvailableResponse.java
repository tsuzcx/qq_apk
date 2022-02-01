package face;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FaceForeignIp$AvailableResponse
  extends MessageMicro<AvailableResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "msg" }, new Object[] { Integer.valueOf(0), "" }, AvailableResponse.class);
  public final PBStringField msg = PBField.initString("");
  public final PBEnumField ret = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     face.FaceForeignIp.AvailableResponse
 * JD-Core Version:    0.7.0.1
 */