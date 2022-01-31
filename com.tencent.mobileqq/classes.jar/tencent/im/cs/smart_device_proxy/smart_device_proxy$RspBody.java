package tencent.im.cs.smart_device_proxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class smart_device_proxy$RspBody
  extends MessageMicro<RspBody>
{
  public static final int BYTES_INFO_FIELD_NUMBER = 3;
  public static final int INT32_CMD_FIELD_NUMBER = 1;
  public static final int INT32_ERRORCODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_cmd = PBField.initInt32(0);
  public final PBInt32Field int32_errorCode = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_cmd", "int32_errorCode", "bytes_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.smart_device_proxy.smart_device_proxy.RspBody
 * JD-Core Version:    0.7.0.1
 */