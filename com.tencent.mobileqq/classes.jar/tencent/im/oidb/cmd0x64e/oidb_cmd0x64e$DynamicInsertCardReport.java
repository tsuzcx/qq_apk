package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x64e$DynamicInsertCardReport
  extends MessageMicro<DynamicInsertCardReport>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field action_type = PBField.initUInt32(0);
  public final PBRepeatField<ByteStringMicro> id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field progress = PBField.initUInt32(0);
  public final PBBytesField seq_no = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field watch_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "uin", "seq_no", "action_type", "progress", "watch_time", "id" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, DynamicInsertCardReport.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.DynamicInsertCardReport
 * JD-Core Version:    0.7.0.1
 */