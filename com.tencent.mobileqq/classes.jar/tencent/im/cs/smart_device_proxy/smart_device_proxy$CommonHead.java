package tencent.im.cs.smart_device_proxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class smart_device_proxy$CommonHead
  extends MessageMicro
{
  public static final int BYTES_SN_FIELD_NUMBER = 5;
  public static final int BYTES_TINYIDA2_FIELD_NUMBER = 7;
  public static final int BYTES_UINA2_FIELD_NUMBER = 6;
  public static final int STR_VERSION_FIELD_NUMBER = 8;
  public static final int UINT32_FLAG_FIELD_NUMBER = 10;
  public static final int UINT32_PID_FIELD_NUMBER = 4;
  public static final int UINT32_SEQ_FIELD_NUMBER = 9;
  public static final int UINT32_UIN_FIELD_NUMBER = 1;
  public static final int UINT64_DIN_FIELD_NUMBER = 2;
  public static final int UINT64_TINYID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sn = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tinyidA2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uinA2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_version = PBField.initString("");
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint32_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 72, 80 }, new String[] { "uint32_uin", "uint64_din", "uint64_tinyid", "uint32_pid", "bytes_sn", "bytes_uinA2", "bytes_tinyidA2", "str_version", "uint32_seq", "uint32_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", Integer.valueOf(0), Integer.valueOf(0) }, CommonHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.smart_device_proxy.smart_device_proxy.CommonHead
 * JD-Core Version:    0.7.0.1
 */