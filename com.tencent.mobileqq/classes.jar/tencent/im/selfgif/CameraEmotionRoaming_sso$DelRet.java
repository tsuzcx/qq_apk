package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class CameraEmotionRoaming_sso$DelRet
  extends MessageMicro<DelRet>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_del_ret = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_del_ret", "bytes_resource_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, DelRet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso.DelRet
 * JD-Core Version:    0.7.0.1
 */