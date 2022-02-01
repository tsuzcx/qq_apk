package tencent.im.oidb.cmd0x2060;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x2060$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_vote_total", "uint32_vote_yes_num", "uint32_vote_no_num", "uint32_vote_status" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field uint32_vote_no_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vote_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vote_total = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vote_yes_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x2060.oidb_cmd0x2060.RspBody
 * JD-Core Version:    0.7.0.1
 */