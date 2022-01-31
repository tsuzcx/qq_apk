package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_common$Token
  extends MessageMicro
{
  public static final int BUF_FIELD_NUMBER = 1;
  public static final int C2C_TYPE_FIELD_NUMBER = 2;
  public static final int SERVICE_TYPE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field c2c_type = PBField.initUInt32(0);
  public final PBUInt32Field service_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "buf", "c2c_type", "service_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, Token.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_common.Token
 * JD-Core Version:    0.7.0.1
 */