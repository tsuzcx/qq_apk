package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x8$NearFieldFileStateSync
  extends MessageMicro<NearFieldFileStateSync>
{
  public static final int ETYPE_FIELD_NUMBER = 1;
  public static final int INT32_ERROR_CODE_FIELD_NUMBER = 4;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 3;
  public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField eType = PBField.initEnum(1);
  public final PBInt32Field int32_error_code = PBField.initInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "eType", "uint64_session_id", "uint64_from_uin", "int32_error_code" }, new Object[] { Integer.valueOf(1), localLong, localLong, Integer.valueOf(0) }, NearFieldFileStateSync.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.NearFieldFileStateSync
 * JD-Core Version:    0.7.0.1
 */