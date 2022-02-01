package tencent.im.oidb.cmd0xf34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf34$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_num", "uint32_share_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field uint32_share_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_num = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf34.oidb_cmd0xf34.RspBody
 * JD-Core Version:    0.7.0.1
 */