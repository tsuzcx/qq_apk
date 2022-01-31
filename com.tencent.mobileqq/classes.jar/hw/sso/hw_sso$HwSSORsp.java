package hw.sso;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hw_sso$HwSSORsp
  extends MessageMicro<HwSSORsp>
{
  public static final int BODY_FIELD_NUMBER = 3;
  public static final int ERR_CODE_FIELD_NUMBER = 1;
  public static final int ERR_MSG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "body" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, HwSSORsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     hw.sso.hw_sso.HwSSORsp
 * JD-Core Version:    0.7.0.1
 */