package tencent.im.oidb.cmd0xe27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xe27$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_test_keep_silence_sec" }, new Object[] { Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field uint32_test_keep_silence_sec = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.RspBody
 * JD-Core Version:    0.7.0.1
 */