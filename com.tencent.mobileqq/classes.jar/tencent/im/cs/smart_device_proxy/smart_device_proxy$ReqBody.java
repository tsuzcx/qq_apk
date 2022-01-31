package tencent.im.cs.smart_device_proxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class smart_device_proxy$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int BYTES_BODY_FIELD_NUMBER = 3;
  public static final int INT32_CMD_FIELD_NUMBER = 1;
  public static final int MSG_HEADER_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_cmd = PBField.initInt32(0);
  public smart_device_proxy.CommonHead msg_header = new smart_device_proxy.CommonHead();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_cmd", "msg_header", "bytes_body" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.smart_device_proxy.smart_device_proxy.ReqBody
 * JD-Core Version:    0.7.0.1
 */