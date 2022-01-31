package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class faceproto$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "Name", "IDCardNumber" }, new Object[] { "", "" }, UserInfo.class);
  public final PBStringField IDCardNumber = PBField.initString("");
  public final PBStringField Name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     face.qqlogin.faceproto.UserInfo
 * JD-Core Version:    0.7.0.1
 */