package tencent.im.s2c.msgtype0x210.submsgtype0x40;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x40$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int BYTES_VUUID_FIELD_NUMBER = 1;
  public static final int STR_FROMPHONENUM_FIELD_NUMBER = 12;
  public static final int UINT32_OPERTYPE_FIELD_NUMBER = 11;
  public static final int UINT32_STATE_FIELD_NUMBER = 4;
  public static final int UINT64_FROMUIN_FIELD_NUMBER = 2;
  public static final int UINT64_TOUIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_vUuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_fromphonenum = PBField.initString("");
  public final PBUInt32Field uint32_State = PBField.initUInt32(0);
  public final PBUInt32Field uint32_opertype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fromUin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_toUin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 88, 98 }, new String[] { "bytes_vUuid", "uint64_fromUin", "uint64_toUin", "uint32_State", "uint32_opertype", "str_fromphonenum" }, new Object[] { localByteStringMicro, localLong, localLong, localInteger, localInteger, "" }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x40.SubMsgType0x40.MsgBody
 * JD-Core Version:    0.7.0.1
 */