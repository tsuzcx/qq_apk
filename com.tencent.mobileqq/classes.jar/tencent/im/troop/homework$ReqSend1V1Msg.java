package tencent.im.troop;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class homework$ReqSend1V1Msg
  extends MessageMicro<ReqSend1V1Msg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBInt32Field int32_time_zone = PBField.initInt32(0);
  public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> to_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "text", "group_id", "to_uins", "int32_time_zone" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, ReqSend1V1Msg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.troop.homework.ReqSend1V1Msg
 * JD-Core Version:    0.7.0.1
 */