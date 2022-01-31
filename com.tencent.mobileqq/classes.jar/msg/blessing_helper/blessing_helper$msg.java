package msg.blessing_helper;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class blessing_helper$msg
  extends MessageMicro<msg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field number = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field time = PBField.initUInt64(0L);
  public final PBUInt32Field touin_count = PBField.initUInt32(0);
  public final PBRepeatField<Long> touin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64 }, new String[] { "version", "result", "uin", "time", "number", "text", "touin_count", "touin_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, msg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msg.blessing_helper.blessing_helper.msg
 * JD-Core Version:    0.7.0.1
 */