package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x51b$GetSingleRoamMsgReq
  extends MessageMicro<GetSingleRoamMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17 }, new String[] { "uint64_puin", "fixed64_last_msg_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GetSingleRoamMsgReq.class);
  public final PBFixed64Field fixed64_last_msg_id = PBField.initFixed64(0L);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x51b.GetSingleRoamMsgReq
 * JD-Core Version:    0.7.0.1
 */