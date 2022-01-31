package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceproto$Response
  extends MessageMicro<Response>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "Ret", "ErrMsg", "IDKey", "NeedRetry" }, new Object[] { Integer.valueOf(0), "", "", Boolean.valueOf(false) }, Response.class);
  public final PBStringField ErrMsg = PBField.initString("");
  public final PBStringField IDKey = PBField.initString("");
  public final PBBoolField NeedRetry = PBField.initBool(false);
  public final PBUInt32Field Ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     face.qqlogin.faceproto.Response
 * JD-Core Version:    0.7.0.1
 */