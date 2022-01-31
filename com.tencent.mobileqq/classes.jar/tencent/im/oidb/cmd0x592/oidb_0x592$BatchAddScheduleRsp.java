package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x592$BatchAddScheduleRsp
  extends MessageMicro<BatchAddScheduleRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x592.BatchAddScheduleResult> rpt_msg_result = PBField.initRepeatMessage(oidb_0x592.BatchAddScheduleResult.class);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error_msg", "rpt_msg_result" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, BatchAddScheduleRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.BatchAddScheduleRsp
 * JD-Core Version:    0.7.0.1
 */