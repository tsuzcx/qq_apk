package tencent.im.oidb.cmd0x508;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x508$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_update_seq = PBField.initUInt64(0L);
  public final PBRepeatField<Long> rpt_uint64_appid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "opt_uint32_result", "opt_bytes_errinfo", "rpt_uint64_appid_list", "opt_uint64_update_seq" }, new Object[] { Integer.valueOf(0), localByteStringMicro, localLong, localLong }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x508.oidb_0x508.RspBody
 * JD-Core Version:    0.7.0.1
 */