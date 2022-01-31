package tencent.im.opengroup;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AppUrlOpenGroup$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_company = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_err_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_info_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uint32_result", "bytes_err_info", "bytes_app_name", "bytes_company", "bytes_share_url", "bytes_info_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.opengroup.AppUrlOpenGroup.RspBody
 * JD-Core Version:    0.7.0.1
 */