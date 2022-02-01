package tencent.im.cs.smart_device_proxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class smart_device_proxy$CgiReq
  extends MessageMicro<CgiReq>
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 3;
  public static final int BYTES_PARAM_FIELD_NUMBER = 2;
  public static final int STR_CGINAME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_param = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_cgiName = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_cgiName", "bytes_param", "bytes_cookie" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2 }, CgiReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.smart_device_proxy.smart_device_proxy.CgiReq
 * JD-Core Version:    0.7.0.1
 */