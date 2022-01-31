package tencent.im.s2c.msgtype0x210.submsgtype0x41;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MsgType0x210_SubMsgType0x41$UinResult
  extends MessageMicro<UinResult>
{
  public static final int BYTES_NICKNAME_FIELD_NUMBER = 2;
  public static final int STR_SCORE_FIELD_NUMBER = 4;
  public static final int UINT32_GRADE_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_score = PBField.initString("");
  public final PBUInt32Field uint32_grade = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint64_uin", "bytes_nickname", "uint32_grade", "str_score" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), "" }, UinResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x41.MsgType0x210_SubMsgType0x41.UinResult
 * JD-Core Version:    0.7.0.1
 */