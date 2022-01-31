package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class OfflinePkg$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBBytesField str_err_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_expire_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_offline_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_predown_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_predown_pkg_ex = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "int32_ret", "str_err_desc", "str_expire_pkg", "str_predown_pkg", "str_predown_pkg_ex", "str_offline_pkg" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.sso.offlinpkg.OfflinePkg.RspBody
 * JD-Core Version:    0.7.0.1
 */