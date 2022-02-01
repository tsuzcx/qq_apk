package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0xe5$MsgBody$S2CCcAgentActionResultPush
  extends MessageMicro<S2CCcAgentActionResultPush>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_target_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_callid = PBField.initString("");
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_target_kfext = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56 }, new String[] { "uint32_type", "str_callid", "uint32_result", "uint32_timestamp", "uint32_status", "bytes_target_name", "uint64_target_kfext" }, new Object[] { localInteger, "", localInteger, localInteger, localInteger, localByteStringMicro, Long.valueOf(0L) }, S2CCcAgentActionResultPush.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CCcAgentActionResultPush
 * JD-Core Version:    0.7.0.1
 */