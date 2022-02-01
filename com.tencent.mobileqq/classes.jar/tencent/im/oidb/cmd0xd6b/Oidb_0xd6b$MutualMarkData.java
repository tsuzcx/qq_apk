package tencent.im.oidb.cmd0xd6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.mutualmark.mutualmark.MutualMark;

public final class Oidb_0xd6b$MutualMarkData
  extends MessageMicro<MutualMarkData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90 }, new String[] { "uint64_frd_uin", "uint32_result", "uint32_is_gray_for_chat_move", "mutualmark_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, MutualMarkData.class);
  public final PBRepeatMessageField<mutualmark.MutualMark> mutualmark_info = PBField.initRepeatMessage(mutualmark.MutualMark.class);
  public final PBUInt32Field uint32_is_gray_for_chat_move = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.MutualMarkData
 * JD-Core Version:    0.7.0.1
 */