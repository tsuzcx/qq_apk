package tencent.im.oidb.cmd0x877;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x877$InteractInfo
  extends MessageMicro<InteractInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "interact_word", "uint32_interact_count", "uint32_interact_flag", "uint64_interact_info_time" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, InteractInfo.class);
  public oidb_0x877.MsgWord interact_word = new oidb_0x877.MsgWord();
  public final PBUInt32Field uint32_interact_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interact_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_interact_info_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x877.oidb_0x877.InteractInfo
 * JD-Core Version:    0.7.0.1
 */