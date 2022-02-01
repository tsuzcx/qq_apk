package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FaceSecureCheck$SecureCheckResponse
  extends MessageMicro<SecureCheckResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_sec_pass = PBField.initBool(false);
  public final PBStringField str_err_msg = PBField.initString("");
  public final PBStringField str_openid = PBField.initString("");
  public final PBStringField str_tmpkey = PBField.initString("");
  public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "uint32_errcode", "str_err_msg", "uint32_seq", "bool_sec_pass", "str_openid", "str_tmpkey" }, new Object[] { localInteger, "", localInteger, Boolean.valueOf(false), "", "" }, SecureCheckResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     face.qqlogin.FaceSecureCheck.SecureCheckResponse
 * JD-Core Version:    0.7.0.1
 */