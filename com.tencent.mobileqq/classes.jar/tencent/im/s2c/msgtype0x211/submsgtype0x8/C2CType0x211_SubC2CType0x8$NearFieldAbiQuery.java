package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x8$NearFieldAbiQuery
  extends MessageMicro
{
  public static final int BOOL_NEED_TIPS_FIELD_NUMBER = 3;
  public static final int BYTES_COOKIE_FIELD_NUMBER = 5;
  public static final int BYTES_PEER_EXTRA_FIELD_NUMBER = 8;
  public static final int INT32_PEER_IP_FIELD_NUMBER = 6;
  public static final int INT32_PEER_PORT_FIELD_NUMBER = 7;
  public static final int INT32_TIMEOUT_FIELD_NUMBER = 4;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_TO_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_need_tips = PBField.initBool(false);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_peer_extra = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_peer_ip = PBField.initInt32(0);
  public final PBInt32Field int32_peer_port = PBField.initInt32(0);
  public final PBInt32Field int32_timeout = PBField.initInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "uint64_to_uin", "uint64_from_uin", "bool_need_tips", "int32_timeout", "bytes_cookie", "int32_peer_ip", "int32_peer_port", "bytes_peer_extra" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, NearFieldAbiQuery.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.NearFieldAbiQuery
 * JD-Core Version:    0.7.0.1
 */