package tencent.im.oidb.cmd0xb9b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb9b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint64_uin", "uint32_match_op", "enum_matchopretcode", "msg_match_info", "uint32_match_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, RspBody.class);
  public final PBEnumField enum_matchopretcode = PBField.initEnum(0);
  public oidb_0xb9b.MatchInfo msg_match_info = new oidb_0xb9b.MatchInfo();
  public final PBUInt32Field uint32_match_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_match_op = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb9b.oidb_0xb9b.RspBody
 * JD-Core Version:    0.7.0.1
 */